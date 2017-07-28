/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mongo.support;

import com.gewara.mongo.support.TableStats;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang.StringUtils;

public class MongoStats {
	public static String OP_QUERY = "query";
	public static String OP_UPDATE = "update";
	public static String OP_REMOVE = "remove";
	public static boolean enableStats = true;
	private static Map<String, TableStats> statsMap = new ConcurrentHashMap();

	public static boolean isEnableStats() {
		return enableStats;
	}

	public static void setEnableStats(boolean enableStats) {
		MongoStats.enableStats = enableStats;
	}

	public static void addOp(String namespace, String op) {
		if (enableStats) {
			TableStats stats = (TableStats) statsMap.get(namespace);
			if (stats == null) {
				stats = new TableStats(namespace);
				statsMap.put(namespace, stats);
			}

			if (StringUtils.equals(op, OP_QUERY)) {
				stats.addQuery();
			} else if (StringUtils.equals(op, OP_UPDATE)) {
				stats.addUpdate();
			} else if (StringUtils.equals(op, OP_REMOVE)) {
				stats.addRemove();
			}

		}
	}

	public static List<TableStats> getTableStats() {
		return new ArrayList(statsMap.values());
	}
}