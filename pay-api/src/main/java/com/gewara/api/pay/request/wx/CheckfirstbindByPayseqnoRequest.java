package com.gewara.api.pay.request.wx;

import java.util.HashMap;
import java.util.Map;

import com.gewara.api.pay.ApiRequest;

public class CheckfirstbindByPayseqnoRequest extends ApiRequest {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3650370086575450781L;
	
	/**支付交易流水*/
	private String payseqno;
	
	public CheckfirstbindByPayseqnoRequest(){}
	
	public CheckfirstbindByPayseqnoRequest(String payseqno){
		this.payseqno = payseqno;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("payseqno", payseqno);
		return params;
	}

	@Override
	public boolean checkParams() {
		if(payseqno == null || "".equals(payseqno.trim())){
			return false;
		}
		return true;
	}

	public String getPayseqno() {
		return payseqno;
	}

	public void setPayseqno(String payseqno) {
		this.payseqno = payseqno;
	}

}
