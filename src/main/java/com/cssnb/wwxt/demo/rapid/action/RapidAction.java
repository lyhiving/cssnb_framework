/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.wwxt.demo.rapid.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Company: 中国软件与技术服务股份有限公司宁波分公司
 * @Author(svn): 卜繁晟
 * @Created Date: 2013-1-29
 */
@Controller
@RequestMapping("/rapid")
public class RapidAction {

	@RequestMapping(method = RequestMethod.GET, value = { "", "/", "/base" })
	public String index(HttpServletRequest request, HttpServletResponse response){
		return "demo/rapid/base";
	}
	@RequestMapping(method = RequestMethod.GET, value = { "/{name}" })
	public String pageName(@PathVariable(value = "name") String name, HttpServletRequest request, HttpServletResponse response){
		return "demo/rapid/" + name;
	}
}