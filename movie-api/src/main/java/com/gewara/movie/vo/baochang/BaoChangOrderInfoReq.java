package com.gewara.movie.vo.baochang;

import java.io.Serializable;
import java.util.Date;

public class BaoChangOrderInfoReq implements Serializable {
	private static final long serialVersionUID = 7752957508279898304L;
	
	private Long cinemaid;//影院
	private Long roomid;//影厅ID.
	private Long mpid;//场次ID
	private Date appointmentDate;//预约日期
	private String startTime;//预约时间段（开始时间）
	private String endTime;//预约时间段（结束时间）
	private String mobile;//预留手机号
	private String tradeNo;//订单号
	private Long memberid;
	private String citycode;			//城市代码
	private Long movieid;
	private Integer price;		//成本价
	private Integer gewaprice;	//格瓦卖价
	private Integer successPrice;//实际确认价格
	private String userRemark;//包场人说明
	private String username;//包场人姓名
	private String from;//下单来源（orderInfo：安卓；ios：IOS）
	
	public BaoChangOrderInfoReq(){}
	
	public BaoChangOrderInfoReq(Long cinemaid, Long roomid, Long mpid){
		this.cinemaid = cinemaid;
		this.roomid = roomid;
		this.mpid = mpid;
	}
	
	public Long getCinemaid() {
		return cinemaid;
	}
	
	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}
	
	public Long getRoomid() {
		return roomid;
	}
	
	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}
	
	public Long getMpid() {
		return mpid;
	}
	
	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Long getMovieid() {
		return movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getGewaprice() {
		return gewaprice;
	}

	public void setGewaprice(Integer gewaprice) {
		this.gewaprice = gewaprice;
	}

	public Integer getSuccessPrice() {
		return successPrice;
	}

	public void setSuccessPrice(Integer successPrice) {
		this.successPrice = successPrice;
	}

	public String getUserRemark() {
		return userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
}
