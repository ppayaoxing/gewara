/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.Config;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public abstract class GewaLeaderLatchListener {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());

	public abstract void isLeader();

	public void notLeader() {
		this.dbLogger.warn(Config.DEPLOYID + " is not leader");
	}
}