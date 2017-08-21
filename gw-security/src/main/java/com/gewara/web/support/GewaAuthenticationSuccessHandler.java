package com.gewara.web.support;

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

import com.gewara.Config;
import com.gewara.model.acl.GewaraUser;
import com.gewara.untrans.CacheService;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaLogger;
import com.gewara.util.StringUtil;
import com.gewara.util.WebLogger;
import com.gewara.web.support.auth.DefaultSessidGenerator;
import com.gewara.web.support.auth.SessidGenerator;
import com.gewara.web.util.LoginUtils;

public class GewaAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private Map<String, String> successUrlMap = new HashMap<String, String>();
	private String partnerKeyParameter = "ptn";
	public static final String REMEMBERME_PARAM = "rememberMe";
	
	protected CacheService cacheService;
	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}
	@Autowired@Qualifier("monitorService")
	protected MonitorService monitorService;
	
	@Autowired@Qualifier("authenticationManager")
	protected ProviderManager authenticationManager;
	@Autowired@Qualifier("config")
	protected Config config;
	protected int defaultDuration = 60 * 60 * 12;
	protected boolean enableRememberMe = false;
	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}
	protected int rememberMeSeconds = 60 * 60 * 24 * 7;
	public void setEnableRememberMe(boolean enableRememberMe) {
		this.enableRememberMe = enableRememberMe;
	}
	private boolean httpOnly = true;
	public void setHttpOnly(boolean httpOnly) {
		this.httpOnly = httpOnly;
	}
	protected SessidGenerator sessidGenerator = new DefaultSessidGenerator();
	/**
	 * 用户是否重复登录
	 */
	protected boolean isRelogin = false;

	public boolean isRelogin() {
		return isRelogin;
	}

	public void setRelogin(boolean isRelogin) {
		this.isRelogin = isRelogin;
	}
	
	@Override
	public void setDefaultTargetUrl(String defaultTargetUrl) {
		defaultTargetUrl = config.getBasePath() + defaultTargetUrl;
		super.setDefaultTargetUrl(defaultTargetUrl);
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		processSuccess(request, response, authentication);
		String targetUrl = determineTargetUrl(request, response);
		getRedirectStrategy().sendRedirect(request, response, targetUrl);
	}

	/**
	 * 认证成功后处理cookie、cache
	 * @param request
	 * @param response
	 * @param authentication
	 */
	public void processSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		if(authentication.isAuthenticated()){
			String ip = BaseWebUtils.getRemoteIp(request);
			boolean rememberMe = StringUtils.isNotBlank(request.getParameter(REMEMBERME_PARAM));
			int duration = defaultDuration;
			if(enableRememberMe && rememberMe){
				duration = rememberMeSeconds;
			}
			
			String sessid = saveAuthentication(ip, duration, rememberMe, authentication);
			
			setLogonSessid(sessid, response, duration);
			GewaraUser user = (GewaraUser) authentication.getPrincipal();
			LoginUtils.setLogonTrace(user.getId(), request, response);
			successCallback(request, user, ip, sessid);
		}
	}

	/**
	 * 认证成功后处理cookie、cache
	 * @param request
	 * @param response
	 * @param authentication
	 */
	public void processSessid(HttpServletRequest request, HttpServletResponse response, Long userId, String sessid) {
		boolean rememberMe = StringUtils.isNotBlank(request.getParameter(REMEMBERME_PARAM));
		int duration = defaultDuration;
		if(enableRememberMe && rememberMe){
			duration = rememberMeSeconds;
		}
			
		setLogonSessid(sessid, response, duration);
		LoginUtils.setLogonTrace(userId, request, response);
	}

	public String saveAuthentication(String ip, int duration, boolean rememberMe, Authentication authentication){
		GewaraUser user = (GewaraUser) authentication.getPrincipal();
		if(authentication.isAuthenticated()){
			String sessid = sessidGenerator.generateSessid(authentication);
			
			CachedAuthentication ca = new CachedAuthentication();
			ca.setAuthentication(authentication);
			ca.setIp(ip);
			ca.setTimeout(System.currentTimeMillis() + duration * 1000);
			String ukey = LoginUtils.getCacheUkey(sessid);
			cacheService.set(CacheService.REGION_LOGINAUTH, ukey, ca, duration);
			
			String repeatKey = LoginUtils.getRepeatKey(user.getUsertype(), user.getUsername());
			if (isRelogin) {
				Object sessidOld = cacheService.get(CacheService.REGION_LOGINAUTH, repeatKey);
				if (sessidOld != null && !sessid.equals(sessidOld)) {
					cacheService.remove(CacheService.REGION_LOGINAUTH, LoginUtils.getCacheUkey(sessidOld.toString()));
					dbLogger.error("重复用户登录，剔除用户" + repeatKey + " " + user.getUsername());
				}
				cacheService.set(CacheService.REGION_LOGINAUTH, repeatKey, sessid);
			}
			return sessid;
		}else{
			throw new IllegalStateException(user.getUsername() + " not authenticated!");
		}
	}
	
	/**
	 * 处理登录信息
	 * @param remoteIp
	 * @param userAgent
	 * @param port
	 * @param loginname
	 * @param password
	 * @return
	 */
	public String processAuthentication(String remoteIp, String userAgent, String port, String loginname, String password) {
		Authentication authentication = new UsernamePasswordAuthenticationToken(loginname, password);
		authentication = authenticationManager.authenticate(authentication);
		
		int duration = defaultDuration;
		GewaraUser user = (GewaraUser) authentication.getPrincipal();
		String sessid = saveAuthentication(remoteIp, duration, false, authentication);
		successCallback(userAgent, port, user, remoteIp, sessid);
		return sessid;
	}
	
	protected void successCallback(String userAgent, String port, GewaraUser user, String ip, String sessid) {
		String nickname = user.getRealname();
		String brower = BaseWebUtils.getBrowerInfo(userAgent);
		Map<String, String> info = new HashMap<String, String>();
		info.put("nickname", nickname);
		info.put("sid", StringUtil.md5(sessid));
		info.put("brower", brower);
		if(StringUtils.isNotBlank(port)){
			info.put("port", port);
		}
		monitorService.saveMemberLogMap(user.getId(), "login", info, ip);
	}
	protected void successCallback(HttpServletRequest request, GewaraUser user, String ip, String sessid) {
		String userAgent = request.getHeader("user-agent");
		String port = BaseWebUtils.getRemotePort(request);
		successCallback(userAgent, port, user, ip, sessid);
	}
	protected void setLogonSessid(String sessid, HttpServletResponse response, int duration) {
		// 设置前台登录Cookie
		Cookie cookie = new Cookie(LoginUtils.SESS_COOKIE_NAME, sessid);
		cookie.setMaxAge(duration);
		cookie.setPath("/");
		cookie.setSecure(false);
		cookie.setHttpOnly(httpOnly);
		response.addCookie(cookie);
	}

	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
		String partner = request.getParameter(partnerKeyParameter);
		String target = "";
		if (StringUtils.isNotBlank(partner)) {
			target = successUrlMap.get(partner);
		}
		if (StringUtils.isNotBlank(target))
			return target;
		return super.determineTargetUrl(request, response);
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
