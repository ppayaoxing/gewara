/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.trace.agent;

import com.gewara.kafka.producer.KafkaProducerTemplate;
import com.gewara.trace.Span;
import com.gewara.trace.agent.DtAgent;
import com.gewara.util.GewaLogger;
import com.gewara.util.JsonUtils;
import com.gewara.util.WebLogger;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dtAgent")
public class DtAgentKafkaImpl implements DtAgent, InitializingBean {
	protected final transient GewaLogger logger = WebLogger.getLogger(this.getClass());
	@Autowired(required = false)
	private KafkaProducerTemplate kafkaProducer;
	private boolean isKafka = false;
	private String topic = "DT_TRACE_INFO";
	private ThreadPoolExecutor executor;

	public void sendTraceInfo(final List<Span> spanList) {
		if (this.isKafka) {
			try {
				this.executor.execute(new Runnable() {
					public void run() {
						DtAgentKafkaImpl.this.kafkaProducer.send(DtAgentKafkaImpl.this.topic,
								JsonUtils.writeObjectToJson(spanList));
					}
				});
			} catch (Exception arg2) {
				this.logger.error(arg2, 10);
			}
		} else {
			this.logger.warn(JsonUtils.writeObjectToJson(spanList));
		}

	}

	public void afterPropertiesSet() throws Exception {
		if (this.kafkaProducer != null) {
			this.isKafka = true;
			this.kafkaProducer.addValidTopic(this.topic);
			this.logger.warn("DT send trace info by kafka!");
			ArrayBlockingQueue taskQueue = new ArrayBlockingQueue(5000);
			this.executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, taskQueue);
			this.executor.allowCoreThreadTimeOut(false);
			this.executor.setRejectedExecutionHandler(new DiscardPolicy());
		}

	}
}