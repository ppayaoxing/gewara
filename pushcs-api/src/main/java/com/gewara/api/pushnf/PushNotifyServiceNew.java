/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pushnf;

import com.gewara.api.vo.PushNotifyVo;
import com.gewara.api.vo.ResultCode;

public interface PushNotifyServiceNew {
	ResultCode<String> sendPushNotify(PushNotifyVo arg0);

	ResultCode<String> cancelPushNotify(String arg0);
}