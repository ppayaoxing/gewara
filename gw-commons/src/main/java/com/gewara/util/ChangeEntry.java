/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.BeanUtil;
import com.gewara.util.ClassUtils;
import com.gewara.util.DateUtil;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class ChangeEntry {
	private Map<String, ?> oldMap;

	public ChangeEntry() {
	}

	public ChangeEntry(Map<String, ?> oldMap) {
		this.oldMap = oldMap;
	}

	public ChangeEntry(Object oldObj) {
		this.setOld(oldObj);
	}

	public void setOld(Object oldObj) {
		if (oldObj != null) {
			this.oldMap = BeanUtil.getBeanMap(oldObj);
		}

		if (this.oldMap == null) {
			this.oldMap = new HashMap();
		}

	}

	public Map<String, String> getChangeMap(Object newObj) {
		HashMap tmpMap = new HashMap(this.oldMap);
		Object newMap = BeanUtil.getBeanMap(newObj);
		if (newMap == null) {
			newMap = new HashMap();
		}

		HashMap changeMap = new HashMap();
		ArrayList keySet = new ArrayList();
		keySet.addAll(tmpMap.keySet());
		keySet.addAll(((Map) newMap).keySet());
		Iterator arg5 = keySet.iterator();

		while (arg5.hasNext()) {
			String key = (String) arg5.next();
			Object oldvalue = tmpMap.remove(key);
			Object newvalue = ((Map) newMap).remove(key);
			String ov = this.getStringValue(oldvalue);
			String nv = this.getStringValue(newvalue);
			if (!StringUtils.equals(ov, nv)) {
				changeMap.put(key, ov + "==>" + nv);
			}
		}

		return changeMap;
	}

	public String getChangeMap(Map<String, String> changeMap) {
		if (changeMap.isEmpty()) {
			return "";
		} else {
			String change = changeMap.toString();
			return change;
		}
	}

	public String getStringValue(Object value) {
		return value == null ? ""
				: (value instanceof String ? (String) value
						: (ClassUtils.isPrimitiveOrWrapper(value.getClass()) ? "" + value
								: (value instanceof Timestamp ? DateUtil.formatTimestamp((Timestamp) value)
										: (value instanceof Date ? DateUtil.formatDate((Date) value) : "" + value))));
	}
}