package com.cssnb.wwxt.monitor.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("rawtypes")
/**
 * 页面查询统计
 * @描述: 
 * @作者: 卜繁晟
 * @创建日期: 2013-3-4 下午8:31:18
 */
public class MonitorDao extends SqlSessionDaoSupport {

	/**
	 * 查询监控记录列表
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午3:47:57
	 */
	public List getMonitorList(Map pMap){
		return super.getSqlSession().selectList("Monitor.getMonitorList", pMap);
	}
	/**
	 * 查询监控记录总数
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午3:48:04
	 */
	public int getMonitorListCount(Map pMap){
		return super.getSqlSession().selectOne("Monitor.getMonitorListCount", pMap);
	}
	/**
	 * 查询监控详细记录
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午3:52:21
	 */
	public Map getMonitorDetail(Map pMap){
		return (Map) super.getSqlSession().selectOne("Monitor.getMonitorDetail", pMap);
	}
	/**
	 * 查询部门列表
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午4:25:57
	 */
	public List getBmList(){
		return super.getSqlSession().selectList("Monitor.getBmList");
	}
	/**
	 * 查询用户列表
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-8 下午4:25:57
	 */
	public List getYhList(Map pMap){
		return super.getSqlSession().selectList("Monitor.getYhList", pMap);
	}
	/**
	 * 查询监控统计报表
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-9 下午2:32:07
	 */
	public List getMonitorReport(Map pMap){
		return super.getSqlSession().selectList("Monitor.getMonitorReport", pMap);
	}
}