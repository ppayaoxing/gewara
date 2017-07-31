package com.gewara.kafka.consumer;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

import com.gewara.support.TraceErrorException;

/**
 * 使用方法参详{@link KafkaConsumerGroupFactory}
 * @author quzhuping
 *
 */
public class KafkaConsumerMsgListener implements InitializingBean{
	private String groupId;
	private String topic;
	private int pollInterval = 500;
	private ConsumerCallbackGroup callbackGroup;
	
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getGroupId() {
		return groupId;
	}
	public String getTopic() {
		return topic;
	}
	public void setCallbackGroup(ConsumerCallbackGroup callbackGroup) {
		this.callbackGroup = callbackGroup;
	}
	
	public void doMessage(String topic1, String value){
		callbackGroup.doGroupCallback(topic1, value);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if(callbackGroup == null){
			throw new TraceErrorException("callbackGroup is null");
		}
		if (StringUtils.isBlank(groupId)) {
			throw new TraceErrorException("groupId is blank");
		}
		if (StringUtils.isBlank(topic)) {
			throw new TraceErrorException("topic is blank");
		}
		
	}
	public void setPollInterval(int pollInterval) {
		this.pollInterval = pollInterval;
	}
	public int getPollInterval() {
		return pollInterval;
	}
	
}
