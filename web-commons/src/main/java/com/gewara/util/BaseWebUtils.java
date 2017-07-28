/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import com.gewara.util.GewaIpConfig;
import com.gewara.util.GewaLogger;
import com.gewara.util.HtmlParser;
import com.gewara.util.JsonUtils;
import com.gewara.util.StringUtil;
import com.gewara.util.WebLogger;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

public abstract class BaseWebUtils {
	protected static final transient GewaLogger dbLogger = WebLogger.getLogger(BaseWebUtils.class);
	private static Pattern QUERY_MAP_PATTERN = Pattern.compile("&?([^=&]+)=");
	private static final List<String> DEFAULT_SENSITIVE = Arrays
			.asList(new String[]{"mobile", "pass", "sign", "encode", "token", "check", "card"});
	private static final List<String> IGNORE_KEYS = Arrays.asList(new String[]{"mobileType"});

	public String checkScript(HttpServletRequest request) {
		String match = "onclick|onfocus|onblur|onload|onerror";
		Iterator arg2 = request.getParameterMap().values().iterator();

		while (arg2.hasNext()) {
			String[] v = (String[]) arg2.next();
			String[] arg4 = v;
			int arg5 = v.length;

			for (int arg6 = 0; arg6 < arg5; ++arg6) {
				String value = arg4[arg6];
				String script = StringUtil.findFirstByRegex(value, match);
				if (StringUtils.isNotBlank(script)) {
					return script;
				}
			}
		}

		return "";
	}

	public static final String getRemoteIp(HttpServletRequest request) {
		String xfwd = request.getHeader("X-Forwarded-For");
		String result = getRemoteIpFromXfwd(xfwd);
		return StringUtils.isNotBlank(result) ? result : request.getRemoteAddr();
	}

	public static final String getRemoteIpFromXfwd(String xfwd) {
		String gewaip = null;
		if (StringUtils.isNotBlank(xfwd)) {
			String[] ipList = xfwd.split(",");

			for (int i = ipList.length - 1; i >= 0; --i) {
				String ip = ipList[i];
				ip = StringUtils.trim(ip);
				if (GewaIpConfig.isGewaServerIp(ip)) {
					gewaip = ip;
				} else if (!ip.equals("127.0.0.1") && !ip.equals("localhost")) {
					return ip;
				}
			}
		}

		return gewaip;
	}

	public static final boolean isLocalRequest(HttpServletRequest request) {
		String ip = getRemoteIp(request);
		return GewaIpConfig.isLocalIp(ip);
	}

	public static final void writeJsonResponse(HttpServletResponse res, boolean success, String retval) {
		res.setContentType("application/json;charset=utf-8");
		res.setCharacterEncoding("utf-8");

		try {
			PrintWriter writer = res.getWriter();
			HashMap jsonMap = new HashMap();
			jsonMap.put("success", Boolean.valueOf(success));
			if (!success) {
				jsonMap.put("msg", retval);
			} else {
				jsonMap.put("retval", retval);
			}

			writer.write("var data=" + JsonUtils.writeObjectToJson(jsonMap));
			res.flushBuffer();
		} catch (IOException arg4) {
			;
		}

	}

	public static final String getAttributeStr(HttpServletRequest request, String spliter) {
		String paramsStr = "";

		String tmpname;
		for (Enumeration params = request.getAttributeNames(); params
				.hasMoreElements(); paramsStr = paramsStr + tmpname + "=" + request.getAttribute(tmpname) + spliter) {
			tmpname = (String) params.nextElement();
		}

		return paramsStr;
	}

	public static final String getHeaderStr(HttpServletRequest request) {
		return "" + getHeaderMap(request);
	}

	public static final Map<String, String> getRequestMap(HttpServletRequest request) {
		HashMap result = new HashMap();
		Enumeration it = request.getParameterNames();
		String key = null;

		while (it.hasMoreElements()) {
			key = (String) it.nextElement();
			result.put(key, request.getParameter(key));
		}

		return result;
	}

	public static final Map<String, String> getHeaderMap(HttpServletRequest request) {
		HashMap result = new HashMap();
		Enumeration it = request.getHeaderNames();

		String value;
		for (String key = null; it.hasMoreElements(); result.put(key, value)) {
			key = (String) it.nextElement();
			value = request.getHeader(key);
			if (StringUtils.containsIgnoreCase(key, "cookie")) {
				value = "*******";
			}
		}

		return result;
	}

	public static final Map<String, String> getHeaderMapWidthPreKey(HttpServletRequest request) {
		HashMap result = new HashMap();
		Enumeration it = request.getHeaderNames();

		String value;
		for (String key = null; it.hasMoreElements(); result.put("head4" + StringUtils.lowerCase(key), value)) {
			key = (String) it.nextElement();
			value = request.getHeader(key);
			if (StringUtils.containsIgnoreCase(key, "cookie")) {
				value = "*******";
			}
		}

		return result;
	}

