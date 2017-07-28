/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class BaseVo implements Serializable {
	private static final long serialVersionUID = -1291080555056535690L;
	private Map<String, String> attach;

	public abstract Serializable realId();

	public final int hashCode() {
		return this.realId() == null ? 0 : this.realId().hashCode();
	}

	public final boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (this.getClass() != obj.getClass()) {
			return false;
		} else {
			boolean arg9999;
			label34: {
				BaseVo other = (BaseVo) obj;
				if (this.realId() != null) {
					if (this.realId().equals(other.realId())) {
						break label34;
					}
				} else if (other.realId() == null) {
					break label34;
				}

				arg9999 = false;
				return arg9999;
			}

			arg9999 = true;
			return arg9999;
		}
	}

	public void addAttach(String key, String value) {
		if (this.attach == null) {
			this.attach = new LinkedHashMap();
		}

		this.attach.put(key, value);
	}

	public void addAttach(Map<String, String> attachMap) {
		if (this.attach == null) {
			this.attach = new LinkedHashMap();
		}

		Iterator arg1 = attachMap.entrySet().iterator();

		while (arg1.hasNext()) {
			Entry entry = (Entry) arg1.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			this.attach.put(key, value);
		}

	}

	public String getAttachByKey(String key) {
		return this.attach != null ? (String) this.attach.get(key) : null;
	}

	public Map<String, String> getAttach() {
		return this.attach;
	}
}