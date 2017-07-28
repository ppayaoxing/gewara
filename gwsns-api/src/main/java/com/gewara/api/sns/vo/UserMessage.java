/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo;

import java.io.Serializable;

public class UserMessage implements Serializable {
	private static final long serialVersionUID = -3322684887723628280L;
	private String memberId;
	private String mobileUserName;
	private String sinaUserName;
	private String mobile;
	private String gewaraMemberId;

	public String getMemberId() {
		return this.memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMobileUserName() {
		return this.mobileUserName;
	}

	public void setMobileUserName(String mobileUserName) {
		this.mobileUserName = mobileUserName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSinaUserName() {
		return this.sinaUserName;
	}

	public void setSinaUserName(String sinaUserName) {
		this.sinaUserName = sinaUserName;
	}

	public String getGewaraMemberId() {
		return this.gewaraMemberId;
	}

	public void setGewaraMemberId(String gewaraMemberId) {
		this.gewaraMemberId = gewaraMemberId;
	}

	public String toString() {
		return "UserMessage [memberId=" + this.memberId + ", mobileUserName=" + this.mobileUserName + ", sinaUserName="
				+ this.sinaUserName + ", mobile=" + this.mobile + ", gewaraMemberId=" + this.gewaraMemberId + "]";
	}
}