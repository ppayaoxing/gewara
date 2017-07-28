/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.support.PropertyComparator;

public class DynamicStats {
	private Map<String, DynamicStats.LogCounter> counterMap = new ConcurrentHashMap();
	private Map<String, String> specialTypes = new HashMap();
	private AtomicInteger totalProcessing = new AtomicInteger(0);
	private long lastRemoveTime = 0L;
	private long lastCleanTime = 0L;
	private boolean init = false;
	private String type;

	public long getLastRemoveTime() {
		return this.lastRemoveTime;
	}

	public long getLastCleanTime() {
		return this.lastCleanTime;
	}

	public String getType() {
		return this.type;
	}

	public DynamicStats(String type) {
		this.type = type;
	}

	public void setInit(boolean init) {
		this.init = init;
	}

	public boolean isInit() {
		return this.init;
	}

	public int getCounterSize() {
		return this.counterMap.size();
	}

	public int getTotalProcessing() {
		return this.totalProcessing.get();
	}

	public List<Map> getProcessingList(int waitmill) {
		ArrayList result = new ArrayList();
		long totalprocessing = 0L;
		long maxnum = 0L;
		long totalprocessed = 0L;
		long totaltime = 0L;
		Iterator row = this.counterMap.values().iterator();

		while (row.hasNext()) {
			DynamicStats.LogCounter counter = (DynamicStats.LogCounter) row.next();
			int p = counter.processing.get();
			if (p > 0) {
				LinkedHashMap row1 = new LinkedHashMap();
				long total = System.currentTimeMillis() * (long) p - counter.processTime.get();
				totaltime += total;
				totalprocessing += (long) p;
				if (total > maxnum) {
					maxnum = total;
				}

				long avgwait = total / (long) p;
				if (avgwait > (long) waitmill) {
					int processed = counter.processed.get();
					totalprocessed += (long) processed;
					row1.put("processed", Integer.valueOf(processed));
					row1.put("processing", Integer.valueOf(p));
					row1.put("avgwait", Long.valueOf(avgwait));
					row1.put("type", StringUtils.defaultString((String) this.specialTypes.get(counter.url), "normal"));
					row1.put("url", counter.url);
					result.add(row1);
				}
			}
		}

		if (result.size() > 0) {
			LinkedHashMap row2 = new LinkedHashMap();
			row2.put("processed", Long.valueOf(totalprocessed));
			row2.put("processing", Long.valueOf(totalprocessing));
			row2.put("avgwait", Long.valueOf(totaltime / totalprocessing));
			row2.put("url", "total");
			result.add(row2);
		}

		return result;
	}

	public DynamicStats.LogCounter register(String sourceName, long regtime) {
		DynamicStats.LogCounter lc = new DynamicStats.LogCounter(sourceName, Long.valueOf(regtime));
		lc.type = this.type;
		this.counterMap.put(sourceName, lc);
		return lc;
	}

	public void addSpecialType(String uri, String rtype) {
		this.specialTypes.put(uri, rtype);
	}

	public String getSpecialType(String uri) {
		return (String) this.specialTypes.get(uri);
	}

	public DynamicStats.LogCounter beforeProcess(String resourceName, long curtime) {
		DynamicStats.LogCounter counter = (DynamicStats.LogCounter) this.counterMap.get(resourceName);
		if (counter != null) {
			this.totalProcessing.incrementAndGet();
			counter.processing.incrementAndGet();
			counter.processTime.addAndGet(curtime);
		}

		return counter;
	}

	public int getResourceProcessingCount(String resourceName) {
		DynamicStats.LogCounter counter = (DynamicStats.LogCounter) this.counterMap.get(resourceName);
		return counter != null ? counter.getProcessing().intValue() : 0;
	}

	public DynamicStats.LogCounter beforeProcessAndReg(String resourceName, long curtime) {
		DynamicStats.LogCounter counter = (DynamicStats.LogCounter) this.counterMap.get(resourceName);
		if (counter == null) {
			counter = this.register(resourceName, curtime);
		}

		if (counter != null) {
			this.totalProcessing.incrementAndGet();
			counter.processing.incrementAndGet();
			counter.processTime.addAndGet(curtime);
		}

		return counter;
	}

	public void afterProcess(DynamicStats.LogCounter counter, long lasttime, boolean updateTotaltime) {
		if (counter != null) {
			this.totalProcessing.decrementAndGet();
			counter.processing.decrementAndGet();
			counter.processTime.addAndGet(-lasttime);
			counter.processed.incrementAndGet();
			if (updateTotaltime) {
				counter.totaltime.addAndGet(System.currentTimeMillis() - lasttime);
			}
		}

	}

