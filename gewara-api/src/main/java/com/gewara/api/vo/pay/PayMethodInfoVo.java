package com.gewara.api.vo.pay;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gewara.api.vo.BaseVo;

public class PayMethodInfoVo extends BaseVo {
	private static final long serialVersionUID = 5801913340643625866L;
	private String tradeno;
	private Integer discountAmount;
	private Integer totalAmount;
	private Integer due;
	private String status;
	private List<PayMethodDescVo> paymethodList = new ArrayList<PayMethodDescVo>();
	
	@Override
	public Serializable realId() {
		return tradeno;
	}

	public String getTradeno() {
		return tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public Integer getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getDue() {
		return due;
	}

	public void setDue(Integer due) {
		this.due = due;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PayMethodDescVo> getPaymethodList() {
		return paymethodList;
	}

	public void setPaymethodList(List<PayMethodDescVo> paymethodList) {
		this.paymethodList = paymethodList;
	}

}
