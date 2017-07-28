/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo;

import java.io.Serializable;

public class MerchantPushNotifyInfoVo implements Serializable {
	private static final long serialVersionUID = -2030166662871082665L;
	private String msgKey;
	private String relatedId;
	private String links;
	private String linksRelatedId;
	private String msgType;
	private String title;
	private String content;
	private String sendTime;
	private Integer validTime;
	private String appName;
	private String version;
	private String appVersion;
	private String otherInfo;

	public MerchantPushNotifyInfoVo() {
	}

	public MerchantPushNotifyInfoVo(String relatedId, String msgType, String appName, String title, String content,
			String links, String sendTime, Integer validTime, String msgKey) {
		this.relatedId = relatedId;
		this.msgType = msgType;
		this.appName = appName;
		this.title = title;
		this.content = content;
		this.links = links;
		this.sendTime = sendTime;
		this.validTime = validTime;
		this.validTime = validTime;
		this.msgKey = msgKey;
		this.version = "2.0";
	}

	public MerchantPushNotifyInfoVo(String relatedId, String msgType, String appName, String title, String content,
			String links, String sendTime, Integer validTime, String msgKey, String version) {
		this(relatedId, msgType, appName, title, content, links, sendTime, validTime, msgKey);
		this.version = version;
	}

	public String getRelatedId() {
		return this.relatedId;
	}

	public void setRelatedId(String relatedId) {
		this.relatedId = relatedId;
	}

	public String getLinks() {
		return this.links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public String getLinksRelatedId() {
		return this.linksRelatedId;
	}

	public void setLinksRelatedId(String linksRelatedId) {
		this.linksRelatedId = linksRelatedId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getValidTime() {
		return this.validTime;
	}

	public void setValidTime(Integer validTime) {
		this.validTime = validTime;
	}

	public String getAppName() {
		return this.appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAppVersion() {
		return this.appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getMsgKey() {
		return this.msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

	public String getMsgType() {
		return this.msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOtherInfo() {
		return this.otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
}