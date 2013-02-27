/**
 * 
 */
package com.cssnb.nbzj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cssnb.nbzj.dao.CommonDAO;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-5-21上午7:29:23
 * 类说明：公共服务类，提供全局的代码表，缓存
 * 
 */
@Service
public class CommonManager {

	@Autowired
	private CommonDAO commonDAO;
	
	@Cacheable(value = "dataCache")
	public List<Map<String,Object>> getDataList(String tableName){
		return commonDAO.getTableList(tableName);
	}
	
	@Cacheable(value = "dataCache",key="#tableName.#key")
	public Map<String,Object> getDataMap(String tableName,String key){
		return commonDAO.getTableMap(tableName, key);
	}
}
