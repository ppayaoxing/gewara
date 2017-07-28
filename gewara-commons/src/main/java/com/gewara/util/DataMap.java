/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.DateUtil;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class DataMap implements Map {
	private Map map;

	public DataMap(Map map) {
		this.map = map;
	}

	public Long longValue(String key) {
		Object value = this.map.get(key);
		return value == null ? null : Long.valueOf(Long.parseLong(value.toString()));
	}

	public Integer intValue(String key) {
		Object value = this.map.get(key);
		return value == null ? null : Integer.valueOf(Integer.parseInt(value.toString()));
	}

	public Double doubleValue(String key) {
		Object value = this.map.get(key);
		return value == null ? null : Double.valueOf(Double.parseDouble(value.toString()));
	}

	public Timestamp timestampValue(String key) {
		Object value = this.map.get(key);
		return value == null ? null
				: (value instanceof Timestamp ? (Timestamp) value : DateUtil.parseTimestamp("" + value));
	}

	public Date dateValue(String key) {
		Object value = this.map.get(key);
		return value == null ? null : (value instanceof Date ? (Date) value : DateUtil.parseDate("" + value));
	}

	public String stringValue(String key) {
		Object value = this.map.get(key);
		return value == null ? null : value.toString();
	}

	public int size() {
		return this.map.size();
	}

	public boolean isEmpty() {
		return this.map == null || this.map.isEmpty();
	}

	public boolean containsKey(Object key) {
		return this.map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return this.map.containsValue(value);
	}

	public Object get(Object key) {
		return this.map.get(key);
	}

	public Object put(Object key, Object value) {
		return this.map.put(key, value);
	}

	public Object remove(Object key) {
		return this.map.remove(key);
	}

	public void putAll(Map m) {
		this.map.putAll(m);
	}

	public void clear() {
		this.map.clear();
	}

	public Set keySet() {
		return this.map.keySet();
	}

	public Collection values() {
		return this.map.values();
	}

	public Set entrySet() {
		return this.map.entrySet();
	}
}