/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.api.openlogin;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.OpenResultVo;

public interface BaiduAuthorizeVoService {
	ResultCode<String> getRedirectUrl(String arg0);

	ResultCode<OpenResultVo> callBackWebLogin(String arg0, String arg1, String arg2);
}