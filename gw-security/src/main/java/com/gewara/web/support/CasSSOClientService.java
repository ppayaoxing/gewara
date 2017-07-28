/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.Config;
import com.gewara.model.acl.GewaraUser;
import com.gewara.model.acl.User;
import com.gewara.service.DaoService;
import com.gewara.sso.client.cas.GewaraSsoClient;
import com.gewara.support.ErrorCode;
import com.gewara.util.BeanUtil;
import com.gewara.util.StringUtil;
import com.gewara.web.support.AbstractSSOClientService;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.Assert;

public class CasSSOClientService extends AbstractSSOClientService implements InitializingBean {
	private GewaraSsoClient ssoClient;
	@Autowired
	@Qualifier("daoService")
	private DaoService daoService;

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public void afterPropertiesSet() {
		Assert.notNull(this.aclService, "必须提供aclService实现！");
		String validateUrl = this.config.getString("ssoValidateUrl");
		this.ssoClient = new GewaraSsoClient(this.config.getString("ssoLoginUrl"), this.getPath(), validateUrl);
	}

	public String getLoginUrl(HttpServletRequest request) {
		String url = this.config.getString("ssoLoginUrl") + "?";
		url = url + "service=" + this.getPath() + this.config.getBasePath() + "casLogon.xhtml?";
		String callback = "system=" + Config.SYSTEMID + "&returnUrl=";
		String returnUrl = request.getParameter(this.targetUrlParameter);
		if (StringUtils.isBlank(returnUrl)) {
			String contextPath = request.getContextPath();
			returnUrl = request.getRequestURI().substring(contextPath.length());
			String qstr = request.getQueryString();
			if (StringUtils.isNotBlank(qstr)) {
				try {
					returnUrl = returnUrl + "?" + URLDecoder.decode(qstr, "utf-8");
				} catch (UnsupportedEncodingException arg9) {
					;
				}
			}

			try {
				callback = callback + Base64.encodeBase64URLSafeString(returnUrl.getBytes("utf-8"));
			} catch (UnsupportedEncodingException arg8) {
				;
			}
		}

		try {
			callback = URLDecoder.decode(callback, "utf-8");
			callback = URLEncoder.encode(callback, "utf-8");
		} catch (UnsupportedEncodingException arg7) {
			;
		}

		url = url + callback;
		return url;
	}

	public ErrorCode<GewaraUser> getGewaraUser(HttpServletRequest request, HttpServletResponse response,
			String sessid) {
		Assertion assertion = null;

		try {
			assertion = this.ssoClient.validationSso(request, response, this.getPath(), this.config.getBasePath());
			List e = this.ssoClient.loadUserAttributes(assertion);
			GewaraUser user = this.createCasUser(assertion);
			if (user == null) {
				return ErrorCode.getFailure("用户信息未同步，请同步用户信息！！");
			} else {
				if (this.aclService.isCopyAuthorities()) {
					StringBuffer rolenames = new StringBuffer();
					ArrayList tmpAuth = new ArrayList();
					Iterator arg8 = e.iterator();

					while (arg8.hasNext()) {
						Object key = arg8.next();
						String role = key.toString().trim();
						if (!StringUtils.isBlank(role)) {
							rolenames.append(role + ",");
							tmpAuth.add(new SimpleGrantedAuthority(role));
						}
					}

					BeanUtil.set(user, "rolenames", rolenames.toString());
					user.getAuthorities();
				}

				BeanUtil.set(user, "usertype", "sso");
				return ErrorCode.getSuccessReturn(user);
			}
		} catch (Exception arg11) {
			this.dbLogger.warn(arg11, 10);
			return ErrorCode.getFailure("单点登录失败,请单点登录配置！！");
		}
	}

	private String getPath() {
		String path = this.config.getString("houtaiPath");
		if (StringUtils.isBlank(path)) {
			path = this.config.getAbsPath();
		}

		return path;
	}

	private GewaraUser createCasUser(Assertion assertion) {
		User user = (User) this.daoService.getObjectByUkey(User.class, "username", assertion.getPrincipal().getName());
		Long userid = Long.valueOf(Long.parseLong(GewaraSsoClient.loadUserAttributes(assertion, "id")));
		boolean update = false;
		if (user == null) {
			user = (User) this.daoService.getObject(User.class, userid);
			update = true;
		}

		if (user == null) {
			user = new User();
			user.setUsername(assertion.getPrincipal().getName());
			user.setPassword(StringUtil.getRandomString(10));
			user.setId(userid);
			user.setAccountEnabled("Y");
			update = true;
		}

		if (update) {
			user.setNickname(GewaraSsoClient.loadUserAttributes(assertion, "displayName"));
			user.setEmail(GewaraSsoClient.loadUserAttributes(assertion, "mail"));
			user.setMobile(GewaraSsoClient.loadUserAttributes(assertion, "mobile"));
			user.setUsertype("sso");
			user = (User) this.daoService.saveObject(user);
		}

		return user;
	}
}