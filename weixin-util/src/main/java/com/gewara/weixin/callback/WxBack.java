/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin.callback;

import java.io.Serializable;

public class WxBack implements Serializable {
	private static final long serialVersionUID = 3275511581256252303L;
	protected String errmsg;
	protected Integer errcode;

	public String getErrmsg() {
		return this.errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Integer getErrcode() {
		return this.errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}
}