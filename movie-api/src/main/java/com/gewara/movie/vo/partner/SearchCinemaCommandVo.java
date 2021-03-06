package com.gewara.movie.vo.partner;

import java.io.Serializable;

public class SearchCinemaCommandVo implements Serializable  {
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
	private String pairseat;		//锟斤拷锟斤拷锟斤拷
	private String coupon;			//锟脚伙拷券
	private String booking;
	public Long stationid;
	public String popcorn;			//锟斤拷锟阶伙拷
	public int pageNo=0;
	public int rowsPerpage=10;
	private String imax;
	private String child;
	private String cinemaids;		//锟揭筹拷去IDs
	private String acthas;			//锟角凤拷锟叫活动
	private String refund;			//锟角凤拷锟斤拷锟狡�
	private String characteristic;//锟斤拷效锟斤拷
	private String hotcinema;		//锟斤拷锟斤拷影院
	private String ctype;			//锟斤拷效锟斤拷锟斤拷锟斤拷
	private String lineall;			//锟斤拷锟叫碉拷锟斤拷锟斤拷路
	private String buyInsure;  //锟角凤拷支锟街癸拷票锟斤拷票取锟斤拷锟斤拷
	private String showGawara; //锟角凤拷锟斤拷锟斤拷锟斤拷锟绞撅拷锟結锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷示锟斤拷N锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷示锟斤拷
	
	public String getImax() {
		return imax;
	}
	public void setImax(String imax) {
		this.imax = imax;
	}
	public String getCountycode() {
		return countycode;
	}
	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}
	public String getIndexareacode() {
		return indexareacode;
	}
	public void setIndexareacode(String indexareacode) {
		this.indexareacode = indexareacode;
	}
	public Long getCinemaid() {
		return cinemaid;
	}
	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getRowsPerpage() {
		return rowsPerpage;
	}
	public void setRowsPerpage(int rowsPerpage) {
		this.rowsPerpage = rowsPerpage;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getCinemaname() {
		return cinemaname;
	}
	public void setCinemaname(String cinemaname) {
		if(cinemaname!=null && cinemaname.contains("锟斤拷锟斤拷")) {
            this.cinemaname = null;
        } else {
            this.cinemaname = cinemaname;
        }
	}
	public Long getLineId() {
		return lineId;
	}
	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}
	public String getPark() {
		return park;
	}
	public void setPark(String park) {
		this.park = park;
	}
	public String getPlayground() {
		return playground;
	}
	public void setPlayground(String playground) {
		this.playground = playground;
	}
	public String getVisacard() {
		return visacard;
	}
	public void setVisacard(String visacard) {
		this.visacard = visacard;
	}
	public String getPairseat() {
		return pairseat;
	}
	public void setPairseat(String pairseat) {
		this.pairseat = pairseat;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public Long getStationid() {
		return stationid;
	}
	public void setStationid(Long stationid) {
		this.stationid = stationid;
	}
	public String getBooking() {
		return booking;
	}
	public void setBooking(String booking) {
		this.booking = booking;
	}
	public String getPopcorn() {
		return popcorn;
	}
	public void setPopcorn(String popcorn) {
		this.popcorn = popcorn;
	}
	public String getChild() {
		return child;
	}
	public void setChild(String child) {
		this.child = child;
	}
	public String getCinemaids() {
		return cinemaids;
	}
	public void setCinemaids(String cinemaids) {
		this.cinemaids = cinemaids;
	}
	public String getActhas() {
		return acthas;
	}
	public void setActhas(String acthas) {
		this.acthas = acthas;
	}
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	public String getCharacteristic() {
		return characteristic;
	}
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
	public String getHotcinema() {
		return hotcinema;
	}
	public void setHotcinema(String hotcinema) {
		this.hotcinema = hotcinema;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getLineall() {
		return lineall;
	}
	public void setLineall(String lineall) {
		this.lineall = lineall;
	}
	public String getBuyInsure() {
		return buyInsure;
	}
	public void setBuyInsure(String buyInsure) {
		this.buyInsure = buyInsure;
	}
	public String getShowGawara() {
		return showGawara;
	}
	public void setShowGawara(String showGawara) {
		this.showGawara = showGawara;
	}

}
