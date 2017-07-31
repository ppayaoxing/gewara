package com.gewara.untrans;

import java.io.IOException;
import java.util.List;

public interface LeaderElectionService {

	/**
	 * 创建选举
	 * @param key	创建一个选举唯一标识，该必须符合ZK节点命名规范
	 * @param listener	监听
	 * @throws Exception
	 * @author leo
	 * @addTime 2016年4月18日下午5:17:26
	 */
	void createElection(String key, GewaLeaderLatchListener listener) throws Exception;

	/**
	 * 创建选举
	 * @param key	创建一个选举唯一标识，该必须符合ZK节点命名规范
	 * @param listenerList	监听
	 * @throws Exception
	 * @author leo
	 * @addTime 2016年4月18日下午5:17:26
	 */
	void createElection(String key, List<GewaLeaderLatchListener> listenerList) throws Exception;

	/**
	 * 关闭选举
	 * @param key	选举唯一标识
	 * @throws IOException
	 * @author leo
	 * @addTime 2016年4月18日下午5:23:58
	 */
	void closeElection(String key) throws IOException;

	/**
	 * 添加监听
	 * @param key	选举唯一标识
	 * @param listener
	 * @author leo
	 * @addTime 2016年4月18日下午5:24:16
	 */
	void addListener(String key, GewaLeaderLatchListener listener);
	
	/**
	 * 判断当前是否是leader
	 * @param key
	 * @return
	 * @author leo
	 * @addTime 2016年4月21日下午4:37:43
	 */
	boolean isLeader(String key);

}
