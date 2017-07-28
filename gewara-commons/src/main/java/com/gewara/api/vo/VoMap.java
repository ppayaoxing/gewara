/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.BeanUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class VoMap<K, V> implements Map<K, V>, Serializable {
	private static final long serialVersionUID = -6947799462487517862L;
	private static GewaLogger dbLogger = LoggerUtils.getLogger(VoMap.class);
	private Map<K, V> _underline;

	public VoMap() {
		this._underline = new LinkedHashMap(0);
	}

	public VoMap(int initialCapacity) {
		this._underline = new LinkedHashMap(initialCapacity);
	}

	public VoMap(int initialCapacity, float loadFactor) {
		this._underline = new LinkedHashMap(initialCapacity, loadFactor);
	}

	public V put(K key, V value) {
		this.checkValue(value, 1);
		return this._underline.put(key, value);
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		Set keys = m.keySet();
		Iterator arg2 = keys.iterator();

		while (arg2.hasNext()) {
			Object key = arg2.next();
			this.put(key, m.get(key));
		}

	}

	private boolean checkValue(Object value, int deep) {
		if (value == null) {
			return true;
		} else if (deep >= 7) {
			return false;
		} else if (this.isValid(value)) {
			return true;
		} else if (value instanceof Collection) {
			return this.checkCollection((Collection) value, deep + 1);
		} else if (value instanceof Map) {
			return this.checkMap((Map) value, deep + 1);
		} else {
			if (value.getClass().isArray()) {
				Class clazz = value.getClass().getComponentType();
				if (BeanUtil.isSimpleProperty(clazz) || BaseVo.class.isAssignableFrom(clazz)) {
					return true;
				}
			}

			dbLogger.warn("InvalidVoMapData:" + value);
			return false;
		}
	}

	private boolean checkMap(Map value, int deep) {
		if (deep >= 7) {
			return false;
		} else {
			Collection values = value.values();
			Iterator it = values.iterator();

			Object v;
			boolean c;
			do {
				if (!it.hasNext()) {
					return true;
				}

				v = it.next();
				c = this.checkValue(v, deep);
			} while (c);

			dbLogger.warn("InvalidVoMapData:" + v);
			return c;
		}
	}

	private boolean checkCollection(Collection value, int deep) {
		if (deep >= 7) {
			return false;
		} else {
			Iterator it = value.iterator();

			Object v;
			boolean c;
			do {
				if (!it.hasNext()) {
					return true;
				}

				v = it.next();
				c = this.checkValue(v, deep);
			} while (c);

			dbLogger.warn("InvalidVoMapData:" + v);
			return c;
		}
	}

	private boolean isValid(Object value) {
		return value instanceof Timestamp || value instanceof BaseVo || BeanUtil.isSimpleProperty(value.getClass());
	}

	public int size() {
		return this._underline.size();
	}

	public boolean isEmpty() {
		return this._underline.isEmpty();
	}

	public boolean containsKey(Object key) {
		return this._underline.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return this._underline.containsValue(value);
	}

	public V get(Object key) {
		return this._underline.get(key);
	}

	public V remove(Object key) {
		return this._underline.remove(key);
	}

	public void clear() {
		this._underline.clear();
	}

	public Set<K> keySet() {
		return this._underline.keySet();
	}

	public Collection<V> values() {
		return this._underline.values();
	}

	public Set<Entry<K, V>> entrySet() {
		return this._underline.entrySet();
	}
}