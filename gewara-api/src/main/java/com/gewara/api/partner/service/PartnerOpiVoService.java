package com.gewara.api.partner.service;

import java.util.Map;

import com.gewara.api.partner.req.vo.PartnerCommonReqVo;
import com.gewara.api.partner.res.vo.OpiSeatVo;
import com.gewara.api.vo.ResultCode;

public interface PartnerOpiVoService {
	/**
	 * 获取缓存座位图
	 * @param reqVo
	 * @return
	 */
	ResultCode<OpiSeatVo> getOpiCacheSeat(PartnerCommonReqVo reqVo);
	/**
	 * 获取实时座位图
	 * @param reqVo
	 * @return
	 */
	ResultCode<OpiSeatVo> getOpiSeat(PartnerCommonReqVo reqVo);
	
	ResultCode<Map<String, String>> getCachedRemoteLockSeat(Long mpid, String secid);
}
