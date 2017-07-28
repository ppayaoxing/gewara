/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class ElecCardBatchVo extends BaseVo {
	private static final long serialVersionUID = 8738747879676531874L;
	public static String COSTTYPE_MINADD = "minadd";
	public static String COSTTYPE_FIXED = "fixed";
	public static String ACTIVATION_Y = "Y";
	public static String ACTIVATION_N = "N";
	public static String EXCHANGETYPE_A = "A";
	public static String EXCHANGETYPE_B = "B";
	public static String EXCHANGETYPE_D = "D";
	public static String EXCHANGETYPE_E = "E";
	public static String SOLD_TYPE_P = "P";
	public static String SOLD_TYPE_S = "S";
	public static String OTHERINFO_CINEMA = "validcinema";
	public static String OTHERINFO_MOVIE = "validmovie";
	public static String OTHERINFO_ITEM = "validitem";
	private Long id;
	private Long pid;
	private String tag;
	private Integer amount;
	private String addtime1;
	private String addtime2;
	private String addweek;
	private String opentime;
	private String closetime;
	private String weektype;
	private String validcinema;
	private String validmovie;
	private String validitem;
	private String validprice;
	private String bindpay;
	private String remark;
	private Timestamp timefrom;
	private Timestamp timeto;
	private String cardtype;
	private String notifymsg;
	private Integer daynum;
	private String citycode;
	private String citypattern;
	private String validpartner;
	private Long bindgoods;
	private Integer bindratio;
	private String costtype;
	private Integer costnum;
	private Integer costnum3D;
	private String edition;
	private String limitdesc;
	private String activation;
	private String exchangetype;
	private String channelinfo;
	private Integer appoint;
	private String soldType;
	private Integer delayDays;
	private Integer delayUseDays;
	private Integer delayFee;
	private String otherinfo;
	private String bindmobile;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getAddtime1() {
		return this.addtime1;
	}

	public void setAddtime1(String addtime1) {
		this.addtime1 = addtime1;
	}

	public String getAddtime2() {
		return this.addtime2;
	}

	public void setAddtime2(String addtime2) {
		this.addtime2 = addtime2;
	}

	public String getAddweek() {
		return this.addweek;
	}

	public void setAddweek(String addweek) {
		this.addweek = addweek;
	}

	public String getOpentime() {
		return this.opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getClosetime() {
		return this.closetime;
	}

	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	public String getWeektype() {
		return this.weektype;
	}

	public void setWeektype(String weektype) {
		this.weektype = weektype;
	}

	public String getValidcinema() {
		return this.validcinema;
	}

	public void setValidcinema(String validcinema) {
		this.validcinema = validcinema;
	}

	public String getValidmovie() {
		return this.validmovie;
	}

	public void setValidmovie(String validmovie) {
		this.validmovie = validmovie;
	}

	public String getValiditem() {
		return this.validitem;
	}

	public void setValiditem(String validitem) {
		this.validitem = validitem;
	}

	public String getValidprice() {
		return this.validprice;
	}

	public void setValidprice(String validprice) {
		this.validprice = validprice;
	}

	public String getBindpay() {
		return this.bindpay;
	}

	public void setBindpay(String bindpay) {
		this.bindpay = bindpay;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getTimefrom() {
		return this.timefrom;
	}

	public void setTimefrom(Timestamp timefrom) {
		this.timefrom = timefrom;
	}

	public Timestamp getTimeto() {
		return this.timeto;
	}

	public void setTimeto(Timestamp timeto) {
		this.timeto = timeto;
	}

	public String getCardtype() {
		return this.cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getNotifymsg() {
		return this.notifymsg;
	}

	public void setNotifymsg(String notifymsg) {
		this.notifymsg = notifymsg;
	}

	public Integer getDaynum() {
		return this.daynum;
	}

	public void setDaynum(Integer daynum) {
		this.daynum = daynum;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCitypattern() {
		return this.citypattern;
	}

	public void setCitypattern(String citypattern) {
		this.citypattern = citypattern;
	}

	public String getValidpartner() {
		return this.validpartner;
	}

	public void setValidpartner(String validpartner) {
		this.validpartner = validpartner;
	}

	public Long getBindgoods() {
		return this.bindgoods;
	}

	public void setBindgoods(Long bindgoods) {
		this.bindgoods = bindgoods;
	}

	public Integer getBindratio() {
		return this.bindratio;
	}

	public void setBindratio(Integer bindratio) {
		this.bindratio = bindratio;
	}

	public String getCosttype() {
		return this.costtype;
	}

	public void setCosttype(String costtype) {
		this.costtype = costtype;
	}

	public Integer getCostnum() {
		return this.costnum;
	}

	public void setCostnum(Integer costnum) {
		this.costnum = costnum;
	}

	public Integer getCostnum3D() {
		return this.costnum3D;
	}

	public void setCostnum3D(Integer costnum3d) {
		this.costnum3D = costnum3d;
	}

	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getLimitdesc() {
		return this.limitdesc;
	}

	public void setLimitdesc(String limitdesc) {
		this.limitdesc = limitdesc;
	}

	public String getActivation() {
		return this.activation;
	}

	public void setActivation(String activation) {
		this.activation = activation;
	}

	public String getExchangetype() {
		return this.exchangetype;
	}

	public void setExchangetype(String exchangetype) {
		this.exchangetype = exchangetype;
	}

	public String getChannelinfo() {
		return this.channelinfo;
	}

	public void setChannelinfo(String channelinfo) {
		this.channelinfo = channelinfo;
	}

	public Integer getAppoint() {
		return this.appoint;
	}

	public void setAppoint(Integer appoint) {
		this.appoint = appoint;
	}

	public String getSoldType() {
		return this.soldType;
	}

	public void setSoldType(String soldType) {
		this.soldType = soldType;
	}

	public Integer getDelayDays() {
		return this.delayDays;
	}

	public void setDelayDays(Integer delayDays) {
		this.delayDays = delayDays;
	}

	public Integer getDelayUseDays() {
		return this.delayUseDays;
	}

	public void setDelayUseDays(Integer delayUseDays) {
		this.delayUseDays = delayUseDays;
	}

	public Integer getDelayFee() {
		return this.delayFee;
	}

	public void setDelayFee(Integer delayFee) {
		this.delayFee = delayFee;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getBindmobile() {
		return this.bindmobile;
	}

	public void setBindmobile(String bindmobile) {
		this.bindmobile = bindmobile;
	}
}