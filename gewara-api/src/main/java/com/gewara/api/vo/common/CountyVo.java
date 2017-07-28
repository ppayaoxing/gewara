/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.common;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class CountyVo extends BaseVo {
	private static final long serialVersionUID = -886944461240705718L;
	private String countycode;
	private String briefname;
	private String citycode;
	private String countyname;

	public String getCountycode() {
		return this.countycode;
	}

	public void setCountycode(String citycode) {
		this.countycode = citycode;
	}

	public String getCountyname() {
		return this.countyname;
	}

	public void setCountyname(String county) {
		this.countyname = county;
	}

	public String getId() {
		return this.countycode;
	}

	public Serializable realId() {
		return this.countycode;
	}

	public String getCode() {
		return this.countycode;
	}

	public String getName() {
		return this.countyname;
	}

	public String getBriefname() {
		return this.briefname;
	}

	public void setBriefname(String briefname) {
		this.briefname = briefname;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
}