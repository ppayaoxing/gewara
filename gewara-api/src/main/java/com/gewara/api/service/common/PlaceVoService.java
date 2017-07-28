/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.common;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.common.CityVo;
import com.gewara.api.vo.common.CountyVo;
import com.gewara.api.vo.common.IndexareaVo;
import com.gewara.api.vo.common.ProgramInfoVo;
import com.gewara.api.vo.common.ProvinceVo;
import java.util.List;
import java.util.Map;

public interface PlaceVoService {
	ResultCode<List<ProvinceVo>> getProvinceList();

	ResultCode<List<CityVo>> getCityListByProvincecode(String arg0);

	ResultCode<Map<String, String>> getSubwaylineMap(String arg0);

	ResultCode<ProgramInfoVo> getProgramInfo(String arg0, Long arg1);

	ResultCode<List<CountyVo>> countyList(String arg0);

	ResultCode<List<CountyVo>> countyListBycodes(List<String> arg0);

	ResultCode<List<IndexareaVo>> hotIndexareaList(String arg0);

	ResultCode<Map<String, List<CityVo>>> cityList(String arg0);

	ResultCode<ProvinceVo> getProvince(String arg0);
}