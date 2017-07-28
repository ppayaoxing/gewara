/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.serialize;

import com.gewara.serialize.ReflectUtils;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CompatibleTypeUtils {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static Object compatibleTypeConvert(Object value, Class<?> type) {
		if (value != null && type != null && !type.isAssignableFrom(value.getClass())) {
			if (value instanceof String) {
				String arg15 = (String) value;
				if (!Character.TYPE.equals(type) && !Character.class.equals(type)) {
					if (type.isEnum()) {
						return Enum.valueOf(type, arg15);
					}

					if (type == BigInteger.class) {
						return new BigInteger(arg15);
					}

					if (type == BigDecimal.class) {
						return new BigDecimal(arg15);
					}

					if (type != Short.class && type != Short.TYPE) {
						if (type != Integer.class && type != Integer.TYPE) {
							if (type != Long.class && type != Long.TYPE) {
								if (type != Double.class && type != Double.TYPE) {
									if (type != Float.class && type != Float.TYPE) {
										if (type == Byte.class || type == Byte.TYPE) {
											return new Byte(arg15);
										}

										if (type == Boolean.class || type == Boolean.TYPE) {
											return new Boolean(arg15);
										}

										if (type == Date.class) {
											try {
												return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
														.parse((String) value);
											} catch (ParseException arg7) {
												throw new IllegalStateException("Failed to parse date " + value
														+ " by format " + "yyyy-MM-dd HH:mm:ss" + ", cause: "
														+ arg7.getMessage(), arg7);
											}
										}

										if (type == Class.class) {
											try {
												return ReflectUtils.name2class((String) value);
											} catch (ClassNotFoundException arg8) {
												throw new RuntimeException(arg8.getMessage(), arg8);
											}
										}

										return value;
									}

									return new Float(arg15);
								}

								return new Double(arg15);
							}

							return new Long(arg15);
						}

						return new Integer(arg15);
					}

					return new Short(arg15);
				}

				if (arg15.length() != 1) {
					throw new IllegalArgumentException(String.format(
							"CAN NOT convert String(%s) to char! when convert String to char, the String MUST only 1 char.",
							new Object[] { arg15 }));
				}

				return Character.valueOf(arg15.charAt(0));
			} else if (value instanceof Number) {
				Number arg13 = (Number) value;
				if (type != Byte.TYPE && type != Byte.class) {
					if (type != Short.TYPE && type != Short.class) {
						if (type != Integer.TYPE && type != Integer.class) {
							if (type != Long.TYPE && type != Long.class) {
								if (type != Float.TYPE && type != Float.class) {
									if (type == Double.TYPE || type == Double.class) {
										return Double.valueOf(arg13.doubleValue());
									}

									if (type == BigInteger.class) {
										return BigInteger.valueOf(arg13.longValue());
									}

									if (type == BigDecimal.class) {
										return BigDecimal.valueOf(arg13.doubleValue());
									}

									if (type == Date.class) {
										return new Date(arg13.longValue());
									}

									return value;
								}

								return Float.valueOf(arg13.floatValue());
							}

							return Long.valueOf(arg13.longValue());
						}

						return Integer.valueOf(arg13.intValue());
					}

					return Short.valueOf(arg13.shortValue());
				}

				return Byte.valueOf(arg13.byteValue());
			} else {
				int arg12;
				if (value instanceof Collection) {
					Collection collection = (Collection) value;
					if (type.isArray()) {
						arg12 = collection.size();
						Object i = Array.newInstance(type.getComponentType(), arg12);
						int i1 = 0;
						Iterator arg5 = collection.iterator();

						while (arg5.hasNext()) {
							Object item = arg5.next();
							Array.set(i, i1++, item);
						}

						return i;
					}

					if (!type.isInterface()) {
						try {
							Collection length = (Collection) type.newInstance();
							length.addAll(collection);
							return length;
						} catch (Throwable arg10) {
							;
						}
					} else {
						if (type == List.class) {
							return new ArrayList(collection);
						}

						if (type == Set.class) {
							return new HashSet(collection);
						}
					}
				} else if (value.getClass().isArray() && Collection.class.isAssignableFrom(type)) {
					Object arg11;
					if (!type.isInterface()) {
						try {
							arg11 = (Collection) type.newInstance();
						} catch (Throwable arg9) {
							arg11 = new ArrayList();
						}
					} else if (type == Set.class) {
						arg11 = new HashSet();
					} else {
						arg11 = new ArrayList();
					}

					arg12 = Array.getLength(value);

					for (int arg14 = 0; arg14 < arg12; ++arg14) {
						((Collection) arg11).add(Array.get(value, arg14));
					}

					return arg11;
				}
			}

			return value;
		} else {
			return value;
		}
	}
}