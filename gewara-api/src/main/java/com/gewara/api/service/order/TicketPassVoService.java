package com.gewara.api.service.order;

import com.gewara.api.vo.ResultCode;

public interface TicketPassVoService {
	/**
	 * 获取取票短信密码模板
	 * @return
	 */
	ResultCode<String> getCheckpassTemplate(String tradeNo);
}
