package com.gewara.ucenter.api.openlogin;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.OpenResultVo;

/**
 * APP端支付宝登陆相关API
 * 
 */
public interface OpenApiMobileAliVoService {
	
	ResultCode<OpenResultVo> aliUserDetail(String authcode, String userid,
			String appId, String remoteIp);
	/**
	 * 支付宝钱包用户登录 
	 * @param accessToken
	 * @param remoteIp
	 * @return
	 */
	ResultCode<OpenResultVo> alipayLogin(String accessToken, String remoteIp);

}
