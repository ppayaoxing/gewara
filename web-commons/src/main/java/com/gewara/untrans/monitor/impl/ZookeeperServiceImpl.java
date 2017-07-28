/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.impl;

import com.gewara.support.TraceErrorException;
import com.gewara.untrans.monitor.CuratorConnectionFactroy;
import com.gewara.untrans.monitor.KeeperWatcher;
import com.gewara.untrans.monitor.ZookeeperService;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.ACLBackgroundPathAndBytesable;
import org.apache.curator.framework.api.BackgroundPathAndBytesable;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatch.CloseMode;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.springframework.beans.factory.DisposableBean;

public class ZookeeperServiceImpl implements ZookeeperService, DisposableBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private Map<String, String> registerMap = new HashMap();
	private List<KeeperWatcher> watcherList = new ArrayList();
	private static String ENCODING = "UTF-8";
	private CuratorFramework client;

	public ZookeeperServiceImpl() {
	}

	public ZookeeperServiceImpl(CuratorFramework client) {
		this.client = client;
	}

	public ZookeeperServiceImpl(CuratorConnectionFactroy factory) throws IOException {
		this.client = factory.getCuratorFramework();
	}

	public String getNodeData(String path) {
		try {
			byte[] e = (byte[]) this.client.getData().forPath(path);
			return e == null ? null : new String(e, ENCODING);
		} catch (Exception arg2) {
			throw new IllegalStateException(arg2);
		}
	}

	public List<String> getChildren(String path) {
		if (this.client != null) {
			try {
				return (List) this.client.getChildren().forPath(path);
			} catch (Exception arg2) {
				throw new IllegalStateException(arg2);
			}
		} else {
			return null;
		}
	}

	public boolean updateNode(String path, String data) {
		try {
			this.client.setData().forPath(path, data.getBytes(ENCODING));
			return true;
		} catch (Exception arg3) {
			throw new IllegalStateException(arg3);
		}
	}

	public boolean delNode(String path) {
		try {
			this.client.delete().forPath(path);
			return true;
		} catch (Exception arg2) {
			throw new IllegalStateException(arg2);
		}
	}

	public boolean exist(String path) {
		try {
			return this.client.checkExists().forPath(path) != null;
		} catch (Exception arg2) {
			throw new IllegalStateException(arg2);
		}
	}

	public boolean addSeqNode(String path, String data) {
		try {
			byte[] e = StringUtils.isNotBlank(data) ? data.getBytes(ENCODING) : null;
			((BackgroundPathAndBytesable) ((ACLBackgroundPathAndBytesable) this.client.create()
					.withMode(CreateMode.EPHEMERAL_SEQUENTIAL)).withACL(Ids.OPEN_ACL_UNSAFE)).forPath(path, e);
			return true;
		} catch (Exception arg3) {
			throw new IllegalStateException(arg3);
		}
	}

	public boolean addTempNode(String path, String data) {
		try {
			byte[] e = StringUtils.isNotBlank(data) ? data.getBytes(ENCODING) : null;
			((BackgroundPathAndBytesable) ((ACLBackgroundPathAndBytesable) this.client.create()
					.withMode(CreateMode.EPHEMERAL)).withACL(Ids.OPEN_ACL_UNSAFE)).forPath(path, e);
			return true;
		} catch (Exception arg3) {
			throw new IllegalStateException(arg3);
		}
	}

	public boolean addPresistentNode(String path, String data) {
		try {
			byte[] e = StringUtils.isNotBlank(data) ? data.getBytes(ENCODING) : null;
			((BackgroundPathAndBytesable) ((ACLBackgroundPathAndBytesable) this.client.create()
					.creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)).withACL(Ids.OPEN_ACL_UNSAFE))
							.forPath(path, e);
			return true;
		} catch (Exception arg3) {
			throw new IllegalStateException(arg3);
		}
	}

	public Map<String, String> getChildrenData(String path) {
		HashMap result = new HashMap();
		List children = this.getChildren(path);
		if (!StringUtils.endsWith(path, "/")) {
			path = path + "/";
		}

		if (children != null) {
			Iterator arg3 = children.iterator();

			while (arg3.hasNext()) {
				String child = (String) arg3.next();
				result.put(child, this.getNodeData(path + child));
			}
		}

		return result;
	}

	public void addMonitor(KeeperWatcher monitor) {
		synchronized (this) {
			Iterator arg2 = this.watcherList.iterator();

			KeeperWatcher watcher;
			do {
				if (!arg2.hasNext()) {
					if (!this.exist(monitor.getPath())) {
						this.addPresistentNode(monitor.getPath(), "");
					}

					this.watcherList.add(monitor);
					monitor.init(this.client);
					return;
				}

				watcher = (KeeperWatcher) arg2.next();
			} while (!StringUtils.equals(watcher.getPath(), monitor.getPath()) || !watcher.getClass().equals(monitor));

		}
	}

	public List<KeeperWatcher> getMonitor() {
		return this.watcherList;
	}

	public void registerNode(String nodePath, String nodeData) {
		this.registerMap.put(nodePath, nodeData);
		this.addSeqNode(nodePath, nodeData);
	}

	public void registerEphemeralNode(String nodePath, String nodeData) {
		String tmpPath = nodePath;
		if (!StringUtils.endsWith(nodePath, "/s")) {
			tmpPath = nodePath + "/s";
		}

		this.registerMap.put(tmpPath, nodeData);
		this.addSeqNode(tmpPath, nodeData);
	}

	public void unRegisterEphemeralNode(String nodePath, String nodeData) {
		String tmpPath = nodePath;
		if (StringUtils.endsWith(nodePath, "/s")) {
			tmpPath = StringUtils.substringBeforeLast(nodePath, "/s");
		}

		List childrenPathList = this.getChildren(tmpPath);
		Iterator arg4 = childrenPathList.iterator();

		while (arg4.hasNext()) {
			String childrenPath = (String) arg4.next();
			String delPath = tmpPath + "/" + childrenPath;
			if (StringUtils.equals(this.getNodeData(delPath), nodeData)) {
				this.dbLogger.warn("del Node :" + delPath);
				this.delNode(delPath);
			}
		}

	}

	public void addReconnectedStateListener(final String nodePath, final String nodeData) {
		if (StringUtils.endsWith(nodePath, "/s")) {
			throw new TraceErrorException("the nodePath must not ends with /s");
		} else {
			this.client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
				public void stateChanged(CuratorFramework cf, ConnectionState newState) {
					if (newState == ConnectionState.RECONNECTED) {
						Map dataMap = ZookeeperServiceImpl.this.getChildrenData(nodePath);
						if (!dataMap.containsValue(nodeData)) {
							ZookeeperServiceImpl.this.dbLogger.warn(
									"after reconnected,client registerEphemeralNode:" + nodePath + "->" + nodeData);
							ZookeeperServiceImpl.this.registerEphemeralNode(nodePath, nodeData);
						}
					}

				}
			});
		}
	}

	public void destroy() throws InterruptedException {
		if (this.client != null) {
			this.client.close();
		}

	}

	public InterProcessMutex createInterProcessMutex(String path) {
		InterProcessMutex mutex = new InterProcessMutex(this.client, path);
		return mutex;
	}

	public LeaderLatch createLeaderLatch(String latchPath, String id) {
		LeaderLatch latch = new LeaderLatch(this.client, latchPath, id, CloseMode.NOTIFY_LEADER);
		return latch;
	}
}