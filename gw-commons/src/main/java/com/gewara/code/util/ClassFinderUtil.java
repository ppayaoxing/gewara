/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.code.util;

import com.fasterxml.jackson.databind.util.ClassUtil;
import com.gewara.code.util.ClassFilter;
import com.gewara.code.util.FileSearch;
import com.gewara.code.util.LineFilter;
import com.gewara.code.util.MethodLine;
import com.gewara.code.util.LineFilter.RegFilter;
import com.gewara.dubbo.bytecode.Wrapper;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

public class ClassFinderUtil {
	private static final char DOT = '.';
	private static final char SLASH = '/';
	private static final String CLASS_SUFFIX = ".class";
	public static final String URL_PROTOCOL_FILE = "file";
	public static final String URL_PROTOCOL_JAR = "jar";
	public static final String URL_PROTOCOL_ZIP = "zip";
	public static final String URL_PROTOCOL_WSJAR = "wsjar";
	public static final String URL_PROTOCOL_VFSZIP = "vfszip";

	public static List<Class<?>> find(String scannedPackage) {
		String scannedPath = scannedPackage.replace('.', '/');
		Enumeration resources = null;
		ArrayList result = new ArrayList();

		try {
			resources = Thread.currentThread().getContextClassLoader().getResources(scannedPath);
		} catch (IOException arg4) {
			;
		}

		if (resources == null) {
			return result;
		} else {
			while (resources.hasMoreElements()) {
				URL resource = (URL) resources.nextElement();
				if (isFileURL(resource)) {
					result.addAll(findFileClass(resource.getFile(), scannedPackage));
				} else if (isJarURL(resource)) {
					;
				}
			}

			return result;
		}
	}

	public static List<Class<?>> findFileClass(String scanDir, String scannedPackage) {
		ArrayList classes = new ArrayList();
		File rootFile = new File(scanDir);
		File[] arg3 = rootFile.listFiles();
		int arg4 = arg3.length;

		for (int arg5 = 0; arg5 < arg4; ++arg5) {
			File file = arg3[arg5];
			classes.addAll(find(file, scannedPackage));
		}

		return classes;
	}

	public static boolean isJarURL(URL url) {
		String protocol = url.getProtocol();
		return "jar".equals(protocol) || "zip".equals(protocol) || "vfszip".equals(protocol)
				|| "wsjar".equals(protocol);
	}

	public static boolean isFileURL(URL url) {
		String protocol = url.getProtocol();
		return "file".equals(protocol);
	}

	protected Set<URL> findJarClass(URL rootDir, String subPattern) throws IOException {
		URLConnection con = rootDir.openConnection();
		JarFile jarFile = null;
		String rootEntryPath = null;
		boolean newJarFile = false;
		if (con instanceof JarURLConnection) {
			JarURLConnection result = (JarURLConnection) con;
			jarFile = result.getJarFile();
			JarEntry entries = result.getJarEntry();
			rootEntryPath = entries != null ? entries.getName() : "";
		}

		try {
			if (!"".equals(rootEntryPath) && !rootEntryPath.endsWith("/")) {
				rootEntryPath = rootEntryPath + "/";
			}

			LinkedHashSet result1 = new LinkedHashSet(8);
			Enumeration entries1 = jarFile.entries();

			while (entries1.hasMoreElements()) {
				JarEntry entry = (JarEntry) entries1.nextElement();
				String entryPath = entry.getName();
				if (entryPath.startsWith(rootEntryPath)) {
					String relativePath = entryPath.substring(rootEntryPath.length());
					result1.add(this.createRelative(rootDir, relativePath));
				}
			}

			LinkedHashSet entries2 = result1;
			return entries2;
		} finally {
			if (newJarFile) {
				jarFile.close();
			}

		}
	}

	private URL createRelative(URL rootDir, String relativePath) throws MalformedURLException {
		if (relativePath.startsWith("/")) {
			relativePath = relativePath.substring(1);
		}

		return new URL(rootDir, relativePath);
	}

