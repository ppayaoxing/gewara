/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.baochang;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.commons.lang.StringUtils;

public class BaoChangOrderInfoVo extends BaseVo {
	private static final long serialVersionUID = -5463299983756719416L;
	private Long id;
	private Long cinemaid;
	private String cinemaname;
	private Long roomid;
	private String roomname;
	private Long movieid;
	private String moviename;
	private String imgUrl;
	private Long mpid;
	private Long memberid;
	private String mobile;
	private String tradeNo;
	private Date appointmentDate;
	private String startTime;
	private String endTime;
	private Date playdate;
	private String showtime;
	private String status;
	private String remark;
	private Timestamp createtime;
	private Timestamp successtime;
	private String citycode;
	private Integer prTicketNum;
	private Integer recTicketNum;
	private String orderType;
	private Timestamp validtime;
	private Integer price;
	private Integer gewaprice;
	private Integer successPrice;
	private String userRemark;
	private String username;
	private String from;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public String getCinemaname() {
		return this.cinemaname;
	}

	public void setCinemaname(String cinemaname) {
		this.cinemaname = cinemaname;
	}

	public Long getRoomid() {
		return this.roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public String getRoomname() {
		return this.roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public String getMoviename() {
		return this.moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public Long getMpid() {
		return this.mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
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

	public Date getPlaydate() {
		return this.playdate;
	}

	public void setPlaydate(Date playdate) {
		this.playdate = playdate;
	}

	public String getShowtime() {
		return this.showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Integer getPrTicketNum() {
		return this.prTicketNum;
	}

	public void setPrTicketNum(Integer prTicketNum) {
		this.prTicketNum = prTicketNum;
	}

	public Integer getRecTicketNum() {
		return this.recTicketNum;
	}

	public void setRecTicketNum(Integer recTicketNum) {
		this.recTicketNum = recTicketNum;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Timestamp getValidtime() {
		return this.validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public boolean isTimeout() {
		return this.validtime != null && this.validtime.before(new Timestamp(System.currentTimeMillis()));
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Timestamp getSuccesstime() {
		return this.successtime;
	}

	public void setSuccesstime(Timestamp successtime) {
		this.successtime = successtime;
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

	public Timestamp getPlaytime() {
		return this.playdate != null && StringUtils.isNotBlank(this.showtime)
				? DateUtil.parseTimestamp(DateUtil.formatDate(this.playdate) + " " + this.showtime + ":00") : null;
	}

	public String showPlaytime() {
		if (this.playdate == null) {
			return null;
		} else {
			int month = DateUtil.getMonth(this.playdate).intValue();
			int day = DateUtil.getDay(this.playdate).intValue();
			return month + "ÔÂ" + day + "ÈÕ" + this.showtime;
		}
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