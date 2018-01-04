package com.gewara.api.pay.response.abc;


public class PointPayResponse extends AbcResponse {

	private static final long serialVersionUID = -1551641511145075550L;
	
	private String cardno		;//交易卡号
	private String trandate		;//交易日期
	private String trantime		;//交易时间
	private String sysdef		;//系统参考号
	private String settleno		;//农行批次号
	private String termserial	;//终端流水号
	private String vouserial	;//凭证号
	
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getTrandate() {
		return trandate;
	}
	public void setTrandate(String trandate) {
		this.trandate = trandate;
	}
	public String getTrantime() {
		return trantime;
	}
	public void setTrantime(String trantime) {
		this.trantime = trantime;
	}
	public String getSysdef() {
		return sysdef;
	}
	public void setSysdef(String sysdef) {
		this.sysdef = sysdef;
	}
	public String getSettleno() {
		return settleno;
	}
	public void setSettleno(String settleno) {
		this.settleno = settleno;
	}
	public String getTermserial() {
		return termserial;
	}
	public void setTermserial(String termserial) {
		this.termserial = termserial;
	}
	public String getVouserial() {
		return vouserial;
	}
	public void setVouserial(String vouserial) {
		this.vouserial = vouserial;
	}
}
