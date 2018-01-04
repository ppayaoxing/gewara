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

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

public abstract class RedirectUrlBuilder {
	public static final String getRedirectUrl(String path, Map model){
		if(StringUtils.startsWith(path, "/")) {
            path = path.substring(1);
        }
		StringBuilder targetUrl = new StringBuilder(path);
		appendQueryProperties(targetUrl, model, "utf-8");
		return targetUrl.toString();
	}
	private static void appendQueryProperties(StringBuilder targetUrl, Map<String, Object> model, String encoding) {
		boolean first = (targetUrl.indexOf("?") < 0);
		for (Map.Entry<String, Object> entry : queryProperties(model).entrySet()) {
			Object rawValue = entry.getValue();
			Iterator valueIter = null;
			if (rawValue != null && rawValue.getClass().isArray()) {
				valueIter = Arrays.asList(ObjectUtils.toObjectArray(rawValue)).iterator();
			}
			else if (rawValue instanceof Collection) {
				valueIter = ((Collection) rawValue).iterator();
			}
			else {
				valueIter = Collections.singleton(rawValue).iterator();
			}
			while (valueIter.hasNext()) {
				Object value = valueIter.next();
				if (first) {
					targetUrl.append('?');
					first = false;
				}
				else {
					targetUrl.append('&');
				}
				String encodedKey = urlEncode(entry.getKey(), encoding);
				String encodedValue = (value != null ? urlEncode(value.toString(), encoding) : "");
				targetUrl.append(encodedKey).append('=').append(encodedValue);
			}
		}
	}

	private static Map<String, Object> queryProperties(Map<String, Object> model) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		for (Map.Entry<String, Object> entry : model.entrySet()) {
			if (isEligibleProperty(entry.getValue())) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}
	private static boolean isEligibleProperty(Object value) {
		if (value == null) {
            return false;
        }
		if (isEligibleValue(value)) {
            return true;
        }

		if (value.getClass().isArray()) {
			int length = Array.getLength(value);
			if (length == 0) {
				return false;
			}
			for (int i = 0; i < length; i++) {
				Object element = Array.get(value, i);
				if (!isEligibleValue(element)) {
					return false;
				}
			}
			return true;
		}

		if (value instanceof Collection) {
			Collection coll = (Collection) value;
			if (coll.isEmpty()) {
				return false;
			}
			for (Object element : coll) {
				if (!isEligibleValue(element)) {
					return false;
				}
			}
			return true;
		}

		return false;
	}
	private static String urlEncode(String input, String charsetName) {
		try {
			return (input != null ? URLEncoder.encode(input, charsetName) : null);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	private static boolean isEligibleValue(Object value) {
		return (value != null && BeanUtils.isSimpleValueType(value.getClass()));
	}

}
