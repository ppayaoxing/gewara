package com.gewara.movie.api.service.admin;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;

public interface CityPriceTierAdminVoService {
	
	/**
	 * 根据id删除城市所在类别
	 * @param cityCode
	 * @return
	 */
	ResultCode removeCityPriceTierById(String cityCode);
	
	/**
	 * 新增/更新城市所在类别
	 * @param cityPriceTier
	 */
	ResultCode saveOrUpdateCityPriceTier(Map cityPriceTier);
	
	/**
	 * 获取所有城市所在类别
	 * @return
	 */
	ResultCode<List<Map>> getAllCityPriceTier();
	
	/**
	 * 根据id(citycode)查询城市所在类别
	 * @param citycode
	 * @return
	 */
	ResultCode<Map> getCityPriceTierById(String citycode);
}