	public static List<String> findNoDefaultConstructClass(String scannedPackage) {
		ArrayList result = new ArrayList();
		List classList = find(scannedPackage);
		Iterator arg2 = classList.iterator();

		while (arg2.hasNext()) {
			Class clazz = (Class) arg2.next();
			if (ClassUtil.isConcrete(clazz)) {
				try {
					clazz.newInstance();
				} catch (Throwable arg5) {
					result.add(clazz.getCanonicalName());
				}
			}
		}

		return result;
	}

	private static List<Class<?>> find(File file, String scannedPackage) {
		ArrayList classes = new ArrayList();
		String resource = scannedPackage + '.' + file.getName();
		if (file.isDirectory()) {
			File[] endIndex = file.listFiles();
			int className = endIndex.length;

			for (int arg5 = 0; arg5 < className; ++arg5) {
				File child = endIndex[arg5];
				classes.addAll(find(child, resource));
			}
		} else if (resource.endsWith(".class")) {
			int arg8 = resource.length() - ".class".length();
			String arg9 = resource.substring(0, arg8);

			try {
				classes.add(Class.forName(arg9));
			} catch (ClassNotFoundException arg7) {
				;
			}
		}

		return classes;
	}

	public static List<MethodLine> findInterfaceMethods(String javaSrc, String clazz) throws Exception {
		String javaFile = StringUtils.replace(clazz, ".", "/") + ".java";
		File file = new File(javaSrc, javaFile);
		ArrayList methods = new ArrayList();
		List lines = IOUtils.readLines(new FileReader(file));
		int i = 1;

		for (Iterator arg6 = lines.iterator(); arg6.hasNext(); ++i) {
			String line = (String) arg6.next();
			line = StringUtils.trim(line);
			if (!line.startsWith("import") && !line.contains("interface") && !line.startsWith("package")
					&& line.matches("^\\w+.*")) {
				if (line.startsWith("public")) {
					line = line.substring(7).trim();
				}

				line = line.replaceAll("<[^>]*>", "");
				methods.add(new MethodLine(clazz, line, Integer.valueOf(i)));
			}
		}

		return methods;
	}

	public static List<String> findStaticFields(Class clazz, boolean addClassPre) {
		ArrayList result = new ArrayList();
		String className = clazz.getSimpleName();
		Field[] arg3 = clazz.getFields();
		int arg4 = arg3.length;

		for (int arg5 = 0; arg5 < arg4; ++arg5) {
			Field f = arg3[arg5];
			if (Modifier.isStatic(f.getModifiers())) {
				if (addClassPre) {
					result.add(className + "." + f.getName());
				} else {
					result.add(f.getName());
				}
			}
		}

		return result;
	}

	public static void findAllUnusedStaticFields(String pkg, String javaSrc) {
		List clazzList = findAllClass(pkg, ClassFilter.ACCEPT_ALL);
		System.err.println("---start loadsource-------------------------------------------");
		List javaSourceLines = loadAllJava(javaSrc, LineFilter.ACCEPT_ALL_FILTER);
		System.err.println("---end loadsource-------------------------------------------");
		ArrayList regList = new ArrayList();
		Iterator arg4 = clazzList.iterator();

		while (arg4.hasNext()) {
			Class reg = (Class) arg4.next();
			List notUsed = findUnusedStaticFieldsInternal(reg, javaSourceLines);
			if (notUsed.size() > 0) {
				regList.add(reg.getCanonicalName() + " search reg: .*(" + StringUtils.join(notUsed, "|") + ").*\\R");
			}
		}

		System.err.println("----------------------- eclipse search regex ----------------------------");
		arg4 = regList.iterator();

		while (arg4.hasNext()) {
			String reg1 = (String) arg4.next();
			System.out.println(reg1);
		}

	}

	public static List<String> findUnusedStaticFields(Class clazz, String javaSrc) {
		System.err.println("---start loadsource-------------------------------------------");
		List javaSourceLines = loadAllJava(javaSrc, LineFilter.ACCEPT_ALL_FILTER);
		System.err.println("---end loadsource-------------------------------------------");
		List result = findUnusedStaticFieldsInternal(clazz, javaSourceLines);
		return result;
	}

