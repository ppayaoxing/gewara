package com.gewara.kafka.consumer;

import java.util.Map;

public interface JsonConsumerCallback {

	void doCallback(Map<String, String> data, Map<String, String> header);

}
