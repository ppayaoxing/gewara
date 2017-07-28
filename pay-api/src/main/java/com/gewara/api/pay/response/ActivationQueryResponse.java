/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response;

import com.gewara.api.pay.ApiResponse;

public class ActivationQueryResponse extends ApiResponse {
	private static final long serialVersionUID = 6544109331366876341L;
	private String activateStatus;
	private String phoneNumber;
	private Integer transLimit;
	private Integer sumLimit;
	private String expiry;
	private String cupReserved;

	public String getActivateStatus() {
		return this.activateStatus;
	}

	public void setActivateStatus(String activateStatus) {
		this.activateStatus = activateStatus;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getTransLimit() {
		return this.transLimit;
	}

	public void setTransLimit(Integer transLimit) {
		this.transLimit = transLimit;
	}

	public Integer getSumLimit() {
		return this.sumLimit;
	}

	public void setSumLimit(Integer sumLimit) {
		this.sumLimit = sumLimit;
	}

	public String getCupReserved() {
		return this.cupReserved;
	}

	public void setCupReserved(String cupReserved) {
		this.cupReserved = cupReserved;
	}

	public String getExpiry() {
		return this.expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
}