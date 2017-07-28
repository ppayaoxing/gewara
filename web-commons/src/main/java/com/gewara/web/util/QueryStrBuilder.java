/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class QueryStrBuilder {
	private String encode = "utf-8";
	private String queryStr = "";

	public void buildQueryStr(Map<String, String[]> params, String[] paramNames) {
		ArrayList keyList = new ArrayList();
		if (params != null) {
			if (paramNames == null) {
				keyList.addAll(params.keySet());
			} else {
				keyList.addAll(Arrays.asList(paramNames));
			}

			Collections.sort(keyList);
			Iterator arg3 = keyList.iterator();

			while (true) {
				while (true) {
					String key;
					Object values;
					do {
						if (!arg3.hasNext()) {
							return;
						}

						key = (String) arg3.next();
						values = params.get(key);
					} while (values == null);

					if (values instanceof String[]) {
						String[] arg6 = (String[]) ((String[]) values);
						int arg7 = arg6.length;

						for (int arg8 = 0; arg8 < arg7; ++arg8) {
							String value = arg6[arg8];
							if (StringUtils.isNotBlank(value)) {
								try {
									this.queryStr = this.queryStr + "&" + key + "="
											+ URLEncoder.encode(value, this.encode);
								} catch (UnsupportedEncodingException arg12) {
									;
								}
							}
						}
					} else {
						try {
							this.queryStr = this.queryStr + "&" + key + "="
									+ URLEncoder.encode("" + values, this.encode);
						} catch (UnsupportedEncodingException arg11) {
							;
						}
					}
				}
			}
		}
	}

	public void buildQueryStr(Map<String, String[]> params) {
		this.buildQueryStr(params, (String[]) null);
	}

	public String getQueryStr(String fieldname, Object fieldvalue) {
		String value = "";

		try {
			if (fieldvalue != null) {
				value = URLEncoder.encode(fieldvalue.toString(), this.encode);
			}
		} catch (UnsupportedEncodingException arg6) {
			;
		}

		String result = this.queryStr;
		int idx1 = StringUtils.indexOf(result, "&" + fieldname + "=");
		if (idx1 >= 0) {
			int idx2 = StringUtils.indexOf(result, '&', idx1 + 1);
			if (idx2 == -1) {
				idx2 = result.length();
			}

			result = result.substring(0, idx1 + 1) + fieldname + "=" + value + result.substring(idx2);
		} else if (StringUtils.isNotBlank(value)) {
			result = result + "&" + fieldname + "=" + value;
		}

		return result.substring(1);
	}
}