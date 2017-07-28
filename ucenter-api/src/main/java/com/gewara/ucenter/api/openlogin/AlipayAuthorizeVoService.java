/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.openlogin;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.OpenMemberVo;
import com.gewara.ucenter.vo.member.OpenResultVo;
import java.util.Map;

public interface AlipayAuthorizeVoService {
	ResultCode<String> getRedirectUrl(String arg0);

	ResultCode<OpenResultVo> callBackLogin(String arg0, String arg1, String arg2, Map arg3, String arg4);

	ResultCode<OpenMemberVo> rsaSign(String arg0, String arg1, String arg2, String arg3);

	ResultCode<String> checkSign(String arg0, String arg1, Map arg2);
}