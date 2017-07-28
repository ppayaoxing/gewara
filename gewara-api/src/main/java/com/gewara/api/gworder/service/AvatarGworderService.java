/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gworder.service;

import com.gewara.api.gworder.vo.ProcessOrderPayVo;
import com.gewara.api.vo.ResultCode;

public interface AvatarGworderService {
	ResultCode<ProcessOrderPayVo> processOrderPay(String arg0);
}