/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.component.mon;

import com.gewara.support.redis.GwShardedJedisPool;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.TimerHelper;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("_redis")
public class RedisPoolController {
	@Autowired(required = false)
	GwShardedJedisPool shardedJedisPool;

	@RequestMapping({"/sysmgr/redispool/enableCheck.xhtml"})
	@ResponseBody
	public String enableConnectionCheck(HttpServletRequest request, Integer seconds) {
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if (this.shardedJedisPool == null) {
			return "no jedis pool config";
		} else {
			if (seconds == null || seconds.intValue() < 1) {
				seconds = Integer.valueOf(1200);
			}

			this.shardedJedisPool.setTestOnBorrow(true);
			TimerHelper.TIMER.schedule(new Runnable() {
				public void run() {
					RedisPoolController.this.shardedJedisPool.setTestOnBorrow(false);
				}
			}, (long) (seconds.intValue() * 1000));
			return "ok";
		}
	}

	public String disableConnectionCheck(HttpServletRequest request) {
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if (this.shardedJedisPool != null) {
			this.shardedJedisPool.setTestOnBorrow(false);
			return "ok";
		} else {
			return "no jedis pool config";
		}
	}
}