/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.taskreward;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class TaskRewardVo extends BaseVo {
	public static final String TYPE_HEADPIC = "headpic";
	public static final String TYPE_NICKNAME = "nickname";
	public static final String TYPE_INTRO = "introduction";
	public static final String TYPE_OTHER = "other";
	public static final String HAS_VOTE_NO = "0";
	public static final String HAS_VOTE_YES = "1";
	public static final String ISUSED_NO = "0";
	public static final String ISUSED_YES = "1";
	private static final long serialVersionUID = -2462991574596383962L;
	private Long id;
	private String type;
	private String name;
	private String linkeUrl;
	private Integer score;
	private String status;
	private Integer sortNum;
	private Long memberid;
	private String nickname;
	private Timestamp addtime;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinkeUrl() {
		return this.linkeUrl;
	}

	public void setLinkeUrl(String linkeUrl) {
		this.linkeUrl = linkeUrl;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSortNum() {
		return this.sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
}