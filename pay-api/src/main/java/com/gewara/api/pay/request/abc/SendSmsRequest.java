package com.gewara.api.pay.request.abc;

import java.util.Map;

public class SendSmsRequest extends AbcRequest {

	private static final long serialVersionUID = -6958225413916134949L;

	private String cardno	;//锟斤拷锟阶匡拷锟斤拷
	private String cardexp	;//锟斤拷锟斤拷效锟斤拷
	private String mobile	;//锟街伙拷锟斤拷锟斤拷
	private String adddata	;//CVD2
	private Integer amount	;//锟斤拷锟阶斤拷锟�
	
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
		if(!super.checkParams()) {
            return false;
        }
		
		if(cardno==null || cardno.length()>20) {
            return false;
        }
		if(cardexp==null || cardexp.length()==4) {
            return false;
        }
		if(mobile==null || mobile.length()!=11) {
            return false;
        }
		if(adddata==null || adddata.length()!=3) {
            return false;
        }
		if(amount==null || amount<=0) {
            return false;
        }
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
