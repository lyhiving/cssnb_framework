/**
 * 
 */
package com.cssnb.nbzj.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.context.request.WebRequest;

import com.cssnb.commons.domain.JqgridPage;
import com.cssnb.commons.domain.PageRequest;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-5-29下午2:57:36
 * 类说明：
 * 
 */
public class PageRequestUtils {

	public static PageRequest newJqgridPageRequest(JqgridPage page){
		return new PageRequest(page.getPage(),page.getRows());
	}

	public static PageRequest newPageRequest(WebRequest request) {
		
		return newPageRequest(request,"jqgrid");
	}
	
	public static PageRequest newPageRequest(WebRequest request,String type) {
		
		return null;
	}

	public static PageRequest newPageRequest(WebRequest request,
			JqgridPage page) {
		Map<String,Object> filters = getFilterMap(request);
		PageRequest pageRequest = new PageRequest(page.getPage()==null?1:page.getPage(),page.getRows()==null?PageRequest.PAGE_SIZE:page.getRows(),null,filters);
		return pageRequest;
	}
	
	public static Map<String,Object> getFilterMap(WebRequest request){
		Map<String,Object> filterMap=new HashMap<String,Object>();
		Iterator<String> iter = request.getParameterNames();
		while (iter.hasNext()) { 
			String key = iter.next();
			Object val = request.getParameter(key);
			filterMap.put(key, val);
		} 
		return filterMap;
	}
}
