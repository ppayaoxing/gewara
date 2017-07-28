/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.OpenDramaItemVo;

public interface OdiOpenVoService {
	ResultCode<OpenDramaItemVo> updateOdiStats(Long arg0, int arg1, boolean arg2, boolean arg3);

	ResultCode asynchUpdateAreaStats(Long arg0, boolean arg1);
}