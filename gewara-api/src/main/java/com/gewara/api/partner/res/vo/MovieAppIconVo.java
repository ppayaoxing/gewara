/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class MovieAppIconVo extends BaseVo {
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
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPicwidth() {
		return this.picwidth;
	}

	public void setPicwidth(Integer picwidth) {
		this.picwidth = picwidth;
	}

	public Integer getPicheight() {
		return this.picheight;
	}

	public void setPicheight(Integer picheight) {
		this.picheight = picheight;
	}

	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getShowInPlayList() {
		return this.showInPlayList;
	}

	public void setShowInPlayList(Integer showInPlayList) {
		this.showInPlayList = showInPlayList;
	}

	public Serializable realId() {
		return this.id;
	}
}