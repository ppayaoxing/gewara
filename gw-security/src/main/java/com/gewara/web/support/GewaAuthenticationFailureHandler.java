/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.untrans.monitor.MonitorService;
import com.gewara.util.BaseWebUtils;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

public class GewaAuthenticationFailureHandler implements AuthenticationFailureHandler {
	private Map<String, String> failureUrlMap = new HashMap();
	private String loginFromParameter = "LOGINFROM";
	private String defaultFailureUrl;
	private boolean forwardToDestination = false;
	private String targetUrlParameter = null;
	@Autowired
	@Qualifier("monitorService")
	private MonitorService monitorService;
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public void setTargetUrlParameter(String targetUrlParameter) {
		this.targetUrlParameter = targetUrlParameter;
	}

	public GewaAuthenticationFailureHandler() {
	}

	public GewaAuthenticationFailureHandler(String defaultFailureUrl) {
		this.setDefaultFailureUrl(defaultFailureUrl);
	}

	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String failure = this.defaultFailureUrl;
		String loginFrom = request.getParameter(this.loginFromParameter);
		if (StringUtils.isNotBlank(loginFrom) && this.failureUrlMap.get(loginFrom) != null) {
			failure = (String) this.failureUrlMap.get(loginFrom);
		}

		if (failure == null) {
			response.sendError(401, "Authentication Failed: " + exception.getMessage());
		} else {
			String username = request.getParameter("j_username");
			String params = "name=" + username;
			String errortype = "passOrName";
			if (exception instanceof InvalidCookieException) {
				errortype = "captcha";
			} else if (exception instanceof DisabledException) {
				errortype = "rejected";
			} else if (exception instanceof BadCredentialsException) {
				errortype = "password";
			} else if (exception instanceof AuthenticationServiceException) {
				errortype = "username";
			}

			if (StringUtils.isNotBlank(errortype)) {
				params = params + "&errortype=" + URLEncoder.encode(errortype, "utf-8");
			}

			failure = failure + "?" + params;
			String targetUrl = request.getParameter(this.targetUrlParameter);
			if (StringUtils.isNotBlank(targetUrl)) {
				try {
					String result = this.targetUrlParameter + "=" + URLEncoder.encode(targetUrl, "utf-8");
					failure = failure + "&" + result;
				} catch (Exception arg14) {
					;
				}
			}

			HashMap result1 = new HashMap();
			String ip = BaseWebUtils.getRemoteIp(request);
			String userAgent = request.getHeader("user-agent");
			String ckcitycode = BaseWebUtils.getCookieValue(request, "citycode");
			result1.put("citycode", ckcitycode);
			result1.put("userAgent", userAgent);
			result1.put("membername", username);
			String port = BaseWebUtils.getRemotePort(request);
			if (StringUtils.isNotBlank(port)) {
				result1.put("port", port);
			}

			result1.put("errortype", errortype);
			this.monitorService.saveMemberLogByName(username, "login", result1, ip);
			this.redirectStrategy.sendRedirect(request, response, failure);
		}

	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		Assert.isTrue(UrlUtils.isValidRedirectUrl(defaultFailureUrl),
				"\'" + defaultFailureUrl + "\' is not a valid redirect URL");
		this.defaultFailureUrl = defaultFailureUrl;
	}

	public boolean isUseForward() {
		return this.forwardToDestination;
	}

	public void setUseForward(boolean forwardToDestination) {
		this.forwardToDestination = forwardToDestination;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return this.redirectStrategy;
	}

	public void setFailureUrlMap(Map<String, String> failureUrlMap) {
		this.failureUrlMap = failureUrlMap;
	}

	public void setLoginFromParameter(String loginFromParameter) {
		this.loginFromParameter = loginFromParameter;
	}
}