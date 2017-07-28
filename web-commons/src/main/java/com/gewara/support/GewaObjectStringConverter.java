/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import com.gewara.util.DateUtil;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.betwixt.expression.Context;
import org.apache.commons.betwixt.strategy.ConvertUtilsObjectStringConverter;

public class GewaObjectStringConverter extends ConvertUtilsObjectStringConverter {
	private static final long serialVersionUID = 4695536454755182516L;

	public String objectToString(Object object, Class type, String flavour, Context context) {
		return object != null
				? (object instanceof Class ? ((Class) object).getName() : (Timestamp.class.isAssignableFrom(type)
						? DateUtil.format((Date) object, "yyyy-MM-dd HH:mm:ss")
						: (Date.class.isAssignableFrom(type)
								? DateUtil.format((Date) object, "yyyy-MM-dd")
								: super.objectToString(object, type, flavour, context))))
				: "";
	}

	public Object stringToObject(String value, Class type, String flavour, Context context) {
		return Timestamp.class.isAssignableFrom(type)
				? DateUtil.parseTimestamp(value)
				: (Date.class.isAssignableFrom(type)
						? DateUtil.parseDate(value)
						: super.stringToObject(value, type, flavour, context));
	}

	protected void handleException(Exception e) {
		throw new ConversionException("String to object conversion failed: " + e.getMessage(), e);
	}
}