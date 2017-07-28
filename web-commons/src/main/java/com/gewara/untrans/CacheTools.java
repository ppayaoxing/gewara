/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

public interface CacheTools {
	Object get(String arg0, String arg1);

	void set(String arg0, String arg1, Object arg2);

	void remove(String arg0, String arg1);

	boolean isLocal();
}