/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.redis;

import java.util.List;

public interface RedisShardingService {
	<T> T getHashMapCache(String arg0, Class<T> arg1);

	<T> void putHashMapCache4All(String arg0, T arg1);

	void putHashMapCache(String arg0, String arg1, Object arg2);

	<T> void putQueueCache4All(String arg0, List<T> arg1);

	<T> T pollQueueData(String arg0);

	void putCache(String arg0, String arg1);

	String getCache(String arg0);

	<T> Boolean putHashMapCache4AllNotExist(String arg0, T arg1);

	void delCache(String arg0);

	void expireCache(String arg0, int arg1);
}