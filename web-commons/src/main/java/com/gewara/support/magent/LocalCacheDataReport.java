package com.gewara.support.magent;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gewara.monitor.DataReport;
import com.gewara.monitor.ReportType;
import com.gewara.util.BeanUtil;
import com.gewara.util.CacheMeta;
import com.gewara.util.DateUtil;
import com.gewara.util.Gcache;
import com.gewara.util.GcacheManager;
import com.google.common.cache.CacheStats;

public class LocalCacheDataReport implements DataReport {

	@Override
	public List<Map<String, String>> getReportData() {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		Map<Class, CacheMeta> metaMap = GcacheManager.getAllCacheObjectMap();
		for(Map.Entry<Class, CacheMeta> entry: metaMap.entrySet()){
			Map sch = getAndResetStats(entry.getKey(), entry.getValue().gcache);
			if(!sch.isEmpty()){
				Map<String, String> dataReport = BeanUtil.toSimpleStringMap(sch);
				result.add(dataReport);
			}
		}
		return result;
	}

	@Override
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
		Map stats = new HashMap();
		if(h + m + e > 800 || t - starttime>DateUtil.m_hour && h + m + e>0){
			stats.put("hit", h);
			stats.put("miss", m);
			stats.put("expireHit", e);
			stats.put("service", clazz.getCanonicalName());
			stats.put("starttime", new Timestamp(starttime));
			stats.put("endtime", new Timestamp(t));
			stats.put("objNum", uCache.size());
			uCache.resetCacheStats(cacheStats);
		}
		return stats;
	}
}
