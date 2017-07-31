package com.gewara.kafka.consumer;

/**
 * kafka消费回调
 * @author quzhuping
 *
 */
public interface KafkaConsumerCallback {
	/**
	 * 回调处理数据方法<br>
	 * 需要实现异步逻辑处理
	 * @param topic
	 * @param value
	 */
	void doCallBack(String topic, String value);
}
