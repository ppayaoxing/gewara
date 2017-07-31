package com.gewara.util;

import com.gewara.Config;

public class WebLogger {
	public static GewaLogger getLogger(Class clazz) {
		return LoggerUtils.getLogger(clazz, Config.getServerIp(), Config.SYSTEMID);
	}
}
