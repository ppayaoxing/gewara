/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.push.api.req.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class PushNotifyNewVo implements Serializable {
	private static final long serialVersionUID = -41880787313247599L;
	private String product;
	private String title;
	private String msgType;
	private String content;
	private String links;
	private String relatedId;
	private Timestamp sentTime;
	private Long userId;
	private Integer validTime;
	private String msgKey;
	private String version;
	private String appVersion;

	public PushNotifyNewVo(Long userId, String msgType, String product, String title, String content, String links,
			String relatedId, Timestamp sentTime, Integer validTime, String msgKey) {
		this.userId = userId;
		this.msgType = msgType;
		this.product = product;
		this.title = title;
		this.content = content;
		this.links = links;
		this.relatedId = relatedId;
		this.sentTime = sentTime;
		this.validTime = validTime;
		this.msgKey = msgKey;
		this.version = "1.0";
	}

	public PushNotifyNewVo(Long userId, String msgType, String product, String title, String content, String links,
			String relatedId, Timestamp sentTime, Integer validTime, String msgKey, String version) {
		this.userId = userId;
		this.msgType = msgType;
		this.product = product;
		this.title = title;
		this.content = content;
		this.links = links;
		this.relatedId = relatedId;
		this.sentTime = sentTime;
		this.validTime = validTime;
		this.msgKey = msgKey;
		this.version = version;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getLinks() {
		return this.links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public String getRelatedId() {
		return this.relatedId;
	}

	public void setRelatedId(String relatedId) {
		this.relatedId = relatedId;
	}

	public Timestamp getSentTime() {
		return this.sentTime;
	}

	public void setSentTime(Timestamp sentTime) {
		this.sentTime = sentTime;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getValidTime() {
		return this.validTime;
	}

	public void setValidTime(Integer validTime) {
		this.validTime = validTime;
	}

	public String getMsgKey() {
		return this.msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
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
}