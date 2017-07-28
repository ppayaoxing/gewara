/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.schedule;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.OpenDramaItemVo;
import com.gewara.drama.vo.OpenTheatreSeatVo;
import com.gewara.drama.vo.TheatreSeatPriceVo;
import java.util.List;
import java.util.Map;

public interface OpenTheatreSeatAdminVoService {
	ResultCode<List<OpenTheatreSeatVo>> copyTheatreRoomSeat(Long arg0, Long arg1, Long arg2);

	ResultCode<TheatreSeatPriceVo> updateOpenTheatreSeatByPriceid(Long arg0, Long arg1);

	ResultCode<TheatreSeatPriceVo> batchUpdateOpenTheatreSeatByPriceid(Long arg0, String arg1, String arg2);

	ResultCode<OpenTheatreSeatVo> lockSeat(Long arg0, String arg1, String arg2);

	ResultCode<OpenTheatreSeatVo> unLockSeat(Long arg0);

	ResultCode<OpenDramaItemVo> batchUnLockSeat(Long arg0, String arg1, String arg2);

	ResultCode<OpenDramaItemVo> batchLockSeat(Long arg0, String arg1, String arg2, String arg3, String arg4);

	ResultCode<List<OpenTheatreSeatVo>> getOpenTheatreSeatByAreaid(Long arg0);

	ResultCode<Map<String, Long>> getLockSeatMapByAreaid(Long arg0);

	ResultCode<Map<String, Long>> getSeatMapByAreaid(Long arg0);

	ResultCode clearSeatMapByAreaid(Long arg0);

	ResultCode reAreaSeat(Long arg0);
}