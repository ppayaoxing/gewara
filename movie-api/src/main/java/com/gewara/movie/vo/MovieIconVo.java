package com.gewara.movie.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class MovieIconVo extends BaseVo implements Serializable {
	private static final long serialVersionUID = -8402288934867531257L;
	private String id;
	private Long relatedid;
	private String titleIcon;
	private String title;
	private String extraType; // txt:文字 icon:图标 url:链接
	private String contentIcon;
	private String content;
	private String link;
	private String updatetime;
	private Integer titleIconHeight;
	private Integer titleIconWidth;
	private Integer contentIconHeight;
	private Integer contentIconWidth;
	// 排序
	private Integer orderSort;

	public Integer getTitleIconHeight() {
		return titleIconHeight;
	}

	public void setTitleIconHeight(Integer titleIconHeight) {
		this.titleIconHeight = titleIconHeight;
	}

	public Integer getTitleIconWidth() {
		return titleIconWidth;
	}

	public void setTitleIconWidth(Integer titleIconWidth) {
		this.titleIconWidth = titleIconWidth;
	}

	public Integer getContentIconHeight() {
		return contentIconHeight;
	}

	public void setContentIconHeight(Integer contentIconHeight) {
		this.contentIconHeight = contentIconHeight;
	}

	public Integer getContentIconWidth() {
		return contentIconWidth;
	}

	public void setContentIconWidth(Integer contentIconWidth) {
		this.contentIconWidth = contentIconWidth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getRelatedid() {
		return relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getTitleIcon() {
		return titleIcon;
	}

	public void setTitleIcon(String titleIcon) {
		this.titleIcon = titleIcon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExtraType() {
		return extraType;
	}

	public void setExtraType(String extraType) {
		this.extraType = extraType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentIcon() {
		return contentIcon;
	}

	public void setContentIcon(String contentIcon) {
		this.contentIcon = contentIcon;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getOrderSort() {
		return orderSort;
	}

	public void setOrderSort(Integer orderSort) {
		this.orderSort = orderSort;
	}

}
