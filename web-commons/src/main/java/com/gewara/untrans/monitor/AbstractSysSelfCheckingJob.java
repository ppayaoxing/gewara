/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor;

import com.gewara.untrans.monitor.SysSelfCheckingJob;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import javax.annotation.Resource;
import org.springframework.web.context.WebApplicationContext;

public abstract class AbstractSysSelfCheckingJob implements SysSelfCheckingJob {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	@Resource
	protected WebApplicationContext applicationContext;
}