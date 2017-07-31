package com.gewara.support;

import com.gewara.support.lifecycle.BeforeUpdateService;

public class DefaultBeforeUpdateService implements BeforeUpdateService {

	@Override
	public void beforeUpdate() {
		//1)stop camel if exists
		//2)stop job scheduler if exists
		//3)stop managable ExecutorService if exists
		
	}

}
