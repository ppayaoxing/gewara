/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.push.api.service;

import com.gewara.api.vo.ResultCode;
import com.gewara.push.api.req.vo.PushNotifyNewVo;

public interface PushVoService {
	ResultCode<String> sendPushNotify(PushNotifyNewVo arg0);

	ResultCode<String> cancelPushNotify(String arg0);
}