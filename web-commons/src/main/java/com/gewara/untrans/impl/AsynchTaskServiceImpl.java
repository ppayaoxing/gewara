package com.gewara.untrans.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
public class AsynchTaskServiceImpl implements AsynchTaskService, InitializingBean {
	private GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private Map<String/*task*/, AsynchTaskProcessor> processorMap = new HashMap<String, AsynchTaskProcessor>();
	@Autowired@Qualifier("monitorService")
	private MonitorService monitorService;
	@Autowired@Qualifier("lockService")
	private LockService lockService;
	private ThreadPoolExecutor executor;

	private Map<String, WorkGroupThread> workGroupMap = new ConcurrentHashMap<String, WorkGroupThread>();
	private int threadPoolSize = 60;//default 60
	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}
	private Map<String, AtomicInteger> putCountMap = new HashMap<String, AtomicInteger>();
	private Map<String, AtomicInteger> completeCountMap = new HashMap<String, AtomicInteger>();
	
	@Override
	public void addTask(AsynchTask task) {
		AsynchTaskProcessor processor = processorMap.get(task.getTasktype());
		if(processor==null){
			dbLogger.error("No Processor For Task:" + BeanUtil.getBeanMap(task));
			throw new TraceErrorException("No Processor For Task:" + task.getTasktype());
		}
		putCountMap.get(task.getTasktype()).incrementAndGet();
		WorkGroupThread command = workGroupMap.get(task.getGlobalUkey());
		if(command==null){
			command = new WorkGroupThread(task, processor);
			workGroupMap.put(task.getGlobalUkey(), command);
			executor.execute(command);
		}else{
			command.addTask(task);
		}
	}
	@Override
	public void addTask(AsynchTask task, int waitTimeSecond, int minCount) {
		AsynchTaskProcessor processor = processorMap.get(task.getTasktype());
		if(processor==null){
			dbLogger.error("No Processor For Task:" + BeanUtil.getBeanMap(task));
			throw new TraceErrorException("No Processor For Task:" + task.getTasktype());
		}
		putCountMap.get(task.getTasktype()).incrementAndGet();
		WorkGroupThread command = workGroupMap.get(task.getGlobalUkey());
		if(command==null){
			command = new WorkGroupThread(task, processor);
			workGroupMap.put(task.getGlobalUkey(), command);
		}else{
			command.addTask(task);
		}
		if(!command.start && (System.currentTimeMillis() - command.starttime > 1000*waitTimeSecond || command.getSameCount() >= minCount)){
			command.start = true;
			executor.execute(command);
		}
	}

	@Override
	public void cancleTask(String taskUkey) {
		throw new TraceErrorException("not implemented!!");
	}

	@Override
	public void registerTaskProcessor(String tasktype, AsynchTaskProcessor processor) {
		completeCountMap.put(tasktype, new AtomicInteger());
		putCountMap.put(tasktype, new AtomicInteger());
		processorMap.put(tasktype, processor);
	}

	private class WorkGroupThread implements Runnable, LockCallback<Boolean> {
		private long starttime;
		private Queue<AsynchTask> sameList = new ConcurrentLinkedQueue<AsynchTask>();
		private boolean start = false;
		private AsynchTask task;
		private AsynchTaskProcessor processor;
		public WorkGroupThread(AsynchTask task, AsynchTaskProcessor processor){
			this.starttime = System.currentTimeMillis();
			this.task = task;
			this.processor = processor;
		}
		public void addTask(AsynchTask sametask){
			sameList.offer(sametask);
		}
		@Override
		public void run() {
			try {
				if(task.isRequireLock()){
					//lockKey±ä»»
					String lockKey = task.getTasktype() + (Math.abs(task.getTaskUkey().hashCode()) % processor.getLockSize());
					lockService.doWithWriteLock(lockKey, this);
				}else{
					this.processWithInLock();
				}
			} catch (Exception e) {
				dbLogger.warn("" + BeanUtil.getBeanMap(task), e);
			}
		}
		@Override
		public Boolean processWithInLock() {
			try{
				processor.processTask(task);
			}catch(Exception e){
				dbLogger.warn("", e);
			} finally{
				try{
					int complete = completeCountMap.get(task.getTasktype()).incrementAndGet();
					if(complete % 200==0){
						addMonitor();
					}
				}catch (Exception e) {
					dbLogger.warn("", e);
				}
			}
			workGroupMap.remove(task.getGlobalUkey());
			AsynchTask same = null;
			while((same = sameList.poll())!=null){
				try{
					processor.processTask(same);
				}catch(Exception e){
					dbLogger.warn("", e);
				} finally{
					try{
						int complete = completeCountMap.get(task.getTasktype()).incrementAndGet();
						if(complete % 200==0){
							addMonitor();
						}
					}catch (Exception e) {
						dbLogger.warn("", e);
					}
				}
			}
			return true;
		}
		public int getSameCount(){
			return sameList.size();
		}
	}
	
	private void addMonitor(){
		Map<String, String> entry = BeanUtil.toSimpleStringMap(getTaskQueueMap());
		entry.put("server", Config.getServerIp());
		entry.put("type", "process");
		entry.put("addtime", DateUtil.formatTimestamp(new Timestamp(System.currentTimeMillis())));
		entry.put("activity", "" + executor.getActiveCount());
		monitorService.addSysLog(SysLogType.asynchTask, entry);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
		executor = new ThreadPoolExecutor(threadPoolSize, threadPoolSize, 0L, TimeUnit.SECONDS, taskQueue, new GewaExecutorThreadFactory("GwAsynchTask"));
		executor.allowCoreThreadTimeOut(false);
	}
	
	@Override
	public Map<String, Integer> getTaskQueueMap() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for(Map.Entry<String, AtomicInteger> entry: putCountMap.entrySet()){
			String type = entry.getKey();
			int complete = completeCountMap.get(type).get();
			int queue = entry.getValue().get() - complete;
			result.put(type, queue);
			result.put(type+"Complete", complete);
		}
		return result;
	}
	
	@Override
	public int getExecutorActiveCount(){
		return executor.getActiveCount();
	}
	
	@Override
	public int getQueueSize(){
		return  executor.getQueue().size();
	}
}
