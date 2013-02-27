package com.cssnb.nbzj.entity;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.cssnb.commons.utils.Collections3;
import com.google.common.collect.Lists;

/**
 * 用户.
 * 
 * @author calvin
 */
public class User extends IdEntity {

	private String loginName;
	private String password;//为简化演示使用明文保存的密码
	private String name;
	private String email;
	private List<Role> roleList = Lists.newArrayList();//有序的关联对象集合

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoleList() {
		return roleList;
	}
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	/**
	 * 用户拥有的权限组名称字符串, 多个权限组名称用','分隔.
	 */
	public String getRoleNames() {
		return Collections3.extractToString(roleList, "name", ", ");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}