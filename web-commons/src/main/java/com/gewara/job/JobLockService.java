/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.job;

import com.gewara.Config;
import com.gewara.job.JobStatsService;
import com.gewara.support.ErrorCode;
import com.gewara.support.TraceErrorException;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

public class JobLockService implements InitializingBean, JobStatsService {
	private final GewaLogger log = WebLogger.getLogger(this.getClass());
	private String jobLockTable = "JOBLOCK";
	private static Map<String, String> configMap = new HashMap();
	private JdbcTemplate jobJdbcTemplate;
	private String queryOld = "select IP from JOBLOCK where JOBNAME = ? and NEXTFIRE = ? ";
	private String insertNew = "insert into JOBLOCK(jobname, firetime, nextfire, ip, status) values (?, ?, ?, ?, ?)";
	private String updateStatus = "update JOBLOCK set STATUS=?, IP=? WHERE JOBNAME = ? and NEXTFIRE = ? ";
	private String statsQuery = "select jobname, status, count(1) as execCount from JOBLOCK where firetime>=? and firetime<? and jobname like ? group by jobname,status";
	private String cleanSql = "delete from JOBLOCK WHERE  firetime < ? and status=\'Y\' ";

	public void setJobLockTable(String jobLockTable) {
		this.jobLockTable = jobLockTable;
	}

	public static void registerConfig(String jobname, String cron) {
		configMap.put(jobname, cron);
	}

	public void setJobJdbcTemplate(JdbcTemplate jobJdbcTemplate) {
		this.jobJdbcTemplate = jobJdbcTemplate;
	}

	public ErrorCode lockJob(String jobName, Date nextFireTime, String ip) {
		String newnext = DateUtil.format(nextFireTime, "yyyyMMddHHmmss");
		String firetime = DateUtil.format(new Date(), "yyyyMMddHHmmss");

		try {
			List e = this.jobJdbcTemplate.queryForList(this.queryOld, String.class, new Object[]{jobName, newnext});
			if (e.size() > 0) {
				return ErrorCode.getFailure((String) e.get(0));
			} else {
				int rows = this.jobJdbcTemplate.update(this.insertNew,
						new Object[]{jobName, firetime, newnext, ip, "N"});
				return rows > 0 ? ErrorCode.SUCCESS : ErrorCode.getFailure("被其他锁定!");
			}
		} catch (DuplicateKeyException arg7) {
			return ErrorCode.getFailure("被其他锁定!");
		} catch (Throwable arg8) {
			this.log.warn("", arg8, 200);
			return ErrorCode.getFailure("插入错误!");
		}
	}

	public void updateStatus(String status, String jobName, Date nextFireTime, String ip) {
		String newnext = DateUtil.format(nextFireTime, "yyyyMMddHHmmss");
		this.jobJdbcTemplate.update(this.updateStatus, new Object[]{status, ip, jobName, newnext});
	}

	public List<Map<String, Object>> getJobStatsList(Timestamp from, Timestamp to) {
		List rows = this.jobJdbcTemplate.queryForList(this.statsQuery, new Object[]{
				DateUtil.format(from, "yyyyMMddHHmmss"), DateUtil.format(to, "yyyyMMddHHmmss"), Config.SYSTEMID + "%"});
		return rows;
	}

	public void afterPropertiesSet() throws Exception {
		if (StringUtils.isBlank(this.jobLockTable)) {
			throw new TraceErrorException("jobLockTable cannot be null!");
		} else {
			if (!StringUtils.equals(this.jobLockTable, "JOBLOCK")) {
				this.queryOld = "select IP from " + this.jobLockTable + " where JOBNAME = ? and NEXTFIRE = ? ";
				this.insertNew = "insert into " + this.jobLockTable
						+ "(jobname, firetime, nextfire, ip, status) values (?, ?, ?, ?, ?)";
				this.updateStatus = "update " + this.jobLockTable
						+ " set STATUS=?, IP=? WHERE JOBNAME = ? and NEXTFIRE = ? ";
				this.statsQuery = "select jobname, status, count(1) as count from " + this.jobLockTable
						+ " where firetime>=? and firetime<? and jobname like ? group by jobname,status";
				this.cleanSql = "delete from " + this.jobLockTable + " WHERE  firetime < ? and status=\'Y\' ";
			}

			TimerHelper.TIMER.scheduleAtFixedRate(new Runnable() {
				public void run() {
					Timestamp next = (Timestamp) DateUtil.addHour(DateUtil.getCurTruncTimestamp(), 25);
					ErrorCode result = JobLockService.this.lockJob("cleanJoblockData", next, Config.getServerIp());
					if (result.isSuccess()) {
						String last = DateUtil.format(DateUtil.addDay(DateUtil.getCurDate(), -3), "yyyyMMddHHmmss");

						try {
							int e = JobLockService.this.jobJdbcTemplate.update(JobLockService.this.cleanSql,
									new Object[]{last});
							JobLockService.this.log.warn("cleanJobLock:" + e);
							JobLockService.this.updateStatus("Y", "cleanJoblockData", next, Config.getServerIp());
						} catch (Exception arg4) {
							JobLockService.this.log.warn("cleanJobLock:", arg4, 50);
							JobLockService.this.updateStatus("N_ERR", "cleanJoblockData", next, Config.getServerIp());
						}
					} else {
						JobLockService.this.log.warn("cleanJobLock:locked by other");
					}

				}
			}, DateUtil.addHour(DateUtil.getCurTruncTimestamp(), 25), 86400000L);
		}
	}

	public Map<String, String> getJobConfig() {
		return new HashMap(configMap);
	}
}