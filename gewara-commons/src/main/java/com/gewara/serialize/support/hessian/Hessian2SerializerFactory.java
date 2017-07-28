/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.serialize.support.hessian;

import com.caucho.hessian.io.AbstractSerializerFactory;
import com.caucho.hessian.io.BigDecimalDeserializer;
import com.caucho.hessian.io.Deserializer;
import com.caucho.hessian.io.HessianProtocolException;
import com.caucho.hessian.io.Serializer;
import com.caucho.hessian.io.SerializerFactory;
import com.caucho.hessian.io.StringValueSerializer;
import java.math.BigDecimal;

public class Hessian2SerializerFactory extends SerializerFactory {
	public static final SerializerFactory SERIALIZER_FACTORY = new Hessian2SerializerFactory();

	public ClassLoader getClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}

	static {
		AbstractSerializerFactory forBigDecimal = new AbstractSerializerFactory() {
			public Serializer getSerializer(Class paramClass) throws HessianProtocolException {
				return paramClass == BigDecimal.class ? new StringValueSerializer() : null;
			}

			public Deserializer getDeserializer(Class paramClass) throws HessianProtocolException {
				return paramClass == BigDecimal.class ? new BigDecimalDeserializer() : null;
			}
		};
		SERIALIZER_FACTORY.addFactory(forBigDecimal);
	}
}