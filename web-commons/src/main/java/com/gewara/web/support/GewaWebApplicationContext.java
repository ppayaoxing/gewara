package com.gewara.web.support;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.web.context.support.ServletRequestHandledEvent;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.gewara.untrans.monitor.MonitorService;
import com.gewara.untrans.monitor.MonitorService.EXCEPTION_TAG;
import com.gewara.untrans.monitor.SysLogType;
import com.gewara.util.BeanUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public class GewaWebApplicationContext extends XmlWebApplicationContext{
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private ThreadPoolExecutor executor;
	private MonitorService monitorService;
	private boolean init = false;
	
	public GewaWebApplicationContext(){
		executor = new ThreadPoolExecutor(2, 2, 300, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		executor.allowCoreThreadTimeOut(false);
	}
	
	@Override
    public void publishEvent(ApplicationEvent event) {
		if(event instanceof ServletRequestHandledEvent){
			RequestEventHolder.setEvent((ServletRequestHandledEvent) event);
			executor.execute(new LogTask((ServletRequestHandledEvent) event));
		}else{
			super.publishEvent(event);
		}
	}


	@Override
    protected void publishEvent(Object event, ResolvableType eventType) {
		if(event instanceof ServletRequestHandledEvent){
			RequestEventHolder.setEvent((ServletRequestHandledEvent) event);
			executor.execute(new LogTask((ServletRequestHandledEvent) event));
		}else{
			super.publishEvent(event, eventType);
		}
	}

	private class LogTask implements Runnable{
		private ServletRequestHandledEvent event;
		public LogTask(ServletRequestHandledEvent event){
			this.event = event;
		}
		@Override
		public void run() {
			String url = event.getRequestUrl();
			Map<String, Integer> info = ResourceStatsUtil.clearUriIfMaxClick(200);
			if(info!=null){//锟斤拷锟斤拷锟节达拷锟斤拷锟斤拷锟斤拷
				init();
				if(monitorService != null){
					monitorService.logException(EXCEPTION_TAG.PAGE, "GewaDispatcherServlet.noHandlerFound", "锟斤拷锟斤拷锟节碉拷Acition", null, BeanUtil.toSimpleStringMap(info));
				}
			}
			if(!event.wasFailure()){
				Map<String, String> logMap = ResourceStatsUtil.updateUriProcessTime(url, event.getProcessingTimeMillis(), 1000);
				if(logMap != null){
					log(logMap);
				}
			}
		}
	}
	private void init(){
		if(!init){
			try{
				init = true;
				monitorService = this.getBean("monitorService", MonitorService.class);
			}catch(Exception e){
			}
		}
	}
	private void log(Map<String, String> logMap){
		init();
		if(monitorService!=null){
			monitorService.addSysLog(SysLogType.reqStats, logMap);
		}else{
			dbLogger.warnMap(SysLogType.reqStats.name(), logMap);
		}
	}
}
