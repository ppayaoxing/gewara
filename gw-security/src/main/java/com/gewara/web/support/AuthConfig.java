/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

public class AuthConfig {
	private String ssoValidateUrl;
	private String ssoLoginUrl;

	public String getSsoValidateUrl() {
		return this.ssoValidateUrl;
	}

	public void setSsoValidateUrl(String ssoValidateUrl) {
		this.ssoValidateUrl = ssoValidateUrl;
	}

	public String getSsoLoginUrl() {
		return this.ssoLoginUrl;
	}

	public void setSsoLoginUrl(String ssoLoginUrl) {
		this.ssoLoginUrl = ssoLoginUrl;
	}
}