/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.kafka.consumer;

import com.gewara.kafka.consumer.ConsumerCallbackGroup;
import com.gewara.kafka.consumer.KafkaConsumerCallback;
import com.gewara.support.TraceErrorException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.InitializingBean;

public class KafkaConsumerCallbackGroup implements ConsumerCallbackGroup, InitializingBean {
	private List<KafkaConsumerCallback> callbackList = new ArrayList();

	public void setCallbackList(List<KafkaConsumerCallback> callbackList) {
		this.callbackList = callbackList;
	}

	public void doGroupCallback(String topic, String value) {
		Iterator arg2 = this.callbackList.iterator();

		while (arg2.hasNext()) {
			KafkaConsumerCallback cb = (KafkaConsumerCallback) arg2.next();
			cb.doCallBack(topic, value);
		}

	}

	public void afterPropertiesSet() throws Exception {
		if (CollectionUtils.isEmpty(this.callbackList)) {
			throw new TraceErrorException("KafkaConsumerCallback List is empty");
		}
	}
}