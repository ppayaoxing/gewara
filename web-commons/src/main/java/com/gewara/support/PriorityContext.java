package com.gewara.support;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 简单获取策略上下文实现<br>
 * <p><b>基本实现思路:</b>
 * <br>context中初始化size为maxPriority+1的list，maxPriority默认为99
 * <br>list中的元素为LinkedBlockingQueue,queueLen默认为1000,<b>context总容量=listSize * queueLen</b>
 * <br>往context中添加元素时，根据 {@link PriorityObject#getPriority(int maxPriority)}的值放入到对应的queue中
 * <br>获取元素，遍历list中的Queue，获取其第一个节点，非空立即返回
 * <br>context为空则返回null
 * <p><b>使用场景举例：</b>
 * <br>正常的请求对象的priority随机为0~98
 * <br>非正常请求对象的priority设置为99
 * <br>则可以实现99:1的获取关系
 * @author quzhuping
 * @param <T> extends {@link PriorityObject}
 */
public class PriorityContext<T extends PriorityObject> {

	private final List<LinkedBlockingQueue<T>> bucketList;
	private final AtomicInteger curIndexer = new AtomicInteger(0);
	private final int maxPriority;
	private final int bucketSize;
	private final int latch; 

	/**
	 * 初始化maxPriority=99的context
	 */
	public PriorityContext(){
		this(99, 1000);
	}
	
	/**
	 * 如果maxPriority为0，则结构等同于单一Queue
	 * @param maxPriority (0 <= value <= 99)
	 * @param bucketQueueLen (1<= value < 10000)
	 */
	public PriorityContext(int maxPriority, int bucketQueueLen){
		if(maxPriority < 1){
			throw new IllegalArgumentException("maxPriority shout not be < 1");
		}
		if(maxPriority > 99){
			maxPriority = 99;
		}
		if(bucketQueueLen > 10000){
			bucketQueueLen = 10000;
		}
		if(bucketQueueLen < 1){
			bucketQueueLen = 1;
		}
		this.maxPriority = maxPriority;
		this.bucketSize = maxPriority + 1;
		this.latch = this.bucketSize * 100000 -1;
		
		bucketList = new ArrayList(this.bucketSize);
		for(int i = 0; i< this.bucketSize; i++){
			bucketList.add(i, new LinkedBlockingQueue(bucketQueueLen));
		}
	}
	/**
	 * 获取并移除context中的obj，如果context为空，则返回 null。
	 * @return
	 */
	public T poll(){
		for(int i=0; i< bucketSize; i++){
			int curIndex = curIndexer.getAndIncrement();
			if(curIndex == latch){
				curIndexer.set(0);
			}
			
			T rv = bucketList.get(curIndex % bucketSize).poll();
			if(rv != null){
				return rv;
			}
		}
		return null;
	}
	
	/**
	 * 从context中移除指定obj
	 * @param obj 带移除的obj
	 * @return
	 */
	public boolean remove(T obj){
		int priority = obj.getPriority();
		if(priority > this.maxPriority){
			priority = this.maxPriority;
		}
		if(priority < 0){
			priority = 0;
		}
		LinkedBlockingQueue<T> contextQueue = bucketList.get(priority);
		return contextQueue.remove(obj);
	}
	
	/**
	 * 添加obj到context中
	 * <br>如果obj的priority>maxPriority则将对象放入最后一个queue中
	 * <br>如果obj的priority<0则将对象放入第一个queue中(list.index = 0)
	 * @param obj
	 * @return true成功，false队列满
	 */
	public boolean offer(T obj){
		int priority = obj.getPriority();
		if(priority > this.maxPriority){
			priority = this.maxPriority;
		}
		if(priority < 0){
			priority = 0;
		}
		LinkedBlockingQueue<T> contextQueue = bucketList.get(priority);
		return contextQueue.offer(obj);
	}
	
	/**
	 * contex中的elements
	 * @return
	 */
	public int size(){
		int size = 0;
		for(LinkedBlockingQueue queue: bucketList){
			size += queue.size();
		}
		return size;
	}
	
	public static class BasePriorityObj implements PriorityObject{
		private static final long serialVersionUID = 1L;
		
		private int priority;
		public BasePriorityObj(int priority){
			this.priority = priority;
		}
		
		@Override
		public int getPriority() {
			return this.priority;
		}
		
	}
}
