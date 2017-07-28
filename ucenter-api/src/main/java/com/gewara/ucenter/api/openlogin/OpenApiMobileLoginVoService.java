/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.openlogin;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberVo;
import com.gewara.ucenter.vo.member.OpenResultVo;
import java.util.Map;

public interface OpenApiMobileLoginVoService {
	ResultCode<String> mobileRegister(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5,
			String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13,
			String arg14, Map<String, String> arg15, boolean arg16);

	ResultCode sendMobileCheck(MemberVo arg0, String arg1, String arg2, String arg3);

	ResultCode<OpenResultVo> openMemberLogin(String arg0, String arg1, String arg2, String arg3, String arg4);

	ResultCode<OpenResultVo> openMemberLoginByApp(String arg0, String arg1, String arg2, Long arg3, String arg4,
			String arg5);

	ResultCode<OpenResultVo> bindAuth(MemberVo arg0, Boolean arg1, Boolean arg2, String arg3, String arg4, Long arg5,
			String arg6, String arg7, String arg8, String arg9);
}