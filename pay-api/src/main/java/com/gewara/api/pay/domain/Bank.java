/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.domain;

import com.gewara.api.pay.ApiObject;

public class Bank extends ApiObject {
	private static final long serialVersionUID = -1244879481213909584L;
	private Long id;
	private Long gatewayId;
	private String gwraBankCode;
	private String bankName;
	private String bankType;

	public String getPayBank() {
		return this.bankType != null && !"".equals(this.bankType.trim()) && !"DEFAULT".equals(this.bankType)
				? this.gwraBankCode + "_" + this.bankType : this.gwraBankCode;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGatewayId() {
		return this.gatewayId;
	}

	public void setGatewayId(Long gatewayId) {
		this.gatewayId = gatewayId;
	}

	public String getGwraBankCode() {
		return this.gwraBankCode;
	}

	public void setGwraBankCode(String gwraBankCode) {
		this.gwraBankCode = gwraBankCode;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankType() {
		return this.bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
}