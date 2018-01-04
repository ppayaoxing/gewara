package com.alibaba.dubbo.remoting.zookeeper.curator;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.CuratorFrameworkFactory.Builder;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.api.GetChildrenBuilder;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException.NoNodeException;
import org.apache.zookeeper.KeeperException.NodeExistsException;
import org.apache.zookeeper.WatchedEvent;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.remoting.zookeeper.ChildListener;
import com.alibaba.dubbo.remoting.zookeeper.StateListener;
import com.alibaba.dubbo.remoting.zookeeper.support.AbstractZookeeperClient;

public class CuratorZookeeperClient extends AbstractZookeeperClient<CuratorWatcher> {

	private final CuratorFramework client;

	public CuratorZookeeperClient(URL url) {
		super(url);
		Builder builder = CuratorFrameworkFactory.builder()
				.connectString(url.getBackupAddress())
		        .retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000))  
		        .connectionTimeoutMs(10000);//original 5
		String authority = url.getAuthority();
		if (authority != null && authority.length() > 0) {
			builder = builder.authorization("digest", authority.getBytes());
		}
		client = builder.build();
		client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
			@Override
            public void stateChanged(CuratorFramework client, ConnectionState state) {
				if (state == ConnectionState.LOST) {
					CuratorZookeeperClient.this.stateChanged(StateListener.DISCONNECTED);
				} else if (state == ConnectionState.CONNECTED) {
					CuratorZookeeperClient.this.stateChanged(StateListener.CONNECTED);
				} else if (state == ConnectionState.RECONNECTED) {
					CuratorZookeeperClient.this.stateChanged(StateListener.RECONNECTED);
				}
			}
		});
		client.start();
	}

	@Override
    public void createPersistent(String path) {
		try {
			client.create().forPath(path);
		} catch (NodeExistsException e) {
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}

	@Override
    public void createEphemeral(String path) {
		try {
			client.create().withMode(CreateMode.EPHEMERAL).forPath(path);
		} catch (NodeExistsException e) {
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}

	@Override
    public void delete(String path) {
		try {
			client.delete().forPath(path);
		} catch (NoNodeException e) {
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}

	@Override
    public List<String> getChildren(String path) {
		try {
			return client.getChildren().forPath(path);
		} catch (NoNodeException e) {
			return null;
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}

	@Override
    public boolean isConnected() {
		return client.getZookeeperClient().isConnected();
	}

	@Override
    public void doClose() {
		client.close();
	}
	
	private class CuratorWatcherImpl implements CuratorWatcher {
		
		private volatile ChildListener listener;
		
		public CuratorWatcherImpl(ChildListener listener) {
			this.listener = listener;
		}
		
		public void unwatch() {
			this.listener = null;
		}
		
		@Override
        public void process(WatchedEvent event) throws Exception {
			if (listener != null) {
				//������־������Ϣ
				try{
					GetChildrenBuilder chb = client.getChildren();
					listener.childChanged(event.getPath(), chb.usingWatcher(this).forPath(event.getPath()));
				}catch(Exception e){
					//client
					String info = "event.getPath:" + event.getPath() + ",client.namespace:" + client.getNamespace() + ",event.type:" + event.getType();
					logger.warn(info);
					throw new Exception(info, e);
				}
			}
		}
	}
	
	@Override
    public CuratorWatcher createTargetChildListener(String path, ChildListener listener) {
		return new CuratorWatcherImpl(listener);
	}
	
	@Override
    public List<String> addTargetChildListener(String path, CuratorWatcher listener) {
		try {
			return client.getChildren().usingWatcher(listener).forPath(path);
		} catch (NoNodeException e) {
			return null;
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}
	
	@Override
    public void removeTargetChildListener(String path, CuratorWatcher listener) {
		((CuratorWatcherImpl) listener).unwatch();
	}

}
