/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.gewara.Config;
import com.gewara.untrans.GewaLeaderLatchListener;
import com.gewara.untrans.LeaderElectionService;
import com.gewara.untrans.monitor.ZookeeperService;
import com.gewara.util.GewaLogger;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;

public class LeaderElectionServiceImpl implements LeaderElectionService, DisposableBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private static String LEADER_NODE_NAME = "leaderelection";
	private Map<String, LeaderLatch> latchMap = new HashMap();
	private Map<String, Boolean> leaderMap = new HashMap();
	@Autowired
	private ZookeeperService keeperService;

	public LeaderElectionServiceImpl() {
	}

	public LeaderElectionServiceImpl(ZookeeperService keeperService) {
		this.keeperService = keeperService;
	}

	public void createElection(String key, GewaLeaderLatchListener listener) throws Exception {
		if (!StringUtils.isBlank(key) && listener != null) {
			LeaderLatch latch = this.createLeaderLatch(key);
			latch.addListener(this.buildLeaderLatchListener(key, listener));
			this.start(key);
		} else {
			throw new IllegalArgumentException("key or listener is null");
		}
	}

	public void createElection(String key, List<GewaLeaderLatchListener> listenerList) throws Exception {
		if (!StringUtils.isBlank(key) && listenerList != null && !listenerList.isEmpty()) {
			LeaderLatch latch = this.createLeaderLatch(key);
			Iterator arg3 = listenerList.iterator();

			while (arg3.hasNext()) {
				GewaLeaderLatchListener listener = (GewaLeaderLatchListener) arg3.next();
				latch.addListener(this.buildLeaderLatchListener(key, listener));
			}

			this.start(key);
		} else {
			throw new IllegalArgumentException("key or listenerList is null");
		}
	}

	public void closeElection(String key) throws IOException {
		LeaderLatch latch = (LeaderLatch) this.latchMap.get(key);
		if (latch != null) {
			latch.close();
			this.leaderMap.put(key, Boolean.valueOf(false));
		}
	}

	public void addListener(String key, GewaLeaderLatchListener listener) {
		LeaderLatch latch = (LeaderLatch) this.latchMap.get(key);
		if (latch != null) {
			latch.addListener(this.buildLeaderLatchListener(key, listener));
		}
	}

	private LeaderLatchListener buildLeaderLatchListener(final String key, final GewaLeaderLatchListener listener) {
		LeaderLatchListener leaderLatchListener = new LeaderLatchListener() {
			public void isLeader() {
				listener.isLeader();
				LeaderElectionServiceImpl.this.leaderMap.put(key, Boolean.valueOf(true));
			}

			public void notLeader() {
				listener.notLeader();
				LeaderElectionServiceImpl.this.leaderMap.put(key, Boolean.valueOf(false));
			}
		};
		return leaderLatchListener;
	}

	private LeaderLatch createLeaderLatch(String key) {
		LeaderLatch latch = (LeaderLatch) this.latchMap.get(key);
		if (latch == null) {
			String latchPath = "/config/" + Config.SYSTEMID + "/" + LEADER_NODE_NAME + "/" + key;
			latch = this.keeperService.createLeaderLatch(latchPath, Config.DEPLOYID);
			this.latchMap.put(key, latch);
			this.leaderMap.put(key, Boolean.valueOf(false));
		}

		return latch;
	}

	private void start(final String key) throws Exception {
		this.dbLogger.warn("LeaderLatch will be start...." + key);
		TimerHelper.TIMER.schedule(new Runnable() {
			public void run() {
				try {
					LeaderLatch e = (LeaderLatch) LeaderElectionServiceImpl.this.latchMap.get(key);
					e.start();
					LeaderElectionServiceImpl.this.dbLogger.warn("LeaderLatch is started...." + key);
				} catch (Exception arg1) {
					LeaderElectionServiceImpl.this.dbLogger.error("LeaderLatch start error: " + key, arg1);
				}

			}
		}, 30000L);
	}

	public void destroy() throws IOException {
		Iterator arg0 = this.latchMap.entrySet().iterator();

		while (arg0.hasNext()) {
			Entry entry = (Entry) arg0.next();

			try {
				((LeaderLatch) entry.getValue()).close();
				this.leaderMap.put(entry.getKey(), Boolean.valueOf(false));
				this.dbLogger.warn("LeaderLatch is closed : " + (String) entry.getKey());
			} catch (Exception arg3) {
				this.dbLogger.error("LeaderLatch close error: " + (String) entry.getKey(), arg3);
			}
		}

	}

	public boolean isLeader(String key) {
		Boolean flag = (Boolean) this.leaderMap.get(key);
		return flag == null ? false : flag.booleanValue();
	}
}