/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response.abc;

import com.gewara.api.pay.response.abc.AbcResponse;

public class SendSmsResponse extends AbcResponse {
	private static final long serialVersionUID = 320131114082724773L;
	private String cardno;
	private String trandate;
	private String trantime;

	public String getCardno() {
		return this.cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
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