	private static List<String> findUnusedStaticFieldsInternal(Class clazz, List<String> sourceLines) {
		ArrayList notUsed = new ArrayList();
		boolean find = false;
		List staticFieldList = findStaticFields(clazz, false);
		String className = clazz.getSimpleName();
		Iterator arg5 = staticFieldList.iterator();

		String method;
		while (arg5.hasNext()) {
			method = (String) arg5.next();
			String search = className + "." + method;
			find = false;
			Iterator arg8 = sourceLines.iterator();

			while (arg8.hasNext()) {
				String line = (String) arg8.next();
				if (StringUtils.containsIgnoreCase(line, search)) {
					find = true;
					break;
				}
			}

			if (!find) {
				notUsed.add(method);
				System.out.println("not found:" + method);
			}
		}

		System.err
				.println("-----------------------" + clazz.getCanonicalName() + "------------------------------------");
		arg5 = notUsed.iterator();

		while (arg5.hasNext()) {
			method = (String) arg5.next();
			System.out.println(method);
		}

		return notUsed;
	}

	public static void findNoDefault(String pkg) {
		List classList = findNoDefaultConstructClass(pkg);
		Iterator arg1 = classList.iterator();

		while (arg1.hasNext()) {
			String clazz = (String) arg1.next();
			System.out.println(clazz);
		}

	}

	public static List<String> findInterfaces(String pkg) {
		List list = find(pkg);
		ArrayList result = new ArrayList();
		Iterator arg2 = list.iterator();

		while (arg2.hasNext()) {
			Class clazz = (Class) arg2.next();
			if (isInterface(clazz)) {
				result.add(clazz.getCanonicalName());
			}
		}

		return result;
	}

	public static List<String> findConcreteClass(String pkg) {
		List list = find(pkg);
		ArrayList result = new ArrayList();
		Iterator arg2 = list.iterator();

		while (arg2.hasNext()) {
			Class clazz = (Class) arg2.next();
			if (ClassUtil.isConcrete(clazz)) {
				result.add(clazz.getCanonicalName());
			}
		}

		return result;
	}

	public static List<Class> findAllClass(String pkg, ClassFilter filter) {
		List list = find(pkg);
		ArrayList result = new ArrayList();
		String cn = null;
		Iterator arg4 = list.iterator();

		while (arg4.hasNext()) {
			Class clazz = (Class) arg4.next();
			if (filter.accept(clazz)) {
				cn = clazz.getCanonicalName();
				if (cn == null) {
					System.err.println("NoName:" + clazz);
				} else {
					result.add(clazz);
				}
			}
		}

		return result;
	}

	public static List<String> toStringNames(List<Class> clazzList) {
		ArrayList result = new ArrayList();
		Iterator arg1 = clazzList.iterator();

		while (arg1.hasNext()) {
			Class clazz = (Class) arg1.next();
			String cn = clazz.getCanonicalName();
			if (cn == null) {
				System.err.println("NoName:" + clazz);
			} else {
				result.add(cn);
			}
		}

		return result;
	}

	public static boolean isInterface(Class<?> type) {
		int mod = type.getModifiers();
		return (mod & 512) > 0;
	}

	public static void findNotMatchGetSet(String modelPackage) {
		List list = find(modelPackage);
		Iterator arg1 = list.iterator();

		while (arg1.hasNext()) {
			Class clazz = (Class) arg1.next();

			try {
				if (ClassUtil.isConcrete(clazz) && clazz.getCanonicalName().indexOf(36) < 0) {
					Wrapper e = Wrapper.getWrapper(clazz);
					ArrayList read = new ArrayList(Arrays.asList(e.getReadPropertyNames()));
					ArrayList write = new ArrayList(Arrays.asList(e.getWritePropertyNames()));
					ArrayList read2 = new ArrayList(read);
					read2.removeAll(write);
					write.removeAll(read);
					String msg = "";
					if (!read2.isEmpty()) {
						msg = "get: " + StringUtils.join(read2, ",");
					}

					if (!write.isEmpty()) {
						msg = "  set: " + StringUtils.join(write, ",");
					}

					if (StringUtils.isNotBlank(msg)) {
						System.out.println(clazz.getCanonicalName() + ":" + msg);
					}
				}
			} catch (Exception arg8) {
				System.out.println(clazz.getCanonicalName() + ":" + arg8);
			}
		}

	}

