/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api;

import com.gewara.api.ApiNode;
import java.util.Map;

public class BeanNode extends ApiNode {
	private Object nodeBean;
	private Map dataMap;

	public Object getNodeBean() {
		return this.nodeBean;
	}

	public BeanNode(Object bean, String nodeName, boolean ignoreEmpty, String... outputFields) {
		this.nodeBean = bean;
		this.nodeName = nodeName;
		this.ignoreEmpty = ignoreEmpty;
		if (outputFields != null && this.nodeBean != null) {
			this.dataMap = getBeanMap(this.nodeBean, outputFields);
		}

	}

	public Map<String, ?> getDataMap() {
		return this.dataMap;
	}
}