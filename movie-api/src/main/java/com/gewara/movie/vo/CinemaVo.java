/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.movie.vo.common.BaseInfoVo;
import com.gewara.util.JsonUtils;
import java.util.List;
import java.util.Map;

public class CinemaVo extends BaseInfoVo {
	private static final long serialVersionUID = 5226491557222831911L;
	private static final double R = 6371229.0D;
	public static final String BOOKING_OPEN = "open";
	public static final String BOOKING_CLOSE = "close";
	private String flag;
	private String booking;
	private String popcorn;
	private String contactTelephone;
	private String mobilePhone;
	private String englishaddress;
	private String manageCompany;
	private String showGawara;
	private String pcid;
	private String generalmarksort;
	private String subwayTransport;

	public String getGeneralmarksort() {
		return this.generalmarksort;
	}

	public void setGeneralmarksort(String generalmarksort) {
		this.generalmarksort = generalmarksort;
	}

	public Long getCinemaid() {
		return this.id;
	}

	public String getCinemaname() {
		return this.name;
	}

	public String getUrl() {
		return "cinema/" + this.id;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getBooking() {
		return this.booking;
	}

	public void setBooking(String booking) {
		this.booking = booking;
	}

	public String getPopcorn() {
		return this.popcorn;
	}

	public void setPopcorn(String popcorn) {
		this.popcorn = popcorn;
	}

	public String getContactTelephone() {
		return this.contactTelephone;
	}

	public void setContactTelephone(String contactTelephone) {
		this.contactTelephone = contactTelephone;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getSubwayTransport() {
		return this.subwayTransport;
	}

	public void setSubwayTransport(String subwayTransport) {
		this.subwayTransport = subwayTransport;
	}

	public String getShowGawara() {
		return this.showGawara;
	}

	public void setShowGawara(String showGawara) {
		this.showGawara = showGawara;
	}

	public String getDistance(String latx1, String laty1) {
		try {
			double e = Double.valueOf(latx1).doubleValue();
			double y1 = Double.valueOf(laty1).doubleValue();
			double x2 = Double.valueOf(this.pointx).doubleValue();
			double y2 = Double.valueOf(this.pointy).doubleValue();
			double x = (x2 - e) * 3.141592653589793D * 6371229.0D
					* Math.cos((y1 + y2) / 2.0D * 3.141592653589793D / 180.0D) / 180.0D;
			double y = (y2 - y1) * 3.141592653589793D * 6371229.0D / 180.0D;
			double distance = Math.hypot(x, y) / 1000.0D;
			return Math.round(distance) + "¹«Àï";
		} catch (Exception arg16) {
			return "";
		}
	}

	public List<Map> gainContactTelephone() {
		return JsonUtils.readJsonToObjectList(Map.class, this.contactTelephone);
	}

	public String getPcid() {
		return this.pcid;
	}

	public void setPcid(String pcid) {
		this.pcid = pcid;
	}

	public String getEnglishaddress() {
		return this.englishaddress;
	}

	public void setEnglishaddress(String englishaddress) {
		this.englishaddress = englishaddress;
	}

	public String getManageCompany() {
		return this.manageCompany;
	}

	public void setManageCompany(String manageCompany) {
		this.manageCompany = manageCompany;
	}
}