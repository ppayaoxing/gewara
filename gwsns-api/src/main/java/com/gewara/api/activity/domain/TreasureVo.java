/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity.domain;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class TreasureVo extends BaseVo {
	private static final long serialVersionUID = -673268778354641818L;
	public static final String ACTION_COLLECT = "collect";
	public static final String ACTION_SIGN = "sign";
	public static final String ACTION_XIANGQU = "xiangqu";
	public static final String ACTION_QUGUO = "quguo";
	public static final String ACTION_XIANGXUE = "xiangxue";
	public static final String ACTION_PLAYING = "playing";
	public static final String ACTION_PLAYED = "played";
	public static final String ACTION_TOGETHER = "together";
	public static final String TAG_MEMBER = "member";
	public static final String ACTION_FANS = "fans";
	public static final String ACTION_ACTIVITY = "activity";
	private Long id;
	private Long memberid;
	private String tag;
	private String action;
	private Long relatedid;
	private Timestamp addtime;
	private String actionlabel;
	private Integer unreadnum;

	public String getActionlabel() {
		return this.actionlabel;
	}

	public void setActionlabel(String actionlabel) {
		this.actionlabel = actionlabel;
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

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getUnreadnum() {
		return this.unreadnum;
	}

	public void setUnreadnum(Integer unreadnum) {
		this.unreadnum = unreadnum;
	}
}