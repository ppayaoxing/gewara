/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.bbs;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class AccusationVo extends BaseVo {
	private static final long serialVersionUID = 4476980910614491968L;
	public static String STATUS_NEW = "new";
	public static String STATUS_PROCESSED_Y = "processed_y";
	public static String STATUS_PROCESSED_N = "processed_n";
	public static String TAG_DIARY = "diary";
	public static String TAG_DIARYCOMMENT = "diarycomment";
	public static String TAG_GEWAQUESTION = "gewaquestion";
	public static String TAG_GEWAANSWER = "gewaanswer";
	public static String TAG_ACTIVITY = "activity";
	public static String TAG_ACTIVITYCOMMENT = "activitycomment";
	public static String TAG_COMMENT = "comment";
	public static String TAG_USERMESSAGE = "userMessage";
	private Long id;
	private Long memberid;
	private String email;
	private String tag;
	private String tag2;
	private Long relatedid;
	private Long relatedid2;
	private String referer;
	private String body;
	private String message;
	private Long clerk;
	private String status;
	private Timestamp addtime;
	private Timestamp updatetime;

	public AccusationVo() {
	}

	public AccusationVo(String tag) {
		this.tag = tag;
		this.status = STATUS_NEW;
		this.addtime = new Timestamp(System.currentTimeMillis());
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getClerk() {
		return this.clerk;
	}

	public void setClerk(Long clerk) {
		this.clerk = clerk;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReferer() {
		return this.referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTag2() {
		return this.tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public Long getRelatedid2() {
		return this.relatedid2;
	}

	public void setRelatedid2(Long relatedid2) {
		this.relatedid2 = relatedid2;
	}
}