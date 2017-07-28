/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.impl;

import com.gewara.untrans.monitor.CuratorConnectionFactroy;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.io.IOException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.CuratorFrameworkFactory.Builder;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CuratorConnectionFactroyImpl implements CuratorConnectionFactroy, InitializingBean, DisposableBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private int sessionTimeout = 30000;
	private String zookeeperQuorum;
	private ConnectionState state;
	private CuratorFramework client;

	public void setZookeeperQuorum(String zookeeperQuorum) {
		this.zookeeperQuorum = zookeeperQuorum;
	}

	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	private void setState(ConnectionState state) {
		this.state = state;
	}

	public CuratorConnectionFactroyImpl() {
	}

	public CuratorConnectionFactroyImpl(String zookeeperQuorum) {
		this.zookeeperQuorum = zookeeperQuorum;
	}

	public void init() throws IOException {
		Builder builder = CuratorFrameworkFactory.builder().connectString(this.zookeeperQuorum)
				.retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000)).connectionTimeoutMs(this.sessionTimeout);
		this.client = builder.build();
		this.client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
			public void stateChanged(CuratorFramework c, ConnectionState s) {
				CuratorConnectionFactroyImpl.this.setState(s);
				CuratorConnectionFactroyImpl.this.dbLogger.warn("zookeeper connection " + s);
			}
		});
		this.client.start();
		int i = 1;
		byte max = 50;

		while (this.state != ConnectionState.CONNECTED) {
			this.dbLogger.warn("zookeeper try connecting...," + i++ + " times!");
			if (i > max) {
				throw new IOException("connect to zookeeper failure:" + this.zookeeperQuorum);
			}

			try {
				Thread.sleep(1000L);
			} catch (Exception arg4) {
				;
			}
		}

	}

	public CuratorFramework getCuratorFramework() throws IOException {
		if (this.state != ConnectionState.CONNECTED) {
			throw new IOException("connect to zookeeper failure:" + this.zookeeperQuorum);
		} else {
			return this.client;
		}
	}

	public void afterPropertiesSet() throws Exception {
		this.init();
	}

	public void destroy() throws InterruptedException {
		if (this.client != null) {
			this.client.close();
		}

	}
}