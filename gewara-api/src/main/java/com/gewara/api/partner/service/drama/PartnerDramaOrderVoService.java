/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service.drama;

import com.gewara.api.partner.req.drama.vo.PartnerDramaOrderMultiPriceReqVo;
import com.gewara.api.partner.req.drama.vo.PartnerDramaOrderPriceReqVo;
import com.gewara.api.partner.req.drama.vo.PartnerDramaOrderSeatReqVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;

public interface PartnerDramaOrderVoService {
	ResultCode<GewaOrderVo> addDramaOrderBySeat(PartnerDramaOrderSeatReqVo arg0);

	ResultCode<GewaOrderVo> addDramaOrderBySimplePrice(PartnerDramaOrderPriceReqVo arg0);

	ResultCode<GewaOrderVo> addDramaOrderByMultiPrice(PartnerDramaOrderMultiPriceReqVo arg0);
}