package com.gewara.untrans.monitor.job;

import com.gewara.Config;
import com.gewara.untrans.CacheService;
import com.gewara.untrans.monitor.AbstractSysSelfCheckingJob;

public class MemberCacheCheckingJob extends AbstractSysSelfCheckingJob {

	@Override
	public String getCheckName() {
		return "MemberCache";
	}

	@Override
	public String getCheckStatus() {
		String status="false";
		try {
			CacheService cacheService = applicationContext.getBean(CacheService.class);
			String key=Config.SYSTEMID + "," + Config.getHostname()+"MemberCheckingJob";
			String value=key+System.currentTimeMillis();
			cacheService.set(CacheService.REGION_TENMIN, key, value);
			Object returnValue=cacheService.get(CacheService.REGION_TENMIN, key);
			if(value.equals(returnValue)){
				status="true";
			}
		} catch (Exception e) {
		}
		return status;
	}
	

}
