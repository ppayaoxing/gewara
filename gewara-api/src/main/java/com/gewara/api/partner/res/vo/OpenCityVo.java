/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.api.vo.common.GewaCityVo;
import java.io.Serializable;
import java.util.List;

public class OpenCityVo extends BaseVo {
	private static final long serialVersionUID = -878465769784391979L;
	private String provincename;
	private List<GewaCityVo> cityList;

	public Serializable realId() {
		return this.provincename;
	}

	public List<GewaCityVo> getCityList() {
		return this.cityList;
	}

	public void setCityList(List<GewaCityVo> cityList) {
		this.cityList = cityList;
	}

	public String getProvincename() {
		return this.provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}
}