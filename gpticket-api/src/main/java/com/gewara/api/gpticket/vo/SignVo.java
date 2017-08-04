package com.gewara.api.gpticket.vo;

public class SignVo {
	private String appkey;
	private String sign;

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public SignVo(String appkey, String sign) {
		super();
		this.appkey = appkey;
		this.sign = sign;
	}

	public SignVo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
