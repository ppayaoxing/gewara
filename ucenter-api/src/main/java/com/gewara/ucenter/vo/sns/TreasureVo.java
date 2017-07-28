/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.sns;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class TreasureVo extends BaseVo {
	private static final long serialVersionUID = -6783731167904266671L;
	public static final String ACTION_COLLECT = "collect";
	public static final String TAG_MEMBER = "member";
	private Long id;
	private Long memberid;
	private String tag;
	private String action;
	private Long relatedid;
	private Timestamp addtime;
	private String actionlabel;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getActionlabel() {
		return this.actionlabel;
	}

	public void setActionlabel(String actionlabel) {
		this.actionlabel = actionlabel;
	}

	public Serializable realId() {
		return this.id;
	}
}