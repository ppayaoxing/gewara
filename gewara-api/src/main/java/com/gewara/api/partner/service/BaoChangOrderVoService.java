package com.gewara.api.partner.service;

import com.gewara.api.partner.req.vo.PartnerAddOrderReqVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;

public interface BaoChangOrderVoService {
	/**
	 * 包场场次，土豪朋友选座下单，系统完成支付
	 * @param reqVo
	 * @return
	 */
	ResultCode<GewaOrderVo> addBaoChangTicketOrder(PartnerAddOrderReqVo reqVo);
	/**
	 * 包场场次，开场前35分钟，未卖出的座位系统自动下单并完成确认
	 * @param mpid
	 * @param secid
	 * @param seatLabel
	 * @param remoteIp
	 * @return
	 */
	ResultCode<GewaOrderVo> addBaoChangTicketOrder4Remain(Long mpid, String secid, String seatLabel, String remoteIp);
}
