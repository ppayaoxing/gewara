/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ParamCollectUtils {
	private static boolean collectEnabled = false;
	private static long enableTime = 0L;
	private static Map<String, Map<String, AtomicInteger>> namesMap = new ConcurrentHashMap();

	public static void enableCollect(int seconds) {
		if (seconds <= 0) {
			collectEnabled = false;
		} else {
			collectEnabled = true;
			enableTime = System.currentTimeMillis() + (long) (seconds * 1000);
		}

	}

	public static void addNameIfEnabled(long cur, String uri, Map<String, String> params) {
		if (collectEnabled && enableTime > cur) {
			Object names = (Map) namesMap.get(uri);
			if (names == null) {
				names = new ConcurrentHashMap();
				namesMap.put(uri, names);
			}

			ArrayList pnList = new ArrayList(params.keySet());
			Iterator arg5 = pnList.iterator();

			while (arg5.hasNext()) {
				String key = (String) arg5.next();
				AtomicInteger count = (AtomicInteger) ((Map) names).get(key);
				if (count == null) {
					count = new AtomicInteger(1);
					((Map) names).put(key, count);
				} else {
					count.incrementAndGet();
				}
			}
		}

	}

	public static List<String> getStats() {
		ArrayList uriList = new ArrayList(namesMap.keySet());
		ArrayList result = new ArrayList();
		Iterator arg1 = uriList.iterator();

		while (arg1.hasNext()) {
			String uri = (String) arg1.next();
			Map pnMap = (Map) namesMap.get(uri);
			Iterator arg4 = pnMap.entrySet().iterator();

			while (arg4.hasNext()) {
				Entry entry = (Entry) arg4.next();
				result.add(uri + "," + (String) entry.getKey() + "," + entry.getValue());
			}
		}

		return result;
	}
}