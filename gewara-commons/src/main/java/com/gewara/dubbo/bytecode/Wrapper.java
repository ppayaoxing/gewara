/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.dubbo.bytecode;

import com.gewara.dubbo.bytecode.ClassGenerator;
import com.gewara.dubbo.bytecode.NoSuchMethodException;
import com.gewara.dubbo.bytecode.NoSuchPropertyException;
import com.gewara.serialize.ClassHelper;
import com.gewara.serialize.ReflectUtils;
import com.gewara.util.ClassUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;

public abstract class Wrapper {
	private static AtomicLong WRAPPER_CLASS_COUNTER = new AtomicLong(0L);
	private static final Map<Class<?>, Wrapper> WRAPPER_MAP = new ConcurrentHashMap();
	private static final String[] EMPTY_STRING_ARRAY = new String[0];
	private static final String[] OBJECT_METHODS = new String[] { "getClass", "hashCode", "toString", "equals" };
	private static final Wrapper OBJECT_WRAPPER = new Wrapper() {
		public String[] getMethodNames() {
			return Wrapper.OBJECT_METHODS;
		}

		public String[] getDeclaredMethodNames() {
			return Wrapper.OBJECT_METHODS;
		}

		public String[] getReadPropertyNames() {
			return Wrapper.EMPTY_STRING_ARRAY;
		}

		public String[] getFieldPropertyNames() {
			return Wrapper.EMPTY_STRING_ARRAY;
		}

		public String[] getWritePropertyNames() {
			return Wrapper.EMPTY_STRING_ARRAY;
		}

		public Class<?> getPropertyType(String pn) {
			return null;
		}

		public Object getPropertyValue(Object instance, String pn) throws NoSuchPropertyException {
			throw new NoSuchPropertyException("Property [" + pn + "] not found.");
		}

		public void setPropertyValue(Object instance, String pn, Object pv) throws NoSuchPropertyException {
			throw new NoSuchPropertyException("Property [" + pn + "] not found.");
		}

		public boolean hasProperty(String name) {
			return false;
		}

		public Object invokeMethod(Object instance, String mn, Class<?>[] types, Object[] args)
				throws NoSuchMethodException {
			if ("getClass".equals(mn)) {
				return instance.getClass();
			} else if ("hashCode".equals(mn)) {
				return Integer.valueOf(instance.hashCode());
			} else if ("toString".equals(mn)) {
				return instance.toString();
			} else if ("equals".equals(mn)) {
				if (args.length == 1) {
					return Boolean.valueOf(instance.equals(args[0]));
				} else {
					throw new IllegalArgumentException("Invoke method [" + mn + "] argument number error.");
				}
			} else {
				throw new NoSuchMethodException("Method [" + mn + "] not found.");
			}
		}

		public Object gainNewInstance() {
			throw new IllegalArgumentException("Object Not Support!");
		}
	};

	public static Wrapper getWrapper(Class<?> c) {
		while (ClassGenerator.isDynamicClass(c)) {
			c = c.getSuperclass();
		}

		if (c == Object.class) {
			return OBJECT_WRAPPER;
		} else {
			Wrapper ret = (Wrapper) WRAPPER_MAP.get(c);
			if (ret == null) {
				ret = makeWrapper(c);
				WRAPPER_MAP.put(c, ret);
			}

			return ret;
		}
	}

	public abstract String[] getReadPropertyNames();

	public abstract String[] getFieldPropertyNames();

	public abstract String[] getWritePropertyNames();

	public abstract Class<?> getPropertyType(String arg0);

	public abstract boolean hasProperty(String arg0);

	public abstract Object gainNewInstance();

	public abstract Object getPropertyValue(Object arg0, String arg1)
			throws NoSuchPropertyException, IllegalArgumentException;

	public abstract void setPropertyValue(Object arg0, String arg1, Object arg2)
			throws NoSuchPropertyException, IllegalArgumentException;

	public Object[] getPropertyValues(Object instance, String[] pns)
			throws NoSuchPropertyException, IllegalArgumentException {
		Object[] ret = new Object[pns.length];

		for (int i = 0; i < ret.length; ++i) {
			ret[i] = this.getPropertyValue(instance, pns[i]);
		}

		return ret;
	}

