/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request.abc;

import com.gewara.api.pay.request.abc.AbcRequest;
import java.util.Map;

public class MoneyAndPointPayRequest extends AbcRequest {
	private static final long serialVersionUID = 7814516839886229493L;
	private String cardno;
	private String cardexp;
	private String adddata;
	private Integer amount;
	private Integer point;
	private Integer totalAmount;
	private String checkcode;
	private String pointflag;

	public MoneyAndPointPayRequest() {
	}

	public MoneyAndPointPayRequest(String orderid, String cardno, String cardexp, String adddata, Integer amount,
			Integer point, Integer totalAmount, String checkcode, String pointflag) {
		super(orderid);
		this.cardno = cardno;
		this.cardexp = cardexp;
		this.adddata = adddata;
		this.amount = amount;
		this.point = point;
		this.totalAmount = totalAmount;
		this.checkcode = checkcode;
		this.pointflag = pointflag;
	}

	public Map<String, String> getTextParams() {
		Map params = super.getTextParams();
		params.put("cardno", this.cardno);
		params.put("cardexp", this.cardexp);
		params.put("adddata", this.adddata);
		params.put("amount", String.valueOf(this.amount));
		params.put("point", String.valueOf(this.point));
		params.put("totalamount", String.valueOf(this.totalAmount));
		params.put("checkcode", this.checkcode);
		params.put("pointflag", this.pointflag);
		return params;
	}

	public boolean checkParams() {
		if (!super.checkParams()) {
			return false;
		} else if (this.cardno != null && this.cardno.length() < 20) {
			if (this.cardexp != null && this.cardno.length() != 4) {
				if (this.adddata != null && this.adddata.length() == 3) {
					if (this.checkcode != null && this.checkcode.length() == 6) {
						if (this.totalAmount != null && this.totalAmount.intValue() > 0) {
							if (this.pointflag == null) {
								return false;
							} else {
								if ("1".equals(this.pointflag)) {
									if (this.point == null || this.point.intValue() <= 0) {
										return false;
									}
								} else if (this.amount == null || this.amount.intValue() <= 0) {
									return false;
								}

								return true;
							}
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
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

	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getCheckcode() {
		return this.checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String getPointflag() {
		return this.pointflag;
	}

	public void setPointflag(String pointflag) {
		this.pointflag = pointflag;
	}

	public Integer getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
}