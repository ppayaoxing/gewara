/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.model.acl.GewaraUser;
import com.gewara.web.support.SecurityModule;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AclService<T extends SecurityModule> extends UserDetailsService {
	GewaraUser getGewaraUser(Long arg0, String arg1);

	List<T> getSecurityModuleList();

	List<T> getMenuList(String arg0);

	List<String> getRolenameList();

	void setLogonType(String arg0);

	GewaraUser loadUserByUsername(String arg0);

	boolean isCopyAuthorities();
}