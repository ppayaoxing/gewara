package com.gewara.drama.dubbo.partner;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.partner.req.PartnerCommonReqVo;
import com.gewara.drama.vo.partner.res.OdiTheatreSeatExtraVo;

public interface PartnerDpiVoService {
	
	/**
	 * 获取区域价格及座位图信息
	 * @param reqVo
	 * @return
	 */
	ResultCode<OdiTheatreSeatExtraVo> getCacheSeatByTheatreSeatArea(PartnerCommonReqVo reqVo);
	
	/**
	 * 获取区域价格及座位图信息
	 * @param reqVo
	 * @return
	 */
	ResultCode<OdiTheatreSeatExtraVo> getOpenTheatreSeatByTheatreSeatArea(PartnerCommonReqVo reqVo);
}
