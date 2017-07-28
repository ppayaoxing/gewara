/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.cmd;

import java.io.Serializable;

public class TspExtCommandVo implements Serializable {
	private static final long serialVersionUID = -5500557062361798872L;
	private Long tspid;
	private String correcttype;
	private Integer quantity;
	private String remark;
	private Long operuser;
	private String opertype;
	private String opername;
	private Long disid;
	private Integer disquantity = Integer.valueOf(0);
	private String tradeno;
	private Long buyitemid;
	private Long settleid;

	public TspExtCommandVo() {
	}

	public TspExtCommandVo(Long tspid, String correcttype) {
		this.tspid = tspid;
		this.correcttype = correcttype;
	}

	public Long getTspid() {
		return this.tspid;
	}

	public void setTspid(Long tspid) {
		this.tspid = tspid;
	}

	public String getCorrecttype() {
		return this.correcttype;
	}

	public void setCorrecttype(String correcttype) {
		this.correcttype = correcttype;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getOperuser() {
		return this.operuser;
	}

	public void setOperuser(Long operuser) {
		this.operuser = operuser;
	}

	public String getOpertype() {
		return this.opertype;
	}

	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}

	public String getOpername() {
		return this.opername;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

	public Long getDisid() {
		return this.disid;
	}

	public void setDisid(Long disid) {
		this.disid = disid;
	}

	public Integer getDisquantity() {
		return this.disquantity;
	}

	public void setDisquantity(Integer disquantity) {
		this.disquantity = disquantity;
	}

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public Long getBuyitemid() {
		return this.buyitemid;
	}

	public void setBuyitemid(Long buyitemid) {
		this.buyitemid = buyitemid;
	}

	public Long getSettleid() {
		return this.settleid;
	}

	public void setSettleid(Long settleid) {
		this.settleid = settleid;
	}
}