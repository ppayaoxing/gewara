package com.gewara.api.service.refund;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.cmd.order.ParamsVo;
import com.gewara.api.vo.pay.AccountRefundVo;
import com.gewara.api.vo.pay.PayGatewayVo;
import com.gewara.api.vo.pay.PayMerchantVo;
import com.gewara.api.vo.pay.RefundMerchantVo;

public interface AccountRefundVoService {
	ResultCode<List<AccountRefundVo>> getAccountRefundList(ParamsVo param);
	
	ResultCode<Integer> getAccountRefundCount(ParamsVo param);
	
	/**
	 * 根据部门查询退款信息
	 * @param param
	 * @return
	 */
	ResultCode<List<AccountRefundVo>> getAccountRefundListByDepartment(ParamsVo param);
	ResultCode<Integer> getAccountRefundCountByDepartment(ParamsVo param);
	ResultCode<List<AccountRefundVo>> getRefundListForTradenoBack(ParamsVo param);
	ResultCode<List<AccountRefundVo>> getRefundListByDepForTradenoBack(ParamsVo param);
	ResultCode<List<PayGatewayVo>> getAllSynGateway();
	ResultCode<List<RefundMerchantVo>> getAllRefundMerchant();
	ResultCode<List<RefundMerchantVo>> getRefundMerchantListByGatewayId(Long gatewayId);
	ResultCode<PayGatewayVo> getSynGatewayByGatewayCode(String gatewayCode);
	ResultCode<List<PayMerchantVo>> getAllPayMerchant();
	ResultCode<List<PayMerchantVo>> getMerchantCodeByGatewayCode(String gatewayCode);
	ResultCode<List<PayGatewayVo>> getGatewayBySupportRefund(String supportRefund);

}
