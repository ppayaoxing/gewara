/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.job;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface JobStatsService {
	List<Map<String, Object>> getJobStatsList(Timestamp arg0, Timestamp arg1);

	Map<String, String> getJobConfig();
}