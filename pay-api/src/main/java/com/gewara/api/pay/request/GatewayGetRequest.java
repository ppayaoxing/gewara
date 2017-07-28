/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request;

import com.gewara.api.pay.ApiRequest;
import java.util.HashMap;
import java.util.Map;

public class GatewayGetRequest extends ApiRequest {
	private static final long serialVersionUID = -4481261055608322805L;
	private Long id;

	public Map<String, String> getTextParams() {
		HashMap params = new HashMap();
		params.put("id", this.id == null ? "" : String.valueOf(this.id));
		return params;
	}

	public boolean checkParams() {
		return this.id != null;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}