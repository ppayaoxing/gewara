package com.gewara.job;

import java.util.Date;
import java.util.TimeZone;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.ReflectionUtils;

import com.gewara.Config;
import com.gewara.support.TraceErrorException;
import com.gewara.untrans.GewaLeaderLatchListener;
import com.gewara.untrans.LeaderElectionService;
import com.gewara.util.Assert;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ResourceStatsUtil;

public class GewaJobTrigger extends CronTriggerImpl implements BeanNameAware, InitializingBean{
	private static final long serialVersionUID = 170131506307364822L;

	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	@Autowired(required=false)@Qualifier("leaderElectionService")
	private LeaderElectionService leaderElectionService;
	
	private String beanName;
	private JobService jobService;
	private String targetMethod;
	private String uniqueName;
	private String hostname;			//只在某台机器上执行
	private boolean uniqueByHost;		//计算uniqueName加上host
	private long startDelay;
	private JobDetail jobDetail;
	
	private boolean electionEnabled = false; //是否可以通过使用选举来决定哪台机器执行, 默认不允许
	
	public void setJobDetail(JobDetail jobDetail) {
		this.getJobDataMap().put("jobDetail", jobDetail);
		this.jobDetail = jobDetail;
	}

	public JobDetail getJobDetail() {
		return this.jobDetail;
	}
	
	@Override
	public final void afterPropertiesSet() throws Exception {
		if (getName() == null) {
			setName(this.beanName);
		}
		if (getGroup() == null) {
			setGroup(Scheduler.DEFAULT_GROUP);
		}
		if (getStartTime() == null) {
			setStartTime(new Date());
		}
		if (getTimeZone() == null) {
			setTimeZone(TimeZone.getDefault());
		}
		if (this.startDelay > 0) {
			setStartTime(new Date(System.currentTimeMillis() + this.startDelay));
		}
		if (this.jobDetail!=null){
			setJobKey(jobDetail.getKey());
		}
		uniqueName = jobService.getServiceName() + "." + targetMethod;
		if(uniqueByHost){
			String host = Config.getHostname();
			int idx = host.indexOf('.');
			if(idx>0){
				host=host.substring(0, idx);
			}
			uniqueName += "@"+host;
		}
		JobLockService.registerConfig(uniqueName, this.getCronExpression());
		if(ReflectionUtils.findMethod(jobService.getClass(), targetMethod)==null){
			throw new TraceErrorException("job targetMethod not exists:" + uniqueName);
		}
		ResourceStatsUtil.registerCall(uniqueName);
		

		dbLogger.warn(Config.getHostname() + ":" + getKey() + " electionEnabled = " + electionEnabled);
		if(electionEnabled){
			Assert.notNull(leaderElectionService, "leaderElectionService required while electionEnabled! ");
			String electionKey = getKey().toString();
			leaderElectionService.createElection(electionKey, new GewaLeaderLatchListener(){
				@Override
				public void isLeader() {
					dbLogger.error(Config.getHostname() + ":" + getKey() + " isLeader");
				}
				
				@Override
				public void notLeader() {
					dbLogger.error(Config.getHostname() + ":" + getKey() + ": notLeader");
				}
			});
		}
	}
	public String getTargetMethod() {
		return targetMethod;
	}
	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}
	public JobService getJobService() {
		return jobService;
	}
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}
	public String getUniqueName() {
		return uniqueName;
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;		
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getHostname() {
		return hostname;
	}

	public void setUniqueByHost(boolean uniqueByHost) {
		this.uniqueByHost = uniqueByHost;
	}

	public boolean isElectionEnabled() {
		return electionEnabled;
	}

	public void setElectionEnabled(boolean electionEnabled) {
		this.electionEnabled = electionEnabled;
	}
}
