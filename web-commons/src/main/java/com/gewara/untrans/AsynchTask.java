package com.gewara.untrans;

import java.util.HashMap;
import java.util.Map;

public class AsynchTask {
	private long addtime;		//入队时间
	private long validtime;		//队列有效时间，超出直接忽略
	private boolean requireLock;
	public void setRequireLock(boolean requireLock) {
		this.requireLock = requireLock;
	}
	public boolean isRequireLock() {
		return requireLock;
	}
	public long getValidtime() {
		return validtime;
	}
	public void setValidtime(long validtime) {
		this.validtime = validtime;
	}
	private String tasktype;	//任务类型
	private String taskUkey;	//任务唯一标识，唯一标识相同的任务可以使用相同的返回数据（如果数据未过时的话）
	private Map otherinfo = new HashMap();		//其他信息
	public AsynchTask(String tasktype, String taskUkey, int maxWaitSeconds, boolean requireLock){
		this.tasktype = tasktype;
		this.taskUkey = taskUkey;
		this.addtime = System.currentTimeMillis();
		this.validtime = addtime + maxWaitSeconds * 1000;
		this.requireLock = requireLock;
	}
	public String getGlobalUkey(){
		return tasktype + taskUkey;
	}
	public String getTaskUkey() {
		return taskUkey;
	}
	/**
	 * 任务的唯一标识，对于相同的task，返回相同的数据
	 * @return
	 */
	public String getTasktype() {
		return tasktype;
	}
	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}
	public long getAddtime() {
		return addtime;
	}
	public void addInfo(String key, Object value){
		otherinfo.put(key, value);
	}
	public Object getInfo(String key){
		return otherinfo.get(key);
	}
	public boolean isTimeout(){
		return getValidtime()<=System.currentTimeMillis();
	}
}
