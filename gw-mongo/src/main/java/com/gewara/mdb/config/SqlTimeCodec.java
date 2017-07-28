/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.config;

import java.sql.Time;
import org.bson.BsonReader;
import org.bson.BsonTimestamp;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class SqlTimeCodec implements Codec<Time> {
	public void encode(BsonWriter writer, Time value, EncoderContext encoderContext) {
		long m = value.getTime();
		writer.writeTimestamp(new BsonTimestamp((int) (m / 1000L), (int) (m % 1000L)));
	}

	public Class<Time> getEncoderClass() {
		return Time.class;
	}

	public Time decode(BsonReader reader, DecoderContext decoderContext) {
		BsonTimestamp bt = reader.readTimestamp();
		return new Time((long) bt.getTime() * 1000L + (long) bt.getInc());
	}
}