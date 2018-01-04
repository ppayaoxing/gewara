package com.gewara.api.gpticket.vo.command;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class DiscountItemVo extends BaseVo {

	private static final long serialVersionUID = -7701699951089429324L;
	private String priceseqno;		//价格编号
	private Double theatreprice;
	private String distype;
	private Double discount;
	private Double discountAmout;
	private Integer quantity;
	private String areaseqno;
	private String siseqno;
	
	@Override
	public Serializable realId() {
		return priceseqno;
	}

	public String getPriceseqno() {
		return priceseqno;
	}

	public void setPriceseqno(String priceseqno) {
		this.priceseqno = priceseqno;
	}

	public Double getTheatreprice() {
		return theatreprice;
	}

	public void setTheatreprice(Double theatreprice) {
		this.theatreprice = theatreprice;
	}

	public String getDistype() {
		return distype;
	}

	public void setDistype(String distype) {
		this.distype = distype;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getDiscountAmout() {
		return discountAmout;
	}

	public void setDiscountAmout(Double discountAmout) {
		this.discountAmout = discountAmout;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getAreaseqno() {
		return areaseqno;
	}

	public void setAreaseqno(String areaseqno) {
		this.areaseqno = areaseqno;
	}

	public String getSiseqno() {
		return siseqno;
	}

	public void setSiseqno(String siseqno) {
		this.siseqno = siseqno;
	}

}
