/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.impl;

import com.gewara.Config;
import com.gewara.untrans.monitor.SysSelfCheckingJob;
import com.gewara.untrans.monitor.SysSelfCheckingService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SysSelfCheckingServiceImpl implements SysSelfCheckingService {
	List<SysSelfCheckingJob> jobList = null;

	public SysSelfCheckingServiceImpl(List<SysSelfCheckingJob> jobList) {
		this.jobList = jobList;
	}

	public Map<String, String> checkSysStatus() {
		LinkedHashMap map = new LinkedHashMap();
		map.put("Server", Config.SYSTEMID + "," + Config.getHostname());
		String gewaraconfig = System.getProperty("GEWACONFIG");
		if (gewaraconfig == null) {
			gewaraconfig = System.getProperty(Config.SYSTEMID + "-GEWACONFIG");
		}

		map.put("GEWACONFIG", gewaraconfig);
		Iterator arg2 = this.jobList.iterator();

		while (arg2.hasNext()) {
			SysSelfCheckingJob job = (SysSelfCheckingJob) arg2.next();

			try {
				map.put(job.getCheckName(), job.getCheckStatus());
			} catch (Exception arg5) {
				;
			}
		}

		return map;
	}
}