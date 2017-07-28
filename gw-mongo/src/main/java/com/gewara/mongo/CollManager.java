/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mongo;

import java.util.Map;

public interface CollManager {
	Map<String, String> getPkeyMap();

	void validateColl(String arg0);

	String getPkey(String arg0);
}