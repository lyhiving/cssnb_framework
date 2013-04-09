/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.wwxt.wiki.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.cssnb.commons.utils.CharsetUtils;
import com.cssnb.commons.utils.ParameterMap;
import com.cssnb.wwxt.wiki.service.WikiService;

/**
 * @Company: 中国软件与技术服务股份有限公司宁波分公司
 * @Author(svn): 卜繁晟
 * @Created Date: 2013-1-29
 */
@Controller
@RequestMapping("/wiki")
@SuppressWarnings({ "rawtypes" })
public class WikiAction {

	@Autowired
	WikiService wikiService;

	/**
	 * 首页
	 * @作者: 卜繁晟
	 * @创时: 2013-2-2 下午9:36:07
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "", "/", "/index" })
	public String index(HttpServletRequest request, HttpServletResponse response){
		Map docMap = wikiService.getDocIndex();
		Subject currentUser = SecurityUtils.getSubject();
		String username = currentUser.getPrincipal().toString();
		request.setAttribute("docMap", docMap);
		request.setAttribute("username", username);
		request.setAttribute("dirId", request.getParameter("dirId"));
		return "wiki/index";
	}
	/**
	 * 查询目录列表
	 * @作者: 卜繁晟
	 * @创时: 2013-2-2 下午9:35:59
	 */
	@RequestMapping("/getDirList")
	public String getDirList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List dirList = wikiService.getDirList();
		response.setContentType("text/javascript;charset=utf-8");
		response.getWriter().print(JSON.toJSONString(CharsetUtils.getEncodingList(dirList, "ISO-8859-1", "GBK")));
		return null;
	}
	/**
	 * 根据目录ID查询文档内容
	 * @作者: 卜繁晟
	 * @创时: 2013-2-4 下午2:47:59
	 */
	@RequestMapping("/getDocByDirId")
	public String getDocByDirId(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map pMap = ParameterMap.getParameterMap(request, false);
		Subject currentUser = SecurityUtils.getSubject();
		String username = currentUser.getPrincipal().toString();
		Map docMap = wikiService.getDocByDirId(pMap);
		request.setAttribute("docMap", CharsetUtils.getEncodingMap(docMap, "ISO-8859-1", "GBK"));
		request.setAttribute("dirId", pMap.get("dirId"));
		request.setAttribute("username", username);
		return "wiki/index";
	}
	/**
	 * 添加文档页面跳转
	 * @作者: 卜繁晟
	 * @创时: 2013-2-2 下午9:36:25
	 */
	@RequestMapping("/newDoc")
	public String newDoc(HttpServletRequest request, HttpServletResponse response){
		Map pMap = ParameterMap.getParameterMap(request, true);
		List dirList = wikiService.getDirList();
		Map docMap = wikiService.getDocByDirId(pMap);
		request.setAttribute("dirList", CharsetUtils.getEncodingList(dirList, "ISO-8859-1", "GBK"));
		if(docMap != null && docMap.get("Content") != null){
			docMap.put("Content", htmlspecialchars(docMap.get("Content").toString()));
		}
		request.setAttribute("docMap", CharsetUtils.getEncodingMap(docMap, "ISO-8859-1", "GBK"));
		request.setAttribute("pMap", pMap);
		return "wiki/newDoc";
	}
	/**
	 * 特殊符号转HTML实体符号
	 * @作者: 卜繁晟
	 * @创时: 2013-2-20 上午9:25:02
	 */
	private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
	/**
	 * 添加文档数据
	 * @作者: 卜繁晟
	 * @创时: 2013-2-2 下午9:36:39
	 */
	@RequestMapping("/addNewDoc")
	public String addNewDoc(HttpServletRequest request, HttpServletResponse response){
		Map pMap = ParameterMap.getParameterMap(request, true);
		int res = wikiService.addDoc(pMap);
		request.setAttribute("res", res);
		request.setAttribute("dirId", pMap.get("dirId"));
		return "wiki/result";
	}
	/**
	 * 更新文档数据
	 * @作者: 卜繁晟
	 * @创时: 2013-2-4 下午3:14:47
	 */
	@RequestMapping("/updNewDoc")
	public String updNewDoc(HttpServletRequest request, HttpServletResponse response){
		Map pMap = ParameterMap.getParameterMap(request, true);
		int res = wikiService.updDoc(pMap);
		request.setAttribute("res", res);
		request.setAttribute("dirId", pMap.get("dirId"));
		return "wiki/result";
	}
	/**
	 * 目录管理
	 * @作者: 卜繁晟
	 * @创时: 2013-2-6 下午2:40:53
	 */
	@RequestMapping("/directory")
	public String directory(HttpServletRequest request, HttpServletResponse response){
		List dirList = wikiService.getDirList();
		Subject currentUser = SecurityUtils.getSubject();
		String username = currentUser.getPrincipal().toString();
		request.setAttribute("dirList", CharsetUtils.getEncodingList(dirList, "ISO-8859-1", "GBK"));
		request.setAttribute("from", request.getParameter("from"));
		request.setAttribute("username", username);
		return "wiki/directory";
	}

	/**
	 * 添加目录
	 * @作者: 卜繁晟
	 * @创时: 2013-2-7 下午2:35:03
	 */
	@RequestMapping("/addDir")
	public String addDir(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map pMap = ParameterMap.getParameterMap(request, true);
		int result = wikiService.addDir(pMap);
		response.setContentType("text/javascript;charset=utf-8");
		response.getWriter().print(result);
		return null;
	}
	/**
	 * 删除目录
	 * @作者: 卜繁晟
	 * @创时: 2013-2-7 下午2:35:03
	 */
	@RequestMapping("/delDirById")
	public String delDirById(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map pMap = ParameterMap.getParameterMap(request, true);
		int result = wikiService.delDirById(pMap);
		response.setContentType("text/javascript;charset=utf-8");
		response.getWriter().print(result);
		return null;
	}
	/**
	 * 修改目录
	 * @作者: 卜繁晟
	 * @创时: 2013-2-7 下午2:35:03
	 */
	@RequestMapping("/updDirById")
	public String updDirById(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map pMap = ParameterMap.getParameterMap(request, true);
		int result = wikiService.updDirById(pMap);
		response.setContentType("text/javascript;charset=utf-8");
		response.getWriter().print(result);
		return null;
	}
}