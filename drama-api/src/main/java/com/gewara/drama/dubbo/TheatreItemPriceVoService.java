package com.gewara.drama.dubbo;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreItemPriceVo;

public interface TheatreItemPriceVoService {
	
	ResultCode<TheatreItemPriceVo> getTheatreItemPriceById(Long id);
	
	ResultCode<List<TheatreItemPriceVo>> geTheatreItemPriceListByDramaid(Long dramaid);
	
	ResultCode<List<Long>> geTheatreItemPricesByDramaid(Long dramaid);
	
	ResultCode<Map<Long,List<TheatreItemPriceVo>>> getTheatreItemPriceListMap(List<Long> dpidList);
	
	ResultCode<List<Long>> getTheatreItemPriceIdList(List<Long> dpidList);
	
	ResultCode<List<TheatreItemPriceVo>> getTheatreItemPriceList(Long dpid);
	
	ResultCode<List<TheatreItemPriceVo>> getTheatreItemPriceList(List<Long> idList);
	
	/**
	 * 根据开始、结束时间获取项目价格
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	ResultCode<List<TheatreItemPriceVo>> getTheatreItemPriceListByUpdateTime(Timestamp startTime, Timestamp endTime);

}
