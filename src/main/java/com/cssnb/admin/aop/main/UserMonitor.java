/**
 *<p>Copyright: CHINA NATIONAL SOFTWARE & SERVICE CO.,LTD.</p>
 */
package com.cssnb.admin.aop.main;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cssnb.admin.aop.dao.UserMonitorDao;

/**
 * @Company: 中国软件与技术服务股份有限公司宁波子公司
 * @Project: 宁波工商信用-奉化信用
 * @Description:
 * @JDK version used: JDK1.6
 * @Author: 卜繁晟
 * @Email: 5545795@qq.com | bufsh@css.com.cn
 * @Created Date: 2013-1-6 下午3:42:36
 */
@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
public class UserMonitor {

	@Autowired
	UserMonitorDao userMonitorDao;

	/**
	 * 操作前开始监控
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-7 上午11:11:43
	 */
	/**
	 * xml配置
	<aop:config>
		<aop:aspect id="b" ref="aspect">
			<aop:pointcut id="xk_pc" expression="execution(* nhxy..action.*.*(..)) or execution(* wzjy.action.*.*(..))" />
			<aop:before method="doBefore" pointcut-ref="xk_pc"/>
			<aop:after method="doAfter" pointcut-ref="xk_pc"/>
		</aop:aspect>
	</aop:config>
	*/
	public void doBefore(JoinPoint jp){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String username = SecurityUtils.getSubject().getPrincipal().toString();
		if(username != null){
			Map monitorMap = new HashMap();
			monitorMap.put("yhmc", username);
			String url = request.getRequestURL() + (request.getQueryString() != null ? "?" + request.getQueryString() : "");
			url = url.length() > 500 ? url.substring(0, 500) : url;
			monitorMap.put("url", url);
			monitorMap.put("lm", jp.getSignature().getDeclaringTypeName());
			monitorMap.put("ffm", jp.getSignature().getName());
			// 求访问的参数
			String paramStr = "";
			Object args[] = jp.getArgs();
			if(args != null){
				for(int i = 0; i < args.length; i++){
					paramStr += args[i] + ",";
				}
				if(paramStr.length() > 0){
					paramStr = paramStr.substring(0, paramStr.length() - 1);
				}
				if(paramStr.length() > 1000){
					paramStr = paramStr.substring(0, 1000);
				}
			}
			monitorMap.put("cs", paramStr);
			userMonitorDao.addUserMonitor(monitorMap);
		}
	}
	/**
	 * 监控结束控制
	 * @Author: 卜繁晟
	 * @Created Date: 2013-1-7 上午11:11:51
	 */
	public void doAfter(JoinPoint jp){}
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
//		long time = System.currentTimeMillis();
		Object retVal = pjp.proceed();
//		time = System.currentTimeMillis() - time;
		//System.out.println("process time: " + time + " ms");
		return retVal;
	}
	public void doThrowing(JoinPoint jp, Throwable ex){
		//System.out.println("method " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + " throw exception");
		//System.out.println(ex.getMessage());
	}
	private void sendEx(String ex){
		// 发送短信或邮件提醒
	}
}