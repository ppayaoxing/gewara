package com.gewara.support.magent;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

import com.gewara.Config;
import com.gewara.monitor.DataReport;
import com.gewara.monitor.JVMHelper;
import com.gewara.monitor.ReportType;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.untrans.monitor.SysLogType;
import com.gewara.util.Assert;
import com.gewara.util.BeanUtil;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.JsonUtils;
import com.gewara.util.LoggerUtils;
import com.gewara.util.ServiceCacheHelper;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ResourceStatsUtil;

public class DataReportAgent implements InitializingBean{
	private GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private int sendThreshold = 5;		//请求数上报阀值

	private int dumpThreshold = 100;	//dump线程请求数阀值
	private int cacheThreshold = 2000;	//
	private int exceptionThreshold = 20;//
	private String threadDumpDir;
	
	private List<DataReport> extDataReportList = new ArrayList<DataReport>();
	public void setExtDataReportList(List<DataReport> extDataReportList) {
		this.extDataReportList = extDataReportList;
	}
	
	private MonitorService monitorService;
	public void setMonitorService(MonitorService monitorService) {
		this.monitorService = monitorService;
	}
	
	public void setDumpThreshold(int dumpThreshold) {
		this.dumpThreshold = dumpThreshold;
	}
	public void setExceptionThreshold(int exceptionThreshold) {
		this.exceptionThreshold = exceptionThreshold;
	}
	
	public void setThreadDumpDir(String threadDumpDir) {
		this.threadDumpDir = threadDumpDir;
	}
	private Long lastreport = System.currentTimeMillis();// 上次瓶颈上报数据

