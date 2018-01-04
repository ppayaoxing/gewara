package com.gewara.util;

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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Maps;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

public abstract class BaseWebUtils {
	protected final static transient GewaLogger dbLogger = WebLogger.getLogger(BaseWebUtils.class);

	public String checkScript(HttpServletRequest request) {
		String match = "onclick|onfocus|onblur|onload|onerror";
		for (String[] v : request.getParameterMap().values()) {
			for (String value : v) {
				String script = StringUtil.findFirstByRegex(value, match);
				if (StringUtils.isNotBlank(script)) {
					return script;
				}
			}
		}
		return "";
	}

	/** 鏍规嵁request鑾峰彇ip鍦板潃
	 * @param request
	 * @return
	 */
	public static final String getRemoteIp(HttpServletRequest request) {
		String xfwd = request.getHeader("X-Forwarded-For");
		String result = getRemoteIpFromXfwd(xfwd);
		if (StringUtils.isNotBlank(result)) {
			return result;
		}
		return request.getRemoteAddr();
	}

	public static final boolean isLocalIp(String ip) {
		return GewaIpConfig.isLocalIp(ip);
	}

	public static final String getRemoteIpFromXfwd(String xfwd) {
		String gewaip = null;
		if (StringUtils.isNotBlank(xfwd)) {
			String[] ipList = xfwd.split(",");
			for (int i = ipList.length - 1; i >= 0; i--) {
				String ip = ipList[i];
				ip = StringUtils.trim(ip);
				if (GewaIpConfig.isGewaServerIp(ip)) {
					gewaip = ip;
				} else if (!"127.0.0.1".equals(ip) && !"localhost".equals(ip)) {
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
			Map jsonMap = new HashMap();
			jsonMap.put("success", success);
			if (!success) {
				jsonMap.put("msg", retval);
			} else {
				jsonMap.put("retval", retval);
			}
			writer.write("var data=" + JsonUtils.writeObjectToJson(jsonMap));
			res.flushBuffer();
		} catch (IOException e) {
		}
	}

	public static final String getAttributeStr(HttpServletRequest request, String spliter) {
		String paramsStr = "";
		String tmpname;
		Enumeration params = request.getAttributeNames();
		while (params.hasMoreElements()) {
			tmpname = (String) params.nextElement();
			paramsStr += tmpname + "=" + request.getAttribute(tmpname) + spliter;
		}
		return paramsStr;
	}

	/**鏍规嵁request灏佽璇锋眰娑堟伅澶翠俊鎭埌 Map,骞朵笖绂佹cookie鏃ュ織鎵撳嵃
	 * @param request
	 * @return
	 */
	public static final String getHeaderStr(HttpServletRequest request) {
		return "" + getHeaderMap(request);
	}

	/** 鏍规嵁request灏佽璇锋眰鍙傛暟鍒� Map
	 * @param request
	 * @return
	 */
	public static final Map<String, String> getRequestMap(HttpServletRequest request) {
		Map<String, String> result = Maps.newHashMap();
		Enumeration<String> it = request.getParameterNames();
		String key = "";
		while (it.hasMoreElements()) {
			key = it.nextElement();
			result.put(key, request.getParameter(key));
		}
		return result;
	}

	/** 鏍规嵁request灏佽璇锋眰娑堟伅澶翠俊鎭埌 Map,骞朵笖绂佹cookie鏃ュ織鎵撳嵃
	 * @param request
	 * @return
	 */
	public static final Map<String, String> getHeaderMap(HttpServletRequest request) {
		Map<String, String> result = Maps.newHashMap();
		Enumeration<String> it = request.getHeaderNames();
		String key = null;
		while (it.hasMoreElements()) {
			key = it.nextElement();
			String value = request.getHeader(key);
			// 绂佹cookie鏃ュ織鎵撳嵃
			if (StringUtils.containsIgnoreCase(key, "cookie")) {
				value = "*******";
			}
			result.put(key, value);
		}
		return result;
	}

	/**
	 * 杩斿洖Map锛屼絾key=鈥渉ead4鈥�+originalKey
	 * 
	 * @param request
	 * @return
	 */
	public static final Map<String, String> getHeaderMapWidthPreKey(HttpServletRequest request) {
		Map<String, String> result = new HashMap<String, String>();
		Enumeration<String> it = request.getHeaderNames();
		String key = null;
		while (it.hasMoreElements()) {
			key = it.nextElement();
			String value = request.getHeader(key);
			// 绂佹cookie鏃ュ織鎵撳嵃
			if (StringUtils.containsIgnoreCase(key, "cookie")) {
				value = "*******";
			}
			result.put("head4" + StringUtils.lowerCase(key), value);
		}
		return result;

	}

	/**
	 * 鑾峰彇html涓浘鐗囩殑url
	 * 
	 * @param html
	 * @return
	 */
	public static final List<String> getPictures(String html) {
		return HtmlParser.getNodeAttrList(html, "img", "src");
	}

	public static final List<String> getNodeAttrList(String html, String nodename, String attrName) {
		return HtmlParser.getNodeAttrList(html, nodename, attrName);
	}

	/**
	 * 鑾峰彇html涓棰戠殑url
	 * 
	 * @param html
	 * @return
	 */
	public static final List<String> getVideos(String html) {
		return HtmlParser.getNodeAttrList(html, "embed", "src");
	}

	public static final void clearCookie(HttpServletResponse response, String path, String cookieName) {
		Cookie cookie = new Cookie(cookieName, null);
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
		cookie.setMaxAge(maxSecond);// 24 hour
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
	}

	public static final Cookie getCookie(HttpServletRequest request, String cookiename) {
        Cookie[] cookies = request.getCookies();
		if (cookies == null) {
            return null;
        }
		for (Cookie cookie : cookies) {
			if (cookiename.equals(cookie.getName())) {
				return cookie;
			}
		}
		return null;
	}

	public static final String getCookieValue(HttpServletRequest request, String cookiename) {
		Cookie cookie = getCookie(request, cookiename);
		if (cookie == null) {
            return null;
        }
		return cookie.getValue();
	}

	public static final String joinParams(Map params, boolean ignoreBlank) {
		StringBuilder content = new StringBuilder();
		List<String> keys = new ArrayList(params.keySet());
		Collections.sort(keys);
		for (String key : keys) {
			Object value = params.get(key);
			if (!ignoreBlank || value != null && StringUtils.isNotBlank("" + value)) {
                content.append(key + "=" + value + "&");
            }
		}
		if (content.length() > 0) {
            content.deleteCharAt(content.length() - 1);
        }
		return content.toString();
	}

	public static final boolean checkString(String str) {
		if (StringUtils.isBlank(str)) {
            return false;
        }
		if (StringUtils.contains(StringUtils.lowerCase(str), "<script")) {
            return true;// 楠岃瘉JS
        }
		if (StringUtils.contains(StringUtils.lowerCase(str), "<iframe")) {
            return true;// 楠岃瘉iframe
        }
		return false;
	}

	public static final boolean checkPropertyAll(Object entity) {
		try {
			Map result = PropertyUtils.describe(entity);
			for (Object key : result.keySet()) {
				if (result.get(key) instanceof String) {
					if (checkString(result.get(key) + "")) {
                        return true;
                    }
				}
			}
		} catch (Exception ex) {
		}
		return false;
	}

	public static final Map<String, String> getRequestParams(HttpServletRequest request, String... pnames) {
		Map<String, String> result = new TreeMap<String, String>();
		if (pnames != null) {
			for (String pn : pnames) {
				String pv = request.getParameter(pn);
				if (StringUtils.isNotBlank(pv)) {
                    result.put(pn, pv);
                }
			}
		}
		return result;
	}

	/**
	 * 鍒ゆ柇鐢ㄦ埛娴忚鍣ㄤ俊鎭�
	 */
	public static final String getBrowerInfo(String userAgent) {
		String browserInfo = "UNKNOWN";
		String info = StringUtils.lowerCase(userAgent);
		try {
			String[] strInfo = info.substring(info.indexOf("(") + 1, info.indexOf(")") - 1).split(";");
			if ((info.indexOf("msie")) > -1) {
				return strInfo[1].trim();
			} else {
				String[] str = info.split(" ");
				if (info.indexOf("navigator") < 0 && info.indexOf("firefox") > -1) {
					return str[str.length - 1].trim();
				} else if ((info.indexOf("opera")) > -1) {
					return str[0].trim();
				} else if (info.indexOf("chrome") < 0 && info.indexOf("safari") > -1) {
					return str[str.length - 1].trim();
				} else if (info.indexOf("chrome") > -1) {
					return str[str.length - 2].trim();
				} else if (info.indexOf("navigator") > -1) {
					return str[str.length - 1].trim();
				}
			}
		} catch (Exception e) {
		}
		return browserInfo;
	}

	/**
	 * 鏌ヨ涓叉彁鍙�
	 * 
	 * @param queryStr
	 * @param encode
	 * @return
	 */
	private static Pattern QUERY_MAP_PATTERN = Pattern.compile("&?([^=&]+)=");

	/**
	 * @param queryString
	 *            encoded queryString queryString is already encoded (e.g %20
	 *            and & may be present)
	 * @param encode
	 * @return
	 */
	public static final Map<String, String> parseQueryStr(String queryString, String encode) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		if (StringUtils.isBlank(queryString)) {
            return map;
        }
		Matcher matcher = QUERY_MAP_PATTERN.matcher(queryString);
		String key = null, value;
		int end = 0;
		while (matcher.find()) {
			if (key != null) {
				try {
					value = queryString.substring(end, matcher.start());
					if (StringUtils.isNotBlank(value)) {
						value = URLDecoder.decode(value, encode);
						map.put(key, value);
					}
				} catch (UnsupportedEncodingException e) {
					dbLogger.error("", e);
				}
			}
			key = matcher.group(1);
			end = matcher.end();
		}
		if (key != null) {
			try {
				value = queryString.substring(end);
				if (StringUtils.isNotBlank(value)) {
					value = URLDecoder.decode(value, encode);
					map.put(key, value);
				}
			} catch (UnsupportedEncodingException e) {
				dbLogger.error("", e);
			}
		}
		return map;
	}

	public static final String getQueryStr(HttpServletRequest request, String encode) {
		return getQueryStr(flatRequestMap(request.getParameterMap(), ","), encode);
	}

	public static final Map<String, String> flatRequestMap(Map<String, String[]> reqMap, String joinChar) {
		Map<String, String> flatMap = new HashMap<String, String>();
		for (String key : reqMap.keySet()) {
			flatMap.put(key, StringUtils.join(reqMap.get(key), joinChar));
		}
		return flatMap;
	}

	/**
	 * 澶氬�肩敤鈥�,鈥濆彿闅斿紑
	 * 
	 * @param requestMap
	 * @param encode
	 * @return
	 */
	public static final String getQueryStr(Map<String, String> requestMap, String encode) {
		if (requestMap == null || requestMap.isEmpty()) {
            return "";
        }
		String result = "";
		for (String name : requestMap.keySet()) {
			try {
				result += name + "=" + URLEncoder.encode(requestMap.get(name), encode) + "&";
			} catch (UnsupportedEncodingException e) {
			}
		}
		return result.substring(0, result.length() - 1);
	}

	public static final String encodeParam(String params, String encode) {
		Map<String, String> paramMap = parseQueryStr(params, encode);
		String result = "";
		for (String key : paramMap.keySet()) {
			try {
				result += "&" + key + "=" + URLEncoder.encode(paramMap.get(key), encode);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotBlank(result)) {
            return result.substring(1);
        }
		return "";
	}

	public static final String getContextPath(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		if (!StringUtils.endsWith(contextPath, "/")) {
            contextPath += "/";
        }
		return contextPath;
	}

	/** 鑾峰彇璇锋眰鍙傛暟,骞朵笖鏍规嵁瑕佹眰瀵规晱鎰熶俊鎭繘琛屽姞瀵�
	 * @param request
	 * @param removeSensitive
	 * @param sensitiveKeys
	 * @return
	 */
	public static final String getParamStr(HttpServletRequest request, boolean removeSensitive,
			String... sensitiveKeys) {
		Map<String, String> requestMap = getRequestMap(request);
		if (removeSensitive) {
			removeSensitiveInfo(requestMap, sensitiveKeys);
		}
		return "" + requestMap;
	}

	private static final List<String> DEFAULT_SENSITIVE = Arrays.asList("mobile", "pass", "sign", "encode", "token",
			"check", "card");
	private static final List<String> IGNORE_KEYS = Arrays.asList("mobileType");

	/** 绉婚櫎鏁忔劅淇℃伅
	 * @param params
	 * @param keys
	 */
	public static final void removeSensitiveInfo(Map<String, String> params, String... keys) {
		List<String> keyList = null;
		if (keys != null) {
			keyList = new ArrayList<String>(DEFAULT_SENSITIVE);
			keyList.addAll(Arrays.asList(keys));
		} else {
			keyList = DEFAULT_SENSITIVE;
		}

		for (String pname : new ArrayList<String>(params.keySet())) {
			int valueLen = StringUtils.length(params.get(pname));
			if (valueLen > 1000) {
				params.put(pname, StringUtils.substring(params.get(pname), 1000) + "->LEN:" + valueLen);
			}
			if (!IGNORE_KEYS.contains(pname)) {
				for (String key : keyList) {
					if (StringUtils.containsIgnoreCase(pname, key) && StringUtils.isNotBlank(params.get(pname))) {
						//瀵规晱鎰熶俊鎭繘琛屽姞瀵�
						params.put(pname, "MG" + StringUtil.md5("kcj3STidSC" + params.get(pname)));
					}
				}
			}
		}
	}

	public static final String getRemotePort(HttpServletRequest request) {// 鑾峰彇璇锋眰绔彛鍙�
		String port = request.getHeader("x-client-port");
		if (StringUtils.isBlank(port)) {
			return "" + request.getRemotePort();
		}
		return port;
	}
}
