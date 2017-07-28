/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.web.support.SSOClientService;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.Assert;

public class GewaLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
	protected boolean enableSSO = false;
	protected String targetUrlParameter = null;
	protected SSOClientService ssoClientService;
	private Map<String, String> loginFormMap = new LinkedHashMap();

	public GewaLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
		super(loginFormUrl);
	}

	public void setEnableSSO(boolean enableSSO) {
		this.enableSSO = enableSSO;
	}

	public void setSsoClientService(SSOClientService ssoClientService) {
		this.ssoClientService = ssoClientService;
	}

	public void setLoginFormMap(Map<String, String> loginFormMap) {
		this.loginFormMap = loginFormMap;
	}

	public void afterPropertiesSet() throws Exception {
		if (this.enableSSO) {
			Assert.notNull(this.ssoClientService);
			this.ssoClientService.setTargetUrlParameter(this.targetUrlParameter);
		}

		super.afterPropertiesSet();
	}

	protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) {
		if (this.loginFormMap != null && !this.loginFormMap.isEmpty()) {
			String uri = request.getRequestURI();
			Iterator arg4 = this.loginFormMap.keySet().iterator();

			String key;
			do {
				if (!arg4.hasNext()) {
					return this.getLoginFormUrl();
				}

				key = (String) arg4.next();
			} while (!StringUtils.startsWith(uri, key));

			return (String) this.loginFormMap.get(key);
		} else {
			return this.getLoginFormUrl();
		}
	}

	protected String buildRedirectUrlToLoginPage(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) {
		String url;
		if (this.isEnableSSO(request)) {
			url = this.ssoClientService.getLoginUrl(request);
			return url;
		} else {
			url = super.buildRedirectUrlToLoginPage(request, response, authException);
			if (url.indexOf(this.targetUrlParameter) < 0) {
				String targetUrl = request.getParameter(this.targetUrlParameter);
				String params;
				if (StringUtils.isBlank(targetUrl)) {
					targetUrl = request.getRequestURI();
					params = request.getQueryString();
					if (StringUtils.isNotBlank(params)) {
						try {
							targetUrl = targetUrl + "?" + URLDecoder.decode(params, "utf-8");
						} catch (UnsupportedEncodingException arg8) {
							;
						}
					}
				}

				try {
					params = this.targetUrlParameter + "=" + URLEncoder.encode(targetUrl, "utf-8");
					if (url.indexOf("?") > 0) {
						url = url + "&" + params;
					} else {
						url = url + "?" + params;
					}
				} catch (Exception arg7) {
					;
				}
			}

			return url;
		}
	}

	protected boolean isEnableSSO(HttpServletRequest request) {
		return this.enableSSO && request != null;
	}

	public void setTargetUrlParameter(String targetUrlParameter) {
		this.targetUrlParameter = targetUrlParameter;
	}
}