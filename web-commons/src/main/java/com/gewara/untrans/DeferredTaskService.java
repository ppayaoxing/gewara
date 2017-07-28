/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.untrans.DeferredResultTask;
import com.gewara.untrans.DeferredTaskCallback;

public interface DeferredTaskService {
	<T> void doTask(DeferredResultTask arg0, DeferredTaskCallback<T> arg1);
}