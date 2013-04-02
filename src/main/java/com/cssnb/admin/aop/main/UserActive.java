/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.admin.aop.main;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.shiro.SecurityUtils;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cssnb.admin.aop.dao.UserMonitorDao;
import com.cssnb.commons.utils.ParameterMap;

/**
 * @Company: 中国软件与技术服务股份有限公司宁波子公司
 * @Project: 宁波工商信用-奉化信用
 * @Description:
 * @JDK version used: JDK1.6
 * @Author: 卜繁晟
 * @Email: 5545795@qq.com | bufsh@css.com.cn
 * @Created Date: 2013-1-6 下午3:42:36
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class UserActive implements MethodBeforeAdvice, MethodInterceptor {

	@Autowired
	UserMonitorDao userMonitorDao;
	private HttpServletRequest request;
	private String url, actionUrl, paramStr = "";

	/**
	 * 操作前开始监控
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-15 上午11:28:35
	 */
	@Override
	public void before(Method arg0, Object[] arg1, Object o) throws Throwable{
		request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String username = SecurityUtils.getSubject().getPrincipal().toString();
		if(username != null){
			Map monitorMap = new HashMap();
			url = "";
			paramStr = "";
			// 求访问的参数
			Map pMap = ParameterMap.getParameterMap(request);
			if(pMap != null){
				paramStr = pMap.toString();
				paramStr = paramStr.substring(1, paramStr.length() - 1);
				if(paramStr.length() > 1000){
					paramStr = paramStr.substring(0, 1000);
				}
			}
			url = request.getServletPath() + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
			url = url.length() > 500 ? url.substring(0, 500) : url;
			this.actionUrl = url;
			monitorMap.put("yhmc", username);
			monitorMap.put("url", url);
			monitorMap.put("cs", paramStr);
			monitorMap.put("lm", o.getClass().toString().replace("class ", ""));
			monitorMap.put("ffm", arg0.getName());
			userMonitorDao.addUserMonitor(monitorMap);
		}
	}
	// 监控action之前
	// implement MethodInterceptor
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable{
		if(request != null){
			url = request.getServletPath() + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
			url = url.length() > 500 ? url.substring(0, 500) : url;
			if(this.actionUrl.equals(url)){
				String username = SecurityUtils.getSubject().getPrincipal().toString();
			}
		}
		return arg0.proceed();
	}
	public void beforeService(){
		if(request != null){
			url = request.getServletPath() + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
			url = url.length() > 500 ? url.substring(0, 500) : url;
			if(this.actionUrl.equals(url)){
				String username = SecurityUtils.getSubject().getPrincipal().toString();
			}
		}
	}
}