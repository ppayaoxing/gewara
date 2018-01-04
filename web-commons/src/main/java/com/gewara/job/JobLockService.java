package com.gewara.job;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gewara.Config;
import com.gewara.support.ErrorCode;
import com.gewara.support.TraceErrorException;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;

public class JobLockService implements InitializingBean, JobStatsService {
	private final GewaLogger log = WebLogger.getLogger(getClass());
	private String jobLockTable = "JOBLOCK";
	public void setJobLockTable(String jobLockTable) {
		this.jobLockTable = jobLockTable;
	}
	private static Map<String, String> configMap = new HashMap<String, String>();
	public static void registerConfig(String jobname, String cron){
		configMap.put(jobname, cron);
	}
	private JdbcTemplate jobJdbcTemplate;
	public void setJobJdbcTemplate(JdbcTemplate jobJdbcTemplate) {
		this.jobJdbcTemplate = jobJdbcTemplate;
	}
	
	private String queryOld = "select IP from JOBLOCK where JOBNAME = ? and NEXTFIRE = ? ";
	private String insertNew = "insert into JOBLOCK(jobname, firetime, nextfire, ip, status) values (?, ?, ?, ?, ?)";
	private String updateStatus = "update JOBLOCK set STATUS=?, IP=? WHERE JOBNAME = ? and NEXTFIRE = ? ";
	private String statsQuery = "select jobname, status, count(1) as execCount from JOBLOCK where firetime>=? and firetime<? and jobname like ? group by jobname,status";
	private String cleanSql = "delete from JOBLOCK WHERE  firetime < ? and status='Y' ";
	public ErrorCode lockJob(String jobName, Date nextFireTime, String ip){
		String newnext = DateUtil.format(nextFireTime, "yyyyMMddHHmmss");
		String firetime = DateUtil.format(new Date(), "yyyyMMddHHmmss");
		try{
			List<String> oldjob = jobJdbcTemplate.queryForList(queryOld, String.class, jobName, newnext);
			if(oldjob.size() > 0) {
                return ErrorCode.getFailure(oldjob.get(0));
            }
			int rows = jobJdbcTemplate.update(insertNew, jobName, firetime, newnext, ip, "N");
			if(rows >0) {
                return ErrorCode.SUCCESS;
            }
			return ErrorCode.getFailure("����������!");
		}catch(DuplicateKeyException e){
			return ErrorCode.getFailure("����������!");
		}catch(Throwable e){
			log.warn("", e, 200);
			return ErrorCode.getFailure("�������!");
		}
	}
	public void updateStatus(String status, String jobName, Date nextFireTime, String ip){
		String newnext = DateUtil.format(nextFireTime, "yyyyMMddHHmmss");
		jobJdbcTemplate.update(updateStatus, status, ip, jobName, newnext);
	}
	@Override
	public List<Map<String, Object>> getJobStatsList(Timestamp from, Timestamp to){
		List<Map<String, Object>> rows = jobJdbcTemplate.queryForList(statsQuery, DateUtil.format(from,  "yyyyMMddHHmmss"), DateUtil.format(to,  "yyyyMMddHHmmss"), Config.SYSTEMID+"%");
		return rows;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		if(StringUtils.isBlank(jobLockTable)) {
            throw new TraceErrorException("jobLockTable cannot be null!");
        }
		if(!StringUtils.equals(jobLockTable, "JOBLOCK")){
			queryOld = "select IP from " + jobLockTable + " where JOBNAME = ? and NEXTFIRE = ? ";
			insertNew = "insert into " + jobLockTable + "(jobname, firetime, nextfire, ip, status) values (?, ?, ?, ?, ?)";
			updateStatus = "update " + jobLockTable + " set STATUS=?, IP=? WHERE JOBNAME = ? and NEXTFIRE = ? ";
			statsQuery = "select jobname, status, count(1) as count from " + jobLockTable + " where firetime>=? and firetime<? and jobname like ? group by jobname,status";
			cleanSql = "delete from " + jobLockTable + " WHERE  firetime < ? and status='Y' ";
		}
		TimerHelper.TIMER.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run() {
				Timestamp next = DateUtil.addHour(DateUtil.getCurTruncTimestamp(), 25);
				ErrorCode result = lockJob("cleanJoblockData", next, Config.getServerIp());
				if(result.isSuccess()){
					String last = DateUtil.format(DateUtil.addDay(DateUtil.getCurDate(), -3), "yyyyMMddHHmmss");
					try{
						int count = jobJdbcTemplate.update(cleanSql, last);
						log.warn("cleanJobLock:" + count);
						updateStatus("Y", "cleanJoblockData", next, Config.getServerIp());
					}catch(Exception e){
						log.warn("cleanJobLock:", e, 50);
						updateStatus("N_ERR", "cleanJoblockData", next, Config.getServerIp());
					}
				}else{
					log.warn("cleanJobLock:locked by other");
				}
			}
		}, DateUtil.addHour(DateUtil.getCurTruncTimestamp(),  25), DateUtil.m_day);
	}
	@Override
	public Map<String, String> getJobConfig() {
		return new HashMap<String, String>(configMap);
	}
}
