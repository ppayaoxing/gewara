/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gworder.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import com.gewara.util.JsonUtils;
import com.gewara.util.StringUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class OrderMpiVo extends BaseVo {
	private static final long serialVersionUID = 7825970506234199792L;
	protected Long id;
	protected Long mpid;
	protected Long movieid;
	protected Long cinemaid;
	protected String language;
	protected Date playdate;
	protected String showtime;
	protected Integer price;
	protected Integer lowest;
	protected Integer gewaprice;
	protected String edition;
	protected Long roomid;
	protected String roomnum;
	protected String opentype;
	protected String citycode;
	protected String seqNo;
	protected Long batch;
	protected Timestamp createtime;
	protected String openStatus;
	protected String mpitype;
	protected Long openid;
	protected String moviename;
	protected String cinemaname;
	protected String roomname;
	protected Timestamp playtime;
	protected Integer costprice;
	protected Integer fee;
	protected String status;
	protected String partner;
	protected Timestamp opentime;
	protected Timestamp closetime;
	protected String elecard;
	protected String spflag;
	protected String buylimit;
	protected Long topicid;
	protected String dayotime;
	protected String dayctime;
	protected Integer givepoint;
	protected String expressid;
	protected Integer lockminute;
	protected Integer maxseat;
	protected String roomtype;
	protected String otherinfo;
	protected String remark;
	protected Timestamp updatetime;
	protected Integer seatnum;
	protected Integer asellnum;
	protected Integer gsellnum;
	protected Integer csellnum;
	protected Integer locknum;

	public Serializable realId() {
		return this.mpid;
	}

	public boolean isHfh() {
		return !this.hasGewara() && StringUtils.isNotBlank(this.seqNo);
	}

	public boolean isValid() {
		return StringUtils.isNotBlank(this.roomname) && this.playdate != null && StringUtils.isNotBlank(this.showtime);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getBatch() {
		return this.batch;
	}

	public void setBatch(Long batch) {
		this.batch = batch;
	}

	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Long getRoomid() {
		return this.roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public Integer getGewaprice() {
		return this.gewaprice;
	}

	public void setGewaprice(Integer gewaprice) {
		this.gewaprice = gewaprice;
	}

	public String getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public Integer getLowest() {
		return this.lowest;
	}

	public void setLowest(Integer lowest) {
		this.lowest = lowest;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getOpenStatus() {
		return this.openStatus;
	}

	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getOpentype() {
		return this.opentype;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	public String getMpitype() {
		return this.mpitype;
	}

	public void setMpitype(String mpitype) {
		this.mpitype = mpitype;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getTimeStr() {
		return DateUtil.format(this.getPlaytime(), "HH:mm");
	}

	public Long getOpenid() {
		return this.openid;
	}

	public void setOpenid(Long openid) {
		this.openid = openid;
	}

	public String getMoviename() {
		return this.moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getCinemaname() {
		return this.cinemaname;
	}

	public void setCinemaname(String cinemaname) {
		this.cinemaname = cinemaname;
	}

	public String getRoomname() {
		return this.roomname;
	}

	public String getPlayroom() {
		return this.roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Integer getCostprice() {
		return this.costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public Integer getFee() {
		return this.fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPartner() {
		return this.partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public Timestamp getOpentime() {
		return this.opentime;
	}

	public void setOpentime(Timestamp opentime) {
		this.opentime = opentime;
	}

	public Timestamp getClosetime() {
		return this.closetime;
	}

	public void setClosetime(Timestamp closetime) {
		this.closetime = closetime;
	}

	public String getElecard() {
		return this.elecard;
	}

	public void setElecard(String elecard) {
		this.elecard = elecard;
	}

	public String getSpflag() {
		return this.spflag;
	}

	public void setSpflag(String spflag) {
		this.spflag = spflag;
	}

	public String getBuylimit() {
		return this.buylimit;
	}

	public void setBuylimit(String buylimit) {
		this.buylimit = buylimit;
	}

	public Long getTopicid() {
		return this.topicid;
	}

	public void setTopicid(Long topicid) {
		this.topicid = topicid;
	}

	public String getDayotime() {
		return this.dayotime;
	}

	public void setDayotime(String dayotime) {
		this.dayotime = dayotime;
	}

	public String getDayctime() {
		return this.dayctime;
	}

	public void setDayctime(String dayctime) {
		this.dayctime = dayctime;
	}

	public Integer getGivepoint() {
		return this.givepoint;
	}

	public void setGivepoint(Integer givepoint) {
		this.givepoint = givepoint;
	}

	public String getExpressid() {
		return this.expressid;
	}

	public void setExpressid(String expressid) {
		this.expressid = expressid;
	}

	public Integer getLockminute() {
		return this.lockminute;
	}

	public void setLockminute(Integer lockminute) {
		this.lockminute = lockminute;
	}

	public Integer getMaxseat() {
		return this.maxseat;
	}

	public void setMaxseat(Integer maxseat) {
		this.maxseat = maxseat;
	}

	public String getRoomtype() {
		return this.roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public Integer getSeatnum() {
		return this.seatnum;
	}

	public void setSeatnum(Integer seatnum) {
		this.seatnum = seatnum;
	}

	public Integer getAsellnum() {
		return this.asellnum;
	}

	public void setAsellnum(Integer asellnum) {
		this.asellnum = asellnum;
	}

	public Integer getGsellnum() {
		return this.gsellnum;
	}

	public void setGsellnum(Integer gsellnum) {
		this.gsellnum = gsellnum;
	}

	public Integer getCsellnum() {
		return this.csellnum;
	}

	public void setCsellnum(Integer csellnum) {
		this.csellnum = csellnum;
	}

	public Integer getLocknum() {
		return this.locknum;
	}

	public void setLocknum(Integer locknum) {
		this.locknum = locknum;
	}

	public String getRoomnum() {
		return this.roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public Long getMpid() {
		return this.mpid == null ? this.id : this.mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

	public Timestamp getPlaytime() {
		return this.playtime == null
				? DateUtil.parseTimestamp(DateUtil.formatDate(this.playdate) + " " + this.showtime + ":00")
				: this.playtime;
	}

	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}

	public boolean isOpenToPartner() {
		return this.hasOpenid() && "Y".equals(this.partner);
	}

	public boolean isOpenPointPay() {
		return this.hasOpenid() && !StringUtils.contains(this.elecard, "N");
	}

	public boolean isOpenCardPay() {
		return this.hasOpenid() && StringUtils.containsAny(this.elecard, "ABD");
	}

	public boolean isDisCountPay() {
		return this.hasOpenid() && StringUtils.contains(this.elecard, "M");
	}

	public String seatAmountStatus() {
		if (this.seatnum != null && this.asellnum != null && this.gsellnum != null && this.csellnum != null
				&& this.locknum != null) {
			Integer remain = Integer.valueOf(this.seatnum.intValue() - this.gsellnum.intValue()
					- this.csellnum.intValue() - this.locknum.intValue());
			return remain.intValue() == 0 ? "0" : (0 < remain.intValue() && remain.intValue() < 10 ? "1" : "2");
		} else {
			return "2";
		}
	}

	public String getSeatStatus() {
		if (!this.hasOpenid()) {
			return "";
		} else if (this.seatnum != null && this.asellnum != null && this.gsellnum != null && this.csellnum != null
				&& this.locknum != null) {
			Timestamp curtime = DateUtil.getCurFullTimestamp();
			String resText = "Ñ¡×ù¹ºÆ±";
			if (this.opentime != null && this.opentime.after(curtime)
					&& DateUtil.formatDate(curtime).equals(DateUtil.formatDate(this.opentime))) {
				resText = DateUtil.format(this.opentime, "HH:mm") + "ÊÛÆ±";
			}

			return resText;
		} else {
			return "Ñ¡×ù¹ºÆ±";
		}
	}

	public boolean hasGewara() {
		return StringUtils.equals(this.opentype, "GEWA");
	}

	public boolean hasOpentype(String type) {
		return StringUtils.isBlank(type) ? false : StringUtils.equals(this.opentype, type);
	}

	public boolean hasOpenStatus(String statuss) {
		return StringUtils.equals(this.openStatus, statuss);
	}

	public boolean isUnOpenToGewa() {
		return StringUtils.contains(this.otherinfo, "unopengewa");
	}

	public boolean isUnShowToGewa() {
		return StringUtils.contains(this.otherinfo, "unshowgewa") || StringUtils.contains(this.otherinfo, "unopengewa")
				|| StringUtils.contains(this.otherinfo, "baoChang");
	}

	public boolean hasOpenid() {
		return this.openid != null;
	}

	public boolean isOrder() {
		if (!this.hasOpenid()) {
			return false;
		} else {
			Timestamp curtime = new Timestamp(System.currentTimeMillis());
			String time = DateUtil.format(curtime, "HHmm");
			boolean open = this.getPlaytime().after(curtime) && this.opentime.before(curtime)
					&& this.closetime.after(curtime) && this.status.equals("Y")
					&& StringUtil.between(time, this.dayotime, this.dayctime);
			return open;
		}
	}

	public boolean isShowOrder() {
		if (!this.hasOpenid()) {
			return false;
		} else {
			Timestamp curtime = new Timestamp(System.currentTimeMillis());
			if (this.opentime.after(curtime)
					&& !DateUtil.formatDate(curtime).equals(DateUtil.formatDate(this.opentime))) {
				return false;
			} else {
				String time = DateUtil.format(curtime, "HHmm");
				boolean open = this.getPlaytime().after(curtime) && this.closetime.after(curtime)
						&& this.status.equals("Y") && StringUtil.between(time, this.dayotime, this.dayctime);
				return open;
			}
		}
	}

	public Timestamp getFullPlaytime() {
		return this.openid == null
				? DateUtil.parseTimestamp(DateUtil.formatDate(this.playdate) + " " + this.showtime + ":00")
				: this.playtime;
	}

	public boolean isOpen() {
		return !this.hasOpenid() ? false
				: this.opentime != null && this.opentime.before(new Timestamp(System.currentTimeMillis()));
	}

	public boolean isBooking() {
		return !this.hasOpenid() ? false : StringUtils.equals(this.status, "Y") && !this.isClosed();
	}

	public boolean isExpired() {
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return !this.hasOpenid() ? this.getPlaytime().before(cur)
				: this.playtime != null && this.playtime.before(cur) || StringUtils.equals(this.status, "P");
	}

	public boolean isClosed() {
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return !this.hasOpenid() ? cur.before(this.getPlaytime()) : this.closetime == null || cur.after(this.closetime);
	}

	public boolean hasOpi() {
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return !this.hasOpenid() ? false
				: !this.closetime.before(cur)
						&& (!this.opentime.after(cur)
								|| DateUtil.formatDate(cur).equals(DateUtil.formatDate(this.opentime)))
						&& StringUtils.equals(this.status, "Y") && (this.gsellnum == null || this.asellnum == null
								|| this.gsellnum.intValue() < this.asellnum.intValue());
	}

	public Integer gainServiceFee() {
		if (this.gewaprice != null && this.costprice != null) {
			int serviceFee = this.gewaprice.intValue() - this.costprice.intValue();
			return Integer.valueOf(serviceFee < 0 ? 0 : serviceFee);
		} else {
			return Integer.valueOf(0);
		}
	}

	public Integer getServicefee() {
		return this.gainServiceFee();
	}

	public int gainLockSeat() {
		return !this.hasOpentype("MTX") && !this.hasOpentype("JY") && !this.hasOpentype("NJY")
				&& !this.hasOpentype("MJY") && !this.hasOpentype("WD") && !this.hasOpentype("WD2")
				&& !this.hasOpentype("GPTBS") ? 5 : 4;
	}

	public int gainLockMinute() {
		return 15;
	}

	public boolean hasRefund() {
		Map map = JsonUtils.readJsonToMap(this.otherinfo);
		return StringUtils.equals((String) map.get("isRefund"), "Y");
	}

	public boolean hasBaoChang() {
		return StringUtils.contains(this.otherinfo, "baoChang");
	}
}