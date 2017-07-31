package com.gewara.untrans.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import com.gewara.util.CacheMeta;
import com.gewara.util.GcacheManager;
import com.gewara.util.GewaLogger;
import com.gewara.util.JsonUtils;
import com.gewara.util.WebLogger;

public abstract class AbstractGcacheUpdater implements InitializingBean{
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	protected RedisMessageListenerContainer listenerContainer;
	
	public void setListenerContainer(RedisMessageListenerContainer listenerContainer) {
		this.listenerContainer = listenerContainer;
	}
	public abstract List<String> getListenerTags();
	
	@Override
	public void afterPropertiesSet() throws Exception {
		initListener();
	}
	private void initListener(){
		List<String> channelList = getListenerTags();
		MessageListener messageListener = new MessageListener() {			
			@Override
			public void onMessage(Message message, byte[] pattern) {
				try {
					refreshCurrent(new String(message.getBody(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					dbLogger.error(e, 10);
				}
			}
		};
		
		for(String channel : channelList){
			listenerContainer.addMessageListener(messageListener, new ChannelTopic(channel));
		}
	}

	private void refreshCurrent(String newConfig) {
		String tag = null, ids = null, op = null;
		if(StringUtils.startsWith(newConfig, "{")){//json¸ñÊ½
			Map<String, String> dataMap = JsonUtils.readJsonToMap(newConfig);
			tag = dataMap.get("tag");
			ids = dataMap.get("ids");
			op = dataMap.get("op");
		}else{//×Ö·û´®Æ´½Ó£ºtag#@op#@ids, split by #@
			String[] pair = StringUtils.split(newConfig, "#@");
			tag = pair[0];
			op = pair[1];
			if(pair.length==3){
				ids = pair[2];
			}
		}
		if(StringUtils.isBlank(tag)){
			return;
		}
		
		final CacheMeta meta = GcacheManager.getCacheMeta(tag);
		if(meta == null){
			dbLogger.warn("CacheObjectService:MetaError:" + tag);
			return;
		}
		refreshCache(meta, ids, op);
	}
	protected abstract void refreshCache(CacheMeta meta, String ids, String op);
	
}
