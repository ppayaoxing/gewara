/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.order.DramaOrderContainerVo;
import java.util.Map;

public interface DramaUpdateVoService {
	ResultCode<DramaOrderContainerVo> updateStatistics(String arg0);

	ResultCode updateDramaStatistics(String arg0);

	ResultCode updateDramaData(String arg0, Long arg1, Map<String, Integer> arg2);
}