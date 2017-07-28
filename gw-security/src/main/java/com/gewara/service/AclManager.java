/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.service;

import com.gewara.model.acl.Role;
import com.gewara.model.acl.User;
import com.gewara.model.acl.WebModule;
import java.util.List;

public interface AclManager {
	Role getRole(String arg0);

	void removeRole(String arg0);

	Role addRole(String arg0, String arg1, String arg2);

	List<WebModule> getMainMenuList(String arg0, boolean arg1);

	String getMainMenuNextSubCode(String arg0);

	String getMainMenuNextCode(String arg0);

	List<WebModule> getSubMenuList(String arg0, String arg1, boolean arg2);

	List<Role> getRoleListByTag(String arg0);

	List<User> getUnrelatedUsersByRole(Long arg0);

	List<User> getRelatedUsersByRole(Long arg0);

	List<Long> getRelatedModulesByRole(Long arg0);
}