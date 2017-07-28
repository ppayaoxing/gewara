/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.serialize;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class ClassHelper {
	public static final String ARRAY_SUFFIX = "[]";
	private static final String INTERNAL_ARRAY_PREFIX = "[L";
	private static final Map<String, Class<?>> primitiveTypeNameMap = new HashMap(16);
	private static final Map<Class<?>, Class<?>> primitiveWrapperTypeMap = new HashMap(8);

	public static Class<?> forNameWithThreadContextClassLoader(String name) throws ClassNotFoundException {
		return forName(name, Thread.currentThread().getContextClassLoader());
	}

	public static Class<?> forNameWithCallerClassLoader(String name, Class<?> caller) throws ClassNotFoundException {
		return forName(name, caller.getClassLoader());
	}

	public static ClassLoader getCallerClassLoader(Class<?> caller) {
		return caller.getClassLoader();
	}

	public static ClassLoader getClassLoader(Class<?> cls) {
		ClassLoader cl = null;

		try {
			cl = Thread.currentThread().getContextClassLoader();
		} catch (Throwable arg2) {
			;
		}

		if (cl == null) {
			cl = cls.getClassLoader();
		}

		return cl;
	}

	public static ClassLoader getClassLoader() {
		return getClassLoader(ClassHelper.class);
	}

	public static Class<?> forName(String name) throws ClassNotFoundException {
		return forName(name, getClassLoader());
	}

	public static Class<?> forName(String name, ClassLoader classLoader) throws ClassNotFoundException, LinkageError {
		Class clazz = resolvePrimitiveClassName(name);
		if (clazz != null) {
			return clazz;
		} else if (name.endsWith("[]")) {
			String internalArrayMarker1 = name.substring(0, name.length() - "[]".length());
			Class classLoaderToUse2 = forName(internalArrayMarker1, classLoader);
			return Array.newInstance(classLoaderToUse2, 0).getClass();
		} else {
			int internalArrayMarker = name.indexOf("[L");
			if (internalArrayMarker != -1 && name.endsWith(";")) {
				String classLoaderToUse1 = null;
				if (internalArrayMarker == 0) {
					classLoaderToUse1 = name.substring("[L".length(), name.length() - 1);
				} else if (name.startsWith("[")) {
					classLoaderToUse1 = name.substring(1);
				}

				Class elementClass = forName(classLoaderToUse1, classLoader);
				return Array.newInstance(elementClass, 0).getClass();
			} else {
				ClassLoader classLoaderToUse = classLoader;
				if (classLoader == null) {
					classLoaderToUse = getClassLoader();
				}

				return classLoaderToUse.loadClass(name);
			}
		}
	}

	public static Class<?> resolvePrimitiveClassName(String name) {
		Class result = null;
		if (name != null && name.length() <= 8) {
			result = (Class) primitiveTypeNameMap.get(name);
		}

		return result;
	}

	public static String toShortString(Object obj) {
		return obj == null ? "null" : obj.getClass().getSimpleName() + "@" + System.identityHashCode(obj);
	}

	static {
		primitiveWrapperTypeMap.put(Boolean.class, Boolean.TYPE);
		primitiveWrapperTypeMap.put(Byte.class, Byte.TYPE);
		primitiveWrapperTypeMap.put(Character.class, Character.TYPE);
		primitiveWrapperTypeMap.put(Double.class, Double.TYPE);
		primitiveWrapperTypeMap.put(Float.class, Float.TYPE);
		primitiveWrapperTypeMap.put(Integer.class, Integer.TYPE);
		primitiveWrapperTypeMap.put(Long.class, Long.TYPE);
		primitiveWrapperTypeMap.put(Short.class, Short.TYPE);
		HashSet primitiveTypeNames = new HashSet(16);
		primitiveTypeNames.addAll(primitiveWrapperTypeMap.values());
		primitiveTypeNames.addAll(Arrays.asList(new Class[] { boolean[].class, byte[].class, char[].class,
				double[].class, float[].class, int[].class, long[].class, short[].class }));
		Iterator it = primitiveTypeNames.iterator();

		while (it.hasNext()) {
			Class primitiveClass = (Class) it.next();
			primitiveTypeNameMap.put(primitiveClass.getName(), primitiveClass);
		}

	}
}