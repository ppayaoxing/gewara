package com.gewara.api.vo.order;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class GoodsOrderVo extends GewaOrderVo {
	private String goodsname;
	private String shortname;
	private String printcontent;
	private Integer price;
	private Long placeid;

	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public String getShortname() {
		return shortname;
	}

	public String getPrintcontent() {
		return printcontent;
	}

	public Integer getPrice() {
		return price;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public void setPrintcontent(String printcontent) {
		this.printcontent = printcontent;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Long getPlaceid() {
		return placeid;
	}

	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}

}
