package com.gewara.ucenter.api.openlogin;

import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.OpenMemberVo;
import com.gewara.ucenter.vo.member.OpenResultVo;

public interface AlipayAuthorizeVoService {
	
	ResultCode<String> getRedirectUrl(String callbackUrl);
	
	ResultCode<OpenResultVo> callBackLogin(String notify_id, String sign, String user_id, Map signMap, String remoteIp);
	
	ResultCode<OpenMemberVo> rsaSign(String userId, String userType, String sign, String remoteIp);
	
	ResultCode<String> checkSign(String notify_id, String sign, Map signMap);
}
