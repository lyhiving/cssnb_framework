/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.wwxt.demo.rapid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cssnb.wwxt.demo.rapid.dao.RapidDao;

/**
 * @Company: 中国软件与技术服务股份有限公司宁波分公司
 * @Author(svn): 卜繁晟
 * @Created Date: 2013-1-29
 */
@Service
public class RapidService {

	@Autowired
	private RapidDao rapidDao;
}