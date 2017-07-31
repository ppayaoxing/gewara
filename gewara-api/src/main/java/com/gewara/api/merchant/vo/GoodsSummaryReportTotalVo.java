package com.gewara.api.merchant.vo;

import java.io.Serializable;
import java.util.List;

public class GoodsSummaryReportTotalVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4212158813102851671L;
	private List<GoodsSummaryReportVo> goodsSummaryReportVoList;
	private List<GoodsOrderReportVo> goodsOrderReportVoList;
	private Integer cinemaCount;
	private Integer totalGoods; //套餐数
	private Integer quantity; //票数
	private Integer totalAmount; //总金额
	private Integer orderCount; //总订单数
	private Integer totalCount; //总条数
	public List<GoodsSummaryReportVo> getGoodsSummaryReportVoList() {
		return goodsSummaryReportVoList;
	}
	public void setGoodsSummaryReportVoList(
			List<GoodsSummaryReportVo> goodsSummaryReportVoList) {
		this.goodsSummaryReportVoList = goodsSummaryReportVoList;
	}
	public Integer getCinemaCount() {
		return cinemaCount;
	}
	public void setCinemaCount(Integer cinemaCount) {
		this.cinemaCount = cinemaCount;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalGoods() {
		return totalGoods;
	}
	public void setTotalGoods(Integer totalGoods) {
		this.totalGoods = totalGoods;
	}
	public List<GoodsOrderReportVo> getGoodsOrderReportVoList() {
		return goodsOrderReportVoList;
	}
	public void setGoodsOrderReportVoList(List<GoodsOrderReportVo> goodsOrderReportVoList) {
		this.goodsOrderReportVoList = goodsOrderReportVoList;
	}
	
}
