/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb;

import com.mongodb.Tag;
import com.mongodb.TagSet;

public class HostInfo {
	private String tagName = null;
	private String tagValue = null;
	private String ip = null;
	private Integer port = null;

	public HostInfo() {
	}

	public HostInfo(String tag, String value) {
		this.tagName = tag;
		this.tagValue = value;
	}

	public HostInfo(String ip, Integer port, String tag, String value) {
		this.ip = ip;
		this.port = port;
		this.tagName = tag;
		this.tagValue = value;
	}

	public HostInfo(String ipport) {
		String[] h = ipport.split(":");
		this.ip = h[0].trim();
		this.port = Integer.valueOf(Integer.parseInt(h[1].trim()));
	}

	public String getTagName() {
		return this.tagName;
	}

	public String getTagValue() {
		return this.tagValue;
	}

	public String getIp() {
		return this.ip;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public TagSet getTagSet() {
		return new TagSet(new Tag(this.tagName, this.tagValue));
	}

	public Integer getPort() {
		return this.port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
}