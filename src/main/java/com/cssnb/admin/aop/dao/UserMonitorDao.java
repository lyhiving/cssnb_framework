/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.admin.aop.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Company: 中国软件与技术服务股份有限公司宁波子公司
 * @Project: 宁波工商信用-用户操作日志监控系统
 * @JDK version used: JDK1.6
 * @Author: 卜繁晟
 * @Email: 5545795@qq.com | bufsh@css.com.cn
 * @Created Date: 2013-1-7 下午4:04:23
 */
@Repository
public class UserMonitorDao extends SqlSessionDaoSupport {

	/**
	 * 添加用户操作监控日志记录
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-16 上午9:59:17
	 */
	public void addUserMonitor(Map monitorMap){
		super.getSqlSession().insert("Monitor.addUserMonitor", monitorMap);
	}
	/**
	 * 查询模块列表
	 * @param string
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-16 上午9:57:30
	 */
	public List getModuleList(String JH){
		return super.getSqlSession().selectList("Monitor.getModuleList", JH);
	}
	/**
	 * 查询权限信息-getDetail
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-16 下午4:42:34
	 */
	public String getDetailQxxx(Map pMap){
		return (String) super.getSqlSession().selectOne("Monitor.getDetailQxxx", pMap);
	}
	/**
	 * 查询权限信息-getDetailByNbxh
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-16 下午4:42:34
	 */
	public String getDetailByNbxhQxxx(Map pMap){
		return (String) super.getSqlSession().selectOne("Monitor.getDetailByNbxhQxxx", pMap);
	}
}