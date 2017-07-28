/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.impl;

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
import eu.bitwalker.useragentutils.UserAgent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.support.ServletRequestHandledEvent;

public class RequestLogServiceImpl implements RequestLogService, InitializingBean {
	public static final String REQ_LOG_ENTRY_KEY_PRE = "log_";
	private static final String ERROR_TMID = "9999";
	private String DEFAULT_CONF = "request_log_default.conf";
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private Set<String> sensitiveList = new HashSet(Arrays.asList(new String[]{"mobile", "pass", "sign", "encode"}));
	private Set<String> ignoreUriList = new HashSet();
	private List<String> ignoreUriPreList = new ArrayList();
	private int valueMaxLength = 64;
	private String configFile = "requestLog.conf";
	private MonitorService monitorService;

	public void addSensitiveWords(String words) {
		this.sensitiveList.addAll(Arrays.asList(StringUtils.split(words, ",")));
	}

	public void logRequest(String ip, String uri, Map<String, String> params, HttpServletRequest req,
			ServletRequestHandledEvent event) {
		if (!this.isIgnore(ip, uri)) {
			String referer = req.getHeader("referer");
			String xForwardedHost = req.getHeader("x-forwarded-host");
			String isAjaxReq = BaseWebUtils.isAjaxRequest(req) ? "Y" : "N";
			String uvKey = "";
			String memberKey = "";
			String[] trace = LoginUtils.getTracePair(req);
			if (trace != null) {
				uvKey = trace[0];
				if (trace.length == 2) {
					memberKey = trace[1];
				}
			}

			String userAgent = req.getHeader("user-agent");
			Map logMap = (Map) req.getAttribute("_REQ_LOG_ENTRY_KEY");
			this.logRequestInternal(ip, uri, referer, userAgent, xForwardedHost, params, isAjaxReq, uvKey, memberKey,
					logMap, event);
		}

	}

	public void logRequest(String ip, String uri, String referer, String userAgent, String xForwardedHost,
			Map<String, String> params, String isAjaxReq, String uvKey, String memberKey) {
		if (!this.isIgnore(ip, uri)) {
			this.logRequestInternal(ip, uri, referer, userAgent, xForwardedHost, params, isAjaxReq, uvKey, memberKey,
					(Map) null, (ServletRequestHandledEvent) null);
		}

	}

	private void logRequestInternal(String ip, String uri, String referer, String userAgent, String xForwardedHost,
			Map<String, String> params, String isAjaxReq, String uvKey, String memberKey, Map<String, String> logMap,
			ServletRequestHandledEvent event) {
		try {
			Map e = this.getLogParams(params);
			e.put("info_ajax", isAjaxReq);
			e.put("info_uvkey", StringUtils.defaultIfBlank(uvKey, "none"));
			if (StringUtils.isNotBlank(memberKey)) {
				e.put("info_tmid", StringUtils.defaultString(LoginUtils.getUserIdByTraceId(memberKey), "9999"));
			} else {
				e.put("info_tmid", "0");
			}

			e.put("info_referer", this.normalReferer(referer));
			e.put("info_host", StringUtils.defaultString(xForwardedHost, "none"));
			e.put("info_uri", uri);
			e.put("info_ip", ip);
			e.put("info_accesstime", DateUtil.getCurFullTimestampStr());
			String[] loc = IPUtil.findProAndCityByIp(ip);
			e.put("info_procode", StringUtils.defaultString(loc[0], "none"));
			e.put("info_citycode", StringUtils.defaultString(loc[1], "none"));
			if (StringUtils.isNotBlank(userAgent)) {
				UserAgent ua = new UserAgent(userAgent);
				e.put("info_osname", ua.getOperatingSystem().getName());
				e.put("info_browser", ua.getBrowser().getName());
				e.put("info_device", ua.getOperatingSystem().getDeviceType().getName());
			}

			if (event != null) {
				e.put("info_processtime", "" + event.getProcessingTimeMillis());
				e.put("info_status", "" + event.getStatusCode());
			}

			if (logMap != null) {
				e.putAll(logMap);
			}

			this.monitorService.addAccessLog(e);
		} catch (Exception arg14) {
			this.dbLogger.warn(arg14, 30);
		}

	}

