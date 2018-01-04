package com.gewara.api.service.order;

import com.gewara.api.vo.ResultCode;

public interface TicketRollCallVoService {
	/**
	 * 判断是否是黄牛用户
	 * @param memberId
	 * @param mobile
	 * @return
	 */
	ResultCode<Boolean> isTicketRollCallMember(Long memberId, String mobile);
}
