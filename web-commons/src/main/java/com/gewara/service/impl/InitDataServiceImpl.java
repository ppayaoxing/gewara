/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.service.impl;

import com.gewara.service.InitDataService;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import org.springframework.stereotype.Service;

@Service("initDataService")
public class InitDataServiceImpl implements InitDataService {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());

	public void startInit(String info, Runnable call) {
		this.dbLogger.warn("start init data:" + info);
		call.run();
		this.dbLogger.warn("end init data:" + info);
	}

	public void delayInit(String info, Runnable call, long delayMills) {
		this.dbLogger.warn("start init data:" + info);
		call.run();
		this.dbLogger.warn("end init data:" + info);
	}
}