	private boolean isIgnore(String ip, String uri) {
		if (GewaIpConfig.isGewaInnerIp(ip)) {
			return true;
		} else if (this.ignoreUriList.contains(uri)) {
			return true;
		} else {
			Iterator arg2 = this.ignoreUriPreList.iterator();

			String ignore;
			do {
				if (!arg2.hasNext()) {
					return false;
				}

				ignore = (String) arg2.next();
			} while (!StringUtils.startsWith(uri, ignore));

			return true;
		}
	}

	protected String normalReferer(String referer) {
		if (StringUtils.isBlank(referer)) {
			return "none";
		} else {
			if (StringUtils.contains(referer, "gewara")) {
				int idx = referer.indexOf(63);
				if (idx > 0) {
					return referer.substring(0, idx);
				}
			}

			return referer;
		}
	}

	public void addIgnoreUriList(List<String> ignoreList) {
		Iterator arg1 = ignoreList.iterator();

		while (arg1.hasNext()) {
			String ignore = (String) arg1.next();
			int idx = ignore.indexOf(42);
			if (idx > 0) {
				this.ignoreUriPreList.add(StringUtils.trim(ignore.substring(0, idx)));
			} else {
				this.ignoreUriList.add(StringUtils.trim(ignore));
			}
		}

	}

	protected Map<String, String> getLogParams(Map<String, String> params) {
		LinkedHashMap result = new LinkedHashMap();

		String pname;
		String pv;
		for (Iterator arg2 = params.entrySet().iterator(); arg2.hasNext(); result.put(pname, pv)) {
			Entry entry = (Entry) arg2.next();
			pname = (String) entry.getKey();
			pv = (String) entry.getValue();
			Iterator valueLen = this.sensitiveList.iterator();

			while (valueLen.hasNext()) {
				String key = (String) valueLen.next();
				if (StringUtils.containsIgnoreCase(pname, key) && StringUtils.isNotBlank(pv)) {
					pv = "MG" + StringUtil.md5("kcj3STidSC" + pv);
					break;
				}
			}

			int valueLen1 = StringUtils.length(pv);
			if (valueLen1 > this.valueMaxLength) {
				pv = StringUtils.substring(pv, 0, this.valueMaxLength) + "@LEN:" + valueLen1;
			}
		}

		return result;
	}

	public void afterPropertiesSet() throws Exception {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(this.DEFAULT_CONF);
		Throwable arg1 = null;

		try {
			this.initConf(is);
		} catch (Throwable arg25) {
			arg1 = arg25;
			throw arg25;
		} finally {
			if (is != null) {
				if (arg1 != null) {
					try {
						is.close();
					} catch (Throwable arg23) {
						arg1.addSuppressed(arg23);
					}
				} else {
					is.close();
				}
			}

		}

		if (StringUtils.isNotBlank(this.configFile)) {
			is = this.getClass().getClassLoader().getResourceAsStream(this.configFile);
			arg1 = null;

			try {
				this.initConf(is);
			} catch (Throwable arg24) {
				arg1 = arg24;
				throw arg24;
			} finally {
				if (is != null) {
					if (arg1 != null) {
						try {
							is.close();
						} catch (Throwable arg22) {
							arg1.addSuppressed(arg22);
						}
					} else {
						is.close();
					}
				}

			}
		}

		Assert.notNull(this.monitorService);
	}

	private void initConf(InputStream stream) throws Exception {
		if (stream != null) {
			List rows = IOUtils.readLines(stream, "utf-8");
			ArrayList ignoreList = new ArrayList();
			Iterator arg3 = rows.iterator();

			while (arg3.hasNext()) {
				String row = (String) arg3.next();
				if (StringUtils.startsWith(row, "ignore:")) {
					ignoreList.addAll(Arrays.asList(StringUtils.split(row.substring(7), ",")));
				} else if (StringUtils.startsWith(row, "keyword:")) {
					this.addSensitiveWords(row.substring(8));
				}
			}

			this.addIgnoreUriList(ignoreList);
			this.dbLogger.warn("init requst log conf,row:" + rows.size() + ",ignore:" + ignoreList.size() + ",keywords:"
					+ this.sensitiveList.size());
		}

	}

	public void setMonitorService(MonitorService monitorService) {
		this.monitorService = monitorService;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}
}