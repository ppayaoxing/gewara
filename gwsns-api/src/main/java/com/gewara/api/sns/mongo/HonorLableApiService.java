/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.mongo;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import java.util.List;
import java.util.Map;

public interface HonorLableApiService {
	ResultCode<VoMap<Long, List<Map>>> getUserListHonorLableVoMap(List<Long> arg0);
}