package com.gewara.web.support;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class UriSetRequestMappingHandlerMapping extends RequestMappingHandlerMapping{
	protected Set<String> uriSet = new HashSet<String>();
	protected Set<String> asynchSet = new HashSet<String>();
	@Override
	protected void handlerMethodsInitialized(Map<RequestMappingInfo, HandlerMethod> handlerMethods) {
		String contextPath = this.getServletContext().getContextPath();
		
		for(Map.Entry<RequestMappingInfo, HandlerMethod> info: handlerMethods.entrySet()){
			Set<String> uris = info.getKey().getPatternsCondition().getPatterns();
			uriSet.addAll(uris);
			Class<?> type = info.getValue().getMethod().getReturnType();
			if(type!=null && (type == DeferredResult.class || type.getSuperclass() == DeferredResult.class)){
				asynchSet.addAll(uris);
			}
		}
		ResourceStatsUtil.registerUri(new HashSet<String>(uriSet), contextPath);
		ResourceStatsUtil.addAsynchUri(new HashSet<String>(asynchSet), contextPath);
		initUriMapping(contextPath, uriSet);
	}
	@Override
	protected HandlerMethod lookupHandlerMethod(String lookupPath, HttpServletRequest request) throws Exception {
		if(uriSet.contains(lookupPath)){
			return super.lookupHandlerMethod(lookupPath, request);
		}else{
			return null;
		}
	}
	protected void initUriMapping(String contextPath, Set<String> uris){
	}
	/**
	 * Update the HandlerExecutionChain for CORS-related handling.
	 * <p>For pre-flight requests, the default implementation replaces the selected
	 * handler with a simple HttpRequestHandler that invokes the configured
	 * {@link #setCorsProcessor}.
	 * <p>For actual requests, the default implementation inserts a
	 * HandlerInterceptor that makes CORS-related checks and adds CORS headers.
	 * @param request the current request
	 * @param chain the handler chain
	 * @param config the applicable CORS configuration, possibly {@code null}
	 * @since 4.2
	 */
	@Override
	protected HandlerExecutionChain getCorsHandlerExecutionChain(HttpServletRequest request,
			HandlerExecutionChain chain, CorsConfiguration config) {
//discard spring cors processing
/*		if (CorsUtils.isPreFlightRequest(request)) {
			HandlerInterceptor[] interceptors = chain.getInterceptors();
			chain = new HandlerExecutionChain(new PreFlightHandler(config), interceptors);
		}
		else {
			chain.addInterceptor(new CorsInterceptor(config));
		}
*/
		return chain;
	}
}
