package com.gewara.gmessage.external.entity;

import java.io.Serializable;

import com.gewara.gmessage.external.constant.MCategory;

/**
 * 消息发送者的查询条件
 *
 */
public class SenderQueryParam implements Serializable {
	
	private static final long serialVersionUID = -7149461923621738247L;

	/**发送用户信息*/
	private MUser sender=null;
	
	/**页码，默认第一页*/
	private int pageNo=1;//页码，默认第一页
	
	/**每页的记录数。默认50*/
	private int pageSize=50;//每页的记录数。默认50；
	
	private MCategory messageCat=MCategory.INTERACT;
	
	/**发送日期，返回指定日期之后的消息。不指定，默认为半年内的消息*/
	private Long sendTimes=null;//
 
	public MUser getSender() {
		return sender;
	}

	public void setSender(MUser sender) {
		this.sender = sender;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getSendTimes() {
		return sendTimes;
	}

	public void setSendTimes(Long sendTimes) {
		this.sendTimes = sendTimes;
	}

	public MCategory getMessageCat() {
		return messageCat;
	}

	public void setMessageCat(MCategory messageCat) {
		this.messageCat = messageCat;
	}
}
