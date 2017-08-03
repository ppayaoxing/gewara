package com.gewara.api.vo;

import java.io.Serializable;

public class UserDevice implements Serializable{
	private static final long serialVersionUID = -2486453578172419891L;
	
	private Long userId;		//用户id
	private String deviceId;	//推送标识
	@Deprecated
	private String appToken;	//应用token
	private String deviceTag; 	//设备标记：android、ios
	private String appName;		//应用名称
	private String appVersion;	//应用版本
	private String acceptPush;	//应用是否接受push消息
	private String cityCode; //城市编码
	private String cityName; //城市名称
	private String pointx;
	private String pointy;
	private String uuid; //设备唯一标识
	/**
	 * 
	 * @param uuid设备唯一标识
	 * @param userId 用户id
	 * @param deviceId  推送标识
	 * @param deviceTag 设备标记：android、ios
	 * @param appName 应用名称
	 * @param appVersion 应用版本
	 * @param acceptPush 应用是否接受push消息
	 * @param cityCode 城市编码
	 * @param cityName 城市名称
	 * @param pointx
	 * @param pointy
	 */
	public UserDevice(String uuid,Long userId,String deviceId,String deviceTag,String appName,String appVersion,String acceptPush,String cityCode,String cityName,String pointx,String pointy) {
		this.uuid=uuid;
		this.userId=userId;
		this.deviceId=deviceId;
		this.deviceTag=deviceTag;
		this.appName=appName;
		this.appVersion=appVersion;
		this.acceptPush=acceptPush;
		this.cityCode=cityCode;
		this.cityName=cityName;
		this.pointx=pointx;
		this.pointy=pointy;
	}
	
	/**
	 * 
	 * @param userId 用户id
	 * @param deviceId 设备id
	 * @param appToken 应用token
	 * @param deviceTag 设备标记：android、ios
	 * @param appName 应用名称
	 * @param appVersion 应用版本
	 * @param acceptPush 应用是否接受push消息
	 * @param cityCode 用户城市编码  用户使用设备所在的城市
	 * @param cityName
	 * @param pointx
	 * @param pointy
	 */
	@Deprecated
	public UserDevice(Long userId, String deviceId, String appToken, String deviceTag, 
			String appName, String appVersion, String acceptPush,String cityCode,String cityName,String pointx,String pointy){
		this.userId = userId;
		this.deviceId = deviceId;
		this.appToken = appToken;
		this.deviceTag = deviceTag;
		this.appName = appName;
		this.appVersion = appVersion;
		this.acceptPush = acceptPush;
		this.cityCode=cityCode;	
		this.cityName=cityName;
		this.pointx=pointx;
		this.pointy=pointy;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	@Deprecated
	public String getAppToken() {
		return appToken;
	}
	@Deprecated
	public void setAppToken(String appToken) {
		this.appToken = appToken;
	}

	public String getDeviceTag() {
		return deviceTag;
	}

	public void setDeviceTag(String deviceTag) {
		this.deviceTag = deviceTag;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getAcceptPush() {
		return acceptPush;
	}

	public void setAcceptPush(String acceptPush) {
		this.acceptPush = acceptPush;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getPointx() {
		return pointx;
	}
	public void setPointx(String pointx) {
		this.pointx = pointx;
	}
	public String getPointy() {
		return pointy;
	}
	public void setPointy(String pointy) {
		this.pointy = pointy;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
