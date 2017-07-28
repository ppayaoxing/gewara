/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gworder.service;

import com.gewara.api.gworder.vo.CinemaMerchantGoodsStatisVo;
import com.gewara.api.gworder.vo.ProcessOrderPayVo;
import com.gewara.api.gworder.vo.ValidateOpenApiPayVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.CheckAddOrderGoodsGiftRes;
import java.sql.Timestamp;
import java.util.Map;

public interface SHGwOrderVoService {
	ResultCode bindOrderGoodsGift(String arg0);

	ResultCode addOrderGoodsGift(String arg0, Long arg1, Integer arg2);

	ResultCode addSpid2OrderOtherinfo(String arg0, String arg1, Long arg2);

	ResultCode<ProcessOrderPayVo> processOrderPay(String arg0);

	ResultCode<Map<String, CinemaMerchantGoodsStatisVo>> getCinemaStatisData(String arg0, Long arg1, Timestamp arg2);

	ResultCode<ValidateOpenApiPayVo> validateOpenApiPay(String arg0, String arg1, String arg2, String arg3,
			String arg4);

	ResultCode<CheckAddOrderGoodsGiftRes> checkAddOrderGoodsGift(String arg0, Long arg1, Integer arg2);
}