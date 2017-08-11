package com.gewara.untrans.monitor.impl;

import java.io.CharConversionException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.collect.Maps;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.MissingServletRequestParameterException;

import com.gewara.Config;
import com.gewara.json.SysWarn;
import com.gewara.support.GewaExecutorThreadFactory;
import com.gewara.support.VelocityTemplate;
import com.gewara.untrans.monitor.MonitorData;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.untrans.monitor.RoleTag;
import com.gewara.untrans.monitor.SysLogType;
import com.gewara.util.Assert;
import com.gewara.util.BeanUtil;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.GewaLogger;
import com.gewara.util.JsonUtils;
import com.gewara.util.LoggerUtils;
import com.gewara.util.WebLogger;
/**
 * 通过消息队列实现
 * @author gebiao(ge.biao@gewara.com)
 * @since Feb 18, 2013 2:46:02 PM
 */
public abstract class AbstractMonitorService implements MonitorService {
	protected static String FLAG_ADMIN = "admin";
	protected Map<String, AtomicInteger> callcountMap = new HashMap<String, AtomicInteger>();
	protected GewaLogger dbLogger = WebLogger.getLogger(getClass());
	protected ThreadPoolExecutor executor;
	@Autowired@Qualifier("velocityTemplate")
	private VelocityTemplate velocityTemplate;
	@Override
	public void addApiCall(Map<String, String> paramsLog, long cur, boolean success) {
		//TODO 待定
		
	}
	@Override
	public Map<String, String> getMonitorStatus() {
		Map<String, String> result = new LinkedHashMap<String, String>();
		result.put("count", "" + executor.getCompletedTaskCount());
		result.put("queued", "" + executor.getTaskCount());
		return result;
	}

	/** 根据线程池大小,初始化线程池
	 * @param threadSize
	 */
	protected void setupConsumerThread(int threadSize){
		//FixedPoolSize
		executor = new ThreadPoolExecutor(threadSize, threadSize, 300, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new GewaExecutorThreadFactory(this.getClass().getSimpleName()));
		executor.allowCoreThreadTimeOut(false);//设置主线程是否超时
		dbLogger.warn("MonitorThread started!");
	}
	protected void destroyConsumerThread(){
		executor.shutdown();
	}
	@Override
	public void saveChangeLog(Long userid, Class clazz, Serializable relatedid, Map changeMap) {
		if(changeMap.isEmpty()) return;
		Map<String, String> map = getLogMap("admin");
		map.put("userid", userid + "");
		map.put("tag", clazz.getSimpleName());
		map.put("relatedid", relatedid + "");
		map.put("action", "change");
		map.put("change", JsonUtils.writeMapToJson(changeMap));
		map.put("server", Config.getServerIp());
		addMonitorEntry(MonitorData.DATATYPE_CHANGEHIS, map);
	}
	@Override
	public void saveSysChangeLog(Class clazz, Serializable relatedid, Map changeMap) {
		if(changeMap.isEmpty()) return;
		Map<String, String> map = getLogMap(FLAG_ADMIN);
		map.put("userid", "0");
		map.put("changeType", "sys");
		map.put("tag", clazz.getSimpleName());
		map.put("relatedid", relatedid + "");
		map.put("action", "change");
		map.put("server", Config.getServerIp());
		map.put("change", JsonUtils.writeMapToJson(changeMap));
		addMonitorEntry(MonitorData.DATATYPE_CHANGEHIS, map);
	}
	@Override
	public void addAccessLog(Map<String, String> logEntry) {
		addMonitorEntry(MonitorData.DATATYPE_ACCESSLOG, logEntry);
	}