	public static final List<String> getPictures(String html) {
		return HtmlParser.getNodeAttrList(html, "img", "src");
	}

	public static final List<String> getNodeAttrList(String html, String nodename, String attrName) {
		return HtmlParser.getNodeAttrList(html, nodename, attrName);
	}

	public static final List<String> getVideos(String html) {
		return HtmlParser.getNodeAttrList(html, "embed", "src");
	}

	public static final void clearCookie(HttpServletResponse response, String path, String cookieName) {
		Cookie cookie = new Cookie(cookieName, (String) null);
		cookie.setMaxAge(0);
		cookie.setPath(path);
		response.addCookie(cookie);
	}

	public static final boolean isRobot(String userAgent) {
		return StringUtils.containsIgnoreCase(userAgent, "spider")
				|| StringUtils.containsIgnoreCase(userAgent, "Googlebot")
				|| StringUtils.containsIgnoreCase(userAgent, "robot");
	}

	public static final boolean isAjaxRequest(HttpServletRequest request) {
		boolean result = StringUtils.isNotBlank(request.getHeader("X-Requested-With"));
		return result;
	}

	public static final void addCookie(HttpServletResponse response, String cookiename, String cookievalue, String path,
			int maxSecond) {
		Cookie cookie = new Cookie(cookiename, cookievalue);
		cookie.setPath(path);
		cookie.setMaxAge(maxSecond);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
	}

