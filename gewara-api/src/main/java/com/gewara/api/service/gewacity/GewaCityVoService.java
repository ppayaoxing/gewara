package com.gewara.api.service.gewacity;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.common.GewaCityVo;

/**
 * 格瓦拉城市Service
 *
 */
public interface GewaCityVoService {
	/**
	 * 根据CityCode数组获取GewaCity列表
	 * @param cityCodes
	 * @return
	 */
	ResultCode<List<GewaCityVo>> getGewaCityListByCityCodes(String cityCodes);
	
	
	/**
	 * 获取所有城市编码
	 * @return
	 */
	ResultCode<List<String>> getCityCodes();
	
	/**
	 * 获取城市总数
	 * @return
	 */
	ResultCode<Integer> getGewaCityCount();
	
}
