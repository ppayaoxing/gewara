/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.drama;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreItemPriceVo;
import java.util.Date;
import java.util.List;

public interface RemoteTheatreAdminVoService {
	ResultCode<List<String>> updateTheatreField(Long arg0);

	ResultCode<List<String>> updateTheatreRoom(Long arg0);

	ResultCode<List<String>> updateTheatreRoomSeat(Long arg0);

	ResultCode<List<String>> updateDramaPlayItem(Long arg0, Date arg1);

	ResultCode updateDramaPlayItem(String arg0);

	ResultCode<List<String>> updateDramaPlayItem(Long arg0);

	ResultCode<List<String>> refreshAreaSeat(Long arg0);

	ResultCode<List<String>> updateTheateSeatArea(Long arg0);

	ResultCode<List<String>> updateSeatPrice(Long arg0);

	ResultCode<List<String>> updateDisQuantity(Long arg0);

	ResultCode<List<TheatreItemPriceVo>> updateTheaterItemPrice(Long arg0);

	ResultCode<List<String>> updateSeatPrice(Long arg0, List<Long> arg1);

	ResultCode<List<String>> refreshOpenTheatreSeat(Long arg0);
}