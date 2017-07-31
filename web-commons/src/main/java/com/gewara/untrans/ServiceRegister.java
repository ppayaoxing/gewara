package com.gewara.untrans;

public interface ServiceRegister {

	/**
	 * 向zk注册服务接口数据
	 * 用于服务发现的serviceName使用{@link ServiceDetails#buildServiceName(String, String)}创建
	 * @param details
	 * @throws Exception
	 */
	void registerService(ServiceDetails details) throws Exception;

	/**
	 * 修改zk已经注册的服务接口数据
	 * @param details
	 * @throws Exception
	 */
	void updateService(ServiceDetails details) throws Exception;

}
