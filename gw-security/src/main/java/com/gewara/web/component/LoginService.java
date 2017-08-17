package com.gewara.web.component;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import com.gewara.model.acl.GewaraUser;
import com.gewara.support.ErrorCode;

public interface LoginService {
	
	/** 根据用户名密码登录
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 * @return Map(id,realname)
	 */
	ErrorCode<Map> autoLogin(HttpServletRequest request, HttpServletResponse response, String username, String password);

	/** 根据sessid 和 ip地址登录
	 * @param ip
	 * @param sessid
	 * @return
	 */
	GewaraUser getLogonGewaraUserBySessid(String ip, String sessid);

	/**根据sessid 和 ip地址获取认证信息
	 * @param ip
	 * @param sessid
	 * @return
	 */
	Authentication loadAuthentication(String ip, String sessid);

	/** 根据sessid判断是否是gewara用户登录
	 * @param request
	 * @param sessid
	 * @return
	 */
	boolean isGewaraUserLogon(HttpServletRequest request, String sessid);

	/** 单点登录
	 * @param request
	 * @param response
	 * @param sessid
	 * @return
	 */
	ErrorCode<Map> ssoAutoLogin(HttpServletRequest request, HttpServletResponse response, String sessid);

	/** 销毁sessid
	 * @param sessid
	 */
	void removeInvalidSessid(String sessid);
}
