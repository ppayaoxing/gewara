package com.gewara.api.vo.mobile;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class CommendActivityVo extends BaseVo{
	private static final long serialVersionUID = -390148182069294469L;
	private Long id;
	private String title;
	private String logo;
	private String deslogo;
	private String signname;
	private String summary;
	private Integer sortnum;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDeslogo() {
		return deslogo;
	}
	public void setDeslogo(String deslogo) {
		this.deslogo = deslogo;
	}
	public String getSignname() {
		return signname;
	}
	public void setSignname(String signname) {
		this.signname = signname;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getSortnum() {
		return sortnum;
	}
	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}
	@Override
	public Serializable realId() {
		return id;
	}
}
