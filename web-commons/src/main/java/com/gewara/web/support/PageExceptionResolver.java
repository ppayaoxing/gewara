/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import com.gewara.Config;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.untrans.monitor.MonitorService.EXCEPTION_TAG;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class PageExceptionResolver extends SimpleMappingExceptionResolver implements InitializingBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	@Autowired(required = false)
	@Qualifier("monitorService")
	private MonitorService monitorService;
	private String sensitive;
	private String[] sensitiveList = new String[0];

	public void setSensitive(String sensitive) {
		this.sensitive = sensitive;
	}

	protected Map saveExceptionMessage(Exception ex, HttpServletRequest request) {
		String uri = request.getRequestURI();
		String remoteIp = BaseWebUtils.getRemoteIp(request);
		String title;
		if (GewaIpConfig.isGewaInnerIp(remoteIp)) {
			title = request.getHeader("gewa-remote-ip");
			if (StringUtils.isNotBlank(title)) {
				remoteIp = title;
			}
		}

		title = uri + "@" + Config.getServerIp() + ", RemoteIp:" + remoteIp;
		String reqMap = BaseWebUtils.getParamStr(request, true, this.sensitiveList);
		HashMap result = new HashMap();
		result.put("remoteIp", remoteIp);
		result.put("reqParams", "" + reqMap);
		result.put("reqHeader", BaseWebUtils.getHeaderStr(request));
		result.put("reqUri", uri);
		if (this.monitorService != null) {
			String excTrace = this.monitorService.logException(EXCEPTION_TAG.PAGE, uri, title, ex, result);
			this.dbLogger.error(result + excTrace);
		} else {
			this.dbLogger.error(result + "");
		}

		return result;
	}

	protected void logException(Exception ex, HttpServletRequest request) {
		this.saveExceptionMessage(ex, request);
	}

	public void afterPropertiesSet() throws Exception {
		if (StringUtils.isNotBlank(this.sensitive)) {
			this.sensitiveList = StringUtils.split(this.sensitive, ",");
		}

	}
}