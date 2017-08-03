package com.gewara.drama.dubbo;

import java.util.Collection;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaPlayItemVo;
import com.gewara.drama.vo.OpenDramaItemExtVo;
import com.gewara.drama.vo.OpenDramaItemVo;

public interface DpiVoService {

	/**
	 * 查询场次信息
	 * @param dpid
	 * @return
	 */
	ResultCode<OpenDramaItemVo> getOpenDramaItemByDpid(Long dpid);
	
	ResultCode<List<OpenDramaItemVo>> getOpenDramaItemListByDpid(Long ...dpid);
	
	ResultCode<DramaPlayItemVo> getDramaPlayItemById(Long id);
	
	ResultCode<List<DramaPlayItemVo>> getDramaPlayItemListById(Long ...id);
	
	ResultCode<Integer> getDramaPlayItemCountByDramaid(Long dramaid);
	
	ResultCode<List<DramaPlayItemVo>> getDramaPlayItemListByCitycode(String citycode, Long dramaid, boolean isPartner, boolean booking);
	
	ResultCode<List<OpenDramaItemVo>> getOpenDramaItemListCache(String citycode, Long theatreid, Long dramaid, boolean isOpen, boolean isPartner);
	
	ResultCode<List<OpenDramaItemVo>> getOpenDramaItemExpireListByTheatreid(Long theatreid, Long dramaid);
	
	ResultCode<List<DramaPlayItemVo>> getDramaPlayItemListByTheatreid(Long dramaid, Long theatreid, boolean isPartner, boolean booking);
	
	ResultCode<Boolean> isBookingByDramaId(Long dramaid);
	
	ResultCode<OpenDramaItemExtVo> getOdiExtbyDpid(Long dpid);
	
	ResultCode<List<OpenDramaItemExtVo>> getOdiExtbyDpidList(Collection<Long> dpidList);
}
