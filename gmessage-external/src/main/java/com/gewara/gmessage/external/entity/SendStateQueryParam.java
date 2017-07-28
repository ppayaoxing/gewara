/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.entity;

import com.gewara.gmessage.external.constant.MCategory;
import java.io.Serializable;

public class SendStateQueryParam implements Serializable {
	private static final long serialVersionUID = 2804118341623987745L;
	private int pageNo;
	private int pageSize;
	private MCategory category;
	private String relateIDType;
	private String relateID;

	public SendStateQueryParam() {
		this.pageNo = 1;

		this.pageSize = 50;

		this.category = null;
		this.relateIDType = null;
		this.relateID = null;
	}

	public int getPageNo() {
		return this.pageNo;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public MCategory getCategory() {
		return this.category;
	}

	public String getRelateIDType() {
		return this.relateIDType;
	}

	public String getRelateID() {
		return this.relateID;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setCategory(MCategory category) {
		this.category = category;
	}

	public void setRelateIDType(String relateIDType) {
		this.relateIDType = relateIDType;
	}

	public void setRelateID(String relateID) {
		this.relateID = relateID;
	}

	public String getUreaid() {
		if ((this.relateIDType == null) || (this.relateID == null))
			return null;
		return this.relateIDType + "-" + this.relateID;
	}
}