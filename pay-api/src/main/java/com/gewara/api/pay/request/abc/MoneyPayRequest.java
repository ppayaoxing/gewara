package com.gewara.api.pay.request.abc;

import java.util.Map;

public class MoneyPayRequest extends AbcRequest {

	private static final long serialVersionUID = -5582901218651779910L;
	
	private String cardno		;//锟斤拷锟阶匡拷锟斤拷
	private String cardexp		;//锟斤拷锟斤拷效锟斤拷
	private String adddata		;//CVD2
	private Integer amount		;//锟斤拷锟阶斤拷锟�
	private Integer totalAmount	;//锟斤拷锟斤拷锟杰斤拷锟�
	private String checkcode	;//锟斤拷证锟斤拷
	
	public MoneyPayRequest(){}
	
	public MoneyPayRequest(String orderid, String cardno, String cardexp, String adddata, Integer amount, Integer totalAmount, String checkcode) {
		super(orderid);
		this.cardno = cardno;
		this.cardexp = cardexp;
		this.adddata = adddata;
		this.amount = amount;
		this.totalAmount = totalAmount;
		this.checkcode = checkcode;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = super.getTextParams();
		params.put("cardno", cardno);
		params.put("cardexp", cardexp);
		params.put("adddata", adddata);
		params.put("amount", String.valueOf(amount));
		params.put("totalamount", String.valueOf(totalAmount));
		params.put("checkcode", checkcode);
		return params;
	}

	@Override
	public boolean checkParams() {
		if(!super.checkParams()) {
            return false;
        }
		
		if(cardno==null || cardno.length()>=20) {
            return false;
        }
		if(cardexp==null || cardno.length()==4) {
            return false;
        }
		if(amount==null || amount<=0) {
            return false;
        }
		if(totalAmount==null || totalAmount<=0) {
            return false;
        }
		if(adddata==null || adddata.length()!=3) {
            return false;
        }
		if(checkcode==null || checkcode.length()!=6) {
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

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

}