	public void setPropertyValues(Object instance, String[] pns, Object[] pvs)
			throws NoSuchPropertyException, IllegalArgumentException {
		if (pns.length != pvs.length) {
			throw new IllegalArgumentException("pns.length != pvs.length");
		} else {
			for (int i = 0; i < pns.length; ++i) {
				this.setPropertyValue(instance, pns[i], pvs[i]);
			}

		}
	}

	public abstract String[] getMethodNames();

	public abstract String[] getDeclaredMethodNames();

	public boolean hasMethod(String name) {
		String[] arg1 = this.getMethodNames();
		int arg2 = arg1.length;

		for (int arg3 = 0; arg3 < arg2; ++arg3) {
			String mn = arg1[arg3];
			if (mn.equals(name)) {
				return true;
			}
		}

		return false;
	}

	public abstract Object invokeMethod(Object arg0, String arg1, Class<?>[] arg2, Object[] arg3)
			throws NoSuchMethodException, InvocationTargetException;

	private static Wrapper makeWrapper(Class<?> c) {
		if (c.isPrimitive()) {
			throw new IllegalArgumentException("Can not create wrapper for primitive type: " + c);
		} else {
			String name = c.getName();
			ClassLoader cl = ClassHelper.getCallerClassLoader(Wrapper.class);
			StringBuilder c1 = new StringBuilder("public void setPropertyValue(Object o, String n, Object v){ ");
			StringBuilder c2 = new StringBuilder("public Object getPropertyValue(Object o, String n){ ");
			StringBuilder c3 = new StringBuilder(
					"public Object invokeMethod(Object o, String n, Class[] p, Object[] v) throws "
							+ InvocationTargetException.class.getName() + "{ ");
			c1.append(name).append(" w; try{ w = ((").append(name)
					.append(")$1); }catch(Throwable e){ throw new IllegalArgumentException(e); }");
			c2.append(name).append(" w; try{ w = ((").append(name)
					.append(")$1); }catch(Throwable e){ throw new IllegalArgumentException(e); }");
			c3.append(name).append(" w; try{ w = ((").append(name)
					.append(")$1); }catch(Throwable e){ throw new IllegalArgumentException(e); }");
			HashMap pts = new HashMap();
			LinkedHashMap ms = new LinkedHashMap();
			ArrayList mns = new ArrayList();
			ArrayList dmns = new ArrayList();
			ArrayList readPns = new ArrayList();
			ArrayList fieldPns = new ArrayList();
			ArrayList writePns = new ArrayList();
			Field[] tmpFields = c.getFields();
			int methods = tmpFields.length;

			for (int hasMethod = 0; hasMethod < methods; ++hasMethod) {
				Field matcher = tmpFields[hasMethod];
				String id = matcher.getName();
				Class entry = matcher.getType();
				if (!Modifier.isStatic(matcher.getModifiers()) && !Modifier.isTransient(matcher.getModifiers())) {
					c1.append(" if( $2.equals(\"").append(id).append("\") ){ w.").append(id).append("=")
							.append(arg(entry, "$3")).append("; return; }");
					c2.append(" if( $2.equals(\"").append(id).append("\") ){ return ($w)w.").append(id).append("; }");
					pts.put(id, entry);
					readPns.add(id);
					fieldPns.add(id);
					writePns.add(id);
				}
			}

			List arg33 = ReflectUtils.getBeanAllFieldNames(c);
			Method[] arg34 = c.getMethods();
			boolean arg35 = hasMethods(arg34);
			if (arg35) {
				c3.append(" try{");
			}

			Method[] arg36 = arg34;
			int arg38 = arg34.length;

			String newinstanceMethod;
			int e;
			for (int arg41 = 0; arg41 < arg38; ++arg41) {
				Method cc = arg36[arg41];
				if (cc.getDeclaringClass() != Object.class) {
					newinstanceMethod = cc.getName();
					c3.append(" if( \"").append(newinstanceMethod).append("\".equals( $2 ) ");
					e = cc.getParameterTypes().length;
					c3.append(" && ").append(" $3.length == ").append(e);
					boolean ix = false;
					Method[] l = arg34;
					int m = arg34.length;

					for (int arg24 = 0; arg24 < m; ++arg24) {
						Method m2 = l[arg24];
						if (cc != m2 && cc.getName().equals(m2.getName())) {
							ix = true;
							break;
						}
					}

					if (ix && e > 0) {
						for (int arg50 = 0; arg50 < e; ++arg50) {
							c3.append(" && ").append(" $3[").append(arg50).append("].getName().equals(\"")
									.append(cc.getParameterTypes()[arg50].getName()).append("\")");
						}
					}

					c3.append(" ) { ");
					if (cc.getReturnType() == Void.TYPE) {
						c3.append(" w.").append(newinstanceMethod).append('(')
								.append(args(cc.getParameterTypes(), "$4")).append(");").append(" return null;");
					} else {
						c3.append(" return ($w)w.").append(newinstanceMethod).append('(')
								.append(args(cc.getParameterTypes(), "$4")).append(");");
					}

					c3.append(" }");
					mns.add(newinstanceMethod);
					if (cc.getDeclaringClass() == c) {
						dmns.add(newinstanceMethod);
					}

					ms.put(ReflectUtils.getDesc(cc), cc);
				}
			}

			if (arg35) {
				c3.append(" } catch(Throwable e) { ");
				c3.append("     throw new java.lang.reflect.InvocationTargetException(e); ");
				c3.append(" }");
			}

			c3.append(" throw new " + NoSuchMethodException.class.getName()
					+ "(\"Not found method \\\"\"+$2+\"\\\" in class " + c.getName() + ".\"); }");
			Iterator arg39 = ms.entrySet().iterator();

			Class arg48;
			while (arg39.hasNext()) {
				Entry arg42 = (Entry) arg39.next();
				String arg43 = (String) arg42.getKey();
				Method arg45 = (Method) arg42.getValue();
				Matcher arg37;
				String arg47;
				if ((arg37 = ReflectUtils.GETTER_METHOD_DESC_PATTERN.matcher(arg43)).matches()) {
					arg47 = propertyName(arg37.group(1));
					c2.append(" if( $2.equals(\"").append(arg47).append("\") ){ return ($w)w.").append(arg45.getName())
							.append("(); }");
					pts.put(arg47, arg45.getReturnType());
					readPns.add(arg47);
					if (arg33.contains(arg47)) {
						fieldPns.add(arg47);
					}
				} else if ((arg37 = ReflectUtils.IS_METHOD_DESC_PATTERN.matcher(arg43)).matches()) {
					arg47 = propertyName(arg37.group(1));
					c2.append(" if( $2.equals(\"").append(arg47).append("\") ){ return ($w)w.").append(arg45.getName())
							.append("(); }");
					pts.put(arg47, arg45.getReturnType());
					readPns.add(arg47);
					if (arg33.contains(arg47)) {
						fieldPns.add(arg47);
					}
				} else if ((arg37 = ReflectUtils.SETTER_METHOD_DESC_PATTERN.matcher(arg43)).matches()) {
					arg48 = arg45.getParameterTypes()[0];
					String arg49 = propertyName(arg37.group(1));
					c1.append(" if( $2.equals(\"").append(arg49).append("\") ){ w.").append(arg45.getName()).append("(")
							.append(arg(arg48, "$3")).append("); return; }");
					pts.put(arg49, arg48);
					writePns.add(arg49);
				}
			}

			c1.append(" throw new " + NoSuchPropertyException.class.getName()
					+ "(\"Not found property \\\"\"+$2+\"\\\" filed or setter method in class " + c.getName()
					+ ".\"); }");
			c2.append(" throw new " + NoSuchPropertyException.class.getName()
					+ "(\"Not found property \\\"\"+$2+\"\\\" filed or setter method in class " + c.getName()
					+ ".\"); }");
			long arg40 = WRAPPER_CLASS_COUNTER.getAndIncrement();
			ClassGenerator arg44 = ClassGenerator.newInstance(cl);
			arg44.setClassName(
					(Modifier.isPublic(c.getModifiers()) ? Wrapper.class.getName() : c.getName() + "$sw") + arg40);
			arg44.setSuperClass(Wrapper.class);
			arg44.addDefaultConstructor();
			arg44.addField("public static String[] readPns;");
			arg44.addField("public static String[] fieldPns;");
			arg44.addField("public static String[] writePns;");
			arg44.addField("public static " + Map.class.getName() + " pts;");
			arg44.addField("public static String[] mns;");
			arg44.addField("public static String[] dmns;");
			int arg46 = 0;

			for (e = ms.size(); arg46 < e; ++arg46) {
				arg44.addField("public static Class[] mts" + arg46 + ";");
			}

			arg44.addMethod("public String[] getReadPropertyNames(){ return readPns; }");
			arg44.addMethod("public String[] getFieldPropertyNames(){ return fieldPns; }");
			arg44.addMethod("public String[] getWritePropertyNames(){ return writePns; }");
			arg44.addMethod("public boolean hasProperty(String n){ return pts.containsKey($1); }");
			arg44.addMethod("public Class getPropertyType(String n){ return (Class)pts.get($1); }");
			arg44.addMethod("public String[] getMethodNames(){ return mns; }");
			arg44.addMethod("public String[] getDeclaredMethodNames(){ return dmns; }");
			arg44.addMethod(c1.toString());
			arg44.addMethod(c2.toString());
			arg44.addMethod(c3.toString());
			newinstanceMethod = "public Object gainNewInstance(){return new " + name + "();}";
			if (!ClassUtils.hasConstructor(c, new Class[0])) {
				newinstanceMethod = "public Object gainNewInstance(){return null;}";
			}

			arg44.addMethod(newinstanceMethod);

			try {
				arg48 = arg44.toClass();
				arg48.getField("pts").set((Object) null, pts);
				arg48.getField("readPns").set((Object) null, readPns.toArray(new String[0]));
				arg48.getField("fieldPns").set((Object) null, fieldPns.toArray(new String[0]));
				arg48.getField("writePns").set((Object) null, writePns.toArray(new String[0]));
				arg48.getField("mns").set((Object) null, mns.toArray(new String[0]));
				arg48.getField("dmns").set((Object) null, dmns.toArray(new String[0]));
				int arg51 = 0;
				Iterator arg52 = ms.values().iterator();

				while (arg52.hasNext()) {
					Method arg54 = (Method) arg52.next();
					arg48.getField("mts" + arg51++).set((Object) null, arg54.getParameterTypes());
				}

				Wrapper arg53 = (Wrapper) arg48.newInstance();
				return arg53;
			} catch (RuntimeException arg30) {
				throw arg30;
			} catch (Throwable arg31) {
				throw new RuntimeException(arg31.getMessage(), arg31);
			} finally {
				arg44.release();
				ms.clear();
				mns.clear();
				dmns.clear();
			}
		}
	}

