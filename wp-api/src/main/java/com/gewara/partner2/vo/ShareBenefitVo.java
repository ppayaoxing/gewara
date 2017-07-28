/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.partner2.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class ShareBenefitVo extends BaseVo {
	private static final long serialVersionUID = -4880540467784464050L;
	private String accountid;
	private long partnerid;
	private long amount;
	private long shareMonth;
	private String refsn;
	private String type;
	private Timestamp transactionTime;

	public String getAccountid() {
		return this.accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public long getPartnerid() {
		return this.partnerid;
	}

	public void setPartnerid(long partnerid) {
		this.partnerid = partnerid;
	}

	public long getAmount() {
		return this.amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getRefsn() {
		return this.refsn;
	}

	public void setRefsn(String refsn) {
		this.refsn = refsn;
	}

	public Timestamp getTransactionTime() {
		return this.transactionTime;
	}

	public void setTransactionTime(Timestamp transactionTime) {
		this.transactionTime = transactionTime;
	}

	public long getShareMonth() {
		return this.shareMonth;
	}

	public void setShareMonth(long shareMonth) {
		this.shareMonth = shareMonth;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Serializable realId() {
		return null;
	}
}