/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.entity;

import java.io.Serializable;

public class SendStateQueryResult implements Serializable {
	private static final long serialVersionUID = -8509780580348754248L;
	private Long umid;
	private MUser receiver;
	private Long sendTime;
	private Long readTime;
	private Long delTimes;

	public SendStateQueryResult() {
		this.umid = null;
		this.receiver = null;
		this.sendTime = null;
		this.readTime = null;
		this.delTimes = null;
	}

	public Long getUmid() {
		return this.umid;
	}

	public void setUmid(Long umid) {
		this.umid = umid;
	}

	public MUser getReceiver() {
		return this.receiver;
	}

	public void setReceiver(MUser receiver) {
		this.receiver = receiver;
	}

	public Long getSendTime() {
		return this.sendTime;
	}

	public Long getReadTime() {
		return this.readTime;
	}

	public void setSendTime(Long sendTime) {
		this.sendTime = sendTime;
	}

	public void setReadTime(Long readTime) {
		this.readTime = readTime;
	}

	public Long getDelTimes() {
		return this.delTimes;
	}

	public void setDelTimes(Long delTimes) {
		this.delTimes = delTimes;
	}
}