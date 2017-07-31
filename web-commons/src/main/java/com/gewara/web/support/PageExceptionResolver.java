package com.gewara.web.support;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.gewara.Config;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public class PageExceptionResolver extends SimpleMappingExceptionResolver implements InitializingBean{
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	@Autowired(required=false)@Qualifier("monitorService")
	private MonitorService monitorService;
	private String sensitive;
	public void setSensitive(String sensitive) {
		this.sensitive = sensitive;
	}
	private String[] sensitiveList = new String[]{};

	protected Map saveExceptionMessage(Exception ex, HttpServletRequest request) {
		String uri = request.getRequestURI();
		String remoteIp = BaseWebUtils.getRemoteIp(request);
		if(GewaIpConfig.isGewaInnerIp(remoteIp)){
			String remoteIp2 = request.getHeader("gewa-remote-ip");
			if(StringUtils.isNotBlank(remoteIp2)){
				remoteIp = remoteIp2;
			}
		}
		
		String title = uri + "@" + Config.getServerIp() + ", RemoteIp:" + remoteIp;
		String reqMap = BaseWebUtils.getParamStr(request, true, sensitiveList);
		Map<String, String> result = new HashMap<String, String>();
		result.put("remoteIp", remoteIp);
		result.put("reqParams", ""+reqMap);
		result.put("reqHeader", BaseWebUtils.getHeaderStr(request));
		result.put("reqUri", uri);
		if(monitorService!=null){
			String excTrace = monitorService.logException(MonitorService.EXCEPTION_TAG.PAGE, uri, title, ex, result);
			dbLogger.error(result+excTrace);
		}else{
			dbLogger.error(result+"");
		}
		return result;
	}
	
	@Override
	protected void logException(Exception ex, HttpServletRequest request) {
		saveExceptionMessage(ex, request);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(StringUtils.isNotBlank(sensitive)){
			sensitiveList = StringUtils.split(sensitive, ",");
		}
	}
}
