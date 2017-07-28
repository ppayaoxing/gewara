/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.entity;

import com.gewara.gmessage.external.constant.NoticeType;

public class SenderMessage extends MessageBaseInfo {
	private static final long serialVersionUID = 5203539060269685510L;
	private long messageID;
	private MUser sender;
	private long sendTimes;
	private Long expiryTimes;
	private NoticeType[] noticeType;

	public SenderMessage() {
		this.messageID = -1L;

		this.sender = null;

		this.sendTimes = -1L;

		this.expiryTimes = null;

		this.noticeType = null;
	}

	public long getMessageID() {
		return this.messageID;
	}

	public MUser getSender() {
		return this.sender;
	}

	public long getSendTimes() {
		return this.sendTimes;
	}

	public Long getExpiryTimes() {
		return this.expiryTimes;
	}

	public NoticeType[] getNoticeType() {
		return this.noticeType;
	}

	public void setMessageID(long messageID) {
		this.messageID = messageID;
	}

	public void setSender(MUser sender) {
		this.sender = sender;
	}

	public void setSendTimes(long sendTimes) {
		this.sendTimes = sendTimes;
	}

	public void setExpiryTimes(Long expiryTimes) {
		this.expiryTimes = expiryTimes;
	}

	public void setNoticeType(NoticeType[] noticeType) {
		this.noticeType = noticeType;
	}
}