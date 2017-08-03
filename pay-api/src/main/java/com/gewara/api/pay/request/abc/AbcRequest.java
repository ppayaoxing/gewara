package com.gewara.api.pay.request.abc;

import java.util.HashMap;
import java.util.Map;

import com.gewara.api.pay.ApiRequest;

public class AbcRequest extends ApiRequest {

	private static final long serialVersionUID = -7261831153348805469L;

	private String orderid;
	
	public AbcRequest(){}

	public AbcRequest(String orderid){
		this.orderid = orderid;
	}
	
	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("orderid", orderid);
		return params;
	}

	@Override
	public boolean checkParams() {
		if(orderid==null)
			return false;
		return true;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

}
