/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.job;

import com.gewara.Config;
import com.gewara.job.JobLockService;
import com.gewara.job.JobService;
import com.gewara.support.TraceErrorException;
import com.gewara.untrans.GewaLeaderLatchListener;
import com.gewara.untrans.LeaderElectionService;
import com.gewara.util.Assert;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ResourceStatsUtil;
import java.util.Date;
import java.util.TimeZone;
import org.quartz.JobDetail;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.ReflectionUtils;

public class GewaJobTrigger extends CronTriggerImpl implements BeanNameAware, InitializingBean {
	private static final long serialVersionUID = 170131506307364822L;
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	@Autowired(required = false)
	@Qualifier("leaderElectionService")
	private LeaderElectionService leaderElectionService;
	private String beanName;
	private JobService jobService;
	private String targetMethod;
	private String uniqueName;
	private String hostname;
	private boolean uniqueByHost;
	private long startDelay;
	private JobDetail jobDetail;
	private boolean electionEnabled = false;

	public void setJobDetail(JobDetail jobDetail) {
		this.getJobDataMap().put("jobDetail", jobDetail);
		this.jobDetail = jobDetail;
	}

	public JobDetail getJobDetail() {
		return this.jobDetail;
	}

	public final void afterPropertiesSet() throws Exception {
		if (this.getName() == null) {
			this.setName(this.beanName);
		}

		if (this.getGroup() == null) {
			this.setGroup("DEFAULT");
		}

		if (this.getStartTime() == null) {
			this.setStartTime(new Date());
		}

		if (this.getTimeZone() == null) {
			this.setTimeZone(TimeZone.getDefault());
		}

		if (this.startDelay > 0L) {
			this.setStartTime(new Date(System.currentTimeMillis() + this.startDelay));
		}

		if (this.jobDetail != null) {
			this.setJobKey(this.jobDetail.getKey());
		}

		this.uniqueName = this.jobService.getServiceName() + "." + this.targetMethod;
		String electionKey;
		if (this.uniqueByHost) {
			electionKey = Config.getHostname();
			int idx = electionKey.indexOf(46);
			if (idx > 0) {
				electionKey = electionKey.substring(0, idx);
			}

			this.uniqueName = this.uniqueName + "@" + electionKey;
		}

		JobLockService.registerConfig(this.uniqueName, this.getCronExpression());
		if (ReflectionUtils.findMethod(this.jobService.getClass(), this.targetMethod) == null) {
			throw new TraceErrorException("job targetMethod not exists:" + this.uniqueName);
		} else {
			ResourceStatsUtil.registerCall(this.uniqueName);
			this.dbLogger
					.warn(Config.getHostname() + ":" + this.getKey() + " electionEnabled = " + this.electionEnabled);
			if (this.electionEnabled) {
				Assert.notNull(this.leaderElectionService, "leaderElectionService required while electionEnabled! ");
				electionKey = this.getKey().toString();
				this.leaderElectionService.createElection(electionKey, new GewaLeaderLatchListener() {
					public void isLeader() {
						GewaJobTrigger.this.dbLogger
								.error(Config.getHostname() + ":" + GewaJobTrigger.this.getKey() + " isLeader");
					}

					public void notLeader() {
						GewaJobTrigger.this.dbLogger
								.error(Config.getHostname() + ":" + GewaJobTrigger.this.getKey() + ": notLeader");
					}
				});
			}

		}
	}

	public String getTargetMethod() {
		return this.targetMethod;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}

	public JobService getJobService() {
		return this.jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	public String getUniqueName() {
		return this.uniqueName;
	}

	public void setBeanName(String name) {
		this.beanName = name;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getHostname() {
		return this.hostname;
	}

	public void setUniqueByHost(boolean uniqueByHost) {
		this.uniqueByHost = uniqueByHost;
	}

	public boolean isElectionEnabled() {
		return this.electionEnabled;
	}

	public void setElectionEnabled(boolean electionEnabled) {
		this.electionEnabled = electionEnabled;
	}
}