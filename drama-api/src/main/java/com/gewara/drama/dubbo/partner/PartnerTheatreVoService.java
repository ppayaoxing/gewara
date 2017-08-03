package com.gewara.drama.dubbo.partner;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreVo;
import com.gewara.drama.vo.partner.req.PartnerCommonReqVo;
import com.gewara.drama.vo.partner.req.PartnerTheatreReqVo;

public interface PartnerTheatreVoService {

	/**
	 * 获取当前项目演出所有的场馆
	 * @param reqVo
	 * @return
	 */
	ResultCode<TheatreVo> getCurTheatreVo(PartnerCommonReqVo reqVo);
	
	/**
	 * 获取当前项目可购票场馆
	 * @param reqVo
	 * @return
	 */
	ResultCode<List<TheatreVo>> getBookingTheatreList(PartnerTheatreReqVo reqVo);
}
