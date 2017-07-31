package com.gewara.kafka.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.gewara.support.GewaExecutorThreadFactory;
import com.gewara.support.TraceErrorException;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;

/**
 * 使用方法:
 * 
 * <pre>
 * &lt;bean id=&quot;kafkaConsumerGroupFactory&quot; class=&quot;com.gewara.kafka.consumer.KafkaConsumerGroupFactory&quot;>
 * 	&lt;property name=&quot;brokers&quot; value=&quot;192.168.2.254:9092,192.168.2.250:9092,192.168.2.249:9092&quot;/>
 * 	&lt;property name=&quot;listenerList&quot;>
 * 		&lt;list>
 * 			&lt;ref bean=&quot;dtKafkaConsumerMsgListener&quot;/>
 * 		&lt;/list>
 * 	&lt;/property>
 * &lt;/bean>
 * &lt;bean id=&quot;dtKafkaConsumerMsgListener&quot; class=&quot;com.gewara.kafka.consumer.KafkaConsumerMsgListener&quot;>
 * 	&lt;property name=&quot;topic&quot; value=&quot;DT_TRACE_INFO&quot; />
 * 	&lt;property name=&quot;groupId&quot; value=&quot;traceGroup-1&quot; />
 * 	&lt;property name=&quot;callbackGroup&quot; ref=&quot;dtKafkaConsumerCallbackGroup&quot;>&lt;/property>
 * &lt;/bean>
 * &lt;bean id=&quot;dtKafkaConsumerCallbackGroup&quot; class=&quot;com.gewara.kafka.consumer.KafkaConsumerCallbackGroup&quot;>
 * 	&lt;property name=&quot;callbackList&quot;>
 * 		&lt;list>
 * 			&lt;ref bean=&quot;dtKafkaConumserCallback&quot;/>
 * 		&lt;/list>
 * 	&lt;/property>
 * &lt;/bean>
 * &lt;bean id=&quot;dtKafkaConumserCallback&quot; class=&quot;com.gewara.untrans.impl.KafkaConsumerCallbackImpl&quot; />
 * 
 * </pre>
 * 
 * 注意：KafkaConsumerCallback中消费topic的消息时请实现异步消费
 * 
 * @author quzhuping
 * 
 */
public class KafkaConsumerGroupFactory implements InitializingBean, DisposableBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());

	private String brokers;
	private List<KafkaConsumerMsgListener> listenerList = new ArrayList<>();
	private List<KafkaConsumerRunner> consumerRunnerList = new ArrayList<>();
	public void setBrokers(String brokers) {
		this.brokers = brokers;
	}

	public void setListenerList(List<KafkaConsumerMsgListener> listenerList) {
		this.listenerList = listenerList;
	}

	ExecutorService executor;

	@Override
	public void afterPropertiesSet() throws Exception {
		if (StringUtils.isBlank(brokers)) {
			throw new TraceErrorException("brolers is blank");
		}
		if (CollectionUtils.isEmpty(listenerList)) {
			throw new TraceErrorException( "KafkaConsumerListeners is empty");
		}
		executor = Executors.newFixedThreadPool(listenerList.size(), new GewaExecutorThreadFactory("kafkaConsumerGroup"));

		for (KafkaConsumerMsgListener listener : listenerList) {
			final KafkaConsumerMsgListener lsnr = listener;
			TimerHelper.TIMER.schedule(new Runnable() {
				@Override
				public void run() {
					startConsumer(lsnr);
				}
			}, DateUtil.m_minute);
		}
	}

	private void startConsumer(final KafkaConsumerMsgListener listener) {
		
		KafkaConsumerRunner consumerRunner = new KafkaConsumerRunner(listener);
		consumerRunnerList.add(consumerRunner);
		
		executor.submit(consumerRunner);
	}

	private class KafkaConsumerRunner implements Runnable {
		private KafkaConsumerMsgListener listener;
		private final AtomicBoolean closed = new AtomicBoolean(false);
		private final KafkaConsumer consumer;

		public KafkaConsumerRunner(KafkaConsumerMsgListener listener) {
			dbLogger.warn("start consumer:" + listener.getGroupId() + "=>" + listener.getTopic());
			
			this.listener = listener;
			Properties props = new Properties();
			props.put("bootstrap.servers", brokers);
			props.put("group.id", listener.getGroupId());
			props.put("enable.auto.commit", "true");
			props.put("auto.commit.interval.ms", "1000");
			props.put("session.timeout.ms", "30000");
			props.put("key.deserializer",
					"org.apache.kafka.common.serialization.StringDeserializer");
			props.put("value.deserializer",
					"org.apache.kafka.common.serialization.StringDeserializer");
			consumer = new KafkaConsumer<String, String>(props);
			Collection<String> topicList = Arrays.asList(listener.getTopic());
			consumer.subscribe(topicList);
			
			dbLogger.warn("start consumer complete:" + listener.getGroupId() + "=>" + listener.getTopic());
		}

		@Override
		public void run() {
			try {
				while (!closed.get()) {
					ConsumerRecords<String, String> records = consumer.poll(listener.getPollInterval());
					for (ConsumerRecord<String, String> record : records) {
						listener.doMessage(record.topic(), record.value());
					}
				}
			} catch (WakeupException e) {
				if (!closed.get())
					throw e;
			} finally {
				consumer.close();
			}
		}
		
		public void shutdown() {
			closed.set(true);
			consumer.wakeup();
		}
	}

	@Override
	public void destroy() throws Exception {
		for (KafkaConsumerRunner consumerRunner : consumerRunnerList) {
			try {
				consumerRunner.shutdown();
			} catch (Exception ex) {
				dbLogger.error(ex, 10);
			}
		}
	}

}
