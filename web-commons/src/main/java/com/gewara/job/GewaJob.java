package com.gewara.job;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;

import com.gewara.Config;
import com.gewara.support.ErrorCode;
import com.gewara.untrans.LeaderElectionService;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.DynamicStats.LogCounter;
import com.gewara.web.support.ResourceStatsUtil;

public class GewaJob implements Job{
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	public static final String LOG_TYPE_JOB = "job";					// 定时任务
	private static boolean init = false;
	private static JobLockService jobLockService;
	private static MonitorService monitorService;
	private static LeaderElectionService leaderElectionService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			GewaJobTrigger trigger = (GewaJobTrigger) context.getTrigger();
			if(!init){
				ApplicationContext ctx = (ApplicationContext) context.getScheduler().getContext().get("SCHEDULERCONTEXTKEY");
				jobLockService = ctx.getBean(JobLockService.class);
				try{
					monitorService = ctx.getBean("monitorService", MonitorService.class);
				}catch(Exception e2){
					dbLogger.warn("No monitorService found!");
				}
				if(trigger.isElectionEnabled()){
					leaderElectionService = ctx.getBean("leaderElectionService", LeaderElectionService.class);
				}				
				init = true;
			}
			if(StringUtils.isNotBlank(trigger.getHostname()) && 
					!StringUtils.contains(trigger.getHostname(), Config.getHostname())){
				//有主机限制，不执行
				dbLogger.warn("host not allowed:" + trigger.getHostname() + ":" + Config.getHostname());
				return;
			}
			Date nextFireTime = trigger.getNextFireTime();
			try {
				//随即sleep，便于其他机器有机会执行
				Thread.sleep(RandomUtils.nextInt(2000));
			} catch (InterruptedException e1) {
			}
			String fullname = trigger.getUniqueName();
			dbLogger.warnWithType(LOG_TYPE_JOB, "start execute job:" + fullname);
			
			String electionKey = trigger.getKey().toString();
			if(trigger.isElectionEnabled() && !leaderElectionService.isLeader(electionKey)){
				dbLogger.warn("locked:" + fullname + ", " + trigger.getKey() + " is not leader, " + trigger.isElectionEnabled() + ":" + leaderElectionService.isLeader(electionKey));
				return;
			}
			
			ErrorCode lock = jobLockService.lockJob(fullname, nextFireTime, Config.getServerIp());
			if(!lock.isSuccess()) {
				dbLogger.warn("locked:" + fullname + "," + lock.getMsg());
				return;
			}
			
			String result = "Y";
			LogCounter lc = null;
			long cur = System.currentTimeMillis();
			try {
				Method m = trigger.getJobService().getClass().getMethod(trigger.getTargetMethod());
				lc = ResourceStatsUtil.getCallStats().beforeProcess(trigger.getUniqueName(), cur);
				m.invoke(trigger.getJobService());
			} catch (Throwable e) {
				dbLogger.error("jobError:" + fullname, e, 200);
				result = "N_ERROR";
				if(monitorService != null){
					monitorService.logException(MonitorService.EXCEPTION_TAG.JOB, fullname, Config.getServerIp() + "@" + fullname + "执行出错:" + DateUtil.getCurFullTimestampStr(), e, null);
				}
			} finally{
				if(lc!=null){
					ResourceStatsUtil.getCallStats().afterProcess(lc, cur, false);
				}
				JobService service = trigger.getJobService();
				String info = service.getExecuteInfo();
				//TODO:info存入数据库
				if(StringUtils.isNotBlank(info)) {
					dbLogger.warn("jobExecuteInfo:" + fullname + "," + info);
				}
				jobLockService.updateStatus(result, fullname, nextFireTime, Config.getServerIp());
			}
		} catch (SchedulerException e) {
			dbLogger.error("SchedulerError", e);
		}
	}
}
