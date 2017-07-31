package com.gewara.untrans.monitor;

import org.apache.curator.framework.CuratorFramework;

import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;




public abstract class KeeperWatcher {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	protected String path;
	protected CuratorFramework client;
	/**
	 * ·µ»Ø¼àÌýÂ·¾¶
	 * @return
	 */
	public String getPath(){
		return this.path;
	}
	public abstract KeeperWatcher init(CuratorFramework zc);
}