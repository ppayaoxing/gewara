/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class CinemaProfileVo extends BaseVo {
	private static final long serialVersionUID = -3804714651086763962L;
	public static final String STATUS_OPEN = "open";
	public static final String STATUS_CLOSE = "close";
	public static final String POPCORN_STATUS_Y = "Y";
	public static final String POPCORN_STATUS_N = "N";
	public static final String SERVICEFEE_Y = "Y";
	public static final String SERVICEFEE_N = "N";
	public static final String INSURE_STATUS_OPEN = "open";
	public static final String INSURE_STATUS_CLOSE = "close";
	public static final String TAKEMETHOD_P = "P";
	public static final String TAKEMETHOD_W = "W";
	public static final String TAKEMETHOD_A = "A";
	public static final String TAKEMETHOD_F = "F";
	public static final String TAKEMETHOD_U = "U";
	public static final String TAKEMETHOD_L = "L";
	public static final String TAKEMETHOD_D = "D";
	public static final String TAKEMETHOD_J = "J";
	public static final String TAKEMETHOD_M = "M";
	public static final String TAKEMETHOD_E = "E";
	public static final String TAKEMETHOD_T = "T";
	public static final String TAKEMETHOD_AFT = "AFT";
	private Long id;
	private String notifymsg1;
	private String notifymsg2;
	private String notifymsg3;
	private String notifymsg4;
	private String notifymsg5;
	private String takemethod;
	private Long topicid;
	private String takeAddress;
	private String opentime;
	private String closetime;
	private String startsale;
	private String endsale;
	private String popcorn;
	private String servicefee;
	private String status;
	private Integer cminute;
	private Integer openDay;
	private String openDayTime;
	private Integer fee;
	private String isRefund;
	private String isGewaRefund;
	private String opentype;
	private String direct;
	private String prompting;
	private String isInsure;
	private String openPriority;
	private String globalLimit;
	private Integer passlen;
	protected Timestamp updatetime;
	private Boolean fromCache;

	public Serializable realId() {
		return this.id;
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

	public CinemaProfileVo() {
		this.fromCache = Boolean.valueOf(false);
	}

	public CinemaProfileVo(Long cinemaid) {
		this();
		this.opentime = "0000";
		this.closetime = "2400";
		this.cminute = Integer.valueOf(60);
		this.id = cinemaid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStartsale() {
		return this.startsale;
	}

	public void setStartsale(String startsale) {
		this.startsale = startsale;
	}

	public String getEndsale() {
		return this.endsale;
	}

	public void setEndsale(String endsale) {
		this.endsale = endsale;
	}

	public String getTakeAddress() {
		return this.takeAddress;
	}

	public void setTakeAddress(String takeAddress) {
		this.takeAddress = takeAddress;
	}

	public boolean isBuyItem(Timestamp playtime) {
		if (StringUtils.isNotBlank(this.startsale) && StringUtils.isNotBlank(this.endsale)) {
			String time = DateUtil.format(playtime, "HHmm");
			if (time.compareTo(this.startsale) < 0 || time.compareTo(this.endsale) > 0) {
				return false;
			}
		}

		return true;
	}

	public String getPopcorn() {
		return this.popcorn;
	}

	public void setPopcorn(String popcorn) {
		this.popcorn = popcorn;
	}

	public String getTakeInfo() {
		String result = "在位于影院的格瓦拉自助取票机取票";
		if (StringUtils.equals(this.takemethod, "U")) {
			result = "在位于影院的联和院线自助取票机取票";
		} else if (StringUtils.equals(this.takemethod, "W")) {
			result = "影院售票窗口取票";
		} else if (StringUtils.equals(this.takemethod, "P")) {
			result = "现场派送";
		} else if (StringUtils.equals(this.takemethod, "L")) {
			result = "在位于影院的卢米埃影院自助取票机";
		} else if (StringUtils.equals(this.takemethod, "D")) {
			result = "在位于影院的万达院线自助取票机";
		} else if (StringUtils.equals(this.takemethod, "J")) {
			result = "在位于影院的金逸院线自助取票机";
		} else if (StringUtils.equals(this.takemethod, "M")) {
			result = "在位于影院的影院会员自助取票机";
		} else if (StringUtils.equals(this.takemethod, "E")) {
			result = "在位于影院的大地会员自助取票机";
		} else if (StringUtils.equals(this.takemethod, "T")) {
			result = "在位于影院的天下票仓自助取票机";
		}

		return result;
	}

	public String getServicefee() {
		return this.servicefee;
	}

	public void setServicefee(String servicefee) {
		this.servicefee = servicefee;
	}

	public Integer getCminute() {
		return this.cminute;
	}

	public void setCminute(Integer cminute) {
		this.cminute = cminute;
	}

	public String getIsRefund() {
		return this.isRefund;
	}

	public void setIsRefund(String isRefund) {
		this.isRefund = isRefund;
	}

	public String getIsGewaRefund() {
		return this.isGewaRefund;
	}

	public void setIsGewaRefund(String isGewaRefund) {
		this.isGewaRefund = isGewaRefund;
	}

	public boolean supportRefundEnabled() {
		return StringUtils.equals(this.isRefund, "Y") || StringUtils.equals(this.isGewaRefund, "Y");
	}

	public String getDirect() {
		return this.direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}

	public String getPrompting() {
		return this.prompting;
	}

	public void setPrompting(String prompting) {
		this.prompting = prompting;
	}

	public boolean hasDirect() {
		return StringUtils.equals(this.direct, "Y");
	}

	public String getOpentype() {
		return this.opentype;
	}

	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}

	public Integer getOpenDay() {
		return this.openDay;
	}

	public void setOpenDay(Integer openDay) {
		this.openDay = openDay;
	}

	public String getOpenDayTime() {
		return this.openDayTime;
	}

	public void setOpenDayTime(String openDayTime) {
		this.openDayTime = openDayTime;
	}

	public boolean hasDefinePaper() {
		return StringUtils.isNotBlank(this.takemethod) && "AFT".contains(this.takemethod) && "open".equals(this.status);
	}

	public String getOpenPriority() {
		return this.openPriority;
	}

	public void setOpenPriority(String openPriority) {
		this.openPriority = openPriority;
	}

	public String getIsInsure() {
		return this.isInsure;
	}

	public void setIsInsure(String isInsure) {
		this.isInsure = isInsure;
	}

	public String getGlobalLimit() {
		return this.globalLimit;
	}

	public void setGlobalLimit(String globalLimit) {
		this.globalLimit = globalLimit;
	}

	public Integer getPasslen() {
		return this.passlen;
	}

	public void setPasslen(Integer passlen) {
		this.passlen = passlen;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Boolean getFromCache() {
		return this.fromCache;
	}

	public void setFromCache(Boolean fromCache) {
		this.fromCache = fromCache;
	}

	public String getNotifymsg3() {
		return this.notifymsg3;
	}

	public void setNotifymsg3(String notifymsg3) {
		this.notifymsg3 = notifymsg3;
	}

	public String getNotifymsg4() {
		return this.notifymsg4;
	}

	public void setNotifymsg4(String notifymsg4) {
		this.notifymsg4 = notifymsg4;
	}

	public String getNotifymsg5() {
		return this.notifymsg5;
	}

	public void setNotifymsg5(String notifymsg5) {
		this.notifymsg5 = notifymsg5;
	}
}