package com.gewara.kafka.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.gewara.support.TraceErrorException;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

/**
 * <h3>
 * 注意：必须配置validTopics和brokers属性
 * </h3>
 * <pre>
 * &ltbean id="kafkaProducerTemplate" class="com.gewara.kafka.producer.KafkaProducerTemplate">
 *      &ltproperty name="brokers" value="${kafka.brokers}" />
 *      &ltproperty name="validTopics">
 *           &ltlist>
 *                &ltvalue>agentReportone &lt/value>
 *           &lt/list>
 *      &lt/property>
 * &lt/bean>
 * </pre>
 * <li/>示例中的 <i>${kafka.brokers}</i> 为kafka服务地址ip:port,ip:port
 * <li/>示例中的 topic <i>agentReportone</i> <B>必须提前创建，并且partition数量>0</B>
 */
public class KafkaProducerTemplate implements InitializingBean, DisposableBean {
	protected GewaLogger dbLogger = WebLogger.getLogger(getClass());
	/**
	 * config
	 */
	private Properties options = new Properties();
	private Producer<String, String> producer = null;
	private String brokers;

	private List<String> validTopics = new ArrayList<String>();

	public void setValidTopics(List<String> validTopics) {
		this.validTopics = validTopics;
	}

	public void addValidTopic(String topic){
		if(!validTopics.contains(topic)){
			this.validTopics.add(topic);
		}
	}
	
	public void setBrokers(String brokers){
		this.brokers = brokers;
	}
	
	public KafkaProducerTemplate() {
		super();
	}

	public void send(String topic, String value) {
		if (!validTopics.contains(topic)) {
			dbLogger.warn(value, new TraceErrorException("Invalid topic value:" + topic), 20);
		}
		ProducerRecord<String, String> data = new ProducerRecord<String, String>(topic, value);
		producer.send(data);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(options==null){
			options = new Properties();
		}
		options.put("bootstrap.servers", this.brokers);
		options.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		options.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		producer = new KafkaProducer<String, String>(options);
	}

	@Override
	public void destroy() throws Exception {
		if (producer != null) {
			producer.close();
		}
	}

	public void setOptions(Properties options) {
		this.options = options;
	}

}
