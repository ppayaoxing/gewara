/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.job;

import com.gewara.Config;
import com.gewara.support.TraceErrorException;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.InitializingBean;

public abstract class JobService implements InitializingBean {
	protected final GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private static final Set<String> names = new HashSet();
	private String serviceName;
	private ThreadLocal<String> executeInfo = new ThreadLocal();

	public final void afterPropertiesSet() throws Exception {
		this.serviceName = Config.SYSTEMID + "." + this.getClass().getSimpleName();
		this.dbLogger.warn(this.serviceName);
		if (names.contains(this.serviceName)) {
			throw new TraceErrorException("JobService 重名");
		} else {
			names.add(this.serviceName);
			this.initJobService();
		}
	}

	protected void initJobService() {
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public String getExecuteInfo() {
		String result = (String) this.executeInfo.get();
		this.executeInfo.set((Object) null);
		return result;
	}

	public void setExecuteInfo(String info) {
		this.executeInfo.set(info);
	}
}