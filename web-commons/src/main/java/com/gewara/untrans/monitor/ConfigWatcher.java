package com.gewara.untrans.monitor;

import com.gewara.untrans.monitor.impl.DataChangeWatcher;
import com.gewara.util.TimerHelper;

public class ConfigWatcher extends DataChangeWatcher{
	private ConfigTrigger trigger;
	private int partition = 1;
	private int delay = 0;
	public ConfigWatcher(String path, ConfigTrigger trigger) {
		super(path);
		this.trigger = trigger;
	}
	@Override
	protected void processChange(String oldvalue, final String newvalue) {
		delay = (delay + 4) % 100;
		/*减少并发*/
		TimerHelper.TIMER.schedule(new Runnable(){
			@Override
			public void run() {
				trigger.refreshCurrent(newvalue);				
			}
		}, delay);
	}
	public int getPartition() {
		return partition;
	}
	public void setPartition(int partition) {
		this.partition = partition;
	}
}

