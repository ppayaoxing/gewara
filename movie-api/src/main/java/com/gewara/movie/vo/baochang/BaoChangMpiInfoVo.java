package com.gewara.movie.vo.baochang;

import java.sql.Timestamp;
import java.util.Date;

import com.gewara.util.DateUtil;

public class BaoChangMpiInfoVo extends BaoChangBasePriceInfoVo{
	private static final long serialVersionUID = -8070228638065466745L;
	
	private Long movieid;
	private String moviename;
	private Long mpid;
	private Date playdate;		//放映日期
	private String showtime;	//放映时间
	private String status;//状态
	private Integer seatNum;//影厅座位数量
	private Integer seatPrice;//影院单张票价
	private Integer seatGewaprice;//格瓦单张卖价
	private Timestamp validtime;		//有效时间
	
	public BaoChangMpiInfoVo(){}
	
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

	public Integer getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}

	public Integer getSeatPrice() {
		return seatPrice;
	}

	public void setSeatPrice(Integer seatPrice) {
		this.seatPrice = seatPrice;
	}

	public Integer getSeatGewaprice() {
		return seatGewaprice;
	}

	public void setSeatGewaprice(Integer seatGewaprice) {
		this.seatGewaprice = seatGewaprice;
	}

	public Timestamp getValidtime() {
		return validtime;
	}

	public void setValidtime(Timestamp validtime) {
		this.validtime = validtime;
	}
	
	public boolean isLock(){
		return validtime!=null && new Timestamp(System.currentTimeMillis()).before(validtime);
	}

	public Timestamp getFullPlaytime(){
		String timeStr = DateUtil.formatDate(playdate) + " " + showtime + ":00";
		return DateUtil.parseTimestamp(timeStr);
	}
	
	public boolean isTimeOut(){
		return getFullPlaytime() != null && getFullPlaytime().before(new Timestamp(System.currentTimeMillis()));
	}
}
