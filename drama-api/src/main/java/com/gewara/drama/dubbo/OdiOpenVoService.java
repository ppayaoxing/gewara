package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.OpenDramaItemVo;

public interface OdiOpenVoService {
	
	ResultCode<OpenDramaItemVo> updateOdiStats(Long dpid, int expireSeconds, boolean isFinished, boolean refreshPrice);
	
	ResultCode asynchUpdateAreaStats(Long dpid, boolean farcePrice);

}
