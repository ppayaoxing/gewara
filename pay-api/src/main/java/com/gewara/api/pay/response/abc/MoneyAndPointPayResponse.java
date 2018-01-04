package com.gewara.api.pay.response.abc;


public class MoneyAndPointPayResponse extends AbcResponse {

	private static final long serialVersionUID = -1978543463407522584L;
	
	private String cardno			;//交易卡号
	private String trandate			;//消费交易日期
	private String trantime			;//消费交易时间
	private String sysdef			;//消费系统参考号
	private String settleno			;//消费农行批次号
	private String termserial		;//消费终端流水号
	private String vouserial		;//消费凭证号
	private String ptrandate		;//积分交易日期
	private String ptrantime		;//积分交易时间
	private String psysdef			;//积分系统参考号
	private String psettleno		;//积分农行批次号
	private String ptermserial		;//积分终端流水号
	private String pvouserial		;//积分凭证号
	
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
	public String getPtrandate() {
		return ptrandate;
	}
	public void setPtrandate(String ptrandate) {
		this.ptrandate = ptrandate;
	}
	public String getPtrantime() {
		return ptrantime;
	}
	public void setPtrantime(String ptrantime) {
		this.ptrantime = ptrantime;
	}
	public String getPsysdef() {
		return psysdef;
	}
	public void setPsysdef(String psysdef) {
		this.psysdef = psysdef;
	}
	public String getPsettleno() {
		return psettleno;
	}
	public void setPsettleno(String psettleno) {
		this.psettleno = psettleno;
	}
	public String getPtermserial() {
		return ptermserial;
	}
	public void setPtermserial(String ptermserial) {
		this.ptermserial = ptermserial;
	}
	public String getPvouserial() {
		return pvouserial;
	}
	public void setPvouserial(String pvouserial) {
		this.pvouserial = pvouserial;
	}	
}
