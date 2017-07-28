/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api;

import com.gewara.api.ApiNode;
import com.gewara.util.BeanUtil;

public class SimpleNode extends ApiNode {
	private Object simpleValue;

	public SimpleNode(String nodeName, Object simpleValue, boolean ignoreEmpty) {
		if (simpleValue != null && BeanUtil.isSimpleValueType(simpleValue.getClass())) {
			throw new IllegalArgumentException(simpleValue + " must be simple!");
		} else {
			this.nodeName = nodeName;
			this.simpleValue = simpleValue;
			this.ignoreEmpty = ignoreEmpty;
		}
	}

	public Object getSimpleValue() {
		return this.simpleValue;
	}
}