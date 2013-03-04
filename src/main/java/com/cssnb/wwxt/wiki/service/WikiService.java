/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.wwxt.wiki.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cssnb.wwxt.wiki.dao.WikiDao;

/**
 * @Company: 中国软件与技术服务股份有限公司宁波分公司
 * @Author(svn): 卜繁晟
 * @Created Date: 2013-1-29
 */
@Service
@SuppressWarnings("rawtypes")
public class WikiService {

	@Autowired
	private WikiDao wikiDao;

	/**
	 * 查询目录列表
	 * @作者: 卜繁晟
	 * @创时: 2013-2-2 下午9:00:48
	 */
	public List getDirList(){
		return wikiDao.getDirList();
	}
	/**
	 * 添加新文档
	 * @作者: 卜繁晟
	 * @创时: 2013-2-1 下午4:16:35
	 */
	public int addDoc(Map pMap){
		return wikiDao.addDoc(pMap);
	}
	/**
	 * 更新文档数据
	 * @作者: 卜繁晟
	 * @创时: 2013-2-4 下午3:27:11
	 */
	public int updDoc(Map pMap){
		return wikiDao.updDoc(pMap);
	}
	/**
	 * 查询首页文档内容
	 * @作者: 卜繁晟
	 * @创时: 2013-2-4 下午1:56:13
	 */
	public Map getDocIndex(){
		return wikiDao.getDocIndex();
	}
	/**
	 * 根据目录ID查询文档内容
	 * @作者: 卜繁晟
	 * @创时: 2013-2-4 下午2:41:44
	 */
	public Map getDocByDirId(Map pMap){
		return wikiDao.getDocByDirId(pMap);
	}
	/**
	 * 添加目录
	 * @作者: 卜繁晟
	 * @创时: 2013-2-7 下午2:34:26
	 */
	public int addDir(Map pMap){
		return wikiDao.addDir(pMap);
	}
	/**
	 * 删除目录
	 * @作者: 卜繁晟
	 * @创时: 2013-2-7 下午2:35:31
	 */
	public int delDirById(Map pMap){
		return wikiDao.delDirById(pMap);
	}
	/**
	 * 修改目录
	 * @作者: 卜繁晟
	 * @创时: 2013-2-7 下午2:36:24
	 */
	public int updDirById(Map pMap){
		return wikiDao.updDirById(pMap);
	}
}