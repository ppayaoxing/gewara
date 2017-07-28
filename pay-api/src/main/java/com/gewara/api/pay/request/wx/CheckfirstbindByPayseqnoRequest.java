/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request.wx;

import com.gewara.api.pay.ApiRequest;
import java.util.HashMap;
import java.util.Map;

public class CheckfirstbindByPayseqnoRequest extends ApiRequest {
	private static final long serialVersionUID = -3650370086575450781L;
	private String payseqno;

	public CheckfirstbindByPayseqnoRequest() {
	}

	public CheckfirstbindByPayseqnoRequest(String payseqno) {
		this.payseqno = payseqno;
	}

	public Map<String, String> getTextParams() {
		HashMap params = new HashMap();
		params.put("payseqno", this.payseqno);
		return params;
	}

	public boolean checkParams() {
		return this.payseqno != null && !"".equals(this.payseqno.trim());
	}

	public String getPayseqno() {
		return this.payseqno;
	}

	public void setPayseqno(String payseqno) {
		this.payseqno = payseqno;
	}
}