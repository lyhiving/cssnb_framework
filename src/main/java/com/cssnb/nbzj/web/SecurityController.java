/**
 * 
 */
package com.cssnb.nbzj.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cssnb.commons.shiro.MyFormAuthentication;

/**
 * SecurityController负责页面登录、登出
 * 
 * @author xuning
 *
 */
@Controller
public class SecurityController {

	private static Logger logger = LoggerFactory.getLogger(SecurityController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String tologin() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String fail(@RequestParam(MyFormAuthentication.DEFAULT_USERNAME_PARAM) String userName,Model model) {
		logger.info("you login failed");
		model.addAttribute(MyFormAuthentication.DEFAULT_USERNAME_PARAM, userName);
		return "login";
	}
	
}
