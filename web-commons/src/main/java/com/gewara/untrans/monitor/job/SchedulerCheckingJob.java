/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.job;

import com.gewara.untrans.monitor.AbstractSysSelfCheckingJob;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.SchedulerAccessor;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

public class SchedulerCheckingJob extends AbstractSysSelfCheckingJob {
	public String getCheckName() {
		return "TASK";
	}

	public String getCheckStatus() {
		String existsTask = "";

		try {
			SchedulerFactoryBean scheduler = (SchedulerFactoryBean) this.applicationContext
					.getBean(SchedulerFactoryBean.class);
			Field field = SchedulerAccessor.class.getDeclaredField("triggers");
			field.setAccessible(true);
			Object obj = field.get(scheduler);
			if (obj != null) {
				List tgs = (List) obj;

				Trigger trigger;
				for (Iterator arg5 = tgs.iterator(); arg5.hasNext(); existsTask = existsTask + trigger.getKey() + ";") {
					trigger = (Trigger) arg5.next();
				}
			}
		} catch (Exception arg7) {
			;
		}

		if ("".equals(existsTask)) {
			existsTask = "false";
		}

		return existsTask;
	}
}