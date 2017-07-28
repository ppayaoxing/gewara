/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gworder.service;

import com.gewara.api.gworder.vo.CreateGoodsOrderReq;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.order.GewaOrderVo;
import com.gewara.api.vo.pay.OtherFeeDetailVo;

public interface OrderOperationService {
	ResultCode<GewaOrderVo> createGoodsOrder(CreateGoodsOrderReq arg0);

	ResultCode<OtherFeeDetailVo> saveExpressFee(Long arg0, int arg1, int arg2, String arg3, OtherFeeDetailVo arg4);

	ResultCode changeDramaPreTypeTExpress(Long arg0, String arg1);

	ResultCode clearExpressFee(Long arg0, String arg1, String arg2, int arg3, Long arg4);

	ResultCode partnerPayNotify(String arg0, String arg1, String arg2, String arg3, String arg4);

	ResultCode gewaPayToConfirm(Long arg0);

	ResultCode cancelRemoteTicket(String arg0);

	ResultCode<GewaOrderVo> removeTicketOrderBuyItem(Long arg0, Long arg1);
}