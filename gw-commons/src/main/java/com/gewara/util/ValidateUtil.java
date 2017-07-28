/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.support.ErrorCode;
import com.gewara.util.StringUtil;
import com.gewara.util.Util4Script;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

public class ValidateUtil implements Util4Script {
	private static Set<String> simplePass = new TreeSet();
	public static final List<String> ydMobile;
	public static final List<String> ltMobile;
	public static final List<String> dxMobile;
	private static char[] cncharRange;
	private static String spcharList;

	public static boolean isYdMobile(String mobile) {
		return ydMobile.contains(mobile.substring(0, 3));
	}

	public static boolean isEmail(String email) {
		return StringUtils.isBlank(email) ? false
				: StringUtil.regMatch(email, "^[A-Z0-9._-]+@[A-Z0-9_-]+(\\.[A-Z0-9_-]+)*(\\.[A-Z]{2,4})+$", true);
	}

	public static boolean isMobile(String mobile) {
		return StringUtils.isBlank(mobile) ? false : StringUtil.regMatch(mobile, "^1[34578]{1}\\d{9}$", true);
	}

	public static boolean isNumber(String number) {
		return StringUtils.isNotBlank(number) && StringUtils.isNumeric(number);
	}

	public static boolean isNumber(String number, int minLength, int maxLength) {
		return isNumber(number) && number.length() >= minLength && number.length() <= maxLength;
	}

	public static boolean isIDCard(String number) {
		return StringUtil.regMatch(number, "^(\\d{15}|\\d{17}[0-9xX]{1})$", false);
	}

	public static ErrorCode validatePassword(String pass1, String pass2) {
		return !StringUtils.isBlank(pass1) && !StringUtils.isBlank(pass2)
				? (!StringUtils.equals(pass1, pass2) ? ErrorCode.getFailure("两次输入的密码不一致!")
						: (!isPassword(pass1) ? ErrorCode.getFailure("密码格式不正确,只能是字母，数字，英文标点，长度6—14位！")
								: (isSimplePass(pass1) ? ErrorCode.getFailure("密码过于简单，请重新输入！") : ErrorCode.SUCCESS)))
				: ErrorCode.getFailure("密码必须!");
	}

	private static boolean isSimplePass(String plainPass) {
		if (StringUtils.isNumeric(plainPass)) {
			return true;
		} else {
			String md5 = StringUtil.md5(plainPass);
			return simplePass.contains(md5);
		}
	}

	public static boolean isVariable(String variable, int length1, int length2) {
		return StringUtils.isBlank(variable) ? false
				: StringUtil.regMatch(variable, "^\\w{" + length1 + "," + length2 + "}$", true);
	}

	public static boolean isCNVariable(String variable, int length1, int length2) {
      return StringUtils.isBlank(variable)?false:StringUtil.regMatch(variable, "^[\\w+$\一-\龥]{" + length1 + "," + length2 + "}$", true);
   }

	public static boolean isPhone(String phone) {
		return StringUtils.isBlank(phone) ? false : StringUtil.regMatch(phone, "^[0-9,-]{6,24}$", true);
	}

	public static boolean isPostCode(String postcode) {
		return StringUtil.regMatch(postcode, "^[0-9]{6}$", true);
	}

	public static String validateNewsContent(String spchar, String content) {
		if (StringUtils.isBlank(spchar)) {
			spchar = spcharList;
		}

		String result = "";
		if (StringUtils.isBlank(content)) {
			return result;
		} else {
			boolean c = true;
			int i = 0;

			for (int length = content.length(); i < length; ++i) {
				char arg5 = content.charAt(i);
				if (arg5 >= 128 && (arg5 < cncharRange[0] || arg5 > cncharRange[1]) && spchar.indexOf(arg5) < 0) {
					result = result + "[" + i + "=" + arg5 + "]";
				}
			}

			return result;
		}
	}

	public static boolean isPassword(String password) {
		int len = StringUtils.length(password);
		return StringUtils.isAsciiPrintable(password) && len >= 6 && len <= 14;
	}

	static {
		try {
			InputStream e = ValidateUtil.class.getClassLoader().getResourceAsStream("simplepass.txt");
			Throwable arg0 = null;

			try {
				List lines = IOUtils.readLines(e);
				simplePass.addAll(lines);
			} catch (Throwable arg10) {
				arg0 = arg10;
				throw arg10;
			} finally {
				if (e != null) {
					if (arg0 != null) {
						try {
							e.close();
						} catch (Throwable arg9) {
							arg0.addSuppressed(arg9);
						}
					} else {
						e.close();
					}
				}

			}
		} catch (Exception arg12) {
			arg12.printStackTrace();
		}

		ydMobile = Arrays.asList(new String[] { "139", "138", "137", "136", "135", "134", "147", "150", "151", "152",
				"157", "158", "159", "182", "183", "187", "188", "184", "178" });
		ltMobile = Arrays.asList(new String[] { "130", "131", "132", "155", "156", "185", "186", "176", "145" });
		dxMobile = Arrays.asList(new String[] { "133", "153", "177", "180", "181", "189" });
		cncharRange = new char[] { '一', '龥' };
		spcharList = "～！￥…（）——：“《》？/，、；‘’“”【】·。★☆○●◎◇◆□■△▲※→←↑↓";
	}
}