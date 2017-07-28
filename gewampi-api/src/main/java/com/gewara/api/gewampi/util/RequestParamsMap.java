/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gewampi.util;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;

public class RequestParamsMap<K, V> extends HashMap<K, V> {
	private static final long serialVersionUID = -460044297542256915L;

	public V put(K key, V value) {
		if (value == null) {
			return null;
		} else {
			if (value instanceof String) {
				String valueStr = (String) value;
				if (StringUtils.isBlank(valueStr)) {
					return null;
				}
			}

			return super.put(key, value);
		}
	}
}