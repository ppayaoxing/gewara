/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor;

import com.gewara.untrans.monitor.ConfigTrigger;
import com.gewara.util.BeanUtil;
import com.gewara.util.DateUtil;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class ConfigData implements ConfigTrigger {
	private Object data;

	public ConfigData(Map data) {
		this.data = data;
	}

	public Integer getInteger(String key) {
		Object value = BeanUtil.get(this.data, key);
		if (value != null) {
			try {
				return Integer.valueOf(Integer.parseInt(value.toString()));
			} catch (Exception arg3) {
				;
			}
		}

		return null;
	}

	public Long getLong(String key) {
		Object value = BeanUtil.get(this.data, key);
		if (value != null) {
			try {
				return Long.valueOf(Long.parseLong(value.toString()));
			} catch (Exception arg3) {
				;
			}
		}

		return null;
	}

	public Date getDate(String key) {
		Object value = BeanUtil.get(this.data, key);
		if (value != null) {
			try {
				return DateUtil.parseDate(value.toString());
			} catch (Exception arg3) {
				;
			}
		}

		return null;
	}

	public Timestamp getTimestamp(String key) {
		Object value = BeanUtil.get(this.data, key);
		if (value != null) {
			try {
				return DateUtil.parseTimestamp(value.toString());
			} catch (Exception arg3) {
				;
			}
		}

		return null;
	}

	public String getString(String key) {
		Object value = BeanUtil.get(this.data, key);
		if (value != null) {
			try {
				return value.toString();
			} catch (Exception arg3) {
				;
			}
		}

		return null;
	}

	public Object get(String property) {
		try {
			return PropertyUtils.getNestedProperty(this.data, property);
		} catch (IllegalAccessException arg2) {
			;
		} catch (InvocationTargetException arg3) {
			;
		} catch (NoSuchMethodException arg4) {
			;
		} catch (Exception arg5) {
			;
		}

		return null;
	}

	public abstract void refreshCurrent(String arg0);
}