	@Override
	public void saveAddLog(Long userid, Class clazz, Serializable relatedid, Object entity) {
		if(entity==null) return;
		Map<String, String> map = getLogMap(FLAG_ADMIN);
		map.put("userid", userid + "");
		map.put("tag", clazz.getSimpleName());
		map.put("relatedid", relatedid + "");
		map.put("action", "add");
		map.put("server", Config.getServerIp());
		map.put("change", JsonUtils.writeMapToJson(BeanUtil.getBeanMap(entity)));
		addMonitorEntry(MonitorData.DATATYPE_CHANGEHIS, map);
	}
	@Override
	public void saveDelLog(Long userid, Serializable relatedid, Object entity) {
		Map<String, String> map = getLogMap(FLAG_ADMIN);
		map.put("userid", userid + "");
		map.put("tag", entity.getClass().getSimpleName());
		map.put("relatedid", relatedid + "");
		map.put("action", "del");
		map.put("server", Config.getServerIp());
		map.put("change", JsonUtils.writeMapToJson(BeanUtil.getBeanMap(entity)));
		addMonitorEntry(MonitorData.DATATYPE_CHANGEHIS, map);
	}
	@Override
	public void saveMemberLogMap(Long memberid, String action, Map<String, String> info, String ip) {
		if(info==null) info = new LinkedHashMap<String, String>();
		String curtime = DateUtil.formatTimestamp(new Timestamp(System.currentTimeMillis()));
		info.put("action", action);
		info.put("addtime", curtime);
		info.put("adddate", curtime.substring(0, 10));
		info.put("server", Config.getServerIp());
		if(StringUtils.isNotBlank(ip)) {
			info.put("ip", ip);
		}

		if(memberid!=null){
			info.put("memberid", memberid + "");
		}else{
			info.put("nomemberid", "Y");
		}
		addMonitorEntry(MonitorData.DATATYPE_MEMBERLOG, info);
	}
	@Override
	public void saveMemberLogByName(String membername, String action, Map<String, String> info, String ip){
		Assert.notNull(membername);
		if(info==null) info = new LinkedHashMap<String, String>();
		String curtime = DateUtil.formatTimestamp(new Timestamp(System.currentTimeMillis()));
		info.put("action", action);
		info.put("addtime", curtime);
		info.put("adddate", curtime.substring(0, 10));
		info.put("server", Config.getServerIp());
		if(StringUtils.isNotBlank(ip)) {
			info.put("ip", ip);
		}
		info.put("membername", membername);
		addMonitorEntry(MonitorData.DATATYPE_MEMBERLOG2, info);
	}

	@Override
	public void saveMemberLog(Long memberid, String action, String content, String ip) {
		Map<String, String> info = new  LinkedHashMap<String, String>();
		info.put("content", content);
		saveMemberLogMap(memberid, action, info, ip);
	}


