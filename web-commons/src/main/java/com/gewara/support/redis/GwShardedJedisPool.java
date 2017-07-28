/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.redis;

import java.util.List;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

public class GwShardedJedisPool extends ShardedJedisPool {
	public GwShardedJedisPool(GenericObjectPoolConfig poolConfig, List<JedisShardInfo> shards) {
		super(poolConfig, shards);
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.internalPool.setTestOnBorrow(testOnBorrow);
	}
}