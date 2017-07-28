/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.magent;

import com.gewara.Config;
import com.gewara.monitor.DataReport;
import com.gewara.monitor.JVMHelper;
import com.gewara.monitor.ReportType;
import com.gewara.support.magent.WebContainerUtils;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

public class DataReportAgent implements InitializingBean {
	private GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private int sendThreshold = 5;
	private int dumpThreshold = 100;
	private int cacheThreshold = 2000;
	private int exceptionThreshold = 20;
	private String threadDumpDir;
	private List<DataReport> extDataReportList = new ArrayList();
	private MonitorService monitorService;
	private Long lastreport = Long.valueOf(System.currentTimeMillis());
	private int processCount = 0;

	public void setExtDataReportList(List<DataReport> extDataReportList) {
		this.extDataReportList = extDataReportList;
	}

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

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.monitorService);
		TimerHelper.TIMER.scheduleWithFixedDelay(new Runnable() {
			public void run() {
				DataReportAgent.this.processDubboReq();
			}
		}, 300000L, 600000L);
		TimerHelper.TIMER.scheduleWithFixedDelay(new Runnable() {
			public void run() {
				DataReportAgent.this.processCount++;
				DataReportAgent.this.processRequest();
				DataReportAgent.this.processException();
				DataReportAgent.this.processJms();
				DataReportAgent.this.processServiceCache();
				DataReportAgent.this.processPageCache();
				DataReportAgent.this.processDubbo();
				DataReportAgent.this.processErrorStats();
				if (DataReportAgent.this.extDataReportList != null
						&& !DataReportAgent.this.extDataReportList.isEmpty()) {
					Iterator arg0 = DataReportAgent.this.extDataReportList.iterator();

					while (arg0.hasNext()) {
						DataReport report = (DataReport) arg0.next();

						try {
							List e = report.getReportData();
							if (e != null && !e.isEmpty()) {
								HashMap data = new HashMap();
								data.put("rowList", "" + JsonUtils.writeObjectToJson(e));
								DataReportAgent.this.reportData(data, report.getReptype());
							}
						} catch (Exception arg4) {
							DataReportAgent.this.dbLogger.warn(arg4, 10);
						}
					}
				}

			}
		}, 60000L, 30000L);
	}

	private void processErrorStats() {
		List statsList = ResourceStatsUtil.getErrorStats().getAllStatsAndClear(20);
		Iterator arg1 = statsList.iterator();

		while (arg1.hasNext()) {
			Map stats = (Map) arg1.next();
			this.reportData(stats, ReportType.error);
		}

	}

	private void processDubboReq() {
		List statsList = ResourceStatsUtil.getApiMethodStats().getAllStatsAndClear(2000);
		Iterator arg1 = statsList.iterator();

		while (arg1.hasNext()) {
			Map stats = (Map) arg1.next();
			this.reportData(stats, ReportType.dubboReq);
		}

	}

	private void processRequest() {
		try {
			int e = ResourceStatsUtil.getUriStats().getTotalProcessing();
			if (e >= this.sendThreshold) {
				HashMap fileName = new HashMap();
				fileName.put("reqnum", "" + e);
				this.reportData(fileName, ReportType.reqnum);
			}

			if (e >= this.dumpThreshold && this.lastreport.longValue() < System.currentTimeMillis() - 300000L) {
				this.lastreport = Long.valueOf(System.currentTimeMillis());
				String fileName1 = Config.getHostname() + "_" + Config.SYSTEMID.toLowerCase() + "_"
						+ DateUtil.format(new Date(), "yyyyMMddHHmmss") + ".tdump";
				Map data = JVMHelper.exportThreadToFile(this.threadDumpDir, fileName1);
				this.reportData(data, ReportType.jvmdump);
				String reqFileName = "req_" + Config.getHostname() + "_" + Config.SYSTEMID.toLowerCase() + "_"
						+ DateUtil.format(new Date(), "yyyyMMddHHmmss") + ".json";
				Map data2 = WebContainerUtils.exportRequestToFile(this.threadDumpDir, reqFileName);
				data2.put("reqnum", "" + e);
				this.reportData(data2, ReportType.reqstats);
			}
		} catch (Throwable arg5) {
			this.dbLogger.warn("", arg5, 20);
		}

	}

	private void processDubbo() {
		try {
			int e = ResourceStatsUtil.getApiMethodStats().getTotalProcessing();
			if (e >= this.sendThreshold) {
				HashMap req = new HashMap();
				req.put("reqnum", "" + e);
				this.reportData(req, ReportType.dubbonum);
			}
		} catch (Throwable arg2) {
			this.dbLogger.warn("", arg2, 20);
		}

	}

	private void processJms() {
		try {
			int e = ResourceStatsUtil.getJmsStats().getTotalProcessing();
			if (e >= this.sendThreshold) {
				HashMap req = new HashMap();
				req.put("jmsnum", "" + e);
				this.reportData(req, ReportType.jmsnum);
			}
		} catch (Throwable arg2) {
			this.dbLogger.warn("", arg2, 20);
		}

	}

	private void processServiceCache() {
		try {
			List e = ResourceStatsUtil.getServiceCacheHelperList();
			Iterator arg1 = e.iterator();

			while (arg1.hasNext()) {
				ServiceCacheHelper sch = (ServiceCacheHelper) arg1.next();
				Map statsMap = sch.getAndResetStats();
				if (statsMap != null) {
					Map req = BeanUtil.toSimpleStringMap(statsMap);
					this.reportData(req, ReportType.scache);
				}
			}
		} catch (Throwable arg5) {
			this.dbLogger.warn("", arg5, 20);
		}

	}

	private void processPageCache() {
		try {
			int e = ResourceStatsUtil.getPageCacheStats().getTotalProcessing();
			if (e >= this.cacheThreshold) {
				long cur = System.currentTimeMillis();
				Map statsMap = ResourceStatsUtil.getPageCacheStats().getStatsMap();
				Map req = BeanUtil.toSimpleStringMap(statsMap);
				Iterator arg5 = statsMap.entrySet().iterator();

				while (arg5.hasNext()) {
					Entry row = (Entry) arg5.next();
					ResourceStatsUtil.getPageCacheStats().updateProcessTime((String) row.getKey(), cur, 10);
					if (((Integer) row.getValue()).intValue() < 10) {
						req.remove(row.getKey());
					}
				}

				this.reportData(req, ReportType.pcache);
			}
		} catch (Throwable arg7) {
			this.dbLogger.warn("", arg7, 20);
		}

	}

	private void processException() {
		try {
			int e = LoggerUtils.getCriticalExceptionCount();
			if (e > this.exceptionThreshold || LoggerUtils.getSingleMax() > 2 && this.processCount % 20 == 0) {
				long lasttime = LoggerUtils.getExceptionTimefrom().longValue();
				Map countMap = LoggerUtils.resetExceptionCount();
				HashMap data = new HashMap();
				data.put("total", "" + e);
				data.put("timefrom", DateUtil.formatTimestamp(Long.valueOf(lasttime)));
				data.put("timeto", DateUtil.formatTimestamp(Long.valueOf(System.currentTimeMillis())));
				data.put("countMap", JsonUtils.writeMapToJson(BeanUtil.toSimpleStringMap(countMap)));
				this.reportData(data, ReportType.exception);
			}
		} catch (Throwable arg5) {
			this.dbLogger.warn("", arg5, 20);
		}

	}

	public void reportData(Map<String, String> data, ReportType reptype) {
		data.put("srcsystem", Config.SYSTEMID);
		data.put("hostname", Config.getHostname());
		data.put("reptype", reptype.name());
		String rowListStr = (String) data.remove("rowList");
		if (StringUtils.isNotBlank(rowListStr)) {
			List rowList = JsonUtils.readJsonToObjectList(Map.class, rowListStr);
			Iterator arg4 = rowList.iterator();

			while (arg4.hasNext()) {
				Map row = (Map) arg4.next();
				row.putAll(data);
				this.monitorService.addSysLog(SysLogType.monitor, row);
			}
		} else {
			this.monitorService.addSysLog(SysLogType.monitor, data);
		}

	}
}