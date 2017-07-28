/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response;

import com.gewara.api.pay.ApiResponse;
import com.gewara.api.pay.domain.PayRecord;
import java.util.List;

public class GetPayRecordResponse extends ApiResponse {
	private static final long serialVersionUID = 714349611400026967L;
	private List<PayRecord> payRecordList;
	private Integer total;

	public List<PayRecord> getPayRecordList() {
		return this.payRecordList;
	}

	public void setPayRecordList(List<PayRecord> payRecordList) {
		this.payRecordList = payRecordList;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}