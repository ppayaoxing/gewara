/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.support;

import java.util.Comparator;
import org.apache.commons.beanutils.PropertyUtils;

public class DoubleStringComparator<T> implements Comparator<T> {
	private String property = null;
	private boolean asc;

	public DoubleStringComparator(String property, boolean asc) {
		this.property = property;
		this.asc = asc;
	}

	public int compare(T o1, T o2) {
		int result = 0;
		boolean result1;
		if (o1 != null && o2 == null) {
			result1 = true;
		} else if (o1 == null && o2 != null) {
			result1 = true;
		} else if (o1 != null && o2 != null) {
			try {
				String p1 = "" + PropertyUtils.getProperty(o1, this.property);
				String p2 = "" + PropertyUtils.getProperty(o2, this.property);
				Double n1 = null;
				Double n2 = null;

				try {
					n1 = Double.valueOf(p1);
				} catch (Exception arg9) {
					;
				}

				try {
					n2 = Double.valueOf(p2);
				} catch (Exception arg8) {
					;
				}

				if (n1 == null && n2 != null) {
					result = -1;
				} else if (n2 == null && n1 != null) {
					result = 1;
				} else if (n1 != null && n2 != null) {
					result = n1.compareTo(n2);
				}

				if (result != 0) {
					return this.asc ? result : -result;
				}
			} catch (Exception arg10) {
				;
			}
		}

		return 0;
	}
}