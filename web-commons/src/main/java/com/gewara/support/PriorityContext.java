/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import com.gewara.support.PriorityObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityContext<T extends PriorityObject> {
	private final List<LinkedBlockingQueue<T>> bucketList;
	private final AtomicInteger curIndexer;
	private final int maxPriority;
	private final int bucketSize;
	private final int latch;

	public PriorityContext() {
		this(99, 1000);
	}

	public PriorityContext(int maxPriority, int bucketQueueLen) {
		this.curIndexer = new AtomicInteger(0);
		if (maxPriority < 1) {
			throw new IllegalArgumentException("maxPriority shout not be < 1");
		} else {
			if (maxPriority > 99) {
				maxPriority = 99;
			}

			if (bucketQueueLen > 10000) {
				bucketQueueLen = 10000;
			}

			if (bucketQueueLen < 1) {
				bucketQueueLen = 1;
			}

			this.maxPriority = maxPriority;
			this.bucketSize = maxPriority + 1;
			this.latch = this.bucketSize * 100000 - 1;
			this.bucketList = new ArrayList(this.bucketSize);

			for (int i = 0; i < this.bucketSize; ++i) {
				this.bucketList.add(i, new LinkedBlockingQueue(bucketQueueLen));
			}

		}
	}

	public T poll() {
		for (int i = 0; i < this.bucketSize; ++i) {
			int curIndex = this.curIndexer.getAndIncrement();
			if (curIndex == this.latch) {
				this.curIndexer.set(0);
			}

			PriorityObject rv = (PriorityObject) ((LinkedBlockingQueue) this.bucketList.get(curIndex % this.bucketSize))
					.poll();
			if (rv != null) {
				return rv;
			}
		}

		return null;
	}

	public boolean remove(T obj) {
		int priority = obj.getPriority();
		if (priority > this.maxPriority) {
			priority = this.maxPriority;
		}

		if (priority < 0) {
			priority = 0;
		}

		LinkedBlockingQueue contextQueue = (LinkedBlockingQueue) this.bucketList.get(priority);
		return contextQueue.remove(obj);
	}

	public boolean offer(T obj) {
		int priority = obj.getPriority();
		if (priority > this.maxPriority) {
			priority = this.maxPriority;
		}

		if (priority < 0) {
			priority = 0;
		}

		LinkedBlockingQueue contextQueue = (LinkedBlockingQueue) this.bucketList.get(priority);
		return contextQueue.offer(obj);
	}

	public int size() {
		int size = 0;

		LinkedBlockingQueue queue;
		for (Iterator arg1 = this.bucketList.iterator(); arg1.hasNext(); size += queue.size()) {
			queue = (LinkedBlockingQueue) arg1.next();
		}

		return size;
	}

	public static class BasePriorityObj implements PriorityObject {
		private static final long serialVersionUID = 1L;
		private int priority;

		public BasePriorityObj(int priority) {
			this.priority = priority;
		}

		public int getPriority() {
			return this.priority;
		}
	}
}