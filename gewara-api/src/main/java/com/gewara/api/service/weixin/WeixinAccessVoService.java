/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.weixin;

import com.gewara.api.vo.ResultCode;
import java.util.Map;

public interface WeixinAccessVoService {
	ResultCode<Map<String, Object>> getAccessTokenByCode(String arg0, String arg1, String arg2);

	ResultCode<Map<String, String>> getAccessToken(String arg0, String arg1);
}