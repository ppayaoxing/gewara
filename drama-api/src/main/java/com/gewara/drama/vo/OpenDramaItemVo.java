/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import com.gewara.util.JsonUtils;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class OpenDramaItemVo extends BaseVo {
	private static final long serialVersionUID = 7088106495818025707L;
	private Long id;
	private Long dpid;
	private Long dramaid;
	private String dramaname;
	private String name;
	private Long theatreid;
	private String theatrename;
	private Long roomid;
	private String roomname;
	private Timestamp playtime;
	private Timestamp endtime;
	private String language;
	private String status;
	private String partner;
	private String checkSeat;
	private Timestamp opentime;
	private Timestamp closetime;
	private Timestamp updatetime;
	private String opentype;
	private String elecard;
	private Integer minpoint;
	private Integer maxpoint;
	private Integer maxbuy;
	private Integer msgMinute;
	private Long topicid;
	private String takemethod;
	private String takeAddress;
	private Integer remnantnum;
	private String remnantnotice;
	private String takemsg;
	private String buylimit;
	private String notifymsg1;
	private String notifymsg2;
	private String notifymsg3;
	private String notifyRemark;
	private String qrcodeRemark;
	private String remark;
	private String seatlink;
	private String otherinfo;
	private String spflag;
	private String citycode;
	private String expressid;
	private String ticketfaceid;
	private String barcode;
	private String period;
	private String seller;
	private String sellerseq;
	private String print;
	private Integer sortnum;
	private String saleCycle;
	private String showtype;
	private Integer eticketHour;
	private Integer eticketWeekHour;
	private String prepay;
	private String crmflag;
	private String crmMsg;
	private String gypMsg;
	private Integer seatnum;
	private Integer asellnum;
	private Integer gsellnum;
	private Integer csellnum;
	private Integer locknum;
	private Integer remainnum;
	private String greetings;
	private String roomnum;
	private String fieldlogo;
	private String idcard;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDpid() {
		return this.dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public String getDramaname() {
		return this.dramaname;
	}

	public void setDramaname(String dramaname) {
		this.dramaname = dramaname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTheatreid() {
		return this.theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public String getTheatrename() {
		return this.theatrename;
	}

	public void setTheatrename(String theatrename) {
		this.theatrename = theatrename;
	}

	@Deprecated
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

	public Timestamp getPlaytime() {
		return this.playtime;
	}

	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Integer getMinpoint() {
		return this.minpoint;
	}

	public void setMinpoint(Integer minpoint) {
		this.minpoint = minpoint;
	}

	public Integer getMaxpoint() {
		return this.maxpoint;
	}

	public void setMaxpoint(Integer maxpoint) {
		this.maxpoint = maxpoint;
	}

	public Integer getMaxbuy() {
		return this.maxbuy;
	}

	public void setMaxbuy(Integer maxbuy) {
		this.maxbuy = maxbuy;
	}

	public Integer getMsgMinute() {
		return this.msgMinute;
	}

	public void setMsgMinute(Integer msgMinute) {
		this.msgMinute = msgMinute;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getExpressid() {
		return this.expressid;
	}

	public void setExpressid(String expressid) {
		this.expressid = expressid;
	}

	public String getTicketfaceid() {
		return this.ticketfaceid;
	}

	public void setTicketfaceid(String ticketfaceid) {
		this.ticketfaceid = ticketfaceid;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getSeller() {
		return this.seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getSellerseq() {
		return this.sellerseq;
	}

	public void setSellerseq(String sellerseq) {
		this.sellerseq = sellerseq;
	}

	public String getPrint() {
		return this.print;
	}

	public void setPrint(String print) {
		this.print = print;
	}

	public String getPartner() {
		return this.partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getElecard() {
		return this.elecard;
	}

	public void setElecard(String elecard) {
		this.elecard = elecard;
	}

	public Long getTopicid() {
		return this.topicid;
	}

	public void setTopicid(Long topicid) {
		this.topicid = topicid;
	}

	public String getTakemethod() {
		return this.takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public String getTakemsg() {
		return this.takemsg;
	}

	public void setTakemsg(String takemsg) {
		this.takemsg = takemsg;
	}

	public String getBuylimit() {
		return this.buylimit;
	}

	public void setBuylimit(String buylimit) {
		this.buylimit = buylimit;
	}

	public String getNotifymsg1() {
		return this.notifymsg1;
	}

	public void setNotifymsg1(String notifymsg1) {
		this.notifymsg1 = notifymsg1;
	}

	public String getNotifymsg2() {
		return this.notifymsg2;
	}

	public void setNotifymsg2(String notifymsg2) {
		this.notifymsg2 = notifymsg2;
	}

	public String getNotifymsg3() {
		return this.notifymsg3;
	}

	public void setNotifymsg3(String notifymsg3) {
		this.notifymsg3 = notifymsg3;
	}

	public String getNotifyRemark() {
		return this.notifyRemark;
	}

	public void setNotifyRemark(String notifyRemark) {
		this.notifyRemark = notifyRemark;
	}

	public String getQrcodeRemark() {
		return this.qrcodeRemark;
	}

	public void setQrcodeRemark(String qrcodeRemark) {
		this.qrcodeRemark = qrcodeRemark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSeatlink() {
		return this.seatlink;
	}

	public void setSeatlink(String seatlink) {
		this.seatlink = seatlink;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getSpflag() {
		return this.spflag;
	}

	public void setSpflag(String spflag) {
		this.spflag = spflag;
	}

	public Integer getSortnum() {
		return this.sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public String getSaleCycle() {
		return this.saleCycle;
	}

	public void setSaleCycle(String saleCycle) {
		this.saleCycle = saleCycle;
	}

	public String getShowtype() {
		return this.showtype;
	}

	public void setShowtype(String showtype) {
		this.showtype = showtype;
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

	public Integer getEticketHour() {
		return this.eticketHour;
	}

	public void setEticketHour(Integer eticketHour) {
		this.eticketHour = eticketHour;
	}

	public Integer getEticketWeekHour() {
		return this.eticketWeekHour;
	}

	public void setEticketWeekHour(Integer eticketWeekHour) {
		this.eticketWeekHour = eticketWeekHour;
	}

	public String getPrepay() {
		return this.prepay;
	}

	public void setPrepay(String prepay) {
		this.prepay = prepay;
	}

	public Integer getRemainnum() {
		return this.remainnum;
	}

	public void setRemainnum(Integer remainnum) {
		this.remainnum = remainnum;
	}

	public boolean hasPeriod(String perod) {
		return StringUtils.isBlank(perod) ? false : StringUtils.equals(this.period, perod);
	}

	public boolean hasUnOpenToGewa() {
		return StringUtils.contains(this.otherinfo, "unopengewa");
	}

	public boolean hasUnShowToGewa() {
		return this.hasOnlyUnShowToGewa() || this.hasUnOpenToGewa();
	}

	public boolean hasUnOpenToSpecial() {
		return StringUtils.equals(this.otherinfo, "unopenspecial");
	}

	public boolean hasOnlyUnShowToGewa() {
		return StringUtils.contains(this.otherinfo, "unshowgewa");
	}

	public boolean hasOpenToApp() {
		return StringUtils.equals(JsonUtils.getJsonValueByKey(this.otherinfo, "odioption"), "app");
	}

	public boolean hasOpenToWap() {
		return StringUtils.equals(JsonUtils.getJsonValueByKey(this.otherinfo, "odioption"), "wap");
	}

	public String gainItemName() {
		return this.hasPeriod("Y") ? DateUtil.format(this.playtime, "MÔÂdÈÕ HH:mm") : this.name;
	}

	public boolean hasBooking() {
		return StringUtils.equals(this.status, "Y") && !this.hasClosed() && this.hasOpen() && !this.hasExpired();
	}

	public boolean isPartnerBooking() {
		return StringUtils.contains(this.status, "Y") && !this.hasClosed() && this.hasOpen() && !this.hasExpired()
				&& this.hasOpenPartner();
	}

	public boolean hasExpired() {
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		return this.playtime != null && this.endtime != null
				? this.playtime.before(cur) && StringUtils.equals(this.period, "Y")
						|| this.endtime.before(cur) && StringUtils.equals(this.period, "N")
						|| StringUtils.equals(this.status, "D")
				: true;
	}

	public boolean hasSeller(String sell) {
		return StringUtils.isBlank(sell) ? false : StringUtils.equals(this.seller, sell);
	}

	public boolean hasOpen() {
		return this.opentime == null ? false : this.opentime.before(new Timestamp(System.currentTimeMillis()));
	}

	public boolean hasClosed() {
		if (this.closetime == null) {
			return false;
		} else {
			Timestamp cur = new Timestamp(System.currentTimeMillis());
			return cur.after(this.closetime);
		}
	}

	public boolean hasOpenseat() {
		return "seat".equals(this.opentype);
	}

	public boolean hasOpenprice() {
		return "price".equals(this.opentype);
	}

	public boolean hasOpenPartner() {
		return StringUtils.equals(this.partner, "Y");
	}

	public boolean hasGewa() {
		return StringUtils.equals("GEWA", this.seller);
	}

	public boolean hasOpenPointPay() {
		return this.maxpoint != null && this.maxpoint.intValue() > 0;
	}

	public boolean hasOpenCardPay() {
		return StringUtils.containsAny(this.elecard, "ABD");
	}

	public boolean hasDisCountPay() {
		return StringUtils.contains(this.elecard, "M");
	}

	public boolean hasDiscount() {
		return this.hasOpenPointPay() || this.hasDisCountPay() || this.hasOpenCardPay();
	}

	public String getGreetings() {
		return this.greetings;
	}

	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}

	public String getCheckSeat() {
		return this.checkSeat;
	}

	public void setCheckSeat(String checkSeat) {
		this.checkSeat = checkSeat;
	}

	public String getCrmflag() {
		return this.crmflag;
	}

	public void setCrmflag(String crmflag) {
		this.crmflag = crmflag;
	}

	public String getCrmMsg() {
		return this.crmMsg;
	}

	public void setCrmMsg(String crmMsg) {
		this.crmMsg = crmMsg;
	}

	public String getGypMsg() {
		return this.gypMsg;
	}

	public void setGypMsg(String gypMsg) {
		this.gypMsg = gypMsg;
	}

	public String getRoomnum() {
		return this.roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public String getFieldlogo() {
		return this.fieldlogo;
	}

	public void setFieldlogo(String fieldlogo) {
		this.fieldlogo = fieldlogo;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getTakeAddress() {
		return this.takeAddress;
	}

	public void setTakeAddress(String takeAddress) {
		this.takeAddress = takeAddress;
	}

	public Integer getRemnantnum() {
		return this.remnantnum;
	}

	public void setRemnantnum(Integer remnantnum) {
		this.remnantnum = remnantnum;
	}

	public String getRemnantnotice() {
		return this.remnantnotice;
	}

	public void setRemnantnotice(String remnantnotice) {
		this.remnantnotice = remnantnotice;
	}
}