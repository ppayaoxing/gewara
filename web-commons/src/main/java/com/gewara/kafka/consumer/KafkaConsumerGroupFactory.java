/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.kafka.consumer;

import com.gewara.kafka.consumer.KafkaConsumerMsgListener;
import com.gewara.support.GewaExecutorThreadFactory;
import com.gewara.support.TraceErrorException;
import com.gewara.util.GewaLogger;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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

public class KafkaConsumerGroupFactory implements InitializingBean, DisposableBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private String brokers;
	private List<KafkaConsumerMsgListener> listenerList = new ArrayList();
	private List<KafkaConsumerGroupFactory.KafkaConsumerRunner> consumerRunnerList = new ArrayList();
	ExecutorService executor;

	public void setBrokers(String brokers) {
		this.brokers = brokers;
	}

	public void setListenerList(List<KafkaConsumerMsgListener> listenerList) {
		this.listenerList = listenerList;
	}

	public void afterPropertiesSet() throws Exception {
		if (StringUtils.isBlank(this.brokers)) {
			throw new TraceErrorException("brolers is blank");
		} else if (CollectionUtils.isEmpty(this.listenerList)) {
			throw new TraceErrorException("KafkaConsumerListeners is empty");
		} else {
			this.executor = Executors.newFixedThreadPool(this.listenerList.size(),
					new GewaExecutorThreadFactory("kafkaConsumerGroup"));
			Iterator arg0 = this.listenerList.iterator();

			while (arg0.hasNext()) {
				final KafkaConsumerMsgListener listener = (KafkaConsumerMsgListener) arg0.next();
				TimerHelper.TIMER.schedule(new Runnable() {
					public void run() {
						KafkaConsumerGroupFactory.this.startConsumer(listener);
					}
				}, 60000L);
			}

		}
	}

	private void startConsumer(KafkaConsumerMsgListener listener) {
		KafkaConsumerGroupFactory.KafkaConsumerRunner consumerRunner = new KafkaConsumerGroupFactory.KafkaConsumerRunner(
				listener);
		this.consumerRunnerList.add(consumerRunner);
		this.executor.submit(consumerRunner);
	}

	public void destroy() throws Exception {
		Iterator arg0 = this.consumerRunnerList.iterator();

		while (arg0.hasNext()) {
			KafkaConsumerGroupFactory.KafkaConsumerRunner consumerRunner = (KafkaConsumerGroupFactory.KafkaConsumerRunner) arg0
					.next();

			try {
				consumerRunner.shutdown();
			} catch (Exception arg3) {
				this.dbLogger.error(arg3, 10);
			}
		}

	}

	private class KafkaConsumerRunner implements Runnable {
		private KafkaConsumerMsgListener listener;
		private final AtomicBoolean closed = new AtomicBoolean(false);
		private final KafkaConsumer consumer;

		public KafkaConsumerRunner(KafkaConsumerMsgListener listener) {
			KafkaConsumerGroupFactory.this.dbLogger
					.warn("start consumer:" + listener.getGroupId() + "=>" + listener.getTopic());
			this.listener = listener;
			Properties props = new Properties();
			props.put("bootstrap.servers", KafkaConsumerGroupFactory.this.brokers);
			props.put("group.id", listener.getGroupId());
			props.put("enable.auto.commit", "true");
			props.put("auto.commit.interval.ms", "1000");
			props.put("session.timeout.ms", "30000");
			props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			this.consumer = new KafkaConsumer(props);
			List topicList = Arrays.asList(new String[]{listener.getTopic()});
			this.consumer.subscribe(topicList);
			KafkaConsumerGroupFactory.this.dbLogger
					.warn("start consumer complete:" + listener.getGroupId() + "=>" + listener.getTopic());
		}

		public void run() {
			try {
				while (!this.closed.get()) {
					ConsumerRecords e = this.consumer.poll((long) this.listener.getPollInterval());
					Iterator arg1 = e.iterator();

					while (arg1.hasNext()) {
						ConsumerRecord record = (ConsumerRecord) arg1.next();
						this.listener.doMessage(record.topic(), (String) record.value());
					}
				}
			} catch (WakeupException arg6) {
				if (!this.closed.get()) {
					throw arg6;
				}
			} finally {
				this.consumer.close();
			}

		}

		public void shutdown() {
			this.closed.set(true);
			this.consumer.wakeup();
		}
	}
}