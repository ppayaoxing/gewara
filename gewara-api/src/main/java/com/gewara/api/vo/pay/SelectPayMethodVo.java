package com.gewara.api.vo.pay;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.BaseVo;

public class SelectPayMethodVo extends BaseVo{
	private static final long serialVersionUID = 5582410270545060890L;
	private String tradeNo;
	private Integer discountAmount;
	private Integer totalAmount;
	private Integer due;
	private String payurl;
	private String requestMethod;
	private List<PayParamVo> payparams = new ArrayList();
	public String getPayurl() {
		return payurl;
	}

	public void setPayurl(String payurl) {
		this.payurl = payurl;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public List<PayParamVo> getPayparams() {
		return payparams;
	}

	public void setPayparams(List<PayParamVo> payparams) {
		this.payparams = payparams;
	}

	public SelectPayMethodVo(){}
	
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
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

	@Override
	public Serializable realId() {
		return tradeNo;
	}
	public Map<String, String> getParamValueMap(){
		Map<String, String> resMap = new HashMap();
		for(PayParamVo pp : payparams){
			resMap.put(pp.getParamname(), pp.getParamvalue());
		}
		return resMap;
	}
}
