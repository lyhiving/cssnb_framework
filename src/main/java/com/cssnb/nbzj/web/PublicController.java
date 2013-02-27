/**
 * 
 */
package com.cssnb.nbzj.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-7-10上午10:27:32
 * 类说明：
 * 
 */
@RequestMapping("/public")
@Controller
public class PublicController {

	private static final Logger logger = LoggerFactory.getLogger(PublicController.class);
	
	@RequestMapping(value="/download/{file}")
	public String download(@PathVariable("file") String file ) {
		logger.info("you clicked to download: "+file);
		return "";
	}
	
}
