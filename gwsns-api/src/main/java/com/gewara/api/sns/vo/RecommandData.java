package com.gewara.api.sns.vo;

import java.io.Serializable;

public class RecommandData implements Serializable {
	private static final long serialVersionUID = -7484127957700753034L;
	private String sort;
	private String id;
	private String url;
	private String link;
	private String width;
	private String height;
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
	
}
