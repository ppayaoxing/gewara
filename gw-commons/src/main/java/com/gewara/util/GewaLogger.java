/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import java.util.Map;

public interface GewaLogger {
	void warn(String arg0);

	void error(String arg0);

	void warn(String arg0, Throwable arg1);

	void warn(Throwable arg0, int arg1);

	void warn(String arg0, Throwable arg1, int arg2);

	void error(String arg0, Throwable arg1);

	void error(String arg0, Throwable arg1, int arg2);

	void error(Throwable arg0, int arg1);

	void warnMap(Map arg0);

	void warnMap(String arg0, Map arg1);

	void errorMap(Map arg0);

	void errorMap(String arg0, Map arg1);

	void warnWithType(String arg0, String arg1, Throwable arg2);

	void warnWithType(String arg0, String arg1, Throwable arg2, int arg3);

	void warnWithType(String arg0, String arg1);

	void errorWithType(String arg0, String arg1);

	void errorWithType(String arg0, String arg1, Throwable arg2);

	void errorWithType(String arg0, String arg1, Throwable arg2, int arg3);
}