/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.response;

import com.gewara.api.pay.ApiResponse;
import com.gewara.api.pay.domain.Gateway;
import java.util.List;

public class GatewayGetAllResponse extends ApiResponse {
	private static final long serialVersionUID = -1205041632378397388L;
	private List<Gateway> gatewayList;

	public List<Gateway> getGatewayList() {
		return this.gatewayList;
	}

	public void setGatewayList(List<Gateway> gatewayList) {
		this.gatewayList = gatewayList;
	}
}