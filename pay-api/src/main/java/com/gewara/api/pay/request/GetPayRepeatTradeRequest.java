package com.gewara.api.pay.request;

import java.sql.Timestamp;
import java.util.Map;

import com.gewara.api.pay.ApiRequest;

public class GetPayRepeatTradeRequest extends ApiRequest {

	private static final long serialVersionUID = 3591886930540611460L;

	private Timestamp start;
	
	private Timestamp end;
	
	public GetPayRepeatTradeRequest(){}
	
	public GetPayRepeatTradeRequest(Timestamp start, Timestamp end){
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
	public Map<String, String> getTextParams() {
		return null;
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

}
