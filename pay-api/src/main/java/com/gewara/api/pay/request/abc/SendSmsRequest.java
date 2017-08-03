package com.gewara.api.pay.request.abc;

import java.util.Map;

public class SendSmsRequest extends AbcRequest {

	private static final long serialVersionUID = -6958225413916134949L;

	private String cardno	;//交易卡号
	private String cardexp	;//卡有效期
	private String mobile	;//手机号码
	private String adddata	;//CVD2
	private Integer amount	;//交易金额
	
	public SendSmsRequest(){}
	
	public SendSmsRequest(String orderid, String cardno, String cardexp, String mobile, String adddata, Integer amount){
		super(orderid);
		this.cardno =  cardno;
		this.cardexp = cardexp;
		this.mobile = mobile;
		this.adddata = adddata;
		this.amount = amount;
	}
	
	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = super.getTextParams();
		params.put("cardno", cardno);
		params.put("cardexp", cardexp);
		params.put("mobile", mobile);
		params.put("adddata", adddata);
		params.put("amount", String.valueOf(amount));
		return params;
	}

	@Override
	public boolean checkParams() {
		if(!super.checkParams())
			return false;
		
		if(cardno==null || cardno.length()>20)
			return false;
		if(cardexp==null || cardexp.length()==4)
			return false;
		if(mobile==null || mobile.length()!=11)
			return false;
		if(adddata==null || adddata.length()!=3)
			return false;
		if(amount==null || amount<=0)
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAdddata() {
		return adddata;
	}

	public void setAdddata(String adddata) {
		this.adddata = adddata;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
