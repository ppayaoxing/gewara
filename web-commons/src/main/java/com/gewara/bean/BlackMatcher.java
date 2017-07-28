/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.StringUtils;

public class BlackMatcher {
	private Map<String, Long> matcherMap = new HashMap();
	private String ip;

	public BlackMatcher() {
	}

	public BlackMatcher(String ip) {
		this.ip = ip;
	}

	public Long get(String uri) {
		return (Long) this.matcherMap.get(uri);
	}

	public Long get() {
		return (Long) this.matcherMap.get("ALL");
	}

	public void put(String uri, Long releaseTime) {
		if (StringUtils.isBlank(uri)) {
			this.matcherMap.put("ALL", releaseTime);
		} else {
			this.matcherMap.put(uri, releaseTime);
		}

	}

	public void put(Long releaseTime) {
		this.matcherMap.put("ALL", releaseTime);
	}

	public void remove(String uri) {
		this.matcherMap.remove(uri);
	}

	public void remove() {
		this.matcherMap.remove("ALL");
	}

	public boolean isEmpty() {
		return this.matcherMap.isEmpty();
	}

	public void delOverdue() {
		long currentTime = System.currentTimeMillis();
		HashMap tmp = new HashMap(this.matcherMap);
		Iterator it = tmp.entrySet().iterator();
		boolean flag = false;

		while (it.hasNext()) {
			Entry entry = (Entry) it.next();
			if (((Long) entry.getValue()).longValue() < currentTime) {
				it.remove();
				flag = true;
			}
		}

		if (flag) {
			this.matcherMap = tmp;
		}

	}

	public Long gainReleaseTime(String uri) {
		Long uriReleaseTime = (Long) this.matcherMap.get(uri);
		if (uriReleaseTime != null) {
			return uriReleaseTime;
		} else {
			Long ipReleaseTime = (Long) this.matcherMap.get("ALL");
			return ipReleaseTime;
		}
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Map<String, Long> getMatcherMap() {
		return this.matcherMap;
	}
}