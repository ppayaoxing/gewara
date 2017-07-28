/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import java.io.InputStream;
import java.util.Map;

public interface RequestCallback {
	boolean processResult(InputStream arg0, Map<String, String> arg1);
}