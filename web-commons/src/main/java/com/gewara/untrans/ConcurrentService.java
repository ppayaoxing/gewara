/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.support.concurrent.AtomicCounter;
import java.util.concurrent.BlockingQueue;

public interface ConcurrentService {
	AtomicCounter getAtomicCounter(String arg0);

	AtomicCounter getLocalAtomicCounter(String arg0);

	BlockingQueue<Object> getBlockQueue(String arg0);

	void unregisterBlockQueue(String arg0);
}