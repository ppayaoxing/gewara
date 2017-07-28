/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.serializer;

import com.gewara.serialize.ObjectInput;
import com.gewara.serialize.ObjectOutput;
import com.gewara.serialize.Serialization;
import com.gewara.serialize.support.hessian.Hessian2Serialization;
import com.gewara.support.TraceErrorException;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class HessianRedisSerializer<T> implements RedisSerializer<T> {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	static final byte[] EMPTY_ARRAY = new byte[0];
	private Serialization serialization = new Hessian2Serialization();

	public byte[] serialize(T t) throws SerializationException {
		if (t == null) {
			return EMPTY_ARRAY;
		} else {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			try {
				ObjectOutput e = this.serialization.serialize(byteArrayOutputStream);
				e.writeObject(t);
				e.flushBuffer();
			} catch (IOException arg3) {
				throw new TraceErrorException("Non-serializable object", arg3);
			}

			return byteArrayOutputStream.toByteArray();
		}
	}

	public T deserialize(byte[] in) throws SerializationException {
		Object rv = null;

		try {
			if (in != null && in.length > 0) {
				ByteArrayInputStream e = new ByteArrayInputStream(in);
				ObjectInput deserialize = this.serialization.deserialize(e);
				rv = deserialize.readObject();
			}
		} catch (ClassNotFoundException arg4) {
			this.dbLogger.error(arg4, 10);
		} catch (IOException arg5) {
			this.dbLogger.error(arg5, 10);
		}

		return rv;
	}
}