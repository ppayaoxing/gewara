/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin.friendcard;

import java.sql.Timestamp;

public class CreateFriendCardCmd {
	private Timestamp starttime;
	private Timestamp endtime;
	private String title;
	private String notice;
	private String description;
	private Integer get_limit;
	private String center_title;
	private String center_sub_title;
	private String center_url;
	private String accept_category;
	private String reject_category;
	private String abstractText;
	private String icon;
	private String img;
	private String imgText;

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNotice() {
		return this.notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getGet_limit() {
		return this.get_limit;
	}

	public void setGet_limit(Integer get_limit) {
		this.get_limit = get_limit;
	}

	public String getCenter_title() {
		return this.center_title;
	}

	public void setCenter_title(String center_title) {
		this.center_title = center_title;
	}

	public String getCenter_sub_title() {
		return this.center_sub_title;
	}

	public void setCenter_sub_title(String center_sub_title) {
		this.center_sub_title = center_sub_title;
	}

	public String getCenter_url() {
		return this.center_url;
	}

	public void setCenter_url(String center_url) {
		this.center_url = center_url;
	}

	public String getAbstractText() {
		return this.abstractText;
	}

	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImgText() {
		return this.imgText;
	}

	public void setImgText(String imgText) {
		this.imgText = imgText;
	}

	public String getAccept_category() {
		return this.accept_category;
	}

	public void setAccept_category(String accept_category) {
		this.accept_category = accept_category;
	}

	public String getReject_category() {
		return this.reject_category;
	}

	public void setReject_category(String reject_category) {
		this.reject_category = reject_category;
	}
}