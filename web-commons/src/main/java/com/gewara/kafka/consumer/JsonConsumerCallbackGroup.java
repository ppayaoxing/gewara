/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.kafka.consumer;

import com.gewara.kafka.consumer.ConsumerCallbackGroup;
import com.gewara.kafka.consumer.JsonConsumerCallback;
import com.gewara.support.TraceErrorException;
import com.gewara.util.JsonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

public class JsonConsumerCallbackGroup implements ConsumerCallbackGroup, InitializingBean {
	private List<JsonConsumerCallback> callbackList = new ArrayList();

	public void setCallbackList(List<JsonConsumerCallback> callbackList) {
		this.callbackList = callbackList;
	}

	public void doGroupCallback(String topic, String value) {
		Map data = JsonUtils.readJsonToMap(value);
		Object header = new HashMap();
		String headerStr = (String) data.remove("__header__");
		if (StringUtils.isNotBlank(headerStr)) {
			header = JsonUtils.readJsonToMap(headerStr);
		}

		if (this.callbackList.size() == 1) {
			((JsonConsumerCallback) this.callbackList.get(0)).doCallback(data, (Map) header);
		} else {
			Iterator arg5 = this.callbackList.iterator();

			while (arg5.hasNext()) {
				JsonConsumerCallback cb = (JsonConsumerCallback) arg5.next();
				cb.doCallback(new HashMap(data), new HashMap((Map) header));
			}
		}

	}

	public void afterPropertiesSet() throws Exception {
		if (CollectionUtils.isEmpty(this.callbackList)) {
			throw new TraceErrorException("KafkaConsumerCallback List is empty");
		}
	}
}