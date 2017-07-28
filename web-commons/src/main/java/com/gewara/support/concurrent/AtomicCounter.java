/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.concurrent;

public interface AtomicCounter {
	long get();

	void set(long arg0);

	long getAndAdd(long arg0);

	long getAndDecrement();

	long getAndIncrement();

	long getAndSet(long arg0);

	long incrementAndGet();
}