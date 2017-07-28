/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gworder.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class ProcessOrderPayVo extends BaseVo {
	private static final long serialVersionUID = 4894151622349595385L;
	private String tradeNo;
	private String checkpass;
	protected String orderFlagStatus;

	public Serializable realId() {
		return this.tradeNo;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getCheckpass() {
		return this.checkpass;
	}

	public void setCheckpass(String checkpass) {
		this.checkpass = checkpass;
	}

	public String getOrderFlagStatus() {
		return this.orderFlagStatus;
	}

	public void setOrderFlagStatus(String orderFlagStatus) {
		this.orderFlagStatus = orderFlagStatus;
	}
}