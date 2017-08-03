package com.gewara.api.pay.response;

import com.gewara.api.pay.ApiResponse;
import com.gewara.api.pay.domain.Gateway;

public class GatewayGetResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -693570864939379222L;


	private Gateway gateway;


	public Gateway getGateway() {
		return gateway;
	}


	public void setGateway(Gateway gateway) {
		this.gateway = gateway;
	}
}
