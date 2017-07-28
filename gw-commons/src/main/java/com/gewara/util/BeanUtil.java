/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.dubbo.bytecode.Wrapper;
import com.gewara.support.TraceErrorException;
import com.gewara.util.Assert;
import com.gewara.util.ClassUtils;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import com.gewara.util.Util4Script;
import com.gewara.util.ValidateUtil;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;
import org.apache.commons.lang.StringUtils;

public class BeanUtil implements Util4Script {
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(BeanUtil.class);
	private static Map<Class, List<String>> writeListPropertyMap = new ConcurrentHashMap();

	public static Class<?> getFieldType(Class clazz, String property) {
		try {
			Wrapper e = Wrapper.getWrapper(clazz);
			Class v = e.getPropertyType(property);
			return v;
		} catch (Exception arg3) {
			dbLogger.warn(arg3, 2);
			return null;
		}
	}

	public static Map getBeanFieldMap(Object bean, String... otherProps) {
		Map result = getBeanMap(bean, true, false, true);
		if (otherProps != null && otherProps.length > 0) {
			String[] arg2 = otherProps;
			int arg3 = otherProps.length;

			for (int arg4 = 0; arg4 < arg3; ++arg4) {
				String prop = arg2[arg4];
				Object v = get(bean, prop);
				result.put(prop, v);
			}
		}

		return result;
	}

	public static List getBeanFieldMapList(Collection beanList, String... otherProps) {
		ArrayList result = new ArrayList();
		if (beanList == null) {
			return result;
		} else {
			Iterator arg2 = beanList.iterator();

			while (true) {
				while (arg2.hasNext()) {
					Object bean = arg2.next();
					if (bean != null && !isSimpleProperty(bean.getClass())) {
						result.add(getBeanFieldMap(bean, otherProps));
					} else {
						result.add(bean);
					}
				}

				return result;
			}
		}
	}

	public static void copyProperties(Object dest, Object orig) {
		try {
			PropertyUtils.copyProperties(dest, orig);
		} catch (Exception arg2) {
			;
		}

	}

	public static <T> T getInstance(Class<T> clazz) {
		return Wrapper.getWrapper(clazz).gainNewInstance();
	}

	public static List<String> getWriteListPropertyNames(Class clazz) {
		List result = (List) writeListPropertyMap.get(clazz);
		if (result != null) {
			return result;
		} else {
			Wrapper wrapper = Wrapper.getWrapper(clazz);
			String[] pns = wrapper.getWritePropertyNames();
			ArrayList arg7 = new ArrayList(2);
			String[] arg3 = pns;
			int arg4 = pns.length;

			for (int arg5 = 0; arg5 < arg4; ++arg5) {
				String pn = arg3[arg5];
				if (wrapper.getPropertyType(pn) == List.class) {
					arg7.add(pn);
				}
			}

			writeListPropertyMap.put(clazz, arg7);
			return arg7;
		}
	}

	public static final boolean isEmptyContainer(Object container) {
		return container == null ? true
				: (container.getClass().isArray() ? Array.getLength(container) == 0
						: (container instanceof Collection ? ((Collection) container).size() == 0
								: (container instanceof Map ? ((Map) container).size() == 0 : false)));
	}

	public static Object get(Object bean, String property) {
		if (bean == null) {
			return null;
		} else if (bean instanceof Map) {
			return ((Map) bean).get(property);
		} else {
			try {
				Wrapper e = Wrapper.getWrapper(bean.getClass());
				return e.getPropertyValue(bean, property);
			} catch (Exception arg2) {
				dbLogger.warn(arg2, 2);
				return null;
			}
		}
	}

	public static void set(Object object, String property, Object newproperty) {
		try {
			PropertyUtils.setProperty(object, property, newproperty);
		} catch (IllegalAccessException arg3) {
			;
		} catch (InvocationTargetException arg4) {
			;
		} catch (Exception arg5) {
			;
		}

	}

	public static List<Long> getNotNullId(List<Long> idList) {
		ArrayList result = new ArrayList();
		if (idList != null && !idList.isEmpty()) {
			Iterator arg1 = idList.iterator();

			while (arg1.hasNext()) {
				Long id = (Long) arg1.next();
				if (id != null) {
					result.add(id);
				}
			}

			return result;
		} else {
			return result;
		}
	}

