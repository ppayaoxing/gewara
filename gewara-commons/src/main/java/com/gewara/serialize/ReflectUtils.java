/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.serialize;

import com.gewara.serialize.ClassHelper;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;
import javassist.NotFoundException;

public final class ReflectUtils {
	public static final char JVM_VOID = 'V';
	public static final char JVM_BOOLEAN = 'Z';
	public static final char JVM_BYTE = 'B';
	public static final char JVM_CHAR = 'C';
	public static final char JVM_DOUBLE = 'D';
	public static final char JVM_FLOAT = 'F';
	public static final char JVM_INT = 'I';
	public static final char JVM_LONG = 'J';
	public static final char JVM_SHORT = 'S';
	public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
	public static final String JAVA_IDENT_REGEX = "(?:[_$a-zA-Z][_$a-zA-Z0-9]*)";
	public static final String JAVA_NAME_REGEX = "(?:(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\.(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*)";
	public static final String CLASS_DESC = "(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;)";
	public static final String ARRAY_DESC = "(?:\\[+(?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;)))";
	public static final String DESC_REGEX = "(?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;)|(?:\\[+(?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;))))";
	public static final Pattern DESC_PATTERN = Pattern.compile(
			"(?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;)|(?:\\[+(?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;))))");
	public static final String METHOD_DESC_REGEX = "(?:((?:[_$a-zA-Z][_$a-zA-Z0-9]*))?\\(((?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;)|(?:\\[+(?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;))))*)\\)((?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;)|(?:\\[+(?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;)))))?)";
	public static final Pattern METHOD_DESC_PATTERN = Pattern.compile(
			"(?:((?:[_$a-zA-Z][_$a-zA-Z0-9]*))?\\(((?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;)|(?:\\[+(?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;))))*)\\)((?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;)|(?:\\[+(?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;)))))?)");
	public static final Pattern GETTER_METHOD_DESC_PATTERN = Pattern.compile(
			"get([A-Z_][_a-zA-Z0-9]*)\\(\\)((?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;)|(?:\\[+(?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;)))))");
	public static final Pattern SETTER_METHOD_DESC_PATTERN = Pattern.compile(
			"set([A-Z_][_a-zA-Z0-9]*)\\(((?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;)|(?:\\[+(?:(?:[VZBCDFIJS])|(?:L(?:[_$a-zA-Z][_$a-zA-Z0-9]*)(?:\\/(?:[_$a-zA-Z][_$a-zA-Z0-9]*))*;)))))\\)V");
	public static final Pattern IS_METHOD_DESC_PATTERN = Pattern.compile("(?:is)([A-Z][_a-zA-Z0-9]*)\\(\\)Z");
	private static final ConcurrentMap<String, Class<?>> DESC_CLASS_CACHE = new ConcurrentHashMap();
	private static final ConcurrentMap<String, Class<?>> NAME_CLASS_CACHE = new ConcurrentHashMap();
	private static final ConcurrentMap<String, Method> Signature_METHODS_CACHE = new ConcurrentHashMap();

	public static boolean isPrimitives(Class<?> cls) {
		return cls.isArray() ? isPrimitive(cls.getComponentType()) : isPrimitive(cls);
	}

	public static boolean isPrimitive(Class<?> cls) {
		return cls.isPrimitive() || cls == String.class || cls == Boolean.class || cls == Character.class
				|| Number.class.isAssignableFrom(cls) || Date.class.isAssignableFrom(cls);
	}

	public static Class<?> getBoxedClass(Class<?> c) {
		if (c == Integer.TYPE) {
			c = Integer.class;
		} else if (c == Boolean.TYPE) {
			c = Boolean.class;
		} else if (c == Long.TYPE) {
			c = Long.class;
		} else if (c == Float.TYPE) {
			c = Float.class;
		} else if (c == Double.TYPE) {
			c = Double.class;
		} else if (c == Character.TYPE) {
			c = Character.class;
		} else if (c == Byte.TYPE) {
			c = Byte.class;
		} else if (c == Short.TYPE) {
			c = Short.class;
		}

		return c;
	}

