/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.support;

import java.util.Comparator;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

public class MapItemComparator implements Comparator<Map> {
	private String elname;
	private String property;
	boolean desc;

	public MapItemComparator(String elname, String property, boolean desc) {
		this.elname = elname;
		this.property = property;
		this.desc = desc;
	}

	public int compare(Map one, Map another) {
		Comparable o1 = (Comparable) one.get(this.elname);
		Comparable o2 = (Comparable) another.get(this.elname);
		boolean result = false;
		if ((o1 != null || o2 != null) && o1 != o2) {
			int result1;
			if (o1 == null && o2 != null) {
				result1 = -1;
			} else if (o1 != null && o2 == null) {
				result1 = 1;
			} else if (StringUtils.isBlank(this.property)) {
				result1 = o1.compareTo(o2);
			} else {
				result1 = compareProperty(o1, o2, this.property);
			}

			return this.desc ? -result1 : result1;
		} else {
			return 0;
		}
	}

	private static int compareProperty(Object o1, Object o2, String prop) {
		int result = 0;

		try {
			Comparable p1 = (Comparable) PropertyUtils.getProperty(o1, prop);
			Comparable p2 = (Comparable) PropertyUtils.getProperty(o2, prop);
			if (p1 == null && p2 != null) {
				result = -1;
			} else if (p2 == null && p1 != null) {
				result = 1;
			} else if (p1 != null && p2 != null) {
				result = p1.compareTo(p2);
			}
		} catch (Exception arg5) {
			;
		}

		return result;
	}
}