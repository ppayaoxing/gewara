/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.model.acl;

import com.gewara.model.acl.GewaraUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

public class User extends GewaraUser {
	private static final long serialVersionUID = 3832626162173359411L;
	private Long id;
	private String username;
	private String password;
	private String nickname;
	private String accountEnabled;
	private String citycode;
	private String mobile;
	private String rolenames;
	private String usertype;
	private String email;
	private List<GrantedAuthority> tmpAuth;

	public User() {
	}

	public final List<GrantedAuthority> getAuthorities() {
		if (this.tmpAuth != null) {
			return this.tmpAuth;
		} else {
			this.tmpAuth = new ArrayList();
			if (StringUtils.isBlank(this.rolenames)) {
				return this.tmpAuth;
			} else {
				this.tmpAuth.addAll(AuthorityUtils.createAuthorityList(StringUtils.split(this.rolenames, ",")));
				return this.tmpAuth;
			}
		}
	}

	public final String getRolesString() {
		return this.rolenames;
	}

	public final boolean isRole(String rolename) {
		String[] roles = StringUtils.split(this.rolenames, ",");
		return ArrayUtils.contains(roles, rolename);
	}

	public String getRealname() {
		if (StringUtils.isBlank(this.username)) {
			return null;
		} else {
			int index = this.username.indexOf(64);
			return index > 0 ? "m-" + this.username.substring(0, index) : "m-" + this.username;
		}
	}

	public User(String username) {
		this.username = StringUtils.lowerCase(username);
	}

	public Long getId() {
		return this.id;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Serializable realId() {
		return this.id;
	}

	public boolean isEnabled() {
		return "Y".equals(this.accountEnabled);
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRolenames() {
		return this.rolenames;
	}

	public void setRolenames(String rolenames) {
		this.rolenames = rolenames;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getAccountEnabled() {
		return this.accountEnabled;
	}

	public void setAccountEnabled(String accountEnabled) {
		this.accountEnabled = accountEnabled;
	}

	public void setAuthorities(List<GrantedAuthority> tmpAuth) {
		this.tmpAuth = tmpAuth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}