/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo;

import java.io.Serializable;

public class UserDevice implements Serializable {
	private static final long serialVersionUID = -2486453578172419891L;
	private Long userId;
	private String deviceId;

	@Deprecated
	private String appToken;
	private String deviceTag;
	private String appName;
	private String appVersion;
	private String acceptPush;
	private String cityCode;
	private String cityName;
	private String pointx;
	private String pointy;
	private String uuid;

	public UserDevice(String uuid, Long userId, String deviceId, String deviceTag, String appName, String appVersion,
			String acceptPush, String cityCode, String cityName, String pointx, String pointy) {
		this.uuid = uuid;
		this.userId = userId;
		this.deviceId = deviceId;
		this.deviceTag = deviceTag;
		this.appName = appName;
		this.appVersion = appVersion;
		this.acceptPush = acceptPush;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.pointx = pointx;
		this.pointy = pointy;
	}

	@Deprecated
	public UserDevice(Long userId, String deviceId, String appToken, String deviceTag, String appName,
			String appVersion, String acceptPush, String cityCode, String cityName, String pointx, String pointy) {
		this.userId = userId;
		this.deviceId = deviceId;
		this.appToken = appToken;
		this.deviceTag = deviceTag;
		this.appName = appName;
		this.appVersion = appVersion;
		this.acceptPush = acceptPush;
		this.cityCode = cityCode;
		this.cityName = cityName;
		this.pointx = pointx;
		this.pointy = pointy;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Deprecated
	public String getAppToken() {
		return this.appToken;
	}

	@Deprecated
	public void setAppToken(String appToken) {
		this.appToken = appToken;
	}

	public String getDeviceTag() {
		return this.deviceTag;
	}

	public void setDeviceTag(String deviceTag) {
		this.deviceTag = deviceTag;
	}

	public String getAppName() {
		return this.appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppVersion() {
		return this.appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getAcceptPush() {
		return this.acceptPush;
	}

	public void setAcceptPush(String acceptPush) {
		this.acceptPush = acceptPush;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPointx() {
		return this.pointx;
	}

	public void setPointx(String pointx) {
		this.pointx = pointx;
	}

	public String getPointy() {
		return this.pointy;
	}

	public void setPointy(String pointy) {
		this.pointy = pointy;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}