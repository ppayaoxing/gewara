/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.Assert;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public abstract class ClassUtils {
	public static final String ARRAY_SUFFIX = "[]";
	private static final String INTERNAL_ARRAY_PREFIX = "[";
	private static final String NON_PRIMITIVE_ARRAY_PREFIX = "[L";
	private static final char PACKAGE_SEPARATOR = '.';
	public static final String CLASS_FILE_SUFFIX = ".class";
	private static final Map<Class<?>, Class<?>> primitiveWrapperTypeMap = new HashMap(8);
	private static final Map<Class<?>, Class<?>> primitiveTypeToWrapperMap = new HashMap(8);
	private static final Map<String, Class<?>> primitiveTypeNameMap = new HashMap(32);
	private static final Map<String, Class<?>> commonClassCache = new HashMap(32);

	private static void registerCommonClasses(Class... commonClasses) {
		Class[] arg0 = commonClasses;
		int arg1 = commonClasses.length;

		for (int arg2 = 0; arg2 < arg1; ++arg2) {
			Class clazz = arg0[arg2];
			commonClassCache.put(clazz.getName(), clazz);
		}

	}

	public static ClassLoader getDefaultClassLoader() {
		ClassLoader cl = null;

		try {
			cl = Thread.currentThread().getContextClassLoader();
		} catch (Throwable arg1) {
			;
		}

		if (cl == null) {
			cl = ClassUtils.class.getClassLoader();
		}

		return cl;
	}

	public static ClassLoader overrideThreadContextClassLoader(ClassLoader classLoaderToUse) {
		Thread currentThread = Thread.currentThread();
		ClassLoader threadContextClassLoader = currentThread.getContextClassLoader();
		if (classLoaderToUse != null && !classLoaderToUse.equals(threadContextClassLoader)) {
			currentThread.setContextClassLoader(classLoaderToUse);
			return threadContextClassLoader;
		} else {
			return null;
		}
	}

	public static Class<?> forName(String name, ClassLoader classLoader) throws ClassNotFoundException, LinkageError {
		Assert.notNull(name, "Name must not be null");
		Class clazz = resolvePrimitiveClassName(name);
		if (clazz == null) {
			clazz = (Class) commonClassCache.get(name);
		}

		if (clazz != null) {
			return clazz;
		} else {
			Class ex;
			String classLoaderToUse1;
			if (name.endsWith("[]")) {
				classLoaderToUse1 = name.substring(0, name.length() - "[]".length());
				ex = forName(classLoaderToUse1, classLoader);
				return Array.newInstance(ex, 0).getClass();
			} else if (name.startsWith("[L") && name.endsWith(";")) {
				classLoaderToUse1 = name.substring("[L".length(), name.length() - 1);
				ex = forName(classLoaderToUse1, classLoader);
				return Array.newInstance(ex, 0).getClass();
			} else if (name.startsWith("[")) {
				classLoaderToUse1 = name.substring("[".length());
				ex = forName(classLoaderToUse1, classLoader);
				return Array.newInstance(ex, 0).getClass();
			} else {
				ClassLoader classLoaderToUse = classLoader;
				if (classLoader == null) {
					classLoaderToUse = getDefaultClassLoader();
				}

				try {
					return classLoaderToUse.loadClass(name);
				} catch (ClassNotFoundException arg8) {
					int lastDotIndex = name.lastIndexOf(46);
					if (lastDotIndex != -1) {
						String innerClassName = name.substring(0, lastDotIndex) + '$'
								+ name.substring(lastDotIndex + 1);

						try {
							return classLoaderToUse.loadClass(innerClassName);
						} catch (ClassNotFoundException arg7) {
							;
						}
					}

					throw arg8;
				}
			}
		}
	}

	public static Class<?> resolveClassName(String className, ClassLoader classLoader) throws IllegalArgumentException {
		try {
			return forName(className, classLoader);
		} catch (ClassNotFoundException arg2) {
			throw new IllegalArgumentException("Cannot find class [" + className + "]", arg2);
		} catch (LinkageError arg3) {
			throw new IllegalArgumentException(
					"Error loading class [" + className + "]: problem with class file or dependent class.", arg3);
		}
	}

	public static Class<?> resolvePrimitiveClassName(String name) {
		Class result = null;
		if (name != null && name.length() <= 8) {
			result = (Class) primitiveTypeNameMap.get(name);
		}

		return result;
	}

	public static boolean isPresent(String className, ClassLoader classLoader) {
		try {
			forName(className, classLoader);
			return true;
		} catch (Throwable arg2) {
			return false;
		}
	}

	public static Class<?> getUserClass(Object instance) {
		Assert.notNull(instance, "Instance must not be null");
		return getUserClass(instance.getClass());
	}

	public static boolean isCacheSafe(Class<?> clazz, ClassLoader classLoader) {
		Assert.notNull(clazz, "Class must not be null");
		ClassLoader target = clazz.getClassLoader();
		if (target == null) {
			return false;
		} else {
			ClassLoader cur = classLoader;
			if (classLoader == target) {
				return true;
			} else {
				do {
					if (cur == null) {
						return false;
					}

					cur = cur.getParent();
				} while (cur != target);

				return true;
			}
		}
	}

	public static String getClassFileName(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		String className = clazz.getName();
		int lastDotIndex = className.lastIndexOf(46);
		return className.substring(lastDotIndex + 1) + ".class";
	}

	public static String getPackageName(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		String className = clazz.getName();
		int lastDotIndex = className.lastIndexOf(46);
		return lastDotIndex != -1 ? className.substring(0, lastDotIndex) : "";
	}

	public static String getQualifiedName(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		return clazz.isArray() ? getQualifiedNameForArray(clazz) : clazz.getName();
	}

	private static String getQualifiedNameForArray(Class<?> clazz) {
		StringBuilder result = new StringBuilder();

		while (clazz.isArray()) {
			clazz = clazz.getComponentType();
			result.append("[]");
		}

		result.insert(0, clazz.getName());
		return result.toString();
	}

	public static String getQualifiedMethodName(Method method) {
		Assert.notNull(method, "Method must not be null");
		return method.getDeclaringClass().getName() + "." + method.getName();
	}

	public static String getDescriptiveType(Object value) {
		if (value == null) {
			return null;
		} else {
			Class clazz = value.getClass();
			if (Proxy.isProxyClass(clazz)) {
				StringBuilder result = new StringBuilder(clazz.getName());
				result.append(" implementing ");
				Class[] ifcs = clazz.getInterfaces();

				for (int i = 0; i < ifcs.length; ++i) {
					result.append(ifcs[i].getName());
					if (i < ifcs.length - 1) {
						result.append(',');
					}
				}

				return result.toString();
			} else {
				return clazz.isArray() ? getQualifiedNameForArray(clazz) : clazz.getName();
			}
		}
	}

	public static boolean matchesTypeName(Class<?> clazz, String typeName) {
		return typeName != null && (typeName.equals(clazz.getName()) || typeName.equals(clazz.getSimpleName())
				|| clazz.isArray() && typeName.equals(getQualifiedNameForArray(clazz)));
	}

	public static boolean hasConstructor(Class<?> clazz, Class... paramTypes) {
		return getConstructorIfAvailable(clazz, paramTypes) != null;
	}

	public static <T> Constructor<T> getConstructorIfAvailable(Class<T> clazz, Class... paramTypes) {
		Assert.notNull(clazz, "Class must not be null");

		try {
			return clazz.getConstructor(paramTypes);
		} catch (NoSuchMethodException arg2) {
			return null;
		}
	}

	public static boolean hasMethod(Class<?> clazz, String methodName, Class... paramTypes) {
		return getMethodIfAvailable(clazz, methodName, paramTypes) != null;
	}

	public static Method getMethod(Class<?> clazz, String methodName, Class... paramTypes) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(methodName, "Method name must not be null");

		try {
			return clazz.getMethod(methodName, paramTypes);
		} catch (NoSuchMethodException arg3) {
			throw new IllegalStateException("Expected method not found: " + arg3);
		}
	}

	public static Method getMethodIfAvailable(Class<?> clazz, String methodName, Class... paramTypes) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(methodName, "Method name must not be null");

		try {
			return clazz.getMethod(methodName, paramTypes);
		} catch (NoSuchMethodException arg3) {
			return null;
		}
	}

	public static int getMethodCountForName(Class<?> clazz, String methodName) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(methodName, "Method name must not be null");
		int count = 0;
		Method[] declaredMethods = clazz.getDeclaredMethods();
		Method[] ifcs = declaredMethods;
		int arg4 = declaredMethods.length;

		int arg5;
		for (arg5 = 0; arg5 < arg4; ++arg5) {
			Method method = ifcs[arg5];
			if (methodName.equals(method.getName())) {
				++count;
			}
		}

		Class[] arg8 = clazz.getInterfaces();
		Class[] arg9 = arg8;
		arg5 = arg8.length;

		for (int arg10 = 0; arg10 < arg5; ++arg10) {
			Class ifc = arg9[arg10];
			count += getMethodCountForName(ifc, methodName);
		}

		if (clazz.getSuperclass() != null) {
			count += getMethodCountForName(clazz.getSuperclass(), methodName);
		}

		return count;
	}

	public static boolean hasAtLeastOneMethodWithName(Class<?> clazz, String methodName) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(methodName, "Method name must not be null");
		Method[] declaredMethods = clazz.getDeclaredMethods();
		Method[] ifcs = declaredMethods;
		int arg3 = declaredMethods.length;

		int arg4;
		for (arg4 = 0; arg4 < arg3; ++arg4) {
			Method method = ifcs[arg4];
			if (method.getName().equals(methodName)) {
				return true;
			}
		}

		Class[] arg7 = clazz.getInterfaces();
		Class[] arg8 = arg7;
		arg4 = arg7.length;

		for (int arg9 = 0; arg9 < arg4; ++arg9) {
			Class ifc = arg8[arg9];
			if (hasAtLeastOneMethodWithName(ifc, methodName)) {
				return true;
			}
		}

		return clazz.getSuperclass() != null && hasAtLeastOneMethodWithName(clazz.getSuperclass(), methodName);
	}

	public static Method getStaticMethod(Class<?> clazz, String methodName, Class... args) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(methodName, "Method name must not be null");

		try {
			Method ex = clazz.getMethod(methodName, args);
			return Modifier.isStatic(ex.getModifiers()) ? ex : null;
		} catch (NoSuchMethodException arg3) {
			return null;
		}
	}

	public static boolean isPrimitiveWrapper(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		return primitiveWrapperTypeMap.containsKey(clazz);
	}

	public static boolean isPrimitiveOrWrapper(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		return clazz.isPrimitive() || isPrimitiveWrapper(clazz);
	}

	public static boolean isPrimitiveArray(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		return clazz.isArray() && clazz.getComponentType().isPrimitive();
	}

	public static boolean isPrimitiveWrapperArray(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		return clazz.isArray() && isPrimitiveWrapper(clazz.getComponentType());
	}

	public static Class<?> resolvePrimitiveIfNecessary(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");
		return clazz.isPrimitive() && clazz != Void.TYPE ? (Class) primitiveTypeToWrapperMap.get(clazz) : clazz;
	}

	public static boolean isAssignable(Class<?> lhsType, Class<?> rhsType) {
		Assert.notNull(lhsType, "Left-hand side type must not be null");
		Assert.notNull(rhsType, "Right-hand side type must not be null");
		if (lhsType.isAssignableFrom(rhsType)) {
			return true;
		} else {
			Class resolvedWrapper;
			if (lhsType.isPrimitive()) {
				resolvedWrapper = (Class) primitiveWrapperTypeMap.get(rhsType);
				if (resolvedWrapper != null && lhsType.equals(resolvedWrapper)) {
					return true;
				}
			} else {
				resolvedWrapper = (Class) primitiveTypeToWrapperMap.get(rhsType);
				if (resolvedWrapper != null && lhsType.isAssignableFrom(resolvedWrapper)) {
					return true;
				}
			}

			return false;
		}
	}

	public static boolean isAssignableValue(Class<?> type, Object value) {
		Assert.notNull(type, "Type must not be null");
		return value != null ? isAssignable(type, value.getClass()) : !type.isPrimitive();
	}

	public static String convertResourcePathToClassName(String resourcePath) {
		Assert.notNull(resourcePath, "Resource path must not be null");
		return resourcePath.replace('/', '.');
	}

	public static String convertClassNameToResourcePath(String className) {
		Assert.notNull(className, "Class name must not be null");
		return className.replace('.', '/');
	}

	public static String addResourcePathToPackagePath(Class<?> clazz, String resourceName) {
		Assert.notNull(resourceName, "Resource name must not be null");
		return !resourceName.startsWith("/") ? classPackageAsResourcePath(clazz) + "/" + resourceName
				: classPackageAsResourcePath(clazz) + resourceName;
	}

	public static String classPackageAsResourcePath(Class<?> clazz) {
		if (clazz == null) {
			return "";
		} else {
			String className = clazz.getName();
			int packageEndIndex = className.lastIndexOf(46);
			if (packageEndIndex == -1) {
				return "";
			} else {
				String packageName = className.substring(0, packageEndIndex);
				return packageName.replace('.', '/');
			}
		}
	}

	public static Class<?>[] toClassArray(Collection<Class<?>> collection) {
		return collection == null ? null : (Class[]) collection.toArray(new Class[collection.size()]);
	}

	public static Class[] getAllInterfaces(Object instance) {
		Assert.notNull(instance, "Instance must not be null");
		return getAllInterfacesForClass(instance.getClass());
	}

	public static Class<?>[] getAllInterfacesForClass(Class<?> clazz) {
		return getAllInterfacesForClass(clazz, (ClassLoader) null);
	}

	public static Class<?>[] getAllInterfacesForClass(Class<?> clazz, ClassLoader classLoader) {
		Set ifcs = getAllInterfacesForClassAsSet(clazz, classLoader);
		return (Class[]) ifcs.toArray(new Class[ifcs.size()]);
	}

	public static Set<Class> getAllInterfacesAsSet(Object instance) {
		Assert.notNull(instance, "Instance must not be null");
		return getAllInterfacesForClassAsSet(instance.getClass());
	}

	public static Set<Class> getAllInterfacesForClassAsSet(Class clazz) {
		return getAllInterfacesForClassAsSet(clazz, (ClassLoader) null);
	}

	public static Set<Class> getAllInterfacesForClassAsSet(Class clazz, ClassLoader classLoader) {
		Assert.notNull(clazz, "Class must not be null");
		if (clazz.isInterface() && isVisible(clazz, classLoader)) {
			return Collections.singleton(clazz);
		} else {
			LinkedHashSet interfaces;
			for (interfaces = new LinkedHashSet(); clazz != null; clazz = clazz.getSuperclass()) {
				Class[] ifcs = clazz.getInterfaces();
				Class[] arg3 = ifcs;
				int arg4 = ifcs.length;

				for (int arg5 = 0; arg5 < arg4; ++arg5) {
					Class ifc = arg3[arg5];
					interfaces.addAll(getAllInterfacesForClassAsSet(ifc, classLoader));
				}
			}

			return interfaces;
		}
	}

	public static boolean isVisible(Class<?> clazz, ClassLoader classLoader) {
		if (classLoader == null) {
			return true;
		} else {
			try {
				Class ex = classLoader.loadClass(clazz.getName());
				return clazz == ex;
			} catch (ClassNotFoundException arg2) {
				return false;
			}
		}
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
		Iterator primitiveTypes = primitiveWrapperTypeMap.entrySet().iterator();

		while (primitiveTypes.hasNext()) {
			Entry entry = (Entry) primitiveTypes.next();
			primitiveTypeToWrapperMap.put(entry.getValue(), entry.getKey());
			registerCommonClasses(new Class[] { (Class) entry.getKey() });
		}

		HashSet primitiveTypes1 = new HashSet(32);
		primitiveTypes1.addAll(primitiveWrapperTypeMap.values());
		primitiveTypes1.addAll(Arrays.asList(new Class[] { boolean[].class, byte[].class, char[].class, double[].class,
				float[].class, int[].class, long[].class, short[].class }));
		primitiveTypes1.add(Void.TYPE);
		Iterator entry1 = primitiveTypes1.iterator();

		while (entry1.hasNext()) {
			Class primitiveType = (Class) entry1.next();
			primitiveTypeNameMap.put(primitiveType.getName(), primitiveType);
		}

		registerCommonClasses(new Class[] { Boolean[].class, Byte[].class, Character[].class, Double[].class,
				Float[].class, Integer[].class, Long[].class, Short[].class });
		registerCommonClasses(new Class[] { Number.class, Number[].class, String.class, String[].class, Object.class,
				Object[].class, Class.class, Class[].class });
		registerCommonClasses(new Class[] { Throwable.class, Exception.class, RuntimeException.class, Error.class,
				StackTraceElement.class, StackTraceElement[].class });
	}
}