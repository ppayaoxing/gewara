/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.merchant.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class GoodsOrderReportVo extends BaseVo {
	private static final long serialVersionUID = -103046049017884416L;
	private String tradeNo;
	private String goodsname;
	private Timestamp addtime;
	private Timestamp taketime;
	private int costprice;
	private int quantity;
	private int totalcost;

	public GoodsOrderReportVo() {
	}

	public GoodsOrderReportVo(String tradeNo, String goodsname, Timestamp addtime, int costprice, int quantity) {
		this.tradeNo = tradeNo;
		this.goodsname = goodsname;
		this.addtime = addtime;
		this.quantity = quantity;
		this.costprice = costprice;
		this.totalcost = this.quantity * this.costprice;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getTaketime() {
		return this.taketime;
	}

	public void setTaketime(Timestamp taketime) {
		this.taketime = taketime;
	}

	public int getCostprice() {
		return this.costprice;
	}

	public void setCostprice(int costprice) {
		this.costprice = costprice;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalcost() {
		return this.totalcost;
	}

	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}

	public Serializable realId() {
		return this.tradeNo;
	}
}