/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.util.BaseWebUtils;
import com.gewara.web.component.LoginService;
import com.gewara.web.util.LoginUtils;
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

public class GewaSecurityContextRepository implements SecurityContextRepository {
	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public boolean containsContext(HttpServletRequest request) {
		String sessid = BaseWebUtils.getCookieValue(request, LoginUtils.SESS_COOKIE_NAME);
		return StringUtils.isNotBlank(sessid) ? this.loginService.isGewaraUserLogon(request, sessid) : false;
	}

	public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
		HttpServletRequest request = requestResponseHolder.getRequest();
		String ukey = BaseWebUtils.getCookieValue(request, LoginUtils.SESS_COOKIE_NAME);
		SecurityContextImpl context = new SecurityContextImpl();
		String ip = BaseWebUtils.getRemoteIp(request);
		Authentication auth = this.loginService.loadAuthentication(ip, ukey);
		context.setAuthentication(auth);
		return context;
	}

	public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
	}
}