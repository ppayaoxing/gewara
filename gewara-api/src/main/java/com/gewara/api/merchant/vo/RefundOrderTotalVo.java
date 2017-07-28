/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.merchant.vo;

import com.gewara.api.merchant.vo.OrderRefundVo;
import com.gewara.api.merchant.vo.RefundOrderReportVo;
import java.io.Serializable;
import java.util.List;

public class RefundOrderTotalVo implements Serializable {
	private static final long serialVersionUID = -3805516323721144629L;
	private List<RefundOrderReportVo> refundOrderReportList;
	private List<OrderRefundVo> orderRefundVoList;
	private int cinemaCount;
	private int movieCount;
	private int mpiCount;
	private int totalOrder;
	private int refundOrder;
	private int refundQuantity;
	private int refundAmount;
	private int totalCount;

	public int getCinemaCount() {
		return this.cinemaCount;
	}

	public void setCinemaCount(int cinemaCount) {
		this.cinemaCount = cinemaCount;
	}

	public int getMovieCount() {
		return this.movieCount;
	}

	public void setMovieCount(int movieCount) {
		this.movieCount = movieCount;
	}

	public int getMpiCount() {
		return this.mpiCount;
	}

	public void setMpiCount(int mpiCount) {
		this.mpiCount = mpiCount;
	}

	public int getTotalOrder() {
		return this.totalOrder;
	}

	public void setTotalOrder(int totalOrder) {
		this.totalOrder = totalOrder;
	}

	public int getRefundOrder() {
		return this.refundOrder;
	}

	public void setRefundOrder(int refundOrder) {
		this.refundOrder = refundOrder;
	}

	public int getRefundQuantity() {
		return this.refundQuantity;
	}

	public void setRefundQuantity(int refundQuantity) {
		this.refundQuantity = refundQuantity;
	}

	public int getRefundAmount() {
		return this.refundAmount;
	}

	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}

	public List<RefundOrderReportVo> getRefundOrderReportList() {
		return this.refundOrderReportList;
	}

	public void setRefundOrderReportList(List<RefundOrderReportVo> refundOrderReportList) {
		this.refundOrderReportList = refundOrderReportList;
	}

	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<OrderRefundVo> getOrderRefundVoList() {
		return this.orderRefundVoList;
	}

	public void setOrderRefundVoList(List<OrderRefundVo> orderRefundVoList) {
		this.orderRefundVoList = orderRefundVoList;
	}
}