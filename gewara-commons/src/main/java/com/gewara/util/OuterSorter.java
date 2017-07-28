/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OuterSorter<T> {
	private Map<Comparable, List<T>> beanMap = new TreeMap();
	private List<T> nullList = new LinkedList();
	private int count;
	private boolean nullAsc;

	public OuterSorter(boolean nullAsc) {
		this.nullAsc = nullAsc;
	}

	public void addBean(Comparable sortValue, T bean) {
		if (sortValue == null) {
			this.nullList.add(bean);
		} else {
			Object tmp = (List) this.beanMap.get(sortValue);
			if (tmp == null) {
				tmp = new ArrayList(2);
				this.beanMap.put(sortValue, tmp);
			}

			((List) tmp).add(bean);
		}

		++this.count;
	}

	public List<T> getAscResult() {
		ArrayList result = new ArrayList(this.count);
		if (this.nullAsc) {
			result.addAll(this.nullList);
		}

		Iterator arg1 = this.beanMap.keySet().iterator();

		while (arg1.hasNext()) {
			Comparable key = (Comparable) arg1.next();
			result.addAll((Collection) this.beanMap.get(key));
		}

		if (!this.nullAsc) {
			result.addAll(this.nullList);
		}

		return result;
	}

	public List<T> getDescResult() {
		LinkedList result = new LinkedList();
		Iterator arg1 = this.beanMap.keySet().iterator();

		while (arg1.hasNext()) {
			Comparable key = (Comparable) arg1.next();
			result.addAll(0, (Collection) this.beanMap.get(key));
		}

		if (this.nullAsc) {
			result.addAll(this.nullList);
		} else {
			result.addAll(0, this.nullList);
		}

		return result;
	}
}