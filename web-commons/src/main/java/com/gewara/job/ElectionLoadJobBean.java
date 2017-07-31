package com.gewara.job;

import java.util.Arrays;
import java.util.List;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gewara.untrans.GewaLeaderLatchListener;
import com.gewara.untrans.LeaderElectionService;
import com.gewara.util.GewaLogger;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;

public class ElectionLoadJobBean implements InitializingBean {

	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	@Autowired@Qualifier("scheduler")
	private Scheduler scheduler;
	
	@Autowired(required=false)@Qualifier("leaderElectionService")
	private LeaderElectionService leaderElectionService;
	
	
	private List<Trigger> triggers;

	@Override
	public void afterPropertiesSet() throws Exception {
		TimerHelper.TIMER.schedule(new Runnable(){
			@Override
			public void run() {
				try {
					registerTriggers();
				} catch (Exception e) {
					dbLogger.error(" registerTriggers error: ", e);
				}
			}			
		}, 30000);
	}

	private void registerTriggers() throws SchedulerException {
		try {
			if (this.triggers != null) {
				for (Trigger trigger : this.triggers) {
					addTriggerToScheduler(trigger);
				}
			}
		}catch (Throwable ex) {
			if (ex instanceof SchedulerException) {
				throw (SchedulerException) ex;
			}
			if (ex instanceof Exception) {
				throw new SchedulerException("Registration of jobs and triggers failed: " + ex.getMessage(), ex);
			}
			throw new SchedulerException("Registration of jobs and triggers failed: " + ex.getMessage());
		}
	}
	
	private boolean addTriggerToScheduler(final Trigger trigger) throws Exception {		
		final JobDetail jobDetail = (JobDetail) trigger.getJobDataMap().remove("jobDetail");
		String electionKey = "eljb." + trigger.getKey().toString();
		leaderElectionService.createElection(electionKey, new GewaLeaderLatchListener(){
			@Override
			public void isLeader() {
				dbLogger.error(trigger.getKey() + ": isLeader");
				try {
					boolean triggerExists = (scheduler.getTrigger(trigger.getKey()) != null);
					if (triggerExists) {
						scheduler.rescheduleJob(trigger.getKey(), trigger);
					}else {						
						if (jobDetail != null && scheduler.getJobDetail(jobDetail.getKey()) == null) {
							scheduler.scheduleJob(jobDetail, trigger);
						}else {
							scheduler.scheduleJob(trigger);
						}						
					}
				} catch (Exception e) {
					dbLogger.error(trigger.getKey() + " scheduled error: ", e);
				}
			}
			
			@Override
			public void notLeader() {
				try {
					dbLogger.error(trigger.getKey() + ": notLeader");
					scheduler.unscheduleJob(trigger.getKey());
				} catch (Exception e) {
					dbLogger.error(trigger.getKey() + " pauseTrigger error: ", e);
				}
			}
		});
		return true;
	}

	public void setTriggers(Trigger... triggers) {
		this.triggers = Arrays.asList(triggers);
	}
}
