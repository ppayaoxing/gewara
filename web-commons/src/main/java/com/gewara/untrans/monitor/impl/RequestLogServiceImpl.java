package com.gewara.untrans.monitor.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import com.gewara.untrans.monitor.MonitorService;
import com.gewara.untrans.monitor.RequestLogService;
import com.gewara.util.Assert;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.GewaLogger;
import com.gewara.util.IPUtil;
import com.gewara.util.StringUtil;
import com.gewara.util.WebLogger;
import com.gewara.web.util.LoginUtils;
import com.gewara.web.util.ReqLogUtil;

import eu.bitwalker.useragentutils.UserAgent;

/**
 * 1、参数超过最大长度的都截取
 * 2、参数名称在sensitiveList中的都md5加密
 * 3、在ignoreUriList中的uri忽略掉
 */
public class RequestLogServiceImpl implements RequestLogService, InitializingBean{
	public static final String REQ_LOG_ENTRY_KEY_PRE = "log_";
	private static final String ERROR_TMID = "9999";
	private String DEFAULT_CONF = "request_log_default.conf";
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private Set<String> sensitiveList = new HashSet<String>(Arrays.asList("mobile", "pass", "sign", "encode"));
	private Set<String> ignoreUriList = new HashSet<String>();
	private List<String> ignoreUriPreList = new ArrayList<String>();//前缀
	private int valueMaxLength = 64;
	
	private String configFile = "requestLog.conf"; 
	
	private MonitorService monitorService; 
	
	@Override
	public void addSensitiveWords(String words){
		sensitiveList.addAll(Arrays.asList(StringUtils.split(words, ",")));
	}
	
	@Override
	public void logRequest(String ip, String uri, Map<String, String> params, HttpServletRequest req, ServletRequestHandledEvent event) {
		if(!isIgnore(ip, uri)){
			String referer = req.getHeader("referer");
			String xForwardedHost = req.getHeader("x-forwarded-host");
			String isAjaxReq = BaseWebUtils.isAjaxRequest(req)?"Y":"N";
			String uvKey = "";
			String memberKey = "";
			String[] trace = LoginUtils.getTracePair(req);
			if(trace!=null){
				uvKey = trace[0];
				if(trace.length == 2){
					memberKey = trace[1];
				}
			}
			String userAgent = req.getHeader("user-agent");
			Map<String, String> logMap = (Map<String, String>) req.getAttribute(ReqLogUtil.REQ_LOG_ENTRY_ATTR_KEY);
			logRequestInternal(ip, uri, referer, userAgent, xForwardedHost, params, isAjaxReq, uvKey, memberKey, logMap, event);
		}
	}	
	@Override
	public void logRequest(String ip, String uri, String referer, String userAgent, String xForwardedHost, Map<String, String> params, String isAjaxReq, String uvKey, String memberKey){
		if(!isIgnore(ip, uri)){
			logRequestInternal(ip, uri, referer, userAgent, xForwardedHost, params, isAjaxReq, uvKey, memberKey, null, null);
		}
	}
	private void logRequestInternal(String ip, String uri, String referer, String userAgent, String xForwardedHost, Map<String, String> params, 
			String isAjaxReq, String uvKey, String memberKey, Map<String, String> logMap, ServletRequestHandledEvent event){
		try{
			Map<String, String> logEntry = getLogParams(params);
			logEntry.put("info_ajax", isAjaxReq);
			logEntry.put("info_uvkey", StringUtils.defaultIfBlank(uvKey,"none"));
			if(StringUtils.isNotBlank(memberKey)){
				logEntry.put("info_tmid", StringUtils.defaultString(LoginUtils.getUserIdByTraceId(memberKey), ERROR_TMID));
			}else{
				logEntry.put("info_tmid", "0");
			}
			logEntry.put("info_referer", normalReferer(referer));
			logEntry.put("info_host", StringUtils.defaultString(xForwardedHost, "none"));
			logEntry.put("info_uri", uri);
			logEntry.put("info_ip", ip);
			logEntry.put("info_accesstime", DateUtil.getCurFullTimestampStr());
			//logEntry.put("info_robot", BaseWebUtils.isRobot(userAgent)?"Y":"N");
			String[] loc = IPUtil.findProAndCityByIp(ip);
			logEntry.put("info_procode", StringUtils.defaultString(loc[0], "none"));
			logEntry.put("info_citycode", StringUtils.defaultString(loc[1], "none"));
			if(StringUtils.isNotBlank(userAgent)){
				UserAgent ua = new UserAgent(userAgent);
				logEntry.put("info_osname", ua.getOperatingSystem().getName());
				logEntry.put("info_browser", ua.getBrowser().getName());
				logEntry.put("info_device", ua.getOperatingSystem().getDeviceType().getName());
			}
			if(event!=null){
				logEntry.put("info_processtime", "" + event.getProcessingTimeMillis());
				logEntry.put("info_status", "" + event.getStatusCode());
			}
			if(logMap!=null){
				logEntry.putAll(logMap);
			}
			monitorService.addAccessLog(logEntry);
		}catch(Exception e){
			dbLogger.warn(e, 30);
		}
	}
	
	

