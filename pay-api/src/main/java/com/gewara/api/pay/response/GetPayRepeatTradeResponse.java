/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response;

import com.gewara.api.pay.ApiResponse;
import com.gewara.api.pay.domain.PayRepeatTrade;
import java.util.List;

public class GetPayRepeatTradeResponse extends ApiResponse {
	private static final long serialVersionUID = -1346157118450733049L;
	private Integer total;
	private List<PayRepeatTrade> repeatTradeList;

	public GetPayRepeatTradeResponse() {
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public GetPayRepeatTradeResponse(List<PayRepeatTrade> repeatTradeList) {
		this.repeatTradeList = repeatTradeList;
	}

	public List<PayRepeatTrade> getRepeatTradeList() {
		return this.repeatTradeList;
	}

	public void setRepeatTradeList(List<PayRepeatTrade> repeatTradeList) {
		this.repeatTradeList = repeatTradeList;
	}
}