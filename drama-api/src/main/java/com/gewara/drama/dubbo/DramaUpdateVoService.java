package com.gewara.drama.dubbo;

import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.order.DramaOrderContainerVo;

public interface DramaUpdateVoService {

	/**
	 * 更新统计
	 * @param orderid
	 * @return
	 */
	ResultCode<DramaOrderContainerVo> updateStatistics(String tradeno);
	
	/**
	 * 更新统计（新）
	 * @param orderid
	 * @return
	 */
	ResultCode updateDramaStatistics(String tradeno);
	
	/**
	 * 更新统计（openapi）
	 * @param tag
	 * @param relatedid
	 * @param data
	 * @return
	 */
	ResultCode updateDramaData(String tag, Long relatedid, Map<String, Integer> data);
}
