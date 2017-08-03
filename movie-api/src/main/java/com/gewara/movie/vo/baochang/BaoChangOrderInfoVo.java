package com.gewara.movie.vo.baochang;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;

public class BaoChangOrderInfoVo extends BaseVo {
	private static final long serialVersionUID = -5463299983756719416L;
	
	private Long id;
	private Long cinemaid;//影院
	private String cinemaname;
	private Long roomid;//影厅ID
	private String roomname;
	private Long movieid;//影片ID
	private String moviename;
	private String imgUrl;
	private Long mpid;//场次ID
	private Long memberid;//预约人ID
	private String mobile;//预留手机号
	private String tradeNo;//订单号
	private Date appointmentDate;//预约日期
	private String startTime;//预约时间段（开始时间）
	private String endTime;//预约时间段（结束时间）
	private Date playdate;		//放映日期
	private String showtime;	//放映时间
	private String status;//状态
	private String remark;//说明
	private Timestamp createtime;//创建时间
	private Timestamp successtime;//成功时间
	private String citycode;
	private Integer prTicketNum;
	private Integer recTicketNum;
	private String orderType;//订单类型（exist：现有场次订单；appointment：预约场次订单）
	private Timestamp validtime;		//有效时间
	private Integer price;		//成本价
	private Integer gewaprice;	//格瓦卖价
	private Integer successPrice;//实际确认价格
	private String userRemark;//包场人说明
	private String username;//包场人姓名
	private String from;//下单来源（orderInfo：安卓；ios：IOS）
	
	public BaoChangOrderInfoVo(){}

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

	public Long getCinemaid() {
		return cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public String getCinemaname() {
		return cinemaname;
	}

	public void setCinemaname(String cinemaname) {
		this.cinemaname = cinemaname;
	}

	public Long getRoomid() {
		return roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Long getMovieid() {
		return movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public Long getMpid() {
		return mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
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

	public Date getPlaydate() {
		return playdate;
	}

	public void setPlaydate(Date playdate) {
		this.playdate = playdate;
	}

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Integer getPrTicketNum() {
		return prTicketNum;
	}

	public void setPrTicketNum(Integer prTicketNum) {
		this.prTicketNum = prTicketNum;
	}

	public Integer getRecTicketNum() {
		return recTicketNum;
	}

	public void setRecTicketNum(Integer recTicketNum) {
		this.recTicketNum = recTicketNum;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Timestamp getValidtime() {
		return validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}

	public boolean isTimeout(){
		return validtime!=null && validtime.before(new Timestamp(System.currentTimeMillis()));
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Timestamp getSuccesstime() {
		return successtime;
	}

	public void setSuccesstime(Timestamp successtime) {
		this.successtime = successtime;
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
	
	public Timestamp getPlaytime() {
		return (playdate != null && StringUtils.isNotBlank(showtime))?DateUtil.parseTimestamp(DateUtil.formatDate(playdate) + " " + showtime + ":00"):null;
	}
	
	public String showPlaytime(){
		if(playdate == null){
			return null;
		}
		int month = DateUtil.getMonth(playdate);
		int day = DateUtil.getDay(playdate);
		return month + "月" + day + "日" + showtime;
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
