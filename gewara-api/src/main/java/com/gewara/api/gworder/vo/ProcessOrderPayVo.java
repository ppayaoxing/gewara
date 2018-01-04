package com.gewara.api.gworder.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class ProcessOrderPayVo extends BaseVo{

	private static final long serialVersionUID = 4894151622349595385L;

	private String tradeNo;
	
	private String checkpass;//取材密码

	protected String orderFlagStatus;	//订单标识状态
			
	@Override
	public Serializable realId() {
		return tradeNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getCheckpass() {
		return checkpass;
	}

	public void setCheckpass(String checkpass) {
		this.checkpass = checkpass;
	}

	public String getOrderFlagStatus() {
		return orderFlagStatus;
	}

	public void setOrderFlagStatus(String orderFlagStatus) {
		this.orderFlagStatus = orderFlagStatus;
	}

}
