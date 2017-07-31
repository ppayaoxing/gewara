package com.gewara.service.impl;

import org.springframework.stereotype.Service;

import com.gewara.service.InitDataService;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
@Service("initDataService")
public class InitDataServiceImpl implements InitDataService {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	@Override
	public void startInit(String info,  Runnable call) {
		dbLogger.warn("start init data:" + info);
		call.run();
		dbLogger.warn("end init data:" + info);
	}
	@Override
	public void delayInit(String info,  Runnable call, long delayMills) {
		dbLogger.warn("start init data:" + info);
		call.run();
		dbLogger.warn("end init data:" + info);
	}
}
