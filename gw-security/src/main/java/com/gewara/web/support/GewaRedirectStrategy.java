package com.gewara.web.support;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.RedirectStrategy;

import com.gewara.util.BaseWebUtils;
/**
 * ��¼��ת��Ҫ��֧��POST
 * @author acerge(acerge@163.com)
 * @since 7:38:30 PM Jan 11, 2011
 */
public class GewaRedirectStrategy implements RedirectStrategy {
	private boolean contextRelative;
	@Override
	public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		String redirectUrl = calculateRedirectUrl(request.getContextPath(), url);
		String params = "";
		int idx = redirectUrl.indexOf('?');
		if(idx>0){
			params = BaseWebUtils.encodeParam(redirectUrl.substring(idx+1), "utf-8");
			redirectUrl = redirectUrl.substring(0, idx);
			if(StringUtils.isNotBlank(params)) {
                redirectUrl += "?" + params;
            }
		}
		//HttpUtils.parseQueryStr(queryString, encode)
		//redirectUrl = response.encodeRedirectURL(redirectUrl);
		response.sendRedirect(redirectUrl);
	}

	private String calculateRedirectUrl(String contextPath, String url) {
		if (!url.startsWith("http://") && !url.startsWith("https://")) {
			if (contextRelative) {
				return url;
			} else {
				return contextPath + url;
			}
		}
		if (!contextRelative) {
			return url;
		}
		url = url.substring(url.indexOf("://") + 3); // strip off protocol
		url = url.substring(url.indexOf(contextPath) + contextPath.length());

		if (url.length() > 1 && url.charAt(0) == '/') {
			url = url.substring(1);
		}

		return url;
	}

	/**
	 * If <tt>true</tt>, causes any redirection URLs to be calculated minus the protocol
	 * and context path (defaults to <tt>false</tt>).
	 */
	public void setContextRelative(boolean useRelativeContext) {
		this.contextRelative = useRelativeContext;
	}
}
