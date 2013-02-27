package com.cssnb.nbzj.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 角色.
 * 
 * @author calvin
 */
public class Role extends IdEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
