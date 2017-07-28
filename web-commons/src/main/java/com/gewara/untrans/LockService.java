/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.support.ErrorCode;
import com.gewara.untrans.LockCallback;

public interface LockService {
	<T> ErrorCode<T> doWithWriteLock(String arg0, LockCallback<T> arg1);

	<T> ErrorCode<T> doWithWriteLock(String arg0, int arg1, LockCallback<T> arg2);

	<T> ErrorCode<T> tryDoWithWriteLock(String arg0, LockCallback<T> arg1);
}