	// -------------------------系统警告信息------------------
	@Override
	public void saveSysWarn(String title, String content, RoleTag role) {
		saveSysWarn(null, null, title, content, role);
	}
	@Override
	public void saveSysTemplateWarn(Class clazz, Serializable relatedid, String title, String template, Map model, RoleTag role) {
		String content = velocityTemplate.parseTemplate(template, model);
		saveSysWarn(clazz, relatedid, title, content, role);
	}
	@Override
	public void saveSysTemplateWarn(String title, String template, Map model, RoleTag role) {
		saveSysTemplateWarn(null, null, title, template, model, role);
	}
	@Override
	public void saveSysWarn(Class clazz, Serializable relatedid, String title, String content, RoleTag role) {
		SysWarn warn = new SysWarn();
		if(clazz!=null) warn.setTag(clazz.getSimpleName());
		if(relatedid!=null) warn.setRelatedid(relatedid);
		if(StringUtils.isNotBlank("title")) warn.setTitle(title);
		if(StringUtils.isNotBlank("content")) warn.setContent(content);
		if(role!=null) warn.setRole(role.name());
		Map<String, String> warnMap = BeanUtil.getSimpleStringMap(warn);
		warnMap.put("server", Config.getServerIp());
		addMonitorEntry(MonitorData.DATATYPE_SYSWARN, warnMap);
	}
	@Override
	public void addApiLog(Map<String, String> params, long calltime) {
		String time = DateUtil.formatTimestamp(calltime);
		params.put("calltime", time);
		params.put("calldate", time.substring(0, 10));
		params.put("elapsed", "" + (System.currentTimeMillis() - calltime));
		addMonitorEntry(MonitorData.DATATYPE_APILOG, params);
	}
	@Override
	public void addSysLog(SysLogType logtype, Map<String, String> entry) {
		entry.put("logtype", logtype.name());
		String curtime = DateUtil.formatTimestamp(new Timestamp(System.currentTimeMillis()));
		entry.put("addtime", curtime);
		entry.put("adddate", curtime.substring(0, 10));
		addMonitorEntry(MonitorData.DATATYPE_SYSLOG, entry);
	}
	@Override
	public void addCountRecord(String tag, Long relatedid, Map updateMap){
		Map<String, String> entry = BeanUtil.toSimpleStringMap(updateMap);
		entry.put("tag", tag);
		entry.put("relatedid", relatedid.toString());
		addMonitorEntry(MonitorData.DATATYPE_COUNTRECORD, entry);
	}
	@Override
	public void addBeanData(Class clazz, Map<String, String> beanMap) {
		beanMap.put("className", clazz.getCanonicalName());
		MapMonitorEntry entry = new MapMonitorEntry(MonitorData.DATATYPE_BEANDATA, beanMap);
		Map<String, String> headMap = new HashMap<String, String>();
		headMap.put("className", clazz.getCanonicalName());
		entry.setHeadMap(headMap);
		addMonitorEntry(entry);
	}

	private Map<String, String> getLogMap(String flag) {
		Map<String, String> map = new HashMap<String, String>();
		if(StringUtils.isNotBlank(flag))map.put("flag", flag);
		String curtime = DateUtil.formatTimestamp(new Timestamp(System.currentTimeMillis()));
		map.put("addtime", curtime);
		map.put("adddate", curtime.substring(0, 10));
		return map;
	}
	@Override
	public void incrementCallCount(String callname) {
		AtomicInteger counter = callcountMap.get(callname);
		if(counter==null) counter = createCounter(callname);
		counter.incrementAndGet();
	}
	@Override
	public void decrementCallCount(String callname) {
		AtomicInteger counter = callcountMap.get(callname);
		if(counter==null) counter = createCounter(callname);
		counter.decrementAndGet();
	}
	private AtomicInteger createCounter(String callname){
		AtomicInteger counter = new AtomicInteger();
		callcountMap.put(callname, counter);
		return counter;
	}
	@Override
	public Map<String, Integer> getCallCountInfo(){
		Map<String, Integer> result = new HashMap<String, Integer>();
		for(String key: callcountMap.keySet()){
			result.put(key, callcountMap.get(key).get());
		}
		return result;
	}
	@Override
	public int getCallCount(String callname){
		AtomicInteger counter = callcountMap.get(callname);
		if(counter==null) return 0;
		return counter.get();
	}

