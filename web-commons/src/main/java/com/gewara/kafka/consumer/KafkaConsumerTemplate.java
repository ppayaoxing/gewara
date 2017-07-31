package com.gewara.kafka.consumer;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.gewara.support.TraceErrorException;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

/**
 * kafka消费模板<br>
 * 使用方法：<br>
 * {@code <bean id="kafkaConsumerTemplate" class="com.gewara.kafka.consumer.KafkaConsumerTemplate">}<br>
 * {@code    <property name="brokers" value="${kafka.brokers}"/>}<br>
 * {@code    <property name="topics" value="userlog,dubbomonitor"/>}<br>
 * {@code    <property name="groupId" value="testGroup"/>}<br>
 * {@code    <property name="callback" ref="kafkaConumserCallback"/>}<br>
 * {@code    <property name="isSeekBegin" value="true"/>}<br>
 * {@code </bean>}<br>
 * {@code <bean id="kafkaConumserCallback" class="com.gewara.untrans.impl.KafkaConsumerCallbackImpl"/>}<br>
 * 说明：<br>
 * brokers为kafka地址, ip:port,ip:port<br>
 * topics为计划消费的topic,多个用','分割： topicName,topicName<br>
 * groupId<br>
 * callback为处理消息回调实现{@link KafkaConsumerCallback#doCallBack(String, String, String)}<br>
 * 以上4个参数必须设置<br>
 * isSeekBegin是否从头开始消费数据,默认false,可以不配置<br>
 * @author quzhuping
 *
 */
public class KafkaConsumerTemplate implements InitializingBean, DisposableBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	KafkaConsumerCallback callback;
	KafkaConsumer<String, String> consumer = null;
	private String groupId;
	private String brokers;
	private String topics;
	private boolean isSeekBegin = false;

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
	ExecutorService executor = Executors.newFixedThreadPool(1);
	private void poolRecord() {
/*		if(isSeekBegin){
			consumer.subscribe(Arrays.asList(StringUtils.split(topics, ",")), new ConsumerRebalanceListener() {
				@Override
				public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
					consumer.seekToBeginning(partitions.toArray(new TopicPartition[]{}));
				}
				@Override
				public void onPartitionsAssigned(Collection<TopicPartition> partitions) {}
			});
		}else{*/
			consumer.subscribe(Arrays.asList(StringUtils.split(topics, ",")));
			/*}
		
		if (isSeekBegin) {
			Set<TopicPartition> partitions = consumer.assignment();
			consumer.seekToBeginning(partitions
					.toArray(new TopicPartition[] {}));
		}*/
		executor.submit(new Runnable() {
			@Override
			public void run() {
				while (true) {
					ConsumerRecords<String, String> records = consumer.poll(100);

					for (ConsumerRecord<String, String> record : records){
						callback.doCallBack(record.topic(), record.value());
					}
				}				
			}
		});
	}

	@Override
	public void destroy() throws Exception {
		consumer.close();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(callback == null){
			throw new TraceErrorException("callback is null");
		}
		if (StringUtils.isBlank(brokers)) {
			throw new TraceErrorException("brolers is blank");
		}
		if (StringUtils.isBlank(groupId)) {
			throw new TraceErrorException("groupId is blank");
		}
		if (StringUtils.isBlank(topics)) {
			throw new TraceErrorException("topics is blank");
		}

		Properties props = new Properties();
		props.put("bootstrap.servers", brokers);
		props.put("group.id", groupId);
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer",
				"org.apache.kafka.common.serialization.StringDeserializer");
		if(isSeekBegin){
			props.put("auto.offset.reset", "earliest");
		}
		consumer = new KafkaConsumer<String, String>(props);
		dbLogger.warn("kafka consumer begining...");
		this.poolRecord();
	}

}
