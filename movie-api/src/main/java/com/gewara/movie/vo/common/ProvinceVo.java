package com.gewara.movie.vo.common;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class ProvinceVo extends BaseVo{
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
	public ProvinceVo(){
		
	}
	public String getProvincecode() {
		return provincecode;
	}
	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}
	public String getProvincename() {
		return provincename;
	}
	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}
	public String getProvinceename() {
		return provinceename;
	}
	public void setProvinceename(String provinceename) {
		this.provinceename = provinceename;
	}
	public String getNationcode() {
		return nationcode;
	}
	public void setNationcode(String nationcode) {
		this.nationcode = nationcode;
	}
	public String getNationname() {
		return nationname;
	}
	public void setNationname(String nationname) {
		this.nationname = nationname;
	}
	public String getNationename() {
		return nationename;
	}
	public void setNationename(String nationename) {
		this.nationename = nationename;
	}
	public String getContinentcode() {
		return continentcode;
	}
	public void setContinentcode(String continentcode) {
		this.continentcode = continentcode;
	}
	public String getContinentname() {
		return continentname;
	}
	public void setContinentname(String continentname) {
		this.continentname = continentname;
	}
	public String getContinentename() {
		return continentename;
	}
	public void setContinentename(String continentename) {
		this.continentename = continentename;
	}
	public String getRegionlevel() {
		return regionlevel;
	}
	public void setRegionlevel(String regionlevel) {
		this.regionlevel = regionlevel;
	}
	@Override
	public Serializable realId() {
		return provincecode;
	}
}
