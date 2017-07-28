/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.impl;

import com.gewara.untrans.JmsService;
import com.gewara.untrans.monitor.MonitorData;
import com.gewara.untrans.monitor.MonitorEntry;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.untrans.monitor.impl.AbstractMonitorService;
import com.gewara.untrans.monitor.impl.MapMonitorEntry;
import java.util.Iterator;
import java.util.Map;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorServiceImpl extends AbstractMonitorService implements MonitorService, InitializingBean {
	@Autowired
	@Qualifier("monitorJmsService")
	private JmsService monitorJmsService;

	public void addMonitorEntry(String datatype, Map<String, String> entry) {
		this.executor.execute(new MonitorServiceImpl.WorkThread(new MapMonitorEntry(datatype, entry)));
	}

	public void addMonitorEntry(MonitorEntry entry) {
		this.executor.execute(new MonitorServiceImpl.WorkThread(entry));
	}

	public void afterPropertiesSet() throws Exception {
		Iterator arg0 = MonitorData.queueMap.values().iterator();

		while (arg0.hasNext()) {
			String queue = (String) arg0.next();
			this.monitorJmsService.addQueue(queue, false, false);
		}

		this.setupConsumerThread(10);
	}

	public class WorkThread implements Runnable {
		private MonitorEntry entry;

		public WorkThread(MonitorEntry entry) {
			this.entry = entry;
		}

		public void run() {
			String queue = MonitorData.getQueue(this.entry.getDatatype());
			if (this.entry.getHeadMap() != null) {
				MonitorServiceImpl.this.monitorJmsService.sendMsgToDstWithMultiHead(queue, this.entry.getDatatype(),
						this.entry.getDataMap(), this.entry.getHeadMap());
			} else {
				MonitorServiceImpl.this.monitorJmsService.sendMsgToDst(queue, this.entry.getDatatype(),
						this.entry.getDataMap());
			}

		}
	}
}