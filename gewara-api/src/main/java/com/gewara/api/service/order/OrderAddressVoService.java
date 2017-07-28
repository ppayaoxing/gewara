/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.order;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.pay.OrderAddressVo;
import java.sql.Timestamp;
import java.util.List;

public interface OrderAddressVoService {
	ResultCode<List<OrderAddressVo>> getPostOrderAddressList(Long arg0, String arg1, Timestamp arg2);
}