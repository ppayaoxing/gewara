package com.gewara.web.support;

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

import com.gewara.untrans.monitor.MonitorService;
import com.gewara.util.BaseWebUtils;
import com.gewara.web.util.LoginUtils;
/**
 * @author acerge(acerge@163.com)
 * @since 6:08:04 PM Jun 19, 2010
 */
public class GewaAuthenticationFailureHandler implements AuthenticationFailureHandler {
	private Map<String, String> failureUrlMap = new HashMap<String, String>();
	private String loginFromParameter = "LOGINFROM";
	private String defaultFailureUrl;
	private boolean forwardToDestination = false;
	private String targetUrlParameter = null;
	@Autowired@Qualifier("monitorService")
	private MonitorService monitorService;
	public void setTargetUrlParameter(String targetUrlParameter) {
		this.targetUrlParameter = targetUrlParameter;
	}
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public GewaAuthenticationFailureHandler() {
	}

	public GewaAuthenticationFailureHandler(String defaultFailureUrl) {
		setDefaultFailureUrl(defaultFailureUrl);
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		String failure = defaultFailureUrl;
		String loginFrom = request.getParameter(loginFromParameter);
		if(StringUtils.isNotBlank(loginFrom) && failureUrlMap.get(loginFrom)!=null){
			failure = failureUrlMap.get(loginFrom);
		}
		if (failure == null) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed: " + exception.getMessage());
		} else {
			String username = request.getParameter("j_username");
			String params = "name=" + username;
			String errortype = LoginUtils.ERROR_PASSORNAME;
			if(exception instanceof InvalidCookieException){
				errortype = "captcha";
			}else if(exception instanceof DisabledException){
				//msg = "����û��������ã�����ϵ�ͷ���";
				errortype = LoginUtils.ERROR_REJECTED;
			}else if(exception instanceof BadCredentialsException){//�������
				errortype = LoginUtils.ERROR_PASSWORD;
			}else if(exception instanceof AuthenticationServiceException){//�û�������.
				errortype = LoginUtils.ERROR_USERNAME;
			}	
			if(StringUtils.isNotBlank(errortype)) {
                params += "&errortype=" + URLEncoder.encode(errortype, "utf-8");
            }
			failure += "?" + params;
			String targetUrl = request.getParameter(targetUrlParameter);
			if(StringUtils.isNotBlank(targetUrl)) {
				try{
					String urlParam = targetUrlParameter + "=" + URLEncoder.encode(targetUrl, "utf-8");
					failure += "&" + urlParam;
				}catch(Exception e){
				}
			}
			//��¼��־
			Map<String, String> result = new HashMap();
			String ip = BaseWebUtils.getRemoteIp(request);
			String userAgent = request.getHeader("user-agent");
			String ckcitycode = BaseWebUtils.getCookieValue(request, "citycode");
			
			result.put("citycode", ckcitycode);
			result.put("userAgent", userAgent);
			result.put("membername", username);
			String port = BaseWebUtils.getRemotePort(request);
			if(StringUtils.isNotBlank(port)){
				result.put("port", port);
			}
			result.put("errortype", errortype);

			monitorService.saveMemberLogByName(username, "login", result, ip);
			redirectStrategy.sendRedirect(request, response, failure);
		}
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		Assert.isTrue(UrlUtils.isValidRedirectUrl(defaultFailureUrl), "'" + defaultFailureUrl + "' is not a valid redirect URL");
		this.defaultFailureUrl = defaultFailureUrl;
	}

	public boolean isUseForward() {
		return forwardToDestination;
	}

	/**
	 * If set to <tt>true</tt>, performs a forward to the failure destination URL instead of a redirect. Defaults to
	 * <tt>false</tt>.
	 */
	public void setUseForward(boolean forwardToDestination) {
		this.forwardToDestination = forwardToDestination;
	}

	/**
	 * Allows overriding of the behaviour when redirecting to a target URL.
	 */
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setFailureUrlMap(Map<String, String> failureUrlMap) {
		this.failureUrlMap = failureUrlMap;
	}

	public void setLoginFromParameter(String loginFromParameter) {
		this.loginFromParameter = loginFromParameter;
	}
}
