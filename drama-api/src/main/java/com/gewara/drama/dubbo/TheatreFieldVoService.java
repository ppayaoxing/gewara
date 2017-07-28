/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreFieldVo;
import java.util.List;

public interface TheatreFieldVoService {
	ResultCode<TheatreFieldVo> getTheatreFieldById(Long arg0);

	ResultCode<List<TheatreFieldVo>> getTheatreFieldList(List<Long> arg0);

	@Deprecated
	ResultCode<List<Long>> getTheatreFieldList(String arg0, Long arg1, boolean arg2);
}