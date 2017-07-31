package com.gewara.msearch.external.entity;

import java.io.Serializable;

public class GwSearchResult implements Serializable {

	private static final long serialVersionUID = 1915079466246282429L;
	
	private String name;
	private String tag;//¿‡–Õ±Í«©
	private Long relatedid;
	private String category;
	private String skey;
	private Object relatedObj; 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Long getRelatedid() {
		return relatedid;
	}
	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSkey() {
		return skey;
	}
	public void setSkey(String skey) {
		this.skey = skey;
	}
	public Object getRelatedObj() {
		return relatedObj;
	}
	public void setRelatedObj(Object relatedObj) {
		this.relatedObj = relatedObj;
	}
	
}
