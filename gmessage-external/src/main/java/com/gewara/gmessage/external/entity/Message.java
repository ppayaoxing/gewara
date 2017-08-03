
package com.gewara.gmessage.external.entity;

import java.util.List;

import com.gewara.gmessage.external.constant.NoticeType;

/**
 * 主要用来表示当发送消息时，消息的构成要素。
 * @author 董明
 * @createDate 2015年3月6日
 */
public class Message extends MessageBaseInfo {
	private static final long serialVersionUID = -5568228175149691288L;
	private List<MUser> receivers=null;
	private MUser sender=null;
	private long sendTimes=-1;
	private Long expiryTimes=null;
	private NoticeType[] noticeType =null;

	public List<MUser> getReceivers() {
		return receivers;
	}

	public MUser getSender() {
		return sender;
	}

	public long getSendTimes() {
		return sendTimes;
	}
	
	
	public Long getExpiryTimes() {
		return expiryTimes;
	}
	
	public NoticeType[] getNoticeType() {
		return noticeType;
	}
	
	/**
	 * 消息接收者，必填
	 * @param receivers
	 */
	public void setReceivers(List<MUser> receivers) {
		this.receivers = receivers;
	}
	
	/**
	 * 消息发送人员信息，必填
	 * @param sender
	 */
	public void setSender(MUser sender) {
		this.sender = sender;
	}
	
	/**
	 * 消息发送时间。单位为毫秒，必填
	 * @param sendTimes
	 */
	public void setSendTimes(long sendTimes) {
		this.sendTimes = sendTimes;
	}
	
	/**
	 * 消息失效时间。单位毫秒，非必填
	 * @param effectTimes
	 */
	public void setExpiryTimes(Long expiryTimes) {
		this.expiryTimes =expiryTimes;
	}
	
	/**
	 * 设置消息的通知内型。必须填写。
	 * @param noticeType
	 */
	public void setNoticeType(NoticeType... noticeType) {
		this.noticeType = noticeType;
	}
	
	public String getUreaid(){
		if(getReleaseIDType()==null||getReleaseID()==null) return null;
		return getReleaseIDType()+"-"+getReleaseID();
	}
}
