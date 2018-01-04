package com.gewara.job;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;

import com.gewara.Config;
import com.gewara.support.TraceErrorException;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public abstract class JobService implements InitializingBean {
	protected final GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private static final Set<String> names = new HashSet<String>();
	private String serviceName;
	private ThreadLocal<String> executeInfo = new ThreadLocal<String>();
	@Override
	public final void afterPropertiesSet() throws Exception {
		serviceName = Config.SYSTEMID + "." + getClass().getSimpleName();
		dbLogger.warn(serviceName);
		if(names.contains(serviceName)) {
			throw new TraceErrorException("JobService 重名");
		}
		names.add(serviceName);
		initJobService();
	}
	protected void initJobService(){}
	public String getServiceName() {
		return serviceName;
	}
	public String getExecuteInfo() {
		String result = executeInfo.get();
		executeInfo.set(null);
		return result;
	}
	public void setExecuteInfo(String info){
		executeInfo.set(info);
	}
	
}
