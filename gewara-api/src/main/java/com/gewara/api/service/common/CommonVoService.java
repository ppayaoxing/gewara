package com.gewara.api.service.common;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.common.CountyVo;
import com.gewara.api.vo.common.GewaCityVo;

public interface CommonVoService {
	ResultCode<List<GewaCityVo>> getAllGewaCityList();

	/**
	 * 获取区域信息
	 * @param citycode
	 * @return
	 */
	ResultCode<List<CountyVo>> getCountyListByCitycode(String citycode);
	/**
	 * 得到非法关键字
	 * @param content
	 * @return
	 */
	ResultCode<String> filterContentKey(String content);
	
	/**
	 * 根据id获取切图模板
	 * @param id
	 * @return
	 */
	ResultCode<Map> getDataById(String id);
	/**
	 * 根据id获取翻屏模板
	 * @param id
	 * @return
	 */
	ResultCode<Map> getFanPingDataById(String id);

	ResultCode<List<GewaCityVo>> getAllGewaCity();
}
