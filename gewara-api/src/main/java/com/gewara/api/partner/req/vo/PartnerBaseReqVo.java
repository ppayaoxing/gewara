package com.gewara.api.partner.req.vo;

import java.io.Serializable;

public class PartnerBaseReqVo implements Serializable {
	private static final long serialVersionUID = -678888982991963704L;
	protected String appkey;		// 合作商APPKEY
	protected String citycode;
	protected String remoteIp;	// 城市编码
	public String getRemoteIp() {
		return remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
}
