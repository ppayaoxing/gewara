package com.gewara.api.partner.service;

import com.gewara.api.partner.req.vo.PartnerCommonReqVo;
import com.gewara.api.vo.ResultCode;

public interface PartnerWandaVoService {
	/**
	 * 获取万达选座地址2
	 */
	ResultCode<String> getSeatInfo2(PartnerCommonReqVo reqVo);
	/**
	 * 万达下单2
	 */
	ResultCode<String> createOrder2(PartnerCommonReqVo reqVo);
	/**
	 * 获取特价活动的购买提示（相关的购买限制）
	 * @param sdid
	 * @return
	 */
	ResultCode<String> getSdRemark(PartnerCommonReqVo reqVo);
}
