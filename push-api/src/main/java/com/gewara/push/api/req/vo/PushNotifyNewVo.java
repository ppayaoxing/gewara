package com.gewara.push.api.req.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class PushNotifyNewVo implements Serializable{

	private static final long serialVersionUID = -41880787313247599L;
	private String product;//应用名称
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

	/**
	 * 1.0
	 * {@link #PushNotifyVo(Long, String, String, String, String, String, String, Timestamp, Integer, String, String)}
	 * @param userId
	 * @param msgType
	 * @param product cinema,sport
	 * @param title
	 * @param content
	 * @param links
	 * @param relatedId
	 * @param sentTime
	 * @param validTime
	 */
	public PushNotifyNewVo(Long userId, String msgType, String product,
			String title, String content, String links, String relatedId,
			Timestamp sentTime, Integer validTime, String msgKey) {
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

	/**
	 * {@link #PushNotifyVo(Long, String, String, String, String, String, String, Timestamp, Integer, String)}
	 * @param userId	用户ID
	 * @param msgType 	消息类型 区分应用
	 * @param product cinema,sport
	 * @param title	标题
	 * @param content	内容
	 * @param links		链接
	 * @param relatedId	关联ID
	 * @param sentTime 发送时间
	 * @param validTime 可用时间
	 * @param version 版本号
	 */
	public PushNotifyNewVo(Long userId, String msgType, String product,
			String title, String content, String links, String relatedId,
			Timestamp sentTime, Integer validTime, String msgKey, String version) {
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
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public String getRelatedId() {
		return relatedId;
	}

	public void setRelatedId(String relatedId) {
		this.relatedId = relatedId;
	}

	public Timestamp getSentTime() {
		return sentTime;
	}

	public void setSentTime(Timestamp sentTime) {
		this.sentTime = sentTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getValidTime() {
		return validTime;
	}

	public void setValidTime(Integer validTime) {
		this.validTime = validTime;
	}

	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
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
}
