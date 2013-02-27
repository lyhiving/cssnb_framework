/**
 * 
 */
package com.cssnb.nbzj.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.cssnb.commons.utils.CssStringUtils;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-5-21上午9:19:14
 * 类说明：
 * 
 */
@Repository
public class CommonDAO extends SqlSessionDaoSupport{

	public List<Map<String, Object>> getTableList(String tableName) {
		System.out.println("gettablelist now");
		String tblName = CssStringUtils.toCamelString(tableName);
		return this.getSqlSession().selectList("Common.get"+tblName+"List");
	}
	
	public  Map<String, Object> getTableMap(String tableName,String key){
		String tblName = CssStringUtils.toCamelString(tableName);
		return this.getSqlSession().selectMap("Common.get"+tblName+"List", key);
	}
}
