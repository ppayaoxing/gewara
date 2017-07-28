/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.constant;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.collections.map.UnmodifiableMap;

public class StarConstant {
	public static final String BASEINFO_TYPE_STARTYPE = "startype";
	public static final String BASEINFO_TYPE_VOLK = "volk";
	public static final String BASEINFO_TYPE_SIGN = "sign";
	public static final String BASEINFO_TYPE_HOMETOWN = "hometown";
	public static final String BASEINFO_MOVIE_TYPE = "movietype";
	public static final String BASEINFO_MOVIE_EDITION = "edition";
	public static final String BASEINFO_STATE = "state";
	public static final String BASEINFO_AGELAYER = "ageLayer";
	public static final String BASEINFO_FEATURE = "feature";
	public static final String BASEINFO_FILMTYPE = "film";
	public static final String BASEINFO_IMPORTMODE = "mode";
	public static final String BASEINFO_PERIOD = "period";
	public static final String ACHIEVEMENT_NO = "N";
	public static final String ACHIEVEMENT_YES = "Y";
	public static final Map<String, String> baseinfoMap;

	static {
		LinkedHashMap tmp = new LinkedHashMap();
		tmp.put("startype", "职业");
		tmp.put("volk", "民族");
		tmp.put("sign", "星座");
		tmp.put("hometown", "出生地");
		tmp.put("movietype", "电影类型");
		tmp.put("edition", "电影版本");
		tmp.put("state", "国家/地区");
		tmp.put("film", "片种");
		tmp.put("mode", "引进模式");
		tmp.put("period", "年代");
		tmp.put("ageLayer", "年龄层");
		tmp.put("feature", "用户特征");
		baseinfoMap = UnmodifiableMap.decorate(tmp);
	}
}