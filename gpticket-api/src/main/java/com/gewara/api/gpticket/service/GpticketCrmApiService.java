package com.gewara.api.gpticket.service;

import java.util.Map;

import com.gewara.api.vo.ResultCode;

public interface GpticketCrmApiService {
	/**
	 * 获取用户优惠折扣
	 * @param programid
	 * @param scheduleid
	 * @param mobile
	 * @return
	 */
	ResultCode<Map> getMemberDiscount(String scheduleid, String mobile);

}
