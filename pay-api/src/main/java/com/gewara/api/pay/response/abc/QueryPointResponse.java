package com.gewara.api.pay.response.abc;



public class QueryPointResponse extends AbcResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1164293328300492123L;

	/**
	 * 交易卡号
	 */
	private String cardno;
	
	/**
	 * 总积分
	 */
	private String totalpoint;
	
	/**
	 * 本位币积分
	 */
	private String point;
	
	/**
	 * 外币代码
	 */
	private String curr;
	
	/**
	 * 外币积分
	 */
	private String currpoint;
	
	/**
	 * 交易日期
	 */
	private String trandate;
	
	/**
	 * 交易时间
	 */
	private String trantime;

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getTotalpoint() {
		return totalpoint;
	}

	public void setTotalpoint(String totalpoint) {
		this.totalpoint = totalpoint;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	public String getCurrpoint() {
		return currpoint;
	}

	public void setCurrpoint(String currpoint) {
		this.currpoint = currpoint;
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
