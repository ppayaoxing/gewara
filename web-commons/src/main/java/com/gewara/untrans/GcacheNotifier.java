package com.gewara.untrans;

public interface GcacheNotifier {
	void notifyChanges(Class entityClazz, String ids);
	void notifyChangesAsynch(Class entityClazz, String ids, String op);
	void notifyClean(String tag, String ids);
}
