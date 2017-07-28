/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.monitor;

import com.gewara.monitor.ReportType;
import java.util.List;
import java.util.Map;

public interface DataReport {
	List<Map<String, String>> getReportData();

	ReportType getReptype();
}