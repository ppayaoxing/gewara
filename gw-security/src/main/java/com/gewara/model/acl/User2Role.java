/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.model.acl;

import com.gewara.model.BaseObject;
import com.gewara.model.acl.Role;
import java.io.Serializable;

public class User2Role extends BaseObject {
	private static final long serialVersionUID = -5801762779064940301L;
	private Long id;
	private Long userid;
	private Role role;

	public User2Role() {
	}

	public User2Role(Long userid, Role role) {
		this.userid = userid;
		this.role = role;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Serializable realId() {
		return this.id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}