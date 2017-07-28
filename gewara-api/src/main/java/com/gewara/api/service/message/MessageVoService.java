/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.message;

import com.gewara.support.ErrorCode;
import java.sql.Timestamp;

public interface MessageVoService {
	ErrorCode addMessage(Long arg0, String arg1, String arg2, String arg3, Timestamp arg4, Timestamp arg5, String arg6);
}