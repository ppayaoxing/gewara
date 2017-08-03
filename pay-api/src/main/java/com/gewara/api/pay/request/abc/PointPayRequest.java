package com.gewara.api.pay.request.abc;

import java.util.Map;

public class PointPayRequest extends AbcRequest{

	private static final long serialVersionUID = -5760844299795175992L;

	/**
	 * 交易卡号
	 */
	private String cardno;
	
	/**
	 * 卡有效期
	 */
	private String cardexp;
	
	/**
	 * 积分
	 */
	private Integer point;
	
	/**
	 * 订单总金额
	 */
	private Integer totalAmount;
	
	/**
	 * CVD2
	 */
	private String adddata;
	
	/**
	 * 
	 */
	private String acquirer;
	
	public PointPayRequest(){}
	
	public PointPayRequest(String orderid, String cardno, String cardexp, Integer point, Integer totalAmount, String adddata){
		super(orderid);
		this.cardno = cardno;
		this.cardexp = cardexp;
		this.point = point;
		this.totalAmount = totalAmount;
		this.adddata = adddata;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = super.getTextParams();
		params.put("cardno", cardno);
		params.put("cardexp", cardexp);
		params.put("point", String.valueOf(point));
		params.put("totalamount", String.valueOf(totalAmount));
		params.put("adddata", adddata);
		params.put("acquirer", acquirer);
		return params;
	}

	@Override
	public boolean checkParams() {
		if(!super.checkParams())
			return false;
		
		if(cardno==null || cardno.length()>=20)
			return false;
		if(cardexp==null || cardno.length()==4)
			return false;
		if(point==null || point<=0)
			return false;
		if(totalAmount==null || totalAmount<=0)
			return false;
		if(adddata==null || adddata.length()!=3)
			return false;
		return true;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCardexp() {
		return cardexp;
	}

	public void setCardexp(String cardexp) {
		this.cardexp = cardexp;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getAdddata() {
		return adddata;
	}

	public void setAdddata(String adddata) {
		this.adddata = adddata;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getAcquirer() {
		return acquirer;
	}

	public void setAcquirer(String acquirer) {
		this.acquirer = acquirer;
	}
}
