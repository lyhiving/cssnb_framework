/**
 * 
 */
package com.cssnb.nbzj.web;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cssnb.nbzj.service.AccountManager;
import com.cssnb.nbzj.service.CommonManager;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-5-11 类说明： 处理首页的请求
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private AccountManager accountManager;

	@Autowired
	private CommonManager commonManager;

	@RequestMapping(method = RequestMethod.GET, value = { "/", "/index" })
	public String home(HttpSession sesison) {
		logger.info("Welcome home! ");

		Subject currentUser = SecurityUtils.getSubject();
		String username = currentUser.getPrincipal().toString();
		
		logger.info("" + currentUser.isAuthenticated());
		logger.info("username:" + username);
		return "home";
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/sidebar/{rightId}" })
	public String sidebar(@PathVariable(value = "rightId") String rightId,Model model) {
		logger.info("Welcome sidebar! ");
		logger.info("I got the rightId:{}",rightId);
		
		final Subject currentUser = SecurityUtils.getSubject();
		final String right_id = rightId;
		List<Map<String, Object>> rightList = commonManager.getDataList("tbl_right");
		//Map<String,Object> rightMap = commonManager.getDataMap("tbl_right", "right_id");
		
		//final Right rightInfo = (Right)rightMap.get(rightId);

		Collection<Map<String, Object>> newrightList = Collections2.filter(rightList, new Predicate<Map<String, Object>>() {
			@Override
			public boolean apply(Map<String, Object> map) {
				String key = (String)map.get("right_key");
				String parentId = map.get("right_parentid").toString();
				return parentId.equals(right_id)&&currentUser.isPermitted(key);
			}
		});
		
		
		//model.addAttribute("rightInfo", rightMap.get(""));
		model.addAttribute("rightList", newrightList);
		logger.info("finished call method sidebar");
		return "common/sidebar";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/main")
	public String main(
			@RequestParam(value = "right_id", required = false) String right_id,
			 Model model) {
		logger.info("Welcome main! ");
		//model.addAttribute("tblrights", commonManager.getDataList("tbl_right"));
		model.addAttribute("rightId", right_id);
		logger.info("param:{}", right_id);
		logger.info("method main finish");
		return "common/mainframe";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/default")
	public String defaultPage(
			@RequestParam(value = "right_id", required = false) String right_id,
			 Model model) {
		logger.info("Welcome main! ");
		//model.addAttribute("tblrights", commonManager.getDataList("tbl_right"));
		model.addAttribute("rightId", right_id);
		logger.info("param:{}", right_id);
		logger.info("method main finish");
		return "default";
	}

	/**
	 * Hard coded test against the default user that comes with the Schema.
	 */
	@RequestMapping(value = "/smoketest", method = RequestMethod.GET)
	public String smoketest(Model model) {
		// String salted = this.identityService.getApplicationSalt();
		// logger.info("SALT = " + salted);
		// String userid = "TestUser";
		// String passphrase = "TestUserPassword";
		// UsernamePasswordToken token = new UsernamePasswordToken(userid,
		// passphrase);
		// Subject currentUser = SecurityUtils.getSubject();
		//
		// try {
		// currentUser.login(token);
		// logger.info("AUTH SUCCESS");
		// } catch (AuthenticationException ae) {
		// logger.info("AUTH MSSG: " + ae.getMessage());
		// }
		//
		// Identity thisIdentity = null;
		// if (currentUser.isAuthenticated()) {
		// logger.info("PRINCIPAL: " + currentUser.getPrincipal());
		// thisIdentity =
		// identityService.getIdentity(currentUser.getPrincipal().toString());
		// salted =
		// this.identityService.getCombinedSalt(thisIdentity.getSalt());
		// logger.info("COMBINED SALT = " + salted);
		// }
		// model.addAttribute("identity", thisIdentity);
		return "smoketest/smoke";
	}
}
