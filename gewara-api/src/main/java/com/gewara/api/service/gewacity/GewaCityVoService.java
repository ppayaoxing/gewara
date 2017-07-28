/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.gewacity;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.common.GewaCityVo;
import java.util.List;

public interface GewaCityVoService {
	ResultCode<List<GewaCityVo>> getGewaCityListByCityCodes(String arg0);

	ResultCode<List<String>> getCityCodes();

	ResultCode<Integer> getGewaCityCount();
}