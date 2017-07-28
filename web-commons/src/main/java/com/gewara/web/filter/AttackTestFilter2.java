/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.filter;

import com.gewara.helper.sys.CachedScript;
import com.gewara.helper.sys.ScriptEngineUtil;
import com.gewara.helper.sys.CachedScript.ScriptResult;
import com.gewara.untrans.AttackTestService;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.untrans.monitor.RequestLogService;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.BeanUtil;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.GewaLogger;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;
import com.gewara.web.support.RequestEventHolder;
import com.gewara.web.util.ParamCollectUtils;
import java.io.CharConversionException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimerTask;
import java.util.Map.Entry;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.ServletRequestHandledEvent;
import org.springframework.web.filter.OncePerRequestFilter;

public class AttackTestFilter2 extends OncePerRequestFilter {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private int blackCount = 0;
	@Autowired
	private AttackTestService attackTestService;
	@Autowired
	private MonitorService monitorService;
	@Autowired(required = false)
	private RequestLogService requestLogService;
	private boolean enableAccessLog = false;
	private boolean enableScriptTest = true;
	private String[] scriptEvent = new String[]{"onclick", "onfocus", "onblur", "onload", "onerror"};

	protected void initFilterBean() {
		if (this.requestLogService != null) {
			this.enableAccessLog = true;
			RequestEventHolder.setEnable(true);
		}

	}

	public void setEnableScriptTest(boolean enableScriptTest) {
		this.enableScriptTest = enableScriptTest;
	}

	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		String uri = req.getRequestURI();
		String ip = this.getRemoteIP(req);
		long t = System.currentTimeMillis();
		boolean multiPart = ServletFileUpload.isMultipartContent(req);
		Map params = null;
		if (this.attackTestService.checkBlackReq(ip, uri)) {
			++this.blackCount;
			if (this.blackCount % 100 == 0) {
				this.dbLogger.warn("old blackip:" + ip + "," + uri + "," + BaseWebUtils.getHeaderStr(req));
				this.dbLogger.warn(BaseWebUtils.getParamStr(req, false, new String[0]));
			}

			res.sendError(400);
		} else {
			this.checkRegScript(req);
			if (!multiPart && this.enableScriptTest) {
				params = BaseWebUtils.getRequestMap(req);
				Iterator logAccess = params.entrySet().iterator();

				label239 : while (true) {
					String logEntry;
					do {
						if (!logAccess.hasNext()) {
							ParamCollectUtils.addNameIfEnabled(t, uri, params);
							break label239;
						}

						Entry event = (Entry) logAccess.next();
						logEntry = StringUtils.lowerCase((String) event.getValue());
					} while (!StringUtils.isNotBlank(logEntry));

					if (StringUtils.contains(logEntry, "<script") || StringUtils.contains(logEntry, "javascript")
							|| StringUtils.contains(logEntry, "</script")
							|| StringUtils.contains(logEntry, "create") && StringUtils.contains(logEntry, "element")) {
						this.processAttack("XSSATTACK", params, req);
						res.sendError(401);
						return;
					}

					if (StringUtils.contains(logEntry, "../../")) {
						this.processAttack("SQLATTACK", params, req);
						res.sendError(401);
						return;
					}

					if (StringUtils.contains(logEntry, "on")) {
						String[] arg12 = this.scriptEvent;
						int arg13 = arg12.length;

						for (int arg14 = 0; arg14 < arg13; ++arg14) {
							String event1 = arg12[arg14];
							if (StringUtils.contains(logEntry, event1)) {
								this.processAttack("XSSATTACK", params, req);
								res.sendError(401);
								return;
							}
						}
					}
				}
			}

			boolean arg23 = !multiPart && this.enableAccessLog;
			if (arg23 && params == null) {
				params = BaseWebUtils.getRequestMap(req);
			}

			boolean arg20 = false;

			ServletRequestHandledEvent arg24;
			label265 : {
				try {
					arg20 = true;
					filterChain.doFilter(req, res);
					arg20 = false;
					break label265;
				} catch (IllegalStateException arg21) {
					if (arg21.getCause() == null || !(arg21.getCause() instanceof CharConversionException)) {
						throw arg21;
					}

					HashMap arg25 = new HashMap();
					arg25.put("reqUri", req.getRequestURI());
					arg25.put("exception", "java.lang.IllegalStateException: java.io.CharConversionException");
					this.monitorService.logViolation(ip, "MOCKATTACK", arg25);
					arg20 = false;
				} finally {
					if (arg20) {
						ServletRequestHandledEvent event2 = RequestEventHolder.getAndClearEvent();
						if (arg23) {
							this.requestLogService.logRequest(ip, uri, params, req, event2);
						}

					}
				}

				arg24 = RequestEventHolder.getAndClearEvent();
				if (arg23) {
					this.requestLogService.logRequest(ip, uri, params, req, arg24);
				}

				return;
			}

			arg24 = RequestEventHolder.getAndClearEvent();
			if (arg23) {
				this.requestLogService.logRequest(ip, uri, params, req, arg24);
			}

		}
	}

	private void processAttack(String type, Map<String, String> params, HttpServletRequest req) {
		params.putAll(BaseWebUtils.getHeaderMapWidthPreKey(req));
		final String ip = this.getRemoteIP(req);
		params.put("reqUri", req.getRequestURI());
		this.monitorService.logViolation(ip, type, params);
		if (!GewaIpConfig.allowOffice(ip)) {
			TimerHelper.TIMER.schedule(new TimerTask() {
				public void run() {
					AttackTestFilter2.this.attackTestService.addRealBlack(ip, (String) null, 10);
				}
			}, 500L);
		}

	}

	private String getRemoteIP(HttpServletRequest request) {
		String remoteIp = BaseWebUtils.getRemoteIp(request);
		if (GewaIpConfig.isGewaInnerIp(remoteIp)) {
			String remoteIp2 = request.getHeader("gewa-remote-ip");
			if (StringUtils.isNotBlank(remoteIp2)) {
				remoteIp = remoteIp2;
			}
		}

		return remoteIp;
	}

	private void checkRegScript(HttpServletRequest req) {
		try {
			String e = BaseWebUtils.getRemoteIp(req);
			if (GewaIpConfig.isGewaInnerIp(e) || GewaIpConfig.isOfficeIp(e)) {
				return;
			}

			String script = this.attackTestService.getRegScript(req.getRequestURI());
			if (StringUtils.isBlank(script)) {
				return;
			}

			HashMap context = new HashMap();
			context.put("isAjax", Boolean.valueOf(BaseWebUtils.isAjaxRequest(req)));
			context.put("referer", req.getHeader("referer"));
			if (!this.triggerRule(script, context)) {
				this.logViolation(req);
			}
		} catch (Throwable arg4) {
			this.dbLogger.warn(arg4, 10);
		}

	}

	public void logViolation(HttpServletRequest request) {
		Map params = BaseWebUtils.getRequestMap(request);
		params.putAll(BaseWebUtils.getHeaderMapWidthPreKey(request));
		String ip = BaseWebUtils.getRemoteIp(request);
		String uri = request.getRequestURI();
		this.monitorService.logViolation(ip, uri, params);
	}

	private boolean triggerRule(String scriptTxt, Map context) {
		if (!StringUtils.isBlank(scriptTxt) && !BeanUtil.isEmptyContainer(context)) {
			CachedScript script = ScriptEngineUtil.buildCachedScript(scriptTxt, true);
			ScriptResult result = script.run(context);
			return !result.hasError() && result.getRetval() != null
					? ((Boolean) result.getRetval()).booleanValue()
					: false;
		} else {
			return false;
		}
	}
}