package com.gewara.kafka.consumer;

public interface ConsumerCallbackGroup {
	void doGroupCallback(String topic, String value);
}
