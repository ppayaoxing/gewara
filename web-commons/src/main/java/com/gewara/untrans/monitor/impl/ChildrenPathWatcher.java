/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.impl;

import com.gewara.untrans.monitor.KeeperWatcher;
import com.gewara.util.StringUtil;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;

public class ChildrenPathWatcher extends KeeperWatcher implements PathChildrenCacheListener {
	private Map<String, String> oldChildren;
	private PathChildrenCache pcc;

	public ChildrenPathWatcher(String path) {
		this.path = path;
	}

	protected void processChange(Map<String, String> old, Map<String, String> newChildren) {
		this.dbLogger.warn(old + "---->" + newChildren);
	}

	public KeeperWatcher init(CuratorFramework zc) {
		this.client = zc;
		this.pcc = new PathChildrenCache(zc, this.path, true);
		this.pcc.getListenable().addListener(this);

		try {
			this.pcc.start(StartMode.BUILD_INITIAL_CACHE);
		} catch (Exception arg2) {
			this.dbLogger.warn(arg2, 100);
		}

		Map data = this.getData(this.pcc.getCurrentData());
		this.oldChildren = data;
		return this;
	}

	private Map<String, String> getData(List<ChildData> childList) {
		LinkedHashMap result = new LinkedHashMap();
		if (childList != null) {
			Iterator arg2 = childList.iterator();

			while (arg2.hasNext()) {
				ChildData data = (ChildData) arg2.next();
				String shortPath = StringUtils.substring(data.getPath(), this.path.length());
				if (data.getData() != null) {
					result.put(shortPath, StringUtil.getString(data.getData(), "utf-8"));
				} else {
					result.put(shortPath, (Object) null);
				}
			}
		}

		return result;
	}

	public void childEvent(CuratorFramework zc, PathChildrenCacheEvent event) throws Exception {
		Map tmp = this.oldChildren;
		this.oldChildren = this.getData(this.pcc.getCurrentData());
		this.processChange(tmp, this.oldChildren);
	}
}