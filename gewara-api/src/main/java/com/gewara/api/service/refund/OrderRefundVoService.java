/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.refund;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.cmd.order.SearchRefundCommandVo;
import com.gewara.api.vo.pay.OrderRefundVo;
import java.util.List;

public interface OrderRefundVoService {
	ResultCode<List<OrderRefundVo>> getOrderRefundList(SearchRefundCommandVo arg0, String arg1, int arg2, int arg3);

	ResultCode<Integer> getOrderRefundCount(SearchRefundCommandVo arg0);

	ResultCode<OrderRefundVo> getOrderRefundByTradeNo(String arg0);

	ResultCode<List<String>> getRefundTemplateList2();
}