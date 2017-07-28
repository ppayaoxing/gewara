/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import com.gewara.Config;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;

public class WebLogger {
	public static GewaLogger getLogger(Class clazz) {
		return LoggerUtils.getLogger(clazz, Config.getServerIp(), Config.SYSTEMID);
	}
}