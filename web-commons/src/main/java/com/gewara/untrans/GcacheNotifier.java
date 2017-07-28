/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

public interface GcacheNotifier {
	void notifyChanges(Class arg0, String arg1);

	void notifyChangesAsynch(Class arg0, String arg1, String arg2);

	void notifyClean(String arg0, String arg1);
}