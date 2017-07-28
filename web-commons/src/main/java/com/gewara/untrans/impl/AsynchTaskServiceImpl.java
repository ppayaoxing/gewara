/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.Config;
import com.gewara.support.GewaExecutorThreadFactory;
import com.gewara.support.TraceErrorException;
import com.gewara.untrans.AsynchTask;
import com.gewara.untrans.AsynchTaskProcessor;
import com.gewara.untrans.AsynchTaskService;
import com.gewara.untrans.LockCallback;
import com.gewara.untrans.LockService;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.untrans.monitor.SysLogType;
import com.gewara.util.BeanUtil;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AsynchTaskServiceImpl implements AsynchTaskService, InitializingBean {
	private GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private Map<String, AsynchTaskProcessor> processorMap = new HashMap();
	@Autowired
	@Qualifier("monitorService")
	private MonitorService monitorService;
	@Autowired
	@Qualifier("lockService")
	private LockService lockService;
	private ThreadPoolExecutor executor;
	private Map<String, AsynchTaskServiceImpl.WorkGroupThread> workGroupMap = new ConcurrentHashMap();
	private int threadPoolSize = 60;
	private Map<String, AtomicInteger> putCountMap = new HashMap();
	private Map<String, AtomicInteger> completeCountMap = new HashMap();

	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}

	public void addTask(AsynchTask task) {
		AsynchTaskProcessor processor = (AsynchTaskProcessor) this.processorMap.get(task.getTasktype());
		if (processor == null) {
			this.dbLogger.error("No Processor For Task:" + BeanUtil.getBeanMap(task));
			throw new TraceErrorException("No Processor For Task:" + task.getTasktype());
		} else {
			((AtomicInteger) this.putCountMap.get(task.getTasktype())).incrementAndGet();
			AsynchTaskServiceImpl.WorkGroupThread command = (AsynchTaskServiceImpl.WorkGroupThread) this.workGroupMap
					.get(task.getGlobalUkey());
			if (command == null) {
				command = new AsynchTaskServiceImpl.WorkGroupThread(task, processor);
				this.workGroupMap.put(task.getGlobalUkey(), command);
				this.executor.execute(command);
			} else {
				command.addTask(task);
			}

		}
	}

	public void addTask(AsynchTask task, int waitTimeSecond, int minCount) {
		AsynchTaskProcessor processor = (AsynchTaskProcessor) this.processorMap.get(task.getTasktype());
		if (processor == null) {
			this.dbLogger.error("No Processor For Task:" + BeanUtil.getBeanMap(task));
			throw new TraceErrorException("No Processor For Task:" + task.getTasktype());
		} else {
			((AtomicInteger) this.putCountMap.get(task.getTasktype())).incrementAndGet();
			AsynchTaskServiceImpl.WorkGroupThread command = (AsynchTaskServiceImpl.WorkGroupThread) this.workGroupMap
					.get(task.getGlobalUkey());
			if (command == null) {
				command = new AsynchTaskServiceImpl.WorkGroupThread(task, processor);
				this.workGroupMap.put(task.getGlobalUkey(), command);
			} else {
				command.addTask(task);
			}

			if (!command.start && (System.currentTimeMillis() - command.starttime > (long) (1000 * waitTimeSecond)
					|| command.getSameCount() >= minCount)) {
				command.start = true;
				this.executor.execute(command);
			}

		}
	}

	public void cancleTask(String taskUkey) {
		throw new TraceErrorException("not implemented!!");
	}

	public void registerTaskProcessor(String tasktype, AsynchTaskProcessor processor) {
		this.completeCountMap.put(tasktype, new AtomicInteger());
		this.putCountMap.put(tasktype, new AtomicInteger());
		this.processorMap.put(tasktype, processor);
	}

	private void addMonitor() {
		Map entry = BeanUtil.toSimpleStringMap(this.getTaskQueueMap());
		entry.put("server", Config.getServerIp());
		entry.put("type", "process");
		entry.put("addtime", DateUtil.formatTimestamp(new Timestamp(System.currentTimeMillis())));
		entry.put("activity", "" + this.executor.getActiveCount());
		this.monitorService.addSysLog(SysLogType.asynchTask, entry);
	}

	public void afterPropertiesSet() throws Exception {
		LinkedBlockingQueue taskQueue = new LinkedBlockingQueue();
		this.executor = new ThreadPoolExecutor(this.threadPoolSize, this.threadPoolSize, 0L, TimeUnit.SECONDS,
				taskQueue, new GewaExecutorThreadFactory("GwAsynchTask"));
		this.executor.allowCoreThreadTimeOut(false);
	}

	public Map<String, Integer> getTaskQueueMap() {
		HashMap result = new HashMap();
		Iterator arg1 = this.putCountMap.entrySet().iterator();

		while (arg1.hasNext()) {
			Entry entry = (Entry) arg1.next();
			String type = (String) entry.getKey();
			int complete = ((AtomicInteger) this.completeCountMap.get(type)).get();
			int queue = ((AtomicInteger) entry.getValue()).get() - complete;
			result.put(type, Integer.valueOf(queue));
			result.put(type + "Complete", Integer.valueOf(complete));
		}

		return result;
	}

	public int getExecutorActiveCount() {
		return this.executor.getActiveCount();
	}

	public int getQueueSize() {
		return this.executor.getQueue().size();
	}

	private class WorkGroupThread implements Runnable, LockCallback<Boolean> {
		private long starttime = System.currentTimeMillis();
		private Queue<AsynchTask> sameList = new ConcurrentLinkedQueue();
		private boolean start = false;
		private AsynchTask task;
		private AsynchTaskProcessor processor;

		public WorkGroupThread(AsynchTask task, AsynchTaskProcessor processor) {
			this.task = task;
			this.processor = processor;
		}

		public void addTask(AsynchTask sametask) {
			this.sameList.offer(sametask);
		}

		public void run() {
			try {
				if (this.task.isRequireLock()) {
					String e = this.task.getTasktype()
							+ Math.abs(this.task.getTaskUkey().hashCode()) % this.processor.getLockSize();
					AsynchTaskServiceImpl.this.lockService.doWithWriteLock(e, this);
				} else {
					this.processWithInLock();
				}
			} catch (Exception arg1) {
				AsynchTaskServiceImpl.this.dbLogger.warn("" + BeanUtil.getBeanMap(this.task), arg1);
			}

		}

		public Boolean processWithInLock() {
			boolean arg26 = false;

			label236 : {
				int same;
				label235 : {
					try {
						arg26 = true;
						this.processor.processTask(this.task);
						arg26 = false;
						break label235;
					} catch (Exception arg35) {
						AsynchTaskServiceImpl.this.dbLogger.warn("", arg35);
						arg26 = false;
					} finally {
						if (arg26) {
							try {
								int e1 = ((AtomicInteger) AsynchTaskServiceImpl.this.completeCountMap
										.get(this.task.getTasktype())).incrementAndGet();
								if (e1 % 200 == 0) {
									AsynchTaskServiceImpl.this.addMonitor();
								}
							} catch (Exception arg28) {
								AsynchTaskServiceImpl.this.dbLogger.warn("", arg28);
							}

						}
					}

					try {
						same = ((AtomicInteger) AsynchTaskServiceImpl.this.completeCountMap
								.get(this.task.getTasktype())).incrementAndGet();
						if (same % 200 == 0) {
							AsynchTaskServiceImpl.this.addMonitor();
						}
					} catch (Exception arg31) {
						AsynchTaskServiceImpl.this.dbLogger.warn("", arg31);
					}
					break label236;
				}

				try {
					same = ((AtomicInteger) AsynchTaskServiceImpl.this.completeCountMap.get(this.task.getTasktype()))
							.incrementAndGet();
					if (same % 200 == 0) {
						AsynchTaskServiceImpl.this.addMonitor();
					}
				} catch (Exception arg32) {
					AsynchTaskServiceImpl.this.dbLogger.warn("", arg32);
				}
			}

			AsynchTaskServiceImpl.this.workGroupMap.remove(this.task.getGlobalUkey());
			AsynchTask same1 = null;

			while ((same1 = (AsynchTask) this.sameList.poll()) != null) {
				boolean arg15 = false;

				int e;
				label224 : {
					try {
						arg15 = true;
						this.processor.processTask(same1);
						arg15 = false;
						break label224;
					} catch (Exception arg33) {
						AsynchTaskServiceImpl.this.dbLogger.warn("", arg33);
						arg15 = false;
					} finally {
						if (arg15) {
							try {
								int e2 = ((AtomicInteger) AsynchTaskServiceImpl.this.completeCountMap
										.get(this.task.getTasktype())).incrementAndGet();
								if (e2 % 200 == 0) {
									AsynchTaskServiceImpl.this.addMonitor();
								}
							} catch (Exception arg27) {
								AsynchTaskServiceImpl.this.dbLogger.warn("", arg27);
							}

						}
					}

					try {
						e = ((AtomicInteger) AsynchTaskServiceImpl.this.completeCountMap.get(this.task.getTasktype()))
								.incrementAndGet();
						if (e % 200 == 0) {
							AsynchTaskServiceImpl.this.addMonitor();
						}
					} catch (Exception arg29) {
						AsynchTaskServiceImpl.this.dbLogger.warn("", arg29);
					}
					continue;
				}

				try {
					e = ((AtomicInteger) AsynchTaskServiceImpl.this.completeCountMap.get(this.task.getTasktype()))
							.incrementAndGet();
					if (e % 200 == 0) {
						AsynchTaskServiceImpl.this.addMonitor();
					}
				} catch (Exception arg30) {
					AsynchTaskServiceImpl.this.dbLogger.warn("", arg30);
				}
			}

			return Boolean.valueOf(true);
		}

		public int getSameCount() {
			return this.sameList.size();
		}
	}
}