/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.kafka.consumer;

import com.gewara.kafka.consumer.ConsumerCallbackGroup;
import com.gewara.support.TraceErrorException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

public class KafkaConsumerMsgListener implements InitializingBean {
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
		return this.groupId;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setCallbackGroup(ConsumerCallbackGroup callbackGroup) {
		this.callbackGroup = callbackGroup;
	}

	public void doMessage(String topic1, String value) {
		this.callbackGroup.doGroupCallback(topic1, value);
	}

	public void afterPropertiesSet() throws Exception {
		if (this.callbackGroup == null) {
			throw new TraceErrorException("callbackGroup is null");
		} else if (StringUtils.isBlank(this.groupId)) {
			throw new TraceErrorException("groupId is blank");
		} else if (StringUtils.isBlank(this.topic)) {
			throw new TraceErrorException("topic is blank");
		}
	}

	public void setPollInterval(int pollInterval) {
		this.pollInterval = pollInterval;
	}

	public int getPollInterval() {
		return this.pollInterval;
	}
}