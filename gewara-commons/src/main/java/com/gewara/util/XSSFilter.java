/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.BCConvert;
import com.gewara.util.BeanUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ArrayUtils;

public class XSSFilter {
	protected static final boolean ALWAYS_MAKE_TAGS = true;
	protected static final boolean STRIP_COMMENTS = true;
	protected static final int REGEX_FLAGS_SI = 34;
	protected Map<String, List<String>> vAllowed;
	protected Map<String, Integer> vTagCounts;
	protected String[] vSelfClosingTags;
	protected String[] vNeedClosingTags;
	protected String[] vProtocolAtts;
	protected String[] vAllowedProtocols;
	protected String[] vRemoveBlanks;
	protected String[] vAllowedEntities;
	protected boolean vDebug;
	public static String regExp = "";

	public XSSFilter() {
		this(false);
	}

	public XSSFilter(boolean debug) {
		this.vDebug = debug;
		this.vAllowed = new HashMap();
		this.vTagCounts = new HashMap();
		ArrayList no_atts = new ArrayList();
		this.vAllowed.put("b", no_atts);
		this.vAllowed.put("strong", no_atts);
		this.vAllowed.put("i", no_atts);
		this.vAllowed.put("em", no_atts);
		this.vSelfClosingTags = new String[] { "img" };
		this.vNeedClosingTags = new String[] { "a", "b", "strong", "i", "em" };
		this.vAllowedProtocols = new String[] { "http", "mailto" };
		this.vProtocolAtts = new String[] { "src", "href" };
		this.vRemoveBlanks = new String[] { "a", "b", "strong", "i", "em" };
		this.vAllowedEntities = new String[] { "amp", "gt", "lt", "quot" };
	}

	protected void reset() {
		this.vTagCounts = new HashMap();
	}

	protected void debug(String msg) {
		if (this.vDebug) {
			System.out.println(msg);
		}

	}

	public static String chr(int decimal) {
		return String.valueOf((char) decimal);
	}

	public static String htmlSpecialChars(String s) {
		s = s.replaceAll("&", "&amp;");
		s = s.replaceAll("\"", "&quot;");
		s = s.replaceAll("<", "&lt;");
		s = s.replaceAll(">", "&gt;");
		return s;
	}

	public synchronized String filter(String input) {
		if (input == null) {
			return input;
		} else {
			this.reset();
			this.debug("************************************************");
			this.debug("              INPUT: " + input);
			String s = this.escapeComments(input);
			this.debug("     escapeComments: " + s);
			s = this.balanceHTML(s);
			this.debug("        balanceHTML: " + s);
			s = this.checkTags(s);
			this.debug("          checkTags: " + s);
			s = this.processRemoveBlanks(s);
			this.debug("processRemoveBlanks: " + s);
			s = this.validateEntities(s);
			this.debug("    validateEntites: " + s);
			this.debug("************************************************\n\n");
			return s;
		}
	}

	protected String escapeComments(String s) {
		Pattern p = Pattern.compile("<!--(.*?)-->", 32);
		Matcher m = p.matcher(s);
		StringBuffer buf = new StringBuffer();
		if (m.find()) {
			String match = m.group(1);
			m.appendReplacement(buf, "<!--" + htmlSpecialChars(match) + "-->");
		}

		m.appendTail(buf);
		return buf.toString();
	}

	protected String balanceHTML(String s) {
		s = this.regexReplace("^>", "", s);
		s = this.regexReplace("<([^>]*?)(?=<|$)", "<$1>", s);
		s = this.regexReplace("(^|>)([^<]*?)(?=>)", "$1<$2", s);
		return s;
	}

