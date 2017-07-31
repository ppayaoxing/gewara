package com.gewara.untrans.monitor.job;

import com.gewara.untrans.monitor.AbstractSysSelfCheckingJob;

public class RegionCacheCheckingJob extends AbstractSysSelfCheckingJob {

	private String regionName = "halfDay";

	@Override
	public String getCheckName() {
		return "RegionCache";
	}

	@Override
	public String getCheckStatus() {
		return "true";
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}
