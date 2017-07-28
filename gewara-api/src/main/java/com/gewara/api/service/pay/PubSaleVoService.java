/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.pay;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.pay.PubSaleVo;

public interface PubSaleVoService {
	ResultCode<PubSaleVo> getPubSale(Long arg0);
}