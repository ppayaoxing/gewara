/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.helper;

import com.fasterxml.jackson.databind.util.ClassUtil;
import com.gewara.util.BeanUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.util.ReflectionUtils;

public class ClassMetaInfo {
	private static ConcurrentMap<Class, Map<String, Class>> writableListPropertyInfo = new ConcurrentHashMap();
	private static transient GewaLogger dbLogger = LoggerUtils.getLogger(ClassMetaInfo.class);

	public static Map<String, Class> getWritableListPropertyInfo(Class clazz) {
		Object result = (Map) writableListPropertyInfo.get(clazz);
		if (result == null) {
			result = new HashMap();
			List pnList = BeanUtil.getWriteListPropertyNames(clazz);
			if (!pnList.isEmpty()) {
				Iterator arg2 = pnList.iterator();

				while (arg2.hasNext()) {
					String pn = (String) arg2.next();
					Class genericClass = getListGenericClass(clazz, pn);
					if (genericClass != null && !BeanUtil.isSimpleProperty(genericClass)) {
						((Map) result).put(pn, genericClass);
					}
				}
			}

			writableListPropertyInfo.putIfAbsent(clazz, result);
		}

		return (Map) result;
	}

	private static Class getListGenericClass(Class clazz, String property) {
		try {
			Field e = ReflectionUtils.findField(clazz, property);
			Type genericFieldType = e.getGenericType();
			if (genericFieldType != null && genericFieldType instanceof ParameterizedType) {
				ParameterizedType aType = (ParameterizedType) genericFieldType;
				Type[] fieldArgTypes = aType.getActualTypeArguments();
				if (fieldArgTypes != null && fieldArgTypes.length == 1 && fieldArgTypes[0] instanceof Class) {
					Class cl = (Class) fieldArgTypes[0];
					if (ClassUtil.isConcrete(cl)) {
						return cl;
					}
				}
			}
		} catch (Exception arg6) {
			dbLogger.warn(arg6, 10);
		}

		return null;
	}
}