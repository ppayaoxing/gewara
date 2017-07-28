/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.untrans.CacheObjectService;
import com.gewara.untrans.impl.AbstractGcacheUpdater;
import com.gewara.util.BeanUtil;
import com.gewara.util.CacheMeta;
import com.gewara.util.GcacheManager;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class GcacheUpdater extends AbstractGcacheUpdater {
	@Autowired
	@Qualifier("cacheObjectService")
	protected CacheObjectService cacheObjectService;

	public void setCacheObjectService(CacheObjectService cacheObjectService) {
		this.cacheObjectService = cacheObjectService;
	}

	private void cleanDataByIds(CacheMeta meta, String ids) {
		Class type = this.cacheObjectService.getEntityIdType(meta.gclass);
		if (type != null) {
			if (type == String.class) {
				String[] idList = StringUtils.split(ids, ",");
				String[] arg4 = idList;
				int id = idList.length;

				for (int e = 0; e < id; ++e) {
					String id1 = arg4[e];

					try {
						meta.gcache.invalidate(id1);
						if (meta.eager) {
							this.cacheObjectService.getObject(meta.gclass, id1);
						}

						this.refreshOther(meta.gclass, id1);
					} catch (Exception arg10) {
						this.dbLogger.warn(arg10, 20);
					}
				}
			} else {
				List arg11 = BeanUtil.getIdList(ids, ",");
				Iterator arg12 = arg11.iterator();

				while (arg12.hasNext()) {
					Long arg13 = (Long) arg12.next();

					try {
						meta.gcache.invalidate(arg13);
						if (meta.eager) {
							this.cacheObjectService.getObject(meta.gclass, arg13);
						}

						this.refreshOther(meta.gclass, arg13);
					} catch (Exception arg9) {
						this.dbLogger.warn(arg9, 20);
					}
				}
			}
		}

	}

	protected void refreshOther(Class clazz, Serializable id) {
	}

	public final List<String> getListenerTags() {
		List channelList = GcacheManager.getAllTags();
		if (channelList.isEmpty()) {
			throw new IllegalArgumentException("GcacheManger.getAllTags() is Empty!");
		} else {
			return channelList;
		}
	}

	protected final void refreshCache(CacheMeta meta, String ids, String op) {
		if (StringUtils.equals(op, "C")) {
			if (StringUtils.isNotBlank(ids)) {
				this.cleanDataByIds(meta, ids);
				this.dbLogger.warn("CacheObjectService,CleanByID:" + meta.gclass + ",IDs:" + ids);
			} else {
				meta.gcache.invalidateAll();
				this.dbLogger.warn("CacheObjectService,CleanAll:" + meta.gclass);
			}
		} else {
			if (StringUtils.isBlank(ids)) {
				this.dbLogger.warn("CacheObjectService:NoIDs");
				return;
			}

			this.cleanDataByIds(meta, ids);
		}

	}
}