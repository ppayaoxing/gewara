/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.config;

import java.sql.Date;
import org.bson.BsonReader;
import org.bson.BsonTimestamp;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class SqlDateCodec implements Codec<Date> {
	public void encode(BsonWriter writer, Date value, EncoderContext encoderContext) {
		long m = value.getTime();
		writer.writeTimestamp(new BsonTimestamp((int) (m / 1000L), (int) (m % 1000L)));
	}

	public Class<Date> getEncoderClass() {
		return Date.class;
	}

	public Date decode(BsonReader reader, DecoderContext decoderContext) {
		BsonTimestamp bt = reader.readTimestamp();
		return new Date((long) bt.getTime() * 1000L + (long) bt.getInc());
	}
}