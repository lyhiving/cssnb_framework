/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.wwxt.demo.ztree.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cssnb.wwxt.demo.ztree.dao.ZtreeDao;

/**
 * @Company: 中国软件与技术服务股份有限公司宁波分公司
 * @Author(svn): 卜繁晟
 * @Created Date: 2013-1-29
 */
@Service
@SuppressWarnings("rawtypes")
public class ZtreeService {

	@Autowired
	private ZtreeDao ztreeDao;

	/**
	 * Ztree读取树数据
	 * @作者: 卜繁晟
	 * @创时: 2013-1-29 下午3:22:25
	 */
	public List getTreeList(){
		return ztreeDao.getTreeList();
	}
	/**
	 * 查询模块列表（根据第一层）
	 * @param pMap
	 * @作者: 卜繁晟
	 * @创时: 2013-1-31 上午11:45:10
	 */
	public List getTreeListFirst(Map pMap){
		return ztreeDao.getTreeListFirst(pMap);
	}
	/**
	 * 查询模块列表（根据父级）
	 * @param pMap
	 * @作者: 卜繁晟
	 * @创时: 2013-1-31 上午11:45:10
	 */
	public List getTreeListByPID(Map pMap){
		return ztreeDao.getTreeListByPID(pMap);
	}
}