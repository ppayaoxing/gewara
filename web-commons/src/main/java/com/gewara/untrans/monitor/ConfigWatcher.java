/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor;

import com.gewara.untrans.monitor.ConfigTrigger;
import com.gewara.untrans.monitor.impl.DataChangeWatcher;
import com.gewara.util.TimerHelper;

public class ConfigWatcher extends DataChangeWatcher {
	private ConfigTrigger trigger;
	private int partition = 1;
	private int delay = 0;

	public ConfigWatcher(String path, ConfigTrigger trigger) {
		super(path);
		this.trigger = trigger;
	}

	protected void processChange(String oldvalue, final String newvalue) {
		this.delay = (this.delay + 4) % 100;
		TimerHelper.TIMER.schedule(new Runnable() {
			public void run() {
				ConfigWatcher.this.trigger.refreshCurrent(newvalue);
			}
		}, (long) this.delay);
	}

	public int getPartition() {
		return this.partition;
	}

	public void setPartition(int partition) {
		this.partition = partition;
	}
}