/**
 * 
 */
package com.cssnb.nbzj.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cssnb.nbzj.entity.User;

/**
 * 安全相关实体的管理类,包括用户和权限组.
 * @author Administrator
 *
 */
@Service
@Transactional(readOnly=true)	////默认将类中的所有public函数纳入事务管理.
public class AccountManager {

	private static Logger logger = LoggerFactory.getLogger(AccountManager.class);

	@Cacheable(value = { "user" })
	public User findUserByLoginName(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
