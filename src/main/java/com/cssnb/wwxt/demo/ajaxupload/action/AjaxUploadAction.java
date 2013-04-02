/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.wwxt.demo.ajaxupload.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cssnb.commons.utils.ParameterMap;
import com.cssnb.wwxt.demo.ajaxupload.service.AjaxUploadService;
import com.cssnb.wwxt.demo.ajaxupload.utils.UploadUtils;

/**
 * @Company: 中国软件与技术服务股份有限公司宁波分公司
 * @Author(svn): 卜繁晟
 * @Created Date: 2013-1-29
 */
@Controller
@RequestMapping("/ajaxUpload")
@SuppressWarnings({ "rawtypes", "unused" })
public class AjaxUploadAction {

	@Autowired
	AjaxUploadService ajaxUploadService;

	@RequestMapping(method = RequestMethod.GET, value = { "", "/", "/index" })
	public String index(HttpServletRequest request, HttpServletResponse response){
		return "demo/ajaxUpload/index";
	}
	@RequestMapping(method = RequestMethod.POST, value = { "", "/", "/index" })
	public String recieve(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map pMap = ParameterMap.getParameterMap(request);
		UploadUtils uu = new UploadUtils();
		List fileList = uu.upload(request);
		response.getWriter().print("{\"success\": true, \"reason\": \"上传完了\"}");
		return null;
	}
}