	/** 保存日志信息,根据异常类型保存
	 * @param tag
	 * @param location：uri 或 service、job方法
	 * @param title        标题
	 * @param ex
	 * @param otherinfo
	 * @return
	 */
	@Override
	public String logException(EXCEPTION_TAG tag, String location, String title, Throwable ex, Map<String, String> otherinfo) {
		Map<String, String> row = Maps.newHashMap();
		String exctrace = null;
		String exceptionType = "UNKNOWN";
		if(ex!=null){
			String exceptionTrace = title + "\n";
			String exceptionName = ex.getClass().getSimpleName();
			// 根据异常类型,进行保存相应异常的详细堆栈信息行数
			if(ex instanceof MissingServletRequestParameterException ||
					ex instanceof TypeMismatchException || 
					StringUtils.contains(ex.getClass().getName(), "ClientAbortException")){
				exctrace = LoggerUtils.getExceptionTrace(ex, 10);
			}else if(StringUtils.contains(ex.getClass().getName(), "HibernateOptimisticLockingFailureException")){
				exctrace = LoggerUtils.getExceptionTrace(ex, 50);
				exceptionType = "NORMAL";
			}else{
				exctrace = LoggerUtils.getExceptionTrace(ex, 200);
			}
			exceptionTrace += exctrace;
			if(ex instanceof IllegalStateException && ex.getCause() instanceof CharConversionException){
				//url编码错误，不做登记
				return exctrace;
			}
			if(StringUtils.equals(exceptionName, "BindException") 
					|| StringUtils.equals(exceptionName, "TypeMismatchException")
					|| StringUtils.equals(exceptionName, "NumberFormatException")
					|| StringUtils.equals(exceptionName, "MethodArgumentTypeMismatchException")){
				exceptionType = "AttackException";
			}

			row.put("exceptionName", exceptionName);
			row.put("exceptionTrace", exceptionTrace);
			row.put("exceptionType", exceptionType);
		}else{
			row.put("exceptionName", "无");
			row.put("exceptionTrace", title + "\n" + location + "\n" + otherinfo);
		}
		
		if(otherinfo!=null){
			row.putAll(otherinfo);
		}
		if(tag == EXCEPTION_TAG.JOB){
			//定时任务非常重要
			exceptionType = "UNKNOWN";
		}
		row.put("tag", "" + tag);
		row.put("title", title);
		row.put("location", location);
		row.put("server", Config.getServerIp());
		String curtime = DateUtil.getCurFullTimestampStr();
		row.put("addtime", curtime);
		row.put("adddate", curtime.substring(0, 10));
		//添加日志(错误日志)
		addMonitorEntry(MonitorData.DATATYPE_LOGENTRY, row);
		
		if(otherinfo != null){
			String remoteIp = otherinfo.get("remoteIp");
			//非法访问
			if(StringUtils.isNotBlank(remoteIp) && !GewaIpConfig.isGewaInnerIp(remoteIp)){
				if(StringUtils.equals(exceptionType, "AttackException")){
					String reqUri = otherinfo.get("reqUri");
					String reqParams = otherinfo.get("reqParams");
					String exceptionName = row.get("exceptionName");

					Map<String, String> params = Maps.newHashMap();
					params.put("reqParams", reqParams);
					params.put("exceptionType", "AttackException");
					params.put("exceptionName", exceptionName);
					this.logViolation(remoteIp, reqUri, params);
				}
			}
		}
		return exctrace;
	}

	/** 添加非法访问日志
	 * @param ip
	 * @param resource
	 * @param params
	 */
	@Override
	public void logViolation(String ip, String resource, Map<String, String> params) {
		Map<String, String> row = Maps.newLinkedHashMap();
		row.put("ip", ip);
		row.put("resource", resource);//uri
		row.put("systemId", Config.SYSTEMID);
		row.put("accessTime", DateUtil.getCurFullTimestampStr());
		
		if(params!=null){
			row.putAll(BeanUtil.toSimpleStringMap(params));
		}
		addMonitorEntry(MonitorData.DATATYPE_VIOLATION, row);
	}
	@Override
	public void addMonitorEvent(String eventType, Map<String, String> entry) {
		entry.put("eventType", eventType);
		String curtime = DateUtil.formatTimestamp(new Timestamp(System.currentTimeMillis()));
		entry.put("addtime", curtime);
		addMonitorEntry(MonitorData.DATATYPE_EVENT, entry);
	}
	@Override
	public void addTableData(String tablename, Map<String, String> params, byte[] rowId) {
		params.put(KEY_TABLENAME, tablename);
		params.put(KEY_HEXID, Hex.encodeHexString(rowId));
		addMonitorEntry(MonitorData.DATATYPE_HISDATA, params);
	}
}
