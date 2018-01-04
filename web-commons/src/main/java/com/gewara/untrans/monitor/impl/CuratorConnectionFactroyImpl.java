package com.gewara.untrans.monitor.impl;

import java.io.IOException;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.CuratorFrameworkFactory.Builder;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.gewara.untrans.monitor.CuratorConnectionFactroy;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public class CuratorConnectionFactroyImpl implements CuratorConnectionFactroy, InitializingBean, DisposableBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	private int sessionTimeout =30000;//30 seconds

	private String zookeeperQuorum;
	public void setZookeeperQuorum(String zookeeperQuorum) {
		this.zookeeperQuorum = zookeeperQuorum;
	}
	public void setSessionTimeout(int sessionTimeout){
		this.sessionTimeout = sessionTimeout;
	}
	private ConnectionState state;
	private void setState(ConnectionState state){
		this.state = state;
	}
	
	public CuratorConnectionFactroyImpl(){
		
	}
	public CuratorConnectionFactroyImpl(String zookeeperQuorum){
		this.zookeeperQuorum = zookeeperQuorum;
	}
	
	private CuratorFramework client;

	@Override
	public void init() throws IOException {
		Builder builder = CuratorFrameworkFactory.builder()
				.connectString(zookeeperQuorum)
				.retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000))  
				.connectionTimeoutMs(sessionTimeout);
		client = builder.build();
		client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
			@Override
            public void stateChanged(CuratorFramework c, ConnectionState s) {
				setState(s);
				dbLogger.warn("zookeeper connection " + s);
			}
		});
		client.start();
		int i=1, max=50;
		while(state!=ConnectionState.CONNECTED){
			dbLogger.warn("zookeeper try connecting...,"  +  i++ + " times!");
			if(i>max) {
				throw new IOException("connect to zookeeper failure:" + zookeeperQuorum);
			}
			try{
				Thread.sleep(1000);
			}catch(Exception e){
			}
		}
	}
	
	@Override
	public CuratorFramework getCuratorFramework() throws IOException {
		if(state!=ConnectionState.CONNECTED){
			throw new IOException("connect to zookeeper failure:" + zookeeperQuorum);
		}
		return client;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		init();
	}

	@Override
	public void destroy() throws InterruptedException {
		if (client != null) {
			client.close();
		}
	}


}