	public DynamicStats.LogCounter incrementCount(String uri) {
		DynamicStats.LogCounter counter = (DynamicStats.LogCounter) this.counterMap.get(uri);
		long cur = System.currentTimeMillis();
		if (counter == null) {
			counter = new DynamicStats.LogCounter(uri, Long.valueOf(cur));
			this.counterMap.put(uri, counter);
		}

		this.totalProcessing.incrementAndGet();
		counter.count.incrementAndGet();
		counter.endtime = Long.valueOf(cur);
		return counter;
	}

	public Map<String, String> updateProcessTime(String uri, long time, int clearmax) {
		DynamicStats.LogCounter counter = (DynamicStats.LogCounter) this.counterMap.get(uri);
		if (counter == null) {
			return null;
		} else {
			counter.count.incrementAndGet();
			counter.totaltime.addAndGet(time);
			if (time > 1000L) {
				counter.count2.incrementAndGet();
				counter.count2Time.addAndGet(time);
			}

			Long cur = Long.valueOf(System.currentTimeMillis());
			if (counter.count.get() < clearmax && counter.starttime.longValue() + 3600000L >= cur.longValue()) {
				return null;
			} else {
				Map result = getLogMap(counter, cur.longValue());
				resetCounter(counter, cur.longValue());
				return result;
			}
		}
	}

	public Map<String, Integer> getStatsAndClear(int maxnum) {
		if (this.getTotalProcessing() >= maxnum) {
			HashMap result = new HashMap();
			ArrayList counterList = new ArrayList(this.counterMap.values());
			Iterator arg3 = counterList.iterator();

			while (arg3.hasNext()) {
				DynamicStats.LogCounter counter = (DynamicStats.LogCounter) arg3.next();
				int value = counter.count.getAndSet(0);
				if (value > 0) {
					result.put(counter.getUrl(), Integer.valueOf(value));
				}
			}

			this.totalProcessing.getAndSet(0);
			this.lastCleanTime = System.currentTimeMillis();
			return result;
		} else {
			return null;
		}
	}

	public List<Map<String, String>> getAllStatsAndClear(int maxnum) {
		Long cur = Long.valueOf(System.currentTimeMillis());
		ArrayList result = new ArrayList();
		ArrayList counterList = new ArrayList(this.counterMap.values());
		Iterator arg4 = counterList.iterator();

		while (true) {
			DynamicStats.LogCounter counter;
			int ct;
			do {
				if (!arg4.hasNext()) {
					this.lastCleanTime = cur.longValue();
					return result;
				}

				counter = (DynamicStats.LogCounter) arg4.next();
				ct = counter.processed.get();
			} while (ct <= maxnum && (ct <= 0 || cur.longValue() - counter.getStarttime().longValue() <= 1800000L));

			Map row = getLogMap(counter, cur.longValue());
			if (cur.longValue() - counter.getStarttime().longValue() > 660000L) {
				row.put("flag", "long");
			} else {
				row.put("flag", "normal");
			}

			resetCounter(counter, cur.longValue());
			result.add(row);
		}
	}

	public List<Map> removeCountBefore(long timeBefore) {
		ArrayList result = new ArrayList();
		ArrayList counterList = new ArrayList(this.counterMap.values());
		Iterator arg4 = counterList.iterator();

		while (arg4.hasNext()) {
			DynamicStats.LogCounter counter = (DynamicStats.LogCounter) arg4.next();
			if (counter.getStarttime().longValue() < timeBefore) {
				this.counterMap.remove(counter.getUrl());
				LinkedHashMap row = new LinkedHashMap();
				row.put("count", Integer.valueOf(counter.getCount()));
				row.put("url", counter.getUrl());
				row.put("starttime", counter.starttime);
				row.put("endtime", counter.endtime);
			}
		}

		this.lastRemoveTime = System.currentTimeMillis();
		return result;
	}

	public Map<String, Integer> getStatsMap() {
		HashMap result = new HashMap();
		Iterator arg1 = this.counterMap.entrySet().iterator();

		while (arg1.hasNext()) {
			Entry entry = (Entry) arg1.next();
			int value = ((DynamicStats.LogCounter) entry.getValue()).count.get();
			if (value > 0) {
				result.put(entry.getKey(), Integer.valueOf(value));
			}
		}

		return result;
	}

