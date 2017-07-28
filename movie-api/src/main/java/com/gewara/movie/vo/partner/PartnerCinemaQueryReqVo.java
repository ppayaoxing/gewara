/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.partner;

import com.gewara.movie.vo.partner.PartnerPageReqVo;
import java.util.Date;

public class PartnerCinemaQueryReqVo extends PartnerPageReqVo {
	private static final long serialVersionUID = 6903767757594858880L;
	private String quyuType;
	private String serviceType;
	private Long movieId;
	private Long discountId;
	private String countycode;
	private String orderField;
	private Long subwayId;
	private String indexareacode;
	private Date playDate;
	private Double pointx;
	private Double pointy;
	private Long memberid;

	public String getQuyuType() {
		return this.quyuType;
	}

	public void setQuyuType(String quyuType) {
		this.quyuType = quyuType;
	}

	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Long getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public String getCountycode() {
		return this.countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public String getOrderField() {
		return this.orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public Long getSubwayId() {
		return this.subwayId;
	}

	public void setSubwayId(Long subwayId) {
		this.subwayId = subwayId;
	}

	public String getIndexareacode() {
		return this.indexareacode;
	}

	public void setIndexareacode(String indexareacode) {
		this.indexareacode = indexareacode;
	}

	public Date getPlayDate() {
		return this.playDate;
	}

	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}

	public Double getPointx() {
		return this.pointx;
	}

	public void setPointx(Double pointx) {
		this.pointx = pointx;
	}

	public Double getPointy() {
		return this.pointy;
	}

	public void setPointy(Double pointy) {
		this.pointy = pointy;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
}