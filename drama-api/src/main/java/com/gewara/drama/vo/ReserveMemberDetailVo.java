package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;
import com.gewara.drama.constant.Status;
import com.gewara.util.DateUtil;

public class ReserveMemberDetailVo extends BaseVo {

	private static final long serialVersionUID = 1133189661599112415L;
	private Long id;
	private Long memberId;
	private Long reserveMemberId;
	private Long priceId;
	private Double price;
	private Long relatedId;
	private String origin;
	private Integer reserveCount;
	private Integer reserveNum;
	private Timestamp addTime;
	private String status;
	
	public ReserveMemberDetailVo() {
	}
	
	public ReserveMemberDetailVo(Long memberId, Long reserveMemberId, Long priceId,Double price,String origin,Long relatedId) {
		this.memberId=memberId;
		this.reserveMemberId=reserveMemberId;
		this.priceId=priceId;
		this.price=price;
		this.origin=origin;
		this.reserveCount=0;
		this.reserveNum=0;
		this.status=Status.Y;
		this.relatedId=relatedId;
		this.addTime = DateUtil.getCurFullTimestamp();
	}

	@Override
	public Serializable realId() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getReserveMemberId() {
		return reserveMemberId;
	}

	public void setReserveMemberId(Long reserveMemberId) {
		this.reserveMemberId = reserveMemberId;
	}

	public Long getPriceId() {
		return priceId;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getReserveCount() {
		return reserveCount;
	}

	public void setReserveCount(Integer reserveCount) {
		this.reserveCount = reserveCount;
	}

	public Integer getReserveNum() {
		return reserveNum;
	}

	public void setReserveNum(Integer reserveNum) {
		this.reserveNum = reserveNum;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getRelatedId() {
		return relatedId;
	}

	public void setRelatedId(Long relatedId) {
		this.relatedId = relatedId;
	}

}
