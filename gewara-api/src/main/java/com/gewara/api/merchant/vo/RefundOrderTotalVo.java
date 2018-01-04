package com.gewara.api.merchant.vo;

import java.io.Serializable;
import java.util.List;

public class RefundOrderTotalVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3805516323721144629L;
	private List<RefundOrderReportVo> refundOrderReportList;
	private List<OrderRefundVo> orderRefundVoList;
	private int cinemaCount;//影院数
	private int movieCount;//影片数
	private int mpiCount;//场次数
	private int totalOrder;//总订单数
	private int refundOrder;//总退票订单数
	private int refundQuantity;//总退票 票数
	private int refundAmount;//总退票 金额
	private int totalCount;//总页数
	
	public int getCinemaCount() {
		return cinemaCount;
	}
	public void setCinemaCount(int cinemaCount) {
		this.cinemaCount = cinemaCount;
	}
	public int getMovieCount() {
		return movieCount;
	}
	public void setMovieCount(int movieCount) {
		this.movieCount = movieCount;
	}
	public int getMpiCount() {
		return mpiCount;
	}
	public void setMpiCount(int mpiCount) {
		this.mpiCount = mpiCount;
	}
	public int getTotalOrder() {
		return totalOrder;
	}
	public void setTotalOrder(int totalOrder) {
		this.totalOrder = totalOrder;
	}
	public int getRefundOrder() {
		return refundOrder;
	}
	public void setRefundOrder(int refundOrder) {
		this.refundOrder = refundOrder;
	}
	public int getRefundQuantity() {
		return refundQuantity;
	}
	public void setRefundQuantity(int refundQuantity) {
		this.refundQuantity = refundQuantity;
	}
	public int getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}
	public List<RefundOrderReportVo> getRefundOrderReportList() {
		return refundOrderReportList;
	}
	public void setRefundOrderReportList(
			List<RefundOrderReportVo> refundOrderReportList) {
		this.refundOrderReportList = refundOrderReportList;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<OrderRefundVo> getOrderRefundVoList() {
		return orderRefundVoList;
	}
	public void setOrderRefundVoList(List<OrderRefundVo> orderRefundVoList) {
		this.orderRefundVoList = orderRefundVoList;
	}
}
