/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response;

import com.gewara.api.pay.ApiResponse;
import java.util.Map;

public class GetBindParamsResponse extends ApiResponse {
	private static final long serialVersionUID = -1812192843556562071L;
	private String bindCardUrl;
	private Map<String, String> params;

	public String getBindCardUrl() {
		return this.bindCardUrl;
	}

	public void setBindCardUrl(String bindCardUrl) {
		this.bindCardUrl = bindCardUrl;
	}

	public Map<String, String> getParams() {
		return this.params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}
}