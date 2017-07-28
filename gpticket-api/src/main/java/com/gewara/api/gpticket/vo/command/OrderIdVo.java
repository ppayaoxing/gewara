/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.vo.command;

import java.io.Serializable;

public class OrderIdVo implements Serializable {
	private static final long serialVersionUID = -7048567935319120224L;
	private Long orderid;
	private String description;
	private boolean forceRefresh;

	public OrderIdVo(Long orderid) {
		this.orderid = orderid;
	}

	public Long getOrderid() {
		return this.orderid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isForceRefresh() {
		return this.forceRefresh;
	}

	public void setForceRefresh(boolean forceRefresh) {
		this.forceRefresh = forceRefresh;
	}
}