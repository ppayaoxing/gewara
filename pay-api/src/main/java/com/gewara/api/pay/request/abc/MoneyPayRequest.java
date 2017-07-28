/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request.abc;

import com.gewara.api.pay.request.abc.AbcRequest;
import java.util.Map;

public class MoneyPayRequest extends AbcRequest {
	private static final long serialVersionUID = -5582901218651779910L;
	private String cardno;
	private String cardexp;
	private String adddata;
	private Integer amount;
	private Integer totalAmount;
	private String checkcode;

	public MoneyPayRequest() {
	}

	public MoneyPayRequest(String orderid, String cardno, String cardexp, String adddata, Integer amount,
			Integer totalAmount, String checkcode) {
		super(orderid);
		this.cardno = cardno;
		this.cardexp = cardexp;
		this.adddata = adddata;
		this.amount = amount;
		this.totalAmount = totalAmount;
		this.checkcode = checkcode;
	}

	public Map<String, String> getTextParams() {
		Map params = super.getTextParams();
		params.put("cardno", this.cardno);
		params.put("cardexp", this.cardexp);
		params.put("adddata", this.adddata);
		params.put("amount", String.valueOf(this.amount));
		params.put("totalamount", String.valueOf(this.totalAmount));
		params.put("checkcode", this.checkcode);
		return params;
	}

	public boolean checkParams() {
		return !super.checkParams() ? false
				: (this.cardno != null && this.cardno.length() < 20 ? (this.cardexp != null && this.cardno.length() != 4
						? (this.amount != null && this.amount.intValue() > 0
								? (this.totalAmount != null && this.totalAmount.intValue() > 0
										? (this.adddata != null && this.adddata.length() == 3
												? this.checkcode != null && this.checkcode.length() == 6 : false)
										: false)
								: false)
						: false) : false);
	}

	public String getCardno() {
		return this.cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCardexp() {
		return this.cardexp;
	}

	public void setCardexp(String cardexp) {
		this.cardexp = cardexp;
	}

	public String getAdddata() {
		return this.adddata;
	}

	public void setAdddata(String adddata) {
		this.adddata = adddata;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCheckcode() {
		return this.checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public Integer getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
}