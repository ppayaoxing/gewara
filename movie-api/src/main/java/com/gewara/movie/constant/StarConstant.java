package com.gewara.movie.constant;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;

public class StarConstant {
	public static final String BASEINFO_TYPE_STARTYPE = "startype";		//明星职业类型
	public static final String BASEINFO_TYPE_VOLK = "volk";				//民族
	public static final String BASEINFO_TYPE_SIGN = "sign";				//星座
	public static final String BASEINFO_TYPE_HOMETOWN = "hometown";		//出生地
	public static final String BASEINFO_MOVIE_TYPE = "movietype";			//电影类型
	public static final String BASEINFO_MOVIE_EDITION = "edition";			//电影版本
	public static final String BASEINFO_STATE = "state";					//国家/地区
	public static final String BASEINFO_AGELAYER = "ageLayer";			// 年龄层
	public static final String BASEINFO_FEATURE = "feature";	// 用户特征
	/*
	 * pengdi 2014年10月20日  电影基本资料字段添加
	 */
	public static final String BASEINFO_FILMTYPE= "film";	                // 片种
	public static final String BASEINFO_IMPORTMODE = "mode";	                // 引进模式
	public static final String BASEINFO_PERIOD = "period";	                // 年代
	
	public static final String ACHIEVEMENT_NO = "N";						//是否成就作品:否
	public static final String ACHIEVEMENT_YES = "Y";						//是否成就作品:是
	
	public static final Map<String, String> baseinfoMap;
	static{
		Map<String, String> tmp = new LinkedHashMap<String, String>();
		tmp.put(BASEINFO_TYPE_STARTYPE, "职业");
		tmp.put(BASEINFO_TYPE_VOLK, "民族");
		tmp.put(BASEINFO_TYPE_SIGN, "星座");
		tmp.put(BASEINFO_TYPE_HOMETOWN, "出生地");
		tmp.put(BASEINFO_MOVIE_TYPE, "电影类型");
		tmp.put(BASEINFO_MOVIE_EDITION, "电影版本");
		tmp.put(BASEINFO_STATE, "国家/地区");				
		tmp.put(BASEINFO_FILMTYPE, "片种");
		tmp.put(BASEINFO_IMPORTMODE, "引进模式");
		tmp.put(BASEINFO_PERIOD, "年代");		
		tmp.put(BASEINFO_AGELAYER, "年龄层");
		tmp.put(BASEINFO_FEATURE, "用户特征");
		baseinfoMap = UnmodifiableMap.decorate(tmp);
	}
	
}
