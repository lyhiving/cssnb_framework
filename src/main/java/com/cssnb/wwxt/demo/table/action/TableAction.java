/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.wwxt.demo.table.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cssnb.commons.domain.PageImpl;
import com.cssnb.commons.utils.ParameterMap;
import com.cssnb.wwxt.demo.table.service.TableService;

/**
 * @Company: 中国软件与技术服务股份有限公司宁波分公司
 * @Author(svn): 卜繁晟
 * @Created Date: 2013-1-29
 */
@Controller
@RequestMapping("/demo/table")
@SuppressWarnings("rawtypes")
public class TableAction {

	@Autowired
	TableService tableService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response){
		Map pMap = ParameterMap.getParameterMap(request, false);
		PageImpl<Map> pi = new PageImpl<Map>();
		List moduleList = tableService.getModuleList(pMap);
		request.setAttribute("moduleList", moduleList);
		return "demo/table/index";
	}
}