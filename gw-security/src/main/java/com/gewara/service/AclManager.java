package com.gewara.service;

import java.util.List;

import com.gewara.model.acl.Role;
import com.gewara.model.acl.User;
import com.gewara.model.acl.WebModule;

/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28下午02:05:17
 */
public interface AclManager {
	Role getRole(String rolename);
	void removeRole(String rolename);
	Role addRole(String rolename, String description, String tag);
	List<WebModule> getMainMenuList(String tag, boolean showAll);
	String getMainMenuNextSubCode(String mainmenucode);
	String getMainMenuNextCode(String tag);
	List<WebModule> getSubMenuList(String tag, String mainmenucode, boolean showAll);
	List<Role> getRoleListByTag(String tag);
	/**
	 * 获取未关联某角色的用户
	 * @param roleId
	 * @return
	 */
	List<User> getUnrelatedUsersByRole(Long roleId);
	/**
	 * 获取关联角色的用户
	 * @param roleId
	 * @return
	 */
	List<User> getRelatedUsersByRole(Long roleId);
	List<Long> getRelatedModulesByRole(Long roleId);
	//List<Long> getUnrelatedModulesByRole(Long roleId);

	//WebModule getWebModuleBySubMenucode(String submenucode);
}
