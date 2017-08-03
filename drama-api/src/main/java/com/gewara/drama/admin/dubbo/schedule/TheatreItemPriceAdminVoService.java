package com.gewara.drama.admin.dubbo.schedule;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreItemPriceVo;

public interface TheatreItemPriceAdminVoService {
	
	ResultCode<TheatreItemPriceVo> getTheatreItemPriceById(Long id);
	
	ResultCode<List<TheatreItemPriceVo>> geTheatreItemPriceListByDramaid(Long dramaid);
	
	ResultCode<List<Long>> geTheatreItemPricesByDramaid(Long dramaid);
	
	ResultCode<TheatreItemPriceVo> saveTheatreItemPrices(RequestParamVo paramVo);
	
	ResultCode<Map<Long,List<TheatreItemPriceVo>>> getTheatreItemPriceListMap(List<Long> dpidList);
	
	ResultCode<List<Long>> getTheatreItemPriceIdList(List<Long> dpidList);
	
	ResultCode<List<TheatreItemPriceVo>> getTheatreItemPriceList(Long dpid);
	
	ResultCode<List<TheatreItemPriceVo>> getTheatreItemPriceListByIdList(Collection<Long> idList);

}
