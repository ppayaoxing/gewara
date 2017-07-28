/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external.entity;

import java.io.Serializable;

public class GwSearchResult implements Serializable {
	private static final long serialVersionUID = 1915079466246282429L;
	private String name;
	private String tag;
	private Long relatedid;
	private String category;
	private String skey;
	private Object relatedObj;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSkey() {
		return this.skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public Object getRelatedObj() {
		return this.relatedObj;
	}

	public void setRelatedObj(Object relatedObj) {
		this.relatedObj = relatedObj;
	}
}