package com.gewara.api.sns.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class UserUploadMessage extends BaseVo implements Serializable {
 
	private static final long serialVersionUID = -3322684887723628280L;
	private Long memberId;//当前用户id
	private String codeName;//source对应的名称
	private String code;//source对应的code
	private Long gewaraMemberId;//手机对应的格瓦拉用户id
	private String isNewUser;//新匹配到的用户标记
	private String headpicUrl;
	private String nickname;
	private String personDescribe;
	private String relationship;//用户关系
	private String updaTime;//时间
	private String source;//类型
	private Integer traceNum;//影迹数量
	private Object[] userMark; //荣誉标签
	private String nickName;
	
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getGewaraMemberId() {
		return gewaraMemberId;
	}

	public void setGewaraMemberId(Long gewaraMemberId) {
		this.gewaraMemberId = gewaraMemberId;
	}

	public String getIsNewUser() {
		return isNewUser;
	}

	public void setIsNewUser(String isNewUser) {
		this.isNewUser = isNewUser;
	}

	public String getHeadpicUrl() {
		return headpicUrl;
	}

	public void setHeadpicUrl(String headpicUrl) {
		this.headpicUrl = headpicUrl;
	}

	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPersonDescribe() {
		return personDescribe;
	}

	public void setPersonDescribe(String personDescribe) {
		this.personDescribe = personDescribe;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getUpdaTime() {
		return updaTime;
	}

	public void setUpdaTime(String updaTime) {
		this.updaTime = updaTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "UserUploadMessage [memberId=" + memberId + ", codeName="
				+ codeName + ", code=" + code + ", gewaraMemberId="
				+ gewaraMemberId + ", isNewUser=" + isNewUser + ", headpicUrl="
				+ headpicUrl + ", nickname=" + nickname + ", personDescribe="
				+ personDescribe + ", relationship=" + relationship
				+ ", updaTime=" + updaTime + ", source=" + source
				+ ", traceNum=" + traceNum + "]";
	}

	public Integer getTraceNum() {
		return traceNum;
	}

	public void setTraceNum(Integer traceNum) {
		this.traceNum = traceNum;
	}

	public Object[] getUserMark() {
		return userMark;
	}

	public void setUserMark(Object[] userMark) {
		this.userMark = userMark;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public Serializable realId() {
		return null;
	}


	
}
