package com.gewara.web.component.logon;

import java.net.URLDecoder;
import java.util.List;
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

import com.gewara.Config;
import com.gewara.model.acl.GewaraUser;
import com.gewara.model.acl.User;
import com.gewara.model.acl.WebModule;
import com.gewara.support.ErrorCode;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.RedirectUrlBuilder;
import com.gewara.web.component.LoginService;
import com.gewara.web.menu.GBMenuDataBuilder;
import com.gewara.web.menu.MenuRepository;
import com.gewara.web.support.AclService;
import com.gewara.web.support.DBFilterInvocationSecurityMetadataSource;
import com.gewara.web.util.LoginUtils;

@Controller
public class CommonLogonController implements ApplicationContextAware {
	@Autowired
	private Config config;
	@Autowired(required=false)
	private LoginService loginService;
	@Autowired(required=false)
	private AclService aclService = null;
	private WebApplicationContext applicationContext;
	@Autowired(required=false)
	private SecurityMetadataSource securityMetadataSource;

	private final User getLogonUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
            return null;
        }
		if (auth.isAuthenticated() && !"anonymous".equals(auth.getName())) {// 登录
			GewaraUser user = (GewaraUser) auth.getPrincipal();
			// refresh(user);
			if (user instanceof User) {
                return (User) user;
            }
		}
		return null;
	}

	@RequestMapping(value = "/localLogin.xhtml", method = RequestMethod.GET)
	public String login(ModelMap model, String TARGETURL) {
		model.put("TARGETURL", TARGETURL);
		return "login.vm";
	}

	@RequestMapping(value = "/adminLocalLogin.xhtml", method = RequestMethod.GET)
	public String adminLogin(HttpServletRequest request, ModelMap model, String TARGETURL) {
		if (StringUtils.isBlank(TARGETURL)) {
			TARGETURL = BaseWebUtils.getContextPath(request) + "admin/console.xhtml";
		}
		model.put("TARGETURL", TARGETURL);
		model.put("ptn", "user");
		return "login.vm";
	}

	@RequestMapping(value = "/processLogon.xhtml")
	public String proccessLogon(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			String sessid, String returnUrl) throws Exception {
		ErrorCode<Map> result = loginService.ssoAutoLogin(request, response, sessid);
		if (result.isSuccess()) {
			if (StringUtils.isNotBlank(returnUrl)) {
				String url = URLDecoder.decode(returnUrl, "utf-8");
				return showRedirect(url, model);
			}
			return "redirect:/admin/console.xhtml";
		} else {
			return forwardMessage(model, "error:" + result.getRetval().get("msg"));
		}
	}

	@RequestMapping(value = "/casLogon.xhtml")
	public String casLogon(ModelMap model, HttpServletRequest request, HttpServletResponse response, String sessid,
			String returnUrl) throws Exception {
		ErrorCode<Map> result = loginService.ssoAutoLogin(request, response, sessid);
		if (result.isSuccess()) {
			if (StringUtils.isNotBlank(returnUrl)) {
				String url = new String(Base64.decodeBase64(returnUrl), "utf-8");
				return showRedirect(url, model);
			}
			return "redirect:/admin/console.xhtml";
		} else {
			return forwardMessage(model, "error:" + result.getRetval().get("msg"));
		}
	}
	@RequestMapping("/admin/console.xhtml")
	public String adminConsole(String reload, ModelMap model) {
		User user = getLogonUser();
		String[] roles = StringUtils.split(user.getRolenames(), ",");
		MenuRepository repository = (MenuRepository) applicationContext.getServletContext().getAttribute(
				MenuRepository.GEWA_MENU_REPOSITORY_KEY);
		if (repository == null || "true".equals(reload)) {
			repository = new MenuRepository(aclService.getMenuList(WebModule.TAG_GEWA));
			applicationContext.getServletContext().setAttribute(MenuRepository.GEWA_MENU_REPOSITORY_KEY, repository);
		}
		GBMenuDataBuilder mdb = new GBMenuDataBuilder(config.getBasePath(), roles, repository);
		String menuData = mdb.getMenuData().toString();
		Map<Map, List<Map>> treeMap = mdb.getMenuTree();
		model.put("menuData", menuData);
		model.put("user", user);
		model.put("treeMap", treeMap);

		return "admin/adminConsole.vm";
	}

	@RequestMapping("/admin/reloadMenu.xhtml")
	public String reload(ModelMap model) {
		((DBFilterInvocationSecurityMetadataSource) securityMetadataSource).init();
		MenuRepository repository = new MenuRepository(aclService.getMenuList(WebModule.TAG_GEWA));
		applicationContext.getServletContext().setAttribute(MenuRepository.GEWA_MENU_REPOSITORY_KEY, repository);
		return forwardMessage(model, "重新载入菜单权限成功！");
	}

	/**
	 * 注销本应用的cookie
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/logOutUser.xhtml")
	public String logOutUser(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String ukey = BaseWebUtils.getCookieValue(request, LoginUtils.SESS_COOKIE_NAME);
		if (LoginUtils.isValidSessid(ukey)) {
			loginService.removeInvalidSessid(ukey);
		}
		LoginUtils.removeLogonUkey(response);
		return forwardMessage(model, "清除用户缓存成功！");
	}

	/**
	 * 注销本应用的cookie
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/reloadUser.xhtml")
	public String reloadUser(HttpServletRequest request, HttpServletResponse response, String loginXhtml) {
		String ukey = BaseWebUtils.getCookieValue(request, LoginUtils.SESS_COOKIE_NAME);
		if (LoginUtils.isValidSessid(ukey)) {
			loginService.removeInvalidSessid(ukey);
		}
		LoginUtils.removeLogonUkey(response);
		return "redirect:/" + loginXhtml;
	}

	private final String forwardMessage(ModelMap model, String msg) {
		model.put("successMsgs", msg);
		return "showResult.vm";
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = (WebApplicationContext) applicationContext;

	}

	public static final String showRedirect(String path, ModelMap model) {
		String targetUrl = RedirectUrlBuilder.getRedirectUrl(path, model);
		model.put("redirectUrl", targetUrl.toString());
		return "tempRedirect.vm";
	}

}
