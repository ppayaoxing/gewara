package com.gewara.util;

import java.util.HashSet;
import java.util.Set;

public class Debugger {
	protected final static transient GewaLogger dbLogger = WebLogger.getLogger(DataCollectUtil.class);
	private static Set<String> enabledClass = new HashSet<>();
	public static boolean isDebugEnabled() {
		return debugEnabled;
	}
	public static boolean isDebugEnabled(String tag) {
		return debugEnabled && enabledClass.contains(tag);
	}

	public static void setDebugEnabled(boolean enabled) {
		debugEnabled = enabled;
	}
	public static void enableClazz(String clazz){
		enabledClass.add(clazz);
	}
	public static void disableClazz(String clazz){
		enabledClass.remove(clazz);
	}
	private static boolean debugEnabled = false;

	public static void debugInfo(String clazz, String msg){
		if(debugEnabled){
			if(enabledClass.contains(clazz)){
				dbLogger.warn(msg);
			}
		}
	}

	public static String getDebugInfo() {
		return debugEnabled +":" + enabledClass;
	}
}
