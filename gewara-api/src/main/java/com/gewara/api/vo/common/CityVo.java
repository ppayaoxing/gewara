/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.common;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class CityVo extends BaseVo {
	private static final long serialVersionUID = -1449397931879372657L;
	private String citycode;
	private String cityname;
	private String cityename;

	public CityVo() {
	}

	public CityVo(String citycode) {
		this.citycode = citycode;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getCityename() {
		return this.cityename;
	}

	public void setCityename(String cityename) {
		this.cityename = cityename;
	}

	public Serializable realId() {
		return this.citycode;
	}

	public String getId() {
		return this.citycode;
	}
}