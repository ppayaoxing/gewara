/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.star;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class CastWorksVo extends BaseVo {
	private static final long serialVersionUID = -1527835351959168455L;
	private Long id;
	private Long castid;
	private Long worksid;
	private String workstype;
	private String achievement;
	private Timestamp addtime;
	private Timestamp updatetime;

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

	public String getAchievement() {
		return this.achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
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

	public Serializable realId() {
		return this.id;
	}
}