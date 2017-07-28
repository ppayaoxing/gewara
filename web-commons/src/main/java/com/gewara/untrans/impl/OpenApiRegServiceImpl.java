/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.Config;
import com.gewara.support.lifecycle.BeforeUpdateService;
import com.gewara.untrans.OpenApiRegService;
import com.gewara.untrans.monitor.ZookeeperService;
import com.gewara.util.GewaLogger;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class OpenApiRegServiceImpl implements OpenApiRegService, BeforeUpdateService {
	private GewaLogger logger = WebLogger.getLogger(this.getClass());
	@Autowired
	@Qualifier("keeperService")
	private ZookeeperService keeperService;
	private Map<String, Set<String>> regData = new HashMap();
	private String checkUri;

	public void setCheckUri(String checkUri) {
		this.checkUri = checkUri;
	}

	public void registerOpenApi(final String path, final String data) {
		TimerHelper.TIMER.schedule(new Runnable() {
			public void run() {
				OpenApiRegServiceImpl.this.registerOpenApiInternal(path, data);
			}
		}, 5000L);
	}

	private void registerOpenApiInternal(String path, String data) {
		try {
			boolean ex = this.checkUrl();
			if (ex) {
				if (!this.keeperService.exist(path)) {
					this.keeperService.addPresistentNode(path, System.currentTimeMillis() + "");
				}

				this.logger.warn("zookeeper添加临时节点 ： " + path + " 节点内容为：" + data);
				this.keeperService.registerNode(path + "/s", data);
				Object dataList = (Set) this.regData.get(path);
				if (dataList == null) {
					dataList = new HashSet();
					this.regData.put(path, dataList);
				}

				((Set) dataList).add(data);
			}
		} catch (Exception arg4) {
			this.logger.error("", arg4);
		}

	}

	public void unregisterOpenApi() {
		this.logger.warn("unregister to openapi~~");
		Iterator arg0 = this.regData.entrySet().iterator();

		while (arg0.hasNext()) {
			Entry reg = (Entry) arg0.next();
			Iterator arg2 = ((Set) reg.getValue()).iterator();

			while (arg2.hasNext()) {
				String data = (String) arg2.next();
				this.keeperService.unRegisterEphemeralNode((String) reg.getKey(), data);
			}
		}

	}

	public void beforeUpdate() {
		this.unregisterOpenApi();
	}

	private boolean checkUrl() {
		String checkUrl = "http://" + Config.getServerIp() + ":2000" + this.checkUri;

		for (int i = 0; i < 10; ++i) {
			HttpResult result = HttpUtils.getUrlAsString(checkUrl);
			if (result.isSuccess()) {
				return true;
			}

			try {
				this.logger.warn("testOpenapi2000 failure!!");
				Thread.sleep(3000L);
			} catch (InterruptedException arg4) {
				;
			}
		}

		return false;
	}
}