	public List<Map> getCountList(int mincount, boolean reqFields) {
		LinkedList result = new LinkedList();
		Iterator arg3 = this.counterMap.values().iterator();

		while (arg3.hasNext()) {
			DynamicStats.LogCounter counter = (DynamicStats.LogCounter) arg3.next();
			if (counter.count.get() >= mincount) {
				result.add(this.getCounterCopy(counter, reqFields));
			}
		}

		Collections.sort(result, new PropertyComparator("count", false, false));
		return result;
	}

	public Set<String> getUnusedList() {
		TreeSet result = new TreeSet();
		Iterator arg1 = this.counterMap.values().iterator();

		while (arg1.hasNext()) {
			DynamicStats.LogCounter counter = (DynamicStats.LogCounter) arg1.next();
			if (counter.count.get() == 0) {
				result.add(counter.url);
			}
		}

		return result;
	}

	public Set<String> getAllResources() {
		TreeSet result = new TreeSet(this.counterMap.keySet());
		return result;
	}

	private Map getCounterCopy(DynamicStats.LogCounter counter, boolean reqFields) {
		LinkedHashMap map = new LinkedHashMap();
		map.put("starttime", new Timestamp(counter.starttime.longValue()));
		map.put("count", Integer.valueOf(counter.count.get()));
		if (reqFields) {
			map.put("totaltime", Long.valueOf(counter.totaltime.get()));
			map.put("count2", Integer.valueOf(counter.count2.get()));
			map.put("count2Time", Long.valueOf(counter.count2Time.get()));
			int curcount = counter.processing.get();
			map.put("processing", Integer.valueOf(curcount));
			map.put("processed", Integer.valueOf(counter.processed.get()));
			if (curcount > 0) {
				long total = System.currentTimeMillis() * (long) curcount - counter.processTime.get();
				long avgwait = total / (long) curcount;
				map.put("avgwait", Long.valueOf(avgwait));
			}
		}

		map.put("url", counter.url);
		return map;
	}

	private static Map<String, String> getLogMap(DynamicStats.LogCounter counter, long cur) {
		LinkedHashMap map = new LinkedHashMap();
		map.put("url", counter.url);
		map.put("starttime", counter.starttime.toString());
		map.put("count", counter.count.toString());
		map.put("totaltime", counter.totaltime.toString());
		map.put("count2", counter.count2.toString());
		map.put("count2Time", counter.count2Time.toString());
		map.put("endtime", "" + cur);
		map.put("processed", counter.processed.toString());
		map.put("processing", counter.processing.toString());
		return map;
	}

	private static void resetCounter(DynamicStats.LogCounter counter, long cur) {
		counter.starttime = Long.valueOf(cur);
		counter.count.set(0);
		counter.totaltime.set(0L);
		counter.count2.set(0);
		counter.count2Time.set(0L);
		counter.processed.set(0);
	}

	public static class LogCounter {
		private String type;
		private String url;
		private Long starttime;
		private Long endtime;
		private AtomicLong totaltime;
		private AtomicInteger count;
		private AtomicInteger count2;
		private AtomicLong count2Time;
		private AtomicInteger processed;
		private AtomicLong processTime;
		private AtomicInteger processing;

		public String getType() {
			return this.type;
		}

		public String getUrl() {
			return this.url;
		}

		public Long getStarttime() {
			return this.starttime;
		}

		public Long getEndtime() {
			return this.endtime;
		}

		public Long getTotaltime() {
			return Long.valueOf(this.totaltime.get());
		}

		public int getCount() {
			return this.count.get();
		}

		public int getCount2() {
			return this.count2.get();
		}

		public int increamentCount2() {
			return this.count2.incrementAndGet();
		}

		public Long getCount2Time() {
			return Long.valueOf(this.count2Time.get());
		}

		public Integer getProcessing() {
			return Integer.valueOf(this.processing.get());
		}

		private LogCounter(String url, Long starttime) {
			this.type = "req";
			this.url = url;
			this.starttime = starttime;
			this.endtime = starttime;
			this.totaltime = new AtomicLong(0L);
			this.count = new AtomicInteger(0);
			this.count2 = new AtomicInteger(0);
			this.count2Time = new AtomicLong(0L);
			this.processing = new AtomicInteger(0);
			this.processed = new AtomicInteger(0);
			this.processTime = new AtomicLong(0L);
		}
	}
}