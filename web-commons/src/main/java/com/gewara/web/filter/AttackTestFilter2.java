package com.gewara.web.filter;

import java.io.CharConversionException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.ServletRequestHandledEvent;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gewara.helper.sys.CachedScript;
import com.gewara.helper.sys.CachedScript.ScriptResult;
import com.gewara.helper.sys.ScriptEngineUtil;
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

/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28锟斤拷锟斤拷02:05:17
 */
public class AttackTestFilter2 extends OncePerRequestFilter {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());

	private int blackCount = 0;
	@Autowired
	private AttackTestService attackTestService;
	@Autowired
	private MonitorService monitorService;

	@Autowired(required=false)
	private RequestLogService requestLogService;
	
	private boolean enableAccessLog = false;
	@Override
	protected void initFilterBean(){
		if(requestLogService!=null){
			enableAccessLog = true;
			RequestEventHolder.setEnable(true);
		}
	}
	
	private boolean enableScriptTest = true;
	public void setEnableScriptTest(boolean enableScriptTest) {
		this.enableScriptTest = enableScriptTest;
	}
	
	private String[] scriptEvent = new String[]{"onclick", "onfocus", "onblur", "onload", "onerror"};
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String ip = getRemoteIP(req);
		long t = System.currentTimeMillis();
		boolean multiPart = ServletFileUpload.isMultipartContent(req);
		Map<String, String> params = null;
		
		if(attackTestService.checkBlackReq(ip, uri)){
			blackCount++;
			if(blackCount%100==0){
				dbLogger.warn("old blackip:" + ip + "," + uri + "," + BaseWebUtils.getHeaderStr(req));
				dbLogger.warn(BaseWebUtils.getParamStr(req, false));
			}
			res.sendError(400);
			return;
		}
		checkRegScript(req);

		if(!multiPart && enableScriptTest){
			params = BaseWebUtils.getRequestMap(req);
			for(Map.Entry<String, String> param: params.entrySet()){
				String pv = StringUtils.lowerCase(param.getValue());
				if(StringUtils.isNotBlank(pv)){
					if(StringUtils.contains(pv, "<script") || StringUtils.contains(pv, "javascript") || StringUtils.contains(pv, "</script") ||
							StringUtils.contains(pv, "create") && StringUtils.contains(pv, "element")  ){
						processAttack("XSSATTACK", params, req);
						res.sendError(401);
						return;
					}else if(StringUtils.contains(pv, "../../")){
						processAttack("SQLATTACK", params, req);
						res.sendError(401);
						return;
					}else if(StringUtils.contains(pv, "on")){
						for(String event: scriptEvent){
							if(StringUtils.contains(pv, event)){
								processAttack("XSSATTACK", params, req);
								res.sendError(401);
								return;
							}
						}
					}
				}
			}
			ParamCollectUtils.addNameIfEnabled(t, uri, params);
		}
		
		boolean logAccess = !multiPart && enableAccessLog;
		if(logAccess && params == null) {
			params = BaseWebUtils.getRequestMap(req);
		}
		//-----------------------------------------------------------------------------
		try{
			filterChain.doFilter(req, res);
		}catch(IllegalStateException e){//
			if(e.getCause()!=null && e.getCause() instanceof CharConversionException){
				Map logEntry =new HashMap<String, String>();
				logEntry.put("reqUri", req.getRequestURI());
				logEntry.put("exception", "java.lang.IllegalStateException: java.io.CharConversionException");
				monitorService.logViolation(ip, "MOCKATTACK", logEntry);
			}else{
				throw e;
			}
		}finally{
			ServletRequestHandledEvent event = RequestEventHolder.getAndClearEvent();
			if(logAccess){
				requestLogService.logRequest(ip, uri, params, req, event);
			}
		}
	}
	private void processAttack(String type, Map<String, String> params, HttpServletRequest req){
		params.putAll(BaseWebUtils.getHeaderMapWidthPreKey(req));
		final String ip = getRemoteIP(req);
		params.put("reqUri", req.getRequestURI());
		monitorService.logViolation(ip, type, params);
		if(!GewaIpConfig.allowOffice(ip)){
			TimerHelper.TIMER.schedule(new TimerTask(){
				@Override
				public void run() {
					attackTestService.addRealBlack(ip, null, 10);
				}}, 500);
		}
	}
	private String getRemoteIP(HttpServletRequest request){
		String remoteIp = BaseWebUtils.getRemoteIp(request);
		if(GewaIpConfig.isGewaInnerIp(remoteIp)){
			String remoteIp2 = request.getHeader("gewa-remote-ip");
			if(StringUtils.isNotBlank(remoteIp2)){
				remoteIp = remoteIp2;
			}
		}
		return remoteIp;
	}
	/**
	 * 锟斤拷锟剿关硷拷路锟斤拷锟斤拷锟斤拷
	 * @param req
	 */
	private void checkRegScript(HttpServletRequest req){
		try{
			String ip = BaseWebUtils.getRemoteIp(req);
			if(GewaIpConfig.isGewaInnerIp(ip) || GewaIpConfig.isOfficeIp(ip)){
				return;
			}
			
			String script = attackTestService.getRegScript(req.getRequestURI());
			if(StringUtils.isBlank(script)){
				return;
			}
			Map<String, Object> context = new HashMap<String, Object>();
			context.put("isAjax", BaseWebUtils.isAjaxRequest(req));
			context.put("referer", req.getHeader("referer"));
			if(!triggerRule(script, context)){
				logViolation(req);//
			}
		}catch(Throwable e){
			dbLogger.warn(e, 10);
		}
	}
	
	public void logViolation(HttpServletRequest request) {
		Map<String, String> params = BaseWebUtils.getRequestMap(request);
		params.putAll(BaseWebUtils.getHeaderMapWidthPreKey(request));
		String ip = BaseWebUtils.getRemoteIp(request);
		String uri = request.getRequestURI();
		monitorService.logViolation(ip, uri, params);
	}
	
	private boolean triggerRule(String scriptTxt, Map context){
		if(StringUtils.isBlank(scriptTxt) || BeanUtil.isEmptyContainer(context)) {
            return false;
        }
		CachedScript script = ScriptEngineUtil.buildCachedScript(scriptTxt, true);
		ScriptResult<Boolean> result = script.run(context);
		if(result.hasError() || result.getRetval()==null) {
            return false;
        }
		return result.getRetval();
	}

}
