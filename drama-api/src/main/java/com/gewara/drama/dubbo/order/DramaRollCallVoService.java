package com.gewara.drama.dubbo.order;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.req.CheckMultiDramaRollCallReq;
import com.gewara.drama.vo.req.CheckSimpleDramaRollCallReq;

public interface DramaRollCallVoService {

	/**
	 * 验证所购票项目是否受限制(新)
	 * @param siteSource	站点 web, wap 
	 * @param dramaid		项目ID
	 * @param theatreid		场馆ID
	 * @param member		用户
	 * @param mobile		手机号
	 * @param dpid			场次ID
	 * @param buyCount		购票数量
	 * @return
	 */
	ResultCode dramaRollCallByDpid(String siteSource, Long dramaid, Long theatreid, Long memberid, String mobile, Long dpid, Integer buyCount);
	
	ResultCode checkSimpleDramaRollCall(CheckSimpleDramaRollCallReq req);

	/**
	 * 验证所购票项目是否受限制(新)
	 * @param siteSource	站点 web, wap 
	 * @param dramaid		项目ID
	 * @param theatreid		场馆ID
	 * @param member		用户
	 * @param mobile		手机号
	 * @param dpidList		场次ID List
	 * @param buyCountMap	场次购票数量
	 * @return
	 */
	ResultCode dramaRollCallByDpidList(String siteSource, Long dramaid, Long theatreid, Long memberid, String mobile, List<Long> dpidList, Map<Long, Integer> buyCountMap);
	
	ResultCode checkMultiDramaRollCall(CheckMultiDramaRollCallReq req);
	
	
	ResultCode isDramaSpecialRollCallByPlaytime(Long dramaid, Long theatreid, Long memberid, String mobile, String playtime);



}
