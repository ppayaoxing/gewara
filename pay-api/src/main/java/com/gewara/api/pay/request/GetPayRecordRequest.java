package com.gewara.api.pay.request;

import java.sql.Timestamp;
import java.util.Map;

import com.gewara.api.pay.ApiRequest;

public class GetPayRecordRequest extends ApiRequest{

	private static final long serialVersionUID = -4782512770871483369L;
	
	private Timestamp start;
	
	private Timestamp end;
	
	private String gatewayCode;
	
	private String merchantCode;
	
	public GetPayRecordRequest(){}
	
	public GetPayRecordRequest(Timestamp start, Timestamp end){
		this.start = start;
		this.end = end;
	}
	
	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	@Override
	public boolean checkParams() {
		if(start==null || end==null){
			return false;
		}
		if(end.getTime()-start.getTime()<0 || end.getTime()-start.getTime()>10*24*3600*1000){
			return false;
		}
		return true;
	}

	@Override
	public Map<String, String> getTextParams() {
		return null;
	}

	public String getGatewayCode() {
		return gatewayCode;
	}

	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
}
