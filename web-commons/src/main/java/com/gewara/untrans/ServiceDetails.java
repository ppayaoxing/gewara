package com.gewara.untrans;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("details")
public class ServiceDetails {
	private String systemId;	//服务提供方系统Id
	private String name; 		//服务名称
	private String address;		//IP地址
	private int port;			//服务端口
	private String uri;			//服务uri {scheme}://foo.com:{port}
	
	public ServiceDetails(){
	}
	
	/**
	 * 构造函数
	 * @param systemId 服务提供方系统Id
	 * @param name 服务名称
	 * @param address IP地址
	 * @param port 服务端口
	 * @param uri 服务uri {scheme}://foo.com:{port}
	 */
	public ServiceDetails(String systemId, String name, String address, int port, String uri){
		this.systemId = systemId;
		this.name = name;
		this.address = address;
		this.port = port;
		this.uri = uri;
	}
	
	/**
	 * 生成servicenName
	 * @param systemId
	 * @param name
	 * @return systemId + "|" + name;
	 */
	public static String buildServiceName(String systemId, String name){
		return systemId + "|" + name;
	}
	
	public String getSystemId() {
		return systemId;
	}
	
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
}
