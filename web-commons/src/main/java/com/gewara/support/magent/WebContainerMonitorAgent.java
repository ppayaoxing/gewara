/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.magent;

import com.gewara.Config;
import com.gewara.support.magent.MCCHelper;
import com.gewara.support.magent.MessageCommandCenter;
import com.gewara.support.magent.RequestStatsGroup;
import com.gewara.support.magent.SmackMonitorAgentClient;
import com.gewara.util.TimerHelper;
import java.util.TimerTask;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class WebContainerMonitorAgent implements InitializingBean, DisposableBean {
	private SmackMonitorAgentClient client;
	private MessageCommandCenter mcc;
	@Autowired
	@Qualifier("config")
	private Config config;

	public SmackMonitorAgentClient getClient() {
		return this.client;
	}

	public void afterPropertiesSet() throws Exception {
		String username = StringUtils.lowerCase(Config.SYSTEMID + "_" + Config.getHostname());
		String host = this.config.getString("openfire.host");
		this.mcc = MCCHelper.getDefaultInstance();
		this.mcc.registerGroup(new RequestStatsGroup());
		this.client = new SmackMonitorAgentClient(host, username, Config.SYSTEMID + "pass", this.mcc);
		TimerHelper.TIMER.schedule(new TimerTask() {
			public void run() {
				WebContainerMonitorAgent.this.client.init();
			}
		}, 10000L);
	}

	public void destroy() throws Exception {
	}
}