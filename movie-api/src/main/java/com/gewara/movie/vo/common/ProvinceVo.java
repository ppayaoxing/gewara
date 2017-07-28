/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.common;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class ProvinceVo extends BaseVo {
	private static final long serialVersionUID = -4005179362559886287L;
	private String provincecode;
	private String provincename;
	private String provinceename;
	private String nationcode;
	private String nationname;
	private String nationename;
	private String continentcode;
	private String continentname;
	private String continentename;
	private String regionlevel;

	public String getProvincecode() {
		return this.provincecode;
	}

	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}

	public String getProvincename() {
		return this.provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

	public String getProvinceename() {
		return this.provinceename;
	}

	public void setProvinceename(String provinceename) {
		this.provinceename = provinceename;
	}

	public String getNationcode() {
		return this.nationcode;
	}

	public void setNationcode(String nationcode) {
		this.nationcode = nationcode;
	}

	public String getNationname() {
		return this.nationname;
	}

	public void setNationname(String nationname) {
		this.nationname = nationname;
	}

	public String getNationename() {
		return this.nationename;
	}

	public void setNationename(String nationename) {
		this.nationename = nationename;
	}

	public String getContinentcode() {
		return this.continentcode;
	}

	public void setContinentcode(String continentcode) {
		this.continentcode = continentcode;
	}

	public String getContinentname() {
		return this.continentname;
	}

	public void setContinentname(String continentname) {
		this.continentname = continentname;
	}

	public String getContinentename() {
		return this.continentename;
	}

	public void setContinentename(String continentename) {
		this.continentename = continentename;
	}

	public String getRegionlevel() {
		return this.regionlevel;
	}

	public void setRegionlevel(String regionlevel) {
		this.regionlevel = regionlevel;
	}

	public Serializable realId() {
		return this.provincecode;
	}
}