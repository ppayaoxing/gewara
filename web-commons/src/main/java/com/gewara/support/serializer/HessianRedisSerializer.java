package com.gewara.support.serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.gewara.serialize.ObjectInput;
import com.gewara.serialize.ObjectOutput;
import com.gewara.serialize.Serialization;
import com.gewara.serialize.support.hessian.Hessian2Serialization;
import com.gewara.support.TraceErrorException;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public class HessianRedisSerializer<T> implements RedisSerializer<T> {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());

	static final byte[] EMPTY_ARRAY = new byte[0];
	
	private Serialization serialization = new Hessian2Serialization();
	
	@Override
	public byte[] serialize(T t) throws SerializationException {
		if (t == null) {
			return EMPTY_ARRAY;
		}		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			ObjectOutput objectOutput = serialization.serialize(byteArrayOutputStream);
			objectOutput.writeObject(t);
			objectOutput.flushBuffer();
		} catch (IOException e) {
			 throw new TraceErrorException("Non-serializable object", e);
		}
		return byteArrayOutputStream.toByteArray();
	}

	@Override
	public T deserialize(byte[] in) throws SerializationException {
		T rv = null;
		try {
			if(in != null && in.length > 0){
				ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(in);
				ObjectInput deserialize = serialization.deserialize(byteArrayInputStream);
	
				rv = (T)deserialize.readObject();
			}
		} catch (ClassNotFoundException e) {
			dbLogger.error(e, 10);
		} catch (IOException e) {
			dbLogger.error(e, 10);
		}
		return rv;
	}

}
