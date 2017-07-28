/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;

public interface DramaMarkVoService {
	ResultCode saveOrUpdateMark(String arg0, Long arg1, String arg2, Integer arg3, boolean arg4);

	ResultCode saveOrUpdatePoint(String arg0, Long arg1, String arg2, String arg3, String arg4);

	ResultCode updateFirstPicture(String arg0, Long arg1, String arg2);
}