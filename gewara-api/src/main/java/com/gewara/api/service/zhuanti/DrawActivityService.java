package com.gewara.api.service.zhuanti;

import java.util.Map;

import com.gewara.api.vo.ResultCode;

public interface DrawActivityService {

	/**
	 * 根据专题模板id获取抽奖信息
	 * @param drawId
	 * @return
	 */
	ResultCode<Map> findDrawDetailById(Long drawId);

}
