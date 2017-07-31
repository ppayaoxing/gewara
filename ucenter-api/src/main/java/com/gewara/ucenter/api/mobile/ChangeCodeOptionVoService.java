package com.gewara.ucenter.api.mobile;

import com.gewara.api.vo.ResultCode;

public interface ChangeCodeOptionVoService {
	/**
	 * 切换动态码发送选项   语音或短信
	 * @param option
	 */
	@Deprecated
	void updateSendOptionsMessage(String option);
	ResultCode updateSendOptionsMessage2(String option);
	/**
	 * 后台管理重发用户手机动态码
	 * @param memberid 用户id
	 * @param sendtype 发送类型 语音或短信
	 * @return
	 */
	ResultCode resendMessageByAdmin(String mobile, String sendtype);
	/**
	 * 重置发送次数
	 * @param mobile 手机号码
	 * @param adminid 后台管理员id
	 * @return
	 */
	ResultCode resetSendCount(String mobile, Long adminid, boolean clearAll);
}
