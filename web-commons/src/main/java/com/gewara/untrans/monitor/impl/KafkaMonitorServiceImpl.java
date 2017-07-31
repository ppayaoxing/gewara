package com.gewara.untrans.monitor.impl;

import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.gewara.kafka.producer.KafkaProducerTemplate;
import com.gewara.untrans.monitor.MonitorData;
import com.gewara.untrans.monitor.MonitorEntry;
import com.gewara.util.JsonUtils;

public class KafkaMonitorServiceImpl extends AbstractMonitorService implements InitializingBean{
	private KafkaProducerTemplate kafkaProducerTemplate;
	@Override
	public void addMonitorEntry(String datatype, Map<String, String> entry) {
		executor.execute(new WorkThread(new MapMonitorEntry(datatype, entry)));
	}
	@Override
	public void addMonitorEntry(MonitorEntry entry) {
		executor.execute(new WorkThread(entry));
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		setupConsumerThread(10);
	}
	public class WorkThread implements Runnable{
		private MonitorEntry entry;
		public WorkThread(MonitorEntry entry){
			this.entry = entry;
		}
		@Override
		public void run() {
			String topic = MonitorData.getQueue(entry.getDatatype());
			Map<String, String> data = entry.getDataMap();
			if(entry.getHeadMap()!=null && !entry.getHeadMap().isEmpty()){
				data.put(MapMonitorEntry.HEADER_KEY, JsonUtils.writeMapToJson(entry.getHeadMap()));
			}
			kafkaProducerTemplate.send(topic, JsonUtils.writeMapToJson(data));
		}
	}

	public void setKafkaProducerTemplate(KafkaProducerTemplate kafkaProducerTemplate) {
		this.kafkaProducerTemplate = kafkaProducerTemplate;
	}
}
