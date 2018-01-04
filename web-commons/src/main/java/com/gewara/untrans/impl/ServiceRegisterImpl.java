package com.gewara.untrans.impl;

import java.io.IOException;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.UriSpec;
import org.springframework.beans.factory.InitializingBean;

import com.gewara.constant.ServiceDiscoverConstant;
import com.gewara.support.GwJsonInstanceSerializer;
import com.gewara.untrans.ServiceDetails;
import com.gewara.untrans.ServiceRegister;
import com.gewara.untrans.monitor.CuratorConnectionFactroy;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

/**
 * 基于CuratorFramework的服务注册
 * <p>使用:<br>
 * {@code <bean id="serviceRegister" class="com.gewara.untrans.impl.ServiceRegisterImpl">} <br>
 * {@code     <property name="basePath" value="/service/discovery"/>}<br>
 * {@code     <property name="factory" ref="curatorConnectionFactroy"/>}<br>
 * {@code </bean> }<br>
 * 如果"basePath属性不配置，默认使用{@link ServiceDiscoverConstant#DEFALT_BASE_PATH}
 * 
 * @author quzhuping
 *
 */
public class ServiceRegisterImpl implements ServiceRegister, InitializingBean {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private CuratorFramework client;
	private CuratorConnectionFactroy factory;
	private String basePath = ServiceDiscoverConstant.DEFALT_BASE_PATH;
	private ServiceDiscovery<ServiceDetails> serviceDiscovery;

	public void setFactory(CuratorConnectionFactroy factory) {
		this.factory = factory;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	@Override
	public void registerService(ServiceDetails details) throws Exception {

		ServiceInstance<ServiceDetails> serviceInstance = this.buildServiceInstance(details);
		serviceDiscovery.registerService(serviceInstance);

		dbLogger.warn(serviceInstance.toString());
	}

	@Override
	public void updateService(ServiceDetails details) throws Exception {
		ServiceInstance<ServiceDetails> serviceInstance = this.buildServiceInstance(details);
		serviceDiscovery.updateService(serviceInstance);

		dbLogger.warn(serviceInstance.toString());
	}
	
	private ServiceInstance<ServiceDetails> buildServiceInstance(ServiceDetails details) throws Exception{
		ServiceInstance<ServiceDetails> serviceInstance = ServiceInstance.<ServiceDetails> builder()
				.name(ServiceDetails.buildServiceName(details.getSystemId(), details.getName()))
				.address(details.getAddress())
				.port(details.getPort())
				.payload(details)
				.uriSpec(new UriSpec(details.getUri()))
				.build();
		return serviceInstance;
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
