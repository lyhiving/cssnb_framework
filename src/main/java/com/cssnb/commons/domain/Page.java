package com.cssnb.commons.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 分页信息
 */
public class Page<T> implements Serializable,Iterable<T>
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected List<T> result;

	protected int pageSize;			//每页条数

	protected int pageNumber;		//当前页数,从1开始

	protected int totalElements = 0;	//总的数据条目数量，0表示没有数据
		
	protected int totalPages = 0;	//总页数
	
	public Page(){
		this.result = new ArrayList<T>();
	}
	public Page(PageRequest p, int totalCount) {
		this(p.getPageNumber(),p.getPageSize(),totalCount);
	}
	
	public Page(int pageNumber,int pageSize,int totalCount) {
		this(pageNumber,pageSize,totalCount,new ArrayList<T>());
	}
	
	public Page(int pageNumber,int pageSize,int totalCount,List<T> result) {
		if(pageSize <= 0) throw new IllegalArgumentException("[pageSize] must great than zero");
		this.pageSize = pageSize;
		this.totalElements = totalCount;
		this.totalPages = pageSize == 0 ? 0 : (int) Math.ceil((double) totalElements / (double) pageSize);
		this.pageNumber = pageNumber;
		setResult(result);
	}

	public void setResult(List<T> elements) {
		if(elements == null) throw new IllegalArgumentException("'result' must be not null");
		this.result = elements;
	}
	
    /**
     * 当前页包含的数据
     *
     * @return 当前页数据源
     */
	public List<T> getResult() {
		return result;
	}
	
    /**
     * 是否是首页（第一页），第一页页码为1
     *
     * @return 首页标识
     */
	public boolean isFirstPage() {
		return getThisPageNumber() == 1;
	}

    /**
     * 是否是最后一页
     *
     * @return 末页标识
     */
	public boolean isLastPage() {
		return getThisPageNumber() >= getLastPageNumber();
	}
    /**
     * 是否有下一页
     *
     * @return 下一页标识
     */
	public boolean isHasNextPage() {
		return getLastPageNumber() > getThisPageNumber();
	}
    /**
     * 是否有上一页
     *
     * @return 上一页标识
     */
	public boolean isHasPreviousPage() {
		return getThisPageNumber() > 1;
	}
    /**
     * 获取最后一页页码，也就是总页数
     *
     * @return 最后一页页码
     */
	public int getLastPageNumber() {
		return totalPages;
	}
    /**
     * 总的数据条目数量，0表示没有数据
     *
     * @return 总数量
     */
	public int getTotalElements() {
		return totalElements;
	}
	
	/**
     * 获取总页数
     *
     * @return 总页数
     */
	public int getTotalPages(){
		return totalPages;
	}
    /**
     * 获取当前页的首条数据的行编码
     *
     * @return 当前页的首条数据的行编码
     */
	public int getThisPageFirstElementNumber() {
		return (getThisPageNumber() - 1) * getPageSize() + 1;
	}
    /**
     * 获取当前页的末条数据的行编码
     *
     * @return 当前页的末条数据的行编码
     */
	public int getThisPageLastElementNumber() {
		int fullPage = getThisPageFirstElementNumber() + getPageSize() - 1;
		return getTotalElements() < fullPage ? getTotalElements() : fullPage;
	}
    /**
     * 获取下一页编码
     *
     * @return 下一页编码
     */
	public int getNextPageNumber() {
		return getThisPageNumber() + 1;
	}
    /**
     * 获取上一页编码
     *
     * @return 上一页编码
     */
	public int getPreviousPageNumber() {
		return getThisPageNumber() - 1;
	}
    /**
     * 每一页显示的条目数
     *
     * @return 每一页显示的条目数
     */
	public int getPageSize() {
		return pageSize;
	}
    /**
     * 当前页的页码
     *
     * @return 当前页的页码
     */
	public int getThisPageNumber() {
		return pageNumber;
	}

	/**
	 * 得到数据库的第一条记录号
	 * @return
	 */
	public int getFirstResult() {
		return (pageNumber - 1) * pageSize;
	}
	
    /**
     * 得到用于多页跳转的页码
     * @return
     */
	public static List<Integer> getLinkPageNumbers(int currentPageNumber,int lastPageNumber) {
		return getLinkPageNumbers(currentPageNumber,lastPageNumber,10);
	}

    /**
     * 得到用于多页跳转的页码
     * @return
     */
	public static List<Integer> getLinkPageNumbers(int currentPageNumber,int lastPageNumber,int count) {
		int avg = count / 2;
		
		int startPageNumber = currentPageNumber - avg;
		if(startPageNumber <= 0) {
			startPageNumber = 1;
		}
		
		int endPageNumber = startPageNumber + count - 1;
		if(endPageNumber > lastPageNumber) {
			endPageNumber = lastPageNumber;
		}
		
		if(endPageNumber - startPageNumber < count) {
			startPageNumber = endPageNumber - count;
			if(startPageNumber <= 0 ) {
				startPageNumber = 1;
			}
		}
		
		java.util.List<Integer> result = new ArrayList<Integer>();
		for(int i = startPageNumber; i <= endPageNumber; i++) {
			result.add(new Integer(i));
		}
		return result;
	}
	


    @SuppressWarnings("unchecked")
	public Iterator<T> iterator() {
        return result == null ? Collections.EMPTY_LIST.iterator(): result.iterator();
    }
    
    public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setTotalCount(int totalCount) {
		this.totalElements = totalCount;
	}
}

