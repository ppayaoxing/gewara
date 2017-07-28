/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor;

import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import org.apache.curator.framework.CuratorFramework;

public abstract class KeeperWatcher {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	protected String path;
	protected CuratorFramework client;

	public String getPath() {
		return this.path;
	}

	public abstract KeeperWatcher init(CuratorFramework arg0);
}