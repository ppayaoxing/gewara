/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ResourceStatsUtil;
import com.gewara.web.support.WebAppPostProcessor;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.web.servlet.DispatcherServlet;

public class GewaDispatcherServlet extends DispatcherServlet {
	private static final long serialVersionUID = 8852617763890075853L;
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());

	protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.dbLogger.warnWithType("pageNotFound",
				"uri=" + request.getRequestURL().toString() + ", params="
						+ BaseWebUtils.getParamStr(request, true, new String[0]) + ", header="
						+ BaseWebUtils.getHeaderStr(request));
		ResourceStatsUtil.addUrlNoHandler(request.getRequestURI());
		response.sendError(404);
	}

	protected void initFrameworkServlet() throws ServletException {
		WebAppPostProcessor initiator = null;

		try {
			initiator = (WebAppPostProcessor) this.getWebApplicationContext().getBean(WebAppPostProcessor.class);
		} catch (NoSuchBeanDefinitionException arg2) {
			;
		} catch (Exception arg3) {
			this.logger.warn("", arg3);
		}

		if (initiator != null) {
			this.logger.warn("start customer FrameworkServlet..." + initiator.getClass());
			initiator.init();
		}

	}
}