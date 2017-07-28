/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response.abc;

import com.gewara.api.pay.response.abc.AbcResponse;

public class QueryPointResponse extends AbcResponse {
	private static final long serialVersionUID = -1164293328300492123L;
	private String cardno;
	private String totalpoint;
	private String point;
	private String curr;
	private String currpoint;
	private String trandate;
	private String trantime;

	public String getCardno() {
		return this.cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getTotalpoint() {
		return this.totalpoint;
	}

	public void setTotalpoint(String totalpoint) {
		this.totalpoint = totalpoint;
	}

	public String getPoint() {
		return this.point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getCurr() {
		return this.curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	public String getCurrpoint() {
		return this.currpoint;
	}

	public void setCurrpoint(String currpoint) {
		this.currpoint = currpoint;
	}

	public String getTrandate() {
		return this.trandate;
	}

	public void setTrandate(String trandate) {
		this.trandate = trandate;
	}

	public String getTrantime() {
		return this.trantime;
	}

	public void setTrantime(String trantime) {
		this.trantime = trantime;
	}
}