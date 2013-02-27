/**
 * 
 */
package com.cssnb.commons.domain;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-5-29下午3:07:44 
 * 类说明：
 * 
 */
public class JqgridPage {

	private boolean _search;
	private String filters;
	private Integer page;
	private Integer rows; //
	private String sidx; // sort fields
	private String sord; // sort order

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

}
