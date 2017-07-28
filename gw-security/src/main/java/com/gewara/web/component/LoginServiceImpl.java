/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.component;

import com.gewara.Config;
import com.gewara.model.acl.GewaraUser;
import com.gewara.model.acl.User;
import com.gewara.support.ErrorCode;
import com.gewara.untrans.CacheService;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.util.BeanUtil;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import com.gewara.web.component.LoginService;
import com.gewara.web.support.CachedAuthentication;
import com.gewara.web.support.GewaAuthenticationSuccessHandler;
import com.gewara.web.support.SSOAuthenticationToken;
import com.gewara.web.support.SSOClientService;
import com.gewara.web.util.LoginUtils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class LoginServiceImpl implements LoginService {
	private final transient GewaLogger dbLogger = LoggerUtils.getLogger(this.getClass());
	@Autowired
	@Qualifier("authenticationManager")
	protected ProviderManager authenticationManager;
	@Autowired
	@Qualifier("successHandler")
	protected GewaAuthenticationSuccessHandler successHandler;
	protected CacheService cacheService;
	protected SSOClientService ssoClientService;
	@Autowired
	@Qualifier("monitorService")
	protected MonitorService monitorService;
	private int allowIpNum = 2;

	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	public void setSsoClientService(SSOClientService ssoClientService) {
		this.ssoClientService = ssoClientService;
	}

	public void setAllowIpNum(int allowIpNum) {
		this.allowIpNum = allowIpNum;
	}

	public ErrorCode<Map> autoLogin(HttpServletRequest request, HttpServletResponse response, String username,
			String password) {
		if (!StringUtils.isBlank(username) && !StringUtils.isBlank(password)) {
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, password);
			return this.autoLogin(request, response, auth);
		} else {
			return ErrorCode.getFailure("用户名密码必填！");
		}
	}

	public ErrorCode<Map> ssoAutoLogin(HttpServletRequest request, HttpServletResponse response, String sessid) {
		ErrorCode result = this.ssoClientService.getGewaraUser(request, response, sessid);
		HashMap loginResult = new HashMap();
		if (result.isSuccess()) {
			SSOAuthenticationToken auth = new SSOAuthenticationToken((GewaraUser) result.getRetval(), Config.SYSTEMID,
					((GewaraUser) result.getRetval()).getAuthorities());
			return this.autoLogin(request, response, auth);
		} else {
			loginResult.put("msg", result.getMsg());
			return ErrorCode.getFailureReturn(loginResult);
		}
	}

	protected ErrorCode<Map> autoLogin(HttpServletRequest request, HttpServletResponse response, Authentication auth) {
		HashMap errorMap = new HashMap();

		try {
			auth = this.authenticationManager.authenticate(auth);
			if (auth.isAuthenticated()) {
				this.successHandler.processSuccess(request, response, auth);
				Map e = BeanUtil.getBeanMapWithKey(auth.getPrincipal(), new String[] { "realname", "id", "mobile" });
				if (StringUtils.isNotBlank((String) e.get("mobile"))) {
					e.put("isMobile", Boolean.valueOf(true));
				} else {
					e.put("isMobile", Boolean.valueOf(false));
				}

				return ErrorCode.getSuccessReturn(e);
			}

			errorMap.put("j_username", "用户名或密码错误！");
		} catch (DisabledException arg5) {
			errorMap.put("j_username", "你的用户被禁用，请联系客服！");
		} catch (AuthenticationServiceException arg6) {
			errorMap.put("j_username", "你的账号不存在！");
		} catch (BadCredentialsException arg7) {
			errorMap.put("j_password", "密码错误！");
		} catch (Exception arg8) {
			this.dbLogger.warn("", arg8, 15);
			errorMap.put("j_username", "用户名或密码错误！");
		}

		return ErrorCode.getFailureReturn(errorMap);
	}

	public GewaraUser getLogonGewaraUserBySessid(String ip, String sessid) {
		Authentication auth = this.loadAuthentication(ip, sessid);
		return auth != null ? (GewaraUser) auth.getPrincipal() : null;
	}

	public Authentication loadAuthentication(String ip, String sessid) {
		if (!LoginUtils.isValidSessid(sessid)) {
			return null;
		} else {
			String ukey = LoginUtils.getCacheUkey(sessid);
			CachedAuthentication ca = (CachedAuthentication) this.cacheService.get("loginAuth", ukey);
			if (ca != null) {
				if (!StringUtils.contains(ca.getIp(), ip)) {
					HashMap entry = new HashMap();
					entry.put("oldip", ca.getIp());
					entry.put("newip", ip);
					entry.put("errortype", "ipChange");
					entry.put("username", ca.getAuthentication().getName());
					entry.put("usertype", ca.getAuthentication().getPrincipal().getClass().getName());
					Long memberid = ((GewaraUser) ca.getAuthentication().getPrincipal()).getId();
					this.monitorService.saveMemberLogMap(memberid, "login", entry, ip);
					this.dbLogger.warn("登录IP不匹配，" + ca.getAuthentication().getName() + ":" + ca.getIp() + "---->" + ip);
					if (this.cannotChangeIp(ca.getAuthentication().getPrincipal(), ip)) {
						return null;
					}

					if (StringUtils.split(ca.getIp(), ",").length >= this.allowIpNum) {
						this.cacheService.remove("loginAuth", ukey);
						return null;
					}

					ca.setIp(ca.getIp() + "," + ip);
					this.cacheService.set("loginAuth", ukey, ca);
				}

				if (ca.getTimeout() != null && ca.getTimeout().longValue() < System.currentTimeMillis() + 1200000L) {
					this.cacheService.set("loginAuth", ukey, ca);
				}

				return ca.getAuthentication();
			} else {
				return null;
			}
		}
	}

	protected boolean cannotChangeIp(Object principal, String ip) {
		return principal != null && principal instanceof User && !GewaIpConfig.isOfficeIp(ip);
	}

	public boolean isGewaraUserLogon(HttpServletRequest request, String sessid) {
		CachedAuthentication ca = (CachedAuthentication) this.cacheService.get("loginAuth",
				LoginUtils.getCacheUkey(sessid));
		return ca != null;
	}

	public void removeInvalidSessid(String sessid) {
		this.cacheService.remove("loginAuth", LoginUtils.getCacheUkey(sessid));
	}
}