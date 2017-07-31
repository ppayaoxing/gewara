package com.gewara.untrans.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.gewara.Config;
import com.gewara.untrans.GewaLeaderLatchListener;
import com.gewara.untrans.LeaderElectionService;
import com.gewara.untrans.monitor.ZookeeperService;
import com.gewara.util.GewaLogger;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;

public class LeaderElectionServiceImpl implements LeaderElectionService, DisposableBean {

	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	private static String LEADER_NODE_NAME = "leaderelection";
	
	private Map<String, LeaderLatch> latchMap = new HashMap<String, LeaderLatch>();
	
	private Map<String, Boolean> leaderMap = new HashMap<String, Boolean>();
	
	@Autowired
	private ZookeeperService keeperService;

	public LeaderElectionServiceImpl(){}
	
	public LeaderElectionServiceImpl(ZookeeperService keeperService){
		this.keeperService = keeperService;
	}
	
	@Override
	public void createElection(String key, GewaLeaderLatchListener listener) throws Exception{
		if(StringUtils.isBlank(key) || listener == null){
			throw new IllegalArgumentException("key or listener is null");
		}
		LeaderLatch latch = createLeaderLatch(key);
		latch.addListener(buildLeaderLatchListener(key, listener));
		start(key);
	}
	
	@Override
	public void createElection(String key, List<GewaLeaderLatchListener> listenerList) throws Exception{
		if(StringUtils.isBlank(key) || listenerList == null || listenerList.isEmpty()){
			throw new IllegalArgumentException("key or listenerList is null");
		}
		LeaderLatch latch = createLeaderLatch(key);
		for(GewaLeaderLatchListener listener : listenerList){
			latch.addListener(buildLeaderLatchListener(key, listener));
		}		
		start(key);
	}
	
	@Override
	public void closeElection(String key) throws IOException{
		LeaderLatch latch = latchMap.get(key);
		if(latch == null){
			return;
		}
		latch.close();
		leaderMap.put(key, false);
	}
		
	@Override
	public void addListener(String key, GewaLeaderLatchListener listener){
		LeaderLatch latch = latchMap.get(key);
		if(latch == null){
			return;
		}
		latch.addListener(buildLeaderLatchListener(key, listener));
	}
	
	private LeaderLatchListener buildLeaderLatchListener(final String key, final GewaLeaderLatchListener listener){
		LeaderLatchListener leaderLatchListener = new LeaderLatchListener(){
			@Override
			public void isLeader() {
				listener.isLeader();
				leaderMap.put(key, true);
			}

			@Override
			public void notLeader() {
				listener.notLeader();
				leaderMap.put(key, false);
			}			
		};
		return leaderLatchListener;
	}
	
	private LeaderLatch createLeaderLatch(String key){
		LeaderLatch latch = latchMap.get(key);
		if(latch == null){
			String latchPath = "/config/" + Config.SYSTEMID + "/" + LEADER_NODE_NAME + "/" + key;
			latch = keeperService.createLeaderLatch(latchPath, Config.DEPLOYID);
			latchMap.put(key, latch);
			leaderMap.put(key, false);
		}
		return latch;
	}
	
	private void start(final String key) throws Exception{
		dbLogger.warn("LeaderLatch will be start...." + key);
		TimerHelper.TIMER.schedule(new Runnable(){
			@Override
			public void run() {
				try {
					LeaderLatch latch = latchMap.get(key);
					latch.start();
					dbLogger.warn("LeaderLatch is started...." + key);
				} catch (Exception e) {
					dbLogger.error("LeaderLatch start error: " + key, e);
				}
			}			
		}, 30000);		
	}
	
	@Override
	public void destroy() throws IOException {
		for(Map.Entry<String, LeaderLatch> entry : latchMap.entrySet()){
			try {
				entry.getValue().close();
				leaderMap.put(entry.getKey(), false);
				dbLogger.warn("LeaderLatch is closed : " + entry.getKey());
			} catch (Exception e) {
				dbLogger.error("LeaderLatch close error: " + entry.getKey(), e);
			}
		}
	}

	@Override
	public boolean isLeader(String key) {
		Boolean flag = leaderMap.get(key);
		if(flag == null){
			return false;
		}
		return flag.booleanValue();
	}
}
