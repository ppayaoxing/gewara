/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sms.service;

import com.gewara.api.vo.ResultCode;
import java.sql.Timestamp;

public interface VoiceCodeVoService {
	ResultCode sendVoiceCode(String arg0, String arg1, Long arg2, String arg3, Timestamp arg4);

	ResultCode sendVoiceCode(String arg0, String arg1, Long arg2, String arg3, Timestamp arg4, String arg5);
}