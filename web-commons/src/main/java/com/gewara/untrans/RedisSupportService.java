/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.support.concurrent.AtomicCounter;
import java.util.concurrent.BlockingQueue;
import org.springframework.data.redis.support.collections.DefaultRedisMap;

public interface RedisSupportService<E> {
	BlockingQueue<E> getRedisQueue(String arg0);

	AtomicCounter getRedisAtomicCounter(String arg0);

	DefaultRedisMap<String, Object> getRedisHash(String arg0);
}