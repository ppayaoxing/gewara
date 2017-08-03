package com.gewara.gmessage.external.entity;

import java.io.Serializable;

import com.gewara.gmessage.external.constant.UserType;

/**
 * 
 * 消息的接收或者发送者的具体信息
 * @author user
 *
 */
public class MUser implements Serializable{
	
	private static final long serialVersionUID = -1948794026988727864L;

	private String userID=null; 
	
	private UserType userType=null;
	
	private String mobile=null;//
	
	private String name=null;
	
	private String appVersion = null;
	
	public MUser(String userID,UserType userType){
		this.userID=userID;
		this.userType=userType;
	}
	
	public String getUserID() {
		return userID;
	}
	
	/**用户ID*/
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getMobile() {
		return mobile;
	}
	
	/**用户手机号。*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}
	
	/**用户名称*/
	public void setName(String name) {
		this.name = name;
	}
	
	public UserType getUserType() {
		return userType;
	}

	/**用户类型*/
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	public String getUID(){
		return userType.value()+userID;
	}
	
	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public static MUser fromUID(String uid){
		char type=uid.charAt(0);
		UserType ut=null;
		switch(type){
		case 'M':ut=UserType.MEMBER;break;
		case 'B':ut=UserType.BUSINESS;break;
		case 'A':ut=UserType.MAINTAIN;break;
		}
		if(ut==null) return null;
		return new MUser(uid.substring(1),ut);
	}
}
