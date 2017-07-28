/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.CinemaRoomVo;
import java.io.Serializable;

public interface CinemaRoomAdminVoService {
	ResultCode<CinemaRoomVo> addOuterRingSeat(Long arg0, String arg1, String arg2);

	ResultCode<CinemaRoomVo> updateCinemaRoomProperties(Long arg0, Long arg1, String[] arg2, Serializable[] arg3);

	ResultCode<CinemaRoomVo> saveOrUpdateCinemaRoom(RequestParamVo arg0);

	ResultCode<String> updateCinemaRoomData();

	ResultCode<String> updateRoom(RequestParamVo arg0);

	ResultCode updateCinemaRoomByTicketRoom(Long arg0);
}