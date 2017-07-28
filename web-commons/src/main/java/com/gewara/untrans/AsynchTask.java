/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import java.util.HashMap;
import java.util.Map;

public class AsynchTask {
	private long addtime;
	private long validtime;
	private boolean requireLock;
	private String tasktype;
	private String taskUkey;
	private Map otherinfo = new HashMap();

	public void setRequireLock(boolean requireLock) {
		this.requireLock = requireLock;
	}

	public boolean isRequireLock() {
		return this.requireLock;
	}

	public long getValidtime() {
		return this.validtime;
	}

	public void setValidtime(long validtime) {
		this.validtime = validtime;
	}

	public AsynchTask(String tasktype, String taskUkey, int maxWaitSeconds, boolean requireLock) {
		this.tasktype = tasktype;
		this.taskUkey = taskUkey;
		this.addtime = System.currentTimeMillis();
		this.validtime = this.addtime + (long) (maxWaitSeconds * 1000);
		this.requireLock = requireLock;
	}

	public String getGlobalUkey() {
		return this.tasktype + this.taskUkey;
	}

	public String getTaskUkey() {
		return this.taskUkey;
	}

	public String getTasktype() {
		return this.tasktype;
	}

	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}

	public long getAddtime() {
		return this.addtime;
	}

	public void addInfo(String key, Object value) {
		this.otherinfo.put(key, value);
	}

	public Object getInfo(String key) {
		return this.otherinfo.get(key);
	}

	public boolean isTimeout() {
		return this.getValidtime() <= System.currentTimeMillis();
	}
}