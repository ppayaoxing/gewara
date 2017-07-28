/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request;

import com.gewara.api.pay.ApiRequest;
import java.sql.Timestamp;
import java.util.Map;

public class GetPayRepeatTradeRequest extends ApiRequest {
	private static final long serialVersionUID = 3591886930540611460L;
	private Timestamp start;
	private Timestamp end;

	public GetPayRepeatTradeRequest() {
	}

	public GetPayRepeatTradeRequest(Timestamp start, Timestamp end) {
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

	public Map<String, String> getTextParams() {
		return null;
	}

	public boolean checkParams() {
		return this.start != null && this.end != null ? this.end.getTime() - this.start.getTime() >= 0L
				&& this.end.getTime() - this.start.getTime() <= 864000000L : false;
	}
}