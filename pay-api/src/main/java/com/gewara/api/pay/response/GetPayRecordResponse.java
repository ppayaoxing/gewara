package com.gewara.api.pay.response;

import java.util.List;

import com.gewara.api.pay.ApiResponse;
import com.gewara.api.pay.domain.PayRecord;

public class GetPayRecordResponse extends ApiResponse {

	private static final long serialVersionUID = 714349611400026967L;

	private List<PayRecord> payRecordList;
	
	private Integer total;

	public List<PayRecord> getPayRecordList() {
		return payRecordList;
	}

	public void setPayRecordList(List<PayRecord> payRecordList) {
		this.payRecordList = payRecordList;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
