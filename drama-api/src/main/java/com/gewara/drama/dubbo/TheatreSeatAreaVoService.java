/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DisQuantityVo;
import com.gewara.drama.vo.OpenTheatreSeatVo;
import com.gewara.drama.vo.TheatreFieldVo;
import com.gewara.drama.vo.TheatreSeatAreaVo;
import com.gewara.drama.vo.TheatreSeatPriceVo;
import com.gewara.drama.vo.cmd.AreaSeatParamsVo;
import com.gewara.drama.vo.cmd.ItemSeatMapVo;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface TheatreSeatAreaVoService {
	ResultCode<TheatreFieldVo> getTheatreFieldById(Long arg0);

	ResultCode<TheatreSeatPriceVo> getTheatreSeatPriceById(Long arg0);

	ResultCode<List<TheatreSeatPriceVo>> getTheatreSeatPriceListByIds(Long... arg0);

	ResultCode<List<TheatreSeatPriceVo>> getTheatreSeatPriceListByIdList(Collection<Long> arg0);

	ResultCode<List<TheatreSeatPriceVo>> getTheatreSeatPriceListByDpid(Long arg0);

	ResultCode<List<TheatreSeatPriceVo>> getTheatreSeatPriceListByAreaid(Long arg0);

	ResultCode<TheatreSeatAreaVo> getTheatreSeatAreaListById(Long arg0);

	ResultCode<List<TheatreSeatAreaVo>> getTheatreSeatAreaListByIds(Long... arg0);

	ResultCode<List<TheatreSeatAreaVo>> getTheatreSeatAreaListByIdList(List<Long> arg0);

	ResultCode<List<TheatreSeatAreaVo>> getTheatreSeatAreaListByDpid(Long arg0);

	ResultCode<List<DisQuantityVo>> getDisQuantityListByDpid(Long arg0);

	ResultCode<DisQuantityVo> getDisQuantityById(Long arg0);

	ResultCode<Map<Long, List<String>>> getAreaRemainRemotePriceByDpid(Long arg0);

	ResultCode<ItemSeatMapVo> getChooseSeat(AreaSeatParamsVo arg0);

	ResultCode<List<OpenTheatreSeatVo>> checkSeatLableByAreaid(Long arg0, String arg1);

	ResultCode<List<OpenTheatreSeatVo>> getAutoSeat(Long arg0, Integer arg1, boolean arg2);
}