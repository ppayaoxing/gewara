/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.mobile;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class CommendActivityVo extends BaseVo {
	private static final long serialVersionUID = -390148182069294469L;
	private Long id;
	private String title;
	private String logo;
	private String deslogo;
	private String signname;
	private String summary;
	private Integer sortnum;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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

	public String getDeslogo() {
		return this.deslogo;
	}

	public void setDeslogo(String deslogo) {
		this.deslogo = deslogo;
	}

	public String getSignname() {
		return this.signname;
	}

	public void setSignname(String signname) {
		this.signname = signname;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getSortnum() {
		return this.sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public Serializable realId() {
		return this.id;
	}
}