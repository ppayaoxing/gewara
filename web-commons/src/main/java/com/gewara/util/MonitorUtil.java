/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import com.gewara.Config;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.SystemUtils;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;

public class MonitorUtil {
	private static String monitorPath = null;

	public static String alarm(String systemid, String hostname, String keyword, String msg) {
		String content = "";
		if (StringUtils.isNotBlank(keyword)) {
			content = keyword + ";";
		}

		if (StringUtils.isNotBlank(systemid)) {
			content = content + systemid + ";";
		}

		if (StringUtils.isNotBlank(hostname)) {
			content = content + SystemUtils.getShortHostname(hostname) + ";";
		}

		if (StringUtils.isNotBlank(msg)) {
			content = content + msg + ";";
		}

		if (StringUtils.isNotBlank(content)) {
			String url = monitorPath + "/sendMobileMsg.xhtml";
			HashMap params = new HashMap();
			params.put("msg", content);
			HttpResult result = HttpUtils.getUrlAsString(url, params);
			return result.isSuccess() ? content : "send err!";
		} else {
			return "conent err!";
		}
	}

	public static String getMonitorPath() {
		return monitorPath;
	}

	static {
		if (monitorPath == null) {
			try {
				Object path = Config.getPageTools().get("monitorPath");
				if (path != null) {
					monitorPath = String.valueOf(path);
				}
			} catch (Exception arg0) {
				;
			}

			if (StringUtils.isBlank(monitorPath)) {
				if (GewaIpConfig.isGewaInnerIp(GewaIpConfig.getServerip())) {
					monitorPath = "http://monitor.gewara.com/monitor";
				} else if (System.getProperty("test") != null) {
					monitorPath = "http://localhost/monitor";
				} else if (GewaIpConfig.isNanhuiIp(GewaIpConfig.getServerip())) {
					monitorPath = "http://nhmonitor.gewara.com/monitor";
				} else {
					monitorPath = "http://monitor.gewala.net/monitor";
				}
			} else if (StringUtils.endsWith(monitorPath, "/")) {
				monitorPath = StringUtils.substringBeforeLast(monitorPath, "/");
			}
		}

	}
}