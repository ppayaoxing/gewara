/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import com.gewara.api.vo.pay.PayMethodDescVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PayMethodInfoVo extends BaseVo {
	private static final long serialVersionUID = 5801913340643625866L;
	private String tradeno;
	private Integer discountAmount;
	private Integer totalAmount;
	private Integer due;
	private String status;
	private List<PayMethodDescVo> paymethodList = new ArrayList();

	public Serializable realId() {
		return this.tradeno;
	}

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public Integer getDiscountAmount() {
		return this.discountAmount;
	}

	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Integer getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getDue() {
		return this.due;
	}

	public void setDue(Integer due) {
		this.due = due;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PayMethodDescVo> getPaymethodList() {
		return this.paymethodList;
	}

	public void setPaymethodList(List<PayMethodDescVo> paymethodList) {
		this.paymethodList = paymethodList;
	}
}