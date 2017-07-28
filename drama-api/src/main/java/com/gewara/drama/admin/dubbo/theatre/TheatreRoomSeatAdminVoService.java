/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.theatre;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreRoomSeatVo;
import com.gewara.drama.vo.TheatreRoomVo;
import java.util.List;

public interface TheatreRoomSeatAdminVoService {
	ResultCode<List<TheatreRoomSeatVo>> getTheatreRoomSeatList(Long arg0);

	ResultCode<TheatreRoomVo> addRowSeat(Long arg0);

	ResultCode<TheatreRoomVo> addRankSeat(Long arg0);

	ResultCode<Boolean> deleteRankSeatByRoomid(Long arg0);

	ResultCode<Boolean> deleteRowSeatByRoomid(Long arg0);

	ResultCode<TheatreRoomSeatVo> getTheatreRoomSeatByPosition(Long arg0, int arg1, int arg2);

	ResultCode<Boolean> updateSeatlineByRoomSeatLineno(Long arg0, int arg1, String arg2);

	ResultCode<Boolean> updateSeatrankByRoomSeatRankno(Long arg0, int arg1, String arg2);

	ResultCode batchAddTheatreRoomSeat(Long arg0, String arg1, String arg2);

	ResultCode batchDeleteTheatreRoomSeat(Long arg0, String arg1, String arg2);

	ResultCode updateTheatreRoomSeatInitStatus(Long arg0, String arg1);

	ResultCode updateTheatreRoomSeatLoveInd(Long arg0, String arg1);

	ResultCode<TheatreRoomVo> updateTheatreRoomSeatMapStr(Long arg0);

	ResultCode<TheatreRoomVo> getTheatreRoomById(Long arg0);

	ResultCode addBaseSeat(RequestParamVo arg0);

	ResultCode clearBaseSeat(RequestParamVo arg0);

	ResultCode updateBaseSeatRankNo(RequestParamVo arg0);
}