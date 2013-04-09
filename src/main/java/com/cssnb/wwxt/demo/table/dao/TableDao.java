/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.wwxt.demo.table.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @Company: 中国软件与技术服务股份有限公司宁波分公司
 * @Author(svn): 卜繁晟
 * @Created Date: 2013-1-29
 */
@SuppressWarnings("rawtypes")
@Repository
public class TableDao extends SqlSessionDaoSupport {

	/**
	 * @作者: 卜繁晟
	 * @创时: 2013-1-29 下午3:23:12
	 */
	public List getTreeList(){
		return super.getSqlSession().selectList("Ztree.getTreeList");
	}
	/**
	 * 查询模块列表（根据第一层）
	 * @param pMap
	 * @作者: 卜繁晟
	 * @创时: 2013-1-31 上午11:45:45
	 */
	public List getTreeListFirst(Map pMap){
		return super.getSqlSession().selectList("Ztree.getTreeListFirst", pMap);
	}
	/**
	 * 查询模块列表（根据父级）
	 * @param pMap
	 * @作者: 卜繁晟
	 * @创时: 2013-1-31 上午11:45:45
	 */
	public List getTreeListByPID(Map pMap){
		return super.getSqlSession().selectList("Ztree.getTreeListByPID", pMap);
	}
	/**
	 * @作者: 卜繁晟
	 * @创时: 2013-4-7 下午3:45:27
	 */
	public List getModuleList(Map pMap){
		return super.getSqlSession().selectList("Ztree.getModuleList", pMap);
	}
}