	public static void findUnusedClasses(String javaSrc, String... searchPkg) {
		List importList = loadAllJava(javaSrc, new RegFilter("^import"));
		String[] arg2 = searchPkg;
		int arg3 = searchPkg.length;

		for (int arg4 = 0; arg4 < arg3; ++arg4) {
			String pkg = arg2[arg4];
			findUnusedClass(importList, pkg);
		}

	}

	public static void findUnusedInterfaceMethod(String interfaceSrc, String javaSource) throws Exception {
		List interfaces = findInterfaces(interfaceSrc);
		ArrayList searchCall = new ArrayList();
		Iterator javaSourceLines = interfaces.iterator();

		while (javaSourceLines.hasNext()) {
			String notUsed = (String) javaSourceLines.next();
			List find = findInterfaceMethods(javaSource, notUsed);
			toSimpleCallName(notUsed, find);
			searchCall.addAll(find);
		}

		System.err.println("---start loadsource-------------------------------------------");
		List javaSourceLines1 = loadAllJava(javaSource, LineFilter.ACCEPT_ALL_FILTER);
		System.err.println("---end loadsource-------------------------------------------");
		ArrayList notUsed1 = new ArrayList();
		boolean find1 = false;
		Iterator arg6 = searchCall.iterator();

		while (true) {
			MethodLine method;
			do {
				if (!arg6.hasNext()) {
					System.err.println("-----------------------------------------------------------");
					arg6 = notUsed1.iterator();

					while (arg6.hasNext()) {
						method = (MethodLine) arg6.next();
						System.out.println(method);
					}

					return;
				}

				method = (MethodLine) arg6.next();
			} while (method.callname == null);

			find1 = false;
			Iterator arg8 = javaSourceLines1.iterator();

			while (arg8.hasNext()) {
				String line = (String) arg8.next();
				if (StringUtils.containsIgnoreCase(line, method.callname)) {
					find1 = true;
					break;
				}
			}

			if (!find1) {
				notUsed1.add(method);
				System.out.println("not found:" + method);
			}
		}
	}

	public static void toSimpleCallName(String clazz, List<MethodLine> methods) {
		String serviceName = StringUtils.substringAfterLast(clazz, ".");
		Iterator arg2 = methods.iterator();

		while (arg2.hasNext()) {
			MethodLine method = (MethodLine) arg2.next();

			try {
				int e = method.method.indexOf("(");
				String[] methodPair = method.method.substring(0, e).split("\\s+");
				String methodName = methodPair[methodPair.length - 1];
				method.callname = serviceName + "." + methodName;
			} catch (Exception arg7) {
				System.err.print("ERROR:" + method);
			}
		}

	}

	public static List<String> loadAllJava(String javaSrc, LineFilter lineFilter) {
		ArrayList result = new ArrayList();

		try {
			ArrayList e = new ArrayList();
			FileSearch.searchFile(e, javaSrc, "java");
			Iterator arg3 = e.iterator();

			while (arg3.hasNext()) {
				String file = (String) arg3.next();
				List lines = IOUtils.readLines(new FileReader(file));
				Iterator arg6 = lines.iterator();

				while (arg6.hasNext()) {
					String line = (String) arg6.next();
					if (lineFilter.accept(line)) {
						result.add(line);
					}
				}
			}
		} catch (Exception arg8) {
			arg8.printStackTrace();
		}

		return result;
	}

	public static void findUnusedClass(List<String> importList, String pkg) {
		List modelList = findAllClass(pkg, ClassFilter.ACCEPT_ALL);
		TreeSet modelSet = new TreeSet(toStringNames(modelList));
		System.out.println("------------------------import: " + modelSet.size() + "------------------------------");
		Iterator arg3 = importList.iterator();

		while (arg3.hasNext()) {
			String imp = (String) arg3.next();
			int index = imp.indexOf(pkg);
			if (index > 0) {
				int index2 = imp.indexOf(59);
				String clazz = StringUtils.substring(imp, index, index2);
				modelSet.remove(StringUtils.trim(clazz));
			}
		}

		System.out.println(
				"------------------------unused: " + pkg + ":" + modelSet.size() + "------------------------------");
		System.out.println(StringUtils.join(modelSet, "\n"));
	}
}