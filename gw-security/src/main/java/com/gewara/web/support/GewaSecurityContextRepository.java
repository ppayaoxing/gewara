package com.gewara.web.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;

import com.gewara.util.BaseWebUtils;
import com.gewara.web.component.LoginService;
import com.gewara.web.util.LoginUtils;

public class GewaSecurityContextRepository implements SecurityContextRepository{
	@Autowired@Qualifier("loginService")
	private LoginService loginService;
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	@Override
	public boolean containsContext(HttpServletRequest request) {
		String sessid = BaseWebUtils.getCookieValue(request, LoginUtils.SESS_COOKIE_NAME);
		if(StringUtils.isNotBlank(sessid)){
			return loginService.isGewaraUserLogon(request, sessid);
		}
		return false;
	}

	@Override
	public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
		HttpServletRequest request = requestResponseHolder.getRequest();
		String ukey = BaseWebUtils.getCookieValue(request, LoginUtils.SESS_COOKIE_NAME);
		SecurityContext context = new SecurityContextImpl();
		String ip = BaseWebUtils.getRemoteIp(request);
		Authentication auth = loginService.loadAuthentication(ip, ukey);
		context.setAuthentication(auth);
		return context;
	}

	@Override
	public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
		//DO nothing
	}
}
