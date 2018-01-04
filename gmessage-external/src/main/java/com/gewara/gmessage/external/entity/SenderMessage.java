package com.gewara.gmessage.external.entity;

import com.gewara.gmessage.external.constant.NoticeType;

public class SenderMessage extends MessageBaseInfo{
	private static final long serialVersionUID = 5203539060269685510L;
	

	/**消息ID*/
	private long messageID=-1;
	
	/**消息发送者*/
	private MUser sender=null;
	
	/**发送时间*/
	private long sendTimes=-1;
	
	/**失效时间,不包含这个点。*/
	private Long expiryTimes=null;
	
	/**消息通知类型*/
	private NoticeType[] noticeType =null;

	/**
	 * 消息ID
	 * @return
	 */
	public long getMessageID() {
		return messageID;
	}

	/**
	 * 消息发送者信息
	 * @return
	 */
	public MUser getSender() {
		return sender;
	}

	/**
	 * 消息发送时间，毫秒
	 * @return
	 */
	public long getSendTimes() {
		return sendTimes;
	}

	/**
	 * 消息失效时间
	 * @return
	 */
	public Long getExpiryTimes() {
		return expiryTimes;
	}

	/**
	 * 消息提醒方式
	 * @return
	 */
	public NoticeType[] getNoticeType() {
		return noticeType;
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
