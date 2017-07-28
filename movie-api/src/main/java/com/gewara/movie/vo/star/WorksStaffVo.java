/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.star;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class WorksStaffVo extends BaseVo {
	private static final long serialVersionUID = -1527845351959168455L;
	private Long id;
	private Long castid;
	private Long worksid;
	private String workstype;
	private Long stafllrole;
	private Integer sortby;
	private String rolename;
	private Timestamp addtime;
	private Timestamp updatetime;
	private String chinesename;
	private String engname;
	private String headPicUrl;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCastid() {
		return this.castid;
	}

	public void setCastid(Long castid) {
		this.castid = castid;
	}

	public Long getWorksid() {
		return this.worksid;
	}

	public void setWorksid(Long worksid) {
		this.worksid = worksid;
	}

	public String getWorkstype() {
		return this.workstype;
	}

	public void setWorkstype(String workstype) {
		this.workstype = workstype;
	}

	public Long getStafllrole() {
		return this.stafllrole;
	}

	public void setStafllrole(Long stafllrole) {
		this.stafllrole = stafllrole;
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

	public Integer getSortby() {
		return this.sortby;
	}

	public void setSortby(Integer sortby) {
		this.sortby = sortby;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getChinesename() {
		return this.chinesename;
	}

	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}

	public String getEngname() {
		return this.engname;
	}

	public void setEngname(String engname) {
		this.engname = engname;
	}

	public String getHeadPicUrl() {
		return this.headPicUrl;
	}

	public void setHeadPicUrl(String headPicUrl) {
		this.headPicUrl = headPicUrl;
	}
}