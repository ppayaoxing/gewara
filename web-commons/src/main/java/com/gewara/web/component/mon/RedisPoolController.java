package com.gewara.web.component.mon;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gewara.support.redis.GwShardedJedisPool;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.TimerHelper;

@Controller("_redis")
public class RedisPoolController {
	@Autowired(required=false)
	GwShardedJedisPool shardedJedisPool;
	
	@RequestMapping("/sysmgr/redispool/enableCheck.xhtml")
	@ResponseBody
	public String enableConnectionCheck(HttpServletRequest request, Integer seconds){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if(shardedJedisPool != null){
			if(seconds == null || seconds < 1){
				seconds = 1200;
			}
			
			shardedJedisPool.setTestOnBorrow(true);
			TimerHelper.TIMER.schedule(new Runnable() {
				@Override
				public void run() {
					shardedJedisPool.setTestOnBorrow(false);
					
				}
			}, seconds * 1000);
		}else{
			return "no jedis pool config";
		}
		return "ok";
	}
	
	public String disableConnectionCheck(HttpServletRequest request){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if(shardedJedisPool != null){
			shardedJedisPool.setTestOnBorrow(false);
		}else{
			return "no jedis pool config";
		}
		return "ok";
	}
}
