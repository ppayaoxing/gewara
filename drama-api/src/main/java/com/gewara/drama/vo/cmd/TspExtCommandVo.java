package com.gewara.drama.vo.cmd;

import java.io.Serializable;

public class TspExtCommandVo implements Serializable{

	private static final long serialVersionUID = -5500557062361798872L;

	private Long tspid;
	private String correcttype;
	private Integer quantity;
	private String remark;
	private Long operuser;
	private String opertype;
	private String opername;
	private Long disid;
	private Integer disquantity = 0;
	private String tradeno;
	private Long buyitemid;
	private Long settleid;
	
	public TspExtCommandVo(){}
	
	public TspExtCommandVo(Long tspid, String correcttype){
		this.tspid = tspid;
		this.correcttype = correcttype;
	}
	
	public Long getTspid() {
		return tspid;
	}

	public void setTspid(Long tspid) {
		this.tspid = tspid;
	}

	public String getCorrecttype() {
		return correcttype;
	}
	
	public void setCorrecttype(String correcttype) {
		this.correcttype = correcttype;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getOperuser() {
		return operuser;
	}

	public void setOperuser(Long operuser) {
		this.operuser = operuser;
	}

	public String getOpertype() {
		return opertype;
	}

	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}

	public String getOpername() {
		return opername;
	}

	public void setOpername(String opername) {
		this.opername = opername;
	}

	public Long getDisid() {
		return disid;
	}

	public void setDisid(Long disid) {
		this.disid = disid;
	}

	public Integer getDisquantity() {
		return disquantity;
	}

	public void setDisquantity(Integer disquantity) {
		this.disquantity = disquantity;
	}

	public String getTradeno() {
		return tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public Long getBuyitemid() {
		return buyitemid;
	}

	public void setBuyitemid(Long buyitemid) {
		this.buyitemid = buyitemid;
	}

	public Long getSettleid() {
		return settleid;
	}

	public void setSettleid(Long settleid) {
		this.settleid = settleid;
	}
	
}
