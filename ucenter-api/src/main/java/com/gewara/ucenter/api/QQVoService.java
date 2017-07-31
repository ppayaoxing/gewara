package com.gewara.ucenter.api;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberVo;
import com.gewara.ucenter.vo.sns.QQUserVo;

public interface QQVoService {
	/**
	 * QQ公众号手动绑定格瓦拉账号
	 */
	ResultCode<MemberVo> bindQQGewa(String appkey, String userid, String unionid, String username, String password, String remoteIp);
	
	/**
	 * 根据code获取QQ用户信息
	 */
	ResultCode<MemberVo> getUserByCode(String appkey, String code, String remoteIp);
	
	ResultCode<QQUserVo> getQQUserByCode(String appkey, String code);
	
	ResultCode<QQUserVo> getQQUserByUserid(String appkey, String userid, String unionid);
	
	/**
	 * 取消绑定
	 */
	ResultCode cancelQQUser(String appkey, String userid);
	
	/**
	 * 获取QQ公众号会话token
	 */
	ResultCode<String> getAccessToken(String appkey);

}
