/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import com.gewara.api.vo.pay.PayParamVo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SelectPayMethodVo extends BaseVo {
	private static final long serialVersionUID = 5582410270545060890L;
	private String tradeNo;
	private Integer discountAmount;
	private Integer totalAmount;
	private Integer due;
	private String payurl;
	private String requestMethod;
	private List<PayParamVo> payparams = new ArrayList();

	public String getPayurl() {
		return this.payurl;
	}

	public void setPayurl(String payurl) {
		this.payurl = payurl;
	}

	public String getRequestMethod() {
		return this.requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public List<PayParamVo> getPayparams() {
		return this.payparams;
	}

	public void setPayparams(List<PayParamVo> payparams) {
		this.payparams = payparams;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
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

	public Serializable realId() {
		return this.tradeNo;
	}

	public Map<String, String> getParamValueMap() {
		HashMap resMap = new HashMap();
		Iterator arg1 = this.payparams.iterator();

		while (arg1.hasNext()) {
			PayParamVo pp = (PayParamVo) arg1.next();
			resMap.put(pp.getParamname(), pp.getParamvalue());
		}

		return resMap;
	}
}