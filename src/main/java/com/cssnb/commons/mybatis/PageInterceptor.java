/**
 * 
 */
package com.cssnb.commons.mybatis;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.builder.xml.dynamic.ForEachSqlNode;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cssnb.commons.dialect.Dialect;
import com.cssnb.commons.dialect.DialectFactory;
import com.cssnb.commons.domain.Page;
import com.cssnb.commons.domain.PageRequest;


/**
 * @author xuning
 *
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
@SuppressWarnings("rawtypes")
public class PageInterceptor implements Interceptor{

	protected static Logger log = LoggerFactory.getLogger(PageInterceptor.class);
	
	private static final ThreadLocal<Page> PAGE_CONTEXT = new ThreadLocal<Page>();
	
	
	private Dialect dialect;	//数据库方言
	private String pageSqlId;	//mapper.xml中需要拦截的ID(正则匹配)
	
	public Object intercept(Invocation invocation) throws Throwable {
		
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler);
		
		
		MappedStatement mappedStatement = (MappedStatement)metaStatementHandler.getValue("delegate.mappedStatement");
		
		if(!mappedStatement.getId().matches(pageSqlId)){ //拦截需要分页的SQL
			return invocation.proceed();
		}
		
		//采用mapper时，不用这个得到分页参数
		//RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
		
		//if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {  // 只对不为DEFAULT的RowBounds做拦截
		//	return invocation.proceed();
		//}
		
		
		
		
		BoundSql boundSql = statementHandler.getBoundSql();
		
		Object param = boundSql.getParameterObject();//分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空
		
		if (param instanceof HashMap) {
			HashMap map = (HashMap) param;
			PageRequest pr = (PageRequest) map.get("page");
		
		//if(parameterObject==null){
		//	throw new NullPointerException("parameterObject尚未实例化！");
		//}else{
			String originalSql = boundSql.getSql();
			//String countSql = "select count(0) from (" + originalSql+ ") as tmp_count"; //记录统计
			int count = queryTotal(invocation,mappedStatement,boundSql,param,originalSql);
			int offset = pr.getOffset();
			int limit = pr.getPageSize();
			
			Page p = new Page(pr,count);
			set(p);
			
			if(dialect.supportsLimit()){
				String sql = originalSql;
				if(dialect.supportsLimitOffset()){
					sql = dialect.getLimitString(originalSql, offset,limit);
					offset = RowBounds.NO_ROW_OFFSET;
				}else{
					sql = dialect.getLimitString(originalSql, 0, limit);
				}
				limit = RowBounds.NO_ROW_LIMIT;
				metaStatementHandler.setValue("delegate.boundSql.sql", sql);
				metaStatementHandler.setValue("delegate.rowBounds.offset",offset);
				metaStatementHandler.setValue("delegate.rowBounds.limit",limit);
			}

	        boundSql = statementHandler.getBoundSql();  
	        log.info("生成分页SQL : " + boundSql.getSql());  
		//}
		}
		return invocation.proceed();
	}

	/**
	 * <p>
	 * 查询总数
	 * </p>
	 * 
	 * @param ivk
	 * @param ms
	 * @param boundSql
	 * @param param
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	private int queryTotal(Invocation ivk, MappedStatement ms, BoundSql boundSql,
			Object param,String sql) throws SQLException {
		Connection conn = (Connection) ivk.getArgs()[0];
		String countSql = "select count(0) from (" + sql + ") tmp_count";
		BoundSql bs = new BoundSql(ms.getConfiguration(), countSql,
				boundSql.getParameterMappings(), param);

		ResultSet rs = null;
		PreparedStatement stmt = null;

		int count = 0;
		try {
			stmt = conn.prepareStatement(countSql);
			setParameters(stmt, ms, bs, param);
			rs = stmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} finally {
			rs.close();
			stmt.close();
		}
		return count;
	}
	
	/**
	 * 为count语句设置参数.
	 * 
	 * @see org.apache.ibatis.executor.parameter.DefaultParameterHandler#setParameters(PreparedStatement)
	 * 
	 * @param ps
	 * @param ms
	 * @param bs
	 * @param parameterObject
	 * @throws SQLException
	 */
	private void setParameters(PreparedStatement ps, MappedStatement ms,
			BoundSql bs, Object parameterObject) throws SQLException {
		ErrorContext.instance().activity("setting parameters").object(ms.getParameterMap().getId());
		List<ParameterMapping> mappings = bs.getParameterMappings();
		if (mappings == null) {
			return;
		}
		Configuration configuration = ms.getConfiguration();
		TypeHandlerRegistry typeHandlerRegistry = configuration
				.getTypeHandlerRegistry();
		MetaObject metaObject = parameterObject == null ? null : configuration
				.newMetaObject(parameterObject);
		for (int i = 0; i < mappings.size(); i++) {
			ParameterMapping parameterMapping = mappings.get(i);
			if (parameterMapping.getMode() != ParameterMode.OUT) {
				Object value;
				String propertyName = parameterMapping.getProperty();
				PropertyTokenizer prop = new PropertyTokenizer(propertyName);
				if (parameterObject == null) {
					value = null;
				} else if (typeHandlerRegistry.hasTypeHandler(parameterObject
						.getClass())) {
					value = parameterObject;
				} else if (bs.hasAdditionalParameter(propertyName)) {
					value = bs.getAdditionalParameter(propertyName);
				} else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)
						&& bs.hasAdditionalParameter(prop.getName())) {
					value = bs.getAdditionalParameter(prop.getName());
					if (value != null) {
						value = configuration.newMetaObject(value)
								.getValue(
										propertyName.substring(prop.getName()
												.length()));
					}
				} else {
					value = metaObject == null ? null : metaObject
							.getValue(propertyName);
				}
				TypeHandler typeHandler = parameterMapping.getTypeHandler();
				if (typeHandler == null) {
					throw new ExecutorException(
							"There was no TypeHandler found for parameter "
									+ propertyName + " of statement "
									+ ms.getId());
				}
				typeHandler.setParameter(ps, i + 1, value,
						parameterMapping.getJdbcType());
			}
		}
	}
	/**
	 * 
	 * <p>
	 * {@link ResultSetInterceptor}获取一次即清空
	 * </p>
	 * 
	 * @return
	 */
	public static Page getPage() {
		Page p = PAGE_CONTEXT.get();
		PAGE_CONTEXT.remove();
		return p;
	}

	/**
	 * 
	 * <p>
	 * 保存在ThreadLocal中，使 {@link ResultSetInterceptor}能获取到此page对象
	 * </p>
	 * 
	 * @param p
	 */
	private static void set(Page p) {
		PAGE_CONTEXT.set(p);
	}
	
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		dialect = DialectFactory.getDialect(properties.getProperty("dialect"));
		pageSqlId = properties.getProperty("pageSqlId");
		if (pageSqlId==null||"".equals(pageSqlId)) {
			pageSqlId = ".*page.";
		}
	}

}
