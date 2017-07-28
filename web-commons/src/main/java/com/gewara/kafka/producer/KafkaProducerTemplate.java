/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.kafka.producer;

import com.gewara.support.TraceErrorException;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class KafkaProducerTemplate implements InitializingBean, DisposableBean {
	protected GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private Properties options = new Properties();
	private Producer<String, String> producer = null;
	private String brokers;
	private List<String> validTopics = new ArrayList();

	public void setValidTopics(List<String> validTopics) {
		this.validTopics = validTopics;
	}

	public void addValidTopic(String topic) {
		if (!this.validTopics.contains(topic)) {
			this.validTopics.add(topic);
		}

	}

	public void setBrokers(String brokers) {
		this.brokers = brokers;
	}

	public void send(String topic, String value) {
		if (!this.validTopics.contains(topic)) {
			this.dbLogger.warn(value, new TraceErrorException("Invalid topic value:" + topic), 20);
		}

		ProducerRecord data = new ProducerRecord(topic, value);
		this.producer.send(data);
	}

	public void afterPropertiesSet() throws Exception {
		if (this.options == null) {
			this.options = new Properties();
		}

		this.options.put("bootstrap.servers", this.brokers);
		this.options.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		this.options.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		this.producer = new KafkaProducer(this.options);
	}

	public void destroy() throws Exception {
		if (this.producer != null) {
			this.producer.close();
		}

	}

	public void setOptions(Properties options) {
		this.options = options;
	}
}