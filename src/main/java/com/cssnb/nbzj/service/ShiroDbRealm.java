/**
 * 
 */
package com.cssnb.nbzj.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cssnb.commons.shiro.CaptchaUsernamePasswordToken;
import com.cssnb.commons.shiro.IncorrectCaptchaException;
import com.cssnb.commons.utils.Constants;
import com.cssnb.nbzj.entity.Role;
import com.cssnb.nbzj.entity.User;

/**
 * @author Administrator
 *
 */
public class ShiroDbRealm extends AuthorizingRealm {

	private static Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);
	
	private AccountManager accountManager;
	
	/**
	 * 认证回调函数, 登录时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username=(String)principals.fromRealm(getName()).iterator().next();     
        if( username != null ){     
            User user = accountManager.findUserByLoginName( username );     
            if( user != null && user.getRoleList() != null ){     
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();     
                for( Role each: user.getRoleList() ){     
                        info.addRole(each.getName());     
//                        info.addStringPermissions(each.getPermissionsAsString());     
                }     
                return info;     
            }     
        }     
        return null;
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		//UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) authcToken;
		
		//验证码 验证
        String captcha =null;
        Object obj_captcha = SecurityUtils.getSubject().getSession().getAttribute(Constants.CAPTCHA_KEY );
        //Object obj_count = SecurityUtils.getSubject().getSession().getAttribute( "login_fail_count" );
        //int failed_count = (obj_count ==null || !(obj_count instanceof Integer))?0:(Integer)obj_count;
        if( obj_captcha instanceof String)
             captcha = (String)obj_captcha;
        logger.debug("you input:{},img:{}",token.getCaptcha(),captcha);
        if( captcha !=null 
        		//&& failed_count >0
        		&& !captcha.equalsIgnoreCase( token.getCaptcha() )){
            throw new IncorrectCaptchaException("验证码错误！");
        }
       
		User user = accountManager.findUserByLoginName(token.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(user.getLoginName(),user.getPassword(),user.getName());
		} else {
			return null;
		}
	}

	/**
	  * 更新用户授权信息缓存.
	  */
	@Override
	protected void clearCachedAuthorizationInfo(PrincipalCollection principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
	
	@Autowired
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
}
