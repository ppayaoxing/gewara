/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.bbs;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class BlackMemberVo extends BaseVo {
	private static final long serialVersionUID = -3188650815451237075L;
	private Long id;
	private Long memberId;
	private Long operatorId;
	private String description;
	private Timestamp addtime;

	public BlackMemberVo() {
	}

	public BlackMemberVo(Long memberId) {
		this.memberId = memberId;
		this.addtime = new Timestamp(System.currentTimeMillis());
	}

	public BlackMemberVo(Long memberId, String description, Long operatorId) {
		this(memberId);
		this.description = description;
		this.operatorId = operatorId;
	}

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

	public Long getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Serializable realId() {
		return this.id;
	}
}