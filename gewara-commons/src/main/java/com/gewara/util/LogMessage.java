/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.JsonUtils;
import com.gewara.util.LoggerUtils;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class LogMessage implements Serializable {
	private static final long serialVersionUID = -1449397931879372657L;
	private Map data = new LinkedHashMap();

	public LogMessage(String type, String server, String systemId, Map paramsdata) {
		this.init(type, server, systemId);
		this.data.put("message", paramsdata);
	}

	public LogMessage(String type, String server, String systemId, String message) {
		this.init(type, server, systemId);
		this.data.put("message", message);
	}

	public LogMessage(String type, String server, String systemId, String message, Throwable t) {
		this.init(type, server, systemId);
		this.data.put("message", message);
		this.data.put("exception", t.getClass().getCanonicalName());
		this.data.put("exceptionTrace", LoggerUtils.getExceptionTrace(t, 200));
	}

	private void init(String type, String server, String systemId) {
		if (type != null) {
			this.data.put("type", type);
		}

		this.data.put("server", server);
		this.data.put("systemid", systemId);
	}

	public String getDataStr() {
		return JsonUtils.writeObjectToJson(this.data);
	}

	public Map getDataMap() {
		return this.data;
	}
}