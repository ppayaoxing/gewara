/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreProfileVo;
import com.gewara.drama.vo.TheatreRoomVo;
import com.gewara.drama.vo.TheatreToDramaVo;
import com.gewara.drama.vo.TheatreVo;
import java.sql.Timestamp;
import java.util.List;

public interface TheatreVoService {
	ResultCode<List<TheatreVo>> getTheatreList(String arg0, String arg1, boolean arg2, int arg3, int arg4);

	ResultCode<List<TheatreVo>> getTheatreList(String arg0);

	ResultCode<TheatreVo> getTheatreById(Long arg0);

	ResultCode<List<TheatreVo>> getTheatreListByIdList(Long... arg0);

	ResultCode<List<TheatreVo>> getTheatreListByUpdatetime(Timestamp arg0, int arg1, int arg2);

	ResultCode<List<TheatreVo>> getTheatreListByCitycodeAndDramaid(String arg0, Long arg1, int arg2, int arg3);

	ResultCode<List<TheatreToDramaVo>> getTheatreToDramaListByTheatreid(Long arg0, int arg1, int arg2);

	ResultCode<List<TheatreToDramaVo>> getTheatreToDramaListByDramaid(Long arg0);

	ResultCode<List<TheatreVo>> getTheatreListByHotvalue(String arg0, Integer arg1, int arg2, int arg3);

	ResultCode<TheatreVo> getTheatreByName(String arg0);

	ResultCode<Integer> getTheatreCountByBooking(String arg0);

	ResultCode<TheatreRoomVo> getTheatreRoomById(Long arg0);

	ResultCode<TheatreProfileVo> getTheatreProfileById(Long arg0);

	ResultCode<List<TheatreVo>> getTheatreListByCityCodeAndEndTime(String arg0, int arg1);

	ResultCode<List<Long>> getTheatreIdList(String arg0, Long arg1, boolean arg2);
}