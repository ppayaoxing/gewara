package com.gewara.api.activity.domain;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class ActivityInterestVo extends BaseVo{

	private static final long serialVersionUID = -4749128924546836166L;
	
	private Long id;
	private String sign;
	private String signname;
	private String logo;
	private String title;
	private String status;
	private String otherinfo;

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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getSignname() {
		return signname;
	}

	public void setSignname(String signname) {
		this.signname = signname;
	}

}
