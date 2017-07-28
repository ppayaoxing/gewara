/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.untrans.AsynchTask;

public interface AsynchTaskProcessor<T extends AsynchTask> {
	void processTask(T arg0);

	int getLockSize();
}