	private int processCount = 0;

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(monitorService);
		TimerHelper.TIMER.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				processDubboReq();
			}
		}, DateUtil.m_minute * 5, DateUtil.m_minute*10);

		TimerHelper.TIMER.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				processCount++;
				processRequest();
				processException();
				processJms();
				processServiceCache();
				processPageCache();
				processDubbo();
				processErrorStats();
				if(extDataReportList!=null && !extDataReportList.isEmpty()){
					for(DataReport report: extDataReportList){
						try{
							List<Map<String, String>> dataList = report.getReportData();
							if(dataList!=null && !dataList.isEmpty()){
								Map<String, String> data = new HashMap<String, String>();
								data.put("rowList", "" + JsonUtils.writeObjectToJson(dataList));
								reportData(data, report.getReptype());
							}
						}catch(Exception e){
							dbLogger.warn(e, 10);
						}
					}
				}
			}
		}, DateUtil.m_minute, DateUtil.m_second*30);
	}
	private void processErrorStats(){
		List<Map<String, String>> statsList = ResourceStatsUtil.getErrorStats().getAllStatsAndClear(20);
		for(Map<String, String> stats: statsList){
			reportData(stats, ReportType.error);
		}
		
	}
	private void processDubboReq(){
		List<Map<String, String>> statsList = ResourceStatsUtil.getApiMethodStats().getAllStatsAndClear(2000);
		for(Map<String, String> stats: statsList){
			reportData(stats, ReportType.dubboReq);
		}
	}
	
	private void processRequest() {
		try {
			int reqnum = ResourceStatsUtil.getUriStats().getTotalProcessing();
			if (reqnum >= sendThreshold) {
				Map<String, String> req = new HashMap<String, String>();
				req.put("reqnum", "" + reqnum);
				reportData(req, ReportType.reqnum);
			}
			if (reqnum >= dumpThreshold && lastreport < System.currentTimeMillis() - DateUtil.m_minute * 5) {
				lastreport = System.currentTimeMillis();

				// dump数据并上报
				String fileName = Config.getHostname() + "_" + Config.SYSTEMID.toLowerCase() + "_" + DateUtil.format(new Date(), "yyyyMMddHHmmss") + ".tdump";
				Map<String, String> data = JVMHelper.exportThreadToFile(threadDumpDir, fileName);
				reportData(data, ReportType.jvmdump);

				// reqstats
				String reqFileName = "req_" + Config.getHostname() + "_" + Config.SYSTEMID.toLowerCase() + "_" + DateUtil.format(new Date(), "yyyyMMddHHmmss") + ".json";
				Map<String, String> data2 = WebContainerUtils.exportRequestToFile(threadDumpDir, reqFileName);
				data2.put("reqnum", "" + reqnum);
				reportData(data2, ReportType.reqstats);
			}
		} catch (Throwable e) {
			dbLogger.warn("", e, 20);
		}
	}
	
	private void processDubbo(){
		try {
			int reqnum = ResourceStatsUtil.getApiMethodStats().getTotalProcessing();
			if (reqnum >= sendThreshold) {
				Map<String, String> req = new HashMap<String, String>();
				req.put("reqnum", "" + reqnum);
				reportData(req, ReportType.dubbonum);
			}
		} catch (Throwable e) {
			dbLogger.warn("", e, 20);
		}
	}
	
	private void processJms() {
		try {
			int jmsnum = ResourceStatsUtil.getJmsStats().getTotalProcessing();
			if (jmsnum >= sendThreshold) {
				Map<String, String> req = new HashMap<String, String>();
				req.put("jmsnum", "" + jmsnum);
				reportData(req, ReportType.jmsnum);
			}
		} catch (Throwable e) {
			dbLogger.warn("", e, 20);
		}
	}
	private void processServiceCache() {
		try {
			List<ServiceCacheHelper> schList = ResourceStatsUtil.getServiceCacheHelperList();
			for(ServiceCacheHelper sch: schList){
				Map statsMap = sch.getAndResetStats();
				if(statsMap!=null){
					Map<String, String> req = BeanUtil.toSimpleStringMap(statsMap);
					reportData(req, ReportType.scache);
				}
			}
		} catch (Throwable e) {
			dbLogger.warn("", e, 20);
		}
	}
	private void processPageCache() {
		try {
			int cachenum = ResourceStatsUtil.getPageCacheStats().getTotalProcessing();
			if (cachenum >= cacheThreshold) {
				long cur = System.currentTimeMillis();
				Map<String, Integer> statsMap = ResourceStatsUtil.getPageCacheStats().getStatsMap();
				Map<String, String> req = BeanUtil.toSimpleStringMap(statsMap);
				for(Map.Entry<String, Integer> row: statsMap.entrySet()){
					ResourceStatsUtil.getPageCacheStats().updateProcessTime(row.getKey(), cur, 10);
					if(row.getValue() < 10){
						req.remove(row.getKey());
					}
				}
				reportData(req, ReportType.pcache);
			}
		} catch (Throwable e) {
			dbLogger.warn("", e, 20);
		}
	}

	private void processException() {
		try {
			int critical = LoggerUtils.getCriticalExceptionCount();
			if (critical > exceptionThreshold || LoggerUtils.getSingleMax() > 2 && processCount % 20 == 0/* 10分钟上报一次 */) {
				long lasttime = LoggerUtils.getExceptionTimefrom();
				Map<String, Integer> countMap = LoggerUtils.resetExceptionCount();
				Map<String, String> data = new HashMap<String, String>();
				data.put("total", "" + critical);
				data.put("timefrom", DateUtil.formatTimestamp(lasttime));
				data.put("timeto", DateUtil.formatTimestamp(System.currentTimeMillis()));
				data.put("countMap", JsonUtils.writeMapToJson(BeanUtil.toSimpleStringMap(countMap)));
				reportData(data, ReportType.exception);
			}
		} catch (Throwable e) {
			dbLogger.warn("", e, 20);
		}

	}


	public void reportData(Map<String, String> data, ReportType reptype) {
		data.put("srcsystem", Config.SYSTEMID);
		data.put("hostname", Config.getHostname());
		data.put("reptype", reptype.name());
		String rowListStr = data.remove("rowList");
		if(StringUtils.isNotBlank(rowListStr)){
			List<Map> rowList = JsonUtils.readJsonToObjectList(Map.class, rowListStr);
			for(Map row: rowList){
				row.putAll(data);
				monitorService.addSysLog(SysLogType.monitor, row);
			}
		}else{
			monitorService.addSysLog(SysLogType.monitor, data);
		}
	}
}
