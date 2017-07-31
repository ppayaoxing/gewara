package com.gewara.ucenter.api.openlogin;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.OpenResultVo;

public interface BaiduAuthorizeVoService {
	
	/**
	 * 百度联名登陆获取授权URL
	 * @param partnerName 
	 * @param callback
	 * @return
	 */
	ResultCode<String> getRedirectUrl(String callback);
	/**
	 * 百度Web联名登陆回调
	 * @param code
	 * @param callback
	 * @param remoteIp
	 * @return
	 */
	ResultCode<OpenResultVo> callBackWebLogin(String code, String callback, String remoteIp);
}