	public static <T> Map beanListToMap(Collection<T> beanList, String keyproperty, String valueproperty,
			boolean ignoreNull) {
		HashMap result = new HashMap();
		if (beanList == null) {
			return result;
		} else {
			Iterator arg4 = beanList.iterator();

			while (arg4.hasNext()) {
				Object bean = arg4.next();

				try {
					Object key = get(bean, keyproperty);
					Object value = get(bean, valueproperty);
					if (key != null && (value != null || !ignoreNull)) {
						result.put(key, value);
					}
				} catch (Exception arg8) {
					;
				}
			}

			return result;
		}
	}

	public static Map groupBeanList(Collection beanList, String property) {
		return groupBeanList(beanList, property, (Object) null);
	}

	public static Map groupBeanList(Collection beanList, String property, Object nullKey) {
		LinkedHashMap result = new LinkedHashMap();
		Iterator arg3 = beanList.iterator();

		while (arg3.hasNext()) {
			Object bean = arg3.next();

			try {
				Object keyvalue = get(bean, property);
				if (keyvalue == null) {
					keyvalue = nullKey;
				}

				if (keyvalue != null) {
					Object tmpList = (List) result.get(keyvalue);
					if (tmpList == null) {
						tmpList = new ArrayList();
						result.put(keyvalue, tmpList);
					}

					((List) tmpList).add(bean);
				}
			} catch (Exception arg7) {
				;
			}
		}

		return result;
	}

	public static Bag groupCountBeanList(Collection beanList, String property, Object nullKey) {
		HashBag bag = new HashBag();
		Iterator arg3 = beanList.iterator();

		while (arg3.hasNext()) {
			Object bean = arg3.next();

			try {
				Object keyvalue = get(bean, property);
				if (keyvalue == null) {
					keyvalue = nullKey;
				}

				if (keyvalue != null) {
					bag.add(keyvalue);
				}
			} catch (Exception arg6) {
				;
			}
		}

		return bag;
	}

	public static Map beanListToMap(Collection beanList, String keyproperty) {
		HashMap result = new HashMap();
		if (beanList == null) {
			return result;
		} else {
			Iterator arg2 = beanList.iterator();

			while (arg2.hasNext()) {
				Object bean = arg2.next();

				try {
					Object key = get(bean, keyproperty);
					if (key != null) {
						result.put(key, bean);
					}
				} catch (Exception arg5) {
					;
				}
			}

			return result;
		}
	}

	public static List<Long> getIdList(String idListStr, String spliter) {
		ArrayList result = new ArrayList();
		if (StringUtils.isBlank(idListStr)) {
			return result;
		} else {
			String[] idList = idListStr.split(spliter);
			String[] arg3 = idList;
			int arg4 = idList.length;

			for (int arg5 = 0; arg5 < arg4; ++arg5) {
				String idStr = arg3[arg5];

				try {
					long id = Long.parseLong(idStr.trim());
					result.add(Long.valueOf(id));
				} catch (Exception arg9) {
					;
				}
			}

			return result;
		}
	}

	public static List<Integer> getIntgerList(String idListStr, String spliter) {
		ArrayList result = new ArrayList();
		if (StringUtils.isBlank(idListStr)) {
			return result;
		} else {
			String[] idList = idListStr.split(spliter);
			String[] arg3 = idList;
			int arg4 = idList.length;

			for (int arg5 = 0; arg5 < arg4; ++arg5) {
				String idStr = arg3[arg5];

				try {
					int id = Integer.parseInt(idStr.trim());
					result.add(Integer.valueOf(id));
				} catch (Exception arg8) {
					;
				}
			}

			return result;
		}
	}

	public static <T> List<T> getBeanPropertyList(Collection beanList, Class<T> clazz, String propertyname,
			boolean unique) {
		return getBeanPropertyList(beanList, propertyname, unique);
	}

	public static <T> List<T> getBeanPropertyList(Collection beanList, String propertyname, boolean unique) {
		if (beanList == null) {
			return new ArrayList(0);
		} else {
			Object result = null;
			if (unique) {
				result = new LinkedHashSet(beanList.size());
			} else {
				result = new ArrayList(beanList.size());
			}

			Iterator arg3 = beanList.iterator();

			while (arg3.hasNext()) {
				Object bean = arg3.next();

				try {
					Object pv = get(bean, propertyname);
					if (pv != null) {
						((Collection) result).add(pv);
					}
				} catch (Exception arg6) {
					;
				}
			}

			return (List) (unique ? new ArrayList((Collection) result) : (List) result);
		}
	}

