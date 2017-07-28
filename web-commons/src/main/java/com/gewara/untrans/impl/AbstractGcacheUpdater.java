/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.util.CacheMeta;
import com.gewara.util.GcacheManager;
import com.gewara.util.GewaLogger;
import com.gewara.util.JsonUtils;
import com.gewara.util.WebLogger;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

public abstract class AbstractGcacheUpdater implements InitializingBean {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	protected RedisMessageListenerContainer listenerContainer;

	public void setListenerContainer(RedisMessageListenerContainer listenerContainer) {
		this.listenerContainer = listenerContainer;
	}

	public abstract List<String> getListenerTags();

	public void afterPropertiesSet() throws Exception {
		this.initListener();
	}

	private void initListener() {
		List channelList = this.getListenerTags();
		MessageListener messageListener = new MessageListener() {
			public void onMessage(Message message, byte[] pattern) {
				try {
					AbstractGcacheUpdater.this.refreshCurrent(new String(message.getBody(), "UTF-8"));
				} catch (UnsupportedEncodingException arg3) {
					AbstractGcacheUpdater.this.dbLogger.error(arg3, 10);
				}

			}
		};
		Iterator arg2 = channelList.iterator();

		while (arg2.hasNext()) {
			String channel = (String) arg2.next();
			this.listenerContainer.addMessageListener(messageListener, new ChannelTopic(channel));
		}

	}

	private void refreshCurrent(String newConfig) {
		String tag = null;
		String ids = null;
		String op = null;
		if (StringUtils.startsWith(newConfig, "{")) {
			Map meta = JsonUtils.readJsonToMap(newConfig);
			tag = (String) meta.get("tag");
			ids = (String) meta.get("ids");
			op = (String) meta.get("op");
		} else {
			String[] meta1 = StringUtils.split(newConfig, "#@");
			tag = meta1[0];
			op = meta1[1];
			if (meta1.length == 3) {
				ids = meta1[2];
			}
		}

		if (!StringUtils.isBlank(tag)) {
			CacheMeta meta2 = GcacheManager.getCacheMeta(tag);
			if (meta2 == null) {
				this.dbLogger.warn("CacheObjectService:MetaError:" + tag);
			} else {
				this.refreshCache(meta2, ids, op);
			}
		}
	}

	protected abstract void refreshCache(CacheMeta arg0, String arg1, String arg2);
}