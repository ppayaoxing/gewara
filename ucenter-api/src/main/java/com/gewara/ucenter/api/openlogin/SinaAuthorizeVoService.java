package com.gewara.ucenter.api.openlogin;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberVo;
import com.gewara.ucenter.vo.member.OpenResultVo;

public interface SinaAuthorizeVoService {
	
	/**
	 * 联名登陆获取授权URL
	 * @param partnerName 
	 * @param callback
	 * @return
	 */
	ResultCode<String> getRedirectUrl(String partnerName, String callback);
	
	/**
	 * WAP联名登陆回调
	 * @param code
	 * @param callback
	 * @param remoteIp
	 * @return
	 */
	ResultCode<MemberVo> callBackLogin(String code,String callback, String remoteIp);
	
	/**
	 * PC联名登陆回调
	 * @param code
	 * @param callback
	 * @param remoteIp
	 * @return
	 */
	ResultCode<OpenResultVo> callBackWebLogin(String code, String callback, String type, String sessid, String remoteIp);
}
