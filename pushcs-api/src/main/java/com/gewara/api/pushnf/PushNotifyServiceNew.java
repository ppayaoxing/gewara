package com.gewara.api.pushnf;

import com.gewara.api.vo.PushNotifyVo;
import com.gewara.api.vo.ResultCode;

public interface PushNotifyServiceNew {
	public ResultCode<String> sendPushNotify(PushNotifyVo pushNotify);
	/**
	 * 根据消息唯一标识取消发送
	 * @param tradeNo
	 */
	public ResultCode<String> cancelPushNotify(String msgKey);
}
