/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.util.Assert;

public class RequestMapPropertyValues extends MutablePropertyValues {
	private static final long serialVersionUID = 5230454540179625738L;
	public static final String DEFAULT_PREFIX_SEPARATOR = "_";

	public RequestMapPropertyValues(Map requestParams) {
		this(requestParams, (String) null, (String) null);
	}

	public RequestMapPropertyValues(Map<String, Object> requestParams, String prefix) {
		this(requestParams, prefix, "_");
	}

	public RequestMapPropertyValues(Map requestParams, String prefix, String prefixSeparator) {
		super(getParametersStartingWith(requestParams, prefix != null ? prefix + prefixSeparator : null));
	}

	public static Map<String, Object> getParametersStartingWith(Map requestParams, String prefix) {
		Assert.notNull(requestParams, "requestParams must not be null");
		Iterator paramNames = requestParams.keySet().iterator();
		TreeMap params = new TreeMap();
		if (prefix == null) {
			prefix = "";
		}

		while (paramNames != null && paramNames.hasNext()) {
			String paramName = (String) paramNames.next();
			if ("".equals(prefix) || paramName.startsWith(prefix)) {
				String unprefixed = paramName.substring(prefix.length());
				Object values = requestParams.get(paramName);
				if (values != null) {
					if (values instanceof String[]) {
						if (((String[]) ((String[]) values)).length > 1) {
							params.put(unprefixed, values);
						} else {
							params.put(unprefixed, ((String[]) ((String[]) values))[0]);
						}
					} else {
						params.put(unprefixed, values);
					}
				}
			}
		}

		return params;
	}
}