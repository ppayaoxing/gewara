package com.gewara.api.partner.service.mall;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;

public interface PartnerMallVoService {
	/**
	 * 商城订单使用特价活动
	 * @param sessId
	 * @param remoteIp
	 * @param tradeNo
	 * @param sdid
	 * @return
	 */
	ResultCode<GewaOrderVo> useSpecialDiscount(String sessId, String remoteIp, String tradeNo, Long sdid);
}
