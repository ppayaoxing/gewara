/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class TheatreFieldVo extends BaseVo {
	private static final long serialVersionUID = -2692977270173145089L;
	private Long id;
	private Long theatreid;
	private String name;
	private String fieldnum;
	private String fieldtype;
	private String logo;
	private String mobilelogo;
	private String description;
	private String status;
	private String sortarea;
	private Timestamp addtime;
	private Timestamp updatetime;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTheatreid() {
		return this.theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFieldnum() {
		return this.fieldnum;
	}

	public void setFieldnum(String fieldnum) {
		this.fieldnum = fieldnum;
	}

	public String getFieldtype() {
		return this.fieldtype;
	}

	public void setFieldtype(String fieldtype) {
		this.fieldtype = fieldtype;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMobilelogo() {
		return this.mobilelogo;
	}

	public void setMobilelogo(String mobilelogo) {
		this.mobilelogo = mobilelogo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public boolean hasFieldtype(String type) {
		return StringUtils.isBlank(type) ? false : StringUtils.equals(this.fieldtype, type);
	}

	public String getSortarea() {
		return this.sortarea;
	}

	public void setSortarea(String sortarea) {
		this.sortarea = sortarea;
	}
}