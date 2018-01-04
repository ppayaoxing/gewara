package com.gewara.untrans.monitor;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 监控日志表集合
 */
public class MonitorData {
	public static final String DATATYPE_CHANGEHIS = "CHANGEHIS";			//对象更改历史
	public static final String DATATYPE_LOGENTRY = "LOG_ENTRY";				//错误日志
	public static final String DATATYPE_SYSWARN = "SYSWARN";					//系统报警
	public static final String DATATYPE_APILOG = "APILOG";					//API日志
	public static final String DATATYPE_SYSLOG = "SYSLOG";					//系统日志
	public static final String DATATYPE_APISTATS = "APISTATS";				//API统计
	public static final String DATATYPE_MEMBERLOG = "MEMBERLOG";			//用户前台行为
	public static final String DATATYPE_MEMBERLOG2 = "MEMBERLOG2";			//用户前台行为:membername为主键
	public static final String DATATYPE_GEWAORDER = "GEWAORDER";			//新订单日志
	public static final String DATATYPE_DOMAINLOG = "DOMAINLOG";			//后台日志数据
	public static final String DATATYPE_COUNTRECORD = "COUNTRECORD";		//系统日志
	public static final String DATATYPE_VIOLATION = "VIOLATION";			//非法访问
	public static final String DATATYPE_OPISTATS = "OPISTATS";
	public static final String DATATYPE_BEANDATA = "BEANDATA"; 				//业务数据
	public static final String DATATYPE_APPREPORT = "APPREPORT"; 			//业务数据
	public static final String DATATYPE_ACCESSLOG = "ACCESSLOG"; 			//accessLog
	public static final String DATATYPE_EVENT = "EVENT";						//少量的事件：后台操作，系统更新
	public static final String DATATYPE_ERRORLOG = "ERRORLOG";				//错误日志
	public static final String DATATYPE_APPSOURCE = "APPSOURCE";			//APPSOURCE
	public static final String DATATYPE_HISDATA = "HISDATA";
	public static final String DATATYPE_TERMINALTAKE = "TERMINALTICKET";
	public static final String DATATYPE_APICALL = "DATATYPEAPICALL";   //api调用


	public static final Map<String, String> queueMap = Maps.newHashMap();

	public static final List<String> DATA_TYPE_LIST = Arrays.asList(DATATYPE_CHANGEHIS, DATATYPE_LOGENTRY,
			DATATYPE_SYSWARN, DATATYPE_APILOG, DATATYPE_SYSLOG, DATATYPE_APISTATS, 
			DATATYPE_MEMBERLOG, DATATYPE_GEWAORDER, DATATYPE_DOMAINLOG, DATATYPE_COUNTRECORD, DATATYPE_VIOLATION,   
			DATATYPE_OPISTATS, DATATYPE_BEANDATA, DATATYPE_APPREPORT,DATATYPE_ACCESSLOG,
			DATATYPE_EVENT, DATATYPE_ERRORLOG, DATATYPE_APPSOURCE, DATATYPE_HISDATA, DATATYPE_MEMBERLOG2, DATATYPE_TERMINALTAKE);
	public static final String QUEUE_OTHER = "otherLogQueue";	//未知项目

	static{
		queueMap.put(DATATYPE_CHANGEHIS, "changeLogQueue");
		queueMap.put(DATATYPE_LOGENTRY, "logEntryQueue");
		queueMap.put(DATATYPE_SYSWARN, "sysWarnQueue");
		queueMap.put(DATATYPE_APILOG, "apiLogQueue");
		queueMap.put(DATATYPE_SYSLOG, "sysLogQueue");
		queueMap.put(DATATYPE_APISTATS, "apiStatsQueue");
		queueMap.put(DATATYPE_MEMBERLOG, "memberLogQueue");
		queueMap.put(DATATYPE_MEMBERLOG2, "memberLog2Queue");
		queueMap.put(DATATYPE_GEWAORDER, "gewaOrderQueue");
		queueMap.put(DATATYPE_DOMAINLOG, "domainLogQueue");
		queueMap.put(DATATYPE_COUNTRECORD, "countRecordQueue");
		queueMap.put(DATATYPE_VIOLATION, "violationQueue");
		queueMap.put(DATATYPE_OPISTATS, "opiStatsQueue");
		queueMap.put(DATATYPE_BEANDATA, "beanDataQueue");
		queueMap.put(DATATYPE_APPREPORT, "appreportQueue");
		queueMap.put(DATATYPE_ACCESSLOG, "accessLogQueue");
		queueMap.put(DATATYPE_EVENT, "eventQueue");
		queueMap.put(DATATYPE_ERRORLOG, "errorLogQueue");
		queueMap.put(DATATYPE_APPSOURCE, "appsourceQueue");
		queueMap.put(DATATYPE_TERMINALTAKE, "terminalTicketQueue");
		queueMap.put(DATATYPE_HISDATA, "hisDataQueue");//历史数据，表名未定
	}
	public static String getQueue(String datatype){
		String result = queueMap.get(datatype);
		if(result==null){
			return MonitorData.QUEUE_OTHER;
		}
		return result;
	}
}
