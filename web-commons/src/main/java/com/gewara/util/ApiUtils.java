/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import com.gewara.support.GewaObjectStringConverter;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.beans.IntrospectionException;
import java.io.StringReader;
import org.apache.commons.betwixt.io.BeanReader;

public class ApiUtils {
	protected static final transient GewaLogger dbLogger = WebLogger.getLogger(ApiUtils.class);

	public static BeanReader getBeanReader(String nodeName, Class clazz) {
		BeanReader beanReader = new BeanReader();
		beanReader.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(true);
		beanReader.getBindingConfiguration().setMapIDs(false);
		beanReader.getBindingConfiguration().setObjectStringConverter(new GewaObjectStringConverter());

		try {
			beanReader.registerBeanClass(nodeName, clazz);
		} catch (IntrospectionException arg3) {
			;
		}

		return beanReader;
	}

	public static Object xml2Object(BeanReader reader, String xml) {
		StringReader xmlReader = new StringReader(xml);

		try {
			Object e = reader.parse(xmlReader);
			return e;
		} catch (Exception arg3) {
			dbLogger.warn(arg3.getMessage() + "\n" + xml);
			return null;
		}
	}

	public static Object xml2Object(Class clazz, String xml, String nodeName) {
		return xml2Object(getBeanReader(nodeName, clazz), xml);
	}
}