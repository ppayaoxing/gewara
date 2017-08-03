package com.gewara.gmessage.external.entity;

/**
 * 消息接收者所能查看的消息内容。
 * @author 董明
 * 
 */
public class ReceiverMessage extends MessageBaseInfo{
	private static final long serialVersionUID = 6239060865973734192L;

	/**用户消息ID*/
	private long messageID=-1;
	
	/**消息发送者*/
	private MUser sender=null;
	
	/**发送时间*/
	private long sendTimes=-1;
	
	private Long expiryTimes=null;

	/** 消息的状态，已读或未读 */
	private boolean read=false;

	public long getMessageID() {
		return messageID;
	}

	public void setMessageID(long messageID) {
		this.messageID = messageID;
	}

	public MUser getSender() {
		return sender;
	}

	public void setSender(MUser sender) {
		this.sender = sender;
	}

	public long getSendTimes() {
		return sendTimes;
	}

	public void setSendTimes(long sendTimes) {
		this.sendTimes = sendTimes;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public Long getExpiryTimes() {
		return expiryTimes;
	}

	public void setExpiryTimes(Long expiryTimes) {
		this.expiryTimes = expiryTimes;
	}
	
}
