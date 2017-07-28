/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response.abc;

import com.gewara.api.pay.response.abc.AbcResponse;

public class MoneyAndPointPayResponse extends AbcResponse {
	private static final long serialVersionUID = -1978543463407522584L;
	private String cardno;
	private String trandate;
	private String trantime;
	private String sysdef;
	private String settleno;
	private String termserial;
	private String vouserial;
	private String ptrandate;
	private String ptrantime;
	private String psysdef;
	private String psettleno;
	private String ptermserial;
	private String pvouserial;

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

	public String getSysdef() {
		return this.sysdef;
	}

	public void setSysdef(String sysdef) {
		this.sysdef = sysdef;
	}

	public String getSettleno() {
		return this.settleno;
	}

	public void setSettleno(String settleno) {
		this.settleno = settleno;
	}

	public String getTermserial() {
		return this.termserial;
	}

	public void setTermserial(String termserial) {
		this.termserial = termserial;
	}

	public String getVouserial() {
		return this.vouserial;
	}

	public void setVouserial(String vouserial) {
		this.vouserial = vouserial;
	}

	public String getPtrandate() {
		return this.ptrandate;
	}

	public void setPtrandate(String ptrandate) {
		this.ptrandate = ptrandate;
	}

	public String getPtrantime() {
		return this.ptrantime;
	}

	public void setPtrantime(String ptrantime) {
		this.ptrantime = ptrantime;
	}

	public String getPsysdef() {
		return this.psysdef;
	}

	public void setPsysdef(String psysdef) {
		this.psysdef = psysdef;
	}

	public String getPsettleno() {
		return this.psettleno;
	}

	public void setPsettleno(String psettleno) {
		this.psettleno = psettleno;
	}

	public String getPtermserial() {
		return this.ptermserial;
	}

	public void setPtermserial(String ptermserial) {
		this.ptermserial = ptermserial;
	}

	public String getPvouserial() {
		return this.pvouserial;
	}

	public void setPvouserial(String pvouserial) {
		this.pvouserial = pvouserial;
	}
}