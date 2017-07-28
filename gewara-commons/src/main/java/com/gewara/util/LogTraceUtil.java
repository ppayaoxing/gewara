/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class LogTraceUtil {
	private static List<LogTraceUtil.LogTrace> traceList = new ArrayList();

	public static void addTrace(LogTraceUtil.LogTrace trace) {
		traceList.add(trace);
	}

	public static List<String> getTraceInfo() {
		ArrayList result = new ArrayList();
		Iterator arg0 = traceList.iterator();

		while (arg0.hasNext()) {
			LogTraceUtil.LogTrace trace = (LogTraceUtil.LogTrace) arg0.next();

			try {
				String ts = trace.getTrace();
				if (StringUtils.isNotBlank(ts)) {
					result.add(ts);
				}
			} catch (Throwable arg3) {
				;
			}
		}

		return result;
	}

	public interface LogTrace {
		String getTrace();
	}
}