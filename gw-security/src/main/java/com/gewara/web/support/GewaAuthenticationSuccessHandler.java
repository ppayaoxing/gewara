/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.Config;
import com.gewara.model.acl.GewaraUser;
import com.gewara.untrans.CacheService;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaLogger;
import com.gewara.util.StringUtil;
import com.gewara.util.WebLogger;
import com.gewara.web.support.CachedAuthentication;
import com.gewara.web.support.auth.DefaultSessidGenerator;
import com.gewara.web.support.auth.SessidGenerator;
import com.gewara.web.util.LoginUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class GewaAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private Map<String, String> successUrlMap = new HashMap();
	private String partnerKeyParameter = "ptn";
	public static final String REMEMBERME_PARAM = "rememberMe";
	protected CacheService cacheService;
	@Autowired
	@Qualifier("monitorService")
	protected MonitorService monitorService;
	@Autowired
	@Qualifier("authenticationManager")
	protected ProviderManager authenticationManager;
	@Autowired
	protected Config config;
	protected int defaultDuration = '?';
	protected boolean enableRememberMe = false;
	protected int rememberMeSeconds = 604800;
	private boolean httpOnly = true;
	protected SessidGenerator sessidGenerator = new DefaultSessidGenerator();
	protected boolean isRelogin = false;

	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}

	public void setEnableRememberMe(boolean enableRememberMe) {
		this.enableRememberMe = enableRememberMe;
	}

	public void setHttpOnly(boolean httpOnly) {
		this.httpOnly = httpOnly;
	}

	public boolean isRelogin() {
		return this.isRelogin;
	}

	public void setRelogin(boolean isRelogin) {
		this.isRelogin = isRelogin;
	}

	public void setDefaultTargetUrl(String defaultTargetUrl) {
		defaultTargetUrl = this.config.getBasePath() + defaultTargetUrl;
		super.setDefaultTargetUrl(defaultTargetUrl);
	}

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		this.processSuccess(request, response, authentication);
		String targetUrl = this.determineTargetUrl(request, response);
		this.getRedirectStrategy().sendRedirect(request, response, targetUrl);
	}

	public void processSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) {
		if (authentication.isAuthenticated()) {
			String ip = BaseWebUtils.getRemoteIp(request);
			boolean rememberMe = StringUtils.isNotBlank(request.getParameter("rememberMe"));
			int duration = this.defaultDuration;
			if (this.enableRememberMe && rememberMe) {
				duration = this.rememberMeSeconds;
			}

			String sessid = this.saveAuthentication(ip, duration, rememberMe, authentication);
			this.setLogonSessid(sessid, response, duration);
			GewaraUser user = (GewaraUser) authentication.getPrincipal();
			LoginUtils.setLogonTrace(user.getId(), request, response);
			this.successCallback(request, user, ip, sessid);
		}

	}

	public void processSessid(HttpServletRequest request, HttpServletResponse response, Long userId, String sessid) {
		boolean rememberMe = StringUtils.isNotBlank(request.getParameter("rememberMe"));
		int duration = this.defaultDuration;
		if (this.enableRememberMe && rememberMe) {
			duration = this.rememberMeSeconds;
		}

		this.setLogonSessid(sessid, response, duration);
		LoginUtils.setLogonTrace(userId, request, response);
	}

	public String saveAuthentication(String ip, int duration, boolean rememberMe, Authentication authentication) {
		GewaraUser user = (GewaraUser) authentication.getPrincipal();
		if (authentication.isAuthenticated()) {
			String sessid = this.sessidGenerator.generateSessid(authentication);
			CachedAuthentication ca = new CachedAuthentication();
			ca.setAuthentication(authentication);
			ca.setIp(ip);
			ca.setTimeout(Long.valueOf(System.currentTimeMillis() + (long) (duration * 1000)));
			String ukey = LoginUtils.getCacheUkey(sessid);
			this.cacheService.set("loginAuth", ukey, ca, duration);
			String repeatKey = LoginUtils.getRepeatKey(user.getUsertype(), user.getUsername());
			if (this.isRelogin) {
				Object sessidOld = this.cacheService.get("loginAuth", repeatKey);
				if (sessidOld != null && !sessid.equals(sessidOld)) {
					this.cacheService.remove("loginAuth", LoginUtils.getCacheUkey(sessidOld.toString()));
					this.dbLogger.error("重复用户登录，剔除用户" + repeatKey + " " + user.getUsername());
				}

				this.cacheService.set("loginAuth", repeatKey, sessid);
			}

			return sessid;
		} else {
			throw new IllegalStateException(user.getUsername() + " not authenticated!");
		}
	}

	public String processAuthentication(String remoteIp, String userAgent, String port, String loginname,
			String password) {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginname,
				password);
		Authentication authentication1 = this.authenticationManager.authenticate(authentication);
		int duration = this.defaultDuration;
		GewaraUser user = (GewaraUser) authentication1.getPrincipal();
		String sessid = this.saveAuthentication(remoteIp, duration, false, authentication1);
		this.successCallback(userAgent, port, user, remoteIp, sessid);
		return sessid;
	}

	protected void successCallback(String userAgent, String port, GewaraUser user, String ip, String sessid) {
		String nickname = user.getRealname();
		String brower = BaseWebUtils.getBrowerInfo(userAgent);
		HashMap info = new HashMap();
		info.put("nickname", nickname);
		info.put("sid", StringUtil.md5(sessid));
		info.put("brower", brower);
		if (StringUtils.isNotBlank(port)) {
			info.put("port", port);
		}

		this.monitorService.saveMemberLogMap(user.getId(), "login", info, ip);
	}

	protected void successCallback(HttpServletRequest request, GewaraUser user, String ip, String sessid) {
		String userAgent = request.getHeader("user-agent");
		String port = BaseWebUtils.getRemotePort(request);
		this.successCallback(userAgent, port, user, ip, sessid);
	}

	protected void setLogonSessid(String sessid, HttpServletResponse response, int duration) {
		Cookie cookie = new Cookie(LoginUtils.SESS_COOKIE_NAME, sessid);
		cookie.setMaxAge(duration);
		cookie.setPath("/");
		cookie.setSecure(false);
		cookie.setHttpOnly(this.httpOnly);
		response.addCookie(cookie);
	}

	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
		String partner = request.getParameter(this.partnerKeyParameter);
		String target = "";
		if (StringUtils.isNotBlank(partner)) {
			target = (String) this.successUrlMap.get(partner);
		}

		return StringUtils.isNotBlank(target) ? target : super.determineTargetUrl(request, response);
	}

	public void setSuccessUrlMap(Map<String, String> successUrlMap) {
		this.successUrlMap = successUrlMap;
	}

	public void setPartnerKeyParameter(String partnerKeyParameter) {
		this.partnerKeyParameter = partnerKeyParameter;
	}

	public void setSessidGenerator(SessidGenerator sessidGenerator) {
		this.sessidGenerator = sessidGenerator;
	}
}