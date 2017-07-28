/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import com.gewara.web.support.ResourceStatsUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class UriSetRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
	protected Set<String> uriSet = new HashSet();
	protected Set<String> asynchSet = new HashSet();

	protected void handlerMethodsInitialized(Map<RequestMappingInfo, HandlerMethod> handlerMethods) {
		String contextPath = this.getServletContext().getContextPath();
		Iterator arg2 = handlerMethods.entrySet().iterator();

		while (true) {
			Set uris;
			Class type;
			do {
				do {
					if (!arg2.hasNext()) {
						ResourceStatsUtil.registerUri(new HashSet(this.uriSet), contextPath);
						ResourceStatsUtil.addAsynchUri(new HashSet(this.asynchSet), contextPath);
						this.initUriMapping(contextPath, this.uriSet);
						return;
					}

					Entry info = (Entry) arg2.next();
					uris = ((RequestMappingInfo) info.getKey()).getPatternsCondition().getPatterns();
					this.uriSet.addAll(uris);
					type = ((HandlerMethod) info.getValue()).getMethod().getReturnType();
				} while (type == null);
			} while (type != DeferredResult.class && type.getSuperclass() != DeferredResult.class);

			this.asynchSet.addAll(uris);
		}
	}

	protected HandlerMethod lookupHandlerMethod(String lookupPath, HttpServletRequest request) throws Exception {
		return this.uriSet.contains(lookupPath) ? super.lookupHandlerMethod(lookupPath, request) : null;
	}

	protected void initUriMapping(String contextPath, Set<String> uris) {
	}

	protected HandlerExecutionChain getCorsHandlerExecutionChain(HttpServletRequest request,
			HandlerExecutionChain chain, CorsConfiguration config) {
		return chain;
	}
}