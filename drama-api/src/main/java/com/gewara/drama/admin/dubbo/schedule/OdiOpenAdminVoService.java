package com.gewara.drama.admin.dubbo.schedule;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.OpenDramaItemVo;

public interface OdiOpenAdminVoService {
	
	ResultCode refreshAreaSeat(Long odid, Long areaid, boolean refresh, final List<String> msgList);
	
	ResultCode<OpenDramaItemVo> saveOpenDramaItem(Long dpid);
	
	ResultCode<OpenDramaItemVo> updateOdiStats(Long dpid, int expireSeconds, boolean isFinished, boolean refreshPrice);
	
	ResultCode asynchUpdateAreaStatsByDpid(Long dpid, boolean farcePrice);
	
	ResultCode<OpenDramaItemVo> updateFieldlogo(Long dpid,String fieldlogo);
	
}