	private boolean isIgnore(String ip, String uri){
		if(GewaIpConfig.isGewaInnerIp(ip)){
			return true;
		}
		if(ignoreUriList.contains(uri)){
			return true;
		}
		for(String ignore: ignoreUriPreList){
			if(StringUtils.startsWith(uri, ignore)){
				return true;
			}
		}
		return false;
	}
	
	protected String normalReferer(String referer){//去除关键字
		if(StringUtils.isBlank(referer)){
			return "none";
		}
		if(StringUtils.contains(referer, "gewara")){//内部引用，去除query_string，防止敏感信息泄露
			int idx = referer.indexOf('?');
			if(idx> 0){
				return referer.substring(0, idx);
			}
		}
		return referer;
	}
	
	@Override
	public void addIgnoreUriList(List<String> ignoreList) {
		for(String ignore: ignoreList){
			int idx = ignore.indexOf('*');
			if(idx>0){
				this.ignoreUriPreList.add(StringUtils.trim(ignore.substring(0, idx)));
			}else{
				this.ignoreUriList.add(StringUtils.trim(ignore));
			}
		}
	}
	protected Map<String, String> getLogParams(Map<String, String> params){
		Map<String, String> result = new LinkedHashMap<String, String>();

		for(Map.Entry<String, String> entry: params.entrySet()){
			String pname = entry.getKey();
			String pv = entry.getValue();
			for(String key: sensitiveList){//敏感
				if(StringUtils.containsIgnoreCase(pname, key) && StringUtils.isNotBlank(pv)){
					pv = "MG" + StringUtil.md5("kcj3STidSC" + pv);
					break;
				}
			}
			int valueLen = StringUtils.length(pv);
			if(valueLen > valueMaxLength){
				pv = StringUtils.substring(pv, 0, valueMaxLength) + "@LEN:" + valueLen;
			}
			result.put(pname, pv);
		}
		return result;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		try(InputStream stream = this.getClass().getClassLoader().getResourceAsStream(DEFAULT_CONF)){
			initConf(stream);	
		}
		
		if(StringUtils.isNotBlank(configFile)){
			try(InputStream is = this.getClass().getClassLoader().getResourceAsStream(configFile)){
				initConf(is);
			}
		}
		Assert.notNull(monitorService);
	}
	private void initConf(InputStream stream) throws Exception {
		if(stream!=null){
			List<String> rows = IOUtils.readLines(stream, "utf-8");
			List<String> ignoreList = new ArrayList<String>();
			for(String row:rows){
				if(StringUtils.startsWith(row, "ignore:")){
					ignoreList.addAll(Arrays.asList(StringUtils.split(row.substring(7), ",")));
				}else if(StringUtils.startsWith(row, "keyword:")){
					addSensitiveWords(row.substring(8));
				}
			}
			addIgnoreUriList(ignoreList);
			dbLogger.warn("init requst log conf,row:" + rows.size() + ",ignore:" + ignoreList.size() + ",keywords:" + sensitiveList.size());
		}
	}

	public void setMonitorService(MonitorService monitorService) {
		this.monitorService = monitorService;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}

}
