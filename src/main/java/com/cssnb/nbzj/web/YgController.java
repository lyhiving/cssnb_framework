/**
 * 
 */
package com.cssnb.nbzj.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.cssnb.commons.domain.JqgridPage;
import com.cssnb.commons.domain.JqgridResponse;
import com.cssnb.commons.domain.Page;
import com.cssnb.commons.domain.PageRequest;
import com.cssnb.nbzj.entity.Yyginfo;
import com.cssnb.nbzj.service.YgManager;
import com.cssnb.nbzj.utils.PageRequestUtils;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-5-28下午2:57:27
 * 类说明：
 * 
 */
/**
 * Urls:
 * List   page        : GET  /account/user/
 * Create page        : GET  /account/user/create
 * Create action      : POST /account/user/save
 * Update page        : GET  /account/user/update/{id}
 * Update action      : POST /account/user/save/{id}
 * Delete action      : POST /account/user/delete/{id}
 * CheckLoginName ajax: GET  /account/user/checkLoginName?oldLoginName=a&loginName=b
 * 
 */
@RequestMapping("/yfive/yg")
@Controller
public class YgController {

	private static final Logger logger = LoggerFactory.getLogger(YgController.class);
    
	@Autowired
	private YgManager ygManager;
	
	@RequestMapping(value = { "list", "" })
	public String list(Model model) {
		logger.info("Welcome yg list! ");

		List<Map<String,Object>> yglist = ygManager.getYyginfoList();
		
		model.addAttribute("yglist", yglist);
		
		return "yfive/yglist";
	}
	
	@RequestMapping(value="ygindex")
	public String ygindex() {
		logger.info("Welcome yg index! ");
		return "yfive/yglist2";
	}
	
	@RequestMapping(value="list2")
	public @ResponseBody JqgridResponse<Yyginfo> jqlist(WebRequest request,JqgridPage jqpage,  Model model) {
		logger.info("Welcome yg list2! ");
		//PageRequest pageRequest = PageRequestUtils.newJqgridPageRequest(jqpage);
		PageRequest pageRequest = PageRequestUtils.newPageRequest(request,jqpage);
		
		Page<Yyginfo> ygPage = ygManager.findByPage(pageRequest);
		
		JqgridResponse<Yyginfo> response = new JqgridResponse<Yyginfo>();
		response.setRows(ygPage.getResult());
		response.setPage(Integer.valueOf(ygPage.getPageNumber()).toString());
		response.setRecords(Long.valueOf(ygPage.getTotalElements()).toString());
		response.setTotal(Integer.valueOf(ygPage.getTotalPages()).toString());
		
		return response;
	}
}
