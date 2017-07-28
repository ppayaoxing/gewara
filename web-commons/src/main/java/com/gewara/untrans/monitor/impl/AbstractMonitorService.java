/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.impl;

import com.gewara.Config;
import com.gewara.json.SysWarn;
import com.gewara.support.GewaExecutorThreadFactory;
import com.gewara.support.VelocityTemplate;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.untrans.monitor.RoleTag;
import com.gewara.untrans.monitor.SysLogType;
import com.gewara.untrans.monitor.MonitorService.EXCEPTION_TAG;
import com.gewara.untrans.monitor.impl.MapMonitorEntry;
import com.gewara.util.Assert;
import com.gewara.util.BeanUtil;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.GewaLogger;
import com.gewara.util.JsonUtils;
import com.gewara.util.LoggerUtils;
import com.gewara.util.WebLogger;
import java.io.CharConversionException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.MissingServletRequestParameterException;

public abstract class AbstractMonitorService implements MonitorService {
	protected static String FLAG_ADMIN = "admin";
	protected Map<String, AtomicInteger> callcountMap = new HashMap();
	protected GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	protected ThreadPoolExecutor executor;
	@Autowired
	@Qualifier("velocityTemplate")
	private VelocityTemplate velocityTemplate;

	public Map<String, String> getMonitorStatus() {
		LinkedHashMap result = new LinkedHashMap();
		result.put("count", "" + this.executor.getCompletedTaskCount());
		result.put("queued", "" + this.executor.getTaskCount());
		return result;
	}

	protected void setupConsumerThread(int threadSize) {
		this.executor = new ThreadPoolExecutor(threadSize, threadSize, 300L, TimeUnit.SECONDS,
				new LinkedBlockingQueue(), new GewaExecutorThreadFactory(this.getClass().getSimpleName()));
		this.executor.allowCoreThreadTimeOut(false);
		this.dbLogger.warn("MonitorThread started!");
	}

	protected void destroyConsumerThread() {
		this.executor.shutdown();
	}

	public void saveChangeLog(Long userid, Class clazz, Serializable relatedid, Map changeMap) {
		if (!changeMap.isEmpty()) {
			Map map = this.getLogMap("admin");
			map.put("userid", userid + "");
			map.put("tag", clazz.getSimpleName());
			map.put("relatedid", relatedid + "");
			map.put("action", "change");
			map.put("change", JsonUtils.writeMapToJson(changeMap));
			map.put("server", Config.getServerIp());
			this.addMonitorEntry("CHANGEHIS", map);
		}
	}

	public void saveSysChangeLog(Class clazz, Serializable relatedid, Map changeMap) {
		if (!changeMap.isEmpty()) {
			Map map = this.getLogMap(FLAG_ADMIN);
			map.put("userid", "0");
			map.put("changeType", "sys");
			map.put("tag", clazz.getSimpleName());
			map.put("relatedid", relatedid + "");
			map.put("action", "change");
			map.put("server", Config.getServerIp());
			map.put("change", JsonUtils.writeMapToJson(changeMap));
			this.addMonitorEntry("CHANGEHIS", map);
		}
	}

	public void addAccessLog(Map<String, String> logEntry) {
		this.addMonitorEntry("ACCESSLOG", logEntry);
	}

	public void saveAddLog(Long userid, Class clazz, Serializable relatedid, Object entity) {
		if (entity != null) {
			Map map = this.getLogMap(FLAG_ADMIN);
			map.put("userid", userid + "");
			map.put("tag", clazz.getSimpleName());
			map.put("relatedid", relatedid + "");
			map.put("action", "add");
			map.put("server", Config.getServerIp());
			map.put("change", JsonUtils.writeMapToJson(BeanUtil.getBeanMap(entity)));
			this.addMonitorEntry("CHANGEHIS", map);
		}
	}

	public void saveDelLog(Long userid, Serializable relatedid, Object entity) {
		Map map = this.getLogMap(FLAG_ADMIN);
		map.put("userid", userid + "");
		map.put("tag", entity.getClass().getSimpleName());
		map.put("relatedid", relatedid + "");
		map.put("action", "del");
		map.put("server", Config.getServerIp());
		map.put("change", JsonUtils.writeMapToJson(BeanUtil.getBeanMap(entity)));
		this.addMonitorEntry("CHANGEHIS", map);
	}

	public void saveMemberLogMap(Long memberid, String action, Map<String, String> info, String ip) {
		if (info == null) {
			info = new LinkedHashMap();
		}

		String curtime = DateUtil.formatTimestamp(new Timestamp(System.currentTimeMillis()));
		((Map) info).put("action", action);
		((Map) info).put("addtime", curtime);
		((Map) info).put("adddate", curtime.substring(0, 10));
		((Map) info).put("server", Config.getServerIp());
		if (StringUtils.isNotBlank(ip)) {
			((Map) info).put("ip", ip);
		}

		if (memberid != null) {
			((Map) info).put("memberid", memberid + "");
		} else {
			((Map) info).put("nomemberid", "Y");
		}

		this.addMonitorEntry("MEMBERLOG", (Map) info);
	}

