/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.job;

import com.gewara.untrans.monitor.AbstractSysSelfCheckingJob;

public class RegionCacheCheckingJob extends AbstractSysSelfCheckingJob {
	private String regionName = "halfDay";

	public String getCheckName() {
		return "RegionCache";
	}

	public String getCheckStatus() {
		return "true";
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}