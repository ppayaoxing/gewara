/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.support.GwJsonInstanceSerializer;
import com.gewara.untrans.ServiceDetails;
import com.gewara.untrans.ServiceRegister;
import com.gewara.untrans.monitor.CuratorConnectionFactroy;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import java.io.IOException;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.UriSpec;
import org.springframework.beans.factory.InitializingBean;

public class ServiceRegisterImpl implements ServiceRegister, InitializingBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private CuratorFramework client;
	private CuratorConnectionFactroy factory;
	private String basePath = "/SERVICE/DISCOVER";
	private ServiceDiscovery<ServiceDetails> serviceDiscovery;

	public void setFactory(CuratorConnectionFactroy factory) {
		this.factory = factory;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public void registerService(ServiceDetails details) throws Exception {
		ServiceInstance serviceInstance = this.buildServiceInstance(details);
		this.serviceDiscovery.registerService(serviceInstance);
		this.dbLogger.warn(serviceInstance.toString());
	}

	public void updateService(ServiceDetails details) throws Exception {
		ServiceInstance serviceInstance = this.buildServiceInstance(details);
		this.serviceDiscovery.updateService(serviceInstance);
		this.dbLogger.warn(serviceInstance.toString());
	}

	private ServiceInstance<ServiceDetails> buildServiceInstance(ServiceDetails details) throws Exception {
		ServiceInstance serviceInstance = ServiceInstance.builder()
				.name(ServiceDetails.buildServiceName(details.getSystemId(), details.getName()))
				.address(details.getAddress()).port(details.getPort()).payload(details)
				.uriSpec(new UriSpec(details.getUri())).build();
		return serviceInstance;
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