/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.support.GwJsonInstanceSerializer;
import com.gewara.untrans.ServiceDetails;
import com.gewara.untrans.ServiceDiscover;
import com.gewara.untrans.monitor.CuratorConnectionFactroy;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.x.discovery.ServiceCache;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.beans.factory.InitializingBean;

public class ServiceDiscoverImpl implements ServiceDiscover, InitializingBean {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private CuratorFramework client;
	private CuratorConnectionFactroy factory;
	private String basePath = "/SERVICE/DISCOVER";
	private ServiceDiscovery<ServiceDetails> serviceDiscovery;
	private ConcurrentHashMap<String, ServiceCache<ServiceDetails>> serviceCacheMap = new ConcurrentHashMap();

	public void setFactory(CuratorConnectionFactroy factory) {
		this.factory = factory;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public List<ServiceInstance<ServiceDetails>> getServiceInstance(String name) throws Exception {
		ServiceCache cacheService = (ServiceCache) this.serviceCacheMap.get(name);
		if (cacheService == null) {
			synchronized (this) {
				cacheService = (ServiceCache) this.serviceCacheMap.get(name);
				if (cacheService == null) {
					cacheService = this.serviceDiscovery.serviceCacheBuilder().name(name).build();
					cacheService.start();
					this.serviceCacheMap.put(name, cacheService);
				}
			}
		}

		return cacheService.getInstances();
	}

	public List<ServiceInstance<ServiceDetails>> getServiceInstance(String providerSystemId, String name)
			throws Exception {
		String serviceName = ServiceDetails.buildServiceName(providerSystemId, name);
		ServiceCache cacheService = (ServiceCache) this.serviceCacheMap.get(serviceName);
		if (cacheService == null) {
			synchronized (this) {
				cacheService = (ServiceCache) this.serviceCacheMap.get(serviceName);
				if (cacheService == null) {
					cacheService = this.serviceDiscovery.serviceCacheBuilder().name(serviceName).build();
					cacheService.start();
					this.serviceCacheMap.put(serviceName, cacheService);
				}
			}
		}

		return cacheService.getInstances();
	}

	public void afterPropertiesSet() throws Exception {
		if (this.factory != null && this.factory.getCuratorFramework() != null) {
			this.client = this.factory.getCuratorFramework();
			GwJsonInstanceSerializer serializer = new GwJsonInstanceSerializer(ServiceDetails.class);
			this.serviceDiscovery = ServiceDiscoveryBuilder.builder(ServiceDetails.class).client(this.client)
					.serializer(serializer).basePath(this.basePath).build();
			this.serviceDiscovery.start();
		} else {
			throw new IOException("connect to zookeeper failure");
		}
	}
}