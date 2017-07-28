/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.merchant.vo;

import com.gewara.api.merchant.vo.GoodsOrderReportVo;
import com.gewara.api.merchant.vo.GoodsSummaryReportVo;
import java.io.Serializable;
import java.util.List;

public class GoodsSummaryReportTotalVo implements Serializable {
	private static final long serialVersionUID = -4212158813102851671L;
	private List<GoodsSummaryReportVo> goodsSummaryReportVoList;
	private List<GoodsOrderReportVo> goodsOrderReportVoList;
	private Integer cinemaCount;
	private Integer totalGoods;
	private Integer quantity;
	private Integer totalAmount;
	private Integer orderCount;
	private Integer totalCount;

	public List<GoodsSummaryReportVo> getGoodsSummaryReportVoList() {
		return this.goodsSummaryReportVoList;
	}

	public void setGoodsSummaryReportVoList(List<GoodsSummaryReportVo> goodsSummaryReportVoList) {
		this.goodsSummaryReportVoList = goodsSummaryReportVoList;
	}

	public Integer getCinemaCount() {
		return this.cinemaCount;
	}

	public void setCinemaCount(Integer cinemaCount) {
		this.cinemaCount = cinemaCount;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getOrderCount() {
		return this.orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}

	public Integer getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalGoods() {
		return this.totalGoods;
	}

	public void setTotalGoods(Integer totalGoods) {
		this.totalGoods = totalGoods;
	}

	public List<GoodsOrderReportVo> getGoodsOrderReportVoList() {
		return this.goodsOrderReportVoList;
	}

	public void setGoodsOrderReportVoList(List<GoodsOrderReportVo> goodsOrderReportVoList) {
		this.goodsOrderReportVoList = goodsOrderReportVoList;
	}
}