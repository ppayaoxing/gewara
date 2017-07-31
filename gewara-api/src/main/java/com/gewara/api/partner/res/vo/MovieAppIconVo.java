package com.gewara.api.partner.res.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class MovieAppIconVo extends BaseVo{

	private static final long serialVersionUID = 2578680282816728561L;
	private String id;
	private String type;
	private String tag;
	private String url;
	private Integer picwidth;
	private Integer picheight;
	private String linkUrl;
	private String description;
	private Integer showInPlayList;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getPicwidth() {
		return picwidth;
	}
	public void setPicwidth(Integer picwidth) {
		this.picwidth = picwidth;
	}
	public Integer getPicheight() {
		return picheight;
	}
	public void setPicheight(Integer picheight) {
		this.picheight = picheight;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getShowInPlayList() {
		return showInPlayList;
	}
	public void setShowInPlayList(Integer showInPlayList) {
		this.showInPlayList = showInPlayList;
	}
	@Override
	public Serializable realId() {
		return id;
	}	
}