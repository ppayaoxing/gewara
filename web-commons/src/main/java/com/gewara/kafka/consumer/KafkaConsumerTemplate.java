/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.kafka.consumer;

import com.gewara.kafka.consumer.KafkaConsumerCallback;
import com.gewara.support.TraceErrorException;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.lang.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class KafkaConsumerTemplate implements InitializingBean, DisposableBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	KafkaConsumerCallback callback;
	KafkaConsumer<String, String> consumer = null;
	private String groupId;
	private String brokers;
	private String topics;
	private boolean isSeekBegin = false;
	ExecutorService executor = Executors.newFixedThreadPool(1);

	public void setCallback(KafkaConsumerCallback callback) {
		this.callback = callback;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public void setBrokers(String brokers) {
		this.brokers = brokers;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public void setIsSeekBegin(boolean isSeekBegin) {
		this.isSeekBegin = isSeekBegin;
	}

	private void poolRecord() {
		this.consumer.subscribe(Arrays.asList(StringUtils.split(this.topics, ",")));
		this.executor.submit(new Runnable() {
			public void run() {
				while (true) {
					ConsumerRecords records = KafkaConsumerTemplate.this.consumer.poll(100L);
					Iterator arg1 = records.iterator();

					while (arg1.hasNext()) {
						ConsumerRecord record = (ConsumerRecord) arg1.next();
						KafkaConsumerTemplate.this.callback.doCallBack(record.topic(), (String) record.value());
					}
				}
			}
		});
	}

	public void destroy() throws Exception {
		this.consumer.close();
	}

	public void afterPropertiesSet() throws Exception {
		if (this.callback == null) {
			throw new TraceErrorException("callback is null");
		} else if (StringUtils.isBlank(this.brokers)) {
			throw new TraceErrorException("brolers is blank");
		} else if (StringUtils.isBlank(this.groupId)) {
			throw new TraceErrorException("groupId is blank");
		} else if (StringUtils.isBlank(this.topics)) {
			throw new TraceErrorException("topics is blank");
		} else {
			Properties props = new Properties();
			props.put("bootstrap.servers", this.brokers);
			props.put("group.id", this.groupId);
			props.put("enable.auto.commit", "true");
			props.put("auto.commit.interval.ms", "1000");
			props.put("session.timeout.ms", "30000");
			props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			if (this.isSeekBegin) {
				props.put("auto.offset.reset", "earliest");
			}

			this.consumer = new KafkaConsumer(props);
			this.dbLogger.warn("kafka consumer begining...");
			this.poolRecord();
		}
	}
}