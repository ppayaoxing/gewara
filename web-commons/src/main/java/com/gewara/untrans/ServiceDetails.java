/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("details")
public class ServiceDetails {
	private String systemId;
	private String name;
	private String address;
	private int port;
	private String uri;

	public ServiceDetails() {
	}

	public ServiceDetails(String systemId, String name, String address, int port, String uri) {
		this.systemId = systemId;
		this.name = name;
		this.address = address;
		this.port = port;
		this.uri = uri;
	}

	public static String buildServiceName(String systemId, String name) {
		return systemId + "|" + name;
	}

	public String getSystemId() {
		return this.systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}