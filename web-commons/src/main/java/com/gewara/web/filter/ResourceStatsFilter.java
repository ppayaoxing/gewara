/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.filter;

import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.context.request.async.ResourceStatsContainer;
import com.gewara.web.support.ResourceStatsUtil;
import com.gewara.web.support.DynamicStats.LogCounter;
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

public class ResourceStatsFilter extends GenericFilterBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	public static final String ALREADY_FILTERED_SUFFIX = ".FILTERED";

	public final void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			String alreadyFilteredAttributeName = this.getAlreadyFilteredAttributeName();
			boolean hasAlreadyFilteredAttribute = request.getAttribute(alreadyFilteredAttributeName) != null;
			if (!hasAlreadyFilteredAttribute && !this.skipDispatch(httpRequest) && !this.shouldNotFilter(httpRequest)) {
				request.setAttribute(alreadyFilteredAttributeName, Boolean.TRUE);

				try {
					this.doFilterInternal(httpRequest, httpResponse, filterChain);
				} finally {
					request.removeAttribute(alreadyFilteredAttributeName);
				}
			} else {
				boolean arg13 = false;

				try {
					arg13 = true;
					filterChain.doFilter(request, response);
					arg13 = false;
				} finally {
					if (arg13) {
						ResourceStatsContainer container1 = (ResourceStatsContainer) httpRequest
								.getAttribute(ResourceStatsContainer.RESOURCE_STATS);
						if (container1 != null) {
							container1.processStats();
						} else {
							this.dbLogger.error("the ResourceStatsContainer is null:" + httpRequest.getRequestURI());
						}

					}
				}

				ResourceStatsContainer container = (ResourceStatsContainer) httpRequest
						.getAttribute(ResourceStatsContainer.RESOURCE_STATS);
				if (container != null) {
					container.processStats();
				} else {
					this.dbLogger.error("the ResourceStatsContainer is null:" + httpRequest.getRequestURI());
				}
			}

		} else {
			throw new ServletException("OncePerRequestFilter just supports HTTP requests");
		}
	}

	private boolean skipDispatch(HttpServletRequest request) {
		if (this.isAsyncDispatch(request) && this.shouldNotFilterAsyncDispatch()) {
			return true;
		} else if (request.getAttribute("javax.servlet.error.request_uri") != null
				&& this.shouldNotFilterErrorDispatch()) {
			Throwable ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
			if (ex != null) {
				this.dbLogger.error(request.getAttribute("javax.servlet.error.request_uri").toString(), ex, 10);
			}

			return true;
		} else {
			return false;
		}
	}

	protected boolean isAsyncDispatch(HttpServletRequest request) {
		return WebAsyncUtils.getAsyncManager(request).hasConcurrentResult();
	}

	protected boolean isAsyncStarted(HttpServletRequest request) {
		return WebAsyncUtils.getAsyncManager(request).isConcurrentHandlingStarted();
	}

	protected String getAlreadyFilteredAttributeName() {
		String name = this.getFilterName();
		if (name == null) {
			name = this.getClass().getName();
		}

		return name + ".FILTERED";
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

	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		String uri = req.getRequestURI();
		long t = System.currentTimeMillis();
		boolean multiPart = ServletFileUpload.isMultipartContent(req);
		LogCounter counter = ResourceStatsUtil.getUriStats().beforeProcess(uri, t);
		Integer loc = ResourceStatsUtil.recordRequest(req, multiPart);
		ResourceStatsContainer container = new ResourceStatsContainer(counter, t, loc);
		req.setAttribute(ResourceStatsContainer.RESOURCE_STATS, container);

		try {
			filterChain.doFilter(req, res);
		} finally {
			if (!StringUtils.equals("asynch", ResourceStatsUtil.getUriStats().getSpecialType(uri))) {
				ResourceStatsUtil.getUriStats().afterProcess(counter, t, false);
				ResourceStatsUtil.clearRequest(loc);
			}

		}

	}
}