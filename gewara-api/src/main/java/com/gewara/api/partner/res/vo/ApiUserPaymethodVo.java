/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class ApiUserPaymethodVo extends BaseVo {
	private static final long serialVersionUID = 3764585500571733539L;
	private String appicon;
	private String tag;
	private String paymethod;
	private String desc;

	public String getAppicon() {
		return this.appicon;
	}

	public void setAppicon(String appicon) {
		this.appicon = appicon;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public Serializable realId() {
		return this.tag;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}