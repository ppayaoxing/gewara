package com.gewara.api.sns.vo;

import java.io.Serializable;


public class UserMessage implements Serializable {

	private static final long serialVersionUID = -3322684887723628280L;
	private String memberId;//当前用户id
	private String mobileUserName;//手机用户名
	private String sinaUserName;//手机用户名
	private String mobile;//手机号
	private String gewaraMemberId;//手机对应的格瓦拉用户id

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMobileUserName() {
		return mobileUserName;
	}

	public void setMobileUserName(String mobileUserName) {
		this.mobileUserName = mobileUserName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSinaUserName() {
		return sinaUserName;
	}

	public void setSinaUserName(String sinaUserName) {
		this.sinaUserName = sinaUserName;
	}

	public String getGewaraMemberId() {
		return gewaraMemberId;
	}

	public void setGewaraMemberId(String gewaraMemberId) {
		this.gewaraMemberId = gewaraMemberId;
	}

	@Override
	public String toString() {
		return "UserMessage [memberId=" + memberId + ", mobileUserName="
				+ mobileUserName + ", sinaUserName=" + sinaUserName
				+ ", mobile=" + mobile + ", gewaraMemberId=" + gewaraMemberId
				+ "]";
	}

}
