package com.gewara.api.partner.service.drama;

import com.gewara.api.partner.req.drama.vo.PartnerDramaOrderMultiPriceReqVo;
import com.gewara.api.partner.req.drama.vo.PartnerDramaOrderPriceReqVo;
import com.gewara.api.partner.req.drama.vo.PartnerDramaOrderSeatReqVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;

public interface PartnerDramaOrderVoService {

	/**
	 * 选座下单
	 * @param reqVo
	 * @return
	 */
	ResultCode<GewaOrderVo> addDramaOrderBySeat(PartnerDramaOrderSeatReqVo reqVo);
	
	/**
	 * 选择单一价格下单
	 * @param reqVo
	 * @return
	 */
	ResultCode<GewaOrderVo> addDramaOrderBySimplePrice(PartnerDramaOrderPriceReqVo reqVo);
	
	/**
	 * 选择支持多个价格下单
	 * @param reqVo
	 * @return
	 */
	ResultCode<GewaOrderVo> addDramaOrderByMultiPrice(PartnerDramaOrderMultiPriceReqVo reqVo);
}
