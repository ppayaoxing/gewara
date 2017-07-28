/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.baochang.BaoChangMpiInfoVo;
import com.gewara.movie.vo.baochang.BaoChangOrderInfoVo;
import java.util.List;
import java.util.Map;

public interface BaoChangAdminVoService {
	ResultCode saveOrUpdateBaoChangCinemaInfo(Long arg0, Long arg1, Map<String, String> arg2,
			List<Map<String, String>> arg3);

	ResultCode deleteBaoChangCinemaRoom(Long arg0, Long arg1);

	ResultCode<List<Long>> deleteBaoChangCinema(Long arg0);

	ResultCode<BaoChangOrderInfoVo> saveMpidToBaoChangOrder(Long arg0, Long arg1, String arg2, String arg3,
			Integer arg4);

	ResultCode saveBaoChangMsgContent(String arg0, String arg1, String arg2);

	ResultCode refreshBaoChangInfoCacheByCinemaid(Long arg0);

	ResultCode refreshBaoChangInfoCacheByCinemaidAndRoomid(Long arg0, Long arg1);

	ResultCode saveOrUpdateBaoChangMpiInfo(Long arg0);

	ResultCode<BaoChangMpiInfoVo> deleteBaoChangMpiInfo(Long arg0, Long arg1);
}