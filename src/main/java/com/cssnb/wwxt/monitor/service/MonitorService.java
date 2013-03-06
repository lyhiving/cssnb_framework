package com.cssnb.wwxt.monitor.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cssnb.wwxt.monitor.dao.MonitorDao;

@Service
@SuppressWarnings("rawtypes")
public class MonitorService {

	@Autowired
	private MonitorDao monitorDao;

	/**
	 * 查询监控记录列表
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午3:47:10
	 */
	public List getMonitorList(Map pMap){
		return monitorDao.getMonitorList(pMap);
	}
	/**
	 * 查询监控记录总数
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午3:47:21
	 */
	public int getMonitorListCount(Map pMap){
		return monitorDao.getMonitorListCount(pMap);
	}
	/**
	 * 查询监控详细记录
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午3:52:05
	 */
	public Map getMonitorDetail(Map pMap){
		return monitorDao.getMonitorDetail(pMap);
	}
	/**
	 * 查询部门列表
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午4:25:43
	 */
	public List getBmList(){
		return monitorDao.getBmList();
	}
	/**
	 * 查询用户列表
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午4:26:44
	 */
	public List getYhList(Map pMap){
		return monitorDao.getYhList(pMap);
	}
	/**
	 * 查询监控统计报表
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-9 下午2:31:47
	 */
	public List getMonitorReport(Map pMap){
		return monitorDao.getMonitorReport(pMap);
	}
}