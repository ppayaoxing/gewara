/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request.abc;

import com.gewara.api.pay.ApiRequest;
import java.util.HashMap;
import java.util.Map;

public class AbcRequest extends ApiRequest {
	private static final long serialVersionUID = -7261831153348805469L;
	private String orderid;

	public AbcRequest() {
	}

	public AbcRequest(String orderid) {
		this.orderid = orderid;
	}

	public Map<String, String> getTextParams() {
		HashMap params = new HashMap();
		params.put("orderid", this.orderid);
		return params;
	}

	public boolean checkParams() {
		return this.orderid != null;
	}

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
}