/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.untrans.GewaLeaderLatchListener;
import java.io.IOException;
import java.util.List;

public interface LeaderElectionService {
	void createElection(String arg0, GewaLeaderLatchListener arg1) throws Exception;

	void createElection(String arg0, List<GewaLeaderLatchListener> arg1) throws Exception;

	void closeElection(String arg0) throws IOException;

	void addListener(String arg0, GewaLeaderLatchListener arg1);

	boolean isLeader(String arg0);
}