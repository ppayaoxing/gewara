/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import com.gewara.util.BaseWebUtils;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.RedirectStrategy;

public class GewaRedirectStrategy implements RedirectStrategy {
	private boolean contextRelative;

	public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		String redirectUrl = this.calculateRedirectUrl(request.getContextPath(), url);
		String params = "";
		int idx = redirectUrl.indexOf(63);
		if (idx > 0) {
			params = BaseWebUtils.encodeParam(redirectUrl.substring(idx + 1), "utf-8");
			redirectUrl = redirectUrl.substring(0, idx);
			if (StringUtils.isNotBlank(params)) {
				redirectUrl = redirectUrl + "?" + params;
			}
		}

		response.sendRedirect(redirectUrl);
	}

	private String calculateRedirectUrl(String contextPath, String url) {
		if (!url.startsWith("http://") && !url.startsWith("https://")) {
			return this.contextRelative ? url : contextPath + url;
		} else if (!this.contextRelative) {
			return url;
		} else {
			url = url.substring(url.indexOf("://") + 3);
			url = url.substring(url.indexOf(contextPath) + contextPath.length());
			if (url.length() > 1 && url.charAt(0) == 47) {
				url = url.substring(1);
			}

			return url;
		}
	}

	public void setContextRelative(boolean useRelativeContext) {
		this.contextRelative = useRelativeContext;
	}
}