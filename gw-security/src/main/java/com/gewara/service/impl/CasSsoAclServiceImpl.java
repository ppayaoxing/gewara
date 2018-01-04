package com.gewara.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.gewara.Config;
import com.gewara.model.acl.GewaraUser;
import com.gewara.model.acl.User;
import com.gewara.sso.client.cas.GewaraSsoClient;
import com.gewara.sso.model.WebModule;
import com.gewara.util.BeanUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.AclService;

public class CasSsoAclServiceImpl extends AbstractAclService implements AclService<WebModule>, UserDetailsService {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	@Autowired
	private Config config;
	private List<WebModule> remoteModuleList = new ArrayList<WebModule>();
	public CasSsoAclServiceImpl(){
		this.copyAuthorities = true;
	}
	@Override
	public List<WebModule> getMenuList(String tag){
		List<WebModule> menuList = new LinkedList<WebModule>();
		for(WebModule module: remoteModuleList){
			if(module.getTag().equals(tag) && "1".equals(module.getDisplay())) {
                menuList.add(module);
            }
		}
		return menuList;
	}
	@Override
	public List<WebModule> getSecurityModuleList(){
		String url = config.getString("ssoResoureUrl");
		if(StringUtils.isBlank(url)){
			dbLogger.warn("请检查config.xml中ssoResoureUrl配置是否正确！");
		}
		try{
			remoteModuleList = GewaraSsoClient.findResoureByName(url, Config.SYSTEMID);
		}catch(Exception e){
			dbLogger.warn("单点登录menu菜单获取不到：请检查config中ssoResoureUrl配置是否正确！", e);
		}
		
		return remoteModuleList;
	}
	@Override
	public GewaraUser getGewaraUser(Long userid, String logonType) {
		return baseDao.getObject(User.class, userid);
	}
	@Override
	public List<String> getRolenameList() {
		if(remoteModuleList.isEmpty()) {
            getSecurityModuleList();
        }
		return Arrays.asList(StringUtils.join(BeanUtil.getBeanPropertyList(remoteModuleList, Long.class, "id", true), ",").split(","));
	}
	
}
