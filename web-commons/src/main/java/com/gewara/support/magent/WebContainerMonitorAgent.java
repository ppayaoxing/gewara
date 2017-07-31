package com.gewara.support.magent;

import java.util.TimerTask;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gewara.Config;
import com.gewara.util.TimerHelper;

public class WebContainerMonitorAgent implements InitializingBean, DisposableBean {
	private SmackMonitorAgentClient client;
	private MessageCommandCenter mcc;

	@Autowired@Qualifier("config")
	private Config config;

	public SmackMonitorAgentClient getClient() {
		return client;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		String username = StringUtils.lowerCase(Config.SYSTEMID + "_" + Config.getHostname());
		String host = config.getString("openfire.host");
		mcc = MCCHelper.getDefaultInstance();
		mcc.registerGroup(new RequestStatsGroup());
		client = new SmackMonitorAgentClient(host, username, Config.SYSTEMID + "pass", mcc);
		//延迟加载，加速启动
		TimerHelper.TIMER.schedule(new TimerTask(){
			@Override
			public void run() {
				client.init();		
			}
		}, 1000*10);

	}


	@Override
	public void destroy() throws Exception {

	}
}
