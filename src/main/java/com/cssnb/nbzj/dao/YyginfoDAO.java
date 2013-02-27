/**
 * 
 */
package com.cssnb.nbzj.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.cssnb.commons.dao.MybatisDAO;
import com.cssnb.commons.domain.Page;
import com.cssnb.commons.domain.PageRequest;
import com.cssnb.nbzj.entity.Yyginfo;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-6-5下午2:08:36
 * 类说明：
 * 
 */
@Repository
public class YyginfoDAO extends MybatisDAO<Yyginfo, java.lang.Integer> {

	@Override
	public Class<Yyginfo> getEntityClass() {
		return Yyginfo.class;
	}
	
	public void saveOrUpdate(Yyginfo entity) {
		if(entity.getYginfoId() == null) 
			insert(entity);
		else 
			update(entity);
	}
	
	public Page<Yyginfo> findByPageRequest(PageRequest param) {
		 int count =  (Integer)getSqlSession().selectOne("com.cssnb.nbzj.dao.YyginfoMapper.count",param.getFilters()); 
	        
	        Page<Yyginfo> result = new Page<Yyginfo>(param,count);   
	        if (count > 0) {   
	            List<Yyginfo> data = getSqlSession().selectList("com.cssnb.nbzj.dao.YyginfoMapper.getYyginfoList", param.getFilters(),new RowBounds(param.getOffset(), param.getPageSize()));  
	            result.setResult(data);
	        }   
	        return result;   
	}
}
