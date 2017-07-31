package com.gewara.ucenter.api.openlogin;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.OpenResultVo;

public interface UnionpayAuthorizeVoService {
	
	ResultCode<String> getRedirectUrl(String callbackUrl);
	
	ResultCode<OpenResultVo> callBackLogin(String code, String callbackUrl, String remoteIp);
}
