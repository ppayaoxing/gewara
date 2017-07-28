/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.member;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class MemberOperationVo extends BaseVo {
	private static final long serialVersionUID = -3522154958693872559L;
	public static String OPS_PW = "W";
	public static String OPS_BIND = "B";
	public static String OPS_UNBIND = "U";
	public static String OPS_PAYCODE = "P";
	private Long id;
	private Long userid;
	private Long memberid;
	private String applyIp;
	private Long applyUserid;
	private Long auditUserid;
	private String auditIp;
	private String mobile;
	private String email;
	private String callNumber;
	private String forReason;
	private String opsType;
	private String operator;
	private String status;
	private String createdTime;
	private String extraMsg;

	public MemberOperationVo() {
	}

	public MemberOperationVo(String applyIp, Long applyUserid) {
		this.applyIp = applyIp;
		this.applyUserid = applyUserid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCallNumber() {
		return this.callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	public String getForReason() {
		return this.forReason;
	}

	public void setForReason(String forReason) {
		this.forReason = forReason;
	}

	public String getOpsType() {
		return this.opsType;
	}

	public void setOpsType(String opsType) {
		this.opsType = opsType;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getExtraMsg() {
		return this.extraMsg;
	}

	public void setExtraMsg(String extraMsg) {
		this.extraMsg = extraMsg;
	}

	public Long getApplyUserid() {
		return this.applyUserid;
	}

	public void setApplyUserid(Long applyUserid) {
		this.applyUserid = applyUserid;
	}

	public Long getAuditUserid() {
		return this.auditUserid;
	}

	public void setAuditUserid(Long auditUserid) {
		this.auditUserid = auditUserid;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getApplyIp() {
		return this.applyIp;
	}

	public void setApplyIp(String applyIp) {
		this.applyIp = applyIp;
	}

	public String getAuditIp() {
		return this.auditIp;
	}

	public void setAuditIp(String auditIp) {
		this.auditIp = auditIp;
	}

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Serializable realId() {
		return this.id;
	}
}