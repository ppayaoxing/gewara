/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.constant;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.map.UnmodifiableMap;
import org.apache.commons.lang.StringUtils;

public class FilmFestConstant {
	public static final String MPITYPE_FILMFEST = "filmfest";
	public static final String CODE_BEIJING5 = "beijing5";
	public static final String CODE_BEIJING5_RQZX = "beijing5_rqzx";
	public static final String CODE_BEIJING5_DINGZHI = "beijing5_dingzhi";
	public static final String CODE_BEIJING5_JSDY = "beijing5_jsdy";
	public static final String MPITYPE_FILMFEST5 = "filmfest";
	public static final String CODE_BEIJING6 = "beijing6";
	public static final String CODE_BEIJING6_RQZX = "beijing6_rqzx";
	public static final String CODE_BEIJING6_DINGZHI = "beijing6_dingzhi";
	public static final String CODE_BEIJING6_JSDY = "beijing6_jsdy";
	public static final String MPITYPE_FILMFEST6 = "filmfest";
	public static final String TAG_FILMFEST_16 = "16film";
	public static final String TAG_FILMFEST_17 = "17film";
	public static final String GEWARA_FILMFEST = "gewara_filmfest_";
	public static final String MESSAGES_EN = "en";
	public static final String MESSAGES_ZH = "ZH";
	public static final String MESSAGE_CODE_MOVIEID = "100001";
	public static final String MESSAGE_CODE_PLAYTIME = "100002";
	public static final String MESSAGE_CODE_QUANTITY = "100003";
	public static final String MESSAGE_CODE_NOSEAT = "100004";
	public static final String MESSAGE_CODE_ONESEAT = "100005";
	public static final String MESSAGE_CODE_CAPTCHA = "100006";
	public static final Map<String, String> MESSAGE_MSG_EN;
	public static final Map<String, String> MESSAGE_MSG_ZH;

	public static boolean isValidMessagesEn(String local) {
		return StringUtils.isBlank(local) ? false : StringUtils.equals(local, "en");
	}

	public static Map<String, String> getMessageMap(String local) {
		return isValidMessagesEn(local) ? MESSAGE_MSG_EN : MESSAGE_MSG_ZH;
	}

	static {
		HashMap tmpEnMap = new HashMap();
		tmpEnMap.put("100001", "You have reserved the same movie, please choose other movies.");
		tmpEnMap.put("100002",
				"You have reserved the other movie in the same time & date, please choose other movies.");
		tmpEnMap.put("100003", "You have reserved 10 movies.");
		tmpEnMap.put("100004", "Please choose a seat first.");
		tmpEnMap.put("100005", "You can only choose one seat.");
		tmpEnMap.put("100006", "Wrong Captcha.");
		MESSAGE_MSG_EN = UnmodifiableMap.decorate(tmpEnMap);
		HashMap tmpZhMap = new HashMap();
		tmpZhMap.put("100001", "你已预约过相同影片，请选择其它影片！");
		tmpZhMap.put("100002", "您已预约过相同日期时间的其他影片，请选择其他时间的影片！");
		tmpZhMap.put("100003", "您所预约的影片数量已达10场！");
		tmpZhMap.put("100004", "请选择座位！");
		tmpZhMap.put("100005", "您只能选择一个座位！");
		tmpZhMap.put("100006", "验证码错误！");
		MESSAGE_MSG_ZH = UnmodifiableMap.decorate(tmpZhMap);
	}
}