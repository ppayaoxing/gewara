/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.util.DateUtil;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public class PageParams {
	private Map<String, String> params = new TreeMap();
	private Map<String, String[]> reqCookies = new TreeMap();
	private int hash = 0;

	public Map<String, String[]> getReqCookies() {
		return this.reqCookies;
	}

	public Map<String, String> getParams() {
		return this.params;
	}

	public void addCookie(String cookieName, String cookiePath, String value) {
		this.reqCookies.put(cookieName, new String[]{cookiePath, value});
	}

	public void addInteger(String key, Integer value) {
		if (value != null) {
			this.params.put(key, value.toString());
		}

	}

	public void addLong(String key, Long value) {
		if (value != null) {
			this.params.put(key, value.toString());
		}

	}

	public void addDate(String key, Date date) {
		if (date != null) {
			this.params.put(key, DateUtil.formatDate(date));
		}

	}

	public void addTimestamp(String key, Timestamp timestamp) {
		if (timestamp != null) {
			this.params.put(key, DateUtil.formatTimestamp(timestamp));
		}

	}

	public void addNumber(HttpServletRequest req, String paramName) {
		String value = req.getParameter(paramName);
		if (StringUtils.isNotBlank(value) && NumberUtils.isNumber(value)) {
			this.params.put(paramName, value);
		}

	}

	public void addNumberStr(String key, String value) {
		if (StringUtils.isNotBlank(value) && NumberUtils.isNumber(value)) {
			this.params.put(key, value);
		}

	}

	public void addDateStr(String key, String value) {
		Date date = DateUtil.parseDate(value);
		if (date != null) {
			this.params.put(key, value);
		}

	}

	public void addTimestampStr(String key, String value) {
		Timestamp date = DateUtil.parseTimestamp(value);
		if (date != null) {
			this.params.put(key, value);
		}

	}

	public void addDate(HttpServletRequest req, String paramName) {
		String value = req.getParameter(paramName);
		this.addDateStr(paramName, value);
	}

	public void addTimestamp(HttpServletRequest req, String paramName) {
		String value = req.getParameter(paramName);
		this.addTimestampStr(paramName, value);
	}

	public void addEnum(HttpServletRequest req, String paramName, List<String> validList) {
		String value = req.getParameter(paramName);
		this.addEnumStr(paramName, value, validList);
	}

	public void addEnumStr(String key, String value, List<String> validList) {
		if (StringUtils.isNotBlank(value) && validList.contains(value)) {
			this.params.put(key, value);
		}

	}

	public void addSingleString(String name, String value) {
		if (StringUtils.isNotBlank(value) && StringUtils.isNotBlank(name)) {
			this.params.put(name, value);
		}

	}

	public void addString(HttpServletRequest req, String paramName) {
		String value = req.getParameter(paramName);
		if (StringUtils.isNotBlank(value)) {
			this.params.put(paramName, value);
		}

	}

	public int gainParamsHash() {
		if (this.hash == 0) {
			String paramHash = "" + this.getParams();
			if (!this.reqCookies.isEmpty()) {
				paramHash = paramHash + "cookie";

				String key;
				for (Iterator arg1 = this.reqCookies.keySet().iterator(); arg1.hasNext(); paramHash = paramHash + key
						+ ((String[]) this.reqCookies.get(key))[0] + ((String[]) this.reqCookies.get(key))[1]) {
					key = (String) arg1.next();
				}
			}

			this.hash = paramHash.hashCode();
		}

		return this.hash;
	}
}