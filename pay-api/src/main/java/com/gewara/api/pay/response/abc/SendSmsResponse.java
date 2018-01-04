package com.gewara.api.pay.response.abc;



public class SendSmsResponse extends AbcResponse {

	private static final long serialVersionUID = 320131114082724773L;

	private String	cardno;			//交易卡号
	private String	trandate;		//交易日期
	private String	trantime;		//交易时间
	
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
}
