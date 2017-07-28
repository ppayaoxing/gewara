/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import com.gewara.util.DataCollectUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.util.HashSet;
import java.util.Set;

public class Debugger {
	protected static final transient GewaLogger dbLogger = WebLogger.getLogger(DataCollectUtil.class);
	private static Set<String> enabledClass = new HashSet();
	private static boolean debugEnabled = false;

	public static boolean isDebugEnabled() {
		return debugEnabled;
	}

	public static boolean isDebugEnabled(String tag) {
		return debugEnabled && enabledClass.contains(tag);
	}

	public static void setDebugEnabled(boolean enabled) {
		debugEnabled = enabled;
	}

	public static void enableClazz(String clazz) {
		enabledClass.add(clazz);
	}

	public static void disableClazz(String clazz) {
		enabledClass.remove(clazz);
	}

	public static void debugInfo(String clazz, String msg) {
		if (debugEnabled && enabledClass.contains(clazz)) {
			dbLogger.warn(msg);
		}

	}

	public static String getDebugInfo() {
		return debugEnabled + ":" + enabledClass;
	}
}