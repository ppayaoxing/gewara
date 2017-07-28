/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.HttpResult;

public interface HttpResultCallback {
	void processResult(HttpResult arg0);

	void processError(Throwable arg0);
}