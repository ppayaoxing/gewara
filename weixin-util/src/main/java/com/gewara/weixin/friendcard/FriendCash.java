/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.weixin.friendcard;

import java.io.Serializable;

public class FriendCash implements Serializable {
	private static final long serialVersionUID = 4058243259590388342L;
	private Integer least_cost;
	private Integer reduce_cost;
	private CashBaseInfo base_info;
	private CashAdvancedInfo advanced_info;

	public FriendCash() {
	}

	public FriendCash(Integer reduce_cost, CashBaseInfo baseInfo, CashAdvancedInfo advancedInfo) {
		this.least_cost = Integer.valueOf(0);
		this.reduce_cost = reduce_cost;
		this.base_info = baseInfo;
		this.advanced_info = advancedInfo;
	}

	public Integer getLeast_cost() {
		return this.least_cost;
	}

	public void setLeast_cost(Integer least_cost) {
		this.least_cost = least_cost;
	}

	public Integer getReduce_cost() {
		return this.reduce_cost;
	}

	public void setReduce_cost(Integer reduce_cost) {
		this.reduce_cost = reduce_cost;
	}

	public CashBaseInfo getBase_info() {
		return this.base_info;
	}

	public void setBase_info(CashBaseInfo base_info) {
		this.base_info = base_info;
	}

	public CashAdvancedInfo getAdvanced_info() {
		return this.advanced_info;
	}

	public void setAdvanced_info(CashAdvancedInfo advanced_info) {
		this.advanced_info = advanced_info;
	}
}