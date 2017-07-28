/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mongo.support;

import com.gewara.mongo.support.MongoStats;
import com.gewara.mongo.support.TableStats;
import com.gewara.monitor.DataReport;
import com.gewara.monitor.ReportType;
import com.gewara.util.BeanUtil;
import com.gewara.util.DateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MongoDataReport implements DataReport {
	private int countThreshold = '?';
	private int countMin = 120;
	private long timeThreshold = 1800000L;

	public List<Map<String, String>> getReportData() {
		ArrayList result = new ArrayList();
		List statsList = MongoStats.getTableStats();
		Iterator arg2 = statsList.iterator();

		while (true) {
			TableStats stats;
			do {
				if (!arg2.hasNext()) {
					return result;
				}

				stats = (TableStats) arg2.next();
			} while (stats.total() <= this.countThreshold
					&& (System.currentTimeMillis() - stats.getStarttime() <= this.timeThreshold
							|| stats.total() <= this.countMin));

			Map row = BeanUtil.toSimpleStringMap(BeanUtil.getBeanMap(stats));
			row.put("starttime", DateUtil.formatTimestamp(Long.valueOf(stats.getStarttime())));
			result.add(row);
			stats.reset();
		}
	}

	public ReportType getReptype() {
		return ReportType.mongo;
	}

	public void setCountThreshold(int countThreshold) {
		this.countThreshold = countThreshold;
	}

	public void setTimeThreshold(long timeThreshold) {
		this.timeThreshold = timeThreshold;
	}
}