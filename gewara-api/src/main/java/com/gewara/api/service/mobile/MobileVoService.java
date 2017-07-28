/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.mobile;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.mobile.CommendActivityVo;
import java.util.List;
import java.util.Map;

public interface MobileVoService {
	ResultCode<List<CommendActivityVo>> getCommendActivityList(int arg0, int arg1);

	ResultCode<Map<String, String>> hasRedEnvelope(Long arg0, Long arg1);
}