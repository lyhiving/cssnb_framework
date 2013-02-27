/**
 * 
 */
package com.cssnb.nbzj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cssnb.commons.domain.Page;
import com.cssnb.commons.domain.PageRequest;
import com.cssnb.nbzj.dao.YyginfoDAO;
import com.cssnb.nbzj.dao.YyginfoMapper;
import com.cssnb.nbzj.entity.Yyginfo;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-5-28下午2:59:22
 * 类说明：
 * 
 */
@Service
public class YgManager {

	@Autowired
	private YyginfoMapper yyginfoMapper;
	@Autowired
	private YyginfoDAO yyginfoDAO;
	
//	@Autowired
//	private YyginfoDAO yyginfoDAO;
	
	public List<Map<String,Object>> getYyginfoList(){
		return yyginfoMapper.getYyginfoList();
	}

	public Page<Yyginfo> findAll(PageRequest pageRequest) {
		return yyginfoMapper.getYyginfoList(pageRequest);
	}
	
	public Page<Yyginfo> findByPage(PageRequest pageRequest) {
		//return yyginfoMapper.listPage(pageRequest.getFilters(),pageRequest);
		return yyginfoDAO.findByPageRequest(pageRequest);
	}
}
