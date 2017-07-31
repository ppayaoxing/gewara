package com.gewara.untrans.impl;

import java.io.IOException;

import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.gewara.Config;
import com.gewara.untrans.GewaLeaderLatchListener;
import com.gewara.untrans.LeaderLatchService;
import com.gewara.untrans.monitor.ZookeeperService;
import com.gewara.util.GewaLogger;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;

public class LeaderLatchServiceImpl implements LeaderLatchService, InitializingBean, DisposableBean{

	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	private static String LEADER_NODE_NAME = "zkleader";

	@Autowired
	private ZookeeperService keeperService;
	
	private LeaderLatch latch;

	public LeaderLatchServiceImpl(){}
	
	public LeaderLatchServiceImpl(ZookeeperService keeperService){
		this.keeperService = keeperService;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		init();
	}
	
	private void init() throws Exception{
		if(latch != null){
			try{
				latch.close();
			}catch(Exception e){
				dbLogger.error("close latch error", e);
			}			
		}
		String latchPath = "/config/" + Config.SYSTEMID + "/" + LEADER_NODE_NAME;
		latch = keeperService.createLeaderLatch(latchPath, Config.DEPLOYID);
		start();
	}
	
	private void start() throws Exception{
		dbLogger.warn("LeaderLatch will be start....");
		TimerHelper.TIMER.schedule(new Runnable(){

			@Override
			public void run() {
				try {
					latch.start();
					dbLogger.warn("LeaderLatch is started....");
				} catch (Exception e) {
					dbLogger.error("LeaderLatch start error", e);
				}
			}
			
		}, 60000);
		
	}
	
	@Override
	public void addListener(GewaLeaderLatchListener listener){
		if(listener == null){
			return;
		}
		latch.addListener(buildLeaderLatchListener(listener));
	}

	@Override
	public void destroy() throws IOException {
		if (latch != null) {
			latch.close();
		}
	}
	
	private LeaderLatchListener buildLeaderLatchListener(final GewaLeaderLatchListener listener){
		LeaderLatchListener leaderLatchListener = new LeaderLatchListener(){
			@Override
			public void isLeader() {
				listener.isLeader();
			}

			@Override
			public void notLeader() {
				listener.notLeader();
			}			
		};
		return leaderLatchListener;
	}
}
