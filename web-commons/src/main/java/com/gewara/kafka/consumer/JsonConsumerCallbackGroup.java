package com.gewara.kafka.consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

import com.gewara.support.TraceErrorException;
import com.gewara.untrans.monitor.impl.MapMonitorEntry;
import com.gewara.util.JsonUtils;

public class JsonConsumerCallbackGroup implements ConsumerCallbackGroup, InitializingBean {
	private List<JsonConsumerCallback> callbackList = new ArrayList<>();

	public void setCallbackList(List<JsonConsumerCallback> callbackList) {
		this.callbackList = callbackList;
	}
	@Override
	public void doGroupCallback(String topic, String value){
		Map<String, String> data = JsonUtils.readJsonToMap(value);
		Map<String, String> header = new HashMap<String, String>();
		String headerStr = data.remove(MapMonitorEntry.HEADER_KEY);
		if(StringUtils.isNotBlank(headerStr)){
			header = JsonUtils.readJsonToMap(headerStr);
		}
		if(callbackList.size()==1){
			callbackList.get(0).doCallback(data, header);
		}else{
			for(JsonConsumerCallback cb : callbackList){
				cb.doCallback(new HashMap<String, String>(data), new HashMap<String, String>(header));
			}
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(CollectionUtils.isEmpty(callbackList)){
			throw new TraceErrorException("KafkaConsumerCallback List is empty");
		}
	}
}
