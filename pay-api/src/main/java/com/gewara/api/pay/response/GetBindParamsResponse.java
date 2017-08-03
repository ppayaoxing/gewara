package com.gewara.api.pay.response;

import java.util.Map;

import com.gewara.api.pay.ApiResponse;

public class GetBindParamsResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1812192843556562071L;
	
	public GetBindParamsResponse(){
		super();
	}
	
	/**
	 * 银联卡激活跳转地址
	 */
	private String bindCardUrl;
	
	private Map<String, String> params;

	public String getBindCardUrl() {
		return bindCardUrl;
	}

	public void setBindCardUrl(String bindCardUrl) {
		this.bindCardUrl = bindCardUrl;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}
}
