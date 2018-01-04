package com.gewara.untrans.monitor;

import org.apache.curator.framework.CuratorFramework;

import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;




public abstract class KeeperWatcher {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	protected String path;
	protected CuratorFramework client;
	/**
	 * 返回监听路径
	 * @return
	 */
	public String getPath(){
		return this.path;
	}
	public abstract KeeperWatcher init(CuratorFramework zc);
}