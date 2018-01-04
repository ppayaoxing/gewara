package com.gewara.api.partner.service;

import com.gewara.api.vo.ResultCode;

public interface PartnerPsbcappVoService {
	/**
	 * 验证邮储银行订单
	 * 
	 * @param userid   合作商订单用户唯一标识
	 * @param seatcount 座位数
	 * @return
	 */
	ResultCode<Boolean> validPsbcappOrder(String userid, Integer seatcount);
}
