package com.gewara.ucenter.vo.member;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class MemberOperationVo extends BaseVo{
	private static final long serialVersionUID = -3522154958693872559L;
	/**
	 * 修改密码
	 */
	public static String OPS_PW = "W";
	/**
	 * 绑定手机
	 */
	public static String OPS_BIND = "B";
	/**
	 * 解除手机绑定
	 */
	public static String OPS_UNBIND = "U";
	/**
	 * 重置支付密码
	 */
	public static String OPS_PAYCODE = "P";

	private Long id;
	private Long userid;
	private Long memberid;
	private String applyIp;
	private Long applyUserid;	//申请人
	private Long auditUserid;	//审核人
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
	
	public MemberOperationVo(){
	}
	public MemberOperationVo(String applyIp, Long applyUserid){
		this.applyIp = applyIp;
		this.applyUserid = applyUserid;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	public String getForReason() {
		return forReason;
	}

	public void setForReason(String forReason) {
		this.forReason = forReason;
	}

	public String getOpsType() {
		return opsType;
	}

	public void setOpsType(String opsType) {
		this.opsType = opsType;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getExtraMsg() {
		return extraMsg;
	}

	public void setExtraMsg(String extraMsg) {
		this.extraMsg = extraMsg;
	}

	public Long getApplyUserid() {
		return applyUserid;
	}

	public void setApplyUserid(Long applyUserid) {
		this.applyUserid = applyUserid;
	}

	public Long getAuditUserid() {
		return auditUserid;
	}

	public void setAuditUserid(Long auditUserid) {
		this.auditUserid = auditUserid;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getApplyIp() {
		return applyIp;
	}

	public void setApplyIp(String applyIp) {
		this.applyIp = applyIp;
	}

	public String getAuditIp() {
		return auditIp;
	}

	public void setAuditIp(String auditIp) {
		this.auditIp = auditIp;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	@Override
	public Serializable realId() {
		return id;
	}
}
