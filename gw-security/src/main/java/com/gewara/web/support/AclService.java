package com.gewara.web.support;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gewara.model.acl.GewaraUser;


public interface AclService<T extends SecurityModule> extends UserDetailsService{
	GewaraUser getGewaraUser(Long userid, String logonType);
	/**
	 * 获取非API的拦截模块
	 * @return
	 */
	List<T> getSecurityModuleList();
	List<T> getMenuList(String tag);
	List<String> getRolenameList();
	void setLogonType(String ptn);
	
	
	/**
	 * 根据用户名获取用户对象
	 * @param name
	 * @param logonType
	 * @return
	 */
	@Override
	GewaraUser loadUserByUsername(String name);
	boolean isCopyAuthorities();
}
