/**
 * 
 */
package com.cssnb.commons.cache;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-5-20下午9:02:56
 * 类说明：
 * 
 */
public class CacheLoader {

	private static Logger logger = LoggerFactory.getLogger(CacheLoader.class);
	
	private JdbcTemplate jt;
	
	public void setDataSource(DataSource dataSource) {
		jt = new JdbcTemplate(dataSource);
	}
	public void init(){
		logger.info("server start to load data...");
		loadData();
	}

	//@Cacheable(value = { "cachedata" })
	private void loadData() {
		// TODO Auto-generated method stub
		System.out.println("ffff");
		
		
	}
	
	

}
