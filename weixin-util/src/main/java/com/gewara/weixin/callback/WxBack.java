package com.gewara.weixin.callback;

import java.io.Serializable;

public class WxBack implements Serializable{
	private static final long serialVersionUID = 3275511581256252303L;
	protected String errmsg;
	protected Integer errcode;
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public Integer getErrcode() {
		return errcode;
	}
	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}
	
}
