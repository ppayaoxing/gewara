/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class BSCardVo extends BaseVo {
	private static final long serialVersionUID = -6845529792674703434L;
	private Long id;
	private String cardnum;
	private Long goodsid;
	private String brandname;
	private Long orderid;
	private Long memberid;
	private String status;
	private String remark;
	private Timestamp fromtime;
	private Timestamp totime;
	private Timestamp addtime;
	private Timestamp bindtime;
	private Long brandid;

	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public Long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardnum() {
		return this.cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public Long getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
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

	public Timestamp getFromtime() {
		return this.fromtime;
	}

	public void setFromtime(Timestamp fromtime) {
		this.fromtime = fromtime;
	}

	public Timestamp getTotime() {
		return this.totime;
	}

	public void setTotime(Timestamp totime) {
		this.totime = totime;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getBindtime() {
		return this.bindtime;
	}

	public void setBindtime(Timestamp bindtime) {
		this.bindtime = bindtime;
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getBrandid() {
		return this.brandid;
	}

	public void setBrandid(Long brandid) {
		this.brandid = brandid;
	}
}