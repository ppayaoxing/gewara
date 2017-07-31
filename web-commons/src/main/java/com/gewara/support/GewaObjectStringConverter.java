package com.gewara.support;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.betwixt.expression.Context;
import org.apache.commons.betwixt.strategy.ConvertUtilsObjectStringConverter;

import com.gewara.util.DateUtil;

/**
 * @author acerge(acerge@163.com)
 * @since 7:32:35 PM Nov 27, 2009
 */
public class GewaObjectStringConverter extends ConvertUtilsObjectStringConverter {
	private static final long serialVersionUID = 4695536454755182516L;

	@Override
	public String objectToString(Object object, Class type, String flavour, Context context) {
		if (object != null) {
			if (object instanceof Class) {
				return ((Class) object).getName();
			}

			if (java.sql.Timestamp.class.isAssignableFrom(type)) {
				return DateUtil.format((Date)object, "yyyy-MM-dd HH:mm:ss");
			} else if (java.util.Date.class.isAssignableFrom(type)) {
				return DateUtil.format((Date)object, "yyyy-MM-dd");
			} else {
				// use ConvertUtils implementation
				return super.objectToString(object, type, flavour, context);
			}
		}
		return "";
	}

	/**
	 * Converts an object to a string representation using ConvertUtils.
	 * 
	 * @param value
	 *           the String to be converted, not null
	 * @param type
	 *           the property class to be returned (if possible), not null
	 * @param flavour
	 *           a string allow symantic differences in formatting to be communicated (ignored)
	 * @param context
	 *           not null
	 * @return an Object converted from the String, not null
	 */
	@Override
	public Object stringToObject(String value, Class type, String flavour, Context context) {
		if (Timestamp.class.isAssignableFrom(type)) {
			return DateUtil.parseTimestamp(value);
		} else if (java.util.Date.class.isAssignableFrom(type)) {
			return DateUtil.parseDate(value);
		} else {
			// use ConvertUtils implementation
			return super.stringToObject(value, type, flavour, context);
		}
	}

	/**
	 * Allow subclasses to use a different exception handling strategy. This class throws a
	 * <code>org.apache.commons.beanutils.ConversionException</code> when conversion fails.
	 * 
	 * @param e
	 *           the Exception to be handled
	 * @throws org.apache.commons.beanutils.ConversionException
	 *            when conversion fails
	 */
	protected void handleException(Exception e) {
		throw new ConversionException("String to object conversion failed: " + e.getMessage(), e);
	}
}
