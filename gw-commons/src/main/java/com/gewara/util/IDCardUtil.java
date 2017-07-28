/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.collections.map.UnmodifiableMap;

public abstract class IDCardUtil {
	private static final String[] ValCodeArr = new String[] { "1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2" };
	private static final String[] Wi = new String[] { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10",
			"5", "8", "4", "2" };
	private static final Map<String, String> AREACODEMAP;

	public static String IDCardValidate(String IDStr) {
		String errorInfo = "";
		String Ai = "";
		if (IDStr.length() != 15 && IDStr.length() != 18) {
			errorInfo = "身份证号码长度应该为15位或18位。";
			return errorInfo;
		} else {
			if (IDStr.length() == 18) {
				Ai = IDStr.substring(0, 17);
			} else if (IDStr.length() == 15) {
				Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
			}

			if (!isNumeric(Ai)) {
				errorInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
				return errorInfo;
			} else {
				String strYear = Ai.substring(6, 10);
				String strMonth = Ai.substring(10, 12);
				String strDay = Ai.substring(12, 14);
				if (!isDate(strYear + "-" + strMonth + "-" + strDay)) {
					errorInfo = "身份证生日无效。";
					return errorInfo;
				} else {
					GregorianCalendar gc = new GregorianCalendar();
					SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");

					try {
						if (gc.get(1) - Integer.parseInt(strYear) > 150 || gc.getTime().getTime()
								- s.parse(strYear + "-" + strMonth + "-" + strDay).getTime() < 0L) {
							errorInfo = "身份证生日不在有效范围。";
							return errorInfo;
						}
					} catch (NumberFormatException arg11) {
						errorInfo = "身份证生日不在有效范围。";
						return errorInfo;
					} catch (ParseException arg12) {
						errorInfo = "身份证生日不在有效范围。";
						return errorInfo;
					}

					if (Integer.parseInt(strMonth) <= 12 && Integer.parseInt(strMonth) != 0) {
						if (Integer.parseInt(strDay) <= 31 && Integer.parseInt(strDay) != 0) {
							Map h = AREACODEMAP;
							if (h.get(Ai.substring(0, 2)) == null) {
								errorInfo = "身份证地区编码错误。";
								return errorInfo;
							} else {
								int TotalmulAiWi = 0;

								int modValue;
								for (modValue = 0; modValue < 17; ++modValue) {
									TotalmulAiWi += Integer.parseInt(String.valueOf(Ai.charAt(modValue)))
											* Integer.parseInt(Wi[modValue]);
								}

								modValue = TotalmulAiWi % 11;
								String strVerifyCode = ValCodeArr[modValue];
								Ai = Ai + strVerifyCode;
								if (IDStr.length() == 18) {
									if (!Ai.equals(IDStr)) {
										errorInfo = "身份证无效，不是合法的身份证号码";
										return errorInfo;
									} else {
										return "";
									}
								} else {
									return "";
								}
							}
						} else {
							errorInfo = "身份证日期无效";
							return errorInfo;
						}
					} else {
						errorInfo = "身份证月份无效";
						return errorInfo;
					}
				}
			}
		}
	}

	private static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		return isNum.matches();
	}

	public static boolean isDate(String strDate) {
		Pattern pattern = Pattern.compile(
				"^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
		Matcher m = pattern.matcher(strDate);
		return m.matches();
	}

	static {
		Hashtable areacodeTmp = new Hashtable();
		areacodeTmp.put("11", "北京");
		areacodeTmp.put("12", "天津");
		areacodeTmp.put("13", "河北");
		areacodeTmp.put("14", "山西");
		areacodeTmp.put("15", "内蒙古");
		areacodeTmp.put("21", "辽宁");
		areacodeTmp.put("22", "吉林");
		areacodeTmp.put("23", "黑龙江");
		areacodeTmp.put("31", "上海");
		areacodeTmp.put("32", "江苏");
		areacodeTmp.put("33", "浙江");
		areacodeTmp.put("34", "安徽");
		areacodeTmp.put("35", "福建");
		areacodeTmp.put("36", "江西");
		areacodeTmp.put("37", "山东");
		areacodeTmp.put("41", "河南");
		areacodeTmp.put("42", "湖北");
		areacodeTmp.put("43", "湖南");
		areacodeTmp.put("44", "广东");
		areacodeTmp.put("45", "广西");
		areacodeTmp.put("46", "海南");
		areacodeTmp.put("50", "重庆");
		areacodeTmp.put("51", "四川");
		areacodeTmp.put("52", "贵州");
		areacodeTmp.put("53", "云南");
		areacodeTmp.put("54", "西藏");
		areacodeTmp.put("61", "陕西");
		areacodeTmp.put("62", "甘肃");
		areacodeTmp.put("63", "青海");
		areacodeTmp.put("64", "宁夏");
		areacodeTmp.put("65", "新疆");
		areacodeTmp.put("71", "台湾");
		areacodeTmp.put("81", "香港");
		areacodeTmp.put("82", "澳门");
		areacodeTmp.put("91", "国外");
		AREACODEMAP = UnmodifiableMap.decorate(areacodeTmp);
	}
}