	public static List<Map> getBeanMapList(Collection beanList, String... properties) {
		ArrayList result = new ArrayList();
		if (beanList == null) {
			return result;
		} else {
			Iterator it = beanList.iterator();
			Object bean = null;

			while (it.hasNext()) {
				bean = it.next();
				HashMap beanMap = new HashMap();
				boolean hasProperty = false;
				String[] arg6 = properties;
				int arg7 = properties.length;

				for (int arg8 = 0; arg8 < arg7; ++arg8) {
					String property = arg6[arg8];

					try {
						Object pv = null;
						String keyname = property;
						if (property.indexOf(".") > 0) {
							pv = PropertyUtils.getNestedProperty(bean, property);
							keyname = property.replace('.', '_');
						} else {
							pv = PropertyUtils.getProperty(bean, property);
						}

						if (pv != null) {
							hasProperty = true;
							beanMap.put(keyname, pv);
						}
					} catch (Exception arg12) {
						;
					}
				}

				if (hasProperty) {
					result.add(beanMap);
				}
			}

			return result;
		}
	}

	public static Map getBeanMap(Object bean) {
		return getBeanMap(bean, true);
	}

	public static Map getBeanMap(Object bean, boolean nested) {
		return getBeanMap(bean, nested, false);
	}

	public static Map<String, Object> getBeanMap(Object bean, boolean nested, boolean ignoreNull) {
		return getBeanMap(bean, nested, ignoreNull, false);
	}

	public static Map<String, Object> getBeanMap(Object bean, boolean nested, boolean ignoreNull, boolean onlyFields) {
		if (bean == null) {
			return null;
		} else {
			Assert.isTrue(!isSimpleProperty(bean.getClass()), "bean can\'t be simple!");
			Object beanMap = null;

			try {
				if (bean instanceof Map) {
					beanMap = new LinkedHashMap((Map) bean);
				} else {
					beanMap = getBeanProperties(bean, onlyFields);
				}

				Object e = null;
				Iterator arg5 = (new ArrayList(((Map) beanMap).keySet())).iterator();

				while (arg5.hasNext()) {
					Object key = arg5.next();
					e = ((Map) beanMap).get(key);
					if (e == null) {
						if (ignoreNull) {
							((Map) beanMap).remove(key);
						}
					} else if (!isSimpleProperty(e.getClass())) {
						if (!nested) {
							((Map) beanMap).remove(key);
						} else if (e instanceof Collection) {
							((Map) beanMap).put(key, getBeanMapList((Collection) e, false));
						} else if (e.getClass().isArray()) {
							((Map) beanMap).put(key, getBeanMapList(Arrays.asList((Object[]) ((Object[]) e)), false));
						} else {
							((Map) beanMap).put(key, getBeanMap(e, false));
						}
					}
				}

				((Map) beanMap).remove("class");
				return (Map) beanMap;
			} catch (Exception arg7) {
				dbLogger.warn(arg7, 20);
				return null;
			}
		}
	}

	private static Map getBeanProperties(Object bean, boolean onlyFields) {
		Wrapper wrap = Wrapper.getWrapper(bean.getClass());
		LinkedHashMap result = new LinkedHashMap();
		String[] pns = wrap.getReadPropertyNames();
		if (onlyFields) {
			pns = wrap.getFieldPropertyNames();
		}

		String[] arg4 = pns;
		int arg5 = pns.length;

		for (int arg6 = 0; arg6 < arg5; ++arg6) {
			String pn = arg4[arg6];

			try {
				result.put(pn, wrap.getPropertyValue(bean, pn));
			} catch (Exception arg9) {
				dbLogger.warn(arg9, 2);
			}
		}

		return result;
	}

	public static Map getBeanMapWithKey(Object bean, String... propertyList) {
		return getBeanMapWithKey(bean, false, propertyList);
	}

	public static Map getBeanMapWithKey(Object bean, boolean nested, String... keys) {
		return getBeanMapWithKey(bean, nested, false, keys);
	}

	public static Map getBeanMapWithKey(Object bean, boolean nested, boolean ignoreNull, String... keys) {
		if (keys != null && keys.length != 0) {
			HashMap result = new HashMap();
			Object pv = null;
			String[] arg5 = keys;
			int arg6 = keys.length;

			for (int arg7 = 0; arg7 < arg6; ++arg7) {
				String key = arg5[arg7];
				pv = get(bean, key);
				if (pv == null) {
					if (!ignoreNull) {
						result.put(key, (Object) null);
					}
				} else if (!isSimpleProperty(pv.getClass())) {
					if (nested) {
						if (pv instanceof Collection) {
							result.put(key, getBeanMapList((Collection) pv, false));
						} else {
							result.put(key, getBeanMap(pv, false));
						}
					}
				} else {
					result.put(key, pv);
				}
			}

			return result;
		} else {
			return getBeanMap(bean, nested, ignoreNull);
		}
	}

