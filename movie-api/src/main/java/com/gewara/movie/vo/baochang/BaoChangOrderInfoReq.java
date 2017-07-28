/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.baochang;

import java.io.Serializable;
import java.util.Date;

public class BaoChangOrderInfoReq implements Serializable {
	private static final long serialVersionUID = 7752957508279898304L;
	private Long cinemaid;
	private Long roomid;
	private Long mpid;
	private Date appointmentDate;
	private String startTime;
	private String endTime;
	private String mobile;
	private String tradeNo;
	private Long memberid;
	private String citycode;
	private Long movieid;
	private Integer price;
	private Integer gewaprice;
	private Integer successPrice;
	private String userRemark;
	private String username;
	private String from;

	public BaoChangOrderInfoReq() {
	}

	public BaoChangOrderInfoReq(Long cinemaid, Long roomid, Long mpid) {
		this.cinemaid = cinemaid;
		this.roomid = roomid;
		this.mpid = mpid;
	}

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public Long getRoomid() {
		return this.roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public Long getMpid() {
		return this.mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

	public Date getAppointmentDate() {
		return this.appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getGewaprice() {
		return this.gewaprice;
	}

	public void setGewaprice(Integer gewaprice) {
		this.gewaprice = gewaprice;
	}

	public Integer getSuccessPrice() {
		return this.successPrice;
	}

	public void setSuccessPrice(Integer successPrice) {
		this.successPrice = successPrice;
	}

	public String getUserRemark() {
		return this.userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}