/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.support.TraceErrorException;
import com.gewara.util.HtmlParser;
import com.gewara.util.HtmlUtils;
import com.gewara.util.Util4Script;
import java.io.UnsupportedEncodingException;
import java.rmi.server.UID;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;

public class StringUtil implements Util4Script {
	public static final String upper = "ABCDEFGHJKLMNPQRSTUVWXYZ";
	public static final String lower = "abcdefghijkmnpqrstuvwxyz";
	public static final String digital = "23456789";

	public static String md5(byte[] input) {
		return encryptPassword(input, "md5");
	}

	public static String md5(String text) {
		return md5(text, "utf-8");
	}

	public static String md5(String text, String encoding) {
		return encryptPassword(text, encoding, "md5");
	}

	public static String md5(String text, int length) {
		String result = md5(text);
		if (result.length() > length) {
			result = result.substring(0, length);
		}

		return result;
	}

	public static String sha(String text, String encoding) {
		return encryptPassword(text, encoding, "sha");
	}

	private static String encryptPassword(String password, String encoding, String algorithm) {
		try {
			byte[] e = password.getBytes(encoding);
			return encryptPassword(e, algorithm);
		} catch (UnsupportedEncodingException arg3) {
			return null;
		}
	}

	private static String encryptPassword(byte[] unencodedPassword, String algorithm) {
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance(algorithm);
		} catch (Exception arg5) {
			return null;
		}

		md.reset();
		md.update(unencodedPassword);
		byte[] encodedPassword = md.digest();
		StringBuilder buf = new StringBuilder();

		for (int i = 0; i < encodedPassword.length; ++i) {
			if ((encodedPassword[i] & 255) < 16) {
				buf.append("0");
			}

			buf.append(Long.toString((long) (encodedPassword[i] & 255), 16));
		}

