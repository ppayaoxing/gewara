/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.Config;
import com.gewara.untrans.GewaLeaderLatchListener;
import com.gewara.untrans.LeaderLatchService;
import com.gewara.untrans.monitor.ZookeeperService;
import com.gewara.util.GewaLogger;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;
import java.io.IOException;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class LeaderLatchServiceImpl implements LeaderLatchService, InitializingBean, DisposableBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private static String LEADER_NODE_NAME = "zkleader";
	@Autowired
	private ZookeeperService keeperService;
	private LeaderLatch latch;

	public LeaderLatchServiceImpl() {
	}

	public LeaderLatchServiceImpl(ZookeeperService keeperService) {
		this.keeperService = keeperService;
	}

	public void afterPropertiesSet() throws Exception {
		this.init();
	}

	private void init() throws Exception {
		if (this.latch != null) {
			try {
				this.latch.close();
			} catch (Exception arg1) {
				this.dbLogger.error("close latch error", arg1);
			}
		}

		String latchPath = "/config/" + Config.SYSTEMID + "/" + LEADER_NODE_NAME;
		this.latch = this.keeperService.createLeaderLatch(latchPath, Config.DEPLOYID);
		this.start();
	}

	private void start() throws Exception {
		this.dbLogger.warn("LeaderLatch will be start....");
		TimerHelper.TIMER.schedule(new Runnable() {
			public void run() {
				try {
					LeaderLatchServiceImpl.this.latch.start();
					LeaderLatchServiceImpl.this.dbLogger.warn("LeaderLatch is started....");
				} catch (Exception arg1) {
					LeaderLatchServiceImpl.this.dbLogger.error("LeaderLatch start error", arg1);
				}

			}
		}, 60000L);
	}

	public void addListener(GewaLeaderLatchListener listener) {
		if (listener != null) {
			this.latch.addListener(this.buildLeaderLatchListener(listener));
		}
	}

	public void destroy() throws IOException {
		if (this.latch != null) {
			this.latch.close();
		}

	}

	private LeaderLatchListener buildLeaderLatchListener(final GewaLeaderLatchListener listener) {
		LeaderLatchListener leaderLatchListener = new LeaderLatchListener() {
			public void isLeader() {
				listener.isLeader();
			}

			public void notLeader() {
				listener.notLeader();
			}
		};
		return leaderLatchListener;
	}
}