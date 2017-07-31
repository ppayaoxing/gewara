package com.gewara.api.partner.res.vo;

import java.io.Serializable;
import java.util.List;

import com.gewara.api.vo.BaseVo;
import com.gewara.api.vo.common.GewaCityVo;

public class OpenCityVo extends BaseVo{
	private static final long serialVersionUID = -878465769784391979L;
	private String provincename;
	private List<GewaCityVo> cityList;
	@Override
	public Serializable realId() {
		return provincename;
	}
	
	public List<GewaCityVo> getCityList() {
		return cityList;
	}
	public void setCityList(List<GewaCityVo> cityList) {
		this.cityList = cityList;
	}

	public String getProvincename() {
		return provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}
}
