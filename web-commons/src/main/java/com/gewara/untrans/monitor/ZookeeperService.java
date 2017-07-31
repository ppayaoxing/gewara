package com.gewara.untrans.monitor;

import java.util.List;
import java.util.Map;

import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.zookeeper.KeeperException;


public interface ZookeeperService  {
	
	boolean addPresistentNode(String path, String data);

	/**
	 * 增加临时节点（EPHEMERAL节点，session过期或关闭后自动删除）
	 * 
	 * @param path
	 * @param data
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	boolean addTempNode(String path, String data);
	boolean addSeqNode(String path, String data);

	boolean updateNode(String path, String data);

	boolean delNode(String path);

	List<String> getChildren(String path);

	Map<String, String> getChildrenData(String path);

	String getNodeData(String path);

	boolean exist(String path);
	void addMonitor(KeeperWatcher monitor);
	public List<KeeperWatcher> getMonitor();

	/**
	 * 系统启动注册节点
	 * @param nodePath
	 * @param nodeData
	 */
	void registerNode(String nodePath, String nodeData);

	/**
	 * 系统启动注册临时节点
	 * <p>如果nodePath不以 "/s"结尾，会默认加上
	 * @param nodePath
	 * @param nodeData
	 */
	void registerEphemeralNode(String nodePath, String nodeData);
	/**
	 * 删除临时节点
	 * <p> 如果nodePath下临时节点的值等于nodeData，则删除该临时节点
	 * @param nodePath 临时节点路径
	 * @param nodeData 待比较的值
	 */
	void unRegisterEphemeralNode(String nodePath, String nodeData);

	/**
	 * 增加zk重连后的注册逻辑
	 * <p>适用场景，如：openapi注册服务
	 * @param nodePath 
	 * <p> 不能以"/s"结尾，否则抛出异常
	 * @param nodeData
	 */
	void addReconnectedStateListener(String nodePath, String nodeData);

	/**
	 * 创建分布式锁
	 * @param path zk路径
	 * @return
	 * @author leo
	 * @addTime 2016年3月28日下午3:31:05
	 */
	InterProcessMutex createInterProcessMutex(String path);

	/**
	 * 创建LeaderLatch
	 * @param latchPath zk路径
	 * @param id 该LeaderLatchID
	 * @return
	 * @author leo
	 * @addTime 2016年3月30日下午6:10:08
	 */
	LeaderLatch createLeaderLatch(String latchPath, String id);
}
