/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.entity;

import com.gewara.gmessage.external.constant.MCategory;
import java.io.Serializable;

public class SenderQueryParam implements Serializable {
	private static final long serialVersionUID = -7149461923621738247L;
	private MUser sender;
	private int pageNo;
	private int pageSize;
	private MCategory messageCat;
	private Long sendTimes;

	public SenderQueryParam() {
		this.sender = null;

		this.pageNo = 1;

		this.pageSize = 50;

		this.messageCat = MCategory.INTERACT;

		this.sendTimes = null;
	}

	public MUser getSender() {
		return this.sender;
	}

	public void setSender(MUser sender) {
		this.sender = sender;
	}

	public int getPageNo() {
		return this.pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getSendTimes() {
		return this.sendTimes;
	}

	public void setSendTimes(Long sendTimes) {
		this.sendTimes = sendTimes;
	}

	public MCategory getMessageCat() {
		return this.messageCat;
	}

	public void setMessageCat(MCategory messageCat) {
		this.messageCat = messageCat;
	}
}