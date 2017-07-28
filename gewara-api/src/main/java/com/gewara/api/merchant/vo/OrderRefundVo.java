/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.merchant.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class OrderRefundVo extends BaseVo {
	private static final long serialVersionUID = -2778346477632735962L;
	private String tradeNo;
	private Long movieId;
	private Timestamp playTime;
	private String cinemaName;
	private Integer unitprice;
	private Integer quantity;
	private Integer totalfee;
	private Integer orderCost;
	private Long cinemaId;
	private String otherInfo;
	private Long memberId;
	private String nickName;
	private String mobile;
	private Timestamp addtime;
	private Timestamp refundtime;
	private String reason;
	private String applyinfo;

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Long getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Timestamp getPlayTime() {
		return this.playTime;
	}

	public void setPlayTime(Timestamp playTime) {
		this.playTime = playTime;
	}

	public String getCinemaName() {
		return this.cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public Integer getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTotalfee() {
		return this.totalfee;
	}

	public void setTotalfee(Integer totalfee) {
		this.totalfee = totalfee;
	}

	public Long getCinemaId() {
		return this.cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getOtherInfo() {
		return this.otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public Long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getRefundtime() {
		return this.refundtime;
	}

	public void setRefundtime(Timestamp refundtime) {
		this.refundtime = refundtime;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getApplyinfo() {
		return this.applyinfo;
	}

	public void setApplyinfo(String applyinfo) {
		this.applyinfo = applyinfo;
	}

	public Serializable realId() {
		return this.tradeNo;
	}

	public Integer getOrderCost() {
		return this.orderCost;
	}

	public void setOrderCost(Integer orderCost) {
		this.orderCost = orderCost;
	}
}