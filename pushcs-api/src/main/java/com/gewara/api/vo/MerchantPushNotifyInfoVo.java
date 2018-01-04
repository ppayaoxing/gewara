package com.gewara.api.vo;

import java.io.Serializable;

public class MerchantPushNotifyInfoVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2030166662871082665L;

	private String msgKey; // 消息唯一标识
	private String relatedId; // 关联id（场馆ID等）
	private String links; // 链接地址
	private String linksRelatedId; // 链接地址相关id
	private String msgType; // 策略标记
	private String title; // 标题
	private String content; // 推送类容（Json标记）
	private String sendTime;// 发送时间
	private Integer validTime;// 有效期，单位时间秒
	private String appName; // 应用名称(cinema，sports)
	private String version; // 2.0
	private String appVersion;
	private String otherInfo;	// (Json格式)

	public MerchantPushNotifyInfoVo() {
	}

	public MerchantPushNotifyInfoVo(String relatedId, String msgType, String appName, String title, String content, String links, String sendTime,
			Integer validTime, String msgKey) {
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

	public MerchantPushNotifyInfoVo(String relatedId, String msgType, String appName, String title, String content, String links, String sendTime,
			Integer validTime, String msgKey, String version) {
		this(relatedId, msgType, appName, title, content, links, sendTime, validTime, msgKey);
		this.version = version;
	}

	public String getRelatedId() {
		return relatedId;
	}

	public void setRelatedId(String relatedId) {
		this.relatedId = relatedId;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public String getLinksRelatedId() {
		return linksRelatedId;
	}

	public void setLinksRelatedId(String linksRelatedId) {
		this.linksRelatedId = linksRelatedId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getValidTime() {
		return validTime;
	}

	public void setValidTime(Integer validTime) {
		this.validTime = validTime;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
}
