/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.entity;

import com.gewara.gmessage.external.constant.MCategory;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class UpdateMStateParam implements Serializable {
	private static final long serialVersionUID = 463982967827437920L;
	private MUser receiver = null;
	private MCategory category = null;
	private Integer opertionType = null;

	private Collection<Long> messageIDs = null;
	private String realeaID = null;
	private String realeaIDType = null;

	public UpdateMStateParam(MUser receiver, int opertionType) {
		this.receiver = receiver;
		this.opertionType = Integer.valueOf(opertionType);
	}

	public MUser getReceiver() {
		return this.receiver;
	}

	public MCategory getCategory() {
		return this.category;
	}

	public Integer getOpertionType() {
		return this.opertionType;
	}

	public Collection<Long> getMessageIDs() {
		return this.messageIDs;
	}

	public String getRealeaID() {
		return this.realeaID;
	}

	public String getRealeaIDType() {
		return this.realeaIDType;
	}

	public String getUreaid() {
		if ((this.realeaIDType == null) || (this.realeaID == null))
			return null;
		return this.realeaIDType + "-" + this.realeaID;
	}

	public void setMessageIDs(Collection<Long> messageIDs) {
		this.messageIDs = messageIDs;
	}

	public void addMessageIDs(long messageID) {
		if (this.messageIDs == null)
			this.messageIDs = new HashSet();
		this.messageIDs.add(Long.valueOf(messageID));
	}

	public void setRealeaID(MCategory category, String realeaID, String realeaIDType) {
		this.category = category;
		this.realeaID = realeaID;
		this.realeaIDType = realeaIDType;
	}
}