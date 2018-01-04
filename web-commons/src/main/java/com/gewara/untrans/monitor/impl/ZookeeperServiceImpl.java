package com.gewara.untrans.monitor.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatch.CloseMode;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.springframework.beans.factory.DisposableBean;

import com.gewara.support.TraceErrorException;
import com.gewara.untrans.monitor.CuratorConnectionFactroy;
import com.gewara.untrans.monitor.KeeperWatcher;
import com.gewara.untrans.monitor.ZookeeperService;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

public class ZookeeperServiceImpl implements ZookeeperService, DisposableBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	private Map<String, String> registerMap = new HashMap<String, String>();
	private List<KeeperWatcher> watcherList = new ArrayList<KeeperWatcher>();	
	private static String ENCODING = "UTF-8";
	private CuratorFramework client;
	
	public ZookeeperServiceImpl(){
	}
	public ZookeeperServiceImpl(CuratorFramework client){
		this.client = client;
	}
	
	public ZookeeperServiceImpl(CuratorConnectionFactroy factory) throws IOException{
		this.client = factory.getCuratorFramework();
	}
	
	@Override
	public String getNodeData(String path) {
		try {
			byte[] b = client.getData().forPath(path);
			if(b==null) {
                return null;
            }
			return new String(b, ENCODING);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	@Override
	public List<String> getChildren(String path){
		if (client != null) {
			try {
				return client.getChildren().forPath(path);
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
		return null;
	}

	@Override
	public boolean updateNode(String path, String data) {
		try {
			client.setData().forPath(path, data.getBytes(ENCODING));
			return true;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	@Override
	public boolean delNode(String path) {
		try {
			client.delete().forPath(path);
			return true;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public boolean exist(String path) {
		try {
			return client.checkExists().forPath(path)!=null;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	@Override
	public boolean addSeqNode(String path, String data) {
		try {
			byte[] d = StringUtils.isNotBlank(data)? data.getBytes(ENCODING):null;
			client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).withACL(Ids.OPEN_ACL_UNSAFE).forPath(path, d);
			return true;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	@Override
	public boolean addTempNode(String path, String data) {
		try {
			byte[] d = StringUtils.isNotBlank(data)? data.getBytes(ENCODING):null;
			client.create().withMode(CreateMode.EPHEMERAL).withACL(Ids.OPEN_ACL_UNSAFE).forPath(path, d);
			//zk.create(path, data.getBytes(ENCODING), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
			return true;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public boolean addPresistentNode(String path, String data) {
		try {
			byte[] d = StringUtils.isNotBlank(data)? data.getBytes(ENCODING):null;
			client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).withACL(Ids.OPEN_ACL_UNSAFE).forPath(path, d);
			return true;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	@Override
	public Map<String, String> getChildrenData(String path) {
		Map<String, String> result = new HashMap<String, String>();
		List<String> children = getChildren(path);
		if (!StringUtils.endsWith(path, "/")) {
            path += "/";
        }
		if (children != null) {
			for (String child : children) {
				result.put(child, getNodeData(path + child));
			}
		}
		return result;
	}

	@Override
	public void addMonitor(KeeperWatcher monitor){
		synchronized(this){
			//ͬһ·����ͬ�಻���ظ���ֻע��һ�Σ�
			for(KeeperWatcher watcher : watcherList){
				if(StringUtils.equals(watcher.getPath(), monitor.getPath()) && 
						watcher.getClass().equals(monitor)){
					return;
				}
			}
			if(!this.exist(monitor.getPath())){
				addPresistentNode(monitor.getPath(), "");
			}
			watcherList.add(monitor);
			monitor.init(client);
		}
	}
	
	@Override
	public List<KeeperWatcher> getMonitor(){
		return this.watcherList;
	}

	@Override
	public void registerNode(String nodePath, String nodeData) {
		registerMap.put(nodePath, nodeData);
		//TODO:�жϽڵ������Ƿ��ظ�
		addSeqNode(nodePath, nodeData);
	}
	
	@Override
	public void registerEphemeralNode(String nodePath, String nodeData){
		String tmpPath  = nodePath;
		if(!StringUtils.endsWith(nodePath, "/s")){
			tmpPath = nodePath + "/s";
		}
		registerMap.put(tmpPath, nodeData);
		//TODO:�жϽڵ������Ƿ��ظ�
		addSeqNode(tmpPath, nodeData);
	}
	
	@Override
	public void unRegisterEphemeralNode(String nodePath, String nodeData){
		String tmpPath  = nodePath;
		if(StringUtils.endsWith(nodePath, "/s")){
			tmpPath = StringUtils.substringBeforeLast(tmpPath, "/s");
		}
		List<String> childrenPathList = this.getChildren(tmpPath);
		for(String childrenPath : childrenPathList){
			String delPath = tmpPath + "/" + childrenPath;
			if(StringUtils.equals(this.getNodeData(delPath), nodeData)){
				dbLogger.warn("del Node :" + delPath);
				this.delNode(delPath);
				//ֱ��return��????
			}
		}	
	}
	
	@Override
	public void addReconnectedStateListener(final String nodePath, final String nodeData){
		if(StringUtils.endsWith(nodePath, "/s")){
			throw new TraceErrorException("the nodePath must not ends with /s");
		}
		client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
			@Override
			public void stateChanged(CuratorFramework cf, ConnectionState newState) {
				if(newState == ConnectionState.RECONNECTED){
					Map<String, String> dataMap = getChildrenData(nodePath);
					if(!dataMap.containsValue(nodeData)){
						dbLogger.warn("after reconnected,client registerEphemeralNode:" + nodePath + "->" + nodeData);
						registerEphemeralNode(nodePath, nodeData);
					}
				}
			}
		});
	}
	
	@Override
	public void destroy() throws InterruptedException {
		if (client != null) {
			client.close();
		}
	}
	
	@Override
	public InterProcessMutex createInterProcessMutex(String path){
		InterProcessMutex mutex = new InterProcessMutex(client, path);
		return mutex;
	}
	
	@Override
	public LeaderLatch createLeaderLatch(String latchPath, String id){
		LeaderLatch latch = new LeaderLatch(client, latchPath, id, CloseMode.NOTIFY_LEADER); 
		return latch;
	}
	
}
