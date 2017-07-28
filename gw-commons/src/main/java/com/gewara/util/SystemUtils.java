/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import org.apache.commons.lang.StringUtils;

public class SystemUtils {
	public static final String getShortHostname(String hostname) {
		int idx = StringUtils.indexOf(hostname, '.');
		return idx > 0 ? StringUtils.substring(hostname, 0, idx) : hostname;
	}

	public static boolean isNormalFile(String filename) {
		return StringUtils.isNotBlank(filename) && !StringUtils.contains(filename, "..");
	}
}