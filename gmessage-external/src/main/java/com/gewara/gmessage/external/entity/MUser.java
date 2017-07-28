/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.entity;

import com.gewara.gmessage.external.constant.UserType;
import java.io.Serializable;

public class MUser implements Serializable {
	private static final long serialVersionUID = -1948794026988727864L;
	private String userID = null;

	private UserType userType = null;

	private String mobile = null;

	private String name = null;

	private String appVersion = null;

	public MUser(String userID, UserType userType) {
		this.userID = userID;
		this.userType = userType;
	}

	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserType getUserType() {
		return this.userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getUID() {
		return this.userType.value() + this.userID;
	}

	public String getAppVersion() {
		return this.appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public static MUser fromUID(String uid) {
		char type = uid.charAt(0);
		UserType ut = null;
		switch (type) {
		case 'M':
			ut = UserType.MEMBER;
			break;
		case 'B':
			ut = UserType.BUSINESS;
			break;
		case 'A':
			ut = UserType.MAINTAIN;
		}
		if (ut == null)
			return null;
		return new MUser(uid.substring(1), ut);
	}
}