	public static boolean isCompatible(Class<?> c, Object o) {
		boolean pt = c.isPrimitive();
		if (o == null) {
			return !pt;
		} else {
			if (pt) {
				if (c == Integer.TYPE) {
					c = Integer.class;
				} else if (c == Boolean.TYPE) {
					c = Boolean.class;
				} else if (c == Long.TYPE) {
					c = Long.class;
				} else if (c == Float.TYPE) {
					c = Float.class;
				} else if (c == Double.TYPE) {
					c = Double.class;
				} else if (c == Character.TYPE) {
					c = Character.class;
				} else if (c == Byte.TYPE) {
					c = Byte.class;
				} else if (c == Short.TYPE) {
					c = Short.class;
				}
			}

			return c == o.getClass() ? true : c.isInstance(o);
		}
	}

	public static boolean isCompatible(Class<?>[] cs, Object[] os) {
		int len = cs.length;
		if (len != os.length) {
			return false;
		} else if (len == 0) {
			return true;
		} else {
			for (int i = 0; i < len; ++i) {
				if (!isCompatible(cs[i], os[i])) {
					return false;
				}
			}

			return true;
		}
	}

	public static String getCodeBase(Class<?> cls) {
		if (cls == null) {
			return null;
		} else {
			ProtectionDomain domain = cls.getProtectionDomain();
			if (domain == null) {
				return null;
			} else {
				CodeSource source = domain.getCodeSource();
				if (source == null) {
					return null;
				} else {
					URL location = source.getLocation();
					return location == null ? null : location.getFile();
				}
			}
		}
	}

	public static String getName(Class<?> c) {
		if (!c.isArray()) {
			return c.getName();
		} else {
			StringBuilder sb = new StringBuilder();

			do {
				sb.append("[]");
				c = c.getComponentType();
			} while (c.isArray());

			return c.getName() + sb.toString();
		}
	}

	public static Class<?> getGenericClass(Class<?> cls) {
		return getGenericClass(cls, 0);
	}

	public static Class<?> getGenericClass(Class<?> cls, int i) {
		try {
			ParameterizedType e = (ParameterizedType) cls.getGenericInterfaces()[0];
			Type genericClass = e.getActualTypeArguments()[i];
			return genericClass instanceof ParameterizedType ? (Class) ((ParameterizedType) genericClass).getRawType()
					: (genericClass instanceof GenericArrayType
							? (Class) ((GenericArrayType) genericClass).getGenericComponentType()
							: (Class) genericClass);
		} catch (Throwable arg3) {
			throw new IllegalArgumentException(cls.getName() + " generic type undefined!", arg3);
		}
	}

	public static String getName(Method m) {
		StringBuilder ret = new StringBuilder();
		ret.append(getName(m.getReturnType())).append(' ');
		ret.append(m.getName()).append('(');
		Class[] parameterTypes = m.getParameterTypes();

		for (int i = 0; i < parameterTypes.length; ++i) {
			if (i > 0) {
				ret.append(',');
			}

			ret.append(getName(parameterTypes[i]));
		}

		ret.append(')');
		return ret.toString();
	}

	public static String getSignature(String methodName, Class<?>[] parameterTypes) {
		StringBuilder sb = new StringBuilder(methodName);
		sb.append("(");
		if (parameterTypes != null && parameterTypes.length > 0) {
			boolean first = true;
			Class[] arg3 = parameterTypes;
			int arg4 = parameterTypes.length;

			for (int arg5 = 0; arg5 < arg4; ++arg5) {
				Class type = arg3[arg5];
				if (first) {
					first = false;
				} else {
					sb.append(",");
				}

				sb.append(type.getName());
			}
		}

		sb.append(")");
		return sb.toString();
	}

	public static String getName(Constructor<?> c) {
		StringBuilder ret = new StringBuilder("(");
		Class[] parameterTypes = c.getParameterTypes();

		for (int i = 0; i < parameterTypes.length; ++i) {
			if (i > 0) {
				ret.append(',');
			}

			ret.append(getName(parameterTypes[i]));
		}

		ret.append(')');
		return ret.toString();
	}

