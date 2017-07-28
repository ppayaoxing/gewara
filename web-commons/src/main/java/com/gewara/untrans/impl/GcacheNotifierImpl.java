/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.untrans.GcacheNotifier;
import com.gewara.util.CacheMeta;
import com.gewara.util.GcacheManager;
import com.gewara.util.JsonUtils;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;

public class GcacheNotifierImpl implements GcacheNotifier {
	private boolean useNewFormat = false;
	private StringRedisTemplate redisTemplate;
	public ExecutorService exec = Executors.newFixedThreadPool(8);

	public void setRedisTemplate(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void notifyChanges(Class entityClazz, String ids) {
		CacheMeta meta = GcacheManager.getCacheMeta(entityClazz);
		if (meta != null && StringUtils.isNotBlank(ids)) {
			String msg = this.getMsg(meta.tag, "U", ids);
			this.redisTemplate.convertAndSend(meta.tag, msg);
			if (meta.notifies != null) {
				String[] arg4 = meta.notifies;
				int arg5 = arg4.length;

				for (int arg6 = 0; arg6 < arg5; ++arg6) {
					String notify = arg4[arg6];
					this.redisTemplate.convertAndSend(notify, msg);
				}
			}
		}

	}

	private String getMsg(String tag, String op, String ids) {
		if (this.useNewFormat) {
			String dataMap1 = tag + "#@" + op;
			if (StringUtils.isNotBlank(ids)) {
				dataMap1 = dataMap1 + "#@" + ids;
			}

			return dataMap1;
		} else {
			HashMap dataMap = new HashMap();
			dataMap.put("tag", tag);
			dataMap.put("ids", ids);
			dataMap.put("op", op);
			String msg = JsonUtils.writeMapToJson(dataMap);
			return msg;
		}
	}

	public void notifyClean(final String tag, final String ids) {
		final CacheMeta meta = GcacheManager.getCacheMeta(tag);
		if (meta != null) {
			this.exec.execute(new Runnable() {
				public void run() {
					String msg = GcacheNotifierImpl.this.getMsg(tag, "C", ids);
					GcacheNotifierImpl.this.redisTemplate.convertAndSend(meta.tag, msg);
					if (meta.notifies != null) {
						String[] arg1 = meta.notifies;
						int arg2 = arg1.length;

						for (int arg3 = 0; arg3 < arg2; ++arg3) {
							String notify = arg1[arg3];
							GcacheNotifierImpl.this.redisTemplate.convertAndSend(notify, msg);
						}
					}

				}
			});
		}

	}

	public void setUseNewFormat(boolean useNewFormat) {
		this.useNewFormat = useNewFormat;
	}

	public void notifyChangesAsynch(Class entityClazz, final String ids, String op) {
		final CacheMeta meta = GcacheManager.getCacheMeta(entityClazz);
		if (meta != null && StringUtils.isNotBlank(ids)) {
			this.exec.execute(new Runnable() {
				public void run() {
					String msg = GcacheNotifierImpl.this.getMsg(meta.tag, "U", ids);
					GcacheNotifierImpl.this.redisTemplate.convertAndSend(meta.tag, msg);
					if (meta.notifies != null) {
						String[] arg1 = meta.notifies;
						int arg2 = arg1.length;

						for (int arg3 = 0; arg3 < arg2; ++arg3) {
							String notify = arg1[arg3];
							GcacheNotifierImpl.this.redisTemplate.convertAndSend(notify, msg);
						}
					}

				}
			});
		}

	}
}