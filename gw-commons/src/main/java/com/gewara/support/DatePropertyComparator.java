/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.support;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Date;
import org.apache.commons.beanutils.PropertyUtils;

public class DatePropertyComparator implements Comparator {
	private String property = "";
	private boolean desc = false;

	public DatePropertyComparator(String property, boolean desc) {
		this.property = property;
		this.desc = desc;
	}

	public int compare(Object o1, Object o2) {
		if (o1 == o2) {
			return 0;
		} else if (o1 == null && o2 != null) {
			return this.desc ? 1 : -1;
		} else if (o2 == null && o1 != null) {
			return this.desc ? -1 : 1;
		} else if (o1 == null && o2 == null) {
			return 0;
		} else {
			Date value1 = null;
			Date value2 = null;

			try {
				value1 = (Date) PropertyUtils.getProperty(o1, this.property);
				value2 = (Date) PropertyUtils.getProperty(o2, this.property);
			} catch (IllegalAccessException arg5) {
				;
			} catch (InvocationTargetException arg6) {
				;
			} catch (NoSuchMethodException arg7) {
				;
			}

			return value1 == null && value2 == null ? 0
					: (value1 != null && value2 != null
							? (this.desc ? -value1.compareTo(value2) : value1.compareTo(value2))
							: (value1 == null ? (this.desc ? 1 : -1) : (this.desc ? -1 : 1)));
		}
	}
}