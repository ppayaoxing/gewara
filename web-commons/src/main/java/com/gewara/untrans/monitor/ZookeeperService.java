/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor;

import com.gewara.untrans.monitor.KeeperWatcher;
import java.util.List;
import java.util.Map;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

public interface ZookeeperService {
	boolean addPresistentNode(String arg0, String arg1);

	boolean addTempNode(String arg0, String arg1);

	boolean addSeqNode(String arg0, String arg1);

	boolean updateNode(String arg0, String arg1);

	boolean delNode(String arg0);

	List<String> getChildren(String arg0);

	Map<String, String> getChildrenData(String arg0);

	String getNodeData(String arg0);

	boolean exist(String arg0);

	void addMonitor(KeeperWatcher arg0);

	List<KeeperWatcher> getMonitor();

	void registerNode(String arg0, String arg1);

	void registerEphemeralNode(String arg0, String arg1);

	void unRegisterEphemeralNode(String arg0, String arg1);

	void addReconnectedStateListener(String arg0, String arg1);

	InterProcessMutex createInterProcessMutex(String arg0);

	LeaderLatch createLeaderLatch(String arg0, String arg1);
}