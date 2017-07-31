package com.gewara.web.context.request.async;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.async.DeferredResult;

import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public class GwDeferredResult<T> extends DeferredResult<T> {
	
	public GwDeferredResult(HttpServletRequest request){
		super();
		this.onTimeout(new TimeoutCallbackRunner(request));
	}
	public GwDeferredResult(long timeout, HttpServletRequest request){
		super(timeout);
		this.onTimeout(new TimeoutCallbackRunner(request));
	}
	public GwDeferredResult(Long timeout, Object timeoutResult, HttpServletRequest request){
		super(timeout, timeoutResult);
		this.onTimeout(new TimeoutCallbackRunner(request));
	}
	
	private static class TimeoutCallbackRunner implements Runnable{
		private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
		private ResourceStatsContainer container;
		
		public TimeoutCallbackRunner(HttpServletRequest request){
			this.container = (ResourceStatsContainer) request.getAttribute(ResourceStatsContainer.RESOURCE_STATS);
		}
		@Override
		public void run() {
			if(container != null){
				container.processStats();
			}else{
				dbLogger.error("the ResourceStatsContainer is null");
			}
		}
		
	}
}
