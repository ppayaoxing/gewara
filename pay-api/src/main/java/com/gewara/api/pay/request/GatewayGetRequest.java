package com.gewara.api.pay.request;

import java.util.HashMap;
import java.util.Map;

import com.gewara.api.pay.ApiRequest;

public class GatewayGetRequest extends ApiRequest {
	
	private static final long serialVersionUID = -4481261055608322805L;
	
	private Long id;

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id == null ? "" : String.valueOf(id));
		return params;
	}

	@Override
	public boolean checkParams() {
		if(id == null){
			return false;
		}
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