	public void saveMemberLogByName(String membername, String action, Map<String, String> info, String ip) {
		Assert.notNull(membername);
		if (info == null) {
			info = new LinkedHashMap();
		}

		String curtime = DateUtil.formatTimestamp(new Timestamp(System.currentTimeMillis()));
		((Map) info).put("action", action);
		((Map) info).put("addtime", curtime);
		((Map) info).put("adddate", curtime.substring(0, 10));
		((Map) info).put("server", Config.getServerIp());
		if (StringUtils.isNotBlank(ip)) {
			((Map) info).put("ip", ip);
		}

		((Map) info).put("membername", membername);
		this.addMonitorEntry("MEMBERLOG2", (Map) info);
	}

	public void saveMemberLog(Long memberid, String action, String content, String ip) {
		LinkedHashMap info = new LinkedHashMap();
		info.put("content", content);
		this.saveMemberLogMap(memberid, action, info, ip);
	}

	public void saveSysWarn(String title, String content, RoleTag role) {
		this.saveSysWarn((Class) null, (Serializable) null, title, content, role);
	}

	public void saveSysTemplateWarn(Class clazz, Serializable relatedid, String title, String template, Map model,
			RoleTag role) {
		String content = this.velocityTemplate.parseTemplate(template, model);
		this.saveSysWarn(clazz, relatedid, title, content, role);
	}

	public void saveSysTemplateWarn(String title, String template, Map model, RoleTag role) {
		this.saveSysTemplateWarn((Class) null, (Serializable) null, title, template, model, role);
	}

	public void saveSysWarn(Class clazz, Serializable relatedid, String title, String content, RoleTag role) {
		SysWarn warn = new SysWarn();
		if (clazz != null) {
			warn.setTag(clazz.getSimpleName());
		}

		if (relatedid != null) {
			warn.setRelatedid(relatedid);
		}

		if (StringUtils.isNotBlank("title")) {
			warn.setTitle(title);
		}

		if (StringUtils.isNotBlank("content")) {
			warn.setContent(content);
		}

		if (role != null) {
			warn.setRole(role.name());
		}

		Map warnMap = BeanUtil.getSimpleStringMap(warn);
		warnMap.put("server", Config.getServerIp());
		this.addMonitorEntry("SYSWARN", warnMap);
	}

	public void addApiLog(Map<String, String> params, long calltime) {
		String time = DateUtil.formatTimestamp(Long.valueOf(calltime));
		params.put("calltime", time);
		params.put("calldate", time.substring(0, 10));
		params.put("elapsed", "" + (System.currentTimeMillis() - calltime));
		this.addMonitorEntry("APILOG", params);
	}

	public void addSysLog(SysLogType logtype, Map<String, String> entry) {
		entry.put("logtype", logtype.name());
		String curtime = DateUtil.formatTimestamp(new Timestamp(System.currentTimeMillis()));
		entry.put("addtime", curtime);
		entry.put("adddate", curtime.substring(0, 10));
		this.addMonitorEntry("SYSLOG", entry);
	}

	public void addCountRecord(String tag, Long relatedid, Map updateMap) {
		Map entry = BeanUtil.toSimpleStringMap(updateMap);
		entry.put("tag", tag);
		entry.put("relatedid", relatedid.toString());
		this.addMonitorEntry("COUNTRECORD", entry);
	}

	public void addBeanData(Class clazz, Map<String, String> beanMap) {
		beanMap.put("className", clazz.getCanonicalName());
		MapMonitorEntry entry = new MapMonitorEntry("BEANDATA", beanMap);
		HashMap headMap = new HashMap();
		headMap.put("className", clazz.getCanonicalName());
		entry.setHeadMap(headMap);
		this.addMonitorEntry(entry);
	}

	private Map<String, String> getLogMap(String flag) {
		HashMap map = new HashMap();
		if (StringUtils.isNotBlank(flag)) {
			map.put("flag", flag);
		}

		String curtime = DateUtil.formatTimestamp(new Timestamp(System.currentTimeMillis()));
		map.put("addtime", curtime);
		map.put("adddate", curtime.substring(0, 10));
		return map;
	}

	public void incrementCallCount(String callname) {
		AtomicInteger counter = (AtomicInteger) this.callcountMap.get(callname);
		if (counter == null) {
			counter = this.createCounter(callname);
		}

		counter.incrementAndGet();
	}

	public void decrementCallCount(String callname) {
		AtomicInteger counter = (AtomicInteger) this.callcountMap.get(callname);
		if (counter == null) {
			counter = this.createCounter(callname);
		}

		counter.decrementAndGet();
	}

