/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.job;

import com.gewara.Config;
import com.gewara.job.GewaJobTrigger;
import com.gewara.job.JobLockService;
import com.gewara.job.JobService;
import com.gewara.support.ErrorCode;
import com.gewara.untrans.LeaderElectionService;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.untrans.monitor.MonitorService.EXCEPTION_TAG;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ResourceStatsUtil;
import com.gewara.web.support.DynamicStats.LogCounter;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;

public class GewaJob implements Job {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	public static final String LOG_TYPE_JOB = "job";
	private static boolean init = false;
	private static JobLockService jobLockService;
	private static MonitorService monitorService;
	private static LeaderElectionService leaderElectionService;

	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			GewaJobTrigger e = (GewaJobTrigger) context.getTrigger();
			if (!init) {
				ApplicationContext nextFireTime = (ApplicationContext) context.getScheduler().getContext()
						.get("SCHEDULERCONTEXTKEY");
				jobLockService = (JobLockService) nextFireTime.getBean(JobLockService.class);

				try {
					monitorService = (MonitorService) nextFireTime.getBean("monitorService", MonitorService.class);
				} catch (Exception arg22) {
					this.dbLogger.warn("No monitorService found!");
				}

				if (e.isElectionEnabled()) {
					leaderElectionService = (LeaderElectionService) nextFireTime.getBean("leaderElectionService",
							LeaderElectionService.class);
				}

				init = true;
			}

			if (StringUtils.isNotBlank(e.getHostname())
					&& !StringUtils.contains(e.getHostname(), Config.getHostname())) {
				this.dbLogger.warn("host not allowed:" + e.getHostname() + ":" + Config.getHostname());
				return;
			}

			Date nextFireTime1 = e.getNextFireTime();

			try {
				Thread.sleep((long) RandomUtils.nextInt(2000));
			} catch (InterruptedException arg21) {
				;
			}

			String fullname = e.getUniqueName();
			this.dbLogger.warnWithType("job", "start execute job:" + fullname);
			String electionKey = e.getKey().toString();
			if (e.isElectionEnabled() && !leaderElectionService.isLeader(electionKey)) {
				this.dbLogger.warn("locked:" + fullname + ", " + e.getKey() + " is not leader, " + e.isElectionEnabled()
						+ ":" + leaderElectionService.isLeader(electionKey));
				return;
			}

			ErrorCode lock = jobLockService.lockJob(fullname, nextFireTime1, Config.getServerIp());
			if (!lock.isSuccess()) {
				this.dbLogger.warn("locked:" + fullname + "," + lock.getMsg());
				return;
			}

			String result = "Y";
			LogCounter lc = null;
			long cur = System.currentTimeMillis();
			boolean arg20 = false;

			String info;
			JobService service2;
			label205 : {
				try {
					arg20 = true;
					Method service = e.getJobService().getClass().getMethod(e.getTargetMethod(), new Class[0]);
					lc = ResourceStatsUtil.getCallStats().beforeProcess(e.getUniqueName(), cur);
					service.invoke(e.getJobService(), new Object[0]);
					arg20 = false;
					break label205;
				} catch (Throwable arg23) {
					this.dbLogger.error("jobError:" + fullname, arg23, 200);
					result = "N_ERROR";
					if (monitorService != null) {
						monitorService.logException(EXCEPTION_TAG.JOB, fullname,
								Config.getServerIp() + "@" + fullname + "执行出错:" + DateUtil.getCurFullTimestampStr(),
								arg23, (Map) null);
						arg20 = false;
					} else {
						arg20 = false;
					}
				} finally {
					if (arg20) {
						if (lc != null) {
							ResourceStatsUtil.getCallStats().afterProcess(lc, cur, false);
						}

						JobService service1 = e.getJobService();
						String info1 = service1.getExecuteInfo();
						if (StringUtils.isNotBlank(info1)) {
							this.dbLogger.warn("jobExecuteInfo:" + fullname + "," + info1);
						}

						jobLockService.updateStatus(result, fullname, nextFireTime1, Config.getServerIp());
					}
				}

				if (lc != null) {
					ResourceStatsUtil.getCallStats().afterProcess(lc, cur, false);
				}

				service2 = e.getJobService();
				info = service2.getExecuteInfo();
				if (StringUtils.isNotBlank(info)) {
					this.dbLogger.warn("jobExecuteInfo:" + fullname + "," + info);
				}

				jobLockService.updateStatus(result, fullname, nextFireTime1, Config.getServerIp());
				return;
			}

			if (lc != null) {
				ResourceStatsUtil.getCallStats().afterProcess(lc, cur, false);
			}

			service2 = e.getJobService();
			info = service2.getExecuteInfo();
			if (StringUtils.isNotBlank(info)) {
				this.dbLogger.warn("jobExecuteInfo:" + fullname + "," + info);
			}

			jobLockService.updateStatus(result, fullname, nextFireTime1, Config.getServerIp());
		} catch (SchedulerException arg25) {
			this.dbLogger.error("SchedulerError", arg25);
		}

	}
}