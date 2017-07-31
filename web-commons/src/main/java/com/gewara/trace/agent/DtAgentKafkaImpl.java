package com.gewara.trace.agent;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gewara.kafka.producer.KafkaProducerTemplate;
import com.gewara.trace.Span;
import com.gewara.util.GewaLogger;
import com.gewara.util.JsonUtils;
import com.gewara.util.WebLogger;

@Service("dtAgent")
public class DtAgentKafkaImpl implements DtAgent, InitializingBean {
	protected final transient GewaLogger logger = WebLogger.getLogger(getClass());
	
	@Autowired(required=false)
	private KafkaProducerTemplate kafkaProducer;
	private boolean isKafka = false;
	private String topic = "DT_TRACE_INFO";
	
	private ThreadPoolExecutor executor;
	
	@Override
	public void sendTraceInfo(final List<Span> spanList) {
		if(isKafka){
			try{
				executor.execute(new Runnable() {				
					@Override
					public void run() {
						kafkaProducer.send(topic, JsonUtils.writeObjectToJson(spanList));
					}
				});
			}catch(Exception e){
				logger.error(e, 10);
			}
			
		}else{
			logger.warn(JsonUtils.writeObjectToJson(spanList));
		}

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(kafkaProducer != null){
			isKafka = true;
			kafkaProducer.addValidTopic(topic);
			logger.warn("DT send trace info by kafka!");
			
			BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<Runnable>(5000);
			executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, taskQueue);
			executor.allowCoreThreadTimeOut(false);
			executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
		}
	}

}
