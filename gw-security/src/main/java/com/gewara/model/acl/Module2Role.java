/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.model.acl;

import com.gewara.model.BaseObject;
import com.gewara.model.acl.Role;
import com.gewara.model.acl.WebModule;
import java.io.Serializable;

public class Module2Role extends BaseObject {
	private static final long serialVersionUID = -5801762779064940301L;
	private Long id;
	private WebModule module;
	private Role role;

	public Module2Role() {
	}

	public Module2Role(WebModule module, Role role) {
		this.module = module;
		this.role = role;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public WebModule getModule() {
		return this.module;
	}

	public void setModule(WebModule module) {
		this.module = module;
	}
}