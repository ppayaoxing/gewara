/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.openlogin;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberVo;
import java.util.Map;

public interface OpenApiMobileWeixinVoService {
	ResultCode<MemberVo> getUserByCodeForApp(String arg0, Long arg1, String arg2);

	ResultCode<Map<String, Object>> getWeixinUser(String arg0, Long arg1);

	ResultCode<Map<String, Object>> loginScan(String arg0, String arg1, String arg2, String arg3, String arg4);
}