/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.wwxt.demo.table.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cssnb.wwxt.demo.table.dao.TableDao;

/**
 * @Company: 中国软件与技术服务股份有限公司宁波分公司
 * @Author(svn): 卜繁晟
 * @Created Date: 2013-1-29
 */
@Service
@SuppressWarnings("rawtypes")
public class TableService {

	@Autowired
	private TableDao tableDao;

	/**
	 * 读取模块列表
	 * @作者: 卜繁晟
	 * @创时: 2013-4-7 下午3:45:12
	 */
	public List getModuleList(Map pMap){
		return tableDao.getModuleList(pMap);
	}
}