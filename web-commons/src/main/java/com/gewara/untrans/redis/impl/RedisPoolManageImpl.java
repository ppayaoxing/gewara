package com.gewara.untrans.redis.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.gewara.constant.ZkConfigTag;
import com.gewara.support.redis.GwShardedJedisPool;
import com.gewara.untrans.monitor.ConfigCenter;
import com.gewara.untrans.monitor.ConfigTrigger;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public class RedisPoolManageImpl implements ConfigTrigger, InitializingBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	@Autowired
	private ConfigCenter configCenter;
	@Autowired
	private GwShardedJedisPool pool;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		configCenter.registerGlobal(ZkConfigTag.KEY_GLOBAL_REDISPOOL_SWITCH, this);
	}

	@Override
	public void refreshCurrent(String newConfig) {
		dbLogger.warn("redis pool test on borrow =>" + newConfig);
		if(StringUtils.equals("ON", newConfig)){
			pool.setTestOnBorrow(true);
		}else if(StringUtils.equals("OFF", newConfig)){
			pool.setTestOnBorrow(false);
		}
	}
}
