package com.gewara.movie.constant;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;
import org.apache.commons.lang.StringUtils;


public class FilmFestConstant {
	
	public static final String MPITYPE_FILMFEST = "filmfest";
	
	// 北京电影节CODE
	public static final String CODE_BEIJING5 = "beijing5";
	
	// 人气之选
	public static final String CODE_BEIJING5_RQZX = "beijing5_rqzx";
	// 为你定制
	public static final String CODE_BEIJING5_DINGZHI = "beijing5_dingzhi";
	// 竞赛单元
	public static final String CODE_BEIJING5_JSDY = "beijing5_jsdy";
	// 电影节标识
	public static final String MPITYPE_FILMFEST5 = "filmfest";
	
	// 北京电影节CODE
	public static final String CODE_BEIJING6 = "beijing6";
	// 人气之选
	public static final String CODE_BEIJING6_RQZX = "beijing6_rqzx";
	// 为你定制
	public static final String CODE_BEIJING6_DINGZHI = "beijing6_dingzhi";
	// 竞赛单元
	public static final String CODE_BEIJING6_JSDY = "beijing6_jsdy";
	// 电影节标识
	public static final String MPITYPE_FILMFEST6 = "filmfest";
	
	
	
	
	
	
	
	
	
	
	
	public static final String TAG_FILMFEST_16 = "16film";	//第16届电影节
	public static final String TAG_FILMFEST_17 = "17film";
	public static final String GEWARA_FILMFEST = "gewara_filmfest_";
	
	public static final String MESSAGES_EN = "en";
	public static final String MESSAGES_ZH = "ZH";
	public static boolean isValidMessagesEn(String local){
		if(StringUtils.isBlank(local)){
			return false;
		}
		return StringUtils.equals(local, MESSAGES_EN);
	}
	
	public static final String MESSAGE_CODE_MOVIEID = "100001";
	public static final String MESSAGE_CODE_PLAYTIME = "100002";
	public static final String MESSAGE_CODE_QUANTITY = "100003";
	public static final String MESSAGE_CODE_NOSEAT = "100004";
	public static final String MESSAGE_CODE_ONESEAT = "100005";
	public static final String MESSAGE_CODE_CAPTCHA = "100006";
	
	public static final Map<String, String> MESSAGE_MSG_EN;
	public static final Map<String, String> MESSAGE_MSG_ZH;
	static{
		Map<String, String> tmpEnMap = new HashMap<String, String>();
		tmpEnMap.put(MESSAGE_CODE_MOVIEID, "You have reserved the same movie, please choose other movies.");
		tmpEnMap.put(MESSAGE_CODE_PLAYTIME, "You have reserved the other movie in the same time & date, please choose other movies.");
		tmpEnMap.put(MESSAGE_CODE_QUANTITY, "You have reserved 10 movies.");
		tmpEnMap.put(MESSAGE_CODE_NOSEAT, "Please choose a seat first.");
		tmpEnMap.put(MESSAGE_CODE_ONESEAT, "You can only choose one seat.");
		tmpEnMap.put(MESSAGE_CODE_CAPTCHA, "Wrong Captcha.");
		MESSAGE_MSG_EN = UnmodifiableMap.decorate(tmpEnMap);
		
		Map<String, String> tmpZhMap = new HashMap<String, String>();
		tmpZhMap.put(MESSAGE_CODE_MOVIEID, "你已预约过相同影片，请选择其它影片！");
		tmpZhMap.put(MESSAGE_CODE_PLAYTIME, "您已预约过相同日期时间的其他影片，请选择其他时间的影片！");
		tmpZhMap.put(MESSAGE_CODE_QUANTITY, "您所预约的影片数量已达10场！");
		tmpZhMap.put(MESSAGE_CODE_NOSEAT, "请选择座位！");
		tmpZhMap.put(MESSAGE_CODE_ONESEAT, "您只能选择一个座位！");
		tmpZhMap.put(MESSAGE_CODE_CAPTCHA, "验证码错误！");
		MESSAGE_MSG_ZH = UnmodifiableMap.decorate(tmpZhMap);
	}
	
	public static Map<String, String> getMessageMap(String local){
		if(isValidMessagesEn(local)){
			return MESSAGE_MSG_EN;
		}
		return MESSAGE_MSG_ZH;
	}
}
