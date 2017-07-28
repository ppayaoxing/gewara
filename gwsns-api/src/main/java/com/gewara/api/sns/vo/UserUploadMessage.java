/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class UserUploadMessage extends BaseVo implements Serializable {
	private static final long serialVersionUID = -3322684887723628280L;
	private Long memberId;
	private String codeName;
	private String code;
	private Long gewaraMemberId;
	private String isNewUser;
	private String headpicUrl;
	private String nickname;
	private String personDescribe;
	private String relationship;
	private String updaTime;
	private String source;
	private Integer traceNum;
	private Object[] userMark;
	private String nickName;

	public Long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getCodeName() {
		return this.codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getGewaraMemberId() {
		return this.gewaraMemberId;
	}

	public void setGewaraMemberId(Long gewaraMemberId) {
		this.gewaraMemberId = gewaraMemberId;
	}

	public String getIsNewUser() {
		return this.isNewUser;
	}

	public void setIsNewUser(String isNewUser) {
		this.isNewUser = isNewUser;
	}

	public String getHeadpicUrl() {
		return this.headpicUrl;
	}

	public void setHeadpicUrl(String headpicUrl) {
		this.headpicUrl = headpicUrl;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPersonDescribe() {
		return this.personDescribe;
	}

	public void setPersonDescribe(String personDescribe) {
		this.personDescribe = personDescribe;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getUpdaTime() {
		return this.updaTime;
	}

	public void setUpdaTime(String updaTime) {
		this.updaTime = updaTime;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String toString() {
		return "UserUploadMessage [memberId=" + this.memberId + ", codeName=" + this.codeName + ", code=" + this.code
				+ ", gewaraMemberId=" + this.gewaraMemberId + ", isNewUser=" + this.isNewUser + ", headpicUrl="
				+ this.headpicUrl + ", nickname=" + this.nickname + ", personDescribe=" + this.personDescribe
				+ ", relationship=" + this.relationship + ", updaTime=" + this.updaTime + ", source=" + this.source
				+ ", traceNum=" + this.traceNum + "]";
	}

	public Integer getTraceNum() {
		return this.traceNum;
	}

	public void setTraceNum(Integer traceNum) {
		this.traceNum = traceNum;
	}

	public Object[] getUserMark() {
		return this.userMark;
	}

	public void setUserMark(Object[] userMark) {
		this.userMark = userMark;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Serializable realId() {
		return null;
	}
}