	public static List getBeanMapList(Collection beanList, boolean nested) {
		return getBeanMapList2(beanList, nested, false);
	}

	public static List getBeanMapList2(Collection beanList, boolean nested, boolean onlyFields) {
		ArrayList result = new ArrayList();
		if (beanList == null) {
			return result;
		} else {
			Iterator arg3 = beanList.iterator();

			while (true) {
				while (arg3.hasNext()) {
					Object bean = arg3.next();
					if (bean != null && !isSimpleProperty(bean.getClass())) {
						result.add(getBeanMap(bean, nested, onlyFields));
					} else {
						result.add(bean);
					}
				}

				return result;
			}
		}
	}

	public static List<Map> getBeanMapList(Collection beanList, boolean nested, String... keys) {
		if (keys != null && keys.length != 0) {
			ArrayList result = new ArrayList();
			if (beanList == null) {
				return result;
			} else {
				Iterator arg3 = beanList.iterator();

				while (arg3.hasNext()) {
					Object bean = arg3.next();
					result.add(getBeanMapWithKey(bean, nested, keys));
				}

				return result;
			}
		} else {
			return getBeanMapList(beanList, nested);
		}
	}

	public static String buildString(Object bean, boolean nested) {
		if (bean == null) {
			return null;
		} else {
			Map map = getBeanMap(bean, nested, true);
			return buildString(map);
		}
	}

	private static String buildString(Map map) {
		StringBuilder result = new StringBuilder();
		Iterator arg1 = map.keySet().iterator();

		while (true) {
			while (arg1.hasNext()) {
				Object key = arg1.next();
				result.append("," + key + "=");
				if (map.get(key) instanceof Collection) {
					result.append("[");
					Collection vlist = (Collection) map.get(key);
					Iterator arg4 = vlist.iterator();

					while (arg4.hasNext()) {
						Object el = arg4.next();
						if (el != null) {
							if (isSimpleProperty(el.getClass())) {
								result.append(el);
							} else if (el instanceof Map) {
								result.append(buildString((Map) el));
							}

							result.append(",");
						}
					}

					if (vlist.size() > 0) {
						result.deleteCharAt(result.length() - 1);
					}

					result.append("]");
				} else if (map.get(key) instanceof Map) {
					result.append("{" + buildString((Map) map.get(key)) + "}");
				} else {
					result.append(map.get(key));
				}
			}

			if (result.length() > 0) {
				result.deleteCharAt(0);
			}

			return result.toString();
		}
	}

	public static Map getKeyValuePairMap(List beanList, String keyProperty, String valueProperty) {
		HashMap result = new HashMap();
		Iterator arg3 = beanList.iterator();

		while (arg3.hasNext()) {
			Object bean = arg3.next();

			try {
				Object keyvalue = PropertyUtils.getProperty(bean, keyProperty);
				if (keyvalue != null) {
					result.put(keyvalue, PropertyUtils.getProperty(bean, valueProperty));
				}
			} catch (Exception arg6) {
				;
			}
		}

		return result;
	}

	public static Map<Object, List> groupBeanProperty(List beanList, String keyname, String valuename) {
		HashMap result = new HashMap();
		Iterator arg3 = beanList.iterator();

		while (arg3.hasNext()) {
			Object bean = arg3.next();

			try {
				Object keyvalue = get(bean, keyname);
				if (keyvalue != null) {
					Object list = (List) result.get(keyvalue);
					if (list == null) {
						list = new ArrayList();
						result.put(keyvalue, list);
					}

					((List) list).add(get(bean, valuename));
				}
			} catch (Exception arg7) {
				;
			}
		}

		return result;
	}

	public static <T> List<T> getSubList(List<T> list, int from, int maxnum) {
		return list != null && list.size() > from
				? new ArrayList(list.subList(from, Math.min(from + maxnum, list.size()))) : new ArrayList();
	}

	public static <T> List<List<T>> partition(List<T> longList, int length) {
		ArrayList result = new ArrayList();
		if (longList != null && !longList.isEmpty()) {
			if (longList.size() <= length) {
				result.add(longList);
			} else {
				int groups = (longList.size() - 1) / length + 1;

				for (int i = 0; i < groups - 1; ++i) {
					result.add(new ArrayList(longList.subList(length * i, length * (i + 1))));
				}

				result.add(new ArrayList(longList.subList(length * (groups - 1), longList.size())));
			}

			return result;
		} else {
			return result;
		}
	}

