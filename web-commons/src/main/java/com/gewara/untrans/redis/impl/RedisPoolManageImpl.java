/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.redis.impl;

import com.gewara.support.redis.GwShardedJedisPool;
import com.gewara.untrans.monitor.ConfigCenter;
import com.gewara.untrans.monitor.ConfigTrigger;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisPoolManageImpl implements ConfigTrigger, InitializingBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	@Autowired
	private ConfigCenter configCenter;
	@Autowired
	private GwShardedJedisPool pool;

	public void afterPropertiesSet() throws Exception {
		this.configCenter.registerGlobal("key_global_redispool_switch", this);
	}

	public void refreshCurrent(String newConfig) {
		this.dbLogger.warn("redis pool test on borrow =>" + newConfig);
		if (StringUtils.equals("ON", newConfig)) {
			this.pool.setTestOnBorrow(true);
		} else if (StringUtils.equals("OFF", newConfig)) {
			this.pool.setTestOnBorrow(false);
		}

	}
}