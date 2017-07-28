/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.DateUtil;
import com.gewara.util.Util4Script;
import java.sql.Timestamp;
import java.util.Date;

public class ValueUtil implements Util4Script {
	public static final ValueUtil instance = new ValueUtil();

	public Long lv(Object value) {
		return this.longValue(value);
	}

	public Long longValue(Object value) {
		return value == null ? null : Long.valueOf(Long.parseLong(value.toString()));
	}

	public Integer iv(Object value) {
		return this.intValue(value);
	}

	public Integer intValue(Object value) {
		return value == null ? null : Integer.valueOf(Integer.parseInt(value.toString()));
	}

	public Double dv(Object value) {
		return this.doubleValue(value);
	}

	public Double doubleValue(Object value) {
		return value == null ? null : Double.valueOf(Double.parseDouble(value.toString()));
	}

	public Timestamp tv(Object value) {
		return this.timestampValue(value);
	}

	public Timestamp timestampValue(Object value) {
		return value == null ? null
				: (value instanceof Timestamp ? (Timestamp) value : DateUtil.parseTimestamp("" + value));
	}

	public Date dateValue(Object value) {
		return value == null ? null : (value instanceof Date ? (Date) value : DateUtil.parseDate("" + value));
	}

	public String stringValue(Object value) {
		return value == null ? null : value.toString();
	}
}