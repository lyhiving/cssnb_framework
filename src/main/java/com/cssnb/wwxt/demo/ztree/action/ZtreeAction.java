/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.wwxt.demo.ztree.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.cssnb.commons.utils.ParameterMap;
import com.cssnb.wwxt.demo.ztree.service.ZtreeService;

/**
 * @Company: 中国软件与技术服务股份有限公司宁波分公司
 * @Author(svn): 卜繁晟
 * @Created Date: 2013-1-29
 */
@Controller
@RequestMapping("/ztree")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ZtreeAction {

	@Autowired
	ZtreeService ztreeService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response){
		return "demo/ztree/index";
	}
	@RequestMapping("/index_lazy")
	public String index_lazy(HttpServletRequest request, HttpServletResponse response){
		return "demo/ztree/index_lazy";
	}
	/**
	 * 查询模块列表
	 * @作者: 卜繁晟
	 * @创时: 2013-1-31 上午11:44:44
	 */
	@RequestMapping("/getQxList")
	public String getQxList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List qxList = ztreeService.getTreeList();
		response.setContentType("text/javascript;charset=utf-8");
		response.getWriter().print(JSON.toJSONString(qxList));
		return null;
	}
	/**
	 * 查询模块列表（根据第一层）
	 * @作者: 卜繁晟
	 * @创时: 2013-1-31 上午11:44:32
	 */
	@RequestMapping("/getTreeListFirst")
	public String getTreeListFirst(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map pMap = ParameterMap.getParameterMap(request);
		if(pMap.get("NODE") == null){
			pMap.put("PID", "000");
		}else{
			pMap.put("PID", pMap.get("NODE"));
		}
		List qxList = ztreeService.getTreeListFirst(pMap);
		response.setContentType("text/javascript;charset=utf-8");
		response.getWriter().print(JSON.toJSONString(qxList));
		return null;
	}
	/**
	 * 根据父级查找子级树列表
	 * @作者: 卜繁晟
	 * @创时: 2013-3-29 上午11:17:59
	 */
	@RequestMapping("/getTreeListByPID")
	public String getTreeListByPID(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map pMap = ParameterMap.getParameterMap(request, true);
		List qxList = ztreeService.getTreeListByPID(pMap);
		response.setContentType("text/javascript;charset=utf-8");
		response.getWriter().print(JSON.toJSONString(qxList));
		return null;
	}
}