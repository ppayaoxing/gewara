/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.magent;

import com.gewara.monitor.DataReport;
import com.gewara.monitor.ReportType;
import com.gewara.util.BeanUtil;
import com.gewara.util.CacheMeta;
import com.gewara.util.Gcache;
import com.gewara.util.GcacheManager;
import com.google.common.cache.CacheStats;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LocalCacheDataReport implements DataReport {
	public List<Map<String, String>> getReportData() {
		ArrayList result = new ArrayList();
		Map metaMap = GcacheManager.getAllCacheObjectMap();
		Iterator arg2 = metaMap.entrySet().iterator();

		while (arg2.hasNext()) {
			Entry entry = (Entry) arg2.next();
			Map sch = this.getAndResetStats((Class) entry.getKey(), ((CacheMeta) entry.getValue()).gcache);
			if (!sch.isEmpty()) {
				Map dataReport = BeanUtil.toSimpleStringMap(sch);
				result.add(dataReport);
			}
		}

		return result;
	}

	public ReportType getReptype() {
		return ReportType.gcache;
	}

	private Map getAndResetStats(Class clazz, Gcache uCache) {
		CacheStats cacheStats = uCache.stats();
		CacheStats otherStats = uCache.getStartCacheStats();
		CacheStats subStats = cacheStats.minus(otherStats);
		long h = subStats.hitCount();
		long m = subStats.missCount();
		long e = subStats.evictionCount();
		long t = System.currentTimeMillis();
		long starttime = uCache.getStarttime();
		HashMap stats = new HashMap();
		if (h + m + e > 800L || t - starttime > 3600000L && h + m + e > 0L) {
			stats.put("hit", Long.valueOf(h));
			stats.put("miss", Long.valueOf(m));
			stats.put("expireHit", Long.valueOf(e));
			stats.put("service", clazz.getCanonicalName());
			stats.put("starttime", new Timestamp(starttime));
			stats.put("endtime", new Timestamp(t));
			stats.put("objNum", Long.valueOf(uCache.size()));
			uCache.resetCacheStats(cacheStats);
		}

		return stats;
	}
}