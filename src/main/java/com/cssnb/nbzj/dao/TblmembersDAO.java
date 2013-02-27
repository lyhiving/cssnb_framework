package com.cssnb.nbzj.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.cssnb.commons.dao.MybatisDAO;
import com.cssnb.commons.domain.Page;
import com.cssnb.commons.domain.PageRequest;
import com.cssnb.nbzj.entity.Tblmembers;
@Repository
public class TblmembersDAO extends MybatisDAO<Tblmembers, java.lang.Integer> {
	public Page<Tblmembers> findByPageRequest(PageRequest param) {
		 int count =  (Integer)getSqlSession().selectOne("com.cssnb.nbzj.dao.TblmembersMapper.count"); 
	        
	        Page<Tblmembers> result = new Page<Tblmembers>(param,count);   
	        if (count > 0) {   
	            List<Tblmembers> data = getSqlSession().selectList("com.cssnb.nbzj.dao.TblmembersMapper.selectAll",new RowBounds(param.getOffset(), param.getPageSize()));  
	            result.setResult(data);
	        }
	        System.out.println(result.getResult().size());
	        return result;   
	}

	@Override
	public Class<Tblmembers> getEntityClass() {
		return Tblmembers.class;
	}
}
