/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

public abstract class RedirectUrlBuilder {
	public static final String getRedirectUrl(String path, Map model) {
		if (StringUtils.startsWith(path, "/")) {
			path = path.substring(1);
		}

		StringBuilder targetUrl = new StringBuilder(path);
		appendQueryProperties(targetUrl, model, "utf-8");
		return targetUrl.toString();
	}

	private static void appendQueryProperties(StringBuilder targetUrl, Map<String, Object> model, String encoding) {
		boolean first = targetUrl.indexOf("?") < 0;
		Iterator arg3 = queryProperties(model).entrySet().iterator();

		while (arg3.hasNext()) {
			Entry entry = (Entry) arg3.next();
			Object rawValue = entry.getValue();
			Iterator valueIter = null;
			if (rawValue != null && rawValue.getClass().isArray()) {
				valueIter = Arrays.asList(ObjectUtils.toObjectArray(rawValue)).iterator();
			} else if (rawValue instanceof Collection) {
				valueIter = ((Collection) rawValue).iterator();
			} else {
				valueIter = Collections.singleton(rawValue).iterator();
			}

			while (valueIter.hasNext()) {
				Object value = valueIter.next();
				if (first) {
					targetUrl.append('?');
					first = false;
				} else {
					targetUrl.append('&');
				}

				String encodedKey = urlEncode((String) entry.getKey(), encoding);
				String encodedValue = value != null ? urlEncode(value.toString(), encoding) : "";
				targetUrl.append(encodedKey).append('=').append(encodedValue);
			}
		}

	}

	private static Map<String, Object> queryProperties(Map<String, Object> model) {
		LinkedHashMap result = new LinkedHashMap();
		Iterator arg1 = model.entrySet().iterator();

		while (arg1.hasNext()) {
			Entry entry = (Entry) arg1.next();
			if (isEligibleProperty(entry.getValue())) {
				result.put(entry.getKey(), entry.getValue());
			}
		}

		return result;
	}

	private static boolean isEligibleProperty(Object value) {
		if (value == null) {
			return false;
		} else if (isEligibleValue(value)) {
			return true;
		} else {
			Object element;
			if (value.getClass().isArray()) {
				int arg3 = Array.getLength(value);
				if (arg3 == 0) {
					return false;
				} else {
					for (int arg4 = 0; arg4 < arg3; ++arg4) {
						element = Array.get(value, arg4);
						if (!isEligibleValue(element)) {
							return false;
						}
					}

					return true;
				}
			} else if (value instanceof Collection) {
				Collection coll = (Collection) value;
				if (coll.isEmpty()) {
					return false;
				} else {
					Iterator i = coll.iterator();

					do {
						if (!i.hasNext()) {
							return true;
						}

						element = i.next();
					} while (isEligibleValue(element));

					return false;
				}
			} else {
				return false;
			}
		}
	}

	private static String urlEncode(String input, String charsetName) {
		try {
			return input != null ? URLEncoder.encode(input, charsetName) : null;
		} catch (UnsupportedEncodingException arg2) {
			return null;
		}
	}

	private static boolean isEligibleValue(Object value) {
		return value != null && BeanUtils.isSimpleValueType(value.getClass());
	}
}