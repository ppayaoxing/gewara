/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.component.logon;

import com.gewara.Config;
import com.gewara.model.acl.GewaraUser;
import com.gewara.model.acl.User;
import com.gewara.support.ErrorCode;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.RedirectUrlBuilder;
import com.gewara.web.component.LoginService;
import com.gewara.web.menu.GBMenuDataBuilder;
import com.gewara.web.menu.MenuRepository;
import com.gewara.web.support.AclService;
import com.gewara.web.support.DBFilterInvocationSecurityMetadataSource;
import com.gewara.web.util.LoginUtils;
import java.net.URLDecoder;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class CommonLogonController implements ApplicationContextAware {
	@Autowired
	private Config config;
	@Autowired(required = false)
	private LoginService loginService;
	@Autowired(required = false)
	private AclService aclService = null;
	private WebApplicationContext applicationContext;
	@Autowired(required = false)
	private SecurityMetadataSource securityMetadataSource;

	private final User getLogonUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return null;
		} else {
			if (auth.isAuthenticated() && !auth.getName().equals("anonymous")) {
				GewaraUser user = (GewaraUser) auth.getPrincipal();
				if (user instanceof User) {
					return (User) user;
				}
			}

			return null;
		}
	}

	@RequestMapping(value = { "/localLogin.xhtml" }, method = { RequestMethod.GET })
	public String login(ModelMap model, String TARGETURL) {
		model.put("TARGETURL", TARGETURL);
		return "login.vm";
	}

	@RequestMapping(value = { "/adminLocalLogin.xhtml" }, method = { RequestMethod.GET })
	public String adminLogin(HttpServletRequest request, ModelMap model, String TARGETURL) {
		if (StringUtils.isBlank(TARGETURL)) {
			TARGETURL = BaseWebUtils.getContextPath(request) + "admin/console.xhtml";
		}

		model.put("TARGETURL", TARGETURL);
		model.put("ptn", "user");
		return "login.vm";
	}

	@RequestMapping({ "/processLogon.xhtml" })
	public String proccessLogon(ModelMap model, HttpServletRequest request, HttpServletResponse response, String sessid,
			String returnUrl) throws Exception {
		ErrorCode result = this.loginService.ssoAutoLogin(request, response, sessid);
		if (result.isSuccess()) {
			if (StringUtils.isNotBlank(returnUrl)) {
				String url = URLDecoder.decode(returnUrl, "utf-8");
				return showRedirect(url, model);
			} else {
				return "redirect:/admin/console.xhtml";
			}
		} else {
			return this.forwardMessage(model, "error:" + ((Map) result.getRetval()).get("msg"));
		}
	}

	@RequestMapping({ "/casLogon.xhtml" })
	public String casLogon(ModelMap model, HttpServletRequest request, HttpServletResponse response, String sessid,
			String returnUrl) throws Exception {
		ErrorCode result = this.loginService.ssoAutoLogin(request, response, sessid);
		if (result.isSuccess()) {
			if (StringUtils.isNotBlank(returnUrl)) {
				String url = new String(Base64.decodeBase64(returnUrl), "utf-8");
				return showRedirect(url, model);
			} else {
				return "redirect:/admin/console.xhtml";
			}
		} else {
			return this.forwardMessage(model, "error:" + ((Map) result.getRetval()).get("msg"));
		}
	}

	@RequestMapping({ "/admin/console.xhtml" })
	public String adminConsole(String reload, ModelMap model) {
		User user = this.getLogonUser();
		String[] roles = StringUtils.split(user.getRolenames(), ",");
		MenuRepository repository = (MenuRepository) this.applicationContext.getServletContext()
				.getAttribute("com.gewara.web.menu.GEWA_MENU_REPOSITORY");
		if (repository == null || "true".equals(reload)) {
			repository = new MenuRepository(this.aclService.getMenuList("G"));
			this.applicationContext.getServletContext().setAttribute("com.gewara.web.menu.GEWA_MENU_REPOSITORY",
					repository);
		}

		GBMenuDataBuilder mdb = new GBMenuDataBuilder(this.config.getBasePath(), roles, repository);
		String menuData = mdb.getMenuData().toString();
		Map treeMap = mdb.getMenuTree();
		model.put("menuData", menuData);
		model.put("user", user);
		model.put("treeMap", treeMap);
		return "admin/adminConsole.vm";
	}

	@RequestMapping({ "/admin/reloadMenu.xhtml" })
	public String reload(ModelMap model) {
		((DBFilterInvocationSecurityMetadataSource) this.securityMetadataSource).init();
		MenuRepository repository = new MenuRepository(this.aclService.getMenuList("G"));
		this.applicationContext.getServletContext().setAttribute("com.gewara.web.menu.GEWA_MENU_REPOSITORY",
				repository);
		return this.forwardMessage(model, "重新载入菜单权限成功！");
	}

	@RequestMapping({ "/logOutUser.xhtml" })
	public String logOutUser(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String ukey = BaseWebUtils.getCookieValue(request, LoginUtils.SESS_COOKIE_NAME);
		if (LoginUtils.isValidSessid(ukey)) {
			this.loginService.removeInvalidSessid(ukey);
		}

		LoginUtils.removeLogonUkey(response);
		return this.forwardMessage(model, "清除用户缓存成功！");
	}

	@RequestMapping({ "/reloadUser.xhtml" })
	public String reloadUser(HttpServletRequest request, HttpServletResponse response, String loginXhtml) {
		String ukey = BaseWebUtils.getCookieValue(request, LoginUtils.SESS_COOKIE_NAME);
		if (LoginUtils.isValidSessid(ukey)) {
			this.loginService.removeInvalidSessid(ukey);
		}

		LoginUtils.removeLogonUkey(response);
		return "redirect:/" + loginXhtml;
	}

	private final String forwardMessage(ModelMap model, String msg) {
		model.put("successMsgs", msg);
		return "showResult.vm";
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = (WebApplicationContext) applicationContext;
	}

	public static final String showRedirect(String path, ModelMap model) {
		String targetUrl = RedirectUrlBuilder.getRedirectUrl(path, model);
		model.put("redirectUrl", targetUrl.toString());
		return "tempRedirect.vm";
	}
}