/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import com.gewara.util.ValidateUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

public class MobileAreaUtil {
	private static Map<String, String> mobileAreaMap = new HashMap();
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(MobileAreaUtil.class);

	private static void init() {
		try {
			BufferedReader e = new BufferedReader(new InputStreamReader(
					MobileAreaUtil.class.getClassLoader().getResourceAsStream("mobile_area.txt"), "utf-8"));
			List lines = IOUtils.readLines(e);
			Iterator arg1 = lines.iterator();

			while (arg1.hasNext()) {
				String line = (String) arg1.next();
				String[] tmp = StringUtils.split(line, "\t");
				mobileAreaMap.put(tmp[0], tmp[1] + "," + tmp[2]);
			}
		} catch (Exception arg4) {
			dbLogger.warn("MobileAreaUtil init error:" + arg4.getMessage());
		}

		dbLogger.warn("MobileAreaUtil init size:" + mobileAreaMap.size());
	}

	public static String getMobileCitycode(String mobile) {
		if (!ValidateUtil.isMobile(mobile)) {
			return "";
		} else {
			String smobile = mobile.substring(0, 7);
			String res = (String) mobileAreaMap.get(smobile);
			if (StringUtils.isBlank(res)) {
				dbLogger.warn("unfind mobile area:" + mobile);
				return "";
			} else {
				return StringUtils.split(res, ",")[0];
			}
		}
	}

	public static String getMobileProcode(String mobile) {
		if (!ValidateUtil.isMobile(mobile)) {
			return "";
		} else {
			String smobile = mobile.substring(0, 7);
			String res = (String) mobileAreaMap.get(smobile);
			if (StringUtils.isBlank(res)) {
				dbLogger.warn("unfind mobile area:" + mobile);
				return "";
			} else {
				return StringUtils.split(res, ",")[1];
			}
		}
	}

	static {
		init();
	}
}