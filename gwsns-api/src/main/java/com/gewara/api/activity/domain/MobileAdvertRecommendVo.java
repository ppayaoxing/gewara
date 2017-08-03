package com.gewara.api.activity.domain;

import java.io.Serializable;

import com.gewara.api.activity.ApiObject;


public class MobileAdvertRecommendVo extends ApiObject {

	private static final long serialVersionUID = 973080700919329467L;

	private Long id;
	
	/**
	 * 活动id
	 */
	private Long relatedid;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 链接
	 */
	private String link;

	/**
	 * logo地址
	 */
	private String logo;
	
	/**
	 * 排序值
	 */
	private Integer ordernum;
	
	/**
	 * 地区代码(多个值以逗号隔开)
	 */
	private String citycode;
	
	@Override
	public Serializable realId() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRelatedid() {
		return relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

}
