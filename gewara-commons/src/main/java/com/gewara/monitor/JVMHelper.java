/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.monitor;

import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.Thread.State;
import java.lang.management.LockInfo;
import java.lang.management.ManagementFactory;
import java.lang.management.MonitorInfo;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections.bag.HashBag;

public class JVMHelper {
	private static GewaLogger dbLogger = LoggerUtils.getLogger(JVMHelper.class);

	public static Map<String, String> exportThreadToFile(String filePath, String fileName) {
		File savePath = new File(filePath);
		if (!savePath.exists()) {
			savePath.mkdirs();
		}

		BufferedWriter writer = null;
		Object result = null;
		File file = new File(filePath, fileName);

		try {
			writer = new BufferedWriter(new FileWriter(file));
			result = exportThread(writer);
		} catch (Exception arg14) {
			dbLogger.warn("", arg14);
			result = new HashMap();
			((Map) result).put("error", arg14.getClass().getName() + ":" + arg14.getMessage());
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception arg13) {
					;
				}
			}

		}

		((Map) result).put("fileName", fileName);
		if (file.exists()) {
			((Map) result).put("fileSize", "" + file.length());
		}

		return (Map) result;
	}

	public static Map<String, String> exportThread(Writer writer) throws IOException {
		Map traceList = Thread.getAllStackTraces();
		HashBag bag = new HashBag();
		Iterator result = traceList.entrySet().iterator();

		while (result.hasNext()) {
			Entry trace = (Entry) result.next();
			Thread key = (Thread) trace.getKey();
			writer.write("\"" + key.getName() + "\" - " + key.getState() + "\n");
			StackTraceElement[] arg5 = (StackTraceElement[]) trace.getValue();
			int arg6 = arg5.length;

			for (int arg7 = 0; arg7 < arg6; ++arg7) {
				StackTraceElement stack = arg5[arg7];
				writer.write("\tat " + stack.toString() + "\n");
			}

			writer.write("\n");
			bag.add(key.getState().name());
		}

		HashMap arg9 = new HashMap();
		arg9.put("threadCount", "" + traceList.size());
		Iterator arg10 = bag.uniqueSet().iterator();

		while (arg10.hasNext()) {
			Object arg11 = arg10.next();
			arg9.put((String) arg11, "" + bag.getCount(arg11));
		}

		return arg9;
	}

	public static Map<String, String> exportMBeanThread(Writer writer) throws IOException {
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] tiList = bean.getThreadInfo(bean.getAllThreadIds(), true, true);
		HashBag bag = new HashBag();
		ThreadInfo[] result = tiList;
		int arg4 = tiList.length;

		for (int key = 0; key < arg4; ++key) {
			ThreadInfo ti = result[key];
			appendThreadInfo(writer, ti);
			bag.add(ti.getThreadState().name());
		}

		HashMap arg7 = new HashMap();
		arg7.put("threadCount", "" + tiList.length);
		Iterator arg8 = bag.uniqueSet().iterator();

		while (arg8.hasNext()) {
			Object arg9 = arg8.next();
			arg7.put((String) arg9, "" + bag.getCount(arg9));
		}

		return arg7;
	}

	private static void appendThreadInfo(Writer writer, ThreadInfo ti) throws IOException {
		writer.append("\"" + ti.getThreadName() + "\" Id=" + ti.getThreadId() + " " + ti.getThreadState());
		if (ti.getLockName() != null) {
			writer.append(" on " + ti.getLockName());
		}

		if (ti.getLockOwnerName() != null) {
			writer.append(" owned by \"" + ti.getLockOwnerName() + "\" Id=" + ti.getLockOwnerId());
		}

		if (ti.isSuspended()) {
			writer.append(" (suspended)");
		}

		if (ti.isInNative()) {
			writer.append(" (in native)");
		}

		writer.append('\n');
		StackTraceElement[] stackTrace = ti.getStackTrace();

		int arg5;
		for (int locks = 0; locks < stackTrace.length; ++locks) {
			StackTraceElement ste = stackTrace[locks];
			writer.append("\tat " + ste.toString());
			writer.append('\n');
			if (locks == 0 && ti.getLockInfo() != null) {
				State ts = ti.getThreadState();
				switch (null.$SwitchMap$java$lang$Thread$State[ts.ordinal()]) {
				case 1:
					writer.append("\t-  blocked on " + ti.getLockInfo());
					writer.append('\n');
					break;
				case 2:
					writer.append("\t-  waiting on " + ti.getLockInfo());
					writer.append('\n');
					break;
				case 3:
					writer.append("\t-  waiting on " + ti.getLockInfo());
					writer.append('\n');
				}
			}

			MonitorInfo[] arg10 = ti.getLockedMonitors();
			arg5 = arg10.length;

			for (int li = 0; li < arg5; ++li) {
				MonitorInfo mi = arg10[li];
				if (mi.getLockedStackDepth() == locks) {
					writer.append("\t-  locked " + mi);
					writer.append('\n');
				}
			}
		}

		LockInfo[] arg8 = ti.getLockedSynchronizers();
		if (arg8.length > 0) {
			writer.append("\n\tNumber of locked synchronizers = " + arg8.length);
			writer.append('\n');
			LockInfo[] arg9 = arg8;
			int arg11 = arg8.length;

			for (arg5 = 0; arg5 < arg11; ++arg5) {
				LockInfo arg12 = arg9[arg5];
				writer.append("\t- " + arg12);
				writer.append('\n');
			}
		}

		writer.append('\n');
	}
}