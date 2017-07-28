/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.refund;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.pay.OtherFeeRefundVo;
import java.util.List;

public interface OtherFeeRefundVoService {
	ResultCode<List<OtherFeeRefundVo>> getOtherFeeRefundList(String arg0, String arg1, String arg2, Long arg3,
			String arg4, int arg5, int arg6);

	ResultCode<Integer> getOtherFeeRefundCount(String arg0, String arg1, String arg2, Long arg3, String arg4);

	ResultCode<OtherFeeRefundVo> getOtherFeeRefund(String arg0, String arg1);
}