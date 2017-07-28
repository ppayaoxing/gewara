/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

public abstract class DataCollectUtil {
	protected static final transient GewaLogger dbLogger = WebLogger.getLogger(DataCollectUtil.class);
	private static final String LD_REG_KEY = "_LD_REG_KEY";

	public static void addLeiDaCookie(String url, HttpServletRequest request, HttpServletResponse response) {
		String oldValue = BaseWebUtils.getCookieValue(request, "_LD_REG_KEY");
		String[] split = null;
		if (StringUtils.isNotBlank(oldValue)) {
			try {
				oldValue = new String(Base64.decodeBase64(oldValue), "UTF-8");
				split = oldValue.split("@");
				split[1] = split[0];
				split[0] = url;
			} catch (Exception arg7) {
				dbLogger.error(url + ":" + oldValue, arg7);
			}
		} else {
			split = new String[]{url, url};
		}

		String newCookie = StringUtils.join(split, "@");

		try {
			newCookie = Base64.encodeBase64URLSafeString(newCookie.getBytes("UTF-8"));
		} catch (Exception arg6) {
			dbLogger.error("" + newCookie, arg6);
		}

		BaseWebUtils.addCookie(response, "_LD_REG_KEY", newCookie, "/", 30000);
	}

	public static String getLeiDaCookie(HttpServletRequest request) {
		String value = BaseWebUtils.getCookieValue(request, "_LD_REG_KEY");
		if (StringUtils.isNotBlank(value)) {
			try {
				value = new String(Base64.decodeBase64(value), "UTF-8");
				if (StringUtils.contains(value, "@")) {
					return value;
				}
			} catch (Exception arg2) {
				dbLogger.error("" + value, arg2);
			}
		}

		return "";
	}
}