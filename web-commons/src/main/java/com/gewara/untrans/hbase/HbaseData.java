package com.gewara.untrans.hbase;

import java.util.Arrays;
import java.util.List;

public class HbaseData {
	//数据表
	public static final String TABLE_LOGENTRY = "exceptionlog";		//页面错误日志（Exception）
	public static final String TABLE_MONITOR = "monitor";				//监控数据
	public static final String TABLE_APILOG = "apilog";				//api日志
	public static final String TABLE_APILOG2 = "apilog2";				//api日志2，和apilog做切换，便于清除
	public static final String TABLE_HFHLOG = "hfhlog";				//第三方api统计，目前只有火凤凰、满天星日志
	public static final String TABLE_SYSWARN = "syswarn";				//系统警告
	public static final String TABLE_SYSLOG = "syslog";				//系统日志
	public static final String TABLE_GEWAORDER = "gewaorder";		//新订单日志
	public static final String TABLE_CHANGEHIS = "changehis";		//新对象更改日志
	public static final String TABLE_MEMBERLOG = "memberlog";		//前台用户操作
	public static final String TABLE_MEMBERLOG2 = "memberlog2";		//前台用户操作:membername为主键
	public static final String TABLE_DOMAINLOG = "domainlog";		//后台日志
	public static final String TABLE_APICALL = "apicall";				//调用API日志（调用者记录）
	public static final String TABLE_IPSTATS = "ipstats";				//IP访问统计
	public static final String TABLE_COUNTRECORD = "countrecord";	//记数更新
	public static final String TABLE_VIOLATION = "violation";		//非法访问
	public static final String TABLE_DATASTORE = "datastore";		//访问日志
	public static final String TABLE_CCSREQ = "ccsreq";				//访问日志
	public static final String TABLE_OPISTATS = "opistats";			//场次统计数据
	public static final String TABLE_BEANDATA = "beandata";			//场次统计数据
	public static final String TABLE_APPREPORT = "appreport";		//APP数据上报
	public static final String TABLE_DAUDATA = "daudata";				//日活用户数据
	public static final String TABLE_MEMACTCONVERGE = "memactconverge";	//用户行为聚合数据
	public static final String TABLE_EVENT = "event";					//监控事件：一般为更新、备份等数据上报型
	public static final String TABLE_ERRORLOG = "errorlog";			//错误日志
	public static final String TABLE_OPISTATS_TRIGGER = "opistats_trigger";//场次统计触发记录
	public static final String TABLE_ACCESSLOG = "accesslog";		//access.log
	//public static final String TABLE_DAUCOUNT = "daucount";		//日活用户聚合
	
	

	//自定义rowid，不支持直接rowid时间范围
	private static final List<String> SELF_GENROWID_TABLES = Arrays.asList(TABLE_CHANGEHIS, TABLE_GEWAORDER);
	/**
	 * 判断一个表是否支持直接rowid时间范围查询,默认 hbase 支持TimeRange还是需要设置???
	 * @param table
	 * @return
	 */
	public static boolean supportTimeRange(String table){
		return !SELF_GENROWID_TABLES.contains(table);
	}
}
