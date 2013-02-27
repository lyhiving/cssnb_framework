package com.cssnb.commons.mybatis;

import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import com.cssnb.commons.domain.Page;

@Intercepts({ @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class }) })
public class ResultSetInterceptor implements Interceptor {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object intercept(Invocation invocation) throws Throwable {
		Object obj = invocation.proceed();

		Page p = PageInterceptor.getPage();
		if (p != null) {
			p.setResult((List) obj);
			return p;
		}

		return obj;
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
	}
}