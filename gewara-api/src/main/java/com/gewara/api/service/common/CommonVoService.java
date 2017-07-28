/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.common;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.common.CountyVo;
import com.gewara.api.vo.common.GewaCityVo;
import java.util.List;
import java.util.Map;

public interface CommonVoService {
	ResultCode<List<GewaCityVo>> getAllGewaCityList();

	ResultCode<List<CountyVo>> getCountyListByCitycode(String arg0);

	ResultCode<String> filterContentKey(String arg0);

	ResultCode<Map> getDataById(String arg0);

	ResultCode<Map> getFanPingDataById(String arg0);
}