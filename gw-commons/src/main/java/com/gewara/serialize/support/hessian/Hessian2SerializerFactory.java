
package com.gewara.serialize.support.hessian;

import java.math.BigDecimal;

import com.caucho.hessian.io.AbstractSerializerFactory;
import com.caucho.hessian.io.BigDecimalDeserializer;
import com.caucho.hessian.io.Deserializer;
import com.caucho.hessian.io.HessianProtocolException;
import com.caucho.hessian.io.Serializer;
import com.caucho.hessian.io.SerializerFactory;
import com.caucho.hessian.io.StringValueSerializer;
/**
 * lazy-load
 * @author Johnson Yang
 *
 */
public class Hessian2SerializerFactory extends SerializerFactory {

	public static final SerializerFactory SERIALIZER_FACTORY = new Hessian2SerializerFactory();

	static{
		AbstractSerializerFactory forBigDecimal = new AbstractSerializerFactory(){

			@Override
			public Serializer getSerializer(Class paramClass) throws HessianProtocolException {
				if (paramClass == BigDecimal.class) {
					return  new StringValueSerializer();
				}
				return null;
			}

			@Override
			public Deserializer getDeserializer(Class paramClass) throws HessianProtocolException {
				if (paramClass == BigDecimal.class) {
					return  new BigDecimalDeserializer();
				} /*else if (paramClass == char[].class) {
					return  new 
				}*/
				return null;
			}
			
		};
		
		SERIALIZER_FACTORY.addFactory(forBigDecimal);
	}
	private Hessian2SerializerFactory() {
		
	}

	@Override
	/**
	 */
	public ClassLoader getClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}

}
