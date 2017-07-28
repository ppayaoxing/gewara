/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.entity;

import com.gewara.gmessage.external.constant.MCategory;
import com.gewara.gmessage.external.constant.MType;
import com.gewara.gmessage.external.constant.UserType;
import java.io.Serializable;

public class ReceiverQueryParam implements Serializable {
	private static final long serialVersionUID = -841776701319728714L;
	private int pageNo = 1;
	private int pageSize = 50;

	private MUser receiver = null;
	private Boolean read = Boolean.valueOf(false);
	private MCategory messageCat = MCategory.INTERACT;
	private MType[] types = null;
	private Long reciveTimes = null;

	public ReceiverQueryParam(String receiver, UserType userType) {
		this.receiver = new MUser(receiver, userType);
	}

	public ReceiverQueryParam(MUser receiver) {
		this.receiver = receiver;
	}

	public MUser getReceiver() {
		return this.receiver;
	}

	public void setReceiver(MUser receiver) {
		this.receiver = receiver;
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

	public Boolean getRead() {
		return this.read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public MCategory getMessageCat() {
		return this.messageCat;
	}

	public void setMessageCat(MCategory messageCat) {
		this.messageCat = messageCat;
	}

	public MType[] getTypes() {
		return this.types;
	}

	public void setTypes(MType[] types) {
		this.types = types;
	}

	public Long getReciveTimes() {
		return this.reciveTimes;
	}

	public void setReciveTimes(Long reciveTimes) {
		this.reciveTimes = reciveTimes;
	}
}