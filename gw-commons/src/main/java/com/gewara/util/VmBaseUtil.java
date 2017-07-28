/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.commons.sign.Sign;
import com.gewara.util.BeanUtil;
import com.gewara.util.DateUtil;
import com.gewara.util.HtmlUtils;
import com.gewara.util.JsonUtils;
import com.gewara.util.StringUtil;
import com.gewara.util.Util4Script;
import com.gewara.util.ValidateUtil;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class VmBaseUtil extends StringUtils implements Util4Script {
	public static final VmBaseUtil instance = new VmBaseUtil();
	private static String jsVersion = DateUtil.format(new Date(), "yyyyMMddHH");
	private static final String TOKEN_CONSTANT = "he#%&#he";

	public static final void setJsVersion(String jv) {
		jsVersion = jv;
	}

	public static final String getJsVersion() {
		return jsVersion;
	}

	public static final String escapeHtml(String str) {
		return HtmlUtils.htmlEscape(str);
	}

	public static final String escabbr(String str, int length) {
		String result = StringUtil.enabbr(str, length);
		return HtmlUtils.htmlEscape(result);
	}

	public static final String htmlabbr(String html, int length) {
		return StringUtil.getEscapeText(html, length);
	}

	public static final String getText(String html) {
		return StringUtil.getEscapeText(html);
	}

	public static final String subLastText(String temp, String text) {
		return !StringUtils.isBlank(temp) && !StringUtils.isBlank(text)
				? StringUtils.substring(text, StringUtils.lastIndexOf(text, temp) + 1) : "";
	}

	public static final String getHtmlText(String html, int length) {
		return StringUtil.getHtmlText(html, length);
	}

	public static final String encodeStr(String str, String encoding) {
		try {
			if (StringUtils.isBlank(str)) {
				return str;
			} else {
				String result = URLEncoder.encode(str, encoding);
				return result;
			}
		} catch (UnsupportedEncodingException arg2) {
			return null;
		}
	}

	public static final String escbr(String str) {
		return StringUtils.replace(escapeHtml(str), "\n", "<br />");
	}

	public static final boolean isEmptyList(Object list) {
		return BeanUtil.isEmptyContainer(list);
	}

	public static final boolean isEmpObj(Object obj) {
		return obj == null ? true
				: (obj.getClass().isArray() ? Array.getLength(obj) == 0
						: (obj instanceof Collection ? ((Collection) obj).size() == 0
								: (obj instanceof Map ? ((Map) obj).size() == 0 : false)));
	}

	public static final boolean isNotEmpObj(Object obj) {
		return !isEmpObj(obj);
	}

	public static final Integer size(Object list) {
		return list == null ? Integer.valueOf(0)
				: (list.getClass().isArray() ? new Integer(Array.getLength(list))
						: (list instanceof Collection ? Integer.valueOf(((Collection) list).size())
								: (list instanceof Map ? Integer.valueOf(((Map) list).size()) : Integer.valueOf(0))));
	}

	public static final String printList(String[] list) {
		return StringUtils.join(list, ",");
	}

	public static final String printList(List<String> list) {
		return printList(list, ",");
	}

	public static final String printList(List<String> list, String separatorChars) {
		if (isEmptyList(list)) {
			return null;
		} else {
			String[] a = (String[]) list.toArray(new String[list.size()]);
			return StringUtils.join(a, separatorChars);
		}
	}

	public static final boolean isNull(Object obj) {
		return obj == null ? true : (obj instanceof String ? StringUtils.isBlank((String) obj) : false);
	}

	public static final boolean eq(Object obj1, Object obj2) {
		return obj1 == null ? obj2 == null
				: (obj2 == null ? false
						: (obj1.equals(obj2) ? true
								: (obj1.getClass().equals(obj2.getClass()) ? false
										: StringUtils.equals(obj1.toString(), obj2.toString()))));
	}

	public static final boolean gt(Object obj1, Object obj2) {
		if (obj1 == null && obj2 == null) {
			return true;
		} else if (obj2 == null) {
			return true;
		} else if (obj1 == null) {
			return false;
		} else if (obj1.getClass().equals(obj2.getClass())) {
			try {
				int e = ((Comparable) obj1).compareTo(obj2);
				return e > 0;
			} catch (Exception arg2) {
				return false;
			}
		} else {
			try {
				return Double.parseDouble("" + obj1) - Double.parseDouble("" + obj2) > 0.0D;
			} catch (Exception arg3) {
				return ("" + obj1).compareTo(obj2.toString()) > 0;
			}
		}
	}

	public static final Object dft(Object original, Object value) {
		return original == null ? value : (original instanceof String && isBlank("" + original) ? value : original);
	}

	public static final boolean contains(Object list, Object element) {
		return list == null ? false
				: (list.getClass().isArray() ? arrayContains(list, element)
						: (!(list instanceof Collection) ? false : ((Collection) list).contains(element)));
	}

	private static final boolean arrayContains(Object array, Object element) {
		int size = size(array).intValue();

		try {
			for (int e = 0; e < size; ++e) {
				if (eq(element, Array.get(array, e))) {
					return true;
				}
			}
		} catch (IndexOutOfBoundsException arg3) {
			return false;
		} catch (Exception arg4) {
			;
		}

		return false;
	}

	public static final boolean isAscii(String s) {
		if (s == null) {
			return true;
		} else {
			for (int i = 0; i < s.length(); ++i) {
				if (s.charAt(i) > 256) {
					return false;
				}
			}

			return true;
		}
	}

	public static final Object sw(Object value1, Object value2, Object current) {
		return current != null && !current.equals(value1) ? value1 : value2;
	}

	public static final String dft(String src, String dft) {
		return isBlank(src) ? dft : src;
	}

	public static final String dft2(String src, String result, String dft) {
		return isBlank(src) ? dft : (StringUtils.isBlank(result) ? src : result);
	}

	public static final int getByteLength(String input) {
		if (input == null) {
			return 0;
		} else {
			int length = input.length();
			int byteLength = length;

			for (int i = 0; i < length; ++i) {
				if (input.charAt(i) > 128) {
					++byteLength;
				}
			}

			return byteLength;
		}
	}

	public static final boolean isBlank(Object obj) {
		return obj == null ? true : StringUtils.isBlank(obj + "");
	}

	public static final String replaceName(String name, String replaceOldName, String repalceNewName) {
		return StringUtils.isNotBlank(name) && name.indexOf(replaceOldName) != -1
				? name.replace(replaceOldName, repalceNewName) : name;
	}

	public static final String formatPercent(Integer num1, Integer num2) {
		return formatPercent(num1, num2, "0.00%");
	}

	public static final String formatPercent(Integer num1, Integer num2, String format) {
		if (num1 != null && num2 != null && num2.intValue() != 0) {
			double div = (double) num1.intValue() / (double) num2.intValue();
			DecimalFormat myformat = (DecimalFormat) NumberFormat.getPercentInstance();
			myformat.applyPattern(format);
			return myformat.format(div);
		} else {
			return "?";
		}
	}

	public static final String formatPercent(Double num1, Double num2) {
		if (num1 != null && num2 != null && num2.doubleValue() != 0.0D) {
			String format = "0.00%";
			if ((double) num1.intValue() == num1.doubleValue() && (double) num2.intValue() == num2.doubleValue()) {
				format = "0%";
			}

			return formatPercent(num1, num2, format);
		} else {
			return "";
		}
	}

	public static final String formatPercent(Double num1, Double num2, String format) {
		if (num1 != null && num2 != null && num2.doubleValue() != 0.0D) {
			double div = num1.doubleValue() / num2.doubleValue();
			DecimalFormat myformat = (DecimalFormat) NumberFormat.getPercentInstance();
			myformat.applyPattern(format);
			return myformat.format(div);
		} else {
			return "";
		}
	}

	public static final String getJsonValueByKey(String json, String key) {
		return JsonUtils.getJsonValueByKey(json, key);
	}

	public static final String getSmobile(String mobile) {
		return !ValidateUtil.isMobile(mobile) ? "" : mobile.substring(0, 3) + "****" + mobile.substring(7, 11);
	}

	public static boolean isValidToken(String token) {
		if (!StringUtils.isBlank(token) && StringUtils.split(token, ":").length == 2) {
			String[] temp = token.split(":");

			try {
				Long e = Long.valueOf(temp[1]);
				if (e.longValue() < System.currentTimeMillis()) {
					return false;
				}
			} catch (Exception arg2) {
				return false;
			}

			return StringUtils.equals(Sign.md5("he#%&#he" + temp[1]), temp[0]);
		} else {
			return false;
		}
	}

	public static String getToken(int seconds) {
		Long curTimeMillis = Long.valueOf(System.currentTimeMillis() + (long) (seconds * 1000));
		return Sign.md5("he#%&#he" + curTimeMillis) + ":" + curTimeMillis;
	}
}