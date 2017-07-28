/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.context.request.async;

import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.context.request.async.ResourceStatsContainer;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.async.DeferredResult;

public class GwDeferredResult<T> extends DeferredResult<T> {
	public GwDeferredResult(HttpServletRequest request) {
		this.onTimeout(new GwDeferredResult.TimeoutCallbackRunner(request));
	}

	public GwDeferredResult(long timeout, HttpServletRequest request) {
		super(Long.valueOf(timeout));
		this.onTimeout(new GwDeferredResult.TimeoutCallbackRunner(request));
	}

	public GwDeferredResult(Long timeout, Object timeoutResult, HttpServletRequest request) {
		super(timeout, timeoutResult);
		this.onTimeout(new GwDeferredResult.TimeoutCallbackRunner(request));
	}

	private static class TimeoutCallbackRunner implements Runnable {
		private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
		private ResourceStatsContainer container;

		public TimeoutCallbackRunner(HttpServletRequest request) {
			this.container = (ResourceStatsContainer) request.getAttribute(ResourceStatsContainer.RESOURCE_STATS);
		}

		public void run() {
			if (this.container != null) {
				this.container.processStats();
			} else {
				this.dbLogger.error("the ResourceStatsContainer is null");
			}

		}
	}
}