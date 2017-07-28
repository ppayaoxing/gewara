/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.vo.command;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class DiscountItemVo extends BaseVo {
	private static final long serialVersionUID = -7701699951089429324L;
	private String priceseqno;
	private Double theatreprice;
	private String distype;
	private Double discount;
	private Double discountAmout;
	private Integer quantity;
	private String areaseqno;
	private String siseqno;

	public Serializable realId() {
		return this.priceseqno;
	}

	public String getPriceseqno() {
		return this.priceseqno;
	}

	public void setPriceseqno(String priceseqno) {
		this.priceseqno = priceseqno;
	}

	public Double getTheatreprice() {
		return this.theatreprice;
	}

	public void setTheatreprice(Double theatreprice) {
		this.theatreprice = theatreprice;
	}

	public String getDistype() {
		return this.distype;
	}

	public void setDistype(String distype) {
		this.distype = distype;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getDiscountAmout() {
		return this.discountAmout;
	}

	public void setDiscountAmout(Double discountAmout) {
		this.discountAmout = discountAmout;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getAreaseqno() {
		return this.areaseqno;
	}

	public void setAreaseqno(String areaseqno) {
		this.areaseqno = areaseqno;
	}

	public String getSiseqno() {
		return this.siseqno;
	}

	public void setSiseqno(String siseqno) {
		this.siseqno = siseqno;
	}
}