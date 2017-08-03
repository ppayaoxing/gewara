package com.gewara.partner2.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

/**
 * 分润
 * @author user_2
 */
public class ShareBenefitVo extends BaseVo {

	private static final long serialVersionUID = -4880540467784464050L;

	private String accountid; 		// 资金号
	private long partnerid; 		// 合作商ID
	private long amount; 			// 金额[单位：分]
	private long shareMonth;		//分润月份[yyyymm]
	private String refsn;			//交易流水
	private String type;			//充值类型["CHARGE"预付款    "SHARE"分润   "SERVICE"技术服务费 "MAINTAIN" 维护费]
	private Timestamp transactionTime; // 交易时间

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public long getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(long partnerid) {
		this.partnerid = partnerid;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getRefsn() {
		return refsn;
	}

	public void setRefsn(String refsn) {
		this.refsn = refsn;
	}

	public Timestamp getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Timestamp transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	public long getShareMonth() {
		return shareMonth;
	}

	public void setShareMonth(long shareMonth) {
		this.shareMonth = shareMonth;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public Serializable realId() {
		return null;
	}
}
