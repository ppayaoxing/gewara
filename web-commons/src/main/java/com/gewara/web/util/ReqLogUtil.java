/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ReqLogUtil {
	public static final String REQ_LOG_ENTRY_ATTR_KEY = "_REQ_LOG_ENTRY_KEY";
	public static final String REQ_LOG_ENTRY_KEY_PRE = "log_";

	private static HttpServletRequest getRequest() {
		ServletRequestAttributes holder = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (holder != null) {
			HttpServletRequest request = holder.getRequest();
			if (request != null) {
				return request;
			}
		}

		return null;
	}

	public static void addLogInfo(Map<String, String> info) {
		if (info != null && !info.isEmpty()) {
			HttpServletRequest req = getRequest();
			if (req != null) {
				Object logEntry = (Map) req.getAttribute("_REQ_LOG_ENTRY_KEY");
				if (logEntry == null) {
					logEntry = new HashMap();
					req.setAttribute("_REQ_LOG_ENTRY_KEY", logEntry);
				}

				Iterator arg2 = info.entrySet().iterator();

				while (arg2.hasNext()) {
					Entry entry = (Entry) arg2.next();
					((Map) logEntry).put("log_" + StringUtils.substring((String) entry.getKey(), 0, 30),
							StringUtils.substring((String) entry.getValue(), 0, 128));
				}
			}

		}
	}

	public static void addLogInfo(String key, String value) {
		HttpServletRequest req = getRequest();
		if (req != null) {
			Object logEntry = (Map) req.getAttribute("_REQ_LOG_ENTRY_KEY");
			if (logEntry == null) {
				logEntry = new HashMap();
				req.setAttribute("_REQ_LOG_ENTRY_KEY", logEntry);
			}

			((Map) logEntry).put("log_" + StringUtils.substring(key, 0, 30), StringUtils.substring(value, 0, 128));
		}

	}
}