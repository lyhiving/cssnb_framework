package com.cssnb.wwxt.monitor.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.css.framework.common.util.ResponseUtil;
import com.cssnb.commons.utils.ParameterMap;
import com.cssnb.wwxt.monitor.service.MonitorService;

@Controller("/monitor")
@SuppressWarnings("rawtypes")
public class MonitorAction {

	@Autowired
	private MonitorService monitorService;

	/**
	 * 查询初始化跳转
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午4:27:19
	 */
	public String init(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List bmList = monitorService.getBmList();
		request.setAttribute("bmList", bmList);
		return "admin/monitor/monitor_query";
	}
	/**
	 * 查询用户列表
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午4:27:13
	 */
	public String getYhList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map pMap = ParameterMap.getParameterMap(request);
		List yhList = monitorService.getYhList(pMap);
		ResponseUtil.sendJSONResponse(response, yhList);
		return null;
	}
	/**
	 * 查询监控记录
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午3:50:01
	 */
	public String getMonitorList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String username = SecurityUtils.getSubject().getPrincipal().toString();
		if(username != null){
			Map pMap = ParameterMap.getParameterMap(request);
//			int totalRows = this.getTotalRows(request);
//			if(totalRows < 0){
//				totalRows = monitorService.getMonitorListCount(pMap);
//			}
//			this.setPageProperty(request, pMap, totalRows, 10);
			List monitorList = monitorService.getMonitorList(pMap);
			request.setAttribute("monitorList", monitorList);
			return "admin/monitor_list";
		}
		return null;
	}
	/**
	 * 查询监控详细记录
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午3:51:50
	 */
	public String getMonitorDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map pMap = ParameterMap.getParameterMap(request);
		Map monitorMap = monitorService.getMonitorDetail(pMap);
		request.setAttribute("monitorMap", monitorMap);
		return "admin/monitor/monitor_detail";
	}
	/**
	 * 查询监控统计报表
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午3:51:50
	 */
	public String report(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map pMap = ParameterMap.getParameterMap(request);
		List reportList = monitorService.getMonitorReport(pMap);
		request.setAttribute("reportList", reportList);
		request.setAttribute("reportSize", reportList.size());
		return "admin/monitor/monitor_report";
	}
}