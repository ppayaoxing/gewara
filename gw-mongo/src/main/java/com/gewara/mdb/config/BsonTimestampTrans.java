/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.config;

import java.sql.Timestamp;
import org.bson.BsonTimestamp;
import org.bson.Transformer;

public class BsonTimestampTrans implements Transformer {
	public Object transform(Object objectToTransform) {
		if (objectToTransform instanceof BsonTimestamp) {
			BsonTimestamp bt = (BsonTimestamp) objectToTransform;
			return new Timestamp((long) bt.getTime() * 1000L + (long) bt.getInc());
		} else {
			return objectToTransform;
		}
	}
}