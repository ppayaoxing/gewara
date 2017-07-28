/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonitorData {
	public static final String DATATYPE_CHANGEHIS = "CHANGEHIS";
	public static final String DATATYPE_LOGENTRY = "LOG_ENTRY";
	public static final String DATATYPE_SYSWARN = "SYSWARN";
	public static final String DATATYPE_APILOG = "APILOG";
	public static final String DATATYPE_SYSLOG = "SYSLOG";
	public static final String DATATYPE_APISTATS = "APISTATS";
	public static final String DATATYPE_MEMBERLOG = "MEMBERLOG";
	public static final String DATATYPE_MEMBERLOG2 = "MEMBERLOG2";
	public static final String DATATYPE_GEWAORDER = "GEWAORDER";
	public static final String DATATYPE_DOMAINLOG = "DOMAINLOG";
	public static final String DATATYPE_COUNTRECORD = "COUNTRECORD";
	public static final String DATATYPE_VIOLATION = "VIOLATION";
	public static final String DATATYPE_OPISTATS = "OPISTATS";
	public static final String DATATYPE_BEANDATA = "BEANDATA";
	public static final String DATATYPE_APPREPORT = "APPREPORT";
	public static final String DATATYPE_ACCESSLOG = "ACCESSLOG";
	public static final String DATATYPE_EVENT = "EVENT";
	public static final String DATATYPE_ERRORLOG = "ERRORLOG";
	public static final String DATATYPE_APPSOURCE = "APPSOURCE";
	public static final String DATATYPE_HISDATA = "HISDATA";
	public static final String DATATYPE_TERMINALTAKE = "TERMINALTICKET";
	public static final Map<String, String> queueMap = new HashMap();
	public static final List<String> DATA_TYPE_LIST = Arrays
			.asList(new String[]{"CHANGEHIS", "LOG_ENTRY", "SYSWARN", "APILOG", "SYSLOG", "APISTATS", "MEMBERLOG",
					"GEWAORDER", "DOMAINLOG", "COUNTRECORD", "VIOLATION", "OPISTATS", "BEANDATA", "APPREPORT",
					"ACCESSLOG", "EVENT", "ERRORLOG", "APPSOURCE", "HISDATA", "MEMBERLOG2", "TERMINALTICKET"});
	public static final String QUEUE_OTHER = "otherLogQueue";

	public static String getQueue(String datatype) {
		String result = (String) queueMap.get(datatype);
		return result == null ? "otherLogQueue" : result;
	}

	static {
		queueMap.put("CHANGEHIS", "changeLogQueue");
		queueMap.put("LOG_ENTRY", "logEntryQueue");
		queueMap.put("SYSWARN", "sysWarnQueue");
		queueMap.put("APILOG", "apiLogQueue");
		queueMap.put("SYSLOG", "sysLogQueue");
		queueMap.put("APISTATS", "apiStatsQueue");
		queueMap.put("MEMBERLOG", "memberLogQueue");
		queueMap.put("MEMBERLOG2", "memberLog2Queue");
		queueMap.put("GEWAORDER", "gewaOrderQueue");
		queueMap.put("DOMAINLOG", "domainLogQueue");
		queueMap.put("COUNTRECORD", "countRecordQueue");
		queueMap.put("VIOLATION", "violationQueue");
		queueMap.put("OPISTATS", "opiStatsQueue");
		queueMap.put("BEANDATA", "beanDataQueue");
		queueMap.put("APPREPORT", "appreportQueue");
		queueMap.put("ACCESSLOG", "accessLogQueue");
		queueMap.put("EVENT", "eventQueue");
		queueMap.put("ERRORLOG", "errorLogQueue");
		queueMap.put("APPSOURCE", "appsourceQueue");
		queueMap.put("TERMINALTICKET", "terminalTicketQueue");
		queueMap.put("HISDATA", "hisDataQueue");
	}
}