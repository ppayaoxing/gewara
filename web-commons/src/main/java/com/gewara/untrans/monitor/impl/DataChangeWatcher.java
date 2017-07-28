/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.impl;

import com.gewara.untrans.monitor.KeeperWatcher;
import com.gewara.util.StringUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;

public abstract class DataChangeWatcher extends KeeperWatcher implements NodeCacheListener {
	private String prevalue;
	private NodeCache nodeCache;

	public DataChangeWatcher(String path) {
		this.path = path;
	}

	protected abstract void processChange(String arg0, String arg1);

	public void nodeChanged() throws Exception {
		String tmp = this.prevalue;
		this.prevalue = this.getData();
		this.processChange(tmp, this.prevalue);
	}

	public KeeperWatcher init(CuratorFramework zc) {
		this.client = zc;
		this.nodeCache = new NodeCache(this.client, this.path);
		this.nodeCache.getListenable().addListener(this);

		try {
			this.nodeCache.start(true);
		} catch (Exception arg2) {
			this.dbLogger.warn(arg2, 100);
		}

		this.prevalue = this.getData();
		return this;
	}

	private String getData() {
		ChildData cur = this.nodeCache.getCurrentData();
		if (cur != null) {
			byte[] data = cur.getData();
			if (data != null) {
				return StringUtil.getString(data, "utf-8");
			}
		}

		return null;
	}
}