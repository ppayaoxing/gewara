package com.gewara.untrans.monitor.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;

import com.gewara.untrans.monitor.KeeperWatcher;
import com.gewara.util.StringUtil;

public class ChildrenPathWatcher extends KeeperWatcher implements PathChildrenCacheListener{
	private Map<String, String> oldChildren;
	private PathChildrenCache pcc;
	public ChildrenPathWatcher(String path){
		this.path = path;
	}
	
	/**
	 * @param old Map(shortPath,data)
	 * @param newChildren
	 */
	protected void processChange(Map<String, String> old, Map<String, String> newChildren){
		dbLogger.warn(old + "---->" + newChildren);
	}
	@Override
	public KeeperWatcher init(CuratorFramework zc) {
		this.client = zc;
		this.pcc = new PathChildrenCache(zc, path, true);
		this.pcc.getListenable().addListener(this);
		try {
			this.pcc.start(StartMode.BUILD_INITIAL_CACHE);
		} catch (Exception e) {
			dbLogger.warn(e, 100);
		}
		Map<String, String> data = getData(pcc.getCurrentData());
		oldChildren = data;
		return this;
	}
	private Map<String/*path*/, String/*data*/> getData(List<ChildData> childList){
		Map<String, String> result = new LinkedHashMap<String, String>();
		if(childList!=null){
			for(ChildData data: childList){
				String shortPath = StringUtils.substring(data.getPath(), this.path.length());
				if(data.getData()!=null){
					result.put(shortPath, StringUtil.getString(data.getData(), "utf-8"));
				}else{
					result.put(shortPath, null);
				}
			}
		}
		return result;
	}
	@Override
	public void childEvent(CuratorFramework zc, PathChildrenCacheEvent event) throws Exception {
		Map<String, String> tmp = oldChildren;
		oldChildren = getData(pcc.getCurrentData());
		processChange(tmp, oldChildren);
	}
}
