package com.gewara.mongo.support;

import java.util.Map;

public interface MongoRowCallback {
	void processRow(Map row);
}
