package com.gewara.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.async.WebAsyncUtils;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.WebUtils;

import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.context.request.async.ResourceStatsContainer;
import com.gewara.web.support.DynamicStats.LogCounter;
import com.gewara.web.support.ResourceStatsUtil;

/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28下午02:05:17
 */
public class ResourceStatsFilter extends GenericFilterBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	//--------------------------------------copy from OncePerRequestFilter--------------------------------------------------
	public static final String ALREADY_FILTERED_SUFFIX = ".FILTERED";
	@Override
	public final void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
			throw new ServletException("OncePerRequestFilter just supports HTTP requests");
		}
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String alreadyFilteredAttributeName = getAlreadyFilteredAttributeName();
		boolean hasAlreadyFilteredAttribute = request.getAttribute(alreadyFilteredAttributeName) != null;

		if (hasAlreadyFilteredAttribute || skipDispatch(httpRequest) || shouldNotFilter(httpRequest)) {
			try{
				// Proceed without invoking this filter...
				filterChain.doFilter(request, response);
			}finally{
				//第二次进入filter，记录异步处理时间 
				ResourceStatsContainer container = (ResourceStatsContainer) httpRequest.getAttribute(ResourceStatsContainer.RESOURCE_STATS);
				if(container != null){
					container.processStats();
				}else{
					dbLogger.error("the ResourceStatsContainer is null:" + httpRequest.getRequestURI());
				}
			}
		}else {
			// Do invoke this filter...
			request.setAttribute(alreadyFilteredAttributeName, Boolean.TRUE);
			try {
				doFilterInternal(httpRequest, httpResponse, filterChain);
			}
			finally {
				// Remove the "already filtered" request attribute for this request.
				request.removeAttribute(alreadyFilteredAttributeName);
			}
		}
	}

	private boolean skipDispatch(HttpServletRequest request) {
		if (isAsyncDispatch(request) && shouldNotFilterAsyncDispatch()) {
			return true;
		}
		if (request.getAttribute(WebUtils.ERROR_REQUEST_URI_ATTRIBUTE) != null && shouldNotFilterErrorDispatch()) {
			Throwable ex = (Throwable) request.getAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE);
			if( ex != null){
				dbLogger.error(request.getAttribute(WebUtils.ERROR_REQUEST_URI_ATTRIBUTE).toString(), ex, 10);
			}
			return true;
		}
		return false;
	}

	protected boolean isAsyncDispatch(HttpServletRequest request) {
		return WebAsyncUtils.getAsyncManager(request).hasConcurrentResult();
	}

	protected boolean isAsyncStarted(HttpServletRequest request) {
		return WebAsyncUtils.getAsyncManager(request).isConcurrentHandlingStarted();
	}

	protected String getAlreadyFilteredAttributeName() {
		String name = getFilterName();
		if (name == null) {
			name = getClass().getName();
		}
		return name + ALREADY_FILTERED_SUFFIX;
	}
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return false;
	}
	protected boolean shouldNotFilterAsyncDispatch() {
		return true;
	}

	protected boolean shouldNotFilterErrorDispatch() {
		return true;
	}
	//--------------------------------------end copy--------------------------------------------------

	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
		String uri = req.getRequestURI();
		long t = System.currentTimeMillis();
		boolean multiPart = ServletFileUpload.isMultipartContent(req);

		LogCounter counter = ResourceStatsUtil.getUriStats().beforeProcess(uri, t);
		Integer loc = ResourceStatsUtil.recordRequest(req, multiPart);
		
		//----- 异步逻辑处理需要, 第一次进入filter保存到request中--------------------------------------------------------
		ResourceStatsContainer container = new ResourceStatsContainer(counter, t, loc);
		req.setAttribute(ResourceStatsContainer.RESOURCE_STATS, container);
		//-----------------------------------------------------------------------------
		try{
			filterChain.doFilter(req, res);
		}finally{
			if(!StringUtils.equals("asynch", ResourceStatsUtil.getUriStats().getSpecialType(uri))){
				ResourceStatsUtil.getUriStats().afterProcess(counter, t, false);
				ResourceStatsUtil.clearRequest(loc);
			}
		}
	}
}
