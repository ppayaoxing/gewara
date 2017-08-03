package com.gewara.api.pay.response.abc;

import com.gewara.api.pay.ApiResponse;

public class AbcResponse extends ApiResponse {

	private static final long serialVersionUID = -3602887327344956435L;

	private String orderid;
	
	public AbcResponse() {}
	
	public AbcResponse(String orderid){
		this.orderid = orderid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}	
}
