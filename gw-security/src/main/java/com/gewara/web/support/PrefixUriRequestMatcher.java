/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.support;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class PrefixUriRequestMatcher implements RequestMatcher {
	private List<String> prefixList = new ArrayList();

	public boolean matches(HttpServletRequest request) {
		if (this.prefixList.isEmpty()) {
			return true;
		} else {
			String uri = request.getRequestURI();
			String ctxPath = request.getContextPath();
			if (StringUtils.isNotEmpty(ctxPath)) {
				uri = uri.substring(ctxPath.length());
			}

			if (!uri.startsWith("/")) {
				uri = "/" + uri;
			}

			Iterator arg3 = this.prefixList.iterator();

			String prefix;
			do {
				if (!arg3.hasNext()) {
					return false;
				}

				prefix = (String) arg3.next();
			} while (!uri.startsWith(prefix));

			return true;
		}
	}

	public void setPrefixUris(String prefixUris) {
		if (StringUtils.isNotBlank(prefixUris)) {
			this.prefixList = Arrays.asList(StringUtils.split(prefixUris, ","));
		}

	}
}