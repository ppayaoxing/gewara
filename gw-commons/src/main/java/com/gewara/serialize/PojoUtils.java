/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.serialize;

import com.gewara.serialize.ClassHelper;
import com.gewara.serialize.CompatibleTypeUtils;
import com.gewara.serialize.ReflectUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class PojoUtils {
	private static final ConcurrentMap<String, Method> NAME_METHODS_CACHE = new ConcurrentHashMap();
	private static final ConcurrentMap<Class<?>, ConcurrentMap<String, Field>> CLASS_FIELD_CACHE = new ConcurrentHashMap();

	public static Object[] generalize(Object[] objs) {
		Object[] dests = new Object[objs.length];

		for (int i = 0; i < objs.length; ++i) {
			dests[i] = generalize(objs[i]);
		}

		return dests;
	}

	public static Object[] realize(Object[] objs, Class<?>[] types) {
		if (objs.length != types.length) {
			throw new IllegalArgumentException("args.length != types.length");
		} else {
			Object[] dests = new Object[objs.length];

			for (int i = 0; i < objs.length; ++i) {
				dests[i] = realize(objs[i], types[i]);
			}

			return dests;
		}
	}

	public static Object[] realize(Object[] objs, Class<?>[] types, Type[] gtypes) {
		if (objs.length == types.length && objs.length == gtypes.length) {
			Object[] dests = new Object[objs.length];

			for (int i = 0; i < objs.length; ++i) {
				dests[i] = realize(objs[i], types[i], gtypes[i]);
			}

			return dests;
		} else {
			throw new IllegalArgumentException("args.length != types.length");
		}
	}

	public static Object generalize(Object pojo) {
		return generalize(pojo, new IdentityHashMap());
	}

	private static Object generalize(Object pojo, Map<Object, Object> history) {
		if (pojo == null) {
			return null;
		} else if (pojo instanceof Enum) {
			return ((Enum) pojo).name();
		} else {
			int arg18;
			if (pojo.getClass().isArray() && Enum.class.isAssignableFrom(pojo.getClass().getComponentType())) {
				int arg11 = Array.getLength(pojo);
				String[] arg15 = new String[arg11];

				for (arg18 = 0; arg18 < arg11; ++arg18) {
					arg15[arg18] = ((Enum) Array.get(pojo, arg18)).name();
				}

				return arg15;
			} else if (ReflectUtils.isPrimitives(pojo.getClass())) {
				return pojo;
			} else if (pojo instanceof Class) {
				return ((Class) pojo).getName();
			} else {
				Object o = history.get(pojo);
				if (o != null) {
					return o;
				} else {
					history.put(pojo, pojo);
					int dest1;
					if (pojo.getClass().isArray()) {
						int arg14 = Array.getLength(pojo);
						Object[] arg19 = new Object[arg14];
						history.put(pojo, arg19);

						for (dest1 = 0; dest1 < arg14; ++dest1) {
							Object arg26 = Array.get(pojo, dest1);
							arg19[dest1] = generalize(arg26, history);
						}

						return arg19;
					} else if (pojo instanceof Collection) {
						Collection arg13 = (Collection) pojo;
						arg18 = arg13.size();
						Object arg21 = pojo instanceof List ? new ArrayList(arg18) : new HashSet(arg18);
						history.put(pojo, arg21);
						Iterator arg24 = arg13.iterator();

						while (arg24.hasNext()) {
							Object arg25 = arg24.next();
							((Collection) arg21).add(generalize(arg25, history));
						}

						return arg21;
					} else if (pojo instanceof Map) {
						Map arg12 = (Map) pojo;
						Map arg17 = createMap(arg12);
						history.put(pojo, arg17);
						Iterator arg20 = arg12.entrySet().iterator();

						while (arg20.hasNext()) {
							Entry arg22 = (Entry) arg20.next();
							arg17.put(generalize(arg22.getKey(), history), generalize(arg22.getValue(), history));
						}

						return arg17;
					} else {
						HashMap map = new HashMap();
						history.put(pojo, map);
						map.put("class", pojo.getClass().getName());
						Method[] dest = pojo.getClass().getMethods();
						dest1 = dest.length;

						int obj;
						for (obj = 0; obj < dest1; ++obj) {
							Method field = dest[obj];
							if (ReflectUtils.isBeanPropertyReadMethod(field)) {
								try {
									map.put(ReflectUtils.getPropertyNameFromBeanReadMethod(field),
											generalize(field.invoke(pojo, new Object[0]), history));
								} catch (Exception arg9) {
									throw new RuntimeException(arg9.getMessage(), arg9);
								}
							}
						}

						Field[] arg16 = pojo.getClass().getFields();
						dest1 = arg16.length;

						for (obj = 0; obj < dest1; ++obj) {
							Field arg23 = arg16[obj];
							if (ReflectUtils.isPublicInstanceField(arg23)) {
								try {
									Object e = arg23.get(pojo);
									if (history.containsKey(pojo)) {
										Object pojoGenerilizedValue = history.get(pojo);
										if (pojoGenerilizedValue instanceof Map
												&& ((Map) pojoGenerilizedValue).containsKey(arg23.getName())) {
											continue;
										}
									}

									if (e != null) {
										map.put(arg23.getName(), generalize(e, history));
									}
								} catch (Exception arg10) {
									throw new RuntimeException(arg10.getMessage(), arg10);
								}
							}
						}

						return map;
					}
				}
			}
		}
	}

	public static Object realize(Object pojo, Class<?> type) {
		return realize0(pojo, type, (Type) null, new IdentityHashMap());
	}

	public static Object realize(Object pojo, Class<?> type, Type genericType) {
		return realize0(pojo, type, genericType, new IdentityHashMap());
	}

	private static Collection<Object> createCollection(Class<?> type, int len) {
		if (type.isAssignableFrom(ArrayList.class)) {
			return new ArrayList(len);
		} else if (type.isAssignableFrom(HashSet.class)) {
			return new HashSet(len);
		} else {
			if (!type.isInterface() && !Modifier.isAbstract(type.getModifiers())) {
				try {
					return (Collection) type.newInstance();
				} catch (Exception arg2) {
					;
				}
			}

			return new ArrayList();
		}
	}

	private static Map createMap(Map src) {
		Class cl = src.getClass();
		Object result = null;
		if (HashMap.class == cl) {
			result = new HashMap();
		} else if (Hashtable.class == cl) {
			result = new Hashtable();
		} else if (IdentityHashMap.class == cl) {
			result = new IdentityHashMap();
		} else if (LinkedHashMap.class == cl) {
			result = new LinkedHashMap();
		} else if (Properties.class == cl) {
			result = new Properties();
		} else if (TreeMap.class == cl) {
			result = new TreeMap();
		} else {
			if (WeakHashMap.class == cl) {
				return new WeakHashMap();
			}

			if (ConcurrentHashMap.class == cl) {
				result = new ConcurrentHashMap();
			} else if (ConcurrentSkipListMap.class == cl) {
				result = new ConcurrentSkipListMap();
			} else {
				try {
					result = (Map) cl.newInstance();
				} catch (Exception arg4) {
					;
				}

				if (result == null) {
					try {
						Constructor constructor = cl.getConstructor(new Class[] { Map.class });
						result = (Map) constructor.newInstance(new Object[] { Collections.EMPTY_MAP });
					} catch (Exception arg3) {
						;
					}
				}
			}
		}

		if (result == null) {
			result = new HashMap();
		}

		return (Map) result;
	}

	private static Object realize0(Object pojo, Class<?> type, Type genericType, Map<Object, Object> history) {
		if (pojo == null) {
			return null;
		} else if (type != null && type.isEnum() && pojo.getClass() == String.class) {
			return Enum.valueOf(type, (String) pojo);
		} else if (ReflectUtils.isPrimitives(pojo.getClass()) && (type == null || !type.isArray()
				|| !type.getComponentType().isEnum() || pojo.getClass() != String[].class)) {
			return CompatibleTypeUtils.compatibleTypeConvert(pojo, type);
		} else {
			Object o = history.get(pojo);
			if (o != null) {
				return o;
			} else {
				history.put(pojo, pojo);
				Class arg21;
				Object arg23;
				int arg26;
				Collection arg27;
				Object arg32;
				Object arg34;
				if (pojo.getClass().isArray()) {
					int arg29;
					if (Collection.class.isAssignableFrom(type)) {
						arg21 = pojo.getClass().getComponentType();
						arg26 = Array.getLength(pojo);
						arg27 = createCollection(type, arg26);
						history.put(pojo, arg27);

						for (arg29 = 0; arg29 < arg26; ++arg29) {
							arg34 = Array.get(pojo, arg29);
							arg32 = realize0(arg34, arg21, (Type) null, history);
							arg27.add(arg32);
						}

						return arg27;
					} else {
						arg21 = type != null && type.isArray() ? type.getComponentType()
								: pojo.getClass().getComponentType();
						arg26 = Array.getLength(pojo);
						arg23 = Array.newInstance(arg21, arg26);
						history.put(pojo, arg23);

						for (arg29 = 0; arg29 < arg26; ++arg29) {
							arg34 = Array.get(pojo, arg29);
							arg32 = realize0(arg34, arg21, (Type) null, history);
							Array.set(arg23, arg29, arg32);
						}

						return arg23;
					}
				} else {
					Iterator message;
					Type key;
					Object arg28;
					Object arg38;
					if (pojo instanceof Collection) {
						if (!type.isArray()) {
							Collection arg22 = (Collection) pojo;
							arg26 = arg22.size();
							arg27 = createCollection(type, arg26);
							history.put(pojo, arg27);
							message = arg22.iterator();

							while (message.hasNext()) {
								arg34 = message.next();
								key = getGenericClassByIndex(genericType, 0);
								Class arg37 = arg34.getClass();
								if (key instanceof Class) {
									arg37 = (Class) key;
								}

								arg38 = realize0(arg34, arg37, key, history);
								arg27.add(arg38);
							}

							return arg27;
						} else {
							arg21 = type.getComponentType();
							Collection arg24 = (Collection) pojo;
							int arg25 = arg24.size();
							arg28 = Array.newInstance(arg21, arg25);
							history.put(pojo, arg28);
							int arg31 = 0;

							for (Iterator arg33 = arg24.iterator(); arg33.hasNext(); ++arg31) {
								Object arg36 = arg33.next();
								arg38 = realize0(arg36, arg21, (Type) null, history);
								Array.set(arg28, arg31, arg38);
							}

							return arg28;
						}
					} else if (pojo instanceof Map && type != null) {
						Object className = ((Map) pojo).get("class");
						if (className instanceof String) {
							try {
								type = ClassHelper.forName((String) className);
							} catch (ClassNotFoundException arg20) {
								;
							}
						}

						Map map;
						if (!type.isInterface() && !type.isAssignableFrom(pojo.getClass())) {
							try {
								map = (Map) type.newInstance();
							} catch (Exception arg19) {
								map = (Map) pojo;
							}
						} else {
							map = (Map) pojo;
						}

						Entry filed;
						if (!Map.class.isAssignableFrom(type) && type != Object.class) {
							if (type.isInterface()) {
								arg23 = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
										new Class[] { type }, new PojoUtils.PojoInvocationHandler(map));
								history.put(pojo, arg23);
								return arg23;
							} else {
								arg23 = newInstance(type);
								history.put(pojo, arg23);
								message = map.entrySet().iterator();

								while (message.hasNext()) {
									filed = (Entry) message.next();
									arg32 = filed.getKey();
									if (arg32 instanceof String) {
										String arg35 = (String) arg32;
										arg38 = filed.getValue();
										if (arg38 != null) {
											Method arg39 = getSetterMethod(arg23.getClass(), arg35, arg38.getClass());
											Field arg40 = getField(arg23.getClass(), arg35);
											if (arg39 != null) {
												if (!arg39.isAccessible()) {
													arg39.setAccessible(true);
												}

												Type arg41 = arg39.getGenericParameterTypes()[0];
												arg38 = realize0(arg38, arg39.getParameterTypes()[0], arg41, history);

												try {
													arg39.invoke(arg23, new Object[] { arg38 });
												} catch (Exception arg18) {
													arg18.printStackTrace();
													throw new RuntimeException("Failed to set pojo "
															+ arg23.getClass().getSimpleName() + " property " + arg35
															+ " value " + arg38 + "(" + arg38.getClass() + "), cause: "
															+ arg18.getMessage(), arg18);
												}
											} else if (arg40 != null) {
												arg38 = realize0(arg38, arg40.getType(), arg40.getGenericType(),
														history);

												try {
													arg40.set(arg23, arg38);
												} catch (IllegalAccessException arg17) {
													throw new RuntimeException((new StringBuilder(32))
															.append("Failed to set filed ").append(arg35)
															.append(" of pojo ").append(arg23.getClass().getName())
															.append(" : ").append(arg17.getMessage()).toString(),
															arg17);
												}
											}
										}
									}
								}

								if (arg23 instanceof Throwable) {
									arg28 = map.get("message");
									if (arg28 instanceof String) {
										try {
											Field arg30 = Throwable.class.getDeclaredField("detailMessage");
											if (!arg30.isAccessible()) {
												arg30.setAccessible(true);
											}

											arg30.set(arg23, (String) arg28);
										} catch (Exception arg16) {
											;
										}
									}
								}

								return arg23;
							}
						} else {
							Map dest = createMap(map);
							history.put(pojo, dest);
							message = map.entrySet().iterator();

							while (message.hasNext()) {
								filed = (Entry) message.next();
								key = getGenericClassByIndex(genericType, 0);
								Type name = getGenericClassByIndex(genericType, 1);
								Class value;
								if (key instanceof Class) {
									value = (Class) key;
								} else {
									value = filed.getKey() == null ? null : filed.getKey().getClass();
								}

								Class method;
								if (name instanceof Class) {
									method = (Class) name;
								} else {
									method = filed.getValue() == null ? null : filed.getValue().getClass();
								}

								Object field = value == null ? filed.getKey()
										: realize0(filed.getKey(), value, key, history);
								Object e = method == null ? filed.getValue()
										: realize0(filed.getValue(), method, name, history);
								dest.put(field, e);
							}

							return dest;
						}
					} else {
						return pojo;
					}
				}
			}
		}
	}

	private static Type getGenericClassByIndex(Type genericType, int index) {
		Type clazz = null;
		if (genericType instanceof ParameterizedType) {
			ParameterizedType t = (ParameterizedType) genericType;
			Type[] types = t.getActualTypeArguments();
			clazz = types[index];
		}

		return clazz;
	}

	private static Object newInstance(Class<?> cls) {
		try {
			return cls.newInstance();
		} catch (Throwable arg10) {
			try {
				Constructor[] e = cls.getConstructors();
				if (e != null && e.length == 0) {
					throw new RuntimeException("Illegal constructor: " + cls.getName());
				} else {
					Constructor constructor = e[0];
					if (constructor.getParameterTypes().length > 0) {
						Constructor[] arg3 = e;
						int arg4 = e.length;

						for (int arg5 = 0; arg5 < arg4; ++arg5) {
							Constructor c = arg3[arg5];
							if (c.getParameterTypes().length < constructor.getParameterTypes().length) {
								constructor = c;
								if (c.getParameterTypes().length == 0) {
									break;
								}
							}
						}
					}

					return constructor.newInstance(new Object[constructor.getParameterTypes().length]);
				}
			} catch (InstantiationException arg7) {
				throw new RuntimeException(arg7.getMessage(), arg7);
			} catch (IllegalAccessException arg8) {
				throw new RuntimeException(arg8.getMessage(), arg8);
			} catch (InvocationTargetException arg9) {
				throw new RuntimeException(arg9.getMessage(), arg9);
			}
		}
	}

	private static Method getSetterMethod(Class<?> cls, String property, Class<?> valueCls) {
		String name = "set" + property.substring(0, 1).toUpperCase() + property.substring(1);
		Method method = (Method) NAME_METHODS_CACHE.get(cls.getName() + "." + name + "(" + valueCls.getName() + ")");
		if (method == null) {
			try {
				method = cls.getMethod(name, new Class[] { valueCls });
			} catch (NoSuchMethodException arg9) {
				Method[] arg5 = cls.getMethods();
				int arg6 = arg5.length;

				for (int arg7 = 0; arg7 < arg6; ++arg7) {
					Method m = arg5[arg7];
					if (ReflectUtils.isBeanPropertyWriteMethod(m) && m.getName().equals(name)) {
						method = m;
					}
				}
			}

			if (method != null) {
				NAME_METHODS_CACHE.put(cls.getName() + "." + name + "(" + valueCls.getName() + ")", method);
			}
		}

		return method;
	}

	private static Field getField(Class<?> cls, String fieldName) {
		Field result = null;
		if (CLASS_FIELD_CACHE.containsKey(cls) && ((ConcurrentMap) CLASS_FIELD_CACHE.get(cls)).containsKey(fieldName)) {
			return (Field) ((ConcurrentMap) CLASS_FIELD_CACHE.get(cls)).get(fieldName);
		} else {
			try {
				result = cls.getField(fieldName);
			} catch (NoSuchFieldException arg7) {
				Field[] arg3 = cls.getFields();
				int arg4 = arg3.length;

				for (int arg5 = 0; arg5 < arg4; ++arg5) {
					Field field = arg3[arg5];
					if (fieldName.equals(field.getName()) && ReflectUtils.isPublicInstanceField(field)) {
						result = field;
						break;
					}
				}
			}

			if (result != null) {
				ConcurrentMap fields = (ConcurrentMap) CLASS_FIELD_CACHE.get(cls);
				if (fields == null) {
					ConcurrentHashMap arg8 = new ConcurrentHashMap();
					CLASS_FIELD_CACHE.putIfAbsent(cls, arg8);
				}

				fields = (ConcurrentMap) CLASS_FIELD_CACHE.get(cls);
				fields.putIfAbsent(fieldName, result);
			}

			return result;
		}
	}

	public static boolean isPojo(Class<?> cls) {
		return !ReflectUtils.isPrimitives(cls) && !Collection.class.isAssignableFrom(cls)
				&& !Map.class.isAssignableFrom(cls);
	}

	private static class PojoInvocationHandler implements InvocationHandler {
		private Map<Object, Object> map;

		public PojoInvocationHandler(Map<Object, Object> map) {
			this.map = map;
		}

		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (method.getDeclaringClass() == Object.class) {
				return method.invoke(this.map, args);
			} else {
				String methodName = method.getName();
				Object value = null;
				if (methodName.length() > 3 && methodName.startsWith("get")) {
					value = this.map.get(methodName.substring(3, 4).toLowerCase() + methodName.substring(4));
				} else if (methodName.length() > 2 && methodName.startsWith("is")) {
					value = this.map.get(methodName.substring(2, 3).toLowerCase() + methodName.substring(3));
				} else {
					value = this.map.get(methodName.substring(0, 1).toLowerCase() + methodName.substring(1));
				}

				if (value instanceof Map && !Map.class.isAssignableFrom(method.getReturnType())) {
					value = PojoUtils.realize0((Map) value, method.getReturnType(), (Type) null, new IdentityHashMap());
				}

				return value;
			}
		}
	}
}