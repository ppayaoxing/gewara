package com.gewara.api.service.movie;

import com.gewara.api.vo.ResultCode;

public interface MemberSecurityVoService {
	/**
	 * 是否需要安全验证
	 * @param memberid
	 * @return
	 */
	ResultCode<Boolean> isSecurityVerify(String memberEncode, String remoteIp);
	/**
	 * 获取动态验证码
	 * @param memberid
	 * @param mobile
	 * @param ip
	 * @return
	 */
	ResultCode getSecurityVerifyCode(String memberEncode, String mobile, String remoteIp);
	/**
	 * 验证动态密码
	 * @param memberid
	 * @param mobile
	 * @param checkcode
	 * @param ip
	 * @return
	 */
	ResultCode preCheckBindMobile(String memberEncode, String mobile, String checkcode, String remoteIp);
	/**
	 * 添加安全验证通过标识
	 * @param memberid
	 * @param checkCode
	 * @return
	 */
	ResultCode addMemberSecurityVerify(String memberEncode, String checkCode, String remoteIp);
	/**
	 * 未绑定手机用户，绑定手机并获取验证码
	 * @param memberid
	 * @param mobile
	 * @param remoteIp
	 * @return
	 */
	ResultCode getSecurityVerifyCode4NotBindMobile(String memberEncode, String mobile, String remoteIp);
	/**
	 * 绑定手机用户，获取验证码
	 * @param memberid
	 * @param mobile
	 * @param remoteIp
	 * @return
	 */
	ResultCode getSecurityVerifyCode4BindMobile(String memberEncode, String mobile, String remoteIp);
	/**
	 * 当没有绑定手机，且没有支付密码时，进行帮忙手机验证，使用绑定手机逻辑
	 * @param memberid
	 * @param mobile
	 * @param checkpass
	 * @param remoteIp
	 * @param sessid
	 * @return
	 */
	ResultCode checkSecurityVerify4Mobile(String memberEncode, String mobile, String checkpass, String remoteIp);
	
}
