/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import com.gewara.untrans.monitor.MonitorService;
import com.gewara.untrans.monitor.SysLogType;
import com.gewara.untrans.monitor.MonitorService.EXCEPTION_TAG;
import com.gewara.util.BeanUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.RequestEventHolder;
import com.gewara.web.support.ResourceStatsUtil;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.web.context.support.ServletRequestHandledEvent;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class GewaWebApplicationContext extends XmlWebApplicationContext {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private ThreadPoolExecutor executor;
	private MonitorService monitorService;
	private boolean init = false;

	public GewaWebApplicationContext() {
		this.executor = new ThreadPoolExecutor(2, 2, 300L, TimeUnit.SECONDS, new LinkedBlockingQueue());
		this.executor.allowCoreThreadTimeOut(false);
	}

	public void publishEvent(ApplicationEvent event) {
		if (event instanceof ServletRequestHandledEvent) {
			RequestEventHolder.setEvent((ServletRequestHandledEvent) event);
			this.executor.execute(new GewaWebApplicationContext.LogTask((ServletRequestHandledEvent) event));
		} else {
			super.publishEvent(event);
		}

	}

	protected void publishEvent(Object event, ResolvableType eventType) {
		if (event instanceof ServletRequestHandledEvent) {
			RequestEventHolder.setEvent((ServletRequestHandledEvent) event);
			this.executor.execute(new GewaWebApplicationContext.LogTask((ServletRequestHandledEvent) event));
		} else {
			super.publishEvent(event, eventType);
		}

	}

	private void init() {
		if (!this.init) {
			try {
				this.init = true;
				this.monitorService = (MonitorService) this.getBean("monitorService", MonitorService.class);
			} catch (Exception arg1) {
				;
			}
		}

	}

	private void log(Map<String, String> logMap) {
		this.init();
		if (this.monitorService != null) {
			this.monitorService.addSysLog(SysLogType.reqStats, logMap);
		} else {
			this.dbLogger.warnMap(SysLogType.reqStats.name(), logMap);
		}

	}

	private class LogTask implements Runnable {
		private ServletRequestHandledEvent event;

		public LogTask(ServletRequestHandledEvent event) {
			this.event = event;
		}

		public void run() {
			String url = this.event.getRequestUrl();
			Map info = ResourceStatsUtil.clearUriIfMaxClick(200);
			if (info != null) {
				GewaWebApplicationContext.this.init();
				if (GewaWebApplicationContext.this.monitorService != null) {
					GewaWebApplicationContext.this.monitorService.logException(EXCEPTION_TAG.PAGE,
							"GewaDispatcherServlet.noHandlerFound", "不存在的Acition", (Throwable) null,
							BeanUtil.toSimpleStringMap(info));
				}
			}

			if (!this.event.wasFailure()) {
				Map logMap = ResourceStatsUtil.updateUriProcessTime(url, this.event.getProcessingTimeMillis(), 1000);
				if (logMap != null) {
					GewaWebApplicationContext.this.log(logMap);
				}
			}

		}
	}
}