	public static boolean isSimpleProperty(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		return isSimpleValueType(clazz) || clazz.isArray() && isSimpleValueType(clazz.getComponentType());
	}

	public static boolean isSimpleValueType(Class<?> clazz) {
		return ClassUtils.isPrimitiveOrWrapper(clazz) || clazz.isEnum() || CharSequence.class.isAssignableFrom(clazz)
				|| Number.class.isAssignableFrom(clazz) || Date.class.isAssignableFrom(clazz) || clazz.equals(URI.class)
				|| clazz.equals(URL.class) || clazz.equals(Locale.class) || clazz.equals(Class.class);
	}

	public static Map<String, String> getSimpleStringMap(Object bean) {
		if (bean == null) {
			return null;
		} else if (bean instanceof Map) {
			return toSimpleStringMap((Map) bean);
		} else if (isSimpleProperty(bean.getClass())) {
			throw new TraceErrorException("bean can\'t be simple!");
		} else {
			Map beanMap = null;

			try {
				beanMap = PropertyUtils.describe(bean);
				Object e = null;
				Iterator arg2 = (new ArrayList(beanMap.keySet())).iterator();

				while (arg2.hasNext()) {
					Object key = arg2.next();
					e = beanMap.get(key);
					if (e == null) {
						beanMap.remove(key);
					} else if (!isSimpleProperty(e.getClass())) {
						beanMap.remove(key);
					}
				}

				beanMap.remove("class");
				return toSimpleStringMap(beanMap);
			} catch (Exception arg4) {
				return null;
			}
		}
	}

	public static Map<String, String> getSimpleStringMapWithKey(Object bean, String... keys) {
		HashMap result = new HashMap();
		String[] arg3 = keys;
		int arg4 = keys.length;

		for (int arg5 = 0; arg5 < arg4; ++arg5) {
			String key = arg3[arg5];

			try {
				if (ValidateUtil.isVariable(key, 1, 50)) {
					Object pv = get(bean, key);
					if (pv != null && isSimpleProperty(pv.getClass())) {
						result.put(key, getStringValue(pv));
					}
				}
			} catch (Exception arg8) {
				;
			}
		}

		return result;
	}

	public static Map<String, String> toSimpleStringMap(Map map) {
		HashMap result = new HashMap();
		Iterator arg1 = map.keySet().iterator();

		while (arg1.hasNext()) {
			Object key = arg1.next();
			String tmpKey = getStringValue(key);
			result.put(tmpKey, getStringValue(map.get(key)));
		}

		return result;
	}

	public static String getStringValue(Object value) {
		return value == null ? null
				: (value instanceof String ? (String) value
						: (value instanceof Timestamp ? DateUtil.formatTimestamp((Timestamp) value)
								: (value instanceof Date ? DateUtil.formatDate((Date) value) : value.toString())));
	}

	public static String getIdentityHashCode(Object object) {
		return "0x" + Integer.toHexString(System.identityHashCode(object));
	}

	public static <K, V extends Comparable<V>> LinkedHashMap<K, V> sortMapByValue(Map<K, V> map, boolean asc) {
		List sortedEntries = sortEntriesByValue(map.entrySet(), asc);
		LinkedHashMap sortedMap = new LinkedHashMap(map.size());
		Iterator arg3 = sortedEntries.iterator();

		while (arg3.hasNext()) {
			Entry entry = (Entry) arg3.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	private static <K, V extends Comparable<V>> List<Entry<K, V>> sortEntriesByValue(Set<Entry<K, V>> entries,
			boolean asc) {
		ArrayList sortedEntries = new ArrayList(entries);
		Collections.sort(sortedEntries, new BeanUtil.ValueComparator(asc));
		return sortedEntries;
	}

	public static <T> List<T> getEmptyList(Class<T> clazz) {
		return new ArrayList();
	}

	private static class ValueComparator<V extends Comparable<V>> implements Comparator<Entry<?, V>> {
		private boolean asc;

		public ValueComparator(boolean asc) {
			this.asc = asc;
		}

		public int compare(Entry<?, V> entry1, Entry<?, V> entry2) {
			int result = ((Comparable) entry1.getValue()).compareTo(entry2.getValue());
			return this.asc ? result : -result;
		}
	}
}