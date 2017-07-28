/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.openlogin;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberVo;
import com.gewara.ucenter.vo.member.OpenResultVo;

public interface SinaAuthorizeVoService {
	ResultCode<String> getRedirectUrl(String arg0, String arg1);

	ResultCode<MemberVo> callBackLogin(String arg0, String arg1, String arg2);

	ResultCode<OpenResultVo> callBackWebLogin(String arg0, String arg1, String arg2, String arg3, String arg4);
}