		return buf.toString();
	}

	public static String getUID() {
		String UID = (new UID()).toString().replace(':', '_').replace('-', '_');
		return "s" + UID;
	}

	public static String enabbr(String input, int size) {
		if (StringUtils.isBlank(input)) {
			return null;
		} else {
			int bytelength = getByteLength(input);
			if (bytelength < size) {
				return input;
			} else {
				StringBuilder sb = new StringBuilder(size);
				int count = 0;

				for (int i = 0; i < input.length(); ++i) {
					char c = input.charAt(i);
					sb.append(c);
					if (c > 128) {
						count += 2;
					} else {
						++count;
					}

					if (count >= size) {
						break;
					}
				}

				return sb.toString();
			}
		}
	}

	public static String enabbrstr(String input, int size, String addStr) {
		if (StringUtils.isBlank(input)) {
			return null;
		} else {
			int bytelength = getByteLength(input);
			if (bytelength < size) {
				return input;
			} else {
				String ss = enabbr(input, size);
				return ss + addStr;
			}
		}
	}

	public static int getByteLength(String input) {
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

	public static String getHtmlText(String html) {
		return HtmlParser.getHtmlText(html);
	}

	public static String getHtmlText(String html, int length) {
		String result = HtmlParser.getHtmlText(html);
		return enabbr(result, length);
	}

	public static String getEscapeText(String html) {
		String result = HtmlParser.getHtmlText(html);
		return HtmlUtils.htmlEscape(result);
	}

	public static String getEscapeText(String html, int length) {
		String result = HtmlParser.getHtmlText(html);
		result = HtmlUtils.htmlEscape(enabbr(result, length));
		return result;
	}

	public static String toUnicode(String original) {
		if (original == null) {
			return null;
		} else {
			String result = "";
			int i = 0;

			for (int length = original.length(); i < length; ++i) {
				if (original.charAt(i) > 0 && original.charAt(i) < 256) {
					result = result + original.charAt(i);
				} else {
					result = result + "\\u" + Integer.toHexString(original.charAt(i)).toUpperCase();
				}
			}

			return result;
		}
	}

	public static String getRandomString(int length) {
		return getRandomString(length, true, true, true);
	}

	public static String getUpperRandomString(int length) {
		return getRandomString(length, true, false, false);
	}

	public static String getLowerRandomString(int length) {
		return getRandomString(length, false, true, false);
	}

	public static String getDigitalRandomString(int length) {
		return getRandomString(length, false, false, true);
	}

	public static String getRandomString(int length, boolean includeUpper, boolean includeLower,
			boolean includeDigital) {
		if (length > 100) {
			length = 100;
		}

		String s = "";
		if (includeUpper) {
			s = s + "ABCDEFGHJKLMNPQRSTUVWXYZ";
		}

		if (includeLower) {
			s = s + "abcdefghijkmnpqrstuvwxyz";
		}

		if (includeDigital) {
			s = s + "23456789";
		}

		if (length > 100) {
			throw new TraceErrorException("生成的字符串长度必须<100！");
		} else {
			return getRandomString(s, length);
		}
	}

	public static String getRandomString(String charArray, int length) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; ++i) {
			sb.append(charArray.charAt(RandomUtils.nextInt(charArray.length())));
		}

		return sb.toString();
	}

	public static String getSearchKey(String qryStr) {
      if(StringUtils.isBlank(qryStr)) {
         return "";
      } else {
         String result = substitute(qryStr, "[^ \\w$\\n]+", "", true); //TODO 正则有问题,待修复
         result = result.replaceAll("AND", "and").replaceAll("OR", "or").replaceAll("NOT", "not");
         return result.trim();
      }
   }

	public static String md5WithKey(String str) {
		return md5(str + "7fuTP5", "utf-8");
	}

	public static String md5WithKey(String str, int length) {
		String result = md5WithKey(str);
		return result.length() > length ? result.substring(0, length) : result;
	}

	public static boolean between(String str, String minstr, String maxstr) {
		return str.compareTo(minstr) >= 0 && str.compareTo(maxstr) <= 0;
	}

	public static String parse2HTML(String txt) {
		String reg = "(http://(([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?))";
		return StringUtils.isBlank(txt) ? ""
				: txt.replaceAll(" ", "&nbsp;").replaceAll("\n", "<br />").replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;")
						.replaceAll(reg, "<a href=\'$1\' target=\'_blank\'>$2</a>");
	}

	public static String getFilename(String path) {
		if (path == null) {
			return null;
		} else {
			int separatorIndex = path.lastIndexOf(47);
			if (separatorIndex == -1) {
				separatorIndex = path.lastIndexOf(92);
			}

			return separatorIndex != -1 ? path.substring(separatorIndex + 1) : path;
		}
	}

	public static String getFilepath(String path) {
		if (path == null) {
			return null;
		} else {
			int separatorIndex = path.lastIndexOf(47);
			if (separatorIndex == -1) {
				separatorIndex = path.lastIndexOf(92);
			}

			return separatorIndex != -1 ? path.substring(0, separatorIndex) : "";
		}
	}

	public static String getFilenameExtension(String path) {
		if (path == null) {
			return null;
		} else {
			int sepIndex = path.lastIndexOf(46);
			return sepIndex != -1 ? path.substring(sepIndex + 1) : null;
		}
	}

	public static String getSplitString(String str, String split, int length) {
		int splen = split.length();
		StringBuilder sb = new StringBuilder(str);

		for (int start = length; start < sb.length() - 1; start += length + splen) {
			sb.insert(start, split);
		}

		return sb.toString();
	}

	public static String insertStr(String src, String insert) {
		if (StringUtils.isBlank(src)) {
			return "";
		} else if (StringUtils.isBlank(insert)) {
			return src;
		} else {
			String result = "";
			char[] arg2 = src.toCharArray();
			int arg3 = arg2.length;

			for (int arg4 = 0; arg4 < arg3; ++arg4) {
				char c = arg2[arg4];
				result = result + c + insert;
			}

			result = result.substring(0, result.length() - insert.length());
			return result;
		}
	}

	public static Set getRandomNumber(int max, int count) {
		TreeSet v = new TreeSet();
		Random r = new Random();
		boolean b = true;

		while (b) {
			v.add(Integer.valueOf(r.nextInt(max)));
			if (v.size() == count) {
				b = false;
			}
		}

		return v;
	}

	public static List<String> findByRegex(String src, String reg, boolean unique) {
		ArrayList result = new ArrayList();
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(src);

		while (true) {
			String s;
			do {
				if (!matcher.find()) {
					return result;
				}

				s = matcher.group();
			} while (unique && result.contains(s));

			result.add(s);
		}
	}

	public static String findFirstByRegex(String src, String reg) {
		Pattern pattern = Pattern.compile(reg, 2);
		Matcher matcher = pattern.matcher(src);
		return matcher.find() ? matcher.group() : "";
	}

	public static String substitute(String src, String reg, String replacement, boolean ignoreCase) {
		Pattern pattern = null;
		if (ignoreCase) {
			pattern = Pattern.compile(reg, 2);
		} else {
			pattern = Pattern.compile(reg);
		}

		Matcher matcher = pattern.matcher(src);
		String result = matcher.replaceAll(replacement);
		return result;
	}

	public static boolean regMatch(String src, String reg, boolean ignoreCase) {
		Pattern pattern = null;
		if (ignoreCase) {
			pattern = Pattern.compile(reg, 2);
		} else {
			pattern = Pattern.compile(reg);
		}

		Matcher matcher = pattern.matcher(src);
		return matcher.find();
	}

	public static String ToDBC(String input) {
		char[] c = input.toCharArray();

		for (int i = 0; i < c.length; ++i) {
			if (c[i] == 12288) {
				c[i] = 32;
			} else if (c[i] > '＀' && c[i] < '｟') {
				c[i] -= 'ﻠ';
			}
		}

		return new String(c);
	}

	public static String getString(byte[] bytes, String charset) {
		try {
			return new String(bytes, charset);
		} catch (UnsupportedEncodingException arg2) {
			return null;
		}
	}

	public static boolean isHexDataStr(String str) {
		if (!StringUtils.isBlank(str) && StringUtils.length(str) % 2 != 1) {
			for (int i = 0; i < str.length(); ++i) {
				char c = str.charAt(i);
				if ((c < 48 || c > 57) && (c < 97 || c > 102) && (c < 65 || c > 70)) {
					return false;
				}
			}

			return true;
		} else {
			return false;
		}
	}
}