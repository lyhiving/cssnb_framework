/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.wiki.index.dao;

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
public class WikiDao extends SqlSessionDaoSupport {

	/**
	 * 查询目录列表
	 * @作者: 卜繁晟
	 * @创时: 2013-2-2 下午9:01:51
	 */
	public List getDirList(){
		return super.getSqlSession().selectList("Wiki.getDirList");
	}
	/**
	 * 添加新文档
	 * @作者: 卜繁晟
	 * @创时: 2013-2-1 下午4:17:11
	 */
	public int addDoc(Map pMap){
		return super.getSqlSession().insert("Wiki.addDoc", pMap);
	}
	/**
	 * 更新文档数据
	 * @作者: 卜繁晟
	 * @创时: 2013-2-4 下午3:27:28
	 */
	public int updDoc(Map pMap){
		return super.getSqlSession().update("Wiki.updDoc", pMap);
	}
	/**
	 * 查询首页文档内容
	 * @作者: 卜繁晟
	 * @创时: 2013-2-4 下午1:56:29
	 */
	public Map getDocIndex(){
		return super.getSqlSession().selectOne("Wiki.getDocIndex");
	}
	/**
	 * 根据目录ID查询文档内容
	 * @作者: 卜繁晟
	 * @创时: 2013-2-4 下午2:42:05
	 */
	public Map getDocByDirId(Map pMap){
		return super.getSqlSession().selectOne("Wiki.getDocByDirId", pMap);
	}
	/**
	 * 添加目录
	 * @作者: 卜繁晟
	 * @创时: 2013-2-7 下午2:34:40
	 */
	public int addDir(Map pMap){
		return super.getSqlSession().insert("Wiki.addDir", pMap);
	}
	/**
	 * 删除目录
	 * @作者: 卜繁晟
	 * @创时: 2013-2-7 下午2:35:45
	 */
	public int delDirById(Map pMap){
		return super.getSqlSession().delete("Wiki.delDirById", pMap);
	}
	/**
	 * 修改目录
	 * @作者: 卜繁晟
	 * @创时: 2013-2-7 下午2:36:38
	 */
	public int updDirById(Map pMap){
		return super.getSqlSession().update("Wiki.updDirById", pMap);
	}
}