/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.common;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class ProgramInfoVo extends BaseVo {
	private static final long serialVersionUID = 3219793338938201077L;
	private Long id;
	private String name;
	private String limg;
	private Integer clickedtimes;
	private Timestamp addtime;
	private String pointx;
	private String pointy;

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getPointx() {
		return this.pointx;
	}

	public void setPointx(String pointx) {
		this.pointx = pointx;
	}

	public String getPointy() {
		return this.pointy;
	}

	public void setPointy(String pointy) {
		this.pointy = pointy;
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLimg() {
		return this.limg;
	}

	public void setLimg(String limg) {
		this.limg = limg;
	}

	public Integer getClickedtimes() {
		return this.clickedtimes;
	}

	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}
}