	private static String arg(Class<?> cl, String name) {
		if (cl.isPrimitive()) {
			if (cl == Boolean.TYPE) {
				return "((Boolean)" + name + ").booleanValue()";
			} else if (cl == Byte.TYPE) {
				return "((Byte)" + name + ").byteValue()";
			} else if (cl == Character.TYPE) {
				return "((Character)" + name + ").charValue()";
			} else if (cl == Double.TYPE) {
				return "((Number)" + name + ").doubleValue()";
			} else if (cl == Float.TYPE) {
				return "((Number)" + name + ").floatValue()";
			} else if (cl == Integer.TYPE) {
				return "((Number)" + name + ").intValue()";
			} else if (cl == Long.TYPE) {
				return "((Number)" + name + ").longValue()";
			} else if (cl == Short.TYPE) {
				return "((Number)" + name + ").shortValue()";
			} else {
				throw new RuntimeException("Unknown primitive type: " + cl.getName());
			}
		} else {
			return "(" + ReflectUtils.getName(cl) + ")" + name;
		}
	}

	private static String args(Class<?>[] cs, String name) {
		int len = cs.length;
		if (len == 0) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < len; ++i) {
				if (i > 0) {
					sb.append(',');
				}

				sb.append(arg(cs[i], name + "[" + i + "]"));
			}

			return sb.toString();
		}
	}

	private static String propertyName(String pn) {
		return pn.length() != 1 && !Character.isLowerCase(pn.charAt(1)) && !Character.isDigit(pn.charAt(1)) ? pn
				: Character.toLowerCase(pn.charAt(0)) + pn.substring(1);
	}

	private static boolean hasMethods(Method[] methods) {
		if (methods != null && methods.length != 0) {
			Method[] arg0 = methods;
			int arg1 = methods.length;

			for (int arg2 = 0; arg2 < arg1; ++arg2) {
				Method m = arg0[arg2];
				if (m.getDeclaringClass() != Object.class) {
					return true;
				}
			}

			return false;
		} else {
			return false;
		}
	}
}