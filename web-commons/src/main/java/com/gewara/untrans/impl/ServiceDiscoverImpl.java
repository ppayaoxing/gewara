package com.gewara.untrans.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.x.discovery.ServiceCache;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.beans.factory.InitializingBean;

import com.gewara.constant.ServiceDiscoverConstant;
import com.gewara.support.GwJsonInstanceSerializer;
import com.gewara.untrans.ServiceDetails;
import com.gewara.untrans.ServiceDiscover;
import com.gewara.untrans.monitor.CuratorConnectionFactroy;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

/**
 * 基于CuratorFramework的服务发现
 * <p>使用:<br>
 * {@code <bean id="serviceDiscover" class="com.gewara.untrans.impl.ServiceDiscoverImpl">} <br>
 * {@code     <property name="basePath" value="/service/discovery"/>}<br>
 * {@code     <property name="factory" ref="curatorConnectionFactroy"/>}<br>
 * {@code </bean> }<br>
 * 如果"basePath属性不配置，默认使用{@link ServiceDiscoverConstant#DEFALT_BASE_PATH}
 * 
 * @author quzhuping
 *
 */
public class ServiceDiscoverImpl implements ServiceDiscover, InitializingBean {
	
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private CuratorFramework client;
	private CuratorConnectionFactroy factory;
	private String basePath = ServiceDiscoverConstant.DEFALT_BASE_PATH;
	private ServiceDiscovery<ServiceDetails> serviceDiscovery;
	private ConcurrentHashMap<String , ServiceCache<ServiceDetails>> serviceCacheMap = new ConcurrentHashMap<>();

	public void setFactory(CuratorConnectionFactroy factory) {
		this.factory = factory;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	@Override
	public List<ServiceInstance<ServiceDetails>> getServiceInstance(String name) throws Exception{
		ServiceCache<ServiceDetails> cacheService = serviceCacheMap.get(name);
		if(cacheService == null){
			synchronized (this) {
				cacheService = serviceCacheMap.get(name);
				if(cacheService == null){
					cacheService = serviceDiscovery.serviceCacheBuilder().name(name).build();
					cacheService.start();
					serviceCacheMap.put(name, cacheService);
				}
			}
		}
		return cacheService.getInstances();
	}
	
	@Override
	public List<ServiceInstance<ServiceDetails>> getServiceInstance(String providerSystemId, String name) throws Exception{
		String serviceName = ServiceDetails.buildServiceName(providerSystemId, name);
		
		ServiceCache<ServiceDetails> cacheService = serviceCacheMap.get(serviceName);
		if(cacheService == null){
			synchronized (this) {
				cacheService = serviceCacheMap.get(serviceName);
				if(cacheService == null){
					cacheService = serviceDiscovery.serviceCacheBuilder().name(serviceName).build();
					cacheService.start();
					serviceCacheMap.put(serviceName, cacheService);
				}
			}
		}
		return cacheService.getInstances();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (factory == null || factory.getCuratorFramework() == null) {
			throw new IOException("connect to zookeeper failure");
		}
		this.client = this.factory.getCuratorFramework();
		GwJsonInstanceSerializer<ServiceDetails> serializer = new GwJsonInstanceSerializer<ServiceDetails>(ServiceDetails.class);
		serviceDiscovery = ServiceDiscoveryBuilder.builder(ServiceDetails.class)
				.client(client)
				.serializer(serializer)
				.basePath(basePath)
				.build();
		serviceDiscovery.start();
	}
}
