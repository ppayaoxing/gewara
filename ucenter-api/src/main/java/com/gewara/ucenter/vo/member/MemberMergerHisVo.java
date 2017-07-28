/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.member;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class MemberMergerHisVo extends BaseVo {
	private static final long serialVersionUID = 8946272152683008335L;
	private Long id;
	private Long memberId;
	private String memberPhone;
	private Long mergerMemberId;
	private String mergerMemberNickName;
	private Long operationUserId;
	private Timestamp addtime;
	private Timestamp updatetime;
	private String otherInfo;
	private String status;
	private String remark;
	private Long bindStep;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberPhone() {
		return this.memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public Long getMergerMemberId() {
		return this.mergerMemberId;
	}

	public void setMergerMemberId(Long mergerMemberId) {
		this.mergerMemberId = mergerMemberId;
	}

	public String getMergerMemberNickName() {
		return this.mergerMemberNickName;
	}

	public void setMergerMemberNickName(String mergerMemberNickName) {
		this.mergerMemberNickName = mergerMemberNickName;
	}

	public Long getOperationUserId() {
		return this.operationUserId;
	}

	public void setOperationUserId(Long operationUserId) {
		this.operationUserId = operationUserId;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getOtherInfo() {
		return this.otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getBindStep() {
		return this.bindStep;
	}

	public void setBindStep(Long bindStep) {
		this.bindStep = bindStep;
	}

	public Serializable realId() {
		return this.id;
	}
}