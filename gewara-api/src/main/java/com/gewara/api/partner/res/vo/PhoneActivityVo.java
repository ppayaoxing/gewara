/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.util.Date;

public class PhoneActivityVo extends BaseVo {
	private static final long serialVersionUID = -4047545723681730742L;
	private String id;
	private String title;
	private String logo;
	private String fullLogo;
	private Date starttime;
	private Date endtime;
	private String address;
	private String type;
	private String content;
	private String opiinfo;
	private String apptype;
	private String ostype;
	private Date addtime;
	private String citycode;
	private String status;
	private String contentLogo;
	private Integer rank;

	public Serializable realId() {
		return this.id;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOpiinfo() {
		return this.opiinfo;
	}

	public void setOpiinfo(String opiinfo) {
		this.opiinfo = opiinfo;
	}

	public String getApptype() {
		return this.apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public String getOstype() {
		return this.ostype;
	}

	public void setOstype(String ostype) {
		this.ostype = ostype;
	}

	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContentLogo() {
		return this.contentLogo;
	}

	public void setContentLogo(String contentLogo) {
		this.contentLogo = contentLogo;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getFullLogo() {
		return this.fullLogo;
	}

	public void setFullLogo(String fullLogo) {
		this.fullLogo = fullLogo;
	}
}