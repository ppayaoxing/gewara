package com.gewara.api.partner.res.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class ApiUserPaymethodVo extends BaseVo{
	private static final long serialVersionUID = 3764585500571733539L;
	private String appicon;
	private String tag;
	private String paymethod;
	private String desc;
	
	public String getAppicon() {
		return appicon;
	}
	public void setAppicon(String appicon) {
		this.appicon = appicon;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	@Override
	public Serializable realId() {
		return tag;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
