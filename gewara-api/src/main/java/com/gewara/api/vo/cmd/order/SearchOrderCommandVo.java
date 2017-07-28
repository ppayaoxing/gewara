/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.cmd.order;

import com.gewara.util.DateUtil;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class SearchOrderCommandVo {
	private String ordertype;
	private String pricategory;
	private String category;
	private String placetype;
	private Long placeid;
	private String itemtype;
	private String mptype;
	private Long cid;
	private Long movieid;
	private Long orderid;
	private Long mpid;
	private Long memberid;
	private Integer minute;
	private String mobile;
	private String tradeNo;
	private String status = "paid";
	private Timestamp timeFrom;
	private Timestamp timeTo;
	private Long goodsid;
	private Long dramaid;
	private Long theatrid;
	private String sno;
	private String takemethod;
	private String card;
	private String citycode;
	private String expressid;
	private Long areaid;
	private Long mctid;

	public String getCard() {
		return this.card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getTakemethod() {
		return this.takemethod;
	}

	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}

	public String getSno() {
		return this.sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public Long getTheatrid() {
		return this.theatrid;
	}

	public void setTheatrid(Long theatrid) {
		this.theatrid = theatrid;
	}

	public Long getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public Timestamp getTimeFrom() {
		return this.timeFrom;
	}

	public void setTimeFrom(Timestamp timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Timestamp getTimeTo() {
		return this.timeTo;
	}

	public void setTimeTo(Timestamp timeTo) {
		this.timeTo = timeTo;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
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

	public Long getMpid() {
		return this.mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

	public Long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Integer getMinute() {
		return this.minute;
	}

	public void setMinute(Integer minute) {
		if (minute != null && minute.intValue() > 14400) {
			this.minute = Integer.valueOf(14400);
		} else {
			this.minute = minute;
		}

	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public boolean isBlankCond() {
		return (this.minute == null
				|| this.minute.intValue() > 1440 && !StringUtils.startsWith(this.ordertype, "paid_failure"))
				&& (this.timeFrom == null || this.timeTo == null
						|| ((Timestamp) DateUtil.addDay(this.timeFrom, 30)).before(this.timeTo))
				&& this.mpid == null && this.orderid == null && StringUtils.length(this.tradeNo) != 16
				&& StringUtils.length(this.mobile) != 11;
	}

	public boolean hasBlankCond() {
		return this.isBlankCond() && this.placeid == null;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getPricategory() {
		return this.pricategory;
	}

	public void setPricategory(String pricategory) {
		this.pricategory = pricategory;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getPlacetype() {
		return this.placetype;
	}

	public void setPlacetype(String placetype) {
		this.placetype = placetype;
	}

	public String getItemtype() {
		return this.itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getMptype() {
		return this.mptype;
	}

	public void setMptype(String mptype) {
		this.mptype = mptype;
	}

	public Long getPlaceid() {
		return this.placeid;
	}

	public void setPlaceid(Long placeid) {
		this.placeid = placeid;
	}

	public String getExpressid() {
		return this.expressid;
	}

	public void setExpressid(String expressid) {
		this.expressid = expressid;
	}

	public Long getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}

	public Long getMctid() {
		return this.mctid;
	}

	public void setMctid(Long mctid) {
		this.mctid = mctid;
	}
}