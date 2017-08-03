package com.gewara.api.pay.response;

import java.util.List;

import com.gewara.api.pay.ApiResponse;
import com.gewara.api.pay.domain.PayRepeatTrade;

public class GetPayRepeatTradeResponse extends ApiResponse {

	private static final long serialVersionUID = -1346157118450733049L;
	
	private Integer total;
	
	private List<PayRepeatTrade> repeatTradeList;
	
	public GetPayRepeatTradeResponse(){}
	
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public GetPayRepeatTradeResponse(List<PayRepeatTrade> repeatTradeList){
		this.repeatTradeList = repeatTradeList;
	}

	public List<PayRepeatTrade> getRepeatTradeList() {
		return repeatTradeList;
	}

	public void setRepeatTradeList(List<PayRepeatTrade> repeatTradeList) {
		this.repeatTradeList = repeatTradeList;
	}
}
