/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.Config;
import com.gewara.model.acl.GewaraUser;
import com.gewara.untrans.CacheService;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.util.BaseWebUtils;
import com.gewara.web.component.LoginService;
import com.gewara.web.util.LoginUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class GewaUrlLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler
		implements LogoutSuccessHandler {
	private String logoutParamName = "ptn";
	protected Map<String, String> logoutUrlMap = new HashMap();
	@Autowired
	@Qualifier("cacheService")
	protected CacheService cacheService;
	@Autowired
	@Qualifier("loginService")
	protected LoginService loginService;
	@Autowired
	@Qualifier("monitorService")
	protected MonitorService monitorService;
	@Autowired
	protected Config config;
	private boolean casSsoLogout = false;

	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
		String partner = request.getParameter(this.logoutParamName);
		return StringUtils.isNotBlank(partner) && StringUtils.isNotBlank((String) this.logoutUrlMap.get(partner))
				? (String) this.logoutUrlMap.get(partner) : super.determineTargetUrl(request, response);
	}

	public void setLogoutParamName(String logoutParamName) {
		this.logoutParamName = logoutParamName;
	}

	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		this.doLogout(request, response, authentication);
	}

	public void doLogout(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String ukey = BaseWebUtils.getCookieValue(request, LoginUtils.SESS_COOKIE_NAME);
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaraUser user = null;
		if (LoginUtils.isValidSessid(ukey)) {
			user = this.loginService.getLogonGewaraUserBySessid(ip, ukey);
			if (user != null) {
				this.cacheService.remove("loginAuth", LoginUtils.getCacheUkey(ukey));
				String key = LoginUtils.getRepeatKey(user.getUsertype(), user.getUsername());
				this.cacheService.remove("loginAuth", key);
				this.addMemberLogoutLog(user.getId(), user.getRealname(), ip);
			}
		}

		LoginUtils.removeLogonUkey(response);
		if (user != null && StringUtils.equals(user.getUsertype(), "sso") && this.isCasSsoLogout()) {
			this.casLogout(request, response);
		} else {
			super.handle(request, response, authentication);
		}

	}

	public void addMemberLogoutLog(Long memberid, String nickname, String ip) {
		HashMap changeMap = new HashMap();
		changeMap.put("nickname", nickname);
		changeMap.put("errortype", "logout");
		this.monitorService.saveMemberLogMap(memberid, "login", changeMap, ip);
	}

	public void setLogoutUrlMap(Map<String, String> logoutUrlMap) {
		this.logoutUrlMap = logoutUrlMap;
	}

	public void casLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(this.config.getString("ssoValidateUrl") + "logout?service=" + this.getPath()
				+ this.config.getBasePath());
	}

	public boolean isCasSsoLogout() {
		return this.casSsoLogout;
	}

	public void setCasSsoLogout(boolean casSsoLogout) {
		this.casSsoLogout = casSsoLogout;
	}

	private String getPath() {
		String path = this.config.getString("houtaiPath");
		if (StringUtils.isBlank(path)) {
			path = this.config.getAbsPath();
		}

		return path;
	}
}