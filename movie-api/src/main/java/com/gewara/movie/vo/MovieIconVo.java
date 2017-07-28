/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class MovieIconVo extends BaseVo implements Serializable {
	private static final long serialVersionUID = -8402288934867531257L;
	private String id;
	private Long relatedid;
	private String titleIcon;
	private String title;
	private String extraType;
	private String contentIcon;
	private String content;
	private String link;
	private String updatetime;
	private Integer titleIconHeight;
	private Integer titleIconWidth;
	private Integer contentIconHeight;
	private Integer contentIconWidth;
	private Integer orderSort;

	public Integer getTitleIconHeight() {
		return this.titleIconHeight;
	}

	public void setTitleIconHeight(Integer titleIconHeight) {
		this.titleIconHeight = titleIconHeight;
	}

	public Integer getTitleIconWidth() {
		return this.titleIconWidth;
	}

	public void setTitleIconWidth(Integer titleIconWidth) {
		this.titleIconWidth = titleIconWidth;
	}

	public Integer getContentIconHeight() {
		return this.contentIconHeight;
	}

	public void setContentIconHeight(Integer contentIconHeight) {
		this.contentIconHeight = contentIconHeight;
	}

	public Integer getContentIconWidth() {
		return this.contentIconWidth;
	}

	public void setContentIconWidth(Integer contentIconWidth) {
		this.contentIconWidth = contentIconWidth;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getTitleIcon() {
		return this.titleIcon;
	}

	public void setTitleIcon(String titleIcon) {
		this.titleIcon = titleIcon;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExtraType() {
		return this.extraType;
	}

	public void setExtraType(String extraType) {
		this.extraType = extraType;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentIcon() {
		return this.contentIcon;
	}

	public void setContentIcon(String contentIcon) {
		this.contentIcon = contentIcon;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public Serializable realId() {
		return null;
	}

	public Integer getOrderSort() {
		return this.orderSort;
	}

	public void setOrderSort(Integer orderSort) {
		this.orderSort = orderSort;
	}
}