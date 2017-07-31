package com.gewara.untrans.monitor;

import javax.annotation.Resource;

import org.springframework.web.context.WebApplicationContext;

import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public abstract class AbstractSysSelfCheckingJob implements SysSelfCheckingJob {
	
	
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	@Resource
	protected WebApplicationContext applicationContext;

}
