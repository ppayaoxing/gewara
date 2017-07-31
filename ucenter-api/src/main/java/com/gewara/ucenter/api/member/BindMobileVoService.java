package com.gewara.ucenter.api.member;

import com.gewara.api.vo.ResultCode;

public interface BindMobileVoService {
	/**
	 * 未登录前的验证码
	 * @param tag
	 * @param mobile
	 * @param ip
	 * @return
	 */
	ResultCode refreshDynamicCode(String tag, String mobile, String ip);
	/**
	 * 重新刷新验证码
	 * @param tag
	 * @param mobile
	 * @return
	 */
	ResultCode refreshDynamicCode(String tag, String mobile, String ip, Long memberid);
	
	ResultCode refreshBindMobile1(String mobile, Long memberid, String ip);
	ResultCode refreshBindMobile2(String mobile, Long memberid, String ip, String msgTemplate);
	ResultCode refreshChangeMobile(String newmobile, Long memberid, String ip);
	
	/**
	 * 测试成功后次数直接用完
	 * @param tag
	 * @param mobile
	 * @param checkpass
	 * @return ERRORCODE分两种：可重试或失效，前台区分
	 */
	ResultCode checkBindMobile(String tag, String mobile, Long memberid, String checkpass);
	/**
	 * 未注册（或未登录前）的验证码绑定
	 * @param tag
	 * @param mobile
	 * @param checkpass
	 * @return
	 */
	ResultCode checkDynamicCode(String tag, String mobile, String checkpass);
	/**
	 * 预先检测，次数增1
	 * @param tag
	 * @param mobile
	 * @param checkpass
	 * @return
	 */
	ResultCode preCheckBindMobile(String tag, String mobile, Long memberid, String checkpass);

	ResultCode<Boolean> getAndUpdateToken(String type, String ip, int checkcount);
	ResultCode<Boolean> isNeedToken(String type, String ip, int checkcount);

	/**
	 * 账号回复短信验证
	 * @param mobile
	 * @param ip
	 * @return
	 */
	ResultCode refreshSMSValid(String mobile, String ip);
	/**
	 * 重新刷新验证码(drama)
	 * @param tag
	 * @param mobile
	 * @param ip
	 * @param memberid
	 * @param type
	 * @return
	 */
	ResultCode refreshDynamicCode(String tag, String mobile, String ip, Long memberid, String type);

}
