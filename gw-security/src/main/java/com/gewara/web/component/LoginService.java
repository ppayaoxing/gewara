package com.gewara.web.component;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import com.gewara.model.acl.GewaraUser;
import com.gewara.support.ErrorCode;

public interface LoginService {
	
	/**
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 * @return Map(id,realname)
	 */
	ErrorCode<Map> autoLogin(HttpServletRequest request, HttpServletResponse response, String username, String password);
	GewaraUser getLogonGewaraUserBySessid(String ip, String sessid);
	Authentication loadAuthentication(String ip, String sessid);
	boolean isGewaraUserLogon(HttpServletRequest request, String sessid);
	ErrorCode<Map> ssoAutoLogin(HttpServletRequest request, HttpServletResponse response, String sessid);
	void removeInvalidSessid(String sessid);
}
