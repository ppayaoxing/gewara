package com.gewara.api.service.mobile;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.mobile.CommendActivityVo;

public interface MobileVoService {
	ResultCode<List<CommendActivityVo>> getCommendActivityList(int from, int maxnum);
	
	/**
	 * pc wap ºì°üµ÷ÓÃ
	 */
	
	ResultCode<Map<String, String>> hasRedEnvelope(Long movieid,Long memberid);
}
