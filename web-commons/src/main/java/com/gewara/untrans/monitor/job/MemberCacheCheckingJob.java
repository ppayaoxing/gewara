/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.job;

import com.gewara.Config;
import com.gewara.untrans.CacheService;
import com.gewara.untrans.monitor.AbstractSysSelfCheckingJob;

public class MemberCacheCheckingJob extends AbstractSysSelfCheckingJob {
	public String getCheckName() {
		return "MemberCache";
	}

	public String getCheckStatus() {
		String status = "false";

		try {
			CacheService cacheService = (CacheService) this.applicationContext.getBean(CacheService.class);
			String key = Config.SYSTEMID + "," + Config.getHostname() + "MemberCheckingJob";
			String value = key + System.currentTimeMillis();
			cacheService.set("tenMin", key, value);
			Object returnValue = cacheService.get("tenMin", key);
			if (value.equals(returnValue)) {
				status = "true";
			}
		} catch (Exception arg5) {
			;
		}

		return status;
	}
}