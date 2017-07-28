/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mall.dubbo;

import com.gewara.api.vo.ResultCode;

public interface MallVoService {
	ResultCode<String> getPayinfoByTradeNo(String arg0);

	ResultCode<String> getSmsContentByTradeNo(String arg0);

	ResultCode processOrderConfirm(String arg0);

	ResultCode modMemberUsefulAddress(Long arg0, Long arg1, String arg2, String arg3, String arg4, String arg5,
			String arg6, String arg7, String arg8);
}