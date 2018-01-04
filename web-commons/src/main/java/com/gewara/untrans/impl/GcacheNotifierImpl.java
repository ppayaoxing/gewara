package com.gewara.untrans.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.gewara.untrans.GcacheNotifier;
import com.gewara.util.CacheMeta;
import com.gewara.util.GcacheManager;
import com.gewara.util.JsonUtils;

/**
 * 基于redis pub/sub实现
 * @author quzhuping
 */
public class GcacheNotifierImpl implements GcacheNotifier {
	private boolean useNewFormat = false;
	private StringRedisTemplate redisTemplate;
	
	public void setRedisTemplate(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	public ExecutorService exec = Executors.newFixedThreadPool(8);
	@Override
	public void notifyChanges(Class entityClazz, String ids) {
		CacheMeta meta = GcacheManager.getCacheMeta(entityClazz);
		if (meta!=null && StringUtils.isNotBlank(ids)) {
			String msg = getMsg(meta.tag, "U", ids);
			redisTemplate.convertAndSend(meta.tag, msg);
			if(meta.notifies!=null){
				for(String notify: meta.notifies){
					redisTemplate.convertAndSend(notify, msg);
				}
			}
		}
	}
	
	private String getMsg(String tag, String op, String ids){
		if(useNewFormat){
			String result =  tag + "#@" + op;
			if(StringUtils.isNotBlank(ids)){
				result += "#@" + ids;
			}
			return result;
		}else{
			Map<String, String> dataMap = new HashMap<String, String>();
			dataMap.put("tag", tag);
			dataMap.put("ids", ids);
			dataMap.put("op", op);
			String msg = JsonUtils.writeMapToJson(dataMap);
			return msg;
		}
		
		 
	}

	@Override
	public void notifyClean(String tag, String ids) {
		CacheMeta meta = GcacheManager.getCacheMeta(tag);
		if(meta!=null){
			exec.execute(new Runnable(){
				@Override
				public void run() {
					String msg = getMsg(tag, "C", ids);
					redisTemplate.convertAndSend(meta.tag, msg);
					if(meta.notifies!=null){
						for(String notify: meta.notifies){
							redisTemplate.convertAndSend(notify, msg);
						}
					}
				}
			});
		}
	}
	public void setUseNewFormat(boolean useNewFormat) {
		this.useNewFormat = useNewFormat;
	}

	@Override
	public void notifyChangesAsynch(Class entityClazz, String ids, String op) {
		CacheMeta meta = GcacheManager.getCacheMeta(entityClazz);
		if (meta!=null && StringUtils.isNotBlank(ids)) {
			exec.execute(new Runnable(){
				@Override
				public void run() {
					String msg = getMsg(meta.tag, "U", ids);
					redisTemplate.convertAndSend(meta.tag, msg);
					if(meta.notifies!=null){
						for(String notify: meta.notifies){
							redisTemplate.convertAndSend(notify, msg);
						}
					}
				}
			});
		}
	}

}
