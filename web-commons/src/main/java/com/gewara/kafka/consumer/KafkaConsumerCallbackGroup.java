package com.gewara.kafka.consumer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;

import com.gewara.support.TraceErrorException;

/**
 * 使用方法参详{@link KafkaConsumerGroupFactory}
 * @author quzhuping
 *
 */
public class KafkaConsumerCallbackGroup implements ConsumerCallbackGroup, InitializingBean{
	private List<KafkaConsumerCallback> callbackList = new ArrayList<>();

	public void setCallbackList(List<KafkaConsumerCallback> callbackList) {
		this.callbackList = callbackList;
	}
	
	@Override
	public void doGroupCallback(String topic, String value){
		for(KafkaConsumerCallback cb : callbackList){
			cb.doCallBack(topic, value);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(CollectionUtils.isEmpty(callbackList)){
			throw new TraceErrorException("KafkaConsumerCallback List is empty");
		}
	}

	
}
