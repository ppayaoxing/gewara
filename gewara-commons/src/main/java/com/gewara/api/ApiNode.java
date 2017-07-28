/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api;

import com.gewara.util.BeanUtil;
import java.util.Map;

public abstract class ApiNode {
	protected String nodeName;
	protected String[] outputFields;
	protected boolean ignoreEmpty;

	public boolean isIgnoreEmpty() {
		return this.ignoreEmpty;
	}

	public String getNodeName() {
		return this.nodeName;
	}

	public String[] getOutputFields() {
		return this.outputFields;
	}

	public static Map getBeanMap(Object bean, String[] outputFields) {
		Map result = BeanUtil.getBeanMapWithKey(bean, false, outputFields);
		String[] arg2 = outputFields;
		int arg3 = outputFields.length;

		for (int arg4 = 0; arg4 < arg3; ++arg4) {
			String field = arg2[arg4];
			Object value = BeanUtil.get(bean, field);
			if (value != null && BeanUtil.isSimpleValueType(value.getClass())) {
				result.put(field, value);
			}
		}

		return result;
	}
}