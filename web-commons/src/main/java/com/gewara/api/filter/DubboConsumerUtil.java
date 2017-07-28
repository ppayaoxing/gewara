/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.api.filter;

import java.util.Map;

public class DubboConsumerUtil {
	private static final ThreadLocal<Map<String, String>> pushHeader = new ThreadLocal();

	public static void clearHeader() {
		pushHeader.remove();
	}

	public static void pushHeader(Map<String, String> header) {
		pushHeader.set(header);
	}

	public static Map<String, String> getHeader() {
		return (Map) pushHeader.get();
	}
}