package com.cssnb.commons.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.cssnb.commons.domain.Page;
import com.cssnb.commons.domain.PageRequest;

@Repository
public abstract class MybatisDAO<T, ID extends Serializable> extends
		SqlSessionDaoSupport implements BaseDAO<T, ID> {

	// sqlmap.xml定义文件中对应的sqlid
	public static final String SQLID_INSERT = "insert";
	public static final String SQLID_UPDATE = "update";
	public static final String SQLID_UPDATE_PARAM = "updateParam";
	public static final String SQLID_DELETE = "delete";
	public static final String SQLID_DELETE_PARAM = "deleteParam";
	public static final String SQLID_TRUNCATE = "truncate";
	public static final String SQLID_SELECT = "select";
	public static final String SQLID_SELECT_PK = "selectPk";
	public static final String SQLID_SELECT_PARAM = "selectParam";
	public static final String SQLID_SELECT_FK = "selectFk";
	public static final String SQLID_COUNT = "count";
	public static final String SQLID_COUNT_PARAM = "countParam";

	@Override
	public void insert(T entity){
		getSqlSession().insert(getInsertQuery(), entity);
	}

	@Override
	public int update(T entity) {
		return getSqlSession().update(getUpdateQuery(),entity);
	}

	@Override
	public int update(PageRequest param) {
		return getSqlSession().update(getUpdateQuery(),param);
	}

	@Override
	public int delete(ID id) {
		return getSqlSession().delete(getDeleteQuery(), id);
	}

	@Override
	public int delete(PageRequest param) {
		return getSqlSession().delete(getDeleteQuery()+"."+SQLID_DELETE_PARAM, param);
	}

	@Override
	public int truncate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int count() {
		return (Integer)getSqlSession().selectOne(getCountQuery());
	}

	@Override
	public int count(PageRequest param) {
		return (Integer)getSqlSession().selectOne(getCountQuery(),param.getFilters());
	}

	@Override
	public T get(ID primaryKey) {
		return (T)getSqlSession().selectOne(getFindByPrimaryKeyQuery(),primaryKey);
	}

	@Override
	public List<T> select() {
		return getSqlSession().selectList(getListQuery());   
	}

	@Override
	public List<T> select(PageRequest param) {
		return getSqlSession().selectList(getListQuery(), param);   
	}

	@Override
	public Page<T> selectPagination(PageRequest param) {
		
		
        int count = count(param);   
        
        Page<T> result = new Page<T>(param,count);   
        if (count > 0) {   
            List<T> data = getSqlSession().selectList(getListPageQuery(), param.getFilters(),new RowBounds(param.getOffset(), param.getPageSize()));  
            result.setResult(data);
        }   
        return result;   
	}

	@Override
	public List<T> selectFk(PageRequest param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<T> selectFkPagination(PageRequest param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void batchInsert(List<T> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void batchUpdate(List<T> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void batchDelete(List<ID> list) {
		// TODO Auto-generated method stub

	}
	
	public abstract Class<T> getEntityClass();

	public String getFindByPrimaryKeyQuery() {
        return getEntityClass().getSimpleName()+".getById";
    }
	
	public String getInsertQuery() {
        return getEntityClass().getSimpleName()+".insert";
    }

    public String getUpdateQuery() {
    	return getEntityClass().getSimpleName()+".update";
    }

    public String getDeleteQuery() {
    	return getEntityClass().getSimpleName()+".delete";
    }

    public String getCountQuery() {
		return getEntityClass().getSimpleName() +".count";
	}
    
    public String getListQuery() {
		return getEntityClass().getSimpleName() +".list";
	}
    
    public String getListPageQuery() {
		return getEntityClass().getSimpleName() +".listPage";
	}
}
