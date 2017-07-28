/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.common;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class SubwaystationVo extends BaseVo {
	private static final long serialVersionUID = -1449397931879372657L;
	private Long id;
	private String stationname;
	private String citycode;

	public SubwaystationVo(String stationname) {
		this.stationname = stationname;
	}

	public SubwaystationVo() {
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

	public String getStationname() {
		return this.stationname;
	}

	public void setStationname(String stationname) {
		this.stationname = stationname;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
}