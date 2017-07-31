package com.gewara.ucenter.api;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.member.MemberVo;

public interface PartnerPinganfuVoService {
	/**
	 * 平安付联名登录接口
	 * @param loginToken      平安付的登录token
	 * @param uid			     联名用户的唯一ID
	 * @param citycode        城市编码
	 * @param remoteIp        登录用户IP
	 * @return                用户实体对象
	 */
	public ResultCode<MemberVo> pinganfuLogin(String loginToken, String uid, String citycode, String remoteIp);
	
	/**
	 * 
	 * 获取获取平安付登录token
	 * @param memberId            格瓦拉用户id
	 * @param transactionId       平安付用户唯一标识
	 * @return                    平安付用户登录token
	 */
	public ResultCode<String> getLoginToken(Long memberId, String transactionId);
}
