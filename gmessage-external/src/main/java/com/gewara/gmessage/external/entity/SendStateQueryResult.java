package com.gewara.gmessage.external.entity;

import java.io.Serializable;


/**
 * 查询消息发送状态结果
 * 
 * @author 董明
 * @createDate 2015年12月4日
 */
public class SendStateQueryResult implements Serializable{
	private static final long serialVersionUID = -8509780580348754248L;
	
	private Long umid=null; //用户消息ID
	private MUser receiver = null;//接收者消息
	private Long sendTime = null;// 送达到接收者的时间
	private Long readTime = null;// 接收者阅读时间
	private Long delTimes = null;// 删除时间

	public Long getUmid() {
		return umid;
	}

	public void setUmid(Long umid) {
		this.umid = umid;
	}

	public MUser getReceiver() {
		return receiver;
	}

	public void setReceiver(MUser receiver) {
		this.receiver = receiver;
	}

	public Long getSendTime() {
		return sendTime;
	}

	public Long getReadTime() {
		return readTime;
	}

	public void setSendTime(Long sendTime) {
		this.sendTime = sendTime;
	}

	public void setReadTime(Long readTime) {
		this.readTime = readTime;
	}

	public Long getDelTimes() {
		return delTimes;
	}

	public void setDelTimes(Long delTimes) {
		this.delTimes = delTimes;
	}
}
