package com.gewara.untrans.monitor;

import java.io.Serializable;
import java.util.Map;

public interface MonitorService {
	String KEY_TABLENAME = "TABLE_NAME";
	String KEY_HEXID = "HEXID";
	String PRE_WEBSERVICE = "PRE_WEBSERVICE";

	enum EXCEPTION_TAG{
		PAGE,		//页面异常
		SERVICE,	//服务异常
		JOB			//定时任务异常
	}
	/**
	 * 增加日志数据
	 * @param datatype
	 * @param entry
	 */
	void addMonitorEntry(String datatype, Map<String, String> entry);
	void addMonitorEntry(MonitorEntry entry);
	/**
	 * 获取统计信息，count：处理条数，queued：当前队列数
	 * @return
	 */
	Map<String, String> getMonitorStatus();
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~business method~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * 后台编辑数据
	 * @param userid
	 * @param clazz
	 * @param relatedid
	 * @param content
	 */
	void saveChangeLog(Long userid, Class clazz, Serializable relatedid, Map changeMap);
	/**
	 * 系统数据更改
	 * @param clazz
	 * @param relatedid
	 * @param changeMap
	 */
	void saveSysChangeLog(Class clazz, Serializable relatedid, Map changeMap);
	/**
	 * 删除数据
	 * @param userid
	 * @param relatedid
	 * @param entity
	 */
	void saveDelLog(Long userid, Serializable relatedid, Object entity);
	/**
	 * 增加数据
	 * @param userid
	 * @param clazz
	 * @param relatedid
	 * @param entity
	 */
	void saveAddLog(Long userid, Class clazz, Serializable relatedid, Object entity);
	/**
	 * 前台用户行为
	 * @param memberid
	 * @param action
	 * @param content
	 * @param ip
	 */
	void saveMemberLogMap(Long memberid, String action, Map<String, String> info, String ip);

	void saveMemberLog(Long memberid, String action, String content, String ip);

	/**
	 * 前台用户行为
	 * @param membername: 登录名称
	 * @param action
	 * @param content
	 * @param ip
	 */
	void saveMemberLogByName(String membername, String action, Map<String, String> info, String ip);

	/**
	 * 系统警告内容
	 * @param action
	 * @param title
	 * @param content
	 */
	void saveSysWarn(String title, String content, RoleTag role);
	void saveSysWarn(Class clazz, Serializable relatedid, String title, String content, RoleTag role);
	void saveSysTemplateWarn(String title, String template, Map model, RoleTag role);
	/**
	 * 系统警告内容
	 * @param action
	 * @param title
	 * @param template
	 * @param model
	 */
	void saveSysTemplateWarn(Class clazz, Serializable relatedid, String title, String template, Map model, RoleTag role);
	
	void addApiLog(Map<String, String> params, long calltime);
	/**
	 * 增加调用次数
	 * @param callname
	 */
	void incrementCallCount(String callname);
	/**
	 * 减少调用次数
	 * @param msgname
	 */
	void decrementCallCount(String callname);
	Map<String, Integer> getCallCountInfo();
	int getCallCount(String callname);
	void addSysLog(SysLogType logtype, Map<String, String> entry);
	void addCountRecord(String tag, Long relatedid, Map updateMap);
	/**
	 * 
	 * @param tag
	 * @param location：uri 或 service、job方法
	 * @param title 标题
	 * @param e excepion
	 */
	String logException(EXCEPTION_TAG tag, String location, String title, Throwable e, Map<String, String> otherinfo);
	/**
	 * 增加非法访问记录
	 * @param ip
	 * @param params
	 */
	void logViolation(String ip, String resource, Map<String, String> params);
	
	void addTableData(String tablename, Map<String, String> params, byte[] rowId);
	void addBeanData(Class clazz, Map<String, String> bean);
	void addMonitorEvent(String eventType, Map<String, String> eventEntry);
	void addAccessLog(Map<String, String> logEntry);
	void addApiCall(Map<String, String> paramsLog, long cur, boolean success);
}
