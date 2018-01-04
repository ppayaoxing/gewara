package com.gewara.web.support;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gewara.model.acl.GewaraUser;


public interface AclService<T extends SecurityModule> extends UserDetailsService{
	GewaraUser getGewaraUser(Long userid, String logonType);
	/**
	 * 鑾峰彇闈濧PI鐨勬嫤鎴ā鍧�
	 * @return
	 */
	List<T> getSecurityModuleList();
	List<T> getMenuList(String tag);
	List<String> getRolenameList();
	void setLogonType(String ptn);
	
	
	/**
	 * 鏍规嵁鐢ㄦ埛鍚嶈幏鍙栫敤鎴峰璞�
	 * @param name
	 * @param logonType
	 * @return
	 */
	@Override
	GewaraUser loadUserByUsername(String name);
	boolean isCopyAuthorities();
}
