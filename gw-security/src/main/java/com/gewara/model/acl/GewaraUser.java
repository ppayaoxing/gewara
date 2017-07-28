/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.model.acl;

import com.gewara.model.BaseObject;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class GewaraUser extends BaseObject implements UserDetails {
	private static final long serialVersionUID = 6078080839080249253L;

	public final boolean isAccountNonExpired() {
		return true;
	}

	public final boolean isAccountNonLocked() {
		return true;
	}

	public final boolean isCredentialsNonExpired() {
		return true;
	}

	public abstract List<GrantedAuthority> getAuthorities();

	public abstract boolean isRole(String arg0);

	public abstract String getRolesString();

	public abstract String getRealname();

	public abstract Long getId();

	public abstract String getUsertype();
}