/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.impl;

import com.gewara.kafka.producer.KafkaProducerTemplate;
import com.gewara.untrans.monitor.MonitorData;
import com.gewara.untrans.monitor.MonitorEntry;
import com.gewara.untrans.monitor.impl.AbstractMonitorService;
import com.gewara.untrans.monitor.impl.MapMonitorEntry;
import com.gewara.util.JsonUtils;
import java.util.Map;
import org.springframework.beans.factory.InitializingBean;

public class KafkaMonitorServiceImpl extends AbstractMonitorService implements InitializingBean {
	private KafkaProducerTemplate kafkaProducerTemplate;

	public void addMonitorEntry(String datatype, Map<String, String> entry) {
		this.executor.execute(new KafkaMonitorServiceImpl.WorkThread(new MapMonitorEntry(datatype, entry)));
	}

	public void addMonitorEntry(MonitorEntry entry) {
		this.executor.execute(new KafkaMonitorServiceImpl.WorkThread(entry));
	}

	public void afterPropertiesSet() throws Exception {
		this.setupConsumerThread(10);
	}

	public void setKafkaProducerTemplate(KafkaProducerTemplate kafkaProducerTemplate) {
		this.kafkaProducerTemplate = kafkaProducerTemplate;
	}

	public class WorkThread implements Runnable {
		private MonitorEntry entry;

		public WorkThread(MonitorEntry entry) {
			this.entry = entry;
		}

		public void run() {
			String topic = MonitorData.getQueue(this.entry.getDatatype());
			Map data = this.entry.getDataMap();
			if (this.entry.getHeadMap() != null && !this.entry.getHeadMap().isEmpty()) {
				data.put("__header__", JsonUtils.writeMapToJson(this.entry.getHeadMap()));
			}

			KafkaMonitorServiceImpl.this.kafkaProducerTemplate.send(topic, JsonUtils.writeMapToJson(data));
		}
	}
}