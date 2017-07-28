/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.service.impl;

import com.gewara.Config;
import com.gewara.model.acl.GewaraUser;
import com.gewara.model.acl.User;
import com.gewara.service.impl.AbstractAclService;
import com.gewara.sso.client.cas.GewaraSsoClient;
import com.gewara.sso.model.WebModule;
import com.gewara.util.BeanUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.AclService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CasSsoAclServiceImpl extends AbstractAclService implements AclService<WebModule>, UserDetailsService {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	@Autowired
	private Config config;
	private List<WebModule> remoteModuleList = new ArrayList();

	public CasSsoAclServiceImpl() {
		this.copyAuthorities = true;
	}

	public List<WebModule> getMenuList(String tag) {
		LinkedList menuList = new LinkedList();
		Iterator arg2 = this.remoteModuleList.iterator();

		while (arg2.hasNext()) {
			WebModule module = (WebModule) arg2.next();
			if (module.getTag().equals(tag) && module.getDisplay().equals("1")) {
				menuList.add(module);
			}
		}

		return menuList;
	}

	public List<WebModule> getSecurityModuleList() {
		String url = this.config.getString("ssoResoureUrl");
		if (StringUtils.isBlank(url)) {
			this.dbLogger.warn("请检查config.xml中ssoResoureUrl配置是否正确！");
		}

		try {
			this.remoteModuleList = GewaraSsoClient.findResoureByName(url, Config.SYSTEMID);
		} catch (Exception arg2) {
			this.dbLogger.warn("单点登录menu菜单获取不到：请检查config中ssoResoureUrl配置是否正确！", arg2);
		}

		return this.remoteModuleList;
	}

	public GewaraUser getGewaraUser(Long userid, String logonType) {
		return (GewaraUser) this.baseDao.getObject(User.class, userid);
	}

	public List<String> getRolenameList() {
		if (this.remoteModuleList.isEmpty()) {
			this.getSecurityModuleList();
		}

		return Arrays.asList(StringUtils
				.join(BeanUtil.getBeanPropertyList(this.remoteModuleList, Long.class, "id", true), ",").split(","));
	}
}