	protected String checkTags(String s) {
		Pattern p = Pattern.compile("<(.*?)>", 32);
		Matcher m = p.matcher(s);
		StringBuffer buf = new StringBuffer();

		while (m.find()) {
			String replaceStr = m.group(1);
			replaceStr = this.processTag(replaceStr);
			m.appendReplacement(buf, replaceStr);
		}

		m.appendTail(buf);
		s = buf.toString();
		Iterator arg7 = this.vTagCounts.keySet().iterator();

		while (arg7.hasNext()) {
			String key = (String) arg7.next();

			for (int ii = 0; ii < ((Integer) this.vTagCounts.get(key)).intValue(); ++ii) {
				s = s + "</" + key + ">";
			}
		}

		return s;
	}

	protected String processRemoveBlanks(String s) {
		String[] arg1 = this.vRemoveBlanks;
		int arg2 = arg1.length;

		for (int arg3 = 0; arg3 < arg2; ++arg3) {
			String tag = arg1[arg3];
			s = this.regexReplace("<" + tag + "(\\s[^>]*)?></" + tag + ">", "", s);
			s = this.regexReplace("<" + tag + "(\\s[^>]*)?/>", "", s);
		}

		return s;
	}

	protected String regexReplace(String regex_pattern, String replacement, String s) {
		Pattern p = Pattern.compile(regex_pattern);
		Matcher m = p.matcher(s);
		return m.replaceAll(replacement);
	}

	protected String processTag(String s) {
		Pattern p = Pattern.compile("^/([a-z0-9]+)", 34);
		Matcher m = p.matcher(s);
		String comment;
		if (m.find()) {
			comment = m.group(1).toLowerCase();
			if (this.vAllowed.containsKey(comment) && !this.inArray(comment, this.vSelfClosingTags)
					&& this.vTagCounts.containsKey(comment)) {
				this.vTagCounts.put(comment, Integer.valueOf(((Integer) this.vTagCounts.get(comment)).intValue() - 1));
				return "</" + comment + ">";
			}
		}

		p = Pattern.compile("^([a-z0-9]+)(.*?)(/?)$", 34);
		m = p.matcher(s);
		if (!m.find()) {
			p = Pattern.compile("^!--(.*)--$", 34);
			m = p.matcher(s);
			if (m.find()) {
				comment = m.group();
				return "";
			} else {
				return "";
			}
		} else {
			comment = m.group(1).toLowerCase();
			String body = m.group(2);
			String ending = m.group(3);
			if (!this.vAllowed.containsKey(comment)) {
				return "";
			} else {
				String params = "";
				Pattern p2 = Pattern.compile("([a-z0-9]+)=([\"\'])(.*?)\\2", 34);
				Pattern p3 = Pattern.compile("([a-z0-9]+)(=)([^\"\\s\']+)", 34);
				Matcher m2 = p2.matcher(body);
				Matcher m3 = p3.matcher(body);
				ArrayList paramNames = new ArrayList();
				ArrayList paramValues = new ArrayList();

				while (m2.find()) {
					paramNames.add(m2.group(1));
					paramValues.add(m2.group(3));
				}

				while (m3.find()) {
					paramNames.add(m3.group(1));
					paramValues.add(m3.group(3));
				}

				for (int ii = 0; ii < paramNames.size(); ++ii) {
					String paramName = ((String) paramNames.get(ii)).toLowerCase();
					String paramValue = (String) paramValues.get(ii);
					if (((List) this.vAllowed.get(comment)).contains(paramName)) {
						if (this.inArray(paramName, this.vProtocolAtts)) {
							paramValue = this.processParamProtocol(paramValue);
						}

						params = params + " " + paramName + "=\"" + paramValue + "\"";
					}
				}

				if (this.inArray(comment, this.vSelfClosingTags)) {
					ending = " /";
				}

				if (this.inArray(comment, this.vNeedClosingTags)) {
					ending = "";
				}

				if (ending != null && ending.length() >= 1) {
					ending = " /";
				} else if (this.vTagCounts.containsKey(comment)) {
					this.vTagCounts.put(comment,
							Integer.valueOf(((Integer) this.vTagCounts.get(comment)).intValue() + 1));
				} else {
					this.vTagCounts.put(comment, Integer.valueOf(1));
				}

				return "<" + comment + params + ending + ">";
			}
		}
	}

	protected String processParamProtocol(String s) {
		s = this.decodeEntities(s);
		Pattern p = Pattern.compile("^([^:]+):", 34);
		Matcher m = p.matcher(s);
		if (m.find()) {
			String protocol = m.group(1);
			if (!this.inArray(protocol, this.vAllowedProtocols)) {
				s = "#" + s.substring(protocol.length() + 1, s.length());
				if (s.startsWith("#//")) {
					s = "#" + s.substring(3, s.length());
				}
			}
		}

		return s;
	}

	protected String decodeEntities(String s) {
		StringBuffer buf = new StringBuffer();
		Pattern p = Pattern.compile("&#(\\d+);?");
		Matcher m = p.matcher(s);

		String match;
		int decimal;
		while (m.find()) {
			match = m.group(1);
			decimal = Integer.decode(match).intValue();
			m.appendReplacement(buf, chr(decimal));
		}

		m.appendTail(buf);
		s = buf.toString();
		buf = new StringBuffer();
		p = Pattern.compile("&#x([0-9a-f]+);?");
		m = p.matcher(s);

		while (m.find()) {
			match = m.group(1);
			decimal = Integer.decode(match).intValue();
			m.appendReplacement(buf, chr(decimal));
		}

		m.appendTail(buf);
		s = buf.toString();
		buf = new StringBuffer();
		p = Pattern.compile("%([0-9a-f]{2});?");
		m = p.matcher(s);

		while (m.find()) {
			match = m.group(1);
			decimal = Integer.decode(match).intValue();
			m.appendReplacement(buf, chr(decimal));
		}

		m.appendTail(buf);
		s = buf.toString();
		s = this.validateEntities(s);
		return s;
	}

	protected String validateEntities(String s) {
		Pattern p = Pattern.compile("&([^&;]*)(?=(;|&|$))");
		Matcher m = p.matcher(s);
		String one;
		if (m.find()) {
			String buf = m.group(1);
			one = m.group(2);
			s = this.checkEntity(buf, one);
		}

		p = Pattern.compile("(>|^)([^<]+?)(<|$)", 32);
		m = p.matcher(s);
		StringBuffer buf1 = new StringBuffer();
		if (m.find()) {
			one = m.group(1);
			String two = m.group(2);
			String three = m.group(3);
			m.appendReplacement(buf1, one + two.replaceAll("\"", "&quot;") + three);
		}

		m.appendTail(buf1);
		return s;
	}

	protected String checkEntity(String preamble, String term) {
		return !term.equals(";") ? "&amp;" + preamble
				: (this.isValidEntity(preamble) ? "&" + preamble : "&amp;" + preamble);
	}

	protected boolean isValidEntity(String entity) {
		return this.inArray(entity, this.vAllowedEntities);
	}

	private boolean inArray(String s, String[] array) {
		String[] arg2 = array;
		int arg3 = array.length;

		for (int arg4 = 0; arg4 < arg3; ++arg4) {
			String item = arg2[arg4];
			if (item != null && item.equals(s)) {
				return true;
			}
		}

		return false;
	}

	public static String filterSpecStr(String str) {
		str = BCConvert.SBC2DBC(str);
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	public static <T> T filterObjAttrs(T entity, String... attrs) {
		if (ArrayUtils.isEmpty(attrs)) {
			return entity;
		} else {
			XSSFilter filter = new XSSFilter();

			try {
				Map result = PropertyUtils.describe(entity);
				Iterator arg3 = result.keySet().iterator();

				while (arg3.hasNext()) {
					Object key = arg3.next();
					if (result.get(key) instanceof String && ArrayUtils.contains(attrs, String.valueOf(key))) {
						String cleanString = filter.filter(String.valueOf(result.get(key)));
						result.put(key, cleanString);
					}
				}

				BeanUtil.copyProperties(entity, result);
			} catch (Exception arg6) {
				;
			}

			return entity;
		}
	}

	public static String filterAttr(String attr) {
		return (new XSSFilter()).filter(attr);
	}
}