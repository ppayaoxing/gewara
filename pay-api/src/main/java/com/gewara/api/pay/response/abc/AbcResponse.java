/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response.abc;

import com.gewara.api.pay.ApiResponse;

public class AbcResponse extends ApiResponse {
	private static final long serialVersionUID = -3602887327344956435L;
	private String orderid;

	public AbcResponse() {
	}

	public AbcResponse(String orderid) {
		this.orderid = orderid;
	}

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
}