/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase;

import java.util.Arrays;
import java.util.List;

public class HbaseData {
	public static final String TABLE_LOGENTRY = "exceptionlog";
	public static final String TABLE_MONITOR = "monitor";
	public static final String TABLE_APILOG = "apilog";
	public static final String TABLE_APILOG2 = "apilog2";
	public static final String TABLE_HFHLOG = "hfhlog";
	public static final String TABLE_SYSWARN = "syswarn";
	public static final String TABLE_SYSLOG = "syslog";
	public static final String TABLE_GEWAORDER = "gewaorder";
	public static final String TABLE_CHANGEHIS = "changehis";
	public static final String TABLE_MEMBERLOG = "memberlog";
	public static final String TABLE_MEMBERLOG2 = "memberlog2";
	public static final String TABLE_DOMAINLOG = "domainlog";
	public static final String TABLE_APICALL = "apicall";
	public static final String TABLE_IPSTATS = "ipstats";
	public static final String TABLE_COUNTRECORD = "countrecord";
	public static final String TABLE_VIOLATION = "violation";
	public static final String TABLE_DATASTORE = "datastore";
	public static final String TABLE_CCSREQ = "ccsreq";
	public static final String TABLE_OPISTATS = "opistats";
	public static final String TABLE_BEANDATA = "beandata";
	public static final String TABLE_APPREPORT = "appreport";
	public static final String TABLE_DAUDATA = "daudata";
	public static final String TABLE_MEMACTCONVERGE = "memactconverge";
	public static final String TABLE_EVENT = "event";
	public static final String TABLE_ERRORLOG = "errorlog";
	public static final String TABLE_OPISTATS_TRIGGER = "opistats_trigger";
	public static final String TABLE_ACCESSLOG = "accesslog";
	private static final List<String> SELF_GENROWID_TABLES = Arrays.asList(new String[] { "changehis", "gewaorder" });

	public static boolean supportTimeRange(String table) {
		return !SELF_GENROWID_TABLES.contains(table);
	}
}