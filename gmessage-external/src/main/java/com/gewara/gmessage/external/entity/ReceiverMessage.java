/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.entity;

public class ReceiverMessage extends MessageBaseInfo {
	private static final long serialVersionUID = 6239060865973734192L;
	private long messageID;
	private MUser sender;
	private long sendTimes;
	private Long expiryTimes;
	private boolean read;

	public ReceiverMessage() {
		this.messageID = -1L;

		this.sender = null;

		this.sendTimes = -1L;

		this.expiryTimes = null;

		this.read = false;
	}

	public long getMessageID() {
		return this.messageID;
	}

	public void setMessageID(long messageID) {
		this.messageID = messageID;
	}

	public MUser getSender() {
		return this.sender;
	}

	public void setSender(MUser sender) {
		this.sender = sender;
	}

	public long getSendTimes() {
		return this.sendTimes;
	}

	public void setSendTimes(long sendTimes) {
		this.sendTimes = sendTimes;
	}

	public boolean isRead() {
		return this.read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public Long getExpiryTimes() {
		return this.expiryTimes;
	}

	public void setExpiryTimes(Long expiryTimes) {
		this.expiryTimes = expiryTimes;
	}
}