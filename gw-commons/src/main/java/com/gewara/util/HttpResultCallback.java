package com.gewara.util;

public interface HttpResultCallback {
	void processResult(HttpResult result);
	void processError(Throwable t);
}
