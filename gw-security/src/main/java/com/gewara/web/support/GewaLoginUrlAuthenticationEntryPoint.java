package com.gewara.web.support;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.Assert;

public class GewaLoginUrlAuthenticationEntryPoint  extends LoginUrlAuthenticationEntryPoint {
	protected boolean enableSSO = false;
	protected String targetUrlParameter = null;
	protected SSOClientService ssoClientService;
	public GewaLoginUrlAuthenticationEntryPoint(String loginFormUrl){
		super(loginFormUrl);
	}
	public void setEnableSSO(boolean enableSSO) {
		this.enableSSO = enableSSO;
	}
	public void setSsoClientService(SSOClientService ssoClientService) {
		this.ssoClientService = ssoClientService;
	}
	//url Ìø×ªÓ³Éä
	private Map<String, String> loginFormMap = new LinkedHashMap<String, String>();
	public void setLoginFormMap(Map<String, String> loginFormMap) {
		this.loginFormMap = loginFormMap;
	}
	// ~ Methods
	// ========================================================================================================
	@Override
	public void afterPropertiesSet() throws Exception {
		if(enableSSO) {
			Assert.notNull(ssoClientService);
			ssoClientService.setTargetUrlParameter(targetUrlParameter);
		}
		super.afterPropertiesSet();
	}
	@Override
	protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception){
		if(loginFormMap == null || loginFormMap.isEmpty()) return getLoginFormUrl();
		String uri = request.getRequestURI();
		for(String key: loginFormMap.keySet()){
			if(StringUtils.startsWith(uri, key)) return loginFormMap.get(key);
		}
		return getLoginFormUrl();
	}
	@Override
	protected String buildRedirectUrlToLoginPage(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
		if(isEnableSSO(request)){
			String url = ssoClientService.getLoginUrl(request);
			return url;
		}

		String url = super.buildRedirectUrlToLoginPage(request, response, authException);
		if(url.indexOf(targetUrlParameter)<0){
			String targetUrl = request.getParameter(targetUrlParameter);
			if(StringUtils.isBlank(targetUrl)) {
				targetUrl = request.getRequestURI();
				String qstr = request.getQueryString();
				if(StringUtils.isNotBlank(qstr)){
					try {
						targetUrl += "?" + URLDecoder.decode(qstr, "utf-8");
					} catch (UnsupportedEncodingException e) {
					}
				}
			}else{
				
			}
			try{
				String params = targetUrlParameter + "=" + URLEncoder.encode(targetUrl, "utf-8");
				if(url.indexOf("?") >0) url += "&" + params;
				else url += "?" + params;
			}catch(Exception e){
			}
		}
		return url;
	}
	protected boolean isEnableSSO(HttpServletRequest request){
		return enableSSO && request!=null;
	}
	public void setTargetUrlParameter(String targetUrlParameter) {
		this.targetUrlParameter = targetUrlParameter;
	}
}