	public static String getDesc(Class<?> c) {
		StringBuilder ret;
		for (ret = new StringBuilder(); c.isArray(); c = c.getComponentType()) {
			ret.append('[');
		}

		if (c.isPrimitive()) {
			String t = c.getName();
			if ("void".equals(t)) {
				ret.append('V');
			} else if ("boolean".equals(t)) {
				ret.append('Z');
			} else if ("byte".equals(t)) {
				ret.append('B');
			} else if ("char".equals(t)) {
				ret.append('C');
			} else if ("double".equals(t)) {
				ret.append('D');
			} else if ("float".equals(t)) {
				ret.append('F');
			} else if ("int".equals(t)) {
				ret.append('I');
			} else if ("long".equals(t)) {
				ret.append('J');
			} else if ("short".equals(t)) {
				ret.append('S');
			}
		} else {
			ret.append('L');
			ret.append(c.getName().replace('.', '/'));
			ret.append(';');
		}

		return ret.toString();
	}

	public static String getDesc(Class<?>[] cs) {
		if (cs.length == 0) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder(64);
			Class[] arg1 = cs;
			int arg2 = cs.length;

			for (int arg3 = 0; arg3 < arg2; ++arg3) {
				Class c = arg1[arg3];
				sb.append(getDesc(c));
			}

			return sb.toString();
		}
	}

	public static String getDesc(Method m) {
		StringBuilder ret = (new StringBuilder(m.getName())).append('(');
		Class[] parameterTypes = m.getParameterTypes();

		for (int i = 0; i < parameterTypes.length; ++i) {
			ret.append(getDesc(parameterTypes[i]));
		}

		ret.append(')').append(getDesc(m.getReturnType()));
		return ret.toString();
	}

	public static String getDesc(Constructor<?> c) {
		StringBuilder ret = new StringBuilder("(");
		Class[] parameterTypes = c.getParameterTypes();

		for (int i = 0; i < parameterTypes.length; ++i) {
			ret.append(getDesc(parameterTypes[i]));
		}

		ret.append(')').append('V');
		return ret.toString();
	}

	public static String getDescWithoutMethodName(Method m) {
		StringBuilder ret = new StringBuilder();
		ret.append('(');
		Class[] parameterTypes = m.getParameterTypes();

		for (int i = 0; i < parameterTypes.length; ++i) {
			ret.append(getDesc(parameterTypes[i]));
		}

		ret.append(')').append(getDesc(m.getReturnType()));
		return ret.toString();
	}

	public static String getDesc(CtClass c) throws NotFoundException {
		StringBuilder ret = new StringBuilder();
		if (c.isArray()) {
			ret.append('[');
			ret.append(getDesc(c.getComponentType()));
		} else if (c.isPrimitive()) {
			String t = c.getName();
			if ("void".equals(t)) {
				ret.append('V');
			} else if ("boolean".equals(t)) {
				ret.append('Z');
			} else if ("byte".equals(t)) {
				ret.append('B');
			} else if ("char".equals(t)) {
				ret.append('C');
			} else if ("double".equals(t)) {
				ret.append('D');
			} else if ("float".equals(t)) {
				ret.append('F');
			} else if ("int".equals(t)) {
				ret.append('I');
			} else if ("long".equals(t)) {
				ret.append('J');
			} else if ("short".equals(t)) {
				ret.append('S');
			}
		} else {
			ret.append('L');
			ret.append(c.getName().replace('.', '/'));
			ret.append(';');
		}

		return ret.toString();
	}

	public static String getDesc(CtMethod m) throws NotFoundException {
		StringBuilder ret = (new StringBuilder(m.getName())).append('(');
		CtClass[] parameterTypes = m.getParameterTypes();

		for (int i = 0; i < parameterTypes.length; ++i) {
			ret.append(getDesc(parameterTypes[i]));
		}

		ret.append(')').append(getDesc(m.getReturnType()));
		return ret.toString();
	}

	public static String getDesc(CtConstructor c) throws NotFoundException {
		StringBuilder ret = new StringBuilder("(");
		CtClass[] parameterTypes = c.getParameterTypes();

		for (int i = 0; i < parameterTypes.length; ++i) {
			ret.append(getDesc(parameterTypes[i]));
		}

		ret.append(')').append('V');
		return ret.toString();
	}

	public static String getDescWithoutMethodName(CtMethod m) throws NotFoundException {
		StringBuilder ret = new StringBuilder();
		ret.append('(');
		CtClass[] parameterTypes = m.getParameterTypes();

		for (int i = 0; i < parameterTypes.length; ++i) {
			ret.append(getDesc(parameterTypes[i]));
		}

		ret.append(')').append(getDesc(m.getReturnType()));
		return ret.toString();
	}

	public static String name2desc(String name) {
		StringBuilder sb = new StringBuilder();
		int c = 0;
		int index = name.indexOf(91);
		if (index > 0) {
			c = (name.length() - index) / 2;
			name = name.substring(0, index);
		}

		while (c-- > 0) {
			sb.append("[");
		}

		if ("void".equals(name)) {
			sb.append('V');
		} else if ("boolean".equals(name)) {
			sb.append('Z');
		} else if ("byte".equals(name)) {
			sb.append('B');
		} else if ("char".equals(name)) {
			sb.append('C');
		} else if ("double".equals(name)) {
			sb.append('D');
		} else if ("float".equals(name)) {
			sb.append('F');
		} else if ("int".equals(name)) {
			sb.append('I');
		} else if ("long".equals(name)) {
			sb.append('J');
		} else if ("short".equals(name)) {
			sb.append('S');
		} else {
			sb.append('L').append(name.replace('.', '/')).append(';');
		}

		return sb.toString();
	}

	public static String desc2name(String desc) {
		StringBuilder sb = new StringBuilder();
		int c = desc.lastIndexOf(91) + 1;
		if (desc.length() == c + 1) {
			switch (desc.charAt(c)) {
			case 'B':
				sb.append("byte");
				break;
			case 'C':
				sb.append("char");
				break;
			case 'D':
				sb.append("double");
				break;
			case 'E':
			case 'G':
			case 'H':
			case 'K':
			case 'L':
			case 'M':
			case 'N':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
			case 'T':
			case 'U':
			case 'W':
			case 'X':
			case 'Y':
			default:
				throw new RuntimeException();
			case 'F':
				sb.append("float");
				break;
			case 'I':
				sb.append("int");
				break;
			case 'J':
				sb.append("long");
				break;
			case 'S':
				sb.append("short");
				break;
			case 'V':
				sb.append("void");
				break;
			case 'Z':
				sb.append("boolean");
			}
		} else {
			sb.append(desc.substring(c + 1, desc.length() - 1).replace('/', '.'));
		}

		while (c-- > 0) {
			sb.append("[]");
		}

		return sb.toString();
	}

	public static Class<?> forName(String name) {
		try {
			return name2class(name);
		} catch (ClassNotFoundException arg1) {
			throw new IllegalStateException("Not found class " + name + ", cause: " + arg1.getMessage(), arg1);
		}
	}

	public static Class<?> name2class(String name) throws ClassNotFoundException {
		return name2class(ClassHelper.getClassLoader(), name);
	}

	private static Class<?> name2class(ClassLoader cl, String name) throws ClassNotFoundException {
		int c = 0;
		int index = name.indexOf(91);
		if (index > 0) {
			c = (name.length() - index) / 2;
			name = name.substring(0, index);
		}

		if (c > 0) {
			StringBuilder clazz = new StringBuilder();

			while (c-- > 0) {
				clazz.append("[");
			}

			if ("void".equals(name)) {
				clazz.append('V');
			} else if ("boolean".equals(name)) {
				clazz.append('Z');
			} else if ("byte".equals(name)) {
				clazz.append('B');
			} else if ("char".equals(name)) {
				clazz.append('C');
			} else if ("double".equals(name)) {
				clazz.append('D');
			} else if ("float".equals(name)) {
				clazz.append('F');
			} else if ("int".equals(name)) {
				clazz.append('I');
			} else if ("long".equals(name)) {
				clazz.append('J');
			} else if ("short".equals(name)) {
				clazz.append('S');
			} else {
				clazz.append('L').append(name).append(';');
			}

			name = clazz.toString();
		} else {
			if ("void".equals(name)) {
				return Void.TYPE;
			}

			if ("boolean".equals(name)) {
				return Boolean.TYPE;
			}

			if ("byte".equals(name)) {
				return Byte.TYPE;
			}

			if ("char".equals(name)) {
				return Character.TYPE;
			}

			if ("double".equals(name)) {
				return Double.TYPE;
			}

			if ("float".equals(name)) {
				return Float.TYPE;
			}

			if ("int".equals(name)) {
				return Integer.TYPE;
			}

			if ("long".equals(name)) {
				return Long.TYPE;
			}

			if ("short".equals(name)) {
				return Short.TYPE;
			}
		}

		if (cl == null) {
			cl = ClassHelper.getClassLoader();
		}

		Class arg4 = (Class) NAME_CLASS_CACHE.get(name);
		if (arg4 == null) {
			arg4 = Class.forName(name, true, cl);
			NAME_CLASS_CACHE.put(name, arg4);
		}

		return arg4;
	}

	public static Class<?> desc2class(String desc) throws ClassNotFoundException {
		return desc2class(ClassHelper.getClassLoader(), desc);
	}

	private static Class<?> desc2class(ClassLoader cl, String desc) throws ClassNotFoundException {
		switch (desc.charAt(0)) {
		case 'B':
			return Byte.TYPE;
		case 'C':
			return Character.TYPE;
		case 'D':
			return Double.TYPE;
		case 'E':
		case 'G':
		case 'H':
		case 'K':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'T':
		case 'U':
		case 'W':
		case 'X':
		case 'Y':
		default:
			throw new ClassNotFoundException("Class not found: " + desc);
		case 'F':
			return Float.TYPE;
		case 'I':
			return Integer.TYPE;
		case 'J':
			return Long.TYPE;
		case 'L':
			desc = desc.substring(1, desc.length() - 1).replace('/', '.');
			break;
		case 'S':
			return Short.TYPE;
		case 'V':
			return Void.TYPE;
		case 'Z':
			return Boolean.TYPE;
		case '[':
			desc = desc.replace('/', '.');
		}

		if (cl == null) {
			cl = ClassHelper.getClassLoader();
		}

		Class clazz = (Class) DESC_CLASS_CACHE.get(desc);
		if (clazz == null) {
			clazz = Class.forName(desc, true, cl);
			DESC_CLASS_CACHE.put(desc, clazz);
		}

		return clazz;
	}

	public static Class<?>[] desc2classArray(String desc) throws ClassNotFoundException {
		Class[] ret = desc2classArray(ClassHelper.getClassLoader(), desc);
		return ret;
	}

	private static Class<?>[] desc2classArray(ClassLoader cl, String desc) throws ClassNotFoundException {
		if (desc.length() == 0) {
			return EMPTY_CLASS_ARRAY;
		} else {
			ArrayList cs = new ArrayList();
			Matcher m = DESC_PATTERN.matcher(desc);

			while (m.find()) {
				cs.add(desc2class(cl, m.group()));
			}

			return (Class[]) cs.toArray(EMPTY_CLASS_ARRAY);
		}
	}

	public static Method findMethodByMethodSignature(Class<?> clazz, String methodName, String[] parameterTypes)
			throws NoSuchMethodException, ClassNotFoundException {
		String signature = methodName;
		if (parameterTypes != null && parameterTypes.length > 0) {
			signature = methodName + join(parameterTypes);
		}

		Method method = (Method) Signature_METHODS_CACHE.get(signature);
		if (method != null) {
			return method;
		} else {
			if (parameterTypes == null) {
				ArrayList types = new ArrayList();
				Method[] i = clazz.getMethods();
				int arg6 = i.length;

				for (int arg7 = 0; arg7 < arg6; ++arg7) {
					Method m = i[arg7];
					if (m.getName().equals(methodName)) {
						types.add(m);
					}
				}

				if (types.isEmpty()) {
					throw new NoSuchMethodException("No such method " + methodName + " in class " + clazz);
				}

				if (types.size() > 1) {
					String arg10 = String.format("Not unique method for method name(%s) in class(%s), find %d methods.",
							new Object[] { methodName, clazz.getName(), Integer.valueOf(types.size()) });
					throw new IllegalStateException(arg10);
				}

				method = (Method) types.get(0);
			} else {
				Class[] arg9 = new Class[parameterTypes.length];

				for (int arg11 = 0; arg11 < parameterTypes.length; ++arg11) {
					arg9[arg11] = name2class(parameterTypes[arg11]);
				}

				method = clazz.getMethod(methodName, arg9);
			}

			Signature_METHODS_CACHE.put(signature, method);
			return method;
		}
	}

	private static String join(String[] array) {
		if (array.length == 0) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();
			String[] arg1 = array;
			int arg2 = array.length;

			for (int arg3 = 0; arg3 < arg2; ++arg3) {
				String s = arg1[arg3];
				sb.append(s);
			}

			return sb.toString();
		}
	}

	public static Method findMethodByMethodName(Class<?> clazz, String methodName)
			throws NoSuchMethodException, ClassNotFoundException {
		return findMethodByMethodSignature(clazz, methodName, (String[]) null);
	}

	public static Constructor<?> findConstructor(Class<?> clazz, Class<?> paramType) throws NoSuchMethodException {
		Constructor targetConstructor;
		try {
			targetConstructor = clazz.getConstructor(new Class[] { paramType });
		} catch (NoSuchMethodException arg8) {
			targetConstructor = null;
			Constructor[] constructors = clazz.getConstructors();
			Constructor[] arg4 = constructors;
			int arg5 = constructors.length;

			for (int arg6 = 0; arg6 < arg5; ++arg6) {
				Constructor constructor = arg4[arg6];
				if (Modifier.isPublic(constructor.getModifiers()) && constructor.getParameterTypes().length == 1
						&& constructor.getParameterTypes()[0].isAssignableFrom(paramType)) {
					targetConstructor = constructor;
					break;
				}
			}

			if (targetConstructor == null) {
				throw arg8;
			}
		}

		return targetConstructor;
	}

	public static boolean isInstance(Object obj, String interfaceClazzName) {
		for (Class clazz = obj.getClass(); clazz != null
				&& !clazz.equals(Object.class); clazz = clazz.getSuperclass()) {
			Class[] interfaces = clazz.getInterfaces();
			Class[] arg3 = interfaces;
			int arg4 = interfaces.length;

			for (int arg5 = 0; arg5 < arg4; ++arg5) {
				Class itf = arg3[arg5];
				if (itf.getName().equals(interfaceClazzName)) {
					return true;
				}
			}
		}

		return false;
	}

	public static Object getEmptyObject(Class<?> returnType) {
		return getEmptyObject(returnType, new HashMap(), 0);
	}

	private static Object getEmptyObject(Class<?> returnType, Map<Class<?>, Object> emptyInstances, int level) {
		if (level > 2) {
			return null;
		} else if (returnType == null) {
			return null;
		} else if (returnType != Boolean.TYPE && returnType != Boolean.class) {
			if (returnType != Character.TYPE && returnType != Character.class) {
				if (returnType != Byte.TYPE && returnType != Byte.class) {
					if (returnType != Short.TYPE && returnType != Short.class) {
						if (returnType != Integer.TYPE && returnType != Integer.class) {
							if (returnType != Long.TYPE && returnType != Long.class) {
								if (returnType != Float.TYPE && returnType != Float.class) {
									if (returnType != Double.TYPE && returnType != Double.class) {
										if (returnType.isArray()) {
											return Array.newInstance(returnType.getComponentType(), 0);
										} else if (returnType.isAssignableFrom(ArrayList.class)) {
											return new ArrayList(0);
										} else if (returnType.isAssignableFrom(HashSet.class)) {
											return new HashSet(0);
										} else if (returnType.isAssignableFrom(HashMap.class)) {
											return new HashMap(0);
										} else if (String.class.equals(returnType)) {
											return "";
										} else if (!returnType.isInterface()) {
											try {
												Object e = emptyInstances.get(returnType);
												if (e == null) {
													e = returnType.newInstance();
													emptyInstances.put(returnType, e);
												}

												for (Class cls = e.getClass(); cls != null
														&& cls != Object.class; cls = cls.getSuperclass()) {
													Field[] fields = cls.getDeclaredFields();
													Field[] arg5 = fields;
													int arg6 = fields.length;

													for (int arg7 = 0; arg7 < arg6; ++arg7) {
														Field field = arg5[arg7];
														Object property = getEmptyObject(field.getType(),
																emptyInstances, level + 1);
														if (property != null) {
															try {
																if (!field.isAccessible()) {
																	field.setAccessible(true);
																}

																field.set(e, property);
															} catch (Throwable arg11) {
																;
															}
														}
													}
												}

												return e;
											} catch (Throwable arg12) {
												return null;
											}
										} else {
											return null;
										}
									} else {
										return Double.valueOf(0.0D);
									}
								} else {
									return Float.valueOf(0.0F);
								}
							} else {
								return Long.valueOf(0L);
							}
						} else {
							return Integer.valueOf(0);
						}
					} else {
						return Short.valueOf(0);
					}
				} else {
					return Byte.valueOf(0);
				}
			} else {
				return Character.valueOf(' ');
			}
		} else {
			return Boolean.valueOf(false);
		}
	}

	public static boolean isBeanPropertyReadMethod(Method method) {
		return method != null && Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers())
				&& method.getReturnType() != Void.TYPE && method.getDeclaringClass() != Object.class
				&& method.getParameterTypes().length == 0
				&& (method.getName().startsWith("get") && method.getName().length() > 3
						|| method.getName().startsWith("is") && method.getName().length() > 2);
	}

	public static String getPropertyNameFromBeanReadMethod(Method method) {
		if (isBeanPropertyReadMethod(method)) {
			if (method.getName().startsWith("get")) {
				return method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
			}

			if (method.getName().startsWith("is")) {
				return method.getName().substring(2, 3).toLowerCase() + method.getName().substring(3);
			}
		}

		return null;
	}

	public static boolean isBeanPropertyWriteMethod(Method method) {
		return method != null && Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers())
				&& method.getDeclaringClass() != Object.class && method.getParameterTypes().length == 1
				&& method.getName().startsWith("set") && method.getName().length() > 3;
	}

	public static String getPropertyNameFromBeanWriteMethod(Method method) {
		return isBeanPropertyWriteMethod(method)
				? method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4) : null;
	}

	public static boolean isPublicInstanceField(Field field) {
		return Modifier.isPublic(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())
				&& !Modifier.isFinal(field.getModifiers()) && !field.isSynthetic();
	}

	public static Map<String, Field> getBeanPropertyFields(Class cl) {
		HashMap properties;
		for (properties = new HashMap(); cl != null; cl = cl.getSuperclass()) {
			Field[] fields = cl.getDeclaredFields();
			Field[] arg2 = fields;
			int arg3 = fields.length;

			for (int arg4 = 0; arg4 < arg3; ++arg4) {
				Field field = arg2[arg4];
				if (!Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
					field.setAccessible(true);
					properties.put(field.getName(), field);
				}
			}
		}

		return properties;
	}

	public static List<String> getBeanAllFieldNames(Class cl) {
		ArrayList result;
		for (result = new ArrayList(); cl != null; cl = cl.getSuperclass()) {
			Field[] fields = cl.getDeclaredFields();
			Field[] arg2 = fields;
			int arg3 = fields.length;

			for (int arg4 = 0; arg4 < arg3; ++arg4) {
				Field field = arg2[arg4];
				if (!Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
					result.add(field.getName());
				}
			}
		}

		return result;
	}

	public static Map<String, Method> getBeanPropertyReadMethods(Class cl) {
		HashMap properties;
		for (properties = new HashMap(); cl != null; cl = cl.getSuperclass()) {
			Method[] methods = cl.getDeclaredMethods();
			Method[] arg2 = methods;
			int arg3 = methods.length;

			for (int arg4 = 0; arg4 < arg3; ++arg4) {
				Method method = arg2[arg4];
				if (isBeanPropertyReadMethod(method)) {
					method.setAccessible(true);
					String property = getPropertyNameFromBeanReadMethod(method);
					properties.put(property, method);
				}
			}
		}

		return properties;
	}
}