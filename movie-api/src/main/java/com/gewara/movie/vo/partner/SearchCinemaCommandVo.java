/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.partner;

import java.io.Serializable;

public class SearchCinemaCommandVo implements Serializable {
	private static final long serialVersionUID = 7490043716132851414L;
	public String countycode;
	public String indexareacode;
	public String order;
	public Long lineId;
	public Long cinemaid;
	private String cinemaname;
	private String park;
	private String playground;
	private String visacard;
	private String pairseat;
	private String coupon;
	private String booking;
	public Long stationid;
	public String popcorn;
	public int pageNo = 0;
	public int rowsPerpage = 10;
	private String imax;
	private String child;
	private String cinemaids;
	private String acthas;
	private String refund;
	private String characteristic;
	private String hotcinema;
	private String ctype;
	private String lineall;
	private String buyInsure;
	private String showGawara;

	public String getImax() {
		return this.imax;
	}

	public void setImax(String imax) {
		this.imax = imax;
	}

	public String getCountycode() {
		return this.countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public String getIndexareacode() {
		return this.indexareacode;
	}

	public void setIndexareacode(String indexareacode) {
		this.indexareacode = indexareacode;
	}

	public Long getCinemaid() {
		return this.cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public int getPageNo() {
		return this.pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getRowsPerpage() {
		return this.rowsPerpage;
	}

	public void setRowsPerpage(int rowsPerpage) {
		this.rowsPerpage = rowsPerpage;
	}

	public String getOrder() {
		return this.order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getCinemaname() {
		return this.cinemaname;
	}

	public void setCinemaname(String cinemaname) {
		if (cinemaname != null && cinemaname.contains(" ‰»Î")) {
			this.cinemaname = null;
		} else {
			this.cinemaname = cinemaname;
		}

	}

	public Long getLineId() {
		return this.lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public String getPark() {
		return this.park;
	}

	public void setPark(String park) {
		this.park = park;
	}

	public String getPlayground() {
		return this.playground;
	}

	public void setPlayground(String playground) {
		this.playground = playground;
	}

	public String getVisacard() {
		return this.visacard;
	}

	public void setVisacard(String visacard) {
		this.visacard = visacard;
	}

	public String getPairseat() {
		return this.pairseat;
	}

	public void setPairseat(String pairseat) {
		this.pairseat = pairseat;
	}

	public String getCoupon() {
		return this.coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public Long getStationid() {
		return this.stationid;
	}

	public void setStationid(Long stationid) {
		this.stationid = stationid;
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

	public String getChild() {
		return this.child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	public String getCinemaids() {
		return this.cinemaids;
	}

	public void setCinemaids(String cinemaids) {
		this.cinemaids = cinemaids;
	}

	public String getActhas() {
		return this.acthas;
	}

	public void setActhas(String acthas) {
		this.acthas = acthas;
	}

	public String getRefund() {
		return this.refund;
	}

	public void setRefund(String refund) {
		this.refund = refund;
	}

	public String getCharacteristic() {
		return this.characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	public String getHotcinema() {
		return this.hotcinema;
	}

	public void setHotcinema(String hotcinema) {
		this.hotcinema = hotcinema;
	}

	public String getCtype() {
		return this.ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getLineall() {
		return this.lineall;
	}

	public void setLineall(String lineall) {
		this.lineall = lineall;
	}

	public String getBuyInsure() {
		return this.buyInsure;
	}

	public void setBuyInsure(String buyInsure) {
		this.buyInsure = buyInsure;
	}

	public String getShowGawara() {
		return this.showGawara;
	}

	public void setShowGawara(String showGawara) {
		this.showGawara = showGawara;
	}
}