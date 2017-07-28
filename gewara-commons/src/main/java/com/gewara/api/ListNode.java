/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api;

import com.gewara.api.ApiNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListNode extends ApiNode {
	private List beanList;
	private List<Map<String, ?>> dataMapList = new ArrayList();
	private String singleNodeName;

	public List getBeanList() {
		return this.beanList;
	}

	public List<Map<String, ?>> getDataMapList() {
		return this.dataMapList;
	}

	public String getSingleNodeName() {
		return this.singleNodeName;
	}

	public ListNode(List beanList, String nodeName, String singleNodeName, boolean ignoreEmpty,
			String... outputFields) {
		this.beanList = beanList;
		this.nodeName = nodeName;
		this.ignoreEmpty = ignoreEmpty;
		this.singleNodeName = singleNodeName;
		if (outputFields != null && beanList != null) {
			Iterator arg5 = beanList.iterator();

			while (arg5.hasNext()) {
				Object bean = arg5.next();
				this.dataMapList.add(getBeanMap(bean, outputFields));
			}
		}

	}
}