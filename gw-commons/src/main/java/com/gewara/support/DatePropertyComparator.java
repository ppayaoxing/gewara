package com.gewara.support;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

public class DatePropertyComparator implements Comparator {
	private String property = "";
	private boolean desc = false;
	public DatePropertyComparator(String property, boolean desc){
		this.property = property;
		this.desc = desc;
	}
	@Override
	public int compare(Object o1, Object o2) {
		if(o1==o2) return 0;
		if(o1==null && o2!=null) if(desc) return 1; else return -1;
		if(o2==null && o1!=null) if(desc) return -1; else return 1;
		if(o1==null && o2==null) return 0;
		Date value1 = null, value2 = null;
		try {
			value1 = (Date) PropertyUtils.getProperty(o1, property);
			value2 = (Date) PropertyUtils.getProperty(o2, property);
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		} catch (NoSuchMethodException e) {
		}
		if(value1==null && value2==null) return 0;
		if(value1!=null && value2 != null) if(desc) return -value1.compareTo(value2); else return value1.compareTo(value2);
		if(value1==null) if(desc) return 1; else return -1;
		else if(desc) return -1; else return 1;
	}
}