	public static final Cookie getCookie(HttpServletRequest request, String cookiename) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		} else {
			Cookie[] arg2 = cookies;
			int arg3 = cookies.length;

			for (int arg4 = 0; arg4 < arg3; ++arg4) {
				Cookie cookie = arg2[arg4];
				if (cookiename.equals(cookie.getName())) {
					return cookie;
				}
			}

			return null;
		}
	}

	public static final String getCookieValue(HttpServletRequest request, String cookiename) {
		Cookie cookie = getCookie(request, cookiename);
		return cookie == null ? null : cookie.getValue();
	}

	public static final String joinParams(Map params, boolean ignoreBlank) {
		StringBuilder content = new StringBuilder();
		ArrayList keys = new ArrayList(params.keySet());
		Collections.sort(keys);
		Iterator arg3 = keys.iterator();

		while (true) {
			String key;
			Object value;
			do {
				if (!arg3.hasNext()) {
					if (content.length() > 0) {
						content.deleteCharAt(content.length() - 1);
					}

					return content.toString();
				}

				key = (String) arg3.next();
				value = params.get(key);
			} while (ignoreBlank && (value == null || !StringUtils.isNotBlank("" + value)));

			content.append(key + "=" + value + "&");
		}
	}

	public static final boolean checkString(String str) {
		return StringUtils.isBlank(str)
				? false
				: (StringUtils.contains(StringUtils.lowerCase(str), "<script")
						? true
						: StringUtils.contains(StringUtils.lowerCase(str), "<iframe"));
	}

	public static final boolean checkPropertyAll(Object entity) {
		try {
			Map result = PropertyUtils.describe(entity);
			Iterator arg1 = result.keySet().iterator();

			while (arg1.hasNext()) {
				Object key = arg1.next();
				if (result.get(key) instanceof String && checkString(result.get(key) + "")) {
					return true;
				}
			}
		} catch (Exception arg3) {
			;
		}

		return false;
	}

	public static final Map<String, String> getRequestParams(HttpServletRequest request, String... pnames) {
		TreeMap result = new TreeMap();
		if (pnames != null) {
			String[] arg2 = pnames;
			int arg3 = pnames.length;

			for (int arg4 = 0; arg4 < arg3; ++arg4) {
				String pn = arg2[arg4];
				String pv = request.getParameter(pn);
				if (StringUtils.isNotBlank(pv)) {
					result.put(pn, pv);
				}
			}
		}

		return result;
	}

	public static final String getBrowerInfo(String userAgent) {
		String browserInfo = "UNKNOWN";
		String info = StringUtils.lowerCase(userAgent);

		try {
			String[] strInfo = info.substring(info.indexOf("(") + 1, info.indexOf(")") - 1).split(";");
			if (info.indexOf("msie") > -1) {
				return strInfo[1].trim();
			}

			String[] str = info.split(" ");
			if (info.indexOf("navigator") < 0 && info.indexOf("firefox") > -1) {
				return str[str.length - 1].trim();
			}

			if (info.indexOf("opera") > -1) {
				return str[0].trim();
			}

			if (info.indexOf("chrome") < 0 && info.indexOf("safari") > -1) {
				return str[str.length - 1].trim();
			}

			if (info.indexOf("chrome") > -1) {
				return str[str.length - 2].trim();
			}

			if (info.indexOf("navigator") > -1) {
				return str[str.length - 1].trim();
			}
		} catch (Exception arg4) {
			;
		}

		return browserInfo;
	}

	public static final Map<String, String> parseQueryStr(String queryString, String encode) {
		LinkedHashMap map = new LinkedHashMap();
		if (StringUtils.isBlank(queryString)) {
			return map;
		} else {
			Matcher matcher = QUERY_MAP_PATTERN.matcher(queryString);
			String key = null;

			String value;
			int end;
			for (end = 0; matcher.find(); end = matcher.end()) {
				if (key != null) {
					try {
						value = queryString.substring(end, matcher.start());
						if (StringUtils.isNotBlank(value)) {
							value = URLDecoder.decode(value, encode);
							map.put(key, value);
						}
					} catch (UnsupportedEncodingException arg8) {
						dbLogger.error("", arg8);
					}
				}

				key = matcher.group(1);
			}

			if (key != null) {
				try {
					value = queryString.substring(end);
					if (StringUtils.isNotBlank(value)) {
						value = URLDecoder.decode(value, encode);
						map.put(key, value);
					}
				} catch (UnsupportedEncodingException arg7) {
					dbLogger.error("", arg7);
				}
			}

			return map;
		}
	}

	public static final String getQueryStr(HttpServletRequest request, String encode) {
		return getQueryStr(flatRequestMap(request.getParameterMap(), ","), encode);
	}

	public static final Map<String, String> flatRequestMap(Map<String, String[]> reqMap, String joinChar) {
		HashMap flatMap = new HashMap();
		Iterator arg2 = reqMap.keySet().iterator();

		while (arg2.hasNext()) {
			String key = (String) arg2.next();
			flatMap.put(key, StringUtils.join((Object[]) reqMap.get(key), joinChar));
		}

		return flatMap;
	}

	public static final String getQueryStr(Map<String, String> requestMap, String encode) {
		if (requestMap != null && !requestMap.isEmpty()) {
			String result = "";
			Iterator arg2 = requestMap.keySet().iterator();

			while (arg2.hasNext()) {
				String name = (String) arg2.next();

				try {
					result = result + name + "=" + URLEncoder.encode((String) requestMap.get(name), encode) + "&";
				} catch (UnsupportedEncodingException arg5) {
					;
				}
			}

			return result.substring(0, result.length() - 1);
		} else {
			return "";
		}
	}

	public static final String encodeParam(String params, String encode) {
		Map paramMap = parseQueryStr(params, encode);
		String result = "";
		Iterator arg3 = paramMap.keySet().iterator();

		while (arg3.hasNext()) {
			String key = (String) arg3.next();

			try {
				result = result + "&" + key + "=" + URLEncoder.encode((String) paramMap.get(key), encode);
			} catch (UnsupportedEncodingException arg6) {
				arg6.printStackTrace();
			}
		}

		return StringUtils.isNotBlank(result) ? result.substring(1) : "";
	}

	public static final String getContextPath(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		if (!StringUtils.endsWith(contextPath, "/")) {
			contextPath = contextPath + "/";
		}

		return contextPath;
	}

	public static final String getParamStr(HttpServletRequest request, boolean removeSensitive,
			String... sensitiveKeys) {
		Map requestMap = getRequestMap(request);
		if (removeSensitive) {
			removeSensitiveInfo(requestMap, sensitiveKeys);
		}

		return "" + requestMap;
	}

	public static final void removeSensitiveInfo(Map<String, String> params, String... keys) {
		Object keyList = null;
		if (keys != null) {
			keyList = new ArrayList(DEFAULT_SENSITIVE);
			((List) keyList).addAll(Arrays.asList(keys));
		} else {
			keyList = DEFAULT_SENSITIVE;
		}

		Iterator arg2 = (new ArrayList(params.keySet())).iterator();

		while (true) {
			String pname;
			do {
				if (!arg2.hasNext()) {
					return;
				}

				pname = (String) arg2.next();
				int valueLen = StringUtils.length((String) params.get(pname));
				if (valueLen > 1000) {
					params.put(pname, StringUtils.substring((String) params.get(pname), 1000) + "->LEN:" + valueLen);
				}
			} while (IGNORE_KEYS.contains(pname));

			Iterator arg5 = ((List) keyList).iterator();

			while (arg5.hasNext()) {
				String key = (String) arg5.next();
				if (StringUtils.containsIgnoreCase(pname, key) && StringUtils.isNotBlank((String) params.get(pname))) {
					params.put(pname, "MG" + StringUtil.md5("kcj3STidSC" + (String) params.get(pname)));
				}
			}
		}
	}

	public static final String getRemotePort(HttpServletRequest request) {
		String port = request.getHeader("x-client-port");
		return StringUtils.isBlank(port) ? "" + request.getRemotePort() : port;
	}
}