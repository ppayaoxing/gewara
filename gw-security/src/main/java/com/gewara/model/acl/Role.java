/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.model.acl;

import com.gewara.model.BaseObject;
import java.io.Serializable;

public class Role extends BaseObject {
	private static final long serialVersionUID = 3690197650654049848L;
	protected Long id;
	protected String name;
	protected String description;
	protected String tag;

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public String getAuthority() {
		return this.getName();
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}