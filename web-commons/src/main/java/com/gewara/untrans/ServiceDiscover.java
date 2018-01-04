package com.gewara.untrans;

import java.util.List;

import org.apache.curator.x.discovery.ServiceInstance;

public interface ServiceDiscover {

	/**
	 * 根据name获取basePah路径下的服务实例<br>
	 * {@link ServiceDiscover#getServiceInstance(String, String)}
	 * @param name
	 * @return
	 * @throws Exception
	 */
	List<ServiceInstance<ServiceDetails>> getServiceInstance(String name) throws Exception;

	/**
	 * 根据服务提供方systemId 和 name获取basePah路径下的服务实例
	 * <br>用于服务查找的serviceName使用{@link ServiceDetails#buildServiceName(String, String)}创建
	 * @param providerSystemId
	 * @param name
	 * @return
	 * @throws Exception
	 */
	List<ServiceInstance<ServiceDetails>> getServiceInstance(String providerSystemId, String name) throws Exception;

}
