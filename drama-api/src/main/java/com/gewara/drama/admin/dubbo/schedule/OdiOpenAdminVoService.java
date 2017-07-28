/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.schedule;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.OpenDramaItemVo;
import java.util.List;

public interface OdiOpenAdminVoService {
	ResultCode refreshAreaSeat(Long arg0, Long arg1, boolean arg2, List<String> arg3);

	ResultCode<OpenDramaItemVo> saveOpenDramaItem(Long arg0);

	ResultCode<OpenDramaItemVo> updateOdiStats(Long arg0, int arg1, boolean arg2, boolean arg3);

	ResultCode asynchUpdateAreaStatsByDpid(Long arg0, boolean arg1);

	ResultCode<OpenDramaItemVo> updateFieldlogo(Long arg0, String arg1);
}