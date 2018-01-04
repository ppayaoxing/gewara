package com.gewara.api.service.movie;

import java.util.Map;

import com.gewara.api.vo.ResultCode;

public interface CityRoomCharacteristicVoService {
	/**
	 * 根据id(cityCode)查询城市影厅特色
	 * @param cityCode
	 * @return
	 */
	ResultCode<Map<String,String>> getCharacteristicRoomById(String cityCode);
}
