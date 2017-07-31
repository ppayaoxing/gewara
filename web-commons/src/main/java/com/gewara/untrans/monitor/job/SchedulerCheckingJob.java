package com.gewara.untrans.monitor.job;

import java.lang.reflect.Field;
import java.util.List;

import org.quartz.Trigger;
import org.springframework.scheduling.quartz.SchedulerAccessor;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.gewara.untrans.monitor.AbstractSysSelfCheckingJob;

public class SchedulerCheckingJob extends AbstractSysSelfCheckingJob {

	@Override
	public String getCheckName() {
		return "TASK";
	}

	@Override
	public String getCheckStatus() {
		String existsTask = "";
		try {
			SchedulerFactoryBean scheduler = applicationContext.getBean(SchedulerFactoryBean.class);
			Field field = SchedulerAccessor.class.getDeclaredField("triggers");
			field.setAccessible(true);
			Object obj=field.get(scheduler);
			if(obj!=null){
				 List<Trigger> tgs=(List<Trigger>)obj;
				for (Trigger trigger:tgs) {
					existsTask=existsTask + trigger.getKey()+";";
				}
			}
		} catch (Exception e) {
		}
		if("".equals(existsTask)){
			existsTask="false";
		}
		return existsTask;
	}
	

}
