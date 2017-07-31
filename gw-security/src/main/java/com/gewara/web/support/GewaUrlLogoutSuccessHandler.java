package com.gewara.web.support;

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

import com.gewara.Config;
import com.gewara.constant.UserType;
import com.gewara.model.acl.GewaraUser;
import com.gewara.untrans.CacheService;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.util.BaseWebUtils;
import com.gewara.web.component.LoginService;
import com.gewara.web.util.LoginUtils;

/**
 * @author acerge(acerge@163.com)
 * @since 9:37:22 PM Jul 12, 2010
 */
public class GewaUrlLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler
		implements LogoutSuccessHandler {
	private String logoutParamName = "ptn";
	protected Map<String, String> logoutUrlMap = new HashMap<String, String>();
	@Autowired@Qualifier("cacheService")
	protected CacheService cacheService;
	@Autowired@Qualifier("loginService")
	protected LoginService loginService;
	@Autowired@Qualifier("monitorService")
	protected MonitorService monitorService;
	@Autowired
	protected Config config;
	
	private boolean casSsoLogout=false;

	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
		String partner = request.getParameter(logoutParamName);
		if(StringUtils.isNotBlank(partner) && 
				StringUtils.isNotBlank(logoutUrlMap.get(partner)))
			return logoutUrlMap.get(partner);
		return super.determineTargetUrl(request, response);
	}

	public void setLogoutParamName(String logoutParamName) {
		this.logoutParamName = logoutParamName;
	}
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, 
			Authentication authentication) throws IOException, ServletException {
		doLogout(request, response, authentication);
	}
	public void doLogout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{
		String ukey = BaseWebUtils.getCookieValue(request, LoginUtils.SESS_COOKIE_NAME);
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaraUser user = null;
		if(LoginUtils.isValidSessid(ukey)){
			user = loginService.getLogonGewaraUserBySessid(ip, ukey);
			if(user!=null){
				cacheService.remove(CacheService.REGION_LOGINAUTH, LoginUtils.getCacheUkey(ukey));
				String key = LoginUtils.getRepeatKey(user.getUsertype(), user.getUsername());
				cacheService.remove(CacheService.REGION_LOGINAUTH, key);
				addMemberLogoutLog(user.getId(), user.getRealname(), ip);
			}
		}
		LoginUtils.removeLogonUkey(response);
		if(user != null && StringUtils.equals(user.getUsertype(), UserType.USER_TYPE_SSO) && isCasSsoLogout()){
			casLogout(request, response);
		}else{
			super.handle(request, response, authentication);
		}
	}
	public void addMemberLogoutLog(Long memberid, String nickname, String ip){
		Map<String, String> changeMap = new HashMap<String, String>();
		changeMap.put("nickname", nickname);
		changeMap.put("errortype", LoginUtils.ERROR_LOGOUT);
		monitorService.saveMemberLogMap(memberid, "login", changeMap, ip);
	}
	public void setLogoutUrlMap(Map<String, String> logoutUrlMap) {
		this.logoutUrlMap = logoutUrlMap;
	}
	
	public void casLogout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//TODO:MemberÔõÃ´×ö£¿£¿
		//request.getSession().invalidate();
		response.sendRedirect(config.getString("ssoValidateUrl")+"logout"+"?service=" + getPath() + config.getBasePath());
	}

	public boolean isCasSsoLogout() {
		return casSsoLogout;
	}

	public void setCasSsoLogout(boolean casSsoLogout) {
		this.casSsoLogout = casSsoLogout;
	}
	private String getPath(){
		String path = config.getString("houtaiPath");
		if(StringUtils.isBlank(path)) path = config.getAbsPath();
		return path;
	}
	
}
