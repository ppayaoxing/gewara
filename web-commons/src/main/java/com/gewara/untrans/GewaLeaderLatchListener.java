package com.gewara.untrans;

import com.gewara.Config;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public abstract class GewaLeaderLatchListener{

	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	public abstract void isLeader();

	public void notLeader() {
		dbLogger.warn(Config.DEPLOYID + " is not leader");
	}
}
