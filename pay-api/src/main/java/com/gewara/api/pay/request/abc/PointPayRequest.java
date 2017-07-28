/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request.abc;

import com.gewara.api.pay.request.abc.AbcRequest;
import java.util.Map;

public class PointPayRequest extends AbcRequest {
	private static final long serialVersionUID = -5760844299795175992L;
	private String cardno;
	private String cardexp;
	private Integer point;
	private Integer totalAmount;
	private String adddata;
	private String acquirer;

	public PointPayRequest() {
	}

	public PointPayRequest(String orderid, String cardno, String cardexp, Integer point, Integer totalAmount,
			String adddata) {
		super(orderid);
		this.cardno = cardno;
		this.cardexp = cardexp;
		this.point = point;
		this.totalAmount = totalAmount;
		this.adddata = adddata;
	}

	public Map<String, String> getTextParams() {
		Map params = super.getTextParams();
		params.put("cardno", this.cardno);
		params.put("cardexp", this.cardexp);
		params.put("point", String.valueOf(this.point));
		params.put("totalamount", String.valueOf(this.totalAmount));
		params.put("adddata", this.adddata);
		params.put("acquirer", this.acquirer);
		return params;
	}

	public boolean checkParams() {
		return !super.checkParams() ? false
				: (this.cardno != null && this.cardno.length() < 20
						? (this.cardexp != null && this.cardno.length() != 4
								? (this.point != null && this.point.intValue() > 0
										? (this.totalAmount != null && this.totalAmount.intValue() > 0
												? this.adddata != null && this.adddata.length() == 3 : false)
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

	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getAdddata() {
		return this.adddata;
	}

	public void setAdddata(String adddata) {
		this.adddata = adddata;
	}

	public Integer getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getAcquirer() {
		return this.acquirer;
	}

	public void setAcquirer(String acquirer) {
		this.acquirer = acquirer;
	}
}