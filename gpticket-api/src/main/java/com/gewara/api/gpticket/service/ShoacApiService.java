package com.gewara.api.gpticket.service;

import com.gewara.api.vo.ResultCode;

public interface ShoacApiService {
	/**
	 * 获取东艺场次票面信息
	 * @param sceneid
	 * @return
	 */
	ResultCode<String> getPrintContent(String sceneid);

}
