/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.job;

import com.gewara.untrans.GewaLeaderLatchListener;
import com.gewara.untrans.LeaderElectionService;
import com.gewara.util.GewaLogger;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ElectionLoadJobBean implements InitializingBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	@Autowired
	@Qualifier("scheduler")
	private Scheduler scheduler;
	@Autowired(required = false)
	@Qualifier("leaderElectionService")
	private LeaderElectionService leaderElectionService;
	private List<Trigger> triggers;

	public void afterPropertiesSet() throws Exception {
		TimerHelper.TIMER.schedule(new Runnable() {
			public void run() {
				try {
					ElectionLoadJobBean.this.registerTriggers();
				} catch (Exception arg1) {
					ElectionLoadJobBean.this.dbLogger.error(" registerTriggers error: ", arg1);
				}

			}
		}, 30000L);
	}

	private void registerTriggers() throws SchedulerException {
		try {
			if (this.triggers != null) {
				Iterator ex = this.triggers.iterator();

				while (ex.hasNext()) {
					Trigger trigger = (Trigger) ex.next();
					this.addTriggerToScheduler(trigger);
				}
			}

		} catch (Throwable arg2) {
			if (arg2 instanceof SchedulerException) {
				throw (SchedulerException) arg2;
			} else if (arg2 instanceof Exception) {
				throw new SchedulerException("Registration of jobs and triggers failed: " + arg2.getMessage(), arg2);
			} else {
				throw new SchedulerException("Registration of jobs and triggers failed: " + arg2.getMessage());
			}
		}
	}

	private boolean addTriggerToScheduler(final Trigger trigger) throws Exception {
		final JobDetail jobDetail = (JobDetail) trigger.getJobDataMap().remove("jobDetail");
		String electionKey = "eljb." + trigger.getKey().toString();
		this.leaderElectionService.createElection(electionKey, new GewaLeaderLatchListener() {
			public void isLeader() {
				ElectionLoadJobBean.this.dbLogger.error(trigger.getKey() + ": isLeader");

				try {
					boolean e = ElectionLoadJobBean.this.scheduler.getTrigger(trigger.getKey()) != null;
					if (e) {
						ElectionLoadJobBean.this.scheduler.rescheduleJob(trigger.getKey(), trigger);
					} else if (jobDetail != null
							&& ElectionLoadJobBean.this.scheduler.getJobDetail(jobDetail.getKey()) == null) {
						ElectionLoadJobBean.this.scheduler.scheduleJob(jobDetail, trigger);
					} else {
						ElectionLoadJobBean.this.scheduler.scheduleJob(trigger);
					}
				} catch (Exception arg1) {
					ElectionLoadJobBean.this.dbLogger.error(trigger.getKey() + " scheduled error: ", arg1);
				}

			}

			public void notLeader() {
				try {
					ElectionLoadJobBean.this.dbLogger.error(trigger.getKey() + ": notLeader");
					ElectionLoadJobBean.this.scheduler.unscheduleJob(trigger.getKey());
				} catch (Exception arg1) {
					ElectionLoadJobBean.this.dbLogger.error(trigger.getKey() + " pauseTrigger error: ", arg1);
				}

			}
		});
		return true;
	}

	public void setTriggers(Trigger... triggers) {
		this.triggers = Arrays.asList(triggers);
	}
}