package com.gewara.api.pay.response;

import java.util.List;

import com.gewara.api.pay.ApiResponse;
import com.gewara.api.pay.domain.Gateway;

public class GatewayGetAllResponse extends ApiResponse {

	private static final long serialVersionUID = -1205041632378397388L;
	
	private List<Gateway> gatewayList;

	public List<Gateway> getGatewayList() {
		return gatewayList;
	}

	public void setGatewayList(List<Gateway> gatewayList) {
		this.gatewayList = gatewayList;
	}
	
}
