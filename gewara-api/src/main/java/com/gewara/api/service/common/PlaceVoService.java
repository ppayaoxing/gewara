package com.gewara.api.service.common;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.common.CityVo;
import com.gewara.api.vo.common.CountyVo;
import com.gewara.api.vo.common.IndexareaVo;
import com.gewara.api.vo.common.ProgramInfoVo;
import com.gewara.api.vo.common.ProvinceVo;

public interface PlaceVoService {
	/**
	 * 获取省份列表
	 * @return
	 */
	ResultCode<List<ProvinceVo>> getProvinceList();
	/**
	 * 根据省份获取城市列表
	 * @return
	 */
	ResultCode<List<CityVo>> getCityListByProvincecode(String provincecode);
	/**
	 * 通过城市编码获取交通路线(key=id, value=name)
	 * @param citycode
	 * @return
	 */
	ResultCode<Map<String, String>> getSubwaylineMap(String citycode);
	
	/**
	 * 获取项目信息
	 * @deprecated 请项目自己实现
	 * @param category
	 * @param categoryid
	 * @return
	 */
	ResultCode<ProgramInfoVo> getProgramInfo(String category, Long categoryid);
	
	
	/**
	 * 根据城市获取区县列表
	 * 
	 * @param appkey
	 * @param citycode
	 * @return
	 */
	ResultCode<List<CountyVo>> countyList(String citycode);

	/**
	 * 根据区县编码获取区县详情
	 * 
	 * @param appkey
	 * @param countyCodes
	 * @return
	 */
	ResultCode<List<CountyVo>> countyListBycodes(List<String> countyCodes);

	/**
	 * 城市的热门商圈
	 * 
	 * @param appkey
	 * @param citycode
	 * @return
	 */
	ResultCode<List<IndexareaVo>> hotIndexareaList(String citycode);
	
	/**
	 * 合作商开放的城市列表
	 * 
	 * @param appkey
	 * @return
	 */
	ResultCode<Map<String, List<CityVo>>> cityList(String appkey);
	
	/**
	 * 获取省份
	 * @return
	 */
	ResultCode<ProvinceVo> getProvince(String provincecode);
}
