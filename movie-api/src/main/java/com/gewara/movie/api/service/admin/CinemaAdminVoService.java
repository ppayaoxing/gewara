/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.CinemaRoomVo;
import com.gewara.movie.vo.CinemaVo;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface CinemaAdminVoService {
	ResultCode<List<Long>> getBookingOpenCinemaIdListByCityCodes(List<String> arg0);

	ResultCode<List<Map>> getCinemaNameAndIdListByCityCodes(List<String> arg0);

	ResultCode<List<CinemaVo>> getCinemaListByCitycodeForPage(String arg0, int arg1, int arg2);

	ResultCode<List<CinemaVo>> getCinemaPlaceByName(String arg0, String arg1);

	ResultCode<List<CinemaVo>> getOpiCinemaList(String arg0, Long arg1, Date arg2);

	ResultCode<CinemaVo> saveOrUpdateCinema(RequestParamVo arg0, boolean arg1);

	ResultCode<CinemaVo> updateCinemaProperties(Long arg0, String[] arg1, Serializable[] arg2);

	ResultCode<List<CinemaVo>> getCinemaListByKeyAndCityCode(String arg0, String arg1);

	ResultCode<CinemaVo> updateRecommendRoom(Long arg0, Long arg1, boolean arg2);

	ResultCode<List<CinemaVo>> getCinemaListForPage(String arg0, boolean arg1, int arg2, int arg3);

	ResultCode<LinkedList<String>> initImportCinemaPcid(String arg0);

	ResultCode<List<CinemaRoomVo>> getReportCinemaRoomList(Long arg0, String arg1, String arg2, Integer arg3,
			Integer arg4);

	ResultCode<CinemaVo> getCinemaById(Long arg0);
}