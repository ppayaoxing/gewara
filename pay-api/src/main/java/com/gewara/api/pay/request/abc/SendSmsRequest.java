/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request.abc;

import com.gewara.api.pay.request.abc.AbcRequest;
import java.util.Map;

public class SendSmsRequest extends AbcRequest {
	private static final long serialVersionUID = -6958225413916134949L;
	private String cardno;
	private String cardexp;
	private String mobile;
	private String adddata;
	private Integer amount;

	public SendSmsRequest() {
	}

	public SendSmsRequest(String orderid, String cardno, String cardexp, String mobile, String adddata,
			Integer amount) {
		super(orderid);
		this.cardno = cardno;
		this.cardexp = cardexp;
		this.mobile = mobile;
		this.adddata = adddata;
		this.amount = amount;
	}

	public Map<String, String> getTextParams() {
		Map params = super.getTextParams();
		params.put("cardno", this.cardno);
		params.put("cardexp", this.cardexp);
		params.put("mobile", this.mobile);
		params.put("adddata", this.adddata);
		params.put("amount", String.valueOf(this.amount));
		return params;
	}

	public boolean checkParams() {
		return !super.checkParams() ? false
				: (this.cardno != null && this.cardno.length() <= 20
						? (this.cardexp != null && this.cardexp.length() != 4
								? (this.mobile != null && this.mobile.length() == 11
										? (this.adddata != null && this.adddata.length() == 3
												? this.amount != null && this.amount.intValue() > 0 : false)
										: false)
								: false)
						: false);
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

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
}