	private AtomicInteger createCounter(String callname) {
		AtomicInteger counter = new AtomicInteger();
		this.callcountMap.put(callname, counter);
		return counter;
	}

	public Map<String, Integer> getCallCountInfo() {
		HashMap result = new HashMap();
		Iterator arg1 = this.callcountMap.keySet().iterator();

		while (arg1.hasNext()) {
			String key = (String) arg1.next();
			result.put(key, Integer.valueOf(((AtomicInteger) this.callcountMap.get(key)).get()));
		}

		return result;
	}

	public int getCallCount(String callname) {
		AtomicInteger counter = (AtomicInteger) this.callcountMap.get(callname);
		return counter == null ? 0 : counter.get();
	}

	public String logException(EXCEPTION_TAG tag, String location, String title, Throwable ex,
			Map<String, String> otherinfo) {
		HashMap row = new HashMap();
		String exctrace = null;
		String exceptionType = "UNKNOWN";
		String curtime;
		String remoteIp;
		if (ex != null) {
			curtime = title + "\n";
			remoteIp = ex.getClass().getSimpleName();
			if (!(ex instanceof MissingServletRequestParameterException) && !(ex instanceof TypeMismatchException)
					&& !StringUtils.contains(ex.getClass().getName(), "ClientAbortException")) {
				if (StringUtils.contains(ex.getClass().getName(), "HibernateOptimisticLockingFailureException")) {
					exctrace = LoggerUtils.getExceptionTrace(ex, 50);
					exceptionType = "NORMAL";
				} else {
					exctrace = LoggerUtils.getExceptionTrace(ex, 200);
				}
			} else {
				exctrace = LoggerUtils.getExceptionTrace(ex, 10);
			}

			curtime = curtime + exctrace;
			if (ex instanceof IllegalStateException && ex.getCause() instanceof CharConversionException) {
				return exctrace;
			}

			if (StringUtils.equals(remoteIp, "BindException") || StringUtils.equals(remoteIp, "TypeMismatchException")
					|| StringUtils.equals(remoteIp, "NumberFormatException")
					|| StringUtils.equals(remoteIp, "MethodArgumentTypeMismatchException")) {
				exceptionType = "AttackException";
			}

			row.put("exceptionName", remoteIp);
			row.put("exceptionTrace", curtime);
			row.put("exceptionType", exceptionType);
		} else {
			row.put("exceptionName", "无");
			row.put("exceptionTrace", title + "\n" + location + "\n" + otherinfo);
		}

		if (otherinfo != null) {
			row.putAll(otherinfo);
		}

		if (tag == EXCEPTION_TAG.JOB) {
			exceptionType = "UNKNOWN";
		}

		row.put("tag", "" + tag);
		row.put("title", title);
		row.put("location", location);
		row.put("server", Config.getServerIp());
		curtime = DateUtil.getCurFullTimestampStr();
		row.put("addtime", curtime);
		row.put("adddate", curtime.substring(0, 10));
		this.addMonitorEntry("LOG_ENTRY", row);
		if (otherinfo != null) {
			remoteIp = (String) otherinfo.get("remoteIp");
			if (StringUtils.isNotBlank(remoteIp) && !GewaIpConfig.isGewaInnerIp(remoteIp)
					&& StringUtils.equals(exceptionType, "AttackException")) {
				String reqUri = (String) otherinfo.get("reqUri");
				String reqParams = (String) otherinfo.get("reqParams");
				String exceptionName = (String) row.get("exceptionName");
				HashMap params = new HashMap();
				params.put("reqParams", reqParams);
				params.put("exceptionType", "AttackException");
				params.put("exceptionName", exceptionName);
				this.logViolation(remoteIp, reqUri, params);
			}
		}

		return exctrace;
	}

	public void logViolation(String ip, String resource, Map<String, String> params) {
		LinkedHashMap row = new LinkedHashMap();
		row.put("ip", ip);
		row.put("resource", resource);
		row.put("systemId", Config.SYSTEMID);
		row.put("accessTime", DateUtil.getCurFullTimestampStr());
		if (params != null) {
			row.putAll(BeanUtil.toSimpleStringMap(params));
		}

		this.addMonitorEntry("VIOLATION", row);
	}

	public void addMonitorEvent(String eventType, Map<String, String> entry) {
		entry.put("eventType", eventType);
		String curtime = DateUtil.formatTimestamp(new Timestamp(System.currentTimeMillis()));
		entry.put("addtime", curtime);
		this.addMonitorEntry("EVENT", entry);
	}

	public void addTableData(String tablename, Map<String, String> params, byte[] rowId) {
		params.put("TABLE_NAME", tablename);
		params.put("HEXID", Hex.encodeHexString(rowId));
		this.addMonitorEntry("HISDATA", params);
	}
}