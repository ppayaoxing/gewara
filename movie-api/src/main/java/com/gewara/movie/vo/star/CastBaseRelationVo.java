/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.star;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class CastBaseRelationVo extends BaseVo {
	private static final long serialVersionUID = -3007170459229696038L;
	private Long id;
	private Long castid;
	private Long baseinfoid;
	private String infotype;
	private Timestamp addtime;
	private Timestamp updatetime;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getCastid() {
		return this.castid;
	}

	public void setCastid(Long castid) {
		this.castid = castid;
	}

	public Long getBaseinfoid() {
		return this.baseinfoid;
	}

	public void setBaseinfoid(Long baseinfoid) {
		this.baseinfoid = baseinfoid;
	}

	public String getInfotype() {
		return this.infotype;
	}

	public void setInfotype(String infotype) {
		this.infotype = infotype;
	}

	public Serializable realId() {
		return this.id;
	}
}