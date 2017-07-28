/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.pay;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.pay.BSCardVo;
import com.gewara.api.vo.pay.DiscountVo;
import com.gewara.api.vo.pay.ElecCardBatchVo;
import com.gewara.api.vo.pay.ElecCardVo;
import com.gewara.api.vo.pay.OtherFeeDetailVo;
import com.gewara.api.vo.pay.PayMethodInfoVo;
import com.gewara.api.vo.pay.PayMethodVo;
import com.gewara.api.vo.pay.SpCodeVo;
import com.gewara.api.vo.pay.SpecialDiscountTagVo;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface PaymentVoService {
	ResultCode<List<DiscountVo>> getDiscountByOrderId(Long arg0);

	ResultCode<List<DiscountVo>> getDiscountByTradeNo(String arg0);

	ResultCode<List<OtherFeeDetailVo>> getOtherFeeDetailByOrderId(Long arg0);

	ResultCode<Integer> getCardCountByMemberid(Long arg0, String arg1);

	ResultCode<Integer> getSpCodeCountByMemberid(Long arg0);

	ResultCode<String> getSpdEnabledCommon(String arg0, Long arg1);

	ResultCode<List<SpCodeVo>> getSpCodeList(Long arg0, Long arg1, int arg2, int arg3);

	ResultCode<List<ElecCardVo>> getCardListByMemberid(Long arg0, String arg1, int arg2, int arg3);

	ResultCode<ElecCardVo> getElecCardVo(Long arg0);

	ResultCode<SpCodeVo> getSpCodeVo(Long arg0);

	ResultCode<Integer> getSpecialDiscountAllowaddnum(Long arg0);

	ResultCode<Integer> getSpecialDiscountAllowaddnumByFlag(String arg0);

	ResultCode<PayMethodInfoVo> showPayMethodList(String arg0, String arg1, Long arg2, String arg3, String arg4,
			Map<String, String> arg5);

	ResultCode<PayMethodVo> getPayMethodById(String arg0);

	ResultCode<List<PayMethodVo>> getPayMethodListByIdList(String... arg0);

	ResultCode<Integer> checkSpdiscountQuantity(String arg0, Long arg1, String arg2, Integer arg3);

	ResultCode<Integer> computerSeatAmount(String arg0, Long arg1, String arg2, Long arg3, Integer arg4, Long arg5);

	ResultCode<Integer> validateSpdiscountIsUse(String arg0, Long arg1, String arg2, Long arg3, String arg4,
			Integer arg5, String arg6, String arg7, String arg8);

	ResultCode<Map<String, String>> getWxChargeParams(Long arg0, Long arg1, Integer arg2, String arg3);

	ResultCode<List<SpecialDiscountTagVo>> getSpecialDiscountTagList();

	ResultCode<Map<String, String>> getDelayElecCardNoMap(List<Long> arg0);

	ResultCode<Map<Long, String>> spcounterSpecialDiscountStatus(List<Long> arg0, String arg1);

	ResultCode<List<ElecCardBatchVo>> getElecCardBatchList(List<Long> arg0);

	ResultCode<List<BSCardVo>> getBsCardListByMemberid(Long arg0, int arg1, int arg2);

	ResultCode<BSCardVo> getBsCardById(Long arg0);

	ResultCode<List<Map<String, Object>>> findPromotionList(Timestamp arg0, Timestamp arg1);

	ResultCode<ElecCardVo> getElecCardByPass(String arg0);

	ResultCode<ElecCardVo> getElecCardByNo(String arg0);
}