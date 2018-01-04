package com.gewara.api.sns.vo.taskreward;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

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
	private Long id; // 主键
	private String type;// 类型 headpic,nickname,introduction,other
	private String name;//
	private String linkeUrl;// 链接
	private Integer score; // 分数
	private String status; // Y_NEW、N_DELETE
	private Integer sortNum;// 排序
	private Long memberid; // 添加用户
	private String nickname;
	private Timestamp addtime; // 创建时间

	@Override
	public Serializable realId() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinkeUrl() {
		return linkeUrl;
	}

	public void setLinkeUrl(String linkeUrl) {
		this.linkeUrl = linkeUrl;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

}
