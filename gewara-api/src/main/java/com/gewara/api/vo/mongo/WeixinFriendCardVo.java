/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.mongo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class WeixinFriendCardVo extends BaseVo {
	private static final long serialVersionUID = 5839294364342968226L;
	private String id;
	private String event;
	private String toUserName;
	private String fromUserName;
	private String friendUserName;
	private String createTime;
	private String createTimeStr;
	private String msgType;
	private String isGiveByFriend;
	private String userCardCode;
	private String outerId;
	private String del;
	private String used;
	private String cardId;
	private String tradeNo;
	private String gived;
	private String consume;

	public Serializable realId() {
		return this.id;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

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

	public String getFriendUserName() {
		return this.friendUserName;
	}

	public void setFriendUserName(String friendUserName) {
		this.friendUserName = friendUserName;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeStr() {
		return this.createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getMsgType() {
		return this.msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
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

	public String getDel() {
		return this.del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public String getUsed() {
		return this.used;
	}

	public void setUsed(String used) {
		this.used = used;
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getConsume() {
		return this.consume;
	}

	public void setConsume(String consume) {
		this.consume = consume;
	}

	public String getGived() {
		return this.gived;
	}

	public void setGived(String gived) {
		this.gived = gived;
	}
}