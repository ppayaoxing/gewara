/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request;

import com.gewara.api.pay.ApiRequest;
import java.sql.Timestamp;
import java.util.Map;

public class GetPayRecordRequest extends ApiRequest {
	private static final long serialVersionUID = -4782512770871483369L;
	private Timestamp start;
	private Timestamp end;
	private String gatewayCode;
	private String merchantCode;

	public GetPayRecordRequest() {
	}

	public GetPayRecordRequest(Timestamp start, Timestamp end) {
		this.start = start;
		this.end = end;
	}

	public Timestamp getStart() {
		return this.start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getEnd() {
		return this.end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	public boolean checkParams() {
		return this.start != null && this.end != null ? this.end.getTime() - this.start.getTime() >= 0L
				&& this.end.getTime() - this.start.getTime() <= 864000000L : false;
	}

	public Map<String, String> getTextParams() {
		return null;
	}

	public String getGatewayCode() {
		return this.gatewayCode;
	}

	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}

	public String getMerchantCode() {
		return this.merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
}