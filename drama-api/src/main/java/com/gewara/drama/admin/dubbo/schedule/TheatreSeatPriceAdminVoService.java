/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.schedule;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreSeatPriceVo;
import com.gewara.drama.vo.cmd.TspExtCommandVo;
import com.gewara.drama.vo.schedule.TheatreSeatPriceExtVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface TheatreSeatPriceAdminVoService {
	ResultCode<TheatreSeatPriceVo> getTheatreSeatPriceById(Long arg0);

	ResultCode<List<TheatreSeatPriceVo>> getTheatreSeatPriceListByDpid(Long arg0);

	ResultCode<List<TheatreSeatPriceVo>> getTheatreSeatPriceListByAreaid(Long arg0);

	ResultCode<List<TheatreSeatPriceVo>> getTheatreSeatPriceByField(String arg0, Serializable arg1);

	ResultCode<List<TheatreSeatPriceVo>> getTheatreSeatPriceByIdList(List<Long> arg0);

	ResultCode correctPrice(Long arg0, TspExtCommandVo arg1);

	ResultCode<TheatreSeatPriceVo> updateTheatreSeatPrice(RequestParamVo arg0);

	ResultCode<TheatreSeatPriceVo> updateTheatreSeatPrice(Long arg0, String arg1, Timestamp arg2);

	ResultCode updateTheatreSeatPriceList(Collection<Long> arg0, String arg1, Timestamp arg2);

	ResultCode<Integer> getTheatreSeatPriceExtCountByDramaid(Long arg0, Long arg1, String arg2, Timestamp arg3,
			Timestamp arg4);

	ResultCode<List<TheatreSeatPriceExtVo>> getTheatreSeatPriceExtList(RequestParamVo arg0);

	ResultCode<List<Long>> getOpenDramaidByPriceExt(Timestamp arg0);

	ResultCode<List<TheatreSeatPriceExtVo>> getTheatreSeatPriceExtListByTspid(Long arg0, String arg1, int arg2,
			int arg3);

	ResultCode<Integer> getTheatreSeatPriceExtCount(Long arg0, String arg1);

	ResultCode<List<TheatreSeatPriceVo>> getTheatreSeatPriceList(Long arg0, int arg1, int arg2);

	ResultCode<TheatreSeatPriceVo> setShowPrice(Long arg0, String arg1);

	ResultCode<TheatreSeatPriceVo> setShowRemark(Long arg0, String arg1);

	ResultCode asynchCreatePriceExt(String arg0, String arg1);

	ResultCode<Map<Long, List<TheatreSeatPriceVo>>> getTheatreSeatPriceMap(List<Long> arg0, String arg1);

	ResultCode<Map<Long, List<TheatreSeatPriceVo>>> getTheatreSeatPriceMapByAreaid(List<Long> arg0, String arg1);
}