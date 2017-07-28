/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreItemPriceVo;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface TheatreItemPriceVoService {
	ResultCode<TheatreItemPriceVo> getTheatreItemPriceById(Long arg0);

	ResultCode<List<TheatreItemPriceVo>> geTheatreItemPriceListByDramaid(Long arg0);

	ResultCode<List<Long>> geTheatreItemPricesByDramaid(Long arg0);

	ResultCode<Map<Long, List<TheatreItemPriceVo>>> getTheatreItemPriceListMap(List<Long> arg0);

	ResultCode<List<Long>> getTheatreItemPriceIdList(List<Long> arg0);

	ResultCode<List<TheatreItemPriceVo>> getTheatreItemPriceList(Long arg0);

	ResultCode<List<TheatreItemPriceVo>> getTheatreItemPriceList(List<Long> arg0);

	ResultCode<List<TheatreItemPriceVo>> getTheatreItemPriceListByUpdateTime(Timestamp arg0, Timestamp arg1);
}