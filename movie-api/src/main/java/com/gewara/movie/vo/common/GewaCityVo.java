/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.common;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import org.apache.commons.lang.StringUtils;

public class GewaCityVo extends BaseVo {
	public static String SINGLE_SERVICE_TYPE = "single";
	public static String MORE_SERVICE_TYPE = "more";
	private static final long serialVersionUID = 8710609514593838526L;
	private String citycode;
	private String cityname;
	private String provincecode;
	private String provincename;
	private String showHot;
	private String showIdx;
	private String showAdm;
	private Integer hotSort;
	private Integer citySort;
	private Integer provinceSort;
	private String pinyin;
	private String py;
	private String manmethod;
	private String bpointx;
	private String bpointy;
	private String serviceType;

	public Serializable realId() {
		return this.citycode;
	}

	public String getFirstPy() {
		return StringUtils.isNotBlank(this.pinyin) ? this.pinyin.substring(0, 1).toUpperCase() : "";
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

	public String getShowHot() {
		return this.showHot;
	}

	public void setShowHot(String showHot) {
		this.showHot = showHot;
	}

	public String getShowIdx() {
		return this.showIdx;
	}

	public void setShowIdx(String showIdx) {
		this.showIdx = showIdx;
	}

	public String getShowAdm() {
		return this.showAdm;
	}

	public void setShowAdm(String showAdm) {
		this.showAdm = showAdm;
	}

	public Integer getCitySort() {
		return this.citySort;
	}

	public void setCitySort(Integer citySort) {
		this.citySort = citySort;
	}

	public Integer getProvinceSort() {
		return this.provinceSort;
	}

	public void setProvinceSort(Integer provinceSort) {
		this.provinceSort = provinceSort;
	}

	public Integer getHotSort() {
		return this.hotSort;
	}

	public void setHotSort(Integer hotSort) {
		this.hotSort = hotSort;
	}

	public String getPinyin() {
		return this.pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getPy() {
		return this.py;
	}

	public void setPy(String py) {
		this.py = py;
	}

	public String getManmethod() {
		return this.manmethod;
	}

	public void setManmethod(String manmethod) {
		this.manmethod = manmethod;
	}

	public boolean hasAuto() {
		return StringUtils.equals(this.showIdx, "Y") && !StringUtils.equals(this.manmethod, "manual");
	}

	public String getBpointx() {
		return this.bpointx;
	}

	public void setBpointx(String bpointx) {
		this.bpointx = bpointx;
	}

	public String getBpointy() {
		return this.bpointy;
	}

	public void setBpointy(String bpointy) {
		this.bpointy = bpointy;
	}

	public String getFirstInitials() {
		return StringUtils.substring(this.py, 0, 1);
	}

	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
}