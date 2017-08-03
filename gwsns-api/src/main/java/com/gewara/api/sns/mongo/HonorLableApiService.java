package com.gewara.api.sns.mongo;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;

public interface HonorLableApiService {
	/**
	 * 根据用户id获取用户打标
	 * @param memberid
	 * @return
	 */
	ResultCode<VoMap<Long,List<Map>>> getUserListHonorLableVoMap(List<Long> memberidList);
}
