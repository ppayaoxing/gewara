/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.entity;

import com.gewara.gmessage.external.constant.NoticeType;
import java.util.List;

public class Message extends MessageBaseInfo {
	private static final long serialVersionUID = -5568228175149691288L;
	private List<MUser> receivers;
	private MUser sender;
	private long sendTimes;
	private Long expiryTimes;
	private NoticeType[] noticeType;

	public Message() {
		this.receivers = null;
		this.sender = null;
		this.sendTimes = -1L;
		this.expiryTimes = null;
		this.noticeType = null;
	}

	public List<MUser> getReceivers() {
		return this.receivers;
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

	public void setReceivers(List<MUser> receivers) {
		this.receivers = receivers;
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

	public String getUreaid() {
		if ((getReleaseIDType() == null) || (getReleaseID() == null))
			return null;
		return getReleaseIDType() + "-" + getReleaseID();
	}
}