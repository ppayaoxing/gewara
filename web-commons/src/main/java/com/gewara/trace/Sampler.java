/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.trace;

import java.util.concurrent.atomic.AtomicInteger;

public class Sampler {
	private AtomicInteger count = new AtomicInteger();
	private int baseNumber = 100;
	private Long lastTime = Long.valueOf(-1L);

	public Sampler() {
		this.lastTime = Long.valueOf(System.currentTimeMillis());
	}

	public boolean isSample() {
		boolean isSample = true;
		long n = (long) this.count.incrementAndGet();
		if (System.currentTimeMillis() - this.lastTime.longValue() < 1000L) {
			if (n > (long) this.baseNumber) {
				n %= 10L;
				if (n != 0L) {
					isSample = false;
				}
			}
		} else {
			this.count.getAndSet(0);
			this.lastTime = Long.valueOf(System.currentTimeMillis());
		}

		return isSample;
	}
}