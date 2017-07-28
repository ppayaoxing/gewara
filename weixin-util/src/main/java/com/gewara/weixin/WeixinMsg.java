/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin;

import java.io.Serializable;
import org.apache.commons.lang.StringUtils;

public class WeixinMsg implements Serializable {
	private static final long serialVersionUID = -7752796432896344309L;
	private String toUserName;
	private String fromUserName;
	private String createTime;
	private String msgType;
	private String msgId;
	private String content;
	private String location_X;
	private String location_Y;
	private String latitude;
	private String longitude;
	private String scale;
	private String label;
	private String picUrl;
	private String event;
	private String eventKey;
	private String mediaId;
	private String cardId;
	private String cardID;
	private String friendUserName;
	private String isGiveByFriend;
	private String userCardCode;
	private String outerId;

	public String getToUserName() {
		return this.toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return this.fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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

	public String getLocation_X() {
		return this.location_X;
	}

	public void setLocation_X(String location_X) {
		this.location_X = location_X;
	}

	public String getLocation_Y() {
		return this.location_Y;
	}

	public void setLocation_Y(String location_Y) {
		this.location_Y = location_Y;
	}

	public String getScale() {
		return this.scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public boolean isText() {
		return StringUtils.equalsIgnoreCase(this.msgType, "text");
	}

	public boolean isLocation() {
		return StringUtils.equalsIgnoreCase(this.msgType, "location");
	}

	public boolean isImage() {
		return StringUtils.equalsIgnoreCase(this.msgType, "image");
	}

	public boolean isVoice() {
		return StringUtils.equalsIgnoreCase(this.msgType, "voice");
	}

	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return this.eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getFriendUserName() {
		return this.friendUserName;
	}

	public void setFriendUserName(String friendUserName) {
		this.friendUserName = friendUserName;
	}

	public String getIsGiveByFriend() {
		return this.isGiveByFriend;
	}

	public void setIsGiveByFriend(String isGiveByFriend) {
		this.isGiveByFriend = isGiveByFriend;
	}

	public String getUserCardCode() {
		return this.userCardCode;
	}

	public void setUserCardCode(String userCardCode) {
		this.userCardCode = userCardCode;
	}

	public String getOuterId() {
		return this.outerId;
	}

	public void setOuterId(String outerId) {
		this.outerId = outerId;
	}

	public String getCardID() {
		return this.cardID;
	}

	public void setCardID(String cardID) {
		this.cardID = cardID;
	}

	public String getMsgId() {
		return this.msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMediaId() {
		return this.mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}