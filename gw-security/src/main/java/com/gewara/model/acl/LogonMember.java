/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.model.acl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class LogonMember implements UserDetails {
	private static final long serialVersionUID = 6078080839080249253L;
	public static final String USER_TYPE_SSO = "sso";
	public static final String USER_TYPE_USER = "user";
	public static final String USER_TYPE_MEMBER = "member";
	public static final String USER_TYPE_PARTNER = "partner";
	private Long memberid;
	private String nickname;
	private String rejected;
	private List<GrantedAuthority> authList = AuthorityUtils.createAuthorityList(new String[] { "member" });

	public final boolean isAccountNonExpired() {
		return true;
	}

	public final boolean isAccountNonLocked() {
		return true;
	}

	public final boolean isCredentialsNonExpired() {
		return true;
	}

	public List<GrantedAuthority> getAuthorities() {
		return new ArrayList(this.authList);
	}

	public Long getId() {
		return this.memberid;
	}

	public String getUsertype() {
		return "member";
	}

	public String getPassword() {
		return null;
	}

	public String getUsername() {
		return this.nickname;
	}

	public boolean isEnabled() {
		return "N".equals(this.rejected);
	}
}