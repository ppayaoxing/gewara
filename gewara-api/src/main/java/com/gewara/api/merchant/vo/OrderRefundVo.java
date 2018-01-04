package com.gewara.api.merchant.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class OrderRefundVo extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2778346477632735962L;
	private String tradeNo; //订单号
	private Long movieId; //影片id
	private Timestamp playTime;  //放映时间
	private String cinemaName;
	private Integer unitprice;		//单价
	private Integer quantity;			//数量
	private Integer totalfee;			//订单总金额
	private Integer orderCost;//补差金额
	private Long cinemaId;   //影院id
	private String otherInfo;  //影厅等信息
	private Long memberId; //用户id
	private String nickName;   //用户昵称
	private String mobile;    //用户手机号
	private Timestamp addtime;			//增加日期
	private Timestamp refundtime; 		//退款时间】
	private String reason;				//原因
	private String applyinfo;			//备注信息
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public Timestamp getPlayTime() {
		return playTime;
	}
	public void setPlayTime(Timestamp playTime) {
		this.playTime = playTime;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public Integer getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotalfee() {
		return totalfee;
	}
	public void setTotalfee(Integer totalfee) {
		this.totalfee = totalfee;
	}
	public Long getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}
	public Timestamp getRefundtime() {
		return refundtime;
	}
	public void setRefundtime(Timestamp refundtime) {
		this.refundtime = refundtime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getApplyinfo() {
		return applyinfo;
	}
	public void setApplyinfo(String applyinfo) {
		this.applyinfo = applyinfo;
	}
	@Override
	public Serializable realId() {
		return tradeNo;
	}
	public Integer getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(Integer orderCost) {
		this.orderCost = orderCost;
	}
}
