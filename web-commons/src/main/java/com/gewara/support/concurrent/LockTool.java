/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.concurrent;

import com.gewara.support.concurrent.AtomicCounter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;

public interface LockTool {
	void removeLock(String arg0);

	void removeBlockQueue(String arg0);

	BlockingQueue<Object> getBlockQueue(String arg0);

	Lock getLock(String arg0);

	AtomicCounter getAtomicCounter(String arg0);

	void removeAtomicCounter(String arg0);
}