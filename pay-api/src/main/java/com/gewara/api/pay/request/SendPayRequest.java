/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request;

import com.gewara.api.pay.ApiRequest;
import java.util.Map;

public class SendPayRequest extends ApiRequest {
	private static final long serialVersionUID = -4407561764514743815L;
	private Map<String, String> params;

	public Map<String, String> getTextParams() {
		return this.params;
	}

	public boolean checkParams() {
		return true;
	}

	public Map<String, String> getParams() {
		return this.params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}
}