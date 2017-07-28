/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.refund;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.cmd.order.ParamsVo;
import com.gewara.api.vo.pay.AccountRefundVo;
import com.gewara.api.vo.pay.PayGatewayVo;
import com.gewara.api.vo.pay.PayMerchantVo;
import com.gewara.api.vo.pay.RefundMerchantVo;
import java.util.List;

public interface AccountRefundVoService {
	ResultCode<List<AccountRefundVo>> getAccountRefundList(ParamsVo arg0);

	ResultCode<Integer> getAccountRefundCount(ParamsVo arg0);

	ResultCode<List<AccountRefundVo>> getAccountRefundListByDepartment(ParamsVo arg0);

	ResultCode<Integer> getAccountRefundCountByDepartment(ParamsVo arg0);

	ResultCode<List<AccountRefundVo>> getRefundListForTradenoBack(ParamsVo arg0);

	ResultCode<List<AccountRefundVo>> getRefundListByDepForTradenoBack(ParamsVo arg0);

	ResultCode<List<PayGatewayVo>> getAllSynGateway();

	ResultCode<List<RefundMerchantVo>> getAllRefundMerchant();

	ResultCode<List<RefundMerchantVo>> getRefundMerchantListByGatewayId(Long arg0);

	ResultCode<PayGatewayVo> getSynGatewayByGatewayCode(String arg0);

	ResultCode<List<PayMerchantVo>> getAllPayMerchant();

	ResultCode<List<PayMerchantVo>> getMerchantCodeByGatewayCode(String arg0);

	ResultCode<List<PayGatewayVo>> getGatewayBySupportRefund(String arg0);
}