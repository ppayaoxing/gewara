/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import com.gewara.util.BaseWebUtils;
import com.gewara.util.ServiceCacheHelper;
import com.gewara.web.support.DynamicStats;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;

public class ResourceStatsUtil {
	private static DynamicStats badUrlStats = new DynamicStats("badurl");
	private static DynamicStats callStats = new DynamicStats("call");
	private static DynamicStats uriStats = new DynamicStats("uri");
	private static DynamicStats jmsStats = new DynamicStats("jms");
	private static DynamicStats pageCacheStats = new DynamicStats("pageCache");
	private static DynamicStats apiMethodStats = new DynamicStats("apiMethod");
	private static DynamicStats errorStats = new DynamicStats("errorStats");
	private static List<ServiceCacheHelper> schList = new ArrayList();
	private static Map<Integer, HttpServletRequest> requestMap = new ConcurrentHashMap(4096, 0.75F, 32);
	private static AtomicInteger curreqLoc = new AtomicInteger(0);

	public static DynamicStats getErrorStats() {
		return errorStats;
	}

	public static DynamicStats getBadUrlStats() {
		return badUrlStats;
	}

	public static DynamicStats getUriStats() {
		return uriStats;
	}

	public static DynamicStats getCallStats() {
		return callStats;
	}

	public static DynamicStats getJmsStats() {
		return jmsStats;
	}

	public static DynamicStats getPageCacheStats() {
		return pageCacheStats;
	}

	public static List<ServiceCacheHelper> getServiceCacheHelperList() {
		return new ArrayList(schList);
	}

	public static void addServiceCacheHelper(ServiceCacheHelper sch) {
		schList.add(sch);
	}

	public static DynamicStats getApiMethodStats() {
		return apiMethodStats;
	}

	public static Integer recordRequest(HttpServletRequest request, boolean multiPart) {
		if (multiPart) {
			return Integer.valueOf(-1);
		} else {
			Integer loc = Integer.valueOf(curreqLoc.getAndIncrement());
			requestMap.put(loc, request);
			return loc;
		}
	}

	public static List<Map> dumpRequest(int max) {
		ArrayList result = new ArrayList();
		Iterator arg1 = requestMap.entrySet().iterator();

		while (arg1.hasNext()) {
			Entry entry = (Entry) arg1.next();
			HttpServletRequest req = (HttpServletRequest) entry.getValue();
			if (req != null) {
				LinkedHashMap reqMap = new LinkedHashMap();
				reqMap.put("uri", req.getRequestURI());
				reqMap.put("params", BaseWebUtils.getParamStr(req, true, new String[0]));
				reqMap.put("header", BaseWebUtils.getHeaderStr(req));
				result.add(reqMap);
			}
		}

		return result;
	}

	public static void clearRequest(Integer loc) {
		if (loc.intValue() >= 0) {
			requestMap.remove(loc);
		}

	}

	public static void addUrlNoHandler(String uri) {
		badUrlStats.incrementCount(uri);
	}

	public static Map<String, Integer> clearUriIfMaxClick(int maxcount) {
		Map result = badUrlStats.getStatsAndClear(maxcount);
		return result;
	}

	public static void registerUri(Set<String> uriList, String contextPath) {
		if (!StringUtils.isBlank(contextPath) && !StringUtils.equals(contextPath, "/")) {
			if (contextPath.endsWith("/")) {
				contextPath = contextPath.substring(0, contextPath.length() - 1);
			}
		} else {
			contextPath = "";
		}

		long cur = System.currentTimeMillis();
		Iterator arg3 = uriList.iterator();

		while (arg3.hasNext()) {
			String uri = (String) arg3.next();
			uriStats.register(contextPath + uri, cur);
		}

		uriStats.setInit(true);
	}

	public static void registerCall(String callName) {
		long cur = System.currentTimeMillis();
		callStats.register(callName, cur);
	}

	public static Map<String, String> updateUriProcessTime(String uri, long elapsed, int maxcount) {
		return uriStats.updateProcessTime(uri, elapsed, maxcount);
	}

	public static void addAsynchUri(Set<String> uriList, String contextPath) {
		if (!StringUtils.isBlank(contextPath) && !StringUtils.equals(contextPath, "/")) {
			if (contextPath.endsWith("/")) {
				contextPath = contextPath.substring(0, contextPath.length() - 1);
			}
		} else {
			contextPath = "";
		}

		Iterator arg1 = uriList.iterator();

		while (arg1.hasNext()) {
			String uri = (String) arg1.next();
			uriStats.addSpecialType(contextPath + uri, "asynch");
		}

	}
}