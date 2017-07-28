/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.commons.sign;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

public class Sign {
	public static String md5Hex(String text, String inputCharset) {
		return DigestUtils.md5Hex(getContentBytes(text, inputCharset));
	}

	private static byte[] getContentBytes(String content, String charset) {
		if (charset != null && !"".equals(charset)) {
			try {
				return content.getBytes(charset);
			} catch (UnsupportedEncodingException arg2) {
				throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
			}
		} else {
			return content.getBytes();
		}
	}

	public static String md5(String srcStr) {
		return DigestUtils.md5Hex(srcStr).toUpperCase();
	}

	public static String signMD5(Map<String, String> params, String secretCode) {
		if (params != null && !params.isEmpty()) {
			if (params instanceof TreeMap) {
				return signMD5Inner((TreeMap) params, secretCode);
			} else {
				TreeMap treeMap = new TreeMap();
				treeMap.putAll(params);
				return signMD5Inner(treeMap, secretCode);
			}
		} else {
			return "";
		}
	}

	private static String signMD5Inner(TreeMap<String, String> param, String secretCode) {
		return DigestUtils.md5Hex(signStr(param, secretCode, false)).toUpperCase();
	}

	public static String signStr(TreeMap<String, String> param, String secretCode, boolean startAppend) {
		StringBuilder orgin = new StringBuilder();
		String value = "";
		Iterator arg4 = param.keySet().iterator();

		while (arg4.hasNext()) {
			String name = (String) arg4.next();
			if (!StringUtils.equalsIgnoreCase(name, "sign") && !StringUtils.equalsIgnoreCase(name, "signmethod")) {
				value = (String) param.get(name);
				if (StringUtils.isEmpty(value)) {
					value = "";
				}

				orgin.append(name).append("=").append(value).append("&");
			}
		}

		if (startAppend) {
			return secretCode + StringUtils.substringBeforeLast(orgin.toString(), "&");
		} else {
			return StringUtils.substringBeforeLast(orgin.toString(), "&") + secretCode;
		}
	}
}