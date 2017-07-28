/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.map.UnmodifiableMap;

public abstract class DiaryConstant implements Serializable {
	private static final long serialVersionUID = 7800942669108910128L;
	public static final String DIARY_TYPE_ALL = "";
	public static final String DIARY_TYPE_COMMENT = "comment";
	public static final String DIARY_TYPE_TOPIC_DIARY = "topic_diary";
	public static final String DIARY_TYPE_TOPIC_VOTE_RADIO = "topic_vote_radio";
	public static final String DIARY_TYPE_TOPIC_VOTE_MULTI = "topic_vote_multi";
	public static final String DIARY_TYPE_TOPIC = "topic";
	public static final String DIARY_TYPE_TOPIC_VOTE = "topic_vote";
	public static final String DIVISION_Y = "Y";
	public static final String DIVISION_N = "N";
	public static final String DIVISION_A = "A";
	public static final Map<String, String> DIARY_TYPE_MAP;

	static {
		HashMap tmp = new HashMap();
		tmp.put("0", "");
		tmp.put("1", "comment");
		tmp.put("2", "topic_diary");
		tmp.put("3", "topic_vote_radio");
		tmp.put("4", "topic_vote_multi");
		tmp.put("5", "topic");
		tmp.put("6", "topic_vote");
		DIARY_TYPE_MAP = UnmodifiableMap.decorate(tmp);
	}
}