/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor;

import com.gewara.untrans.monitor.MonitorEntry;
import com.gewara.untrans.monitor.RoleTag;
import com.gewara.untrans.monitor.SysLogType;
import java.io.Serializable;
import java.util.Map;

public interface MonitorService {
	String KEY_TABLENAME = "TABLE_NAME";
	String KEY_HEXID = "HEXID";

	void addMonitorEntry(String arg0, Map<String, String> arg1);

	void addMonitorEntry(MonitorEntry arg0);

	Map<String, String> getMonitorStatus();

	void saveChangeLog(Long arg0, Class arg1, Serializable arg2, Map arg3);

	void saveSysChangeLog(Class arg0, Serializable arg1, Map arg2);

	void saveDelLog(Long arg0, Serializable arg1, Object arg2);

	void saveAddLog(Long arg0, Class arg1, Serializable arg2, Object arg3);

	void saveMemberLogMap(Long arg0, String arg1, Map<String, String> arg2, String arg3);

	void saveMemberLog(Long arg0, String arg1, String arg2, String arg3);

	void saveMemberLogByName(String arg0, String arg1, Map<String, String> arg2, String arg3);

	void saveSysWarn(String arg0, String arg1, RoleTag arg2);

	void saveSysWarn(Class arg0, Serializable arg1, String arg2, String arg3, RoleTag arg4);

	void saveSysTemplateWarn(String arg0, String arg1, Map arg2, RoleTag arg3);

	void saveSysTemplateWarn(Class arg0, Serializable arg1, String arg2, String arg3, Map arg4, RoleTag arg5);

	void addApiLog(Map<String, String> arg0, long arg1);

	void incrementCallCount(String arg0);

	void decrementCallCount(String arg0);

	Map<String, Integer> getCallCountInfo();

	int getCallCount(String arg0);

	void addSysLog(SysLogType arg0, Map<String, String> arg1);

	void addCountRecord(String arg0, Long arg1, Map arg2);

	String logException(MonitorService.EXCEPTION_TAG arg0, String arg1, String arg2, Throwable arg3,
			Map<String, String> arg4);

	void logViolation(String arg0, String arg1, Map<String, String> arg2);

	void addTableData(String arg0, Map<String, String> arg1, byte[] arg2);

	void addBeanData(Class arg0, Map<String, String> arg1);

	void addMonitorEvent(String arg0, Map<String, String> arg1);

	void addAccessLog(Map<String, String> arg0);

	public static enum EXCEPTION_TAG {
		PAGE, SERVICE, JOB;
	}
}