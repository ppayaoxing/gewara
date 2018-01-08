package com.gewara.service;

import java.util.List;

import com.gewara.model.acl.Role;

/**
 * @author sunder
 */
public interface AuthService {
	/**
	 * @param userid
	 * @return
	 */
	List<String> getUserRoles(Long userid);

	/**
	 * @param moduleid
	 * @return
	 */
	List<String> getModuleRoles(Long moduleid);

	/**
	 * @param tag
	 * @return
	 */
	List<Role> getRoleListByTag(String tag);
}
