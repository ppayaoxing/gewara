/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.content.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class PictureVo extends BaseVo {
	private static final long serialVersionUID = 4914995483381697551L;
	private Long id;
	private String tag;
	private Long relatedid;
	private String picturename;
	private String description;
	private String category;
	private Long categoryid;
	private String name;
	private Timestamp posttime;
	private Long memberid;
	private String memberType;
	private Integer clickedtimes;
	private Integer picwidth;
	private Integer picheight;
	private String pictureUrl;

	public Serializable realId() {
		return this.id;
	}

	public Integer getClickedtimes() {
		return this.clickedtimes;
	}

	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public String getPicturename() {
		return this.picturename;
	}

	public void setPicturename(String picturename) {
		this.picturename = picturename;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getLogo() {
		return this.picturename;
	}

	public String getLimg() {
		return this.picturename;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getPosttime() {
		return this.posttime;
	}

	public void setPosttime(Timestamp posttime) {
		this.posttime = posttime;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getMemberType() {
		return this.memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public boolean hasMemberType(String type) {
		return StringUtils.equals(this.memberType, type);
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

	public Long getPictureid() {
		return this.id;
	}

	public Integer getPicw() {
		return this.picwidth;
	}

	public Integer getPich() {
		return this.picheight;
	}

	public String getPictureUrl() {
		return this.pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
}