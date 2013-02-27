/*
 * Copyright 2008-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cssnb.commons.domain;

import java.io.Serializable;
import java.util.Map;

import com.cssnb.commons.domain.Sort.Direction;

/**
 * Basic Java Bean implementation of {@code Pageable}.
 *
 * @author Oliver Gierke
 */
public class PageRequest implements Pageable, Serializable {

	private static final long serialVersionUID = 8280485938848398236L;
	public static final int PAGE_SIZE = 10;
	
	private final int page;	//当前页号
	private final int size;	//每页条数
	private final Sort sort;
	private final Map<String,Object> filters;


	


	/**
	 * Creates a new {@link PageRequest}. Pages are zero indexed, thus providing
	 * 0 for {@code page} will return the first page.
	 *
	 * @param size
	 * @param page
	 */
	public PageRequest(int page, int size) {

		this(page, size, null);
	}


	/**
	 * Creates a new {@link PageRequest} with sort parameters applied.
	 *
	 * @param page
	 * @param size
	 * @param direction
	 * @param properties
	 */
	public PageRequest(int page, int size, Direction direction,
										 String... properties) {

		this(page, size, new Sort(direction, properties));
	}


	/**
	 * Creates a new {@link PageRequest} with sort parameters applied.
	 *
	 * @param page
	 * @param size
	 * @param sort
	 */
	public PageRequest(int page, int size, Sort sort) {

		this(page,size,sort,null);
	}
	
	public PageRequest(int page, int size, Sort sort, Map<String,Object> filters) {

		if (0 > page) {
			throw new IllegalArgumentException(
					"Page index must not be less than zero!");
		}

		if (0 >= size) {
			throw new IllegalArgumentException(
					"Page size must not be less than or equal to zero!");
		}

		this.page = page;
		this.size = size;
		this.sort = sort;
		this.filters = filters;
	}


	/*
			 * (non-Javadoc)
			 *
			 * @see org.springframework.data.domain.Pageable#getPageSize()
			 */
	public int getPageSize() {

		return size;
	}


	/*
			 * (non-Javadoc)
			 *
			 * @see org.springframework.data.domain.Pageable#getPageNumber()
			 */
	public int getPageNumber() {

		return page;
	}


	/*
			 * (non-Javadoc)
			 *
			 * @see org.springframework.data.domain.Pageable#getFirstItem()
			 */
	public int getOffset() {

		return (page-1) * size;
	}


	/*
			 * (non-Javadoc)
			 *
			 * @see org.springframework.data.domain.Pageable#getSort()
			 */
	public Sort getSort() {

		return sort;
	}


	public Map<String,Object> getFilters() {
		return filters;
	}
	
	public Object getFilter(String key){
		return filters.get(key);
	}
	/*
			 * (non-Javadoc)
			 *
			 * @see java.lang.Object#equals(java.lang.Object)
			 */
	@Override
	public boolean equals(final Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PageRequest)) {
			return false;
		}

		PageRequest that = (PageRequest) obj;

		boolean pageEqual = this.page == that.page;
		boolean sizeEqual = this.size == that.size;

		boolean sortEqual =
				this.sort == null ? that.sort == null : this.sort
						.equals(that.sort);

		return pageEqual && sizeEqual && sortEqual;
	}


	/*
			 * (non-Javadoc)
			 *
			 * @see java.lang.Object#hashCode()
			 */
	@Override
	public int hashCode() {

		int result = 17;

		result = 31 * result + page;
		result = 31 * result + size;
		result = 31 * result + (null == sort ? 0 : sort.hashCode());

		return result;
	}
}
