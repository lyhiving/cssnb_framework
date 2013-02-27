/**
 * 
 */
package com.cssnb.nbzj.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cssnb.nbzj.service.CommonManager;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-5-16上午6:45:58
 * 类说明：
 * 测试用
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	private CommonManager commonManager;
	
	@RequestMapping(method = RequestMethod.GET, value = { "","/", "/index" })
	 public String home(Model model) {
		 logger.info("Welcome demo! ");
		 model.addAttribute("tblrights", commonManager.getDataList("tbl_right"));
		 logger.info("method finish");
		 return "demo";
	 }
	
	@RequestMapping(method = RequestMethod.GET, value = "/test1")
	public String test1(@RequestParam(value="id",required=false) String id, Model model) {
		 logger.info("Welcome test! ");
		 model.addAttribute("tblrights", commonManager.getDataList("tbl_right"));
		 model.addAttribute("id",id);
		 logger.info("param:{}",id);
		 model.addAttribute("param2","param222");
		 logger.info("method finish");
		 return "test1";
	 }
	
	
}
