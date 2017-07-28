/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.kafka.consumer;

import java.util.Map;

public interface JsonConsumerCallback {
	void doCallback(Map<String, String> arg